package com.neo.personalassistant.web.common;


import lombok.Getter;

/**
 * @author neo
 */
@Getter
public class WebappServiceException extends RuntimeException {

    private static final long serialVersionUID = 1L;


    private WebappRetCode code;

    public WebappServiceException(WebappRetCode code) {
        super();
        this.code = code;
    }

    public WebappServiceException(WebappRetCode code, String message) {
        super(message);
        this.code = code;
    }

    public WebappServiceException(WebappRetCode code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }
}
