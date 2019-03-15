package io.renren.modules.app.form;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * 宠物宝典评论表
 * 
 * @author fz
 * @email fz@gmail.com
 * @date 2019-03-12 10:30:59
 */
@ApiModel
public class TreasureDetailCommentForm implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 评论ID
	 */
    @ApiModelProperty(value = "评论ID",example = "")
	private Long id;
	/**
	 * 宠物宝典ID
	 */
    @ApiModelProperty(value = "宠物宝典ID",example = "")
	private Long detailId;
	/**
	 * 品论内容
	 */
    @ApiModelProperty(value = "品论内容",example = "")
	private String content;
	/**
	 * 评论者openid
	 */
    @ApiModelProperty(value = "评论者openid",example = "")
	private String fromOpenid;
	/**
	 * 点赞数
	 */
    @ApiModelProperty(value = "点赞数",example = "")
	private Long likeCount;

	/**
	 * 设置：评论ID
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：评论ID
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：宠物宝典ID
	 */
	public void setDetailId(Long detailId) {
		this.detailId = detailId;
	}
	/**
	 * 获取：宠物宝典ID
	 */
	public Long getDetailId() {
		return detailId;
	}
	/**
	 * 设置：品论内容
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * 获取：品论内容
	 */
	public String getContent() {
		return content;
	}
	/**
	 * 设置：评论者openid
	 */
	public void setFromOpenid(String fromOpenid) {
		this.fromOpenid = fromOpenid;
	}
	/**
	 * 获取：评论者openid
	 */
	public String getFromOpenid() {
		return fromOpenid;
	}
	/**
	 * 设置：点赞数
	 */
	public void setLikeCount(Long likeCount) {
		this.likeCount = likeCount;
	}
	/**
	 * 获取：点赞数
	 */
	public Long getLikeCount() {
		return likeCount;
	}

}
