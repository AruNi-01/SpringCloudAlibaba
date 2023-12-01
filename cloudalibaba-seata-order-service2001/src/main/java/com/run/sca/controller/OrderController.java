package com.run.sca.controller;

import com.run.sca.domain.CommonResult;
import com.run.sca.domain.Order;
import com.run.sca.service.OrderService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @desc:
 * @author: AarynLu
 * @date: 2023-11-30 16:25
 */
@RestController
public class OrderController {

    @Resource
    private OrderService orderService;

    /**
     * 创建订单
     */
    @GetMapping("/order/create")
    public CommonResult create(Order order) {
        orderService.create(order);
        return new CommonResult(200, "订单创建成功!");
    }

}
