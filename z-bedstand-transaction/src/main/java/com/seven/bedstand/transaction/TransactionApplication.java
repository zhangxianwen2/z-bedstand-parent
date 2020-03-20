package com.seven.bedstand.transaction;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * <p>
 *
 * </p>
 *
 * @Author zhangxianwen
 * 2020/03/19 14:20
 **/
@SpringBootApplication
@MapperScan("com.seven.bedstand.transaction")
public class TransactionApplication {
    public static void main(String[] args) {
        SpringApplication.run(TransactionApplication.class, args);
    }
}
