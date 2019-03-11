package io.renren.modules.app.form;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * 宠物宝典的详情
 * 
 * @author fz
 * @email fz@gmail.com
 * @date 2019-03-11 10:34:08
 */
@ApiModel(value = "宠物宝典的详情表单")
public class TreasureBookDetailForm implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 宠物宝典详情ID
	 */
	@ApiModelProperty(value = "宠物宝典详情ID",example = "1")
	private Long id;
	/**
	 * 所属分类
	 */
	@ApiModelProperty(value = "所属分类",example = "1")
	@NotNull(message="所属分类不能为空")
	private Long categoryId;
	/**
	 * 宝典详情名称
	 */
	@ApiModelProperty(value = "宝典详情",example = "如何饲养萨摩耶幼犬？")
	@NotBlank(message="宝典详情名称不能为空")
	private String tittle;
	/**
	 * 封面图片
	 */
	@ApiModelProperty(value = "封面图片",example = "https://test-1254210782.cos.ap-chengdu.myqcloud.com/yq.jpg")
	@NotBlank(message="封面图片不能为空")
	private String coverPic;
	/**
	 * 作者
	 */
	@ApiModelProperty(value = "作者",example = "fz")
	private String author;
	/**
	 * 宝典详细内容
	 */
	@ApiModelProperty(value = "宝典详细内容",example = "如何饲养萨摩耶幼犬？对于萨摩耶来说，它刚生下来是最难喂养的。刚生下来时身体器官都是比较脆弱的，并且在两个月之内都要通过母乳来增加营养，如果母乳无法提供就只能借助人工喂养来增加营养，但千万不要把我们喝的牛奶当作母乳来喂养萨摩耶小狗狗，可能会造成小狗狗对牛奶过敏，还可能会拉稀。在萨摩耶幼犬处于二至七个月之间时，它的牙齿养狗都长好了，主人就可以开始把母乳换成狗粮来喂养，但换狗粮时要慢慢来，可以先用母乳泡")
	@NotBlank(message="宝典详细内容不能为空")
	private String detail;
	/**
	 * 状态（0发布 -1删除）
	 */
	@ApiModelProperty(value = "状态（0发布 -1删除）",example = "0")
	private Integer status;
	/**
	 * 序号（从小到大）
	 */
	@ApiModelProperty(value = "序号（从小到大）",example = "0")
	private Integer orderNum;
	/**
	 * 阅读数
	 */
	@ApiModelProperty(value = "阅读数",example = "0")
	private Long readCount;
	/**
	 * 点赞数
	 */
	@ApiModelProperty(value = "点赞数",example = "0")
	private Long likeCount;
	/**
	 * 创建者ID
	 */
	@ApiModelProperty(value = "创建者ID",example = "1")
	private Long createUserId;
	/**
	 * 创建时间
	 */
	@ApiModelProperty(value = "创建时间",example = "2019-03-11 14:36:22")
	private Date createTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public String getTittle() {
		return tittle;
	}

	public void setTittle(String tittle) {
		this.tittle = tittle;
	}

	public String getCoverPic() {
		return coverPic;
	}

	public void setCoverPic(String coverPic) {
		this.coverPic = coverPic;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(Integer orderNum) {
		this.orderNum = orderNum;
	}

	public Long getReadCount() {
		return readCount;
	}

	public void setReadCount(Long readCount) {
		this.readCount = readCount;
	}

	public Long getLikeCount() {
		return likeCount;
	}

	public void setLikeCount(Long likeCount) {
		this.likeCount = likeCount;
	}

	public Long getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(Long createUserId) {
		this.createUserId = createUserId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}
