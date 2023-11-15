package com.ldb.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author LiuDongBin
 * @Date 2023/11/15 12:04
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDetail {
    /**
     * 商品
     */
    private Product product;
    /**
     * 商品图片
     */
    private List<ProductImg> productImg;
    /**
     * 商品参数
     */
    private List<ProductParams> productParams;
    /**
     * 商品评论
     */
    private List<ProductComments> productComments;
    /**
     * 商品规格
     */
    private List<ProductSku> productSku;
}
