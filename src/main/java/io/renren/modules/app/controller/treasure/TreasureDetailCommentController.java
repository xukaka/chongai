package io.renren.modules.app.controller.treasure;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import io.renren.common.validator.ValidatorUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;

import io.renren.modules.app.form.TreasureDetailCommentForm;
import io.renren.modules.app.entity.treasure.TreasureDetailCommentEntity;
import io.renren.modules.app.service.TreasureDetailCommentService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 宠物宝典评论表
 *
 * @author fz
 * @email fz@gmail.com
 * @date 2019-03-12 10:30:59
 */
@RestController
@RequestMapping("app/treasuredetailcomment")
@Api(tags= "宠物宝典评论表")
public class TreasureDetailCommentController {
    private final static Logger logger = LoggerFactory.getLogger(TreasureDetailCommentController.class);

    @Autowired
    private TreasureDetailCommentService treasureDetailCommentService;

    /**
     * 宠物宝典评论表列表
     */
    @PostMapping("/list")
    @ApiOperation("获取宠物宝典评论表列表")
    @ApiImplicitParam(name="params",value = "分页page从1开始，sidx和order为排序字段非必填（默认按照排序字段orderNum从小大排序）",example = "{\"page\":1,\"limit\":10,\"sidx\":\"id\",\"order\":\"asc\"}")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = treasureDetailCommentService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 宠物宝典评论表信息
     */
    @GetMapping("/info/{id}")
    @ApiOperation("获取宠物宝典评论表详细内容")
    public R info(@PathVariable("id") Long id){
		TreasureDetailCommentEntity treasureDetailComment = treasureDetailCommentService.selectById(id);

        return R.ok().put("treasureDetailComment", treasureDetailComment);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    @ApiOperation("保存宠物宝典评论表")
    public R save(@RequestBody TreasureDetailCommentForm form){
        ValidatorUtils.validateEntity(form);
        TreasureDetailCommentEntity treasureDetailComment = new TreasureDetailCommentEntity();
        BeanUtils.copyProperties(form,treasureDetailComment);
		treasureDetailCommentService.insert(treasureDetailComment);
        return R.ok();
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    @ApiOperation("编辑宠物宝典评论表内容")
    public R update(@RequestBody TreasureDetailCommentEntity treasureDetailComment){
		treasureDetailCommentService.updateById(treasureDetailComment);

        return R.ok();
    }

    /**
     * 删除
     */
    @GetMapping("/delete")
    @ApiOperation("删除宠物宝典评论表")
    public R delete(@RequestBody Long[] ids){
		treasureDetailCommentService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

    /**
     * 点赞统计
     */
    @GetMapping("/like/{id}")
    @ApiOperation("点赞统计")
    public R like(@PathVariable("id") Long id) {
        TreasureDetailCommentEntity treasureDetailCommentEntity = treasureDetailCommentService.selectById(id);
        if (null != treasureDetailCommentEntity) {
            treasureDetailCommentEntity.setLikeCount(treasureDetailCommentEntity.getLikeCount() + 1);
        }
        treasureDetailCommentService.insertOrUpdate(treasureDetailCommentEntity);
        return R.ok().put("lickCount", treasureDetailCommentEntity.getLikeCount());
    }

}
