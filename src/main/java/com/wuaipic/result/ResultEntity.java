package com.wuaipic.result;

import java.io.Serializable;
import lombok.Data;
/**
 * @program: wuaipic
 * @Auther: HGG
 * @Date: 2019-04-14 23:48
 * @Description:
 */

@Data
public class ResultEntity implements Serializable {

    /**
     * 状态码
     */
    private String code;
    /**
     * 内容
     */
    private Object data;
    /**
     * 状态消息
     */
    private String msg;

    private ResultEntity(String code) {
        this.code = code;
    }

    private ResultEntity(String code, Object data) {
        this.code = code;
        this.data = data;
    }

    private ResultEntity(String code, String message, Object data) {
        this.code = code;
        this.msg = message;
        this.data = data;
    }

    private ResultEntity(String code, String message) {
        this.code = code;
        this.msg = message;
    }

    /**
     * 成功返回信息
     *
     * @param message 信息文本
     * @return 包含成功信息的实体
     */
    public static ResultEntity createBySuccessMessage(String message) {
        return new ResultEntity(RespomseCode.SUCCESS.getCode(), message);
    }

    /**
     * 成功返回数据
     *
     * @param data 数据对象
     * @return 返回包含数据对象的实体
     */
    public static ResultEntity createBySuccessData(Object data) {
        return new ResultEntity(RespomseCode.SUCCESS.getCode(), data);
    }

    /**
     * 成功返回数据与信息
     *
     * @param data    数据对象
     * @param message 信息文本
     * @return 返回包含数据对象与信息的实体
     */
    public static ResultEntity createBySuccessDataAndMessage(Object data, String message) {
        return new ResultEntity(RespomseCode.SUCCESS.getCode(), message, data);
    }

    /**
     * 失败返回信息
     *
     * @param message 信息文本
     * @return 返回包含错误信息的实体
     */
    public static ResultEntity createByErrorMessage(String message) {
        return new ResultEntity(RespomseCode.ERROR.getCode(), message);
    }

    /**
     * 参数错误
     *
     * @return 返回包含参数错误信息的实体
     */
    public static ResultEntity createByIllegal() {
        return new ResultEntity(RespomseCode.ILLEGAL_ARGUMENT.getCode(), RespomseCode.ILLEGAL_ARGUMENT.getDesc());
    }


    /**
     * 没有登录
     *
     * @return 返回包含未登录信息的实体
     */
    public static ResultEntity createByNeedLogin() {
        return new ResultEntity(RespomseCode.NEED_LOGIN.getCode(), RespomseCode.NEED_LOGIN.getDesc());
    }

    /**
     * 其他错误
     *
     * @param code    状态码
     * @param message 信息文本
     * @return 返回自定义错误信息实体
     */
    public static ResultEntity createByErrorCodeMessage(String code, String message) {
        return new ResultEntity(code, message);
    }
}
