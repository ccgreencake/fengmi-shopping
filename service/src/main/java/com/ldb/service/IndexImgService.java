package com.ldb.service;

import com.ldb.pojo.IndexImg;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ldb.pojo.ResultData;

/**
 * <p>
 * 轮播图  服务类
 * </p>
 *
 * @author LiuDongBin
 * @since 2023-11-13
 */
public interface IndexImgService extends IService<IndexImg> {
    ResultData getIndexImg();
}
