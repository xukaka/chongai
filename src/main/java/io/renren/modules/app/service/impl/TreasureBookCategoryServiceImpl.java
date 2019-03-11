package io.renren.modules.app.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.app.dao.treasure.TreasureBookCategoryDao;
import io.renren.modules.app.entity.treasure.TreasureBookCategoryEntity;
import io.renren.modules.app.service.TreasureBookCategoryService;


@Service("treasureBookCategoryService")
public class TreasureBookCategoryServiceImpl extends ServiceImpl<TreasureBookCategoryDao, TreasureBookCategoryEntity> implements TreasureBookCategoryService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<TreasureBookCategoryEntity> page = this.selectPage(
                new Query<TreasureBookCategoryEntity>(params).getPage(),
                new EntityWrapper<TreasureBookCategoryEntity>()
        );

        return new PageUtils(page);
    }

}