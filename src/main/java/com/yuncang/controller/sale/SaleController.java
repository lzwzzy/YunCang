package com.yuncang.controller.sale;

import com.yuncang.dto.PageForBootstrap;
import com.yuncang.dto.Result;
import com.yuncang.entity.GoodsBill;
import com.yuncang.entity.SaleBill;
import com.yuncang.service.GoodsService;
import com.yuncang.service.SaleService;
import com.yuncang.util.AutoMakeSerialId;
import com.yuncang.util.GetTodayTimeStamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * Created by lzw on 2017/5/16.
 * 销售模块控制层
 */
@Controller
@RequestMapping(value = "yuncang")
public class SaleController {

    @Autowired
    private SaleService saleService;
    @Autowired
    private GoodsService goodsService;

    private String saleId;

    /**
     * 初始化界面
     *
     * @param model 传到界面的数据
     * @return 哪个页面
     */
    @RequestMapping(value = "/sale")
    public String sale(Model model) {
        //查询所有商品信息
        List<GoodsBill> goodsBills = goodsService.queryAllGoodsWithProffer();

        //查找数据库中最大ID值
        String maxSaleId = saleService.maxSaleId();
        saleId = AutoMakeSerialId.MakeId(maxSaleId);

        //获取当天时间戳
        long timesmorning = GetTodayTimeStamp.getTimesmorning();
        long timesnight = GetTodayTimeStamp.getTimesnight();


        try {
            //获取当天信息数据
            Map<String, Object> todayInfo = saleService.queryTodaySaleInfo(timesmorning, timesnight);
            Integer todaySaleTotalCount = (Integer) todayInfo.get("todaySaleTotalCount");
            Integer todaySaleTotalPrice = (Integer) todayInfo.get("todaySaleTotalPrice");

            //获取总数据
            Map<String, Object> allInfo = saleService.queryAllSaleInfo();
            Integer SaleTotalCount = (Integer) allInfo.get("SaleTotalCount");
            Integer SaleTotalPrice = (Integer) allInfo.get("SaleTotalPrice");


            //将查询到的值传到页面
            model.addAttribute("goodsBills", goodsBills);
            model.addAttribute("saleId", saleId);

            model.addAttribute("todaySaleTotalCount", todaySaleTotalCount);
            model.addAttribute("todaySaleTotalPrice", todaySaleTotalPrice);

            model.addAttribute("SaleTotalCount", SaleTotalCount);
            model.addAttribute("SaleTotalPrice", SaleTotalPrice);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "sale";
    }

    /**
     * 查询全部销售信息
     *
     * @param pageNumber 页码
     * @param pageSize   每页数据量
     * @param sortOrder  排序方式
     * @param sortName   排序列
     * @param fromTime   开始时间
     * @param toTime     结束时间
     * @return 全部销售信息(分页)
     */
    @ResponseBody
    @RequestMapping(value = "/selectSaleInfo", method = RequestMethod.POST)
    public PageForBootstrap<List<SaleBill>> queryAllSaleInfo(@RequestParam(required = false, defaultValue = "1") int pageNumber,
                                                             @RequestParam(required = false, defaultValue = "10") int pageSize,
                                                             @RequestParam(required = false) String sortOrder,
                                                             @RequestParam(required = false) String sortName,
                                                             @RequestParam(required = false, defaultValue = "0") long fromTime,//1495425600
                                                             @RequestParam(required = false, defaultValue = "0") long toTime) {
        try {
            //拼接排序字符串
            String sort = sortName + "." + sortOrder;
            //获取数据
            Map<String, Object> map = saleService.queryAllSaleInfo(pageNumber, pageSize, sort, fromTime, toTime);
            List<SaleBill> rows = (List<SaleBill>) map.get("saleBills");
            //获取总数据量
            int total = (Integer) map.get("totalCount");
            if (rows != null && total != 0) {
                //如果拿到数据,封装数据(json)返回前端->bootstrapTable要求返回的数据必须包括total,rows
                return new PageForBootstrap<List<SaleBill>>(true, total, rows);
            } else {
                //无数据返回失败信息
                return new PageForBootstrap<List<SaleBill>>(false, "暂无数据");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new PageForBootstrap<List<SaleBill>>(false, "数据获取失败");
        }
    }

    /**
     * 新销售单
     *
     * @param goodsId   商品id
     * @param saleCount 销售数量
     * @param remarks   备注
     * @return 是否成功
     */
    @ResponseBody
    @RequestMapping(value = "/newSaleForm", method = RequestMethod.POST)
    public Result newSaleForm(@RequestParam(required = false) String goodsId,
                              @RequestParam(required = false) String saleCount,
                              @RequestParam(required = false) String remarks) {
        try {
            boolean isSuccess = goodsService.saleExcuse(goodsId, Integer.parseInt(saleCount));
            if (isSuccess) {
                boolean isInsertSuccess = saleService.insertSaleInfo(saleId, goodsId, saleCount, remarks);
                if (isInsertSuccess) {
                    return new Result(true);
                } else {
                    return new Result(false, "插入数据失败");
                }
            } else {
                return new Result(false, "出货失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "数据异常");
        }

    }

    /**
     * 查询近7天的销售数据
     *
     * @return 近7天的销售数据(map)
     */
    @ResponseBody
    @RequestMapping(value = "/chartSaleInfo", method = RequestMethod.POST)
    public Map<String, Object> queryBefore7DaysSaleInfo() {
        try {
            Map<String, Object> map = saleService.queryaWeekSaleInfo();
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
