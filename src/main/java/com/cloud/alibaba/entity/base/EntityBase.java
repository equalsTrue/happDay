package com.cloud.alibaba.entity.base;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@ToString(callSuper = true)
@MappedSuperclass
public class EntityBase implements Serializable {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(length = 36)
    private String identification;

    @Column(name="createtime", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime = new Date(System.currentTimeMillis());

    public Date getCreateTime() {
        if(null == this.createTime){
            return null;
        }
        return (Date) createTime.clone();
    }

    public void setCreateTime(Date createTime) {
        if(null == createTime) {
            this.createTime = null;
        }else{
            this.createTime = (Date) createTime.clone();
        }
    }
}
