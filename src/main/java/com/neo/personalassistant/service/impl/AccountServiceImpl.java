package com.neo.personalassistant.service.impl;

import com.neo.personalassistant.domain.User;
import com.neo.personalassistant.mapper.UserMapper;
import com.neo.personalassistant.service.AccountService;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author : neo
 * @date : 2023/4/27
 */
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean register(String nickname, String encryptPassword) {
        boolean result = userMapper.existNickname(nickname);
        if (result) {
            return false;
        }
        User user = new User();
        user.setNickname(nickname);
        user.setEncryptPassword(encryptPassword);
        return userMapper.insert(user);
    }

    @Override
    public String login(String nickname, String encryptPassword) {
        User user = userMapper.selectByNicknameAndPassword(nickname, encryptPassword);
        String token = null;
        if (user != null) {
            token = RandomStringUtils.randomAlphanumeric(64);
            userMapper.updateToken(user.getUserId(), token);
        }
        return token;
    }
}
