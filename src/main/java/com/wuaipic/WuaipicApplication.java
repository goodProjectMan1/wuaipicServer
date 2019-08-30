package com.wuaipic;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;


@SpringBootApplication()
@MapperScan(value = "com.wuaipic.mapper")
public class WuaipicApplication {

    public static void main(String[] args) {
        SpringApplication.run(WuaipicApplication.class, args);
    }

}
