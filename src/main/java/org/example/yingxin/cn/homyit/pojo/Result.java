package org.example.yingxin.cn.homyit.pojo;

import org.example.yingxin.cn.homyit.enums.CodeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {
    private Integer code;
    private String desc;
    private Object data;
    private Boolean success;

    public Result(Integer code, String desc, Object data) {
        this.code = code;
        this.desc = desc;
        this.data = data;
    }
    public static Result success() {
        return new Result(CodeEnum.SUCCESS.getCode(), CodeEnum.SUCCESS.getMessage(), true);
    }
    public static Result success(Object data){
        return new Result(CodeEnum.SUCCESS.getCode(), CodeEnum.SUCCESS.getMessage(), data);
    }
    public static Result success(CodeEnum codeEnum,Object data){
        return new Result(codeEnum.getCode(), codeEnum.getMessage(), data);
    }
    public static Result success(CodeEnum codeEnum){
        return new Result(codeEnum.getCode(), codeEnum.getMessage(), true);
    }
    public static Result error(CodeEnum codeEnum){
        return new Result(codeEnum.getCode(), codeEnum.getMessage(), false);
    }
    public static Result exception(CodeEnum codeEnum){
        return new Result(codeEnum.getCode(), codeEnum.getMessage(), false);
    }
}
