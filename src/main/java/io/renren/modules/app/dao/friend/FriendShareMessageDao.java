package io.renren.modules.app.dao.friend;

import io.renren.modules.app.entity.friend.FriendShareMessageEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

/**
 * @author xukaijun
 * @email 383635738@qq.com
 * @date 2019-03-02 09:38:43
 */
@Mapper
public interface FriendShareMessageDao extends BaseMapper<FriendShareMessageEntity> {
	List<FriendShareMessageEntity> getPage(HashMap<String,Object> param);

	FriendShareMessageEntity getById(Long id);
}
