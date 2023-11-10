package com.ldb.mapper;

import com.ldb.pojo.Category;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 商品分类 Mapper 接口
 * </p>
 *
 * @author LiuDongBin
 * @since 2023-11-09
 */
public interface CategoryMapper extends BaseMapper<Category> {
    List<Category> selectAllCategory();

}
