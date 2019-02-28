package io.renren.modules.app.controller;


import com.alibaba.fastjson.JSON;
import io.renren.common.exception.RRException;
import io.renren.common.utils.R;
import io.renren.common.validator.ValidatorUtils;
import io.renren.modules.app.entity.Member;
import io.renren.modules.app.entity.MemberAuths;
import io.renren.modules.app.form.LoginForm;
import io.renren.modules.app.form.RegisterForm;
import io.renren.modules.app.service.MemberAuthsService;
import io.renren.modules.app.service.MemberService;
import io.renren.modules.app.utils.JwtUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 注册
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-03-26 17:27
 */
@RestController
@RequestMapping("/app")
@Api(tags = "APP用户注册接口")
public class AppRegisterController {
    private final static Logger logger = LoggerFactory.getLogger(AppRegisterController.class);

    @Autowired
    private MemberService memberService;

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private MemberAuthsService memberAuthsService;

    @PostMapping("register")
    @ApiOperation("注册")
    public R register(@RequestBody RegisterForm form){
        logger.info("[AppRegisterController.register] request param:{}", JSON.toJSONString(form));
        //表单校验
        ValidatorUtils.validateEntity(form);

        Member member = new Member();
        BeanUtils.copyProperties(form,member);
        member.setCreateTime(new Date());

        MemberAuths auths = new MemberAuths();
        auths.setIdentifier(DigestUtils.sha256Hex(form.getIdentifier()));
        auths.setIdentityType(form.getIdentityType());

        memberService.registerMemberWithAuth(member,auths);

        return R.ok();
    }

    /**
     * 登录
     */
    @PostMapping("login")
    @ApiOperation("登录")
    public R login(@RequestBody LoginForm form){
        //表单校验
        ValidatorUtils.validateEntity(form);

        //用户登录
        MemberAuths auths = memberAuthsService.queryByIdentifier(DigestUtils.sha256Hex(form.getIdentifier()));
        if(ObjectUtils.isEmpty(auths)){
            throw new RRException("密码或唯一身份标识错误");
        }
        if(auths.getIdentityType().equals(form.getIdentityType())){
            throw new RRException("登录方式有误");
        }
        //生成token
        String token = jwtUtils.generateToken(auths.getMemberId());

        Map<String, Object> map = new HashMap<>();
        map.put("token", token);
        map.put("memberId", auths.getMemberId());

        return R.ok(map);
    }
}
