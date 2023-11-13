package com.ldb.controller;


import com.ldb.pojo.ResultData;
import com.ldb.service.IndexImgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 轮播图  前端控制器
 * </p>
 *
 * @author LiuDongBin
 * @since 2023-11-13
 */
@RestController
@RequestMapping("/indexImg")
public class IndexImgController {
    @Autowired
    private IndexImgService indexImgService;

    @GetMapping
    public ResultData getIndexImg(){
        return indexImgService.getIndexImg();
    }
}

