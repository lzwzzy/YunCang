package com.yuncang.dao.user;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.yuncang.entity.UserEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by lzw on 2017/4/21.
 * 用户持久层代码
 */
public interface UserDao {

    /**
     * 登陆验证
     *
     * @param username
     * @param password
     * @return
     */
    UserEntity loginCheck(@Param("username") String username, @Param("password") String password);

    /**
     * 注册
     *
     * @param user
     * @return
     */
    int insertUser(UserEntity user);

    /**
     * 判断用户名和手机号是否存在
     *
     * @param param
     * @return
     */
    int isExist(Map<String, Object> param);

    /**
     * 查询所有用户数据
     *
     * @param pageBounds
     * @return
     */
    List<UserEntity> queryAll(PageBounds pageBounds);


    /**
     * 根据用户名查询用户个人信息
     * @param username 用户名
     * @return 个人信息
     */
    UserEntity queryPersonInfoByUserName(String username);

}
