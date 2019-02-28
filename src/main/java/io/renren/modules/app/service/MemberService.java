package io.renren.modules.app.service;


import com.baomidou.mybatisplus.service.IService;
import io.renren.modules.app.entity.Member;
import io.renren.modules.app.entity.MemberAuths;
import io.renren.modules.app.form.LoginForm;

/**
 * 用户
 * @author xukaijun
 */
public interface MemberService extends IService<Member> {

	/**
	 * 同时写入member表和member_auths表
	 */
	void registerMemberWithAuth(Member member, MemberAuths auths);

}
