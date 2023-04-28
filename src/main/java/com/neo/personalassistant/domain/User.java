package com.neo.personalassistant.domain;

import java.util.Date;
import lombok.Data;

@Data
public class User {
    private Integer userId;

    private String nickname;

    private String encryptPassword;

    private Date createTime;

    private String token;
}