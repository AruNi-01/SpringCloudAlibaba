package com.run.sca.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.run.sca.handler.CustomBlockHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FlowLimitController {

    @GetMapping("/testA")
    public String testA() {
        return "------------testA";
    }

    @GetMapping("/testB")
    public String testB() {
        return "------------testB";
    }

    @GetMapping("/testHotParams")
    @SentinelResource(value = "testHotParams", blockHandler = "handle_testHotParams")
    public String testHotParams(@RequestParam(value = "p1", required = false) String p1,
                                @RequestParam(value = "p2", required = false) String p2) {
        return "------------testHotParams";
    }
    // 配置热点参数限流触发时的处理方法，不配置则直接将异常信息打到页面
    public String handle_testHotParams(String p1, String p2, BlockException exception) {
        return "------------handle_testHotParams(兜底处理)";
    }

    @GetMapping("/rateLimit/customHandle")
    @SentinelResource(value = "customHandle", blockHandlerClass = CustomBlockHandler.class, blockHandler = "handleException1")
    public String testCustomHandle() {
        return "------------testCustomHandle";
    }

    @GetMapping("/rateLimit/byUrl")
    public String testLimitByUrl() {
        return "------------rateLimitByUrl";
    }

}
