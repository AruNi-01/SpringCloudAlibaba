package com.run.sca.service;

import com.run.sca.domain.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @desc: 使用 Feign 调用 storage 服务
 * @author: AarynLu
 * @date: 2023-11-30 16:10
 */
public interface StorageService {
    /**
     * 扣减库存
     */
    void decrease(Long productId, Integer count);
}
