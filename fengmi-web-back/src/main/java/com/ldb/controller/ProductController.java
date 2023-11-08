package com.ldb.controller;


import com.ldb.pojo.ResultData;
import com.ldb.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
//@Api(tags = "商品相关接口")
public class ProductController {
    @Autowired
    private ProductService productService;
    @GetMapping
    @ApiOperation(value = "方法的作用",notes = "备注")
    @ApiImplicitParams({
            @ApiImplicitParam(name="pageNum",value="页码",required=false),
//            @ApiImplicitParam(name="pageSize",value="每页的数量",required=false)
    })
    public ResultData all(@RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "5") Integer pageSize){
        return productService.selectPage(pageNum,pageSize);

    }

}

