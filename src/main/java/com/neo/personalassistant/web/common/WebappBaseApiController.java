package com.neo.personalassistant.web.common;

import jakarta.servlet.http.HttpServletRequest;

public abstract class WebappBaseApiController {
    protected String getUserId(HttpServletRequest request) {
        return (String) request.getAttribute("userId");
    }
}
