package com.yuncang.controller.index;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by lzw on 2017/5/8.
 * 主页
 */
@Controller
@RequestMapping(value = "yuncang")
public class IndexController {
    @RequestMapping(value = "/index")
    public String index() {
        return "index";
    }
}
