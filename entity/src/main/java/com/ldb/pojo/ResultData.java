package com.ldb.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@ApiModel("返回结果")
public class ResultData<T> {
    @ApiModelProperty("状态码")
    private Integer code;
    @ApiModelProperty(value = "提示信息")
    private String msg;
    @ApiModelProperty("返回数据")
    private T data;

    public ResultData(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
