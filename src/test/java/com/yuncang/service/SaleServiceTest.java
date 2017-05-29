package com.yuncang.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Map;

/**
 * Created by lzw on 2017/5/24.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:/spring/spring-dao.xml",
        "classpath:/spring/spring-service.xml"})
public class SaleServiceTest {

    @Autowired
    private SaleService saleService;

    @Test
    public void queryAllSaleInfo() throws Exception {
        Map<String, Object> map = saleService.queryAllSaleInfo(1, 5, "sale_id.desc", 0, 0);
        System.out.println(map);
    }

}