package com.ybx.authority.common.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "t_sys_role")
@Getter
@Setter
public class Role {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Basic
    @Column(name = "code")
    private String code;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "describes")
    private String describes;
    @Basic
    @Column(name = "is_deleted")
    private boolean deleted;
    @Basic
    @Column(name = "gmt_create")
    private Date create;
    @Basic
    @Column(name = "gmt_modified")
    private Date modified;
}
