package com.yao.jqr.constant;

public enum DataStatus {

    /**
     * 删除
     */
    DELETE(-1),

    /**
     * 正常
     */
    NORMAL(0);

    DataStatus(Integer status) {
        this.status = status;
    }

    private Integer status;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

}
