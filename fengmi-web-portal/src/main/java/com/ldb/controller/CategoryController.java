package com.ldb.controller;


import com.ldb.pojo.ResultData;
import com.ldb.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 商品分类 前端控制器
 * </p>
 *
 * @author LiuDongBin
 * @since 2023-11-09
 */
@RestController
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResultData selectAll(){
        System.out.println(categoryService.selectAll());
        return categoryService.selectAll();
    }
}

