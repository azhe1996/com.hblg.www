package com.hblg.bean;

/**
 * 模拟数据库里面的用户表信息
 *  声明有
 *      用户名    user_name  userNmae
 *      用户密码    user_pwd  userPwd
 *      用户权限    user_role UserRole
 *
 * 数据库中的  _a   对就着实体类的  A
 *  SSM框架直接用启用上述的使名方式.
 */
public class User {
    private String name;
    private String pwd ;
    private int role ;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }
}
