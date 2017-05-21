package com.yuncang.service;

import java.util.Map;

/**
 * Created by lzw on 2017/5/20.
 * 采购版块逻辑
 */
public interface ImportService {
    /**
     * 查询采购记录
     *
     * @param pageNumber 页码
     * @param pageSize   每页数据量
     * @param sortOrder  排序方式
     * @param fromTime   开始时间
     * @param toTime     结束时间
     * @return 查询结果(分页呈现)
     * @throws Exception
     */
    Map<String, Object> queryAllImportInfo(int pageNumber,
                                           int pageSize,
                                           String sortOrder,
                                           long fromTime,
                                           long toTime) throws Exception;

    /**
     * 查询数据库中最大id值
     * @return 最大id值
     */
    String maxImportId();

    /**
     * 插入采购记录
     *
     * @param importId    编号
     * @param goodsId     商品id
     * @param profferId   供货商id
     * @param importPrice 进价
     * @param importCount 进货数量
     * @param remarks     备注
     * @return 是否插入成功
     * @throws Exception
     */
    boolean insertImportInfo(String importId,
                             String goodsId,
                             String profferId,
                             String importPrice,
                             String importCount,
                             String remarks)throws Exception;
}
