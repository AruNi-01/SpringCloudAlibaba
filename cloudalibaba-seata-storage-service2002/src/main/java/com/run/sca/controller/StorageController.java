package com.run.sca.controller;

import com.run.sca.domain.CommonResult;
import com.run.sca.domain.Storage;
import com.run.sca.service.StorageService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @desc:
 * @author: AarynLu
 * @date: 2023-11-30 16:25
 */
@RestController
public class StorageController {

    @Resource
    private StorageService storageService;

    /**
     * 扣减库存
     */
    @RequestMapping("/storage/decrease")
    public CommonResult decrease(Long productId, Integer count) {
        storageService.decrease(productId, count);
        return new CommonResult(200,"扣减库存成功！");
    }
}
