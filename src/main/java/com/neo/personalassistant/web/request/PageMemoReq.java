package com.neo.personalassistant.web.request;

import lombok.Data;

/**
 * @author : neo
 * @date : 2023/4/27
 */
@Data
public class PageMemoReq {
    private Integer userId;
    private Integer cursor;
    private Integer size;
}