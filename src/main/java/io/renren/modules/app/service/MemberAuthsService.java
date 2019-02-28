package io.renren.modules.app.service;


import com.baomidou.mybatisplus.service.IService;
import io.renren.modules.app.entity.MemberAuths;

/**
 * 用户授权
 * @author xukaijun
 */
public interface MemberAuthsService extends IService<MemberAuths> {

    MemberAuths queryByIdentifier(String identifier);
}
