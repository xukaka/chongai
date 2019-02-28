package io.renren.modules.app.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import io.renren.modules.app.entity.Member;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户表
 * @author xukaijun
 */
@Mapper
public interface MemberDao extends BaseMapper<Member> {

}
