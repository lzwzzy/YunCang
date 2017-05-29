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
    UserEntity loginCheck(@Param("username") String username, @Param("password") String password) throws Exception;

    /**
     * 注册
     *
     * @param user
     * @return
     */
    int insertUser(UserEntity user) throws Exception;

    /**
     * 判断用户名和手机号是否存在
     *
     * @param param
     * @return
     */
    int isExist(Map<String, Object> param) throws Exception;

    /**
     * 查询所有用户数据
     *
     * @param pageBounds
     * @return
     */
    List<UserEntity> queryAll(PageBounds pageBounds) throws Exception;


    /**
     * 根据用户名查询用户个人信息
     *
     * @param username 用户名
     * @return 个人信息
     */
    UserEntity queryPersonInfoByUserName(String username) throws Exception;


    /**
     * 根据id修改个人信息
     *
     * @param userid    用户id
     * @param username  用户名
     * @param userphone 手机号
     * @param useremail 邮箱
     * @param sex       性别
     * @return 影响行数
     */
    int editPersonInfoByUserId(@Param("userid") int userid,
                               @Param("username") String username,
                               @Param("userphone") String userphone,
                               @Param("useremail") String useremail,
                               @Param("sex") String sex) throws Exception;

    /**
     * 修改密码
     *
     * @param username    用户名
     * @param newPassword 密码
     * @return 受影响行数
     */
    int editPassword(@Param("username") String username,
                     @Param("newPassword") String newPassword) throws Exception;
}
