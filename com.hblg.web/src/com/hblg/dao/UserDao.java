package com.hblg.dao;

import com.hblg.bean.User;

import java.util.List;

/**
 * 数据层本身应该只负责数据的调用.
 * 目前将数据层及业务层结合起来实现
 */
public interface UserDao {

    /**
     * 通过 findByName() ,那么实现验证用户名及密码是否正确.
     * @param user  <b>从页面获取的实例</b>
     * @return <b>数据库用户及页面传入用户如果匹配,则true,反之则false</b>
     */
    boolean login (User user);

    /**
     * 通过传入的用户名.连接数据库,查验是否有当前用户.
     * @param userName  <b>从页面获取的用户名</b>
     * @return <b>如果存在就返回用户实例,不存在返回null</b>
     */
    User findByName(String userName);

    /**
     * 通过findByName()返回的结果,为false开始注册.
     * @param user  <b>需要注册的用户</b>
     * @return  <b>添加用户成功返回true,反之为false</b>
     */
    boolean register(User user);

    /***
     *  返回注册用户的数量
     * @return
     */
    int count ();

    /**
     * 返回所有的用户的数据.
     * @return
     */
    List<User> getAll();
}
