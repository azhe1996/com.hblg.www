# 第四天学习内容 

[TOC]

## 对象数组的运用

> 1. 生成一个类,将两个普通数组的生成封装到一个类里面,

~~~java
源码见 com.hblg.day04  --> com.hblg.object包下的内容
~~~

## 获取对象(实例)的方式 

~~~java
1. 通过对象直接获取类
Class cls1 = new Date().getClass();
2. 通过字节码文件获取类
Class cls2 = Date.class;
3. 通过反射来获取类
Class cls3 = Class.forName("java.util.Date");
~~~

### 单例模式

​	在一个程序运行的过程当中,有且只有一份实例在内存中生成.

 1. 单例模式不能直接实例化.(意味着将构造器私有化)

    示例:

    ~~~java
    private MyPanel (){}
    ~~~

    

 2. 单例模式应该有一个能创建自己本身实例的方法.

    示例:

    ~~~java
    private static MyPanel myPanel ;
    public static MyPanel getInstence(){
        if(myPanel == null){
            myPanel = new MyPanel();
        }
        return myPanel;
    }
    ~~~

    上述的单例模式叫做饿汉模式.什么时候需要,什么时候去实例化.

    还有一种是懒汉模式: 直接创建好,什么时候用,直接调用即可.

    示例:

    ~~~java
    private static final MyPanel myPanel = new MyPanel();
    public static MyPanel getInstence(){
        return myPanel;
    }
    ~~~

    总结:

    > 单例模式都是JVM在加载时生成静态变量.区别就在于懒汉直接在堆空间中生成实例.
    >
    > 缺点是JVM加载的时间就会变长.优点是在使用时直接使用.
    >
    > 饿汉模式在JVM加载时只生成静态变量.只在静态域中添加一个索引.
    >
    > 缺点是在调用时需要生成.需要消耗时间.优点是JVM加载的速度会快.

## 继承后的内存分析

有继承关系后.   

​	super() 是每一个构造器里面系统提供的默认的调用父类的方法.

​	super()与this()一样只能写在构造器的第一行.

​	所以super() 与 this() 不能同时调用.



## 多态

### 向上转型 

​	在拥有继承关系后,父类new子类,只能拥有父类与子类共同拥有的方法.

​	简单理解,向上转型,父类对象只能调用自己的方法.调用的结果需要看子类中是否重写了.

​	如果没有重写,那么调用的是自己的方法,如果子类重写了,调用的是,子类重写的方法.

### 向下转型 

​	可能会出现的异常是:(<span style="color:red">ClassCastException</span>)

代码示例:

~~~java
错误示例:
//        Person per1 = new Person ();
//        Student stu1 = (Student)per1;
//        stu1.say();
正确格式:
           Person per1 = new Student();
           Student stu1 = (Student)per1;
           stu1.say();
~~~

​	向下转型的作用:

​		向上转型调用的是父类与子类共同拥有的方法.此时,是无法调用子类所独有的属性及方法.如果需要调用,那么,向下转型,就是解决调用关系的方法.

### 多态的定义

​	多态是多种形态,根据程序在运行时通过不同的结果而产生不同的执行效果.以达到程序自动选择执行的内容.此种范例就叫做多态.

​	实现多态的三要素:

		1. 子类与父类有继承关系. 
  		2. 子类重写父类的方法.
  		3. 实现向上转型.

实际开发时的面向接口编程,通常都会将抽象方法完全定义在接口当中,所以此时,并不需要考虑向下转型问题.直接通过接口对象.(及它的实现类实例)

​	示例代码:

~~~java
模块com.hglg.web   --> 包 com.hblg.dao.impl  -->类 UserDaoTest
~~~

## 常用类

​	== 与 equlas的区别?

​	一般情况下,此时问的是 == 与 String 的equlas的区别.

​	== 与 Object 的equlas在对象的比较上是等效的.

~~~java
public boolean equals(Object obj) {
    return (this == obj);
}
~~~

​	== 还可以比较两个数值是否相等.

String 的equlas 它除了比较两个对象是否相等以外.还会以本质的方式来比较两个字符串每一个位置上的字符是否相同.如果字符都相同,代表字符串也是相同的.所以.String的equlas还可以比较两个字符串是否相同.

~~~java
if (anObject instanceof String) {
    String anotherString = (String)anObject;
    int n = value.length;
    if (n == anotherString.value.length) {
        char v1[] = value;
        char v2[] = anotherString.value;
        int i = 0;
        while (n-- != 0) {
            if (v1[i] != v2[i])
                return false;
            i++;
        }
        return true;
    }
}
~~~





### String

​	字符串的本质是char数组.

~~~java
private final char value[];
~~~

​	char本身的值是Unicode字符(ASCII码).这些字符序列都会在静态域中生成.

​	所以每一个字符串,只是将静态域中的字符进行拼接.

​	此时,拼接完的字符串的存储位置也是存储在静态域当中.

​	String字符串都是常量.



#### 字符串的生成时机:

​	分为两类:

​		如果都是常量,不管有没有连接符,生成的常量都是在静态域的常量池当中,所有只有一份.

​		如果字符串变量连接.此时只能在程序运行时得到一个连接后的结果.那么,生成是在堆空间中生成.那么.

​		与常量池中相同的变量,在这种情况下的地址就不会相同.

示例:

~~~java
//编译期生成的常量
String str1 = "abc";
String str2 = "abc";
String str3 = "ab"+"c"; //"ab"+"c"  -->  "abc"
String str4 = str1;

//两个变量相加,那么只能在运行时才能确定变量的值.
String str5 = "ab";
String str6 = "c";
String str7 = str5+str6;
~~~

String类是一个类的特殊的引用变量.其特殊在其本质是一个char数组,生成是在静态域的常量池当中.

所以,平常定义字符串,不会通过new的方法去创建字符串实例.

str7在程序运行时,通过查看反编译源码.得到结论.

​	在运行时,首先创建一个StringBuilder对象.(可变字符串),通过apend将多个字符串进行连接.对象再调用toString方法,将对象转换成字符串.

~~~java
String str = "abc";
~~~

#### String str = "abc";与String str = new String("abc")区别

new是在堆空间中去开辟一块空间来存放对象.通过分析,参数本身的常量池就可以赋值.在堆空间创建实例相当于是在创建垃圾,所以,如无必要,那么不会通过new的方式来创建字符串的实例.

#### 需要掌握的构造器:

​	

| 构造器                               | 描述                         |
| ------------------------------------ | ---------------------------- |
| public String(byte[] bytes)          | 将一个byte数组转换成字符串   |
| public String(char[] value)          | 将一个字符数组转换成字符串   |
| public String(StringBuilder builder) | 将一个可变字符串转换成字符串 |



​	<span style = "color:red">后台获取页面所有的数据都是字符串.</span>



常用方法:

​	

| 返回值    | 方法                                                         | 描述                                       |
| --------- | ------------------------------------------------------------ | ------------------------------------------ |
| char      | public char charAt(int index)                                | 返回字符串中指定下标索引位置上的char值.    |
| boolean   | public boolean contains(CharSequence s)                      | 验证当前字符串是否包含指定参数字符串.      |
| int       | public int indexOf(int ch)                                   | 查验第一次出现指定ch字符的下标索引         |
| int       | public int indexOf(String str)                               | 查验第一次出现指定字符串的下标索引         |
| int       | public int indexOf(int ch, int fromIndex)                    | 从fromIndex位置开始查验                    |
| int       | public int lastIndexOf(int ch)                               | 查验从后往前的第一次出现指定字符的下标索引 |
| String    | public static String valueOf(Object obj)                     | 将任意对象或值转换成字符串.                |
| boolean   | public boolean equals(Object anObject)                       | 比较两个字符串的内容是否相同               |
| String    | public String substring(int beginIndex)                      | 从指定位置开始剪切字符串生成新的字符串     |
| String [] | public String[] split(String regex)                          | 通过指定的参数来分割字符串                 |
| boolean   | public boolean matches(String regex)                         | java里面的字符串的正则验证方法             |
| String    | public String replace(CharSequence target,                       CharSequence replacement) | 将replacement的替换掉target目标内容        |
| String    | public String concat(String str)                             | 将指定字符串连接到字符串后面               |
| boolean   | public boolean isEmpty()                                     | 检验字符串是否为空                         |
| String    | public String intern()                                       | 强制入池(入常量池)                         |



CharSequence接口

![](char.png)



regex 代表的是正则参数

~~~java
源码见-->模块com.hblg.day04--->包com.hblg.str-->类StringTest
~~~



I/O流

​	File

​	InputStream

​	OutputStream

​	Reader

​	Writer



## 线程 



### 线程与进程的关系 

	#### 进程 

​	一个应用程序的构成单位是进程.

#### 线程

​	一个进程的构成单位是线程.



通过 测试 java的程序除了执行main方法以外. 还执行了垃圾回收器.

也就是说,一个java进程至少启动了两个线程:

​	main

​	gc

通过手动调用垃圾回收器.内容比原来测试的要小.

​	其根本原因,手动调用,每次循环都会进行垃圾的回收检测及垃圾的销毁.

​	而系统调用垃圾回收,需要有一定的时间间隔才会去检测. 

java的开启线程需要Thread类.

### 线程的启动方式

### 线程的五个状态















