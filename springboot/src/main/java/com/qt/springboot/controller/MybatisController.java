package com.qt.springboot.controller;

import com.qt.springboot.pojo.UserInfo;
import com.qt.springboot.service.MybatisService;
import com.qt.springboot.util.ExceptionHandle;
import com.qt.springboot.util.Result;
import com.qt.springboot.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RequestMapping("/mybatis")
@RestController
public class MybatisController {

    @Autowired
    private MybatisService mybatisService;

    @Autowired
    private ExceptionHandle handle;

    /**
     * 添加用户
     */
    @PostMapping("/createUser")
    public Result createUser(@RequestBody Map<String, Object> map) {
        Result result = ResultUtil.success();
        try {
            mybatisService.createUser(map);
        } catch (Exception e) {
            handle.exceptionGet(e);
        }
        return result;
    }

    /**
     * 更新用户信息
     *
     * @param user_id  用户ID
     * @param nickName 昵称
     */
    @PutMapping("/updateUser/{id}")
    public Result updateUser(@PathVariable("id") String user_id, @RequestParam("nickName") String nickName) {
        Result result = ResultUtil.success();
        try {
            mybatisService.updateUser(user_id, nickName);
        } catch (Exception e) {
            result = handle.exceptionGet(e);
        }
        return result;
    }

    /**
     * 获取用户信息
     *
     * @param id 用户Id
     * @return
     */
    @GetMapping("/getUser/{id}")
    public Result getUser(@PathVariable("id") Integer id) {
        Result result = ResultUtil.success();
        try {
            mybatisService.getUser(id);
        } catch (Exception e) {
            result = handle.exceptionGet(e);
        }
        return result;
    }

    @DeleteMapping("/deleteUserById/{tel}")
    public Result deleteUserById(@PathVariable("tel") String tel) {
        Result result = ResultUtil.success();
        try {
            UserInfo userInfo = new UserInfo();
            userInfo.setTel(tel);
            mybatisService.deleteUserById(userInfo);
        } catch (Exception e) {
            handle.exceptionGet(e);
        }
        return result;
    }
}
