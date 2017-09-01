//package com.yuncang.dao.imported;
//
//import com.yuncang.entity.ImportBill;
//import com.yuncang.util.GetTodayTimeStamp;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import java.util.Calendar;
//import java.util.Date;
//import java.util.GregorianCalendar;
//import java.util.List;
//
///**
// * Created by lzw on 2017/5/22.
// */
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration("classpath:/spring/spring-dao.xml")
//public class ImportDaoTest {
//
//    @Autowired
//    private ImportDao importDao;
//
//    @Test
//    public void queryAllImportInfo() throws Exception {
//        long l = GetTodayTimeStamp.getTimesmorning() * 1000;
//        Date date = new Date(l);
//        Calendar calendar = new GregorianCalendar();
//        calendar.setTime(date);
//        calendar.add(calendar.DATE, -1);
//        date = calendar.getTime();
//        System.out.println(date);
//        List<ImportBill> importBills = importDao.queryAllImportInfo();
//        System.out.println(importBills);
//    }
//
//}