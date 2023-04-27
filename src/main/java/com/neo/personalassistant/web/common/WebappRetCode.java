package com.neo.personalassistant.web.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum WebappRetCode {

    BAD_REQUEST(-400),METHOD_NOT_ALLOWED(-401),SERVER_ERROR(-500);

    private final int code;
}
