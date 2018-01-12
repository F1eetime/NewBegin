package com.qt.springboot.service;

import com.qt.springboot.mapper.UserInfoMapper;
import com.qt.springboot.pojo.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class MybatisService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    public UserInfo getUser(Integer id) {
        return userInfoMapper.getUser(id);
    }

    public void updateUser(String user_id, String nickName) {
        userInfoMapper.updateUser(user_id, nickName);
    }
    public void createUser(Map<String,Object> map) {
        userInfoMapper.createUser(map);
    }


    public void deleteUserById(UserInfo userInfo) {
        userInfoMapper.deleteUserByUserId(userInfo);
    }

}
