package com.yuncang.controller.user;

import com.yuncang.dto.Result;
import com.yuncang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by lzw on 2017/5/8.
 * 用户登陆
 */
@Controller
@RequestMapping(value = "yuncang")
public class LoginController {

    @Autowired
    private UserService service;

    @RequestMapping(value = "/login")
    public String login() {
        return "login/login";
    }

    /**
     * 登陆验证
     *
     * @param username
     * @param password
     * @return
     */
    @RequestMapping(value = "/dologin", method = RequestMethod.POST)
    @ResponseBody
    public Result<Boolean> dologin(String username, String password) {

        boolean islogin = service.loginCheck(username, password);
        if (islogin) {
            return new Result<Boolean>(true);
        }
        return new Result<Boolean>(false, "用户名或密码错误");
    }
}
