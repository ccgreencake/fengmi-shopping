package com.ldb.mapper;

import com.ldb.pojo.Product;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 商品 商品信息相关表：分类表，商品图片表，商品规格表，商品参数表 Mapper 接口
 * </p>
 *
 * @author LiuDongBin
 * @since 2023-11-07
 */
public interface ProductMapper extends BaseMapper<Product> {

    List<Product> selectIntroduct(Integer num);
    List<Product> selectByCategoryId(Integer categoryId, Integer pageNum, Integer pageSize);
}
