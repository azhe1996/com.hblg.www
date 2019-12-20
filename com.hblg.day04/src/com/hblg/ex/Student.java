package com.hblg.ex;

public class Student extends Person {

    public Student(){
        //因为调用本类构造器,不再提供 super();
        System.out.println("Student... init....");
    }

    @Override
    public void say(){
        System.out.println("Student... say()...");
    }


    public void play(){
        System.out.println("Student... play()....");

    }

}
