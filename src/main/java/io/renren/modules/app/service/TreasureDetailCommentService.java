package io.renren.modules.app.service;

import com.baomidou.mybatisplus.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.app.entity.treasure.TreasureDetailCommentEntity;

import java.util.Map;

/**
 * 宠物宝典评论表
 *
 * @author fz
 * @email fz@gmail.com
 * @date 2019-03-12 10:30:59
 */
public interface TreasureDetailCommentService extends IService<TreasureDetailCommentEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

