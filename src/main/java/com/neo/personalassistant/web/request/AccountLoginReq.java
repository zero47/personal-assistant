package com.neo.personalassistant.web.request;

import lombok.Data;

/**
 * @author : neo
 * @date : 2023/4/28
 */
@Data
public class AccountLoginReq {

    private String nickname;
    private String encryptPassword;

}
