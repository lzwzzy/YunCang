package com.yuncang.controller.proffer;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by lzw on 2017/5/16.
 */
@Controller
@RequestMapping(value = "yuncang")
public class ProfferController {
    @RequestMapping(value = "/proffer")
    public String buy() {
        return "proffer";
    }
}
