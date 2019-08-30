package com.wuaipic.result;

/**
 * 描述:
 *
 * @author hgg
 */
public enum RespomseCode {
    //操作成功
    SUCCESS("0", "操作成功"),
    //出现错误
    ERROR("1", "出现错误"),
    //未登录
    NEED_LOGIN("2", "未登录"),
    //参数异常
    ILLEGAL_ARGUMENT("3", "参数异常");

    private final String code;
    private final String desc;

    RespomseCode(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
