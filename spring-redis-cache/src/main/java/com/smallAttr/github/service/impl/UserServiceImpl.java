package com.smallAttr.github.service.impl;

import com.smallAttr.github.model.User;
import com.smallAttr.github.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: chenGang
 * @Date: 2018/6/9 上午1:08
 * @Description:
 */
@Service
public class UserServiceImpl implements UserService {

    private final Map<Long, User> db = new HashMap<>();

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    public void addUser(User user) {
        logger.info("add user {}", user);
        db.put(user.getId(), user);
    }

    @Cacheable(cacheNames = "user_cache", key = "#id")
    public User findById(Long id) {
        logger.info("find user by id {}", id);
        return db.get(id);
    }

    @CacheEvict(cacheNames = "user_cache", key = "#id")
    public void delete(Long id) {
        logger.info("delete user by id {}", id);
        db.remove(id);
    }
}
