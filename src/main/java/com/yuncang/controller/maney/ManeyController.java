package com.yuncang.controller.maney;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by lzw on 2017/5/16.
 */
@Controller
@RequestMapping(value = "yuncang")
public class ManeyController {
    @RequestMapping(value = "/maney")
    public String buy() {
        return "maney";
    }
}
