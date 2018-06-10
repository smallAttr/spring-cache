package com.smallAttr.github.service;

import com.smallAttr.github.model.User;

/**
 * @Author: chenGang
 * @Date: 2018/6/9 上午1:06
 * @Description:
 */
public interface UserService {

    void addUser(User user);

    User findById(Long id);

    void delete(Long id);
}
