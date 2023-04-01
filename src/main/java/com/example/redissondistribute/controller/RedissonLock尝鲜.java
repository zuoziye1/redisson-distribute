package com.example.redissondistribute.controller;

import org.redisson.api.RedissonClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author: 姚飞虎
 * @Date: 2023/4/1 8:40 PM
 * @Description:
 */
@RestController
public class RedissonLock尝鲜 {

    /**
     * 直接注入RedissonClient就可以直接使用.
     */
    @Resource
    private RedissonClient redissonClient;

    @GetMapping("/test")
    public String test(){
        String key = "name:yaofeihu";
        boolean success = redissonClient.getLock(key).tryLock();
        if(success){
            System.out.println("获取锁成功了");
        }
        return "success";
    }
}
