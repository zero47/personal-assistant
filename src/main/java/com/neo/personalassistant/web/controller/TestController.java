package com.neo.personalassistant.web.controller;

import com.neo.personalassistant.web.common.WebApiResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : neo
 * @date : 2023/4/27
 */
@RestController
@RequestMapping("test")
public class TestController {

    @PostMapping("ping")
    public WebApiResponse<String> ping() {
        return new WebApiResponse<>("pong");
    }

}
