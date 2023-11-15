package com.ldb.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ldb.mapper.*;
import com.ldb.pojo.*;
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

    @Autowired
    private ProductImgMapper productImgMapper;

    @Autowired
    private ProductParamsMapper productParamsMapper;

    @Autowired
    private ProductCommentsMapper productCommentsMapper;

    @Autowired
    private ProductSkuMapper productSkuMapper;


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

    @Override
    public ResultData getDetail(Integer productId) {
        Product product = productMapper.selectById(productId);
        QueryWrapper QWProductId = new QueryWrapper();
        QueryWrapper QWItemId = new QueryWrapper();
        QWProductId.eq("product_id", productId);
        QWItemId.eq("item_id", productId);
        List<ProductImg> productImgs = productImgMapper.selectList(QWItemId);
        List<ProductParams> productParams = productParamsMapper.selectList(QWProductId);
        List<ProductComments> productComments = productCommentsMapper.selectList(QWProductId);
        List<ProductSku> productSkus = productSkuMapper.selectList(QWProductId);
        ProductDetail productDetail = new ProductDetail(product,productImgs,productParams,productComments,productSkus);
        return new ResultData<>(200,"查询成功",productDetail);
    }
}
