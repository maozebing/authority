package com.ybx.authority.common.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "t_sys_menu")
@Getter
@Setter
public class Menu {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Basic
    @Column(name = "code")
    private String code;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "icon")
    private String icon;
    @Basic
    @Column(name = "is_leaf")
    private boolean leaf;
    @Basic
    @Column(name = "parent")
    private String parent;
    @Basic
    @Column(name = "describe")
    private String describe;
    @Basic
    @Column(name = "actions")
    private String actions;
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
