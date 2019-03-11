package io.renren.modules.app.controller.friend;

import java.util.Arrays;
import java.util.Map;

import io.swagger.annotations.Api;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
@RequestMapping("app/comment")
@Api(tags = "用户评论相关")
public class FriendShareCommentController {
    @Autowired
    private FriendShareCommentService friendShareCommentService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = friendShareCommentService.queryPage(params);
        return R.ok().put("page", page);
    }

    /**
     * 信息
     */
    @RequestMapping("/info")
    public R info(Long id){
        FriendShareCommentEntity friendShareComment = friendShareCommentService.selectById(id);
        return R.ok().put("comment", friendShareComment);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody FriendShareCommentEntity friendShareComment){
			friendShareCommentService.insert(friendShareComment);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody FriendShareCommentEntity friendShareComment){
			friendShareCommentService.updateById(friendShareComment);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        friendShareCommentService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
