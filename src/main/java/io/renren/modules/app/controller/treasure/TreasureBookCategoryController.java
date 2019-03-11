package io.renren.modules.app.controller.treasure;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;

import io.renren.common.validator.ValidatorUtils;
import io.renren.modules.app.form.TreasureBookCategoryForm;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.renren.modules.app.entity.treasure.TreasureBookCategoryEntity;
import io.renren.modules.app.service.TreasureBookCategoryService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 宠物宝典分类
 *
 * @author fz
 * @email fz@gmail.com
 * @date 2019-03-11 10:41:17
 */
@RestController
@RequestMapping("app/tbcategory")
@Api(tags="宠物宝典分类")
public class TreasureBookCategoryController {
    private final static Logger logger = LoggerFactory.getLogger(TreasureBookCategoryController.class);

    @Autowired
    private TreasureBookCategoryService treasureBookCategoryService;

    /**
     * 列表
     */
    @PostMapping("/list")
    @ApiOperation("获取分类列表")
    @ApiImplicitParam(name="params",value = "分页page从1开始，sidx和order为排序字段非必填（默认按照排序字段orderNum从小大排序）",example = "{\"page\":1,\"limit\":10,\"sidx\":\"id\",\"order\":\"asc\"}")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = treasureBookCategoryService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    @ApiOperation("获取宝典分类详细内容")
    public R info(@PathVariable("id") Long id){
		TreasureBookCategoryEntity treasureBookCategory = treasureBookCategoryService.selectById(id);

        return R.ok().put("treasureBookCategory", treasureBookCategory);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    @ApiOperation("保存宝典分类内容")
    public R save(@RequestBody TreasureBookCategoryForm form){
        ValidatorUtils.validateEntity(form);
        TreasureBookCategoryEntity treasureBookCategory = new TreasureBookCategoryEntity();
        BeanUtils.copyProperties(form,treasureBookCategory);
        treasureBookCategory.setCreateTime(new Date());
		treasureBookCategoryService.insert(treasureBookCategory);

        return R.ok();
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    @ApiOperation("编辑宝典分类内容")
    public R update(@RequestBody TreasureBookCategoryEntity treasureBookCategory){
		treasureBookCategoryService.updateById(treasureBookCategory);

        return R.ok();
    }

    /**
     * 删除
     */
    @GetMapping("/delete")
    @ApiOperation("删除宝典分类")
    public R delete(@RequestBody Long[] ids){
		treasureBookCategoryService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

    /**
     * 分类浏览统计
     */
    @GetMapping("/read/{id}")
    @ApiOperation("分类浏览统计")
    public R read(@PathVariable("id") Long id) {
        TreasureBookCategoryEntity treasureBookCategoryEntity = treasureBookCategoryService.selectById(id);
        if (null != treasureBookCategoryEntity) {
            treasureBookCategoryEntity.setCount(treasureBookCategoryEntity.getCount() + 1);
        }
        treasureBookCategoryService.insertOrUpdate(treasureBookCategoryEntity);
        return R.ok().put("count", treasureBookCategoryEntity.getCount());
    }

}
