package com.yuncang.service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.yuncang.entity.UserEntity;

import java.util.Map;

/**
 * Created by lzw on 2017/4/22.
 * 用户逻辑
 */
public interface UserService {

    /**
     * 登陆验证
     *
     * @param user_name
     * @param user_password
     * @return
     */
    boolean loginCheck(String user_name, String user_password);

    /**
     * 用户注册
     *
     * @param user
     * @return
     */
    int insertUser(UserEntity user);

    /**
     * 判断用户名是否存在
     *
     * @param userEntity
     * @return
     */
    boolean isExist(UserEntity userEntity);

}
