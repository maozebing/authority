package com.ybx.authority.common.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "t_sys_user")
@Getter
@Setter
public class User {
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
    @Column(name = "passward")
    private String passward;
    @Basic
    @Column(name = "is_man")
    private boolean man;
    @Basic
    @Column(name = "phone")
    private String phone;
    @Basic
    @Column(name = "email")
    private String email;
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
