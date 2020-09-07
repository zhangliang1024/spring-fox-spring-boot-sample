package com.zhliang.pzy.spring.fox.limit;//package com.zhliang.pzy.distributed.limit;

import com.zhliang.pzy.distributed.limit.annotation.RedisLimit;
import com.zhliang.pzy.distributed.limit.annotation.RedisParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @类描述：测试分布式限流和XSS攻击
 * @version：V1.0
 */
@RestController
public class LimitController {

    @GetMapping("limit")
    @RedisLimit(prefix = "name",expire = 1,count = 10,message = "limit is working")
    public String limit(@RedisParam String name,@RedisParam int age){
        System.err.println("========>>>>>> " +name);
        return "hello " + name;
    }

}
