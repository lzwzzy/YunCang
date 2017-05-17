package com.yuncang.controller.imported;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by lzw on 2017/5/16.
 */
@Controller
@RequestMapping(value = "yuncang")
public class ImportController {
    @RequestMapping(value = "/import")
    public String buy() {
        return "import";
    }
}
