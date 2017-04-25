package com.yuncang.controller.common;

import com.yuncang.dto.Result;
import com.yuncang.entity.UserEntity;
import com.yuncang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by lzw on 2017/4/22.
 * 基本界面跳转
 */
@Controller
@RequestMapping(value = "yuncang")
public class CommonController {

    @Autowired
    private UserService service;

    @RequestMapping(value = "/login")
    public String login(){
        return "login/login";
    }


    /**
     * 登陆验证
     * @param username
     * @param password
     * @return
     */
    @RequestMapping(value = "/dologin",method = RequestMethod.POST)
    @ResponseBody
    public Result<Boolean> dologin(String username,String password){

        boolean islogin = service.loginCheck(username,password);
        if (islogin){
            return new Result<Boolean>(true);
        }
        return new Result<Boolean>(false,"用户名或密码错误");
    }


    @RequestMapping(value = "/index")
    public String index(){
        return "index";
    }


    @RequestMapping(value = "/register")
    public String register(){
        return "login/register";
    }


    /**
     * 用户注册
     * @param request
     * @return
     */
    @RequestMapping(value = "/doregister",method = RequestMethod.POST)
    public String doRegister(HttpServletRequest request){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        long phone = Long.valueOf(request.getParameter("phone"));
        UserEntity user = new UserEntity();
        user.setUsername(username);
        user.setPassword(password);
        user.setPhone(phone);
        int state = service.insertUser(user);
        if (state==1){
            return "redirect:/yuncang/login";
        }
        return "/login/register";
    }
    @RequestMapping(value = "/isExit" ,method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> isExist(UserEntity userEntity){
        Map<String,Object> param = new HashMap<String,Object>();
        boolean isExist = service.isExist(userEntity);
        if (isExist){
            param.put("valid",false);
        }else {
            param.put("valid",true);

        }
        return param;
    }
}
