//package com.yuncang.service;
//
//import com.yuncang.entity.ProfferBill;
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
// * Created by lzw on 2017/5/18.
// */
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration({"classpath:/spring/spring-dao.xml",
//        "classpath:/spring/spring-service.xml"})
//public class ProfferServiceTest {
//
//    @Autowired
//    private ProfferService profferService;
//
//    @Test
//    public void queryAllProffer() throws Exception {
//        Map<String, Object> map = profferService.queryAllProffer(1, 5, "proffered_id.desc", null);
//
//        List<ProfferBill> rows = (List<ProfferBill>) map.get("profferBills");
//
//        int totalCount = (Integer) map.get("totalCount");
//
//        System.out.println(rows);
//        System.out.println(totalCount);
//
//
//    }
//
//}