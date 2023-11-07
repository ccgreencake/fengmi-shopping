package com.ldb.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ldb.pojo.Product;
import com.ldb.mapper.ProductMapper;
import com.ldb.pojo.ResultData;
import com.ldb.service.ProductService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
