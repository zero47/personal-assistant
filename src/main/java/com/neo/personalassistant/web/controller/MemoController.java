package com.neo.personalassistant.web.controller;

import com.neo.personalassistant.bo.PageResult;
import com.neo.personalassistant.domain.Memo;
import com.neo.personalassistant.service.MemoService;
import com.neo.personalassistant.web.common.WebApiResponse;
import com.neo.personalassistant.web.request.PageMemoReq;
import com.neo.personalassistant.web.request.RemoveMemoReq;
import com.neo.personalassistant.web.request.SaveMemoReq;
import com.neo.personalassistant.web.request.UpdateMemoReq;
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
public class MemoController {

    @Autowired
    private MemoService memoService;

    @PostMapping("saveMemo")
    public WebApiResponse<Boolean> saveMemo(@RequestBody SaveMemoReq req) {
        boolean result = memoService.saveMemo(req.getUserId(), req.getContent());
        return new WebApiResponse<>(result);
    }

    @PostMapping("updateMemo")
    public WebApiResponse<Boolean> updateMemo(@RequestBody UpdateMemoReq req) {
        boolean result = memoService.updateMemo(req.getUserId(), req.getMemoId(), req.getContent());
        return new WebApiResponse<>(result);
    }

    @PostMapping("removeMemo")
    public WebApiResponse<Boolean> removeMemo(@RequestBody RemoveMemoReq req) {
        boolean result = memoService.removeMemo(req.getUserId(), req.getMemoId());
        return new WebApiResponse<>(result);
    }

    @PostMapping("pageMemo")
    public WebApiResponse<PageResult<Memo>> pageMemo(@RequestBody PageMemoReq req) {
        PageResult<Memo> memos = memoService.pageMemo(req.getUserId(), req.getCursor(), req.getSize());
        return new WebApiResponse<>(memos);
    }

}
