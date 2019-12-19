package com.hblg.admin;

import com.hblg.array.Person;
import com.hblg.array.Person1;

public class User extends Person {
    public static void main(String[] args) {
        //实例化电脑类
        Computer com = new Computer();
        //调用电脑类的方法,以生成猜拳的结果.
        int cGuess = com.guess();

        /**重构*/

        System.out.println(Person.name);
        System.out.println(Person1.name);
    }
}
