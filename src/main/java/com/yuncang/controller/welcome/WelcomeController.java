package com.yuncang.controller.welcome;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by lzw on 2017/5/29.
 * 欢迎页控制器
 */
@Controller
@RequestMapping(value = "")
public class WelcomeController {


    @RequestMapping(value = "")
    public String home() {
        return "welcome/home";
    }

    @RequestMapping(value = "detail")
    public String detail() {
        return "welcome/detail";
    }

    @RequestMapping(value = "contact")
    public String contact() {
        return "welcome/contact";
    }
}
