package com.yuncang.service;

import com.yuncang.entity.UserEntity;

/**
 * Created by lzw on 2017/4/22.
 * 用户逻辑
 */
public interface UserService {

    /**
     * 登陆验证
     *
     * @param user_name     用户名
     * @param user_password 密码
     * @return 是否验证成功
     */
    boolean loginCheck(String user_name, String user_password) throws Exception;

    /**
     * 用户注册
     *
     * @param user 用户实体
     * @return
     */
    int insertUser(UserEntity user) throws Exception;

    /**
     * 判断用户名是否存在
     *
     * @param userEntity 用户实体
     * @return
     */
    boolean isExist(UserEntity userEntity);

    /**
     * 根据用户名查询用户个人资料
     *
     * @param username 用户名
     * @return
     */
    UserEntity queryPersonInfoByUserName(String username) throws Exception;

    /**
     * 修改个人资料
     *
     * @param id        用户id
     * @param username  用户名
     * @param userphone 手机号
     * @param useremail 邮箱
     * @param sex       性别
     * @return 是否修改成功
     */
    boolean editPersonInfo(int id,
                           String username,
                           String userphone,
                           String useremail,
                           String sex) throws Exception;

    /**
     * 修改密码
     *
     * @param username    用户名
     * @param newPassword 新密码
     * @return 是否修改成功
     */
    boolean editPassword(String username, String newPassword) throws Exception;

}
