package com.hblg.bean;

import java.io.Serializable;

/***
 * 对应数据库 tb_user 表的实体类
 *  数据库的名称定义是以 db_xxx来定义
 *  表的定义是以 tb_xxx   t_xxx 来定义
 *
 *
 */
public class User implements Serializable {

    private String name;
    private String password;
    private int role;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }
}
