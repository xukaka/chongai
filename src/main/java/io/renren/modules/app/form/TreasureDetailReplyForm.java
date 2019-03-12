package io.renren.modules.app.form;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * 宠物宝典回复表
 * 
 * @author fz
 * @email fz@gmail.com
 * @date 2019-03-12 10:30:58
 */
@ApiModel
public class TreasureDetailReplyForm implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 回复表id
	 */
    @ApiModelProperty(value = "回复表id",example = "")
	private Long id;
	/**
	 * 评论id
	 */
    @ApiModelProperty(value = "评论id",example = "")
	private Long commentId;
	/**
	 * 回复内容
	 */
    @ApiModelProperty(value = "回复内容",example = "")
	private String content;
	/**
	 * 回复用户id
	 */
    @ApiModelProperty(value = "回复用户id",example = "")
	private String fromOpenid;
	/**
	 * 回复目标id
	 */
    @ApiModelProperty(value = "回复目标id",example = "")
	private String toOpenid;
	/**
	 * 点赞数
	 */
    @ApiModelProperty(value = "点赞数",example = "")
	private Long likeCount;


	/**
	 * 设置：回复表id
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：回复表id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：评论id
	 */
	public void setCommentId(Long commentId) {
		this.commentId = commentId;
	}
	/**
	 * 获取：评论id
	 */
	public Long getCommentId() {
		return commentId;
	}
	/**
	 * 设置：回复内容
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * 获取：回复内容
	 */
	public String getContent() {
		return content;
	}
	/**
	 * 设置：回复用户id
	 */
	public void setFromOpenid(String fromOpenid) {
		this.fromOpenid = fromOpenid;
	}
	/**
	 * 获取：回复用户id
	 */
	public String getFromOpenid() {
		return fromOpenid;
	}
	/**
	 * 设置：回复目标id
	 */
	public void setToOpenid(String toOpenid) {
		this.toOpenid = toOpenid;
	}
	/**
	 * 获取：回复目标id
	 */
	public String getToOpenid() {
		return toOpenid;
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
