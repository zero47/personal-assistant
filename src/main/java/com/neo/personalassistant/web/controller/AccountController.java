package com.neo.personalassistant.web.controller;

import com.neo.personalassistant.bo.PageResult;
import com.neo.personalassistant.domain.Memo;
import com.neo.personalassistant.service.AccountService;
import com.neo.personalassistant.web.common.WebApiResponse;
import com.neo.personalassistant.web.request.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : neo
 * @date : 2023/4/27
 */
@RestController
@RequestMapping("account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping("register")
    public WebApiResponse<Boolean> register(@RequestBody AccountLoginReq req) {
        boolean result = accountService.register(req.getNickname(), req.getEncryptPassword());
        return new WebApiResponse<>(result);
    }

    @PostMapping("login")
    public WebApiResponse<String> login(@RequestBody AccountLoginReq req) {
        String token = accountService.login(req.getNickname(), req.getEncryptPassword());
        return new WebApiResponse<>(token);
    }

}
