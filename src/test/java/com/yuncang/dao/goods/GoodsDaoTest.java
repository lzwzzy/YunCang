//package com.yuncang.dao.goods;
//
//import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
//import com.yuncang.entity.GoodsBill;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * Created by lzw on 2017/5/12.
// *
// */
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration("classpath:/spring/spring-dao.xml")
//public class GoodsDaoTest {
//
//
//    @Autowired
//    private GoodsDao goodsDao;
//
//    @Test
//    public void queryAllGoodsInfo() throws Exception {
//        PageBounds pageBounds = new PageBounds(1, 5);
//
//        List<GoodsBill> goodsBills = goodsDao.queryAllGoodsWithProffer(pageBounds, "");
//
//        //PageList pageList = (PageList) goodsEntities;
//
//        System.out.println(goodsBills);
//
//    }
//
//    @Test
//    public void insertIntoGoodsBill() throws Exception {
//        int i = goodsDao.insertIntoGoodsBill("123123",
//                "哈哈",
//                123,
//                123,
//                800002,
//                1,
//                1,
//                "123");
//        if (i == 1) {
//            System.out.println("插入成功");
//
//        }
//    }
//
//    @Test
//    public void maxGoodsId() throws Exception {
//        String s = goodsDao.maxGoodsId();
//        System.out.println(s);
//    }
//
//    @Test
//    public void updateGoodsInfo() throws Exception {
//        GoodsBill goodsBill = new GoodsBill();
//        goodsBill.setGoodsId("201705110001");
//        goodsBill.setGoodsName("xiaomi2");
//        int i = goodsDao.updateGoodsInfo(goodsBill, "goodsName");
//        System.out.println(i);
//    }
//
//    @Test
//    public void deleteGoodsInfo() throws Exception {
//
//        List<String> list = new ArrayList<String>();
//        list.add("201705150013");
//        list.add("201705150014");
//        System.out.println(list);
//        int i = goodsDao.deleteGoodsInfo(list);
//        System.out.println(i);
//    }
//
//    @Test
//    public void queryAllGoodsWithProffer() throws Exception {
//        List<GoodsBill> goodsBills = goodsDao.queryAllGoodsWithProffer();
//        System.out.println(goodsBills);
//    }
//
//
//}