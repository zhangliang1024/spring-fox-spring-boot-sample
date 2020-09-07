# SpringFox3.0.0 的学习使用
> Swagger 文档2.9.2升级为3.0.0 后可以不用通过配置类的方式定义接口文档。
>
> @EnableOpenApi注解即可启用文档

### 说明
```markdown
1. 演示SpringFox3.0
2. common-starter 演示项目
3. dynamic-datasource-starter 演示项目
4. redis-lock-spring-boot-starter 分布式锁演示
5. distributed-limit-spirng-boot-starter 分布式限流组件测试
6. xss-spring-boot-starter 防止XSS攻击
7. api-encrypt-spring-boot-starter
```

#### 测试接口地址：
```markdown

5. http://localhost:8081/limit?name=james&age=11
6. http://localhost:8081/limit?name=%3Cdr%3Eop&age=11
7. http://localhost:8081/encrypt

```


### 参考文档
[尝鲜刚发布的 SpringFox 3.0.0-以前造的轮子可以不用了](https://mp.weixin.qq.com/s/j-t4ZRyQ4S6UOXklo542ow)


