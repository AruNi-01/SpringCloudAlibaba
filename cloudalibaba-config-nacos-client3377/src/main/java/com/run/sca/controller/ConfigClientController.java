package com.run.sca.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @desc:
 * @author: AruNi_Lu
 * @date: 2023/11/7
 */
@RestController
@RefreshScope   // 控制器类上加 @RefreshScope 使当前类下的配置支持 Nacos 的动态刷新
public class ConfigClientController {

    // 要从 Nacos 配置文件中获取的信息
    @Value("${config.info}")
    private String configInfo;

    @GetMapping("/config/info")
    public String getConfigInfo() {
        return configInfo;
    }

}
