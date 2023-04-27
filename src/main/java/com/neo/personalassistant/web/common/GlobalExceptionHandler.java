package com.neo.personalassistant.web.common;

import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletRequestWrapper;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.util.ContentCachingRequestWrapper;

import java.nio.charset.Charset;
import java.util.Objects;

/**
 * 关于Spring MVC异常处理的资料：
 * <ul>
 *     <li><a href="https://potoyang.gitbook.io/spring-in-action-v4/di-7-zhang-spring-mvc-de-gao-ji-ji-shu/untitled-3">7.3　处理异常 - Spring 实战(第四版)</a></li>
 *     <li><a href="https://stackoverflow.com/a/19500823/5232255">spring mvc - Setting Precedence of Multiple @ControllerAdvice @ExceptionHandlers - Stack Overflow</a></li>
 *     <li><a href="https://stackoverflow.com/questions/47776457/why-is-spring-exception-handler-not-working-as-expected">Why is Spring exception handler not working as expected - Stack Overflow</a></li>
 * </ul>
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    protected WebApiResponse handleException(Exception ex, HttpServletRequest request) {
        if (ex instanceof HttpRequestMethodNotSupportedException) {
            return WebApiResponse.builder()
                    .code(WebappRetCode.METHOD_NOT_ALLOWED.getCode())
                    .message("http request method not supported")
                    .build();
        } else if (ex instanceof HttpMessageNotReadableException) {
            return WebApiResponse.builder()
                    .code(WebappRetCode.BAD_REQUEST.getCode())
                    .message("bad request")
                    .build();
        } else if (ex instanceof WebappServiceException webappServiceException) {
            log.error(ex.getMessage(), ex);
            return WebApiResponse.builder()
                    .code(((WebappServiceException) ex).getCode().getCode())
                    .message(ex.getMessage())
                    .build();
        } else {
            ContentCachingRequestWrapper underlyingCachingRequest = getUnderlyingCachingRequest(request);
            if (Objects.nonNull(underlyingCachingRequest)) {
                String requestBody = new String(underlyingCachingRequest.getContentAsByteArray(), Charset.defaultCharset());
                log.error("encounter exception, http method: {}, url: {}, request body: {}", request.getMethod(), request.getRequestURI(), requestBody);
            }
            log.error(ex.getMessage(), ex);
            return WebApiResponse.builder()
                    .code(WebappRetCode.SERVER_ERROR.getCode())
                    .message("")
                    .build();
        }
    }

    // https://stackoverflow.com/questions/5182417/reading-httprequest-content-from-spring-exception-handler
    private ContentCachingRequestWrapper getUnderlyingCachingRequest(ServletRequest request) {
        if (ContentCachingRequestWrapper.class.isAssignableFrom(request.getClass())) {
            return (ContentCachingRequestWrapper) request;
        }
        if (request instanceof ServletRequestWrapper) {
            return getUnderlyingCachingRequest(((ServletRequestWrapper) request).getRequest());
        }
        return null;
    }
}
