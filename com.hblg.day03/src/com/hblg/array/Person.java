package com.hblg.array;

public class Person {
    public static String name = "Tom";

    public int age ;
    protected String cardId;

    public Person(){}

    Person (String name ,int age ){
//        this.name = name;
        this.age = age;
    }


    public void say(){
        int age1 = 18;
        System.out.println(age1);
    }
    public void shuo(){
        System.out.println("shuo()执行");
        say();
        System.out.println("shuo()结束");
    }

}

/**一个类文件中,可以有很多个类.
 *  但是一个类文件中,只能有一个由public修饰的类.
 *  public修饰的类必须与类文件名相同.
 * */

class Person2{}
class PersonN{}
