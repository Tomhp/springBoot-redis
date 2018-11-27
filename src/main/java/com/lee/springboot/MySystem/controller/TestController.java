package com.lee.springboot.MySystem.controller;
import com.lee.springboot.MySystem.bean.User;
import com.lee.springboot.MySystem.util.RedisKeyPrefix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/demo")
public class TestController {
    @Autowired
    RedisTemplate redisTemplate;
    @RequestMapping("/hello")
    public Object hello(){


        User user  =  new User();
        user.setName("liheping001");
        user.setSex("nan");
        user.setLength(1.65);
        redisTemplate.opsForValue().set("person",user);
        String key = RedisKeyPrefix.PERSON;
        boolean hasKey = redisTemplate.hasKey(key);

        if (hasKey) { // 从缓存中取
          User  user2 = (User) redisTemplate.opsForValue().get(key);

            return user2;
        }
        return "hhhh";
    }
}
