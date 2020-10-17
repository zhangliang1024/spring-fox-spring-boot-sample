package com.zhliang.pzy.spring.fox.cache;

import com.zhliang.pzy.cache.annotation.Cacheable;
import com.zhliang.pzy.cache.config.PowerCacheBuilder;
import com.zhliang.pzy.pzylog.client.Logger;
import com.zhliang.pzy.pzylog.client.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.UUID;

/**
 * @类描述：缓存使用测试
 * @创建时间：2020/10/16 14:09
 * @version：V1.0
 */
@RestController
@RequestMapping("cache")
public class CacheController {

    private static final Logger logger = LoggerFactory.getLogger(CacheController.class);

    @Autowired
    PowerCacheBuilder cacheBuilder;

    @Cacheable(key = "uuid",expireTime = 6000L)
    @GetMapping("/uuid")
    public String getResult(){
        String uuid = UUID.randomUUID().toString().replaceAll("-","");
        logger.info("cache uuid : {}",uuid);
        return uuid;
    }

    @GetMapping
    public String cache(){

        String version = cacheBuilder.getCacheVersion();
        logger.info(String.format("当前缓存版本：%s", version));


        String cacheKey = cacheBuilder.generateVerKey("goods_v1");
        cacheBuilder.set(cacheKey, "我的测试商品");
        String goodsVO1 = cacheBuilder.get(cacheKey);
        logger.info("first : {}" ,goodsVO1);

        //增加缓存版本
        version = cacheBuilder.resetCacheVersion();
        logger.info(String.format("重置后的缓存版本：%s", version));


        cacheKey = cacheBuilder.generateVerKey("goods_v1");
        cacheBuilder.set(cacheKey, "我的测试商品");
        String goodsVO2 = cacheBuilder.get(cacheKey);
        logger.info("增加缓存版本后 value : {}",goodsVO2);

        return "cache suceess";
    }
}
