package com.hblg.dao.impl;

import com.hblg.bean.User;
import com.hblg.dao.UserDao;

/**
 * 模拟的是UserServlet extends HttpServlet
 *  doGet()
 *  doPost()
 *
 *  service()   restFul格式请求的接收
 *
 *  GET/POST/DELETE/UPDATE/INSERT
 *
 *
 */
public class UserDaoTest {
    public static void main(String[] args) {
        UserDao userDao ;
        User user= new User();
//        choose 从页面获取过来的表单信息.
        String choose = "reg";
        boolean boo = false;
        switch (choose){
            case "reg":
                //调用注册方法时. 方法调用出现问题
                userDao = new UserDaoRegImpl();
                boo = userDao.register(user);
                break;
            case "login":
                //调用登陆方法时,
                userDao = new UserDaoImpl();
                boo = userDao.login(user);
                break;
            default:
                break;

        }

        //boo 只能是true   false
        if(boo){
            //跳转到成功的页面.
        }else{
            //跳转到失败的页面.
        }









    }
}
