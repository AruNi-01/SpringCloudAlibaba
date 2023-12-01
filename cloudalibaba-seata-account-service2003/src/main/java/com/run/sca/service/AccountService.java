package com.run.sca.service;

import com.run.sca.domain.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * @desc: 使用 Feign 调用 account 服务
 * @author: AarynLu
 * @date: 2023-11-30 16:10
 */
public interface AccountService {

    /**
     * 扣减账户余额
     *
     * @param userId 用户id
     * @param money  金额
     */
    void decrease(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money);
}
