package com.neo.personalassistant.mapper;

import com.neo.personalassistant.domain.Memo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemoMapper {
    boolean removeMemo(Integer userId, Integer memoId);

    boolean insert(Memo record);

    Memo selectByPrimaryKey(Integer memoId);

    List<Memo> pageMemo(Integer userId, Integer offset, int limit);

    boolean updateMemo(Integer memoId, Integer userId, String content);

}