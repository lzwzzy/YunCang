package com.yuncang.service.impl;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.github.miemiedev.mybatis.paginator.domain.Paginator;
import com.yuncang.dao.user.UserDao;
import com.yuncang.entity.UserEntity;
import com.yuncang.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lzw on 2017/4/22.
 * 用户逻辑类
 */
@Service
public class UserServiceImpl implements UserService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserDao userDao;



    public boolean loginCheck(String user_name, String user_password) {
        if (user_name != null && user_password != null) {
            UserEntity userEntity = userDao.loginCheck(user_name, user_password);
            if (userEntity != null) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }


    public int insertUser(UserEntity user) {
        int state = userDao.insertUser(user);
        return state;
    }



    public boolean isExist(UserEntity userEntity) {
        Map<String, Object> param = new HashMap<String, Object>();
        String username = userEntity.getUsername();
        long phone = userEntity.getPhone();
        param.put("phone", phone);
        param.put("username", username);
        try {
            int exist = userDao.isExist(param);
            //如果返回数据不为0，说明数据已存在,返回true
            if (exist != 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return false;
        }

    }




}
