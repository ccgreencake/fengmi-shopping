package com.ldb.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author LiuDongBin
 * @Date 2023/11/07 15:03
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultData<T> {
    private Integer code;
    private String msg;
    private T data;

    public ResultData(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
