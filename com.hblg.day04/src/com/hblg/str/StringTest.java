package com.hblg.str;

import java.util.Arrays;
import java.util.Date;

public class StringTest {
//    //编译期生成的常量
//    String str1 = "abc";
//    String str2 = "abc";
//    String str3 = "ab"+"c"; //"ab"+"c"  -->  "abc"
//    String str4 = str1;
//
//    //两个变量相加,那么只能在运行时才能确定变量的值.
//    String str5 = "ab";
//    String str6 = "c";
//    String str7 = str5+str6;



    public static void main(String[] args) {

        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            String str = new String("abcd");
            System.out.println(str);
            //手动调用垃圾回收器
            System.gc();
        }


        /**强制入池.*/
        /*String str1 = "abc";
        String str2 = "ab";
        String str3 = "c";
        String str4 = str2+str3;
        str4 = str4.intern();
        System.out.println(str1 == str4);*/



    /*String str = "adbcdefg Hello World!!Hello!!";

        str = str.concat("~~~~");
        System.out.println(str);*/

        //只有在str.length()为0时，才返回true
//        System.out.println(str.isEmpty());


        /**替换字符串*/
//        String str1 = str.replace('d','~');
//        String str2 = str.replace("Hello","hello");
//        System.out.println(str1);
//        System.out.println(str2);

        /**分割字符串*/
       /* String str1 = "127.0.0.1";//本机的localhost
        //.是特殊符号,需要转义符转义,它本身也是特殊字符,也需要转义.
        String strs [] = str1.split("\\.");// \.
        System.out.println(strs.length);
        System.out.println(Arrays.toString(strs));*/


        /**剪切字符串**/
        //含头去尾
//        String str1 = str.substring(4,19);
//        System.out.println(str1);


        /**字符串的常用方法*/
        //index指的是数组的下标索引.
//        System.out.println(str.charAt(3));
//        System.out.println(str.contains("Hello"));
//        //如果查询不到指定的参数,那么返回值为-1
//        System.out.println(str.indexOf('d',2));
//        System.out.println(str.indexOf("adbc",1));
//        System.out.println(str.lastIndexOf('d',20));
//        System.out.println(String.valueOf(new Date()));
//        String str1 = "abc";
//        String str2 = new String ("abc");
//        System.out.println(str1 == str2);
//        //比较两个字符串是否相同
//        System.out.println(str1.equals(str2));


/**字符串的本质 **/
//        StringTest st = new StringTest();
//        String str = new String(new byte[]{97,98,99});
//        System.out.println(str);
       /* System.out.println(st.str1 == st.str2);
        System.out.println(st.str1 == st.str3);
        System.out.println(st.str1 == st.str4);
        System.out.println(st.str1 == st.str7);
        String str = new String ("abc");
        System.out.println(str == st.str1);*/


    }
}
