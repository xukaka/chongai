package io.renren.modules.app.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

/**
 * 用户登录授权表
 * @author xukaijun
 */
@TableName("member_auths")
public class MemberAuths implements Serializable {

    @TableId
    private Long id;

    //关联member表的id
    private Long memberId;

    //登录类型
    private String identityType;

    //登录标识(密码)
    private String identifier;

    //站内toke
    private String toke;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public String getIdentityType() {
        return identityType;
    }

    public void setIdentityType(String identityType) {
        this.identityType = identityType;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getToke() {
        return toke;
    }

    public void setToke(String toke) {
        this.toke = toke;
    }
}
