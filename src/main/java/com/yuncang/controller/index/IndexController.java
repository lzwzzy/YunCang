package com.yuncang.controller.index;

import com.yuncang.entity.GoodsBill;
import com.yuncang.service.GoodsService;
import com.yuncang.service.ImportService;
import com.yuncang.service.SaleService;
import com.yuncang.util.GetTodayTimeStamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

/**
 * Created by lzw on 2017/5/8.
 * 主页
 */
@Controller
@RequestMapping(value = "yuncang")
public class IndexController {

    @Autowired
    private SaleService saleService;
    @Autowired
    private ImportService importService;
    @Autowired
    private GoodsService goodsService;

    @RequestMapping(value = "/index")
    public String index(Model model) {


        //获取当天时间戳
        long timesmorning = GetTodayTimeStamp.getTimesmorning();
        long timesnight = GetTodayTimeStamp.getTimesnight();

        try {
            //获取当天采购信息数据
            Map<String, Object> todayImportInfo = importService.queryAllImportInfo(timesmorning, timesnight);
            int todayimportTotalCount = (Integer) todayImportInfo.get("todayimportTotalCount");
            int todayimportTotalPrice = (Integer) todayImportInfo.get("todayimportTotalPrice");

            //获取当天销售信息数据
            Map<String, Object> todaySaleInfo = saleService.queryTodaySaleInfo(timesmorning, timesnight);
            Integer todaySaleTotalCount = (Integer) todaySaleInfo.get("todaySaleTotalCount");
            Integer todaySaleTotalPrice = (Integer) todaySaleInfo.get("todaySaleTotalPrice");

            //查询所有商品信息
            List<GoodsBill> goodsBills = goodsService.queryAllGoodsWithProffer();

            model.addAttribute("todayimportTotalCount", todayimportTotalCount);
            model.addAttribute("todayimportTotalPrice", todayimportTotalPrice);

            model.addAttribute("todaySaleTotalCount", todaySaleTotalCount);
            model.addAttribute("todaySaleTotalPrice", todaySaleTotalPrice);

            model.addAttribute("goodsBills", goodsBills);
        } catch (Exception e) {
            e.printStackTrace();
        }


        return "index";
    }


}
