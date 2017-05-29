package com.yuncang.controller.user;

import com.yuncang.dto.Result;
import com.yuncang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
     * @param username 用户名
     * @param password 密码
     * @return
     */
    @RequestMapping(value = "/dologin", method = RequestMethod.POST)
    @ResponseBody
    public Result<Boolean> dologin(HttpSession session, HttpServletRequest request, String username, String password) {

        boolean islogin = false;
        try {
            islogin = service.loginCheck(username, password);
            if (islogin) {
                session = request.getSession();
                session.setAttribute("user", username);
                return new Result<Boolean>(true);
            }
            return new Result<Boolean>(false, "用户名或密码错误");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result<Boolean>(false, "数据异常");
        }

    }
}
