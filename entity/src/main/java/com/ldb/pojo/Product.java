package com.ldb.pojo;

import java.time.LocalDateTime;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonKey;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 商品 商品信息相关表：分类表，商品图片表，商品规格表，商品参数表
 * </p>
 *
 * @author LiuDongBin
 * @since 2023-11-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 商品图片列表
     */
    @TableField(exist = false)
    List<ProductImg> productImgList;

    /**
     * 商品主键id
     */
    @TableId
    private String productId;

    /**
     * 商品名称 商品名称
     */
    private String productName;

    /**
     * 分类外键id 分类id
     */
    private Integer categoryId;

    /**
     * 一级分类外键id 一级分类id，用于优化查询
     */
    private Integer rootCategoryId;

    /**
     * 销量 累计销售
     */
    private Integer soldNum;

    /**
     * 默认是1，表示正常状态, -1表示删除, 0下架 默认是1，表示正常状态, -1表示删除, 0下架
     */
    private Integer productStatus;

    /**
     * 商品内容 商品内容
     */
    private String content;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date createTime;

    /**
     * 更新时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date updateTime;


}
