package com.yuncang.dao.proffer;

import com.yuncang.entity.ProfferBill;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by lzw on 2017/5/12.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/spring/spring-dao.xml")
public class ProfferDaoTest {


    @Autowired
    ProfferDao profferDao;


    @Test
    public void queryAllProffer() throws Exception {
        List<ProfferBill> profferBills = profferDao.queryAllProffer();
        System.out.println(profferBills);
    }

}