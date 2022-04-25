package com.lgy.gulimall.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lgy.common.utils.PageUtils;
import com.lgy.gulimall.coupon.entity.SkuLadderEntity;

import java.util.Map;

/**
 * 商品阶梯价格
 *
 * @author LGY
 * @email dlutlgy@163com
 * @date 2022-04-25 16:40:26
 */
public interface SkuLadderService extends IService<SkuLadderEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

