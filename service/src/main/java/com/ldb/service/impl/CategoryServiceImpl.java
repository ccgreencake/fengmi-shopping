package com.ldb.service.impl;

import com.ldb.pojo.Category;
import com.ldb.mapper.CategoryMapper;
import com.ldb.pojo.ResultData;
import com.ldb.service.CategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    @Autowired
    private CategoryMapper categoryMapper;
    @Override
    public ResultData selectAll() {
        List<Category> categories = categoryMapper.selectAllCategory();
        if(categories.size()>0&&categories!=null) {
            return new ResultData(200, "查询成功", categories);
        }else {
            return new ResultData(500, "没有数据");
        }


    }
}
