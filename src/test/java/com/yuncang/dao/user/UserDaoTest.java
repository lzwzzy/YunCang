package com.yuncang.dao.user;

import com.yuncang.entity.UserEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by lzw on 2017/4/22.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/spring/spring-dao.xml")
public class UserDaoTest {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserDao userDao;
    @Test
    public void loginCheck() throws Exception {
        UserEntity userEntity = userDao.loginCheck("123", "123456");

        System.out.println(userEntity);
    }

    @Test
    public void insertUser() throws Exception {

        UserEntity userEntity = new UserEntity();
        int i = userDao.insertUser(userEntity);
        System.out.println(i);
    }
    @Test
    public void isExist() throws Exception {
        Map<String,Object> param = new HashMap<String,Object>();
        param.put("username","123");
        try {
            int exist = userDao.isExist(param);
            System.out.println(exist);
        } catch (Exception e){
            logger.error(e.getMessage(),e);
        }
    }

}