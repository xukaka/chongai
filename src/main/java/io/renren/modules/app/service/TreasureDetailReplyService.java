package io.renren.modules.app.service;

import com.baomidou.mybatisplus.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.app.entity.treasure.TreasureDetailReplyEntity;

import java.util.Map;

/**
 * 宠物宝典回复表
 *
 * @author fz
 * @email fz@gmail.com
 * @date 2019-03-12 10:30:58
 */
public interface TreasureDetailReplyService extends IService<TreasureDetailReplyEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

