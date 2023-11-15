package com.ldb.service;

import com.ldb.pojo.Product;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ldb.pojo.ResultData;

/**
 * <p>
 * 商品 商品信息相关表：分类表，商品图片表，商品规格表，商品参数表 服务类
 * </p>
 *
 * @author LiuDongBin
 * @since 2023-11-07
 */
public interface ProductService extends IService<Product> {
    ResultData selectPage(Integer pageNum, Integer pageSize);

    ResultData introduce(Integer num);

    ResultData getByCategoryId(Integer categoryId, Integer pageNum, Integer pageSize);

    ResultData getDetail(Integer productId);
}
