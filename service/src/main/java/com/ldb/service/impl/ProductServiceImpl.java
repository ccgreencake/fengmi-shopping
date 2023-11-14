package com.ldb.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ldb.pojo.Product;
import com.ldb.mapper.ProductMapper;
import com.ldb.pojo.ResultData;
import com.ldb.service.ProductService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 商品 商品信息相关表：分类表，商品图片表，商品规格表，商品参数表 服务实现类
 * </p>
 *
 * @author LiuDongBin
 * @since 2023-11-07
 */
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {

    @Autowired
    private ProductMapper productMapper;
    @Override
    public ResultData selectPage(Integer pageNum, Integer pageSize) {
        Page page = new Page(pageNum, pageSize);
        productMapper.selectPage(page,null);
        if (page.getRecords().size() == 0){
            return new ResultData(500,"没有数据");
        }else {
            return new ResultData(200,"查询成功",page);
        }
    }

    @Override
    public ResultData introduce(Integer num) {
        if (num == null) {
            num = 10;
        }
        List<Product> products = productMapper.selectIntroduct(num);
        if (products.size() == 0) {
            return new ResultData(500, "没有数据");
        } else {
            return new ResultData(200, "查询成功", products);
        }
    }

    @Override
    public ResultData getByCategoryId(Integer categoryId, Integer pageNum, Integer pageSize) {
        List<Product> products = productMapper.selectByCategoryId(categoryId, (pageNum-1)*pageSize, pageSize);
        Page page = new Page(pageNum, pageSize);
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("category_id", categoryId);
        queryWrapper.orderByDesc("sold_num");
        productMapper.selectPage(page,queryWrapper);
        page.setRecords(products);
        if (products.size() == 0) {
            return new ResultData(500, "没有数据");
        } else {
            return new ResultData(200, "查询成功",page);
        }
    }
}
