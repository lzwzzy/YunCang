package com.yuncang.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Calendar;
import java.util.Map;

/**
 * Created by lzw on 2017/5/22.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:/spring/spring-dao.xml",
        "classpath:/spring/spring-service.xml"})
public class ImportServiceTest {


    @Autowired
    private ImportService importService;

    //获得当天0点时间
    public static int getTimesmorning() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return (int) (cal.getTimeInMillis() / 1000);
    }

    //获得当天24点时间
    public static int getTimesnight() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 24);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return (int) (cal.getTimeInMillis() / 1000);
    }

    @Test
    public void queryAllImportInfo() throws Exception {
        Map<String, Object> map = importService.queryAllImportInfo(1, 10, "import_id.desc", getTimesmorning(), getTimesnight());
        int i = (Integer) map.get("totalCount");
        System.out.println(i);
    }

    @Test
    public void maxImportId() throws Exception {
    }

    @Test
    public void insertImportInfo() throws Exception {
    }

    @Test
    public void queryaWeekImprotInfo() throws Exception {
        Map<String, Object> map = importService.queryaWeekImprotInfo();

    }
}