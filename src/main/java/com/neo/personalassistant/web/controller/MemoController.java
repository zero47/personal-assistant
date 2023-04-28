package com.neo.personalassistant.web.controller;

import com.neo.personalassistant.bo.PageResult;
import com.neo.personalassistant.domain.Memo;
import com.neo.personalassistant.service.MemoService;
import com.neo.personalassistant.web.common.WebApiResponse;
import com.neo.personalassistant.web.common.WebappBaseApiController;
import com.neo.personalassistant.web.request.PageMemoReq;
import com.neo.personalassistant.web.request.RemoveMemoReq;
import com.neo.personalassistant.web.request.SaveMemoReq;
import com.neo.personalassistant.web.request.UpdateMemoReq;
import com.neo.personalassistant.web.security.Authentication;
import jakarta.servlet.http.HttpServletRequest;
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
@RequestMapping("memo")
public class MemoController extends WebappBaseApiController {

    @Autowired
    private MemoService memoService;

    @Authentication
    @PostMapping("saveMemo")
    public WebApiResponse<Boolean> saveMemo(HttpServletRequest request, @RequestBody SaveMemoReq req) {
        boolean result = memoService.saveMemo(getUserId(request), req.getContent());
        return new WebApiResponse<>(result);
    }

    @Authentication
    @PostMapping("updateMemo")
    public WebApiResponse<Boolean> updateMemo(HttpServletRequest request, @RequestBody UpdateMemoReq req) {
        boolean result = memoService.updateMemo(getUserId(request), req.getMemoId(), req.getContent());
        return new WebApiResponse<>(result);
    }

    @Authentication
    @PostMapping("removeMemo")
    public WebApiResponse<Boolean> removeMemo(HttpServletRequest request, @RequestBody RemoveMemoReq req) {
        boolean result = memoService.removeMemo(getUserId(request), req.getMemoId());
        return new WebApiResponse<>(result);
    }

    @Authentication
    @PostMapping("pageMemo")
    public WebApiResponse<PageResult<Memo>> pageMemo(HttpServletRequest request, @RequestBody PageMemoReq req) {
        PageResult<Memo> memos = memoService.pageMemo(getUserId(request), req.getCursor(), req.getSize());
        return new WebApiResponse<>(memos);
    }

}
