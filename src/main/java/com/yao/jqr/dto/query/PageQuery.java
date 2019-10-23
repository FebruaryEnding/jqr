package com.yao.jqr.dto.query;

import java.io.Serializable;

public class PageQuery implements Serializable {

    private static Integer defaultPageSize = 10;

    private Integer page = 1;

    private Integer pageSize = defaultPageSize;

    public Integer getPage() {
        if (page <= 1) {
            return 0;
        }
        return page - 1;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        if (pageSize == null) {
            pageSize = defaultPageSize;
        } else if (pageSize <= 0) {
            pageSize = defaultPageSize;
        }
        this.pageSize = pageSize;
    }
}
