package com.yuncang.dao.user;

import com.yuncang.entity.UserEntity;
import org.apache.ibatis.annotations.Param;


import java.util.Map;

/**
 * Created by lzw on 2017/4/21.
 */
public interface UserDao {

    /**
     * 登陆验证
     * @param username
     * @param password
     * @return
     */
    UserEntity loginCheck(@Param("username") String username,@Param("password") String password);

    /**
     * 注册
     * @param user
     * @return
     */
    int insertUser(UserEntity user);

    /**
     * 判断用户名和手机号是否存在
     * @param param
     * @return
     */
    int isExist(Map<String,Object> param);

}
