package com.yuncang.service;

import java.util.Map;

/**
 * Created by lzw on 2017/5/24.
 * 销售版块逻辑
 */
public interface SaleService {

    /**
     * 查询全部销售记录
     *
     * @param pageNumber 页码
     * @param pageSize   每页数据量
     * @param sortOrder  排序方式
     * @param fromTime   开始时间
     * @param toTime     结束时间
     * @return 全部销售记录(分页)
     * @throws Exception
     */
    Map<String, Object> queryAllSaleInfo(int pageNumber,
                                         int pageSize,
                                         String sortOrder,
                                         long fromTime,
                                         long toTime) throws Exception;

    /**
     * 查询最大id
     *
     * @return 最大id值
     */
    String maxSaleId();

    /**
     * 插入销售记录
     *
     * @param saleId    流水号
     * @param goodsId   商品id
     * @param saleCount 销售数量
     * @param remarks   备注
     * @return 是否插入成功
     */
    boolean insertSaleInfo(String saleId,
                           String goodsId,
                           String saleCount,
                           String remarks) throws Exception;

    /**
     * 查询当天数据
     *
     * @param fromTime 当天0点
     * @param toTime   当天12点
     * @return 当天范围内销售价格及数量
     */
    Map<String, Object> queryTodaySaleInfo(long fromTime, long toTime) throws Exception;

    /**
     * 查询全部数据
     *
     * @return 销售价格及数量
     */
    Map<String, Object> queryAllSaleInfo();

    /**
     * 查询近7天的销售数据数据
     *
     * @return 近7天的数据
     */
    Map<String, Object> queryaWeekSaleInfo() throws Exception;
}
