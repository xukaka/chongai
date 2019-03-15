package io.renren.modules.app.dao.friend;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import io.renren.modules.app.dto.CommentDto;
import io.renren.modules.app.entity.friend.FriendShareCommentEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

/**
 * @author xukaijun
 * @email 383635738@qq.com
 * @date 2019-03-02 09:38:43
 */
@Mapper
public interface FriendShareCommentDao extends BaseMapper<FriendShareCommentEntity> {

    List<CommentDto> getPage(HashMap params);

    List<CommentDto> querySubThroughParentId(@Param("fsmId") Long fsmId,@Param("parentId") Long parentId);
	
}
