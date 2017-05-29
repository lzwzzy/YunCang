package com.yuncang.controller.user;

import com.yuncang.dto.Result;
import com.yuncang.entity.UserEntity;
import com.yuncang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by lzw on 2017/5/28.
 * 用户资料
 */
@Controller
@RequestMapping(value = "yuncang")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 查询用户个人信息
     *
     * @param username 用户名
     * @return 用户个人信息
     */
    @ResponseBody
    @RequestMapping(value = "/queryPersonInfo", method = RequestMethod.POST)
    public Result<UserEntity> queryPersonInfo(@RequestParam String username) {
        try {
            UserEntity userEntity = userService.queryPersonInfoByUserName(username);
            if (userEntity != null) {
                return new Result<UserEntity>(true, userEntity);
            } else {
                return new Result<UserEntity>(false, "数据不存在");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new Result<UserEntity>(false, "数据异常");
        }
    }

    /**
     * 修改用户信息
     *
     * @param userid    用户id
     * @param username  用户名
     * @param userphone 手机号
     * @param useremail 邮箱
     * @param sex       性别
     * @return 是否修改成功
     */
    @ResponseBody
    @RequestMapping(value = "/editPersonInfo", method = RequestMethod.POST)
    public Result editPersonInfo(@RequestParam(required = false) String userid,
                                 @RequestParam(required = false) String username,
                                 @RequestParam(required = false) String userphone,
                                 @RequestParam(required = false, defaultValue = "") String useremail,
                                 @RequestParam(required = false, defaultValue = "") String sex) {
        try {
            boolean isSuccess = userService.editPersonInfo(Integer.parseInt(userid), username, userphone, useremail, sex);
            if (isSuccess) {
                return new Result(true);
            } else {
                return new Result(false, "用户名已存在");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "数据异常");
        }

    }

    /**
     * 修改密码
     *
     * @param username    用户名
     * @param newPassword 密码
     * @return 是否修改成功
     */
    @ResponseBody
    @RequestMapping(value = "/editPassword", method = RequestMethod.POST)
    public Result editPassword(@RequestParam(required = false) String username,
                               @RequestParam(required = false) String newPassword) {
        try {
            boolean isSuccess = userService.editPassword(username, newPassword);
            if (isSuccess) {
                return new Result(true);
            } else {
                return new Result(false, "修改失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "数据异常");
        }
    }

    /**
     * 注销账户
     *
     * @param session 当前会话
     * @return 是否注销成功
     */
    @ResponseBody
    @RequestMapping(value = "/logOut")
    public Result logOut(HttpSession session, HttpServletRequest request, HttpServletResponse response) {
        //删除会话
        session.removeAttribute("user");
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie :
                cookies) {
            if (cookie.getName().equals("username")) {
                //删除cookie
                cookie.setMaxAge(0);
                response.addCookie(cookie);
            }
        }
        if (session.getAttribute("user") == null) {
            return new Result(true);
        } else {
            return new Result(false, "error");
        }

    }
}
