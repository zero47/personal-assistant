package com.neo.personalassistant.bo;

import lombok.Data;

import java.util.List;

/**
 * @author : neo
 * @date : 2023/4/27
 */
@Data
public class  PageResult<T> {

    private List<T> dataLiist;
    /**
     * 下一页的第一个id，没有则代表没有下一页
     */
    private Integer cursor;

}
