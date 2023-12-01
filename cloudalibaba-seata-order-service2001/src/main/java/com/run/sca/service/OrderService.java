package com.run.sca.service;

import com.run.sca.domain.Order;

/**
 * @desc:
 * @author: AarynLu
 * @date: 2023-11-30 16:07
 */
public interface OrderService {

    /**
     * 创建订单
     */
    void create(Order order);
}