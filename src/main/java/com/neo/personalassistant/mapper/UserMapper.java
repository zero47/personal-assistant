package com.neo.personalassistant.mapper;

import com.neo.personalassistant.domain.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    int deleteByPrimaryKey(Integer userId);

    boolean insert(User record);

    User selectByPrimaryKey(Integer userId);

    boolean existNickname(String nickname);

    User selectByNicknameAndPassword(String nickname, String encryptPassword);

    boolean updateToken(Integer userId, String token);

    Integer selectUserIdByToken(String token);
}