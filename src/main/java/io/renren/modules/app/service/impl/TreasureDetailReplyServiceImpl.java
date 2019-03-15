package io.renren.modules.app.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.app.dao.treasure.TreasureDetailReplyDao;
import io.renren.modules.app.entity.treasure.TreasureDetailReplyEntity;
import io.renren.modules.app.service.TreasureDetailReplyService;


@Service("treasureDetailReplyService")
public class TreasureDetailReplyServiceImpl extends ServiceImpl<TreasureDetailReplyDao, TreasureDetailReplyEntity> implements TreasureDetailReplyService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<TreasureDetailReplyEntity> page = this.selectPage(
                new Query<TreasureDetailReplyEntity>(params).getPage(),
                new EntityWrapper<TreasureDetailReplyEntity>()
        );

        return new PageUtils(page);
    }

}