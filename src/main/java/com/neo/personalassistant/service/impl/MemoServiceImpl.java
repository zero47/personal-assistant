package com.neo.personalassistant.service.impl;

import com.neo.personalassistant.bo.PageResult;
import com.neo.personalassistant.domain.Memo;
import com.neo.personalassistant.mapper.MemoMapper;
import com.neo.personalassistant.service.MemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : neo
 * @date : 2023/4/27
 */
@Service
public class MemoServiceImpl implements MemoService {

    @Autowired
    private MemoMapper memoMapper;

    @Override
    public boolean saveMemo(Integer userId, String content) {
        Memo memo = new Memo();
        memo.setUserId(userId);
        memo.setContent(content);
        return memoMapper.insert(memo);
    }

    @Override
    public boolean updateMemo(Integer userId, Integer memoId, String content) {
        return memoMapper.updateMemo(memoId, userId, content);
    }

    @Override
    public boolean removeMemo(Integer userId, Integer memoId) {
        return memoMapper.removeMemo(userId, memoId);
    }

    @Override
    public PageResult<Memo> pageMemo(Integer userId, Integer cursor, Integer size) {
        PageResult<Memo> pageResult = new PageResult<>();
        List<Memo> memos = memoMapper.pageMemo(userId, cursor, size + 1);
        pageResult.setDataLiist(memos);
        if (memos.size() > size) {
            pageResult.setCursor(memos.get(size).getMemoId());
        }
        return pageResult;
    }
}
