package com.ldb.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author LiuDongBin
 * @Date 2023/11/14 10:26
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MyPage<T> {
    T records;
    Long total;
    Long size;
    Long current;
}
