package com.lgy.gulimall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lgy.common.utils.PageUtils;
import com.lgy.gulimall.product.entity.SpuCommentEntity;

import java.util.Map;

/**
 * 商品评价
 *
 * @author LGY
 * @email dlutlgy@163com
 * @date 2022-04-25 14:40:06
 */
public interface SpuCommentService extends IService<SpuCommentEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

