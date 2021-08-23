package com.example.springpublic.entity.base;

public enum ResultCode {
    SUCCESS("success", "成功"),
    ERROR("error", "参数有误"),
    CONNECTFAIL("fail", "网络连接失败，请重试"),
    FAIL("fail", "系统异常"),
    UNBIND("unbind","未绑定");

    private String code;
    private String describe;

    private ResultCode(String code, String describe) {
        this.code = code;
        this.describe = describe;
    }

    public String getCode() {
        return code;
    }

    public String getDescribe() {
        return describe;
    }

}
