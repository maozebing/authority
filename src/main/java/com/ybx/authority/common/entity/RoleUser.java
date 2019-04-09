package com.ybx.authority.common.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "t_sys_role_user")
@Getter
@Setter
public class RoleUser {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Basic
    @Column(name = "role_code")
    private String roleCode;
    @Basic
    @Column(name = "user_code")
    private String userCode;
}
