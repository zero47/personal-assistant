package com.neo.personalassistant.web.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.Collections;
import java.util.Map;

/**
 * @author neo
 */
@Data
@AllArgsConstructor
@Builder
public class WebApiResponse<T> implements Serializable {

    private static final Map<String, Object> EMPTY_MAP = Collections.emptyMap();

    private static final long serialVersionUID = 1L;

    /**
     * 错误码请参考WebappRetCode
     */
    private int code = 1;
    private String message = "";
    private T data;

    public WebApiResponse() {
        this.data = (T) EMPTY_MAP;
    }

    public WebApiResponse(Map<String, Object> data) {
        this.data = (T) data;
    }

    public WebApiResponse(T data) {
        this.data = data;
    }
}
