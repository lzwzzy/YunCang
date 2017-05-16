package com.yuncang.controller.goods;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yuncang.dto.PageForBootstrap;
import com.yuncang.dto.Result;
import com.yuncang.entity.GoodsBill;
import com.yuncang.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by lzw on 2017/5/8.
 * 商品信息控制层
 */
@Controller
@RequestMapping(value = "yuncang")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @RequestMapping(value = "/goods")
    public String buy() {
        return "manage";
    }


    /**
     * 商品信息
     * @param pageNumber 页码
     * @param pageSize 每页数据量
     * @param sortOrder 排序方式
     * @param sortName 排序参照列
     * @param searchText 查询条件
     * @return 结果信息
     */
    @ResponseBody
    @RequestMapping(value = "/selectGoodsInfo", method = RequestMethod.POST)
    public PageForBootstrap<List<GoodsBill>> goosInfo(@RequestParam(required = false,defaultValue = "1") int pageNumber,
                                                      @RequestParam(required = false,defaultValue = "10") int pageSize,
                                                      @RequestParam(required = false) String sortOrder,
                                                      @RequestParam(required = false) String sortName,
                                                      @RequestParam(required = false) String searchText) {

        try {
            //拼接排序字符串
            String sort = sortName+"."+sortOrder;
            //获取数据
            Map<String, Object> map = goodsService.queryAllGoodsWithProffer(pageNumber, pageSize, sort,searchText);
            List<GoodsBill> rows = (List<GoodsBill>) map.get("goodsBills");
            //获取总数据量
            int total = (Integer) map.get("totalCount");
            if (rows!=null && total!=0){
                //如果拿到数据,封装数据(json)返回前端->bootstrapTable要求返回的数据必须包括total,rows
                return new PageForBootstrap<List<GoodsBill>>(true,total,rows);
            }else {
                //无数据返回失败信息
                return new PageForBootstrap<List<GoodsBill>>(false,"暂无数据");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new PageForBootstrap<List<GoodsBill>>(false,"数据获取失败");
        }
    }

    /**
     * 插入商品信息
     * @param name 商品名称
     * @param type 商品类型
     * @param price 商品单价
     * @param stock 商品库存
     * @param proffer 供货商id
     * @param state 上架状态
     * @param remarks 备注
     * @return 是否插入成功
     */
    @ResponseBody
    @RequestMapping(value = "/insertGoodsInfo",method = RequestMethod.POST)
    public Result insertGoods(@RequestParam(required = false) String name,
                              @RequestParam(required = false) int type,
                              @RequestParam(required = false) int price,
                              @RequestParam(required = false) int stock,
                              @RequestParam(required = false) int proffer,
                              @RequestParam(required = false) int state,
                              @RequestParam(required = false) String remarks){
        try {
            boolean isSuccess = goodsService.insertGoodsInfo(name, type, price, stock, proffer, state, remarks);
            if (isSuccess){
                return new Result(true);
            }else {
                return new Result(false,"插入失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"插入失败");
        }

    }

    /**
     * 数据修改
     * @param row 修改后的信息,包括商品id,和被修改列所对应的修改后的值
     * @param field 被修改列
     * @return 是否修改成功
     */
    @ResponseBody
    @RequestMapping(value = "/updateGoodsInfo",method = RequestMethod.POST)
    public Result updateGoodsInfo(@RequestParam String row,
                                @RequestParam String field){
        try {
            boolean isSuccess = goodsService.updateGoodsInfo(row, field);
            if (isSuccess){
                return new Result(true);
            }else {
                return new Result(false,"修改失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"修改失败");
        }
    }

    /**
     * 删除商品信息
     * @param goodsIdList 前端传来的准备删除的信息的ID集合
     * @return 是否删除成功
     */
    @ResponseBody
    @RequestMapping(value = "/deleteGoodsInfo",method = RequestMethod.POST)
    public Result deleteGoodsInfo(@RequestParam(value = "goodsIdList[]",required = false) List goodsIdList){
        try {
            boolean isSuccess = goodsService.deleteGoodsInfo(goodsIdList);
            if (isSuccess){
                return new Result(true);
            }else {
                return new Result(false,"删除失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"删除失败");
        }
    }
}
