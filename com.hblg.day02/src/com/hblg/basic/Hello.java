package com.hblg.basic;



import org.junit.Test;

import java.util.Random;
import java.util.Scanner;

public class Hello {
    //单元测试 junit是java自带的单元测试的jar包.可以直接使用.
    //单元测试的方法必须是void方法.
    //测试类不能定义成Test类名,否则就找不到junit注解.

    @Test
    public void test1(){
        Random ran = new Random();
        System.out.println(ran.nextInt(3)+1);
        //一般情况,所有的方法定义时,指定参数都是不包含当前值.

    }



//    public static void main(String[] args) {
//
//        /**输入1-12 返回春夏秋冬四个季节**/
//        Scanner scn = new Scanner(System.in);//获取一个扫描器
//        //a :  循环标签  运用在循环及switch上.
//        a : while(true){
//            System.out.println("请输入1-12的任意数字来确定季节: 0,退出");
//            int key = 0;
//            try{
//                key = scn.nextInt();//扫描int值
//            }catch(Exception e){
////            e.printStackTrace();
//                System.err.println("您输入的不是数字");
//            }
//            //实现春夏秋冬的输出
//            switch (key){
//                case 3:
//                case 4:
//                case 5:
//                    System.out.println("您输入的是春季");
//                    break;
//                case 6:
//                case 7:
//                case 8:
//                    System.out.println("您输入的是夏季");
//                    break;
//                case 9:
//                case 10:
//                case 11:
//                    System.out.println("您输入的是秋季");
//                    break;
//                case 12:
//                case 1:
//                case 2:
//                    System.out.println("您输入的是冬季");
//                    break;
//                case 0 :
//                    //1.停止一个方法后续的代码不再执行.
////                    return;
//                    //2.定义循环标签,退出循环
//                    break a ;
//                default:
//                    System.out.println("您输入的月份不正确,请重新输入");
//                    break;
//            }
////            for(;;){}
//        }
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//    /*    String choose1 = "success"; //成功
//        String choose2 = "fail";    //失败
//
//        *//**模拟数据库里面的某条数据*//*
//        String user = "admin";
//        String pwd = "admin";
//
//        *//**实现用户输入:**//*
//        //程序运行后,扫描用户键盘录入的内容.
//
//        *//*
//        Scanner scn = new Scanner(System.in);
//        System.out.println("请输入您的用户名:");
//        String userScan = scn.next();//扫描录入的字符串
//        System.out.println("请输入您的密码:");
//        String pwdScan = scn.next();
//        boolean boo = user.equals(userScan)&&pwd.equals(pwdScan);
//        String str = boo?choose1:choose2;//三目运算符
//        *//**模拟页面跳转*//*
//        switch (str){//选择结构switch结构
//            case "success":
//                System.out.println("登陆成功");
//                break;
//            case "fail":
//                System.out.println("登陆失败");
//        }*/
//
//
//
//
//
//
//
//
//
//
//       /* int a = 3 ;
//        int b = 4 ;
//        System.out.println("程序开始");
//        if(a<b||10/0==0){
//            System.out.println("执行选择流程");
//        }
//        System.out.println("程序结束");*/
//
//
//
//       /*int a = 3 ;
//       int c = a++;//先将a的值给c.自已本身再做自增运算
//       int b = ++a;//a本身先进行运算,再将值赋值给b
//       System.out.println(c);
//       System.out.println(b);*/
//    }
}
