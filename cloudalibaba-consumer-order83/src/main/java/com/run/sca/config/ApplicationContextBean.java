package com.run.sca.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @desc:
 * @author: AruNi_Lu
 * @date: 2023/11/7
 */
@Configuration
public class ApplicationContextBean {

    // RestTemplate 配合 Ribbon 做负载均衡
    // 通过 RestTemplate 发送的请求将会基于负载均衡策略分发到多个实例上
    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
