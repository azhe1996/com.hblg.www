package com.hblg.cls;

public class Outer{
    private int a ;
    private int b ;
    private int c ;

    private int sum(int a,int b ){
        return a + b ;
    }


    public Outer say(int a ,int b ,int c ){
        System.out.println("Outer... sum()...的值是"+sum(a,b));
        class Inner extends Outer{
            public int sum(int a ,int b ,int c ){
                System.out.println("Inner... sum(a,b,c)...结果是:" + (a + b + c));
                return a + b + c ;
            }
        }
        return new Inner();
    }
}
