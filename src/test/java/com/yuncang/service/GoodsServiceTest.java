//package com.yuncang.service;
//
//import com.yuncang.entity.GoodsBill;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import java.util.List;
//import java.util.Map;
//
///**
// * Created by lzw on 2017/5/12.
// */
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration({"classpath:/spring/spring-dao.xml",
//        "classpath:/spring/spring-service.xml"})
//public class GoodsServiceTest {
//    @Autowired
//    private GoodsService goodsService;
//
//    @Test
//    public void queryAllGoodsWithProffer() throws Exception {
//        String sortOder = "asc";
//        Map<String, Object> map = goodsService.queryAllGoodsWithProffer(2, 5, sortOder, "");
//        int totalCount = (Integer) map.get("totalCount");
//        List<GoodsBill> goodsBills = (List<GoodsBill>) map.get("goodsBills");
//        System.out.println("totalCount:" + totalCount);
//        for (int i = 0; i < goodsBills.size(); i++) {
//            System.out.println(goodsBills.get(i).getGoodsName() + goodsBills.get(i).getProfferBill().getProfferedName());
//        }
//    }
//
//}