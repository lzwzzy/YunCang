package com.yuncang.controller.maney;

import com.yuncang.dto.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

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

    @ResponseBody
    @RequestMapping(value = "/isLogin", method = RequestMethod.POST)
    public Result isSuccess(HttpServletRequest request) {
        Map<String, String[]> parameterMap = request.getParameterMap();
        return new Result(true);
    }
}
