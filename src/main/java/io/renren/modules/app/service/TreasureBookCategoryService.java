package io.renren.modules.app.service;

import com.baomidou.mybatisplus.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.app.entity.treasure.TreasureBookCategoryEntity;

import java.util.Map;

/**
 * 宠物宝典分类表
 *
 * @author fz
 * @email fz@gmail.com
 * @date 2019-03-11 10:34:08
 */
public interface TreasureBookCategoryService extends IService<TreasureBookCategoryEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

