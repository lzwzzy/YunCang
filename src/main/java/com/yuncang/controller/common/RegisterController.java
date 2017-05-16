package com.yuncang.controller.common;

import com.yuncang.dto.Result;
import com.yuncang.entity.UserEntity;
import com.yuncang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lzw on 2017/4/22.
 * 用户注册
 */
@Controller
@RequestMapping(value = "yuncang")
public class RegisterController {

    @Autowired
    private UserService service;


    @RequestMapping(value = "/register")
    public String register() {
        return "login/register";
    }


    /**
     * 用户注册
     *
     * @param user
     * @return
     */
    @RequestMapping(value = "/doregister", method = RequestMethod.POST)
    @ResponseBody
    public Result<Boolean> doRegister(UserEntity user) {
        int state = service.insertUser(user);
        if (user == null) {
            return new Result<Boolean>(false);
        } else {
            //如果返回为1，证明插入成功
            if (state == 1) {
                return new Result<Boolean>(true);
            } else {
                return new Result<Boolean>(false);
            }
        }
    }

    /**
     * 判断用户手机号和用户名是否存在
     *
     * @param userEntity
     * @return
     */
    @RequestMapping(value = "/isExit", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> isExist(UserEntity userEntity) {
        Map<String, Object> param = new HashMap<String, Object>();
        boolean isExist = service.isExist(userEntity);
        if (isExist) {
            param.put("valid", false);
        } else {
            param.put("valid", true);

        }
        return param;
    }
}
