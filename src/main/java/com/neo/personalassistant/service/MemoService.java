package com.neo.personalassistant.service;

import com.neo.personalassistant.bo.PageResult;
import com.neo.personalassistant.domain.Memo;

/**
 * @author : neo
 * @date : 2023/4/27
 */
public interface MemoService {

    boolean saveMemo(Integer userId, String content);

    boolean updateMemo(Integer userId, Integer memoId, String content);

    boolean removeMemo(Integer userId, Integer memoId);

    PageResult<Memo> pageMemo(Integer userId, Integer cursor, Integer size);
}
