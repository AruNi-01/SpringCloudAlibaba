package com.run.sca.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;

public class CustomBlockHandler {
    public static String handleException1(BlockException exception) {
        return "code: 510, msg: 自定义 BlockException 处理";
    }
}
