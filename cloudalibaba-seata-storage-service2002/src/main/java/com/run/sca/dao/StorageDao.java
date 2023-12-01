package com.run.sca.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @desc:
 * @author: AarynLu
 * @date: 2023-11-30 15:34
 */
@Mapper
public interface StorageDao {

    /**
     * 扣减库存
     */
    void decrease(@Param("productId") Long productId, @Param("count") Integer count);

}
