package io.renren.modules.app.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import io.renren.modules.app.entity.Member;
import io.renren.modules.app.entity.MemberAuths;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户授权表
 * @author xukaijun
 */
@Mapper
public interface MemberAuthsDao extends BaseMapper<MemberAuths> {
     MemberAuths queryByIdentifier(String identifier);
}
