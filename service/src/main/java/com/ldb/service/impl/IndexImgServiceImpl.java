package com.ldb.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ldb.pojo.IndexImg;
import com.ldb.mapper.IndexImgMapper;
import com.ldb.pojo.ResultData;
import com.ldb.service.IndexImgService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 轮播图  服务实现类
 * </p>
 *
 * @author LiuDongBin
 * @since 2023-11-13
 */
@Service
public class IndexImgServiceImpl extends ServiceImpl<IndexImgMapper, IndexImg> implements IndexImgService {
    @Autowired
    private IndexImgMapper indexImgMapper;
    @Override
    public ResultData getIndexImg() {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("status",1);
        queryWrapper.orderByAsc("seq");
        List<IndexImg> indexImgList = indexImgMapper.selectList(queryWrapper);
        if (indexImgList.size() > 0) {
            return new ResultData(200, "查询成功", indexImgList);
        } else {
            return new ResultData(500, "没有数据");
        }

    }
}
