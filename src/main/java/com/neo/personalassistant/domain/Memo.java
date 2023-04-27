package com.neo.personalassistant.domain;

import java.util.Date;
import lombok.Data;

@Data
public class Memo {
    private Integer memoId;

    private Integer userId;

    private String content;

    private Date createTime;

    private Date lastUpdateTime;
}