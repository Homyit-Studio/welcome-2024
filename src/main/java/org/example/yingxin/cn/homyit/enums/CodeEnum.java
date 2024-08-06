package org.example.yingxin.cn.homyit.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * @prohram: teach
 * @description: 返回信息枚举类
 * @author: Answer
 * @create:2024/4/18 17:30
 **/
@Getter
@AllArgsConstructor
@ToString
public enum CodeEnum {
    SUCCESS(200,"登录成功"),
    LOGIN_ERR(600,"用户名或密码错误"),
    LOGIN_STATUS_EXPIRED(601,"登录状态已过期"),
    LOGIN_USEorNAME_NULL(605,"用户名或密码为空"),
    DELECT_SUCCESS(701,"删除成功"),
    INSERT_SUCCESS(801,"添加成功"),
    INSERT_NAME_NULL(802,"名字不能为空"),
    INSERT_YOUXIAN_NULL(802,"邮箱不能为空"),
    INSERT_BANJI_NULL(802,"班级不能为空"),
    INSERT_FANGXIANG_NULL(802,"方向不能为空"),
    INSERT_XUEHAO_NULL(802,"学号不能为空"),
    BAOMING_SUCCESSS( 901,"报名成功"),
    DOWNLOAD_SUCCESS(902,"下载成功"),
    UPDATE_SUCCESS(903,"修改成功"),
    UPLOAD_SUCCESS(904,"图片上传成功"),
    GETIMAGES_SUCCESS(905,"获取图片成功"),
    GETDATA_SUCCESS(906,"获取地图数据成功");
    private Integer code;
    private String message;

}
