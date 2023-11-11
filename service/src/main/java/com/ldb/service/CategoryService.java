package com.ldb.service;

import com.ldb.pojo.Category;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ldb.pojo.ResultData;

/**
 * <p>
 * 商品分类 服务类
 * </p>
 *
 * @author LiuDongBin
 * @since 2023-11-09
 */
public interface CategoryService extends IService<Category> {
    ResultData selectAll();
}
