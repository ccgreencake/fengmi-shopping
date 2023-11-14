package com.ldb.controller;


import com.ldb.pojo.ResultData;
import com.ldb.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 商品 商品信息相关表：分类表，商品图片表，商品规格表，商品参数表 前端控制器
 * </p>
 *
 * @author LiuDongBin
 * @since 2023-11-07
 */
@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;
    @GetMapping
    public ResultData all(@RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "5") Integer pageSize){
        return productService.selectPage(pageNum,pageSize);

    }
    @GetMapping("/introduce")
    public ResultData introduce(@RequestParam(defaultValue = "10") Integer num){
        return productService.introduce(num);
    }
    @GetMapping("/category/{categoryId}/{pageNum}/{pageSize}")
    public ResultData getByCategoryId(@PathVariable("categoryId") Integer categoryId,@PathVariable("pageNum") Integer pageNum,@PathVariable("pageSize") Integer pageSize){
        return productService.getByCategoryId(categoryId,pageNum,pageSize);
    }

}

