package com.yuncang.service.impl;

import com.yuncang.dao.user.UserDao;
import com.yuncang.entity.UserEntity;
import com.yuncang.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
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


    /**
     * 登陆验证
     *
     * @param user_name
     * @param user_password
     * @return
     */
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

    /**
     * 用户注册
     *
     * @param user
     * @return
     */
    public int insertUser(UserEntity user) {
        int state = userDao.insertUser(user);
        return state;
    }


    /**
     * 判断用户名,手机号是否存在
     *
     * @param userEntity
     * @return
     */
    public boolean isExist(UserEntity userEntity) {
        Map<String, Object> param = new HashMap<String, Object>();
        String username = userEntity.getUsername();
        long phone = userEntity.getPhone();
        if (username != null && !username.equals("")) {
            param.put("username", username);
            try {
                int exist = userDao.isExist(param);
                if (exist != 0) {
                    return true;
                } else {
                    return false;
                }
            } catch (Exception e) {
                logger.error(e.getMessage(), e);
                return false;
            }
        } else {

            try {
                param.put("phone", phone);
                int exist = userDao.isExist(param);
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


}
