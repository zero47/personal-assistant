package com.neo.personalassistant.web.common;

import jakarta.servlet.http.HttpServletRequest;

public abstract class WebappBaseApiController {
    protected Integer getUserId(HttpServletRequest request) {
        return (Integer) request.getAttribute("userId");
    }
}
