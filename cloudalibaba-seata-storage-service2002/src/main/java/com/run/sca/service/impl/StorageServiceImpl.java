package com.run.sca.service.impl;

import com.run.sca.dao.StorageDao;
import com.run.sca.service.StorageService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


/**
 * @desc:
 * @author: AarynLu
 * @date: 2023-11-30 16:08
 */
@Service
@Slf4j
public class StorageServiceImpl implements StorageService {

    @Resource
    private StorageDao storageDao;

    /**
     * 扣减库存
     */
    @Override
    public void decrease(Long productId, Integer count) {
        log.info("------->storage-service中扣减库存开始");
        storageDao.decrease(productId,count);
        log.info("------->storage-service中扣减库存结束");
    }

}
