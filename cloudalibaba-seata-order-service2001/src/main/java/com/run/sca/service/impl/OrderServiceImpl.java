package com.run.sca.service.impl;

import com.run.sca.dao.OrderDao;
import com.run.sca.domain.Order;
import com.run.sca.service.AccountService;
import com.run.sca.service.OrderService;
import com.run.sca.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import jakarta.annotation.Resource;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


/**
 * @desc:
 * @author: AarynLu
 * @date: 2023-11-30 16:08
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderDao orderDao;

    @Resource
    private AccountService accountService;

    @Resource
    private StorageService storageService;


    /**
     * 创建订单->调用库存服务扣减库存->调用账户服务扣减账户余额->修改订单状态
     * 简单说：下订单->减库存->减余额->改状态
     */
    @Override
    // Seata 开启分布式事务
    @GlobalTransactional(name = "seata-order-service:createOrder", rollbackFor = Exception.class)
    public void create(Order order) {
        log.info("------->下单开始");

        // 1. 本应用创建订单
        orderDao.create(order);

        // 2. 远程调用库存服务扣减库存
        log.info("------->order-service中扣减库存开始");
        storageService.decrease(order.getProductId(), order.getCount());
        log.info("------->order-service中扣减库存结束");

        // 3. 远程调用账户服务扣减余额
        log.info("------->order-service中扣减余额开始");
        accountService.decrease(order.getUserId(), order.getMoney());
        log.info("------->order-service中扣减余额结束");

        // 4. 修改订单状态为已完成
        log.info("------->order-service中修改订单状态开始");
        orderDao.update(order.getUserId(), 0);
        log.info("------->order-service中修改订单状态结束");

        log.info("------->下单结束");
    }
}
