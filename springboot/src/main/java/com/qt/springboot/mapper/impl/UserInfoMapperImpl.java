package com.qt.springboot.mapper.impl;

import com.qt.springboot.mapper.UserInfoMapper;
import com.qt.springboot.pojo.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;


@Repository
public class UserInfoMapperImpl implements UserInfoMapper {

    @Override
    public void createUser(Map<String, Object> reqMap) {

    }

    @Override
    public UserInfo getUser(Integer id) {
        return null;
    }

    @Override
    public void updateUser(String user_id, String nickName) {

    }

    @Override
    public void deleteUserByUserId(UserInfo userInfo) {

    }
}
