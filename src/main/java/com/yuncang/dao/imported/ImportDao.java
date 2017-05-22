package com.yuncang.dao.imported;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.yuncang.entity.ImportBill;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * Created by lzw on 2017/5/20.
 * 采购持久层
 */
public interface ImportDao {

    /**
     * 查询全部采购记录
     *
     * @param pageBounds 分页信息
     * @param fromTime   起始时间
     * @param toTime     截止时间
     * @return 信息列表
     * @throws Exception
     */
    List<ImportBill> queryAllImportInfo(@Param("pageBounds") PageBounds pageBounds,
                                        @Param("fromTime") Date fromTime,
                                        @Param("toTime") Date toTime,
                                        @Param("isHaveTime") Boolean isHaveTime) throws Exception;

    /**
     * 查询最大采购编号ID
     *
     * @return 最大采购编号ID
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
     * @return 影响行数
     * @throws Exception
     */
    int insertImportInfo(@Param("importId") String importId,
                         @Param("goodsId") String goodsId,
                         @Param("profferId") String profferId,
                         @Param("importPrice") String importPrice,
                         @Param("importCount") String importCount,
                         @Param("remarks") String remarks) throws Exception;

    /**
     * 查询当日记录，无需分页，做统计用
     *
     * @param fromTime   当天开始时间
     * @param toTime     当天结束时间
     * @param isHaveTime 时间是否存在标志位
     * @return 当日信息列表
     */
    List<ImportBill> queryAllImportInfo(@Param("fromTime") Date fromTime,
                                        @Param("toTime") Date toTime,
                                        @Param("isHaveTime") Boolean isHaveTime);

    /**
     * 查询总记录
     *
     * @return 总记录列表
     */
    List<ImportBill> queryAllImportInfo();
}
