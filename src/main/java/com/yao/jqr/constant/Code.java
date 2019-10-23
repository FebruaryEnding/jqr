package com.yao.jqr.constant;

public enum Code {
    SUCCESS(200, "接口调用成功!"),

    BAD_REQUEST(400, "参数错误!"),

    UNAUTHORIZED(401, "请登录!"),

    FORBIDDEN(403, "没有权限访问此页面!"),

    INTERNAL_SERVER_ERROR(500, "服务器异常!");

    private Integer code;

    private String msg;

    Code(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
