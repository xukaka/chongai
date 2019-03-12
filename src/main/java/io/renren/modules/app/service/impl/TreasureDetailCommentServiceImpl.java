package io.renren.modules.app.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.app.dao.treasure.TreasureDetailCommentDao;
import io.renren.modules.app.entity.treasure.TreasureDetailCommentEntity;
import io.renren.modules.app.service.TreasureDetailCommentService;


@Service("treasureDetailCommentService")
public class TreasureDetailCommentServiceImpl extends ServiceImpl<TreasureDetailCommentDao, TreasureDetailCommentEntity> implements TreasureDetailCommentService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<TreasureDetailCommentEntity> page = this.selectPage(
                new Query<TreasureDetailCommentEntity>(params).getPage(),
                new EntityWrapper<TreasureDetailCommentEntity>()
        );

        return new PageUtils(page);
    }

}