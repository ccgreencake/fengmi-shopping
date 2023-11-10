package com.ldb.service.impl;

import com.ldb.pojo.Category;
import com.ldb.mapper.CategoryMapper;
import com.ldb.service.CategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 商品分类 服务实现类
 * </p>
 *
 * @author LiuDongBin
 * @since 2023-11-09
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {

}
