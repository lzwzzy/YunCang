package com.yuncang.dao.goods;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.yuncang.entity.GoodsBill;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by lzw on 2017/5/12.
 * 商品持久层代码
 */
public interface GoodsDao {


    /**
     * 查询全部商品信息集，返回结果携带供货商实体
     *
     * @param pageBounds 分页信息
     * @param searchText 查询参数
     * @return 商品信息及供货商实体集
     * @throws Exception
     */
    List<GoodsBill> queryAllGoodsWithProffer(@Param("pageBounds") PageBounds pageBounds, @Param("searchText") String searchText) throws Exception;


    /**
     * 插入商品信息
     *
     * @param goodsName  商品信息
     * @param goodsType  商品类型
     * @param goodsPrice 商品价格
     * @param goodsStock 商品库存
     * @param profferId  供货商id
     * @param state      上架状态
     * @param remarks    备注
     * @return 插入行数
     * @throws Exception
     */
    int insertIntoGoodsBill(@Param("goodsId") long goodsId,
                            @Param("goodsName") String goodsName,
                            @Param("goodsPrice") int goodsPrice,
                            @Param("goodsStock") int goodsStock,
                            @Param("profferId") long profferId,
                            @Param("goodsType") int goodsType,
                            @Param("state") int state,
                            @Param("remarks") String remarks) throws Exception;

    /**
     * 查询最大商品ID
     *
     * @return 最大商品ID
     */
    String maxGoodsId();


    /**
     * 更新数据
     *
     * @param goodsBill POJO(GoodsBill)
     * @param field     被更新列
     * @return 更新行数
     */
    int updateGoodsInfo(@Param("goodsBill") GoodsBill goodsBill, @Param("field") String field);

    /**
     * 删除数据
     * @param goodsIdList id集合
     * @return 受影响行数
     * @throws Exception
     */
    int deleteGoodsInfo(List goodsIdList) throws Exception;

}
