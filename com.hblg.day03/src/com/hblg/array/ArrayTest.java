package com.hblg.array;

/**
 * 数组的声明测试.
 *
 *
 * @author restyhap
 */
public class ArrayTest {
    public static void main(String[] args) {
        /**protected 测试*/

        Person per = new Person();
        per.age = 17;
        per.shuo();

        System.out.println(per.age);


        /**多维数组的使用*/
/*

        int [] [] is = new int [3] [] ;
        is[0] = new int []{20,21};
        is[1] = new int []{30,31,32};
        is[2] = new int []{40,41,42,43};

        for (int i = 0; i < is.length; i++) {
            for (int j = 0; j < is[i].length; j++) {
//                ""+   将任何对象或值转换成字符串.  \t 一个制表符.(一个tab键位)
                System.out.printf("\t"+is[i][j]);
            }
            System.out.println();
        }
*/

        
//        System.out.println(is[1][1]);
//        System.out.println(is[2][2]);


        /**数组的声明方式2**/

//        int [] is = new int []{1,2,3,4,5,6};
//
//        System.out.println(is);
//
//
//        Person [] pers = new Person[]
//                {new Person("Jack",23),
//                 new Person("Rose",24)
//                };
////        Person per = new Person();
////        pers[0] = per ;
////        per.name;
//        //Jack喜欢Rose
//        System.out.println(pers[0].name+"喜欢"+pers[1].name);


//        int i = 08;//表示的8进制数值


        /**数组的声明方式1*/
//        int [] is;
//        is = new int[10];
//        int  [] is1= new int [20];
//
//
//        double  []  ds= new double [5];
//        //对象数组也叫做引用数组
//        Person  [] pers = new Person[10];
//
//        //array[index] 获取数组指定index下标索引的值
//        System.out.println(is[0]);
//        System.out.println(pers[0]);

    }
}
