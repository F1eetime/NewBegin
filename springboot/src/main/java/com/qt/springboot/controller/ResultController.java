package com.qt.springboot.controller;

import com.qt.springboot.pojo.UserInfo;
import com.qt.springboot.util.ExceptionEnum;
import com.qt.springboot.util.ExceptionHandle;
import com.qt.springboot.util.Result;
import com.qt.springboot.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/result")
public class ResultController {

    @Autowired
    private ExceptionHandle exceptionHandle;

    /**
     * 返回体测试
     * @param name
     * @param pwd
     * @return
     */
    @RequestMapping(value = "/getResult",method = RequestMethod.POST)
    public Result getResult(@RequestParam("name") String name, @RequestParam("pwd") String pwd){
        Result result = ResultUtil.success();
        try {
            if (name.equals("qt")){
                result =  ResultUtil.success(new UserInfo());
            }else if (name.equals("tq")){
                result =  ResultUtil.error(ExceptionEnum.USER_NOT_FOUND);
            }else{
                int i = 1/0;
            }
        }catch (Exception e){
            result =  exceptionHandle.exceptionGet(e);
        }
        return result;
    }
}
