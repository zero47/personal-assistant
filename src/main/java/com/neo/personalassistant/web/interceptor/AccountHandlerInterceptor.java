package com.neo.personalassistant.web.interceptor;

import com.neo.personalassistant.mapper.UserMapper;
import com.neo.personalassistant.web.common.WebappRetCode;
import com.neo.personalassistant.web.common.WebappServiceException;
import com.neo.personalassistant.web.security.Authentication;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Objects;

/**
 * @author : neo
 * @date : 2023/4/28
 */
public class AccountHandlerInterceptor implements HandlerInterceptor {

    private UserMapper userMapper;

    public AccountHandlerInterceptor(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            boolean requireToken = handlerMethod.hasMethodAnnotation(Authentication.class);
            String token = request.getParameter("token");
            if (StringUtils.isEmpty(token)) {
                if (requireToken) {
                    throw new WebappServiceException(WebappRetCode.FORBIDDEN, "");
                }
            } else {
                Integer userId = userMapper.selectUserIdByToken(token);
                if (requireToken && Objects.isNull(userId)) {
                    throw new WebappServiceException(WebappRetCode.FORBIDDEN, "");
                }
                request.setAttribute("userId", userId);
            }
        }
        return true;
    }
}
