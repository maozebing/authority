package com.ybx.authority.common.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "t_sys_role_menu")
@Getter
@Setter
public class RoleMenu {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Basic
    @Column(name = "role_code")
    private String roleCode;
    @Basic
    @Column(name = "menu_code")
    private String menuCode;
    @Basic
    @Column(name = "menu_actions")
    private String menuActions;
}
