package com.yao.jqr.entity;

import com.yao.jqr.util.ContextUtils;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 基本实体
 */
@MappedSuperclass
public class BaseEntity implements Serializable {
    @Id
    @GeneratedValue(
            generator = "system-uuid"
    )
    @GenericGenerator(
            name = "system-uuid",
            strategy = "uuid"
    )

    private String id;

    /**
     * 创建时间
     */
    @Column(updatable = false)
    private Date createdTime;

    /**
     * 创建用户id
     */
    @Column(updatable = false)
    private String createUserId;

    /**
     * 最后更新时间
     */
    @LastModifiedDate
    private Date lastUpdateTime;

    /**
     * 最后更新用户id
     */
    private String lastUpdateUserId;

    /**
     * 数据状态
     */
    @Column(nullable = false)
    private Integer status;


    @PrePersist
    public void onCreate() {
        createdTime = new Date();
        lastUpdateTime = new Date();
        Object userId = ContextUtils.getContexeData().getData().get("userId");
        if (userId != null) {
            createUserId = userId.toString();
            lastUpdateUserId = userId.toString();
        }
        if (status == null) {
            status = 0;
        }
    }

    @PreUpdate
    public void onUpdate() {
        lastUpdateTime = new Date();
        Object userId = ContextUtils.getContexeData().getData().get("userId");
        if (userId != null) {
            lastUpdateUserId = userId.toString();
        }
        if (status == null) {
            status = 0;
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public String getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public String getLastUpdateUserId() {
        return lastUpdateUserId;
    }

    public void setLastUpdateUserId(String lastUpdateUserId) {
        this.lastUpdateUserId = lastUpdateUserId;
    }


    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
