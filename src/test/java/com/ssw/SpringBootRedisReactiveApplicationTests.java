package com.ssw;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.*;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootRedisReactiveApplicationTests {

    @Autowired
    ReactiveStringRedisTemplate reactiveStringRedisTemplate;

    @Autowired
    RedisTemplate<String,String> redisTemplate;


    @Test
    public void contextLoads() {
        ListOperations<String, String> listOps = redisTemplate.opsForList();
        System.out.println(redisTemplate.opsForValue().get("sswTest"));
        Set<String> keys = redisTemplate.keys("*");
        System.out.println(redisTemplate.opsForValue().multiGet(keys));

    }

    @Test
    public void test(){
        Set<String> keys = redisTemplate.keys("sswT*");
        List<Map<String,String>> mapArrayList = new ArrayList<>();
        Map<String, String> map = new HashMap<>();
        if (keys != null) {
            for (String key : keys) {
                map.put(key,redisTemplate.opsForValue().get(key));
            }
        }
        mapArrayList.add(map);
        System.out.println(mapArrayList);
    }

}

