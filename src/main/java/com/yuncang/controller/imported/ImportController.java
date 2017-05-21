package com.yuncang.controller.imported;

import com.yuncang.dto.PageForBootstrap;
import com.yuncang.dto.Result;
import com.yuncang.entity.GoodsBill;
import com.yuncang.entity.ImportBill;
import com.yuncang.service.GoodsService;
import com.yuncang.service.ImportService;
import com.yuncang.util.AutoMakeImportId;
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
 * 采购控制层
 */
@Controller
@RequestMapping(value = "yuncang")
public class ImportController {

    @Autowired
    private ImportService importService;
    @Autowired
    private GoodsService goodsService;

    private String importId;

    /**
     * 初始化界面
     *
     * @param model 返回页面的数据
     * @return 处理过的数据
     */
    @RequestMapping(value = "/import")
    public String imported(Model model) {
        //查询所有商品信息
        List<GoodsBill> goodsBills = goodsService.queryAllGoodsWithProffer();

        //查找数据库中最大ID值
        String maxImportId = importService.maxImportId();
        importId = AutoMakeImportId.MakeId(maxImportId);

        //将查询到的值传到页面
        model.addAttribute("importId", importId);
        model.addAttribute("goodsBills", goodsBills);
        return "import";
    }

    /**
     * 查询采购记录
     *
     * @param pageNumber 页码
     * @param pageSize   每页数据量
     * @param sortOrder  排序方式
     * @param sortName   排序列
     * @param fromTime   开始时间
     * @param toTime     结束时间
     * @return 查询结果(分页呈现)
     */
    @ResponseBody
    @RequestMapping(value = "/selectImportInfo")
    public PageForBootstrap<List<ImportBill>> queryAllimportInfo(@RequestParam(required = false, defaultValue = "1") int pageNumber,
                                                                 @RequestParam(required = false, defaultValue = "10") int pageSize,
                                                                 @RequestParam(required = false) String sortOrder,
                                                                 @RequestParam(required = false) String sortName,
                                                                 @RequestParam(required = false, defaultValue = "0") long fromTime,
                                                                 @RequestParam(required = false, defaultValue = "0") long toTime) {
        try {
            //拼接排序字符串
            String sort = sortName + "." + sortOrder;
            //获取数据
            Map<String, Object> map = importService.queryAllImportInfo(pageNumber, pageSize, sort, fromTime, toTime);
            List<ImportBill> rows = (List<ImportBill>) map.get("importBills");
            //获取总数据量
            int total = (Integer) map.get("totalCount");
            if (rows != null && total != 0) {
                //如果拿到数据,封装数据(json)返回前端->bootstrapTable要求返回的数据必须包括total,rows
                return new PageForBootstrap<List<ImportBill>>(true, total, rows);
            } else {
                //无数据返回失败信息
                return new PageForBootstrap<List<ImportBill>>(false, "暂无数据");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new PageForBootstrap<List<ImportBill>>(false, "数据获取失败");
        }
    }

    @ResponseBody
    @RequestMapping(value = "/newImportForm", method = RequestMethod.POST)
    public Result newImportForm(@RequestParam(required = false) String goodsId,
                                @RequestParam(required = false) String importPrice,
                                @RequestParam(required = false) String importCount,
                                @RequestParam(required = false) String remarks) {
        try {
            boolean isSuccess = goodsService.importExcuse(goodsId, Integer.parseInt(importCount));
            String profferId = goodsService.queryProfferId(goodsId);
            if (isSuccess) {
                boolean isInsertSuccess = importService.insertImportInfo(importId, goodsId, profferId, importPrice, importCount, remarks);
                if (isInsertSuccess) {
                    return new Result(true);
                } else {
                    return new Result(false, "插入数据失败");
                }
            } else {
                return new Result(false, "进货失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "数据异常");
        }
    }
}
