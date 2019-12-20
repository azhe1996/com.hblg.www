package com.hblg.ex;

public class PersonTest {
    public static void main(String[] args) {
        //向下转型的具体的实例.
        Person per = new Student();
        Student stu = (Student)per;
        stu.play();





        //向上转型
//        Person per = new Student();
//        per.say();
//        per.shuo();

//      错误示例:
//        Person per1 = new Person ();
//        Student stu1 = (Student)per1;
//        stu1.say();
//      正确格式:
//            Person per1 = new Student();
//           Student stu1 = (Student)per1;
//           stu1.say();
    }
}
