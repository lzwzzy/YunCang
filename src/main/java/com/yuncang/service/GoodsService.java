package com.yuncang.service;


import com.yuncang.entity.GoodsBill;

import java.util.List;
import java.util.Map;

/**
 * Created by lzw on 2017/5/12.
 * 商品信息逻辑
 */
public interface GoodsService {

    /**
     * 分页获取商品信息
     *
     * @param pageNumber 第几页
     * @param pageSize   每页显示的信息数
     * @param sortOrder  排序方式
     * @param searchText 查询条件
     * @return Map中包含totalCount:总记录数
     * goodsBills:某页的数据
     * @throws Exception
     */
    Map<String, Object> queryAllGoodsWithProffer(int pageNumber, int pageSize, String sortOrder, String searchText) throws Exception;


    /**
     * 插入商品信息
     *
     * @param goodsName  商品信息
     * @param goodsType  商品类型
     * @param goodsPrice 商品价格
     * @param goodsStock 商品库存
     * @param proffer    供货商id
     * @param state      上架状态
     * @param remarks    备注
     * @return 是否插入成功
     * @throws Exception
     */
    boolean insertGoodsInfo(String goodsName,
                            int goodsType,
                            int goodsPrice,
                            int goodsStock,
                            int proffer,
                            int state,
                            String remarks) throws Exception;

    /**
     * 数据修改
     *
     * @param row   修改后的信息,包括商品id,和被修改列所对应的修改后的值
     * @param field 被修改列
     * @return 是否修改成功
     * @throws Exception
     */
    boolean updateGoodsInfo(String row, String field) throws Exception;

    /**
     * 删除商品信息
     *
     * @param goodsIdList ID集合
     * @return 是否删除成功
     * @throws Exception
     */
    boolean deleteGoodsInfo(List goodsIdList) throws Exception;

    List<GoodsBill> queryAllGoodsWithProffer();

    /**
     * 执行进货操作
     *
     * @param goodsId 商品id
     * @param number  进货数量
     * @return 是否执行成功
     */
    boolean importExcuse(String goodsId, int number) throws Exception;

    /**
     * 执行出货操作
     *
     * @param goodsId 商品id
     * @param number  进货数量
     * @return 是否执行成功
     * @throws Exception
     */
    boolean saleExcuse(String goodsId, int number) throws Exception;

    /**
     * 根据商品id查询供货商
     *
     * @param goodsId 商品id
     * @return 供货商id
     * @throws Exception
     */
    String queryProfferId(String goodsId) throws Exception;
}
