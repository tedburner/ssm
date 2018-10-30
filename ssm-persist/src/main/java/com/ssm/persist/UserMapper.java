package com.ssm.persist;

import com.ssm.model.DO.UserDO;

import java.util.List;

/**
 * @author: Lucifer
 * @date: 2018/10/26 14:46
 * @description:
 */
public interface UserMapper {

    /**
     * 插入用户信息
     */

    void save(UserDO userDO);

    /**
     * 查询所有用户信息
     */
    List<UserDO> selectAll();

    /**
     * 根据ID查询用户信息
     *
     * @param id
     */
    UserDO selectById(Long id);

    /**
     * 根据手机查询用户信息
     *
     * @param phone
     */
    UserDO selectByPhone(String phone);
}
