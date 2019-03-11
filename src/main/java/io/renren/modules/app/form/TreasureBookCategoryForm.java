package io.renren.modules.app.form;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;

/**
 * 宠物宝典分类表
 * 
 * @author fz
 * @email fz@gmail.com
 * @date 2019-03-11 10:34:08
 */
@ApiModel(value = "宠物宝典分类表单")
public class TreasureBookCategoryForm implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 宠物宝典分类主键ID
	 */
	@ApiModelProperty(value = "ID",example = "1")
	private Long id;
	/**
	 * 宠物宝典分类名称
	 */
	@ApiModelProperty(value = "宠物宝典分类名称",example = "幼犬饲养")
	@NotBlank(message="宠物宝典分类名称不能为空")
	private String categoryName;
	/**
	 * 分类图标
	 */
	@ApiModelProperty(value = "分类图标",example = "https://test-1254210782.cos.ap-chengdu.myqcloud.com/yq.jpg")
	@NotBlank(message="分类图标不能为空")
	private String ico;
	/**
	 * 分类排序（顺序从小到大）
	 */
	@ApiModelProperty(value = "分类排序",example = "0")
	private Integer orderNum;
	/**
	 * 状态（-1 删除 0 正常 1禁用）
	 */
	@ApiModelProperty(value = "状态（-1 删除 0 正常 1禁用）",example = "0")
	private Integer status;
	/**
	 * 该类目的浏览量
	 */
	@ApiModelProperty(value = "该类目的浏览量",example = "0")
	private Long count;
	/**
	 * 创建者ID
	 */
	@ApiModelProperty(value = "创建者ID",example = "0")
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

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getIco() {
		return ico;
	}

	public void setIco(String ico) {
		this.ico = ico;
	}

	public Integer getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(Integer orderNum) {
		this.orderNum = orderNum;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
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
