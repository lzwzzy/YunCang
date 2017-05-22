package com.yuncang.dao.imported;

import com.yuncang.dao.goods.GoodsDao;
import com.yuncang.entity.ImportBill;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by lzw on 2017/5/22.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/spring/spring-dao.xml")
public class ImportDaoTest {

    @Autowired
    private ImportDao importDao;

    @Test
    public void queryAllImportInfo() throws Exception {
        List<ImportBill> importBills = importDao.queryAllImportInfo();
        System.out.println(importBills);
    }

}