package io.renren.modules.app.controller.treasure;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;

import io.renren.common.validator.ValidatorUtils;
import io.renren.modules.app.form.TreasureBookDetailForm;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.renren.modules.app.entity.treasure.TreasureBookDetailEntity;
import io.renren.modules.app.service.TreasureBookDetailService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;


/**
 * 宠物宝典的详情
 *
 * @author fz
 * @email fz@gmail.com
 * @date 2019-03-11 10:41:16
 */
@RestController
@RequestMapping("app/tbdetail")
@Api(tags = "宠物宝典详情")
public class TreasureBookDetailController {
    private final static Logger logger = LoggerFactory.getLogger(TreasureBookDetailController.class);

    @Autowired
    private TreasureBookDetailService treasureBookDetailService;

    /**
     * 列表
     */
    @PostMapping("/list")
    @ApiOperation("获取详情列表")
    @ApiImplicitParam(name = "params", value = "分页page从1开始，sidx和order为排序字段非必填（默认按照排序字段orderNum从小大排序）", example = "{\"page\":1,\"limit\":10,\"sidx\":\"id\",\"order\":\"asc\"}")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = treasureBookDetailService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    @ApiOperation("获取宝典详情内容")
    public R info(@PathVariable("id") Long id) {
        TreasureBookDetailEntity treasureBookDetail = treasureBookDetailService.selectById(id);

        return R.ok().put("treasureBookDetail", treasureBookDetail);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    @ApiOperation("保存宝典详情内容")
    public R save(@RequestBody TreasureBookDetailForm form) {
        ValidatorUtils.validateEntity(form);
        TreasureBookDetailEntity treasureBookDetail = new TreasureBookDetailEntity();
        BeanUtils.copyProperties(form, treasureBookDetail);
        treasureBookDetail.setCreateTime(new Date());
        treasureBookDetailService.insert(treasureBookDetail);
        return R.ok();
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    @ApiOperation("编辑宝典详情内容")
    public R update(@RequestBody TreasureBookDetailEntity treasureBookDetail) {
        treasureBookDetailService.updateById(treasureBookDetail);

        return R.ok();
    }

    /**
     * 删除
     */
    @GetMapping("/delete")
    @ApiOperation("删除宝典分详情")
    public R delete(@RequestBody Long[] ids) {
        treasureBookDetailService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

    /**
     * 点赞统计
     */
    @GetMapping("/like/{id}")
    @ApiOperation("点赞统计")
    public R like(@PathVariable("id") Long id) {
        TreasureBookDetailEntity treasureBookDetailEntity = treasureBookDetailService.selectById(id);
        if (null != treasureBookDetailEntity) {
            treasureBookDetailEntity.setLikeCount(treasureBookDetailEntity.getLikeCount() + 1);
        }
        treasureBookDetailService.insertOrUpdate(treasureBookDetailEntity);
        return R.ok().put("lickCount", treasureBookDetailEntity.getLikeCount());
    }

    /**
     * 阅读统计
     */
    @GetMapping("/read/{id}")
    @ApiOperation("阅读统计")
    public R read(@PathVariable("id") Long id) {
        TreasureBookDetailEntity treasureBookDetailEntity = treasureBookDetailService.selectById(id);
        if (null != treasureBookDetailEntity) {
            treasureBookDetailEntity.setReadCount(treasureBookDetailEntity.getReadCount() + 1);
        }
        treasureBookDetailService.insertOrUpdate(treasureBookDetailEntity);
        return R.ok().put("readCount", treasureBookDetailEntity.getReadCount());
    }


}
