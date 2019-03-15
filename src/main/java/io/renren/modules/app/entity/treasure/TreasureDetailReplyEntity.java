package io.renren.modules.app.entity.treasure;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 宠物宝典回复表
 * 
 * @author fz
 * @email fz@gmail.com
 * @date 2019-03-12 10:30:58
 */
@TableName("p_treasure_detail_reply")
public class TreasureDetailReplyEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 回复表id
	 */
	@TableId
	private Long id;
	/**
	 * 评论id
	 */
	private Long commentId;
	/**
	 * 回复内容
	 */
	private String content;
	/**
	 * 回复用户id
	 */
	private String fromOpenid;
	/**
	 * 回复目标id
	 */
	private String toOpenid;
	/**
	 * 点赞数
	 */
	private Long likeCount;

	/**
	 * 状态（0正常 -1屏蔽）
	 */
	private int status = 0;

	/**
	 * 创建时间
	 */
	private Date createTime;

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
	/**
	 * 设置：创建时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getCreateTime() {
		return createTime;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
}
