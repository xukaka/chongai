package io.renren.modules.app.controller.friend;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import io.renren.common.utils.JsonUtil;
import io.renren.modules.app.dto.CommentDto;
import io.renren.modules.app.form.PageWrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import io.renren.modules.app.entity.friend.FriendShareCommentEntity;
import io.renren.modules.app.service.FriendShareCommentService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 评论
 * @author xukaijun
 * @email 383635738@qq.com
 * @date 2019-03-02 09:38:43
 */
@RestController
@RequestMapping("app/fs/comment")
@Api(tags = "用户评论相关")
public class FriendShareCommentController {
    private final static Logger logger = LoggerFactory.getLogger(FriendShareCommentController.class);

    @Autowired
    private FriendShareCommentService friendShareCommentService;

    /**
     * 列表
     */
    @PostMapping("/list")
    @ApiOperation("获取当前动态资讯下的评论列表")
    public R list(@RequestParam Map<String, Object> params){
        logger.info("[FriendShareCommentController.list] 请求参数："+params);
        PageWrapper page = new PageWrapper(params);
        if (StringUtils.isEmpty(page.get("fsmId"))){
            R.error("fsmId must be not null");
        }
        List<CommentDto> list = friendShareCommentService.getPage(page);
        //级联获取子评论
        recycleSubComment(list);

        return R.ok().put("data", list)
                .put("page",page.getCurrPage())
                .put("size",page.getPageSize());
    }

    /**
     * 信息
     */
    @GetMapping("/info")
    @ApiOperation("获取评论详情")
    public R info(Long id){
        logger.info("[FriendShareCommentController.info] 请求参数id={}",id);
        FriendShareCommentEntity friendShareComment = friendShareCommentService.selectById(id);
        return R.ok().put("data", friendShareComment);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    @ApiOperation("保存评论")
    public R save(@RequestBody FriendShareCommentEntity friendShareComment){
        logger.info("[FriendShareCommentController.save] 请求参数={}", JsonUtil.Java2Json(friendShareComment));
        friendShareComment.setCreateTime(System.currentTimeMillis());
        friendShareCommentService.insert(friendShareComment);

        return R.ok();
    }

    /**
     * 修改
     */
    @GetMapping("/update")
    @ApiOperation("更新操作")
    public R update(@RequestBody FriendShareCommentEntity friendShareComment){
        logger.info("[FriendShareCommentController.update] 请求参数={}",friendShareComment);
        friendShareCommentService.updateById(friendShareComment);
        return R.ok();
    }

    /**
     * 删除
     */
    @GetMapping("/delete")
    @ApiOperation("删除")
    public R delete(Long id){
        logger.info("[FriendShareCommentController.delete] 请求参数id={}",id);
        friendShareCommentService.deleteById(id);

        return R.ok();
    }

    public void recycleSubComment(List<CommentDto> commentDtoList){
        for(CommentDto commentDto : commentDtoList){
            List<CommentDto> commentDtos = friendShareCommentService.querySubThroughParentId(commentDto.getFsmId(), commentDto.getId());
            if(!CollectionUtils.isEmpty(commentDtos)){
                commentDto.setSubComment(commentDtos);
                recycleSubComment(commentDtos);
            }
        }
    }

}
