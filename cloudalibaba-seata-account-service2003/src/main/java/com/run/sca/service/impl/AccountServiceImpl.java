package com.run.sca.service.impl;

import com.run.sca.dao.AccountDao;
import com.run.sca.service.AccountService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;


/**
 * @desc:
 * @author: AarynLu
 * @date: 2023-11-30 16:08
 */
@Service
@Slf4j
public class AccountServiceImpl implements AccountService {

    @Resource
    AccountDao accountDao;

    /**
     * 扣减账户余额
     */
    @Override
    public void decrease(Long userId, BigDecimal money) {
        log.info("------->account-service中扣减账户余额开始");
        // sleep 10s 模拟超时异常（在调用方设置了 OpenFeign 请求处理超时时间是 3s），全局事务回滚
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        accountDao.decrease(userId, money);
        log.info("------->account-service中扣减账户余额结束");
    }
}
