package io.renren.modules.app.service.impl;


import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.renren.modules.app.dao.MemberAuthsDao;
import io.renren.modules.app.entity.MemberAuths;
import io.renren.modules.app.service.MemberAuthsService;
import org.springframework.stereotype.Service;


@Service("MemberAuthsService")
public class MemberAuthsServiceImpl extends ServiceImpl<MemberAuthsDao, MemberAuths> implements MemberAuthsService {

    @Override
    public MemberAuths queryByTypeAndIdentifier(String identityType,String identifier) {
        return baseMapper.queryByTypeAndIdentifier(identityType,identifier);
    }
}
