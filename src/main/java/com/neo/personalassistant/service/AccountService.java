package com.neo.personalassistant.service;

/**
 * @author : neo
 * @date : 2023/4/27
 */
public interface AccountService {

    boolean register(String nickname, String encryptPassword);
    String login(String nickname, String encryptPassword);

}
