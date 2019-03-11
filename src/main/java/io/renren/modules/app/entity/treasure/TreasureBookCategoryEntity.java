package io.renren.modules.app.entity.treasure;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 宠物宝典分类表
 * 
 * @author fz
 * @email fz@gmail.com
 * @date 2019-03-11 10:34:08
 */
@TableName("p_treasure_book_category")
public class TreasureBookCategoryEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 宠物宝典分类主键ID
	 */
	@TableId
	private Long id;
	/**
	 * 宠物宝典分类名称
	 */
	private String categoryName;
	/**
	 * 分类图标
	 */
	private String ico;
	/**
	 * 分类排序（顺序从小到大）
	 */
	private Integer orderNum;
	/**
	 * 状态（-1 删除 0 正常 1禁用）
	 */
	private Integer status = 0;
	/**
	 * 该类目的浏览量
	 */
	private Long count = 0l;
	/**
	 * 创建者ID
	 */
	private Long createUserId;
	/**
	 * 创建时间
	 */
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
