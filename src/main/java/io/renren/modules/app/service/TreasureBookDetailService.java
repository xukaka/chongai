package io.renren.modules.app.service;

import com.baomidou.mybatisplus.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.app.entity.treasure.TreasureBookDetailEntity;

import java.util.Map;

/**
 * 宠物宝典的详情
 *
 * @author fz
 * @email fz@gmail.com
 * @date 2019-03-11 10:34:08
 */
public interface TreasureBookDetailService extends IService<TreasureBookDetailEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

