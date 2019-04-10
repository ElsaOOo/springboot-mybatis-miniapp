package com.yezi.demoa.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;

/**
 * @Author: yezi
 * @Date: 2019/4/9 08 12
 * @Description:
 */
@Entity
@Table(name = "tb_area")
@DynamicInsert
@DynamicUpdate
@Data
public class TbArea {

    // 主键ID 类型用基础类型的包装类型，方便做非空的校验
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    @Column(name = "area_id")
    private Integer areaId;

    // 名称
    @Column(name = "area_name")
    private String areaName;

    // 权重，越大越排名靠前
    private Integer priority;

    // 创建时间
    @Column(name = "create_time")
    private Date createTime;

    // 最近一次修改时间
    @Column(name = "last_edit_time")
    private Date lastEditTime;
}
