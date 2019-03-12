package io.renren.modules.app.controller.treasure;

import java.util.Arrays;
import java.util.Map;

import io.renren.modules.app.entity.treasure.TreasureDetailCommentEntity;
import io.renren.modules.app.service.TreasureDetailCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import io.renren.common.validator.ValidatorUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;

import io.renren.modules.app.form.TreasureDetailReplyForm;
import io.renren.modules.app.entity.treasure.TreasureDetailReplyEntity;
import io.renren.modules.app.service.TreasureDetailReplyService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 宠物宝典回复表
 *
 * @author fz
 * @email fz@gmail.com
 * @date 2019-03-12 10:30:58
 */
@RestController
@RequestMapping("app/treasuredetailreply")
@Api(tags= "宠物宝典回复表")
public class TreasureDetailReplyController {
    private final static Logger logger = LoggerFactory.getLogger(TreasureDetailReplyController.class);

    @Autowired
    private TreasureDetailReplyService treasureDetailReplyService;

    @Autowired
    private TreasureDetailCommentService treasureDetailCommentService;

    /**
     * 宠物宝典回复表列表
     */
    @PostMapping("/list")
    @ApiOperation("获取宠物宝典回复表列表")
    @ApiImplicitParam(name="params",value = "分页page从1开始，sidx和order为排序字段非必填（默认按照排序字段orderNum从小大排序）",example = "{\"page\":1,\"limit\":10,\"sidx\":\"id\",\"order\":\"asc\"}")
    public R list(@RequestParam Map<String, Object> params){
        params.put("status",0);
        PageUtils page = treasureDetailReplyService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 宠物宝典回复表信息
     */
    @GetMapping("/info/{id}")
    @ApiOperation("获取宠物宝典回复表详细内容")
    public R info(@PathVariable("id") Long id){
		TreasureDetailReplyEntity treasureDetailReply = treasureDetailReplyService.selectById(id);

        return R.ok().put("treasureDetailReply", treasureDetailReply);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    @ApiOperation("保存宠物宝典回复表")
    public R save(@RequestBody TreasureDetailReplyForm form){
        ValidatorUtils.validateEntity(form);
        TreasureDetailReplyEntity treasureDetailReply = new TreasureDetailReplyEntity();
        BeanUtils.copyProperties(form,treasureDetailReply);
		treasureDetailReplyService.insert(treasureDetailReply);

		//更新评论回复数
        Long commentId = treasureDetailReply.getCommentId();
        TreasureDetailCommentEntity treasureDetailCommentEntity = treasureDetailCommentService.selectById(commentId);
        treasureDetailCommentEntity.setReplyCount(treasureDetailCommentEntity.getReplyCount()+1);
        treasureDetailCommentService.insertOrUpdate(treasureDetailCommentEntity);
        return R.ok();
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    @ApiOperation("编辑宠物宝典回复表内容")
    public R update(@RequestBody TreasureDetailReplyEntity treasureDetailReply){
		treasureDetailReplyService.updateById(treasureDetailReply);

        return R.ok();
    }

    /**
     * 删除
     */
    @GetMapping("/delete")
    @ApiOperation("删除宠物宝典回复表")
    public R delete(@RequestBody Long[] ids){
		treasureDetailReplyService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

    /**
     * 点赞统计
     */
    @GetMapping("/like/{id}")
    @ApiOperation("点赞统计")
    public R like(@PathVariable("id") Long id) {
        TreasureDetailReplyEntity treasureDetailReplyEntity = treasureDetailReplyService.selectById(id);
        if (null != treasureDetailReplyEntity) {
            treasureDetailReplyEntity.setLikeCount(treasureDetailReplyEntity.getLikeCount() + 1);
        }
        treasureDetailReplyService.insertOrUpdate(treasureDetailReplyEntity);
        return R.ok().put("lickCount", treasureDetailReplyEntity.getLikeCount());
    }

}
