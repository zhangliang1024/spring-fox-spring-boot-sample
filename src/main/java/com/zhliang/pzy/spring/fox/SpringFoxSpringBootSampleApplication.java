package com.zhliang.pzy.spring.fox;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.oas.annotations.EnableOpenApi;

@MapperScan("com.zhliang.pzy.spring.fox.dynamic.datasource.mapper")
@EnableOpenApi
@SpringBootApplication
public class SpringFoxSpringBootSampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringFoxSpringBootSampleApplication.class, args);
    }

}
