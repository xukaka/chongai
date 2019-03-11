package io.renren.modules.app.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.app.dao.treasure.TreasureBookDetailDao;
import io.renren.modules.app.entity.treasure.TreasureBookDetailEntity;
import io.renren.modules.app.service.TreasureBookDetailService;


@Service("treasureBookDetailService")
public class TreasureBookDetailServiceImpl extends ServiceImpl<TreasureBookDetailDao, TreasureBookDetailEntity> implements TreasureBookDetailService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<TreasureBookDetailEntity> page = this.selectPage(
                new Query<TreasureBookDetailEntity>(params).getPage(),
                new EntityWrapper<TreasureBookDetailEntity>()
        );

        return new PageUtils(page);
    }

}