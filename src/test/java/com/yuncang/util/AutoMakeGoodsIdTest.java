package com.yuncang.util;

import com.yuncang.dao.goods.GoodsDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by lzw on 2017/5/14.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/spring/spring-dao.xml")
public class AutoMakeGoodsIdTest {
    @Autowired
    private GoodsDao goodsDao;

    @Test
    public void makeId() throws Exception {
        String s = goodsDao.maxGoodsId();
    }

}