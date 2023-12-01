package com.run.sca;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @desc:
 * @author: AruNi_Lu
 * @date: 2023-11-30 12:30
 */
@EnableDiscoveryClient
@SpringBootApplication
@MapperScan({"com.run.sca.dao"})
@EnableFeignClients
public class SeataAccountService2003 {
    public static void main(String[] args) {
        SpringApplication.run(SeataAccountService2003.class, args);
    }
}
