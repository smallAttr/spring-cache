package com.smallAttr.github.memcache;

import com.smallAttr.github.SpringMemcacheCacheLauncher;
import net.rubyeye.xmemcached.MemcachedClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: chenGang
 * @Date: 2018/6/10 下午11:17
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringMemcacheCacheLauncher.class)
public class MemcacheApplicationTests {


    @Autowired
    private MemcachedClient memcachedClient;

    @Test
    public void test() {
        try {
            // 设置/获取
            memcachedClient.set("zlex", 36000, "set/get");
            System.out.println((String) memcachedClient.get("zlex"));
            // 替换
            memcachedClient.replace("zlex", 36000, "replace");
            System.out.println((String) memcachedClient.get("zlex"));
            // 移除
            memcachedClient.delete("zlex");
            System.out.println((String) memcachedClient.get("zlex"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
