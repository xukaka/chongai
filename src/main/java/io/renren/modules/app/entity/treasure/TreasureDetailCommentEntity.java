package io.renren.modules.app.entity.treasure;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 宠物宝典评论表
 * 
 * @author fz
 * @email fz@gmail.com
 * @date 2019-03-12 10:30:59
 */
@TableName("p_treasure_detail_comment")
public class TreasureDetailCommentEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 评论ID
	 */
	@TableId
	private Long id;
	/**
	 * 宠物宝典ID
	 */
	private Long detailId;
	/**
	 * 品论内容
	 */
	private String content;
	/**
	 * 评论者openid
	 */
	private String fromOpenid;

	/**
	 * 回复数
	 */
	private Long replyCount = 0l;

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

	public Long getReplyCount() {
		return replyCount;
	}

	public void setReplyCount(Long replyCount) {
		this.replyCount = replyCount;
	}
}
