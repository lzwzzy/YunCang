package com.yuncang.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.miemiedev.mybatis.paginator.domain.Order;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.yuncang.dao.goods.GoodsDao;
import com.yuncang.entity.GoodsBill;
import com.yuncang.service.GoodsService;
import com.yuncang.util.AutoMakeGoodsId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lzw on 2017/5/12.
 * 商品信息页逻辑实现
 */
@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsDao goodsDao;

    @Override
    public Map<String, Object> queryAllGoodsWithProffer(int pageNumber, int pageSize, String sortOrder, String searchText) throws Exception {

        //在pageBounds构造方法中传入参数，实现分页
        PageBounds pageBounds = new PageBounds(pageNumber, pageSize, Order.formString(sortOrder));
        //调用Dao层方法获取数据集
        List<GoodsBill> goodsBills = goodsDao.queryAllGoodsWithProffer(pageBounds, searchText);
        //处理数据集->分页
        PageList pageList = (PageList) goodsBills;
        //获取总数据数
        int totalCount = pageList.getPaginator().getTotalCount();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("totalCount", totalCount);
        map.put("goodsBills", pageList);
        return map;
    }

    @Override
    @Transactional
    public boolean insertGoodsInfo(String goodsName, int goodsType, int goodsPrice, int goodsStock, int proffer, int state, String remarks) throws Exception {
        //获取数据库中当前最大ID值
        String maxGoodsId = goodsDao.maxGoodsId();
        //自定义工具类AutoMakeGoodsId,生成id
        String goodsId = AutoMakeGoodsId.MakeId(maxGoodsId);

        int isSuccess = goodsDao.insertIntoGoodsBill(goodsId, goodsName, goodsPrice, goodsStock, proffer, goodsType, state, remarks);
        if (isSuccess == 1) {
            return true;
        } else {
            return false;
        }

    }

    @Override
    @Transactional
    public boolean updateGoodsInfo(String row, String field) throws Exception {
        //利用jackson将row(json字符串)转化为POJO(GoodsBill)
        ObjectMapper mapper = new ObjectMapper();
        GoodsBill goodsBill = mapper.readValue(row, GoodsBill.class);

        int isSuccess = goodsDao.updateGoodsInfo(goodsBill, field);
        if (isSuccess == 1) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    @Transactional
    public boolean deleteGoodsInfo(List goodsIdList) throws Exception {
        int i = goodsDao.deleteGoodsInfo(goodsIdList);
        if (i > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<GoodsBill> queryAllGoodsWithProffer() {
        List<GoodsBill> goodsBills = goodsDao.queryAllGoodsWithProffer();
        return goodsBills;
    }

    @Override
    @Transactional
    public boolean importExcuse(String goodsId, int number) throws Exception {
        int isSuccess = goodsDao.importExcuse(goodsId, number);
        if (isSuccess > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String queryProfferId(String goodsId) throws Exception {
        String profferId = goodsDao.queryProfferId(goodsId);
        return profferId;
    }
}
