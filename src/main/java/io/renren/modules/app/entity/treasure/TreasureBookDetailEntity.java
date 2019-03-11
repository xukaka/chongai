package io.renren.modules.app.entity.treasure;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 宠物宝典的详情
 *
 * @author fz
 * @email fz@gmail.com
 * @date 2019-03-11 10:34:08
 */
@TableName("p_treasure_book_detail")
public class TreasureBookDetailEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 宠物宝典详情ID
     */
    @TableId
    private Long id;
    /**
     * 所属分类
     */
    private Long categoryId;
    /**
     * 宝典详情分类
     */
    private String tittle;
    /**
     * 封面图片
     */
    private String coverPic;
    /**
     * 作者
     */
    private String author;
    /**
     * 宝典详细内容
     */
    private String detail;
    /**
     * 状态（0发布 -1删除）
     */
    private Integer status = 0;
    /**
     * 序号（从小到大）
     */
    private Integer orderNum = 0;
    /**
     * 阅读数
     */
    private Long readCount = 0l;
    /**
     * 点赞数
     */
    private Long likeCount = 0l;
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
