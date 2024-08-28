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
    LOGOUT(203,"已退出登录"),
    NOLOGIN(204,"你还未登录，请先登录"),
    LOGIN_ERR(600,"用户名或密码错误"),
    LOGIN_STATUS_EXPIRED(601,"登录状态已过期"),
    LOGIN_USEorNAME_NULL(605,"用户名或密码为空"),
    DELECT_SUCCESS(701,"删除成功"),
    INSERT_ERROR(800,"添加失败"),
    INSERT_SUCCESS(801,"添加成功"),
    INSERT_NAME_NULL(802,"名字不能为空"),
    INSERT_YOUXIAN_NULL(803,"邮箱不能为空"),
    INSERT_BANJI_NULL(804,"班级不能为空"),
    INSERT_FANGXIANG_NULL(805,"方向不能为空"),
    INSERT_XUEHAO_NULL(806,"学号不能为空"),
    BAOMING_SUCCESSS( 901,"报名成功"),
    BAOMING_ERROR(900,"报名失败"),
    DOWNLOAD_SUCCESS(902,"下载成功"),
    UPDATE_SUCCESS(903,"修改成功"),
    UPDATE_ERROR(909,"修改失败"),
    UPLOAD_SUCCESS(904,"图片上传成功"),
    GETIMAGES_SUCCESS(905,"获取图片成功"),
    GETDATA_SUCCESS(906,"获取地图数据成功"),
    SYSTEM_UNKNOW_ERR(999,"未知错误" ),
    SELECT_SUCCESS(907,"查询成功"),
    EMAIL_ERROR(908,"邮箱格式不对"),
    DELECT_ERROR(911,"删除失败" ),
    BAOMING_CHONGFU(912,"请勿重复报名"),
    YOUXIANG_WUXIAO(913,"请检查你填写的邮箱是否正确"),
    DELECTIMAGES_SUSSESS(301,"图片删除成功"),
    DELECTIMAGES_ERROR(300,"图片不存在"),
    JWT_ERORR(299,"JWT令牌失效"),
    UPDATADITU_ERROR(930,"地图修改失败"),
    UPDATADITU_SUCCESS(931,"地图修改成功"),
    UPDATADITU_NULL(932,"地图名称或值为空"), IMAGE_NOT_FOUND(933,"图片没找到" ),
    SELECTDITU_SUCCESS(940,"地图查找成功"),
    SELECTDITU_ERROR(941,"地图查找失败");
    private Integer code;
    private String message;

}
