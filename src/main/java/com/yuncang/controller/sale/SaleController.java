package com.yuncang.controller.sale;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by lzw on 2017/5/16.
 */
@Controller
@RequestMapping(value = "yuncang")
public class SaleController {
    @RequestMapping(value = "/sale")
    public String buy() {
        return "sale";
    }
}
