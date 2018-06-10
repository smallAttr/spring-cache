package com.smallAttr.github.rediscache;

import com.smallAttr.github.SpringRedisCacheLauncher;
import com.smallAttr.github.model.User;
import com.smallAttr.github.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: chenGang
 * @Date: 2018/6/9 上午12:44
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringRedisCacheLauncher.class)
public class SpringCacheApplicationTests {

    private static final Logger logger = LoggerFactory.getLogger(SpringCacheApplicationTests.class);

    @Autowired
    StringRedisTemplate redisTemplate;

    @Autowired
    UserService userService;

    @Test
    public void contextLoads() {
        Assert.assertNotNull(redisTemplate);

        redisTemplate.opsForValue().set("hello", "world");
        String value = redisTemplate.opsForValue().get("hello");
        logger.info("value = " + value);

        redisTemplate.delete("hello");

        value = redisTemplate.opsForValue().get("hello");
        logger.info("value = " + value);
    }


    @Test
    public void redisCache() {
        Assert.assertNotNull(userService);

        final long id = 100l;

        // 创建一个实体
        User user = new User();
        user.setId(id);
        user.setName("admin");
        user.setEmail("admin@123.com");

        // 添加一个
        userService.addUser(user);

        // 根据Id查询
        logger.info("user1 = " + userService.findById(id));
        sleep(1);
        // 等1s再次查询
        logger.info("user2 = " + userService.findById(id));
        sleep(5);
        // 等5s再次查询
        logger.info("user3 = " + userService.findById(id));

        // 添加一个
//        userService.addUser(user);
        // 根据Id查询
//        logger.info("user4 = " + userService.findById(id));
        // 删除
//        userService.delete(id);
        // 根据Id查询
//        logger.info("user5 = " + userService.findById(id));
    }

    private void sleep(int i) {
        try {
            Thread.sleep(i * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
