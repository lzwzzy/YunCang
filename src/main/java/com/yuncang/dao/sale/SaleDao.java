package com.yuncang.dao.sale;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.yuncang.entity.SaleBill;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * Created by lzw on 2017/5/24.
 * 销售持久层
 */
public interface SaleDao {

    /**
     * 查询所有销售记录
     *
     * @param pageBounds 分页信息
     * @param fromTime   开始时间
     * @param toTime     结束时间
     * @param isHaveTime 时间标志位
     * @return 分页后的销售信息
     * @throws Exception
     */
    List<SaleBill> queryAllSaleInfo(@Param("pageBounds") PageBounds pageBounds,
                                    @Param("fromTime") Date fromTime,
                                    @Param("toTime") Date toTime,
                                    @Param("isHaveTime") Boolean isHaveTime) throws Exception;

    /**
     * 查询当前数据库最大id
     *
     * @return
     */
    String maxSaleId();

    /**
     * 插入销售记录
     *
     * @param saleId    流水号
     * @param goodsId   商品id
     * @param saleCount 出货数量
     * @param remarks   备注
     * @return 受影响行数
     * @throws Exception
     */
    int insertSaleInfo(@Param("saleId") String saleId,
                       @Param("goodsId") String goodsId,
                       @Param("saleCount") String saleCount,
                       @Param("remarks") String remarks) throws Exception;

    /**
     * 查询当天销售数据
     *
     * @param fromTime   开始时间
     * @param toTime     结束时间
     * @param isHaveTime 时间存在标志位
     * @return 当天时间段的销售记录
     * @throws Exception
     */
    List<SaleBill> queryAllSaleInfo(@Param("fromTime") Date fromTime,
                                    @Param("toTime") Date toTime,
                                    @Param("isHaveTime") Boolean isHaveTime) throws Exception;

    /**
     * 查询全部销售记录
     *
     * @return 全部销售记录
     */
    List<SaleBill> queryAllSaleInfo();
}
