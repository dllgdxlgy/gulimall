package com.lgy.gulimall.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lgy.common.utils.PageUtils;
import com.lgy.gulimall.coupon.entity.SeckillSessionEntity;

import java.util.Map;

/**
 * 秒杀活动场次
 *
 * @author LGY
 * @email dlutlgy@163com
 * @date 2022-04-25 16:40:26
 */
public interface SeckillSessionService extends IService<SeckillSessionEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

