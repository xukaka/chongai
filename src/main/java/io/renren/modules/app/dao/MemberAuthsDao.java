package io.renren.modules.app.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import io.renren.modules.app.entity.Member;
import io.renren.modules.app.entity.MemberAuths;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 用户授权表
 * @author xukaijun
 */
@Mapper
public interface MemberAuthsDao extends BaseMapper<MemberAuths> {
     MemberAuths queryByTypeAndIdentifier(@Param("identityType") String type,@Param("identifier") String identifier);
}
