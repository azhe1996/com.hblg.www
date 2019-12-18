package com.hblg.basic;

import java.util.Random;
import java.util.Scanner;

public class PersonTest {
    public static final int SHI_TOU = 1 ;
    public static final int JIAN_DAO = 2 ;
    public static final int BU = 3 ;


    public static void main(String[] args) {
        /**
         *  1.需要设计程序重复运行
         *  2.需要设计程序有中止条件
         *  3.设计猜的内容用文字还是数字
         *  4.游戏内核 --->通过判定输出结果
         *
         * */
        //1.1设计电脑的石头,剪刀,布 由随机数来实现
        //1.2设计可以拿到用户输入的石头/剪刀/布
//        Math.random() 生成0~1之间的随机小数
        Random ran = new Random();
        Scanner scn = new Scanner(System.in);
        while(true){
            int com = ran.nextInt(3)+1;
            System.out.println("请输入您要猜的:1.石头, 2.剪刀, 3.布 4.退出");
            switch (scn.nextInt()){
                case SHI_TOU:
                    if(com == SHI_TOU){
                        System.out.println("您出的是石头,电脑出的是石头,平局");
                    }else if(com == JIAN_DAO){
                        System.out.println("您出的是石头,电脑出的是剪刀,您赢了");
                    }else if(com == BU){
                        System.out.println("您出的是石头,电脑出的是布,您输了");
                    }
                    break;
                case JIAN_DAO:
                    if(com == SHI_TOU){
                        System.out.println("您出的是剪刀,电脑出的是石头,您输了");
                    }else if(com == JIAN_DAO){
                        System.out.println("您出的是剪刀,电脑出的是剪刀,平局");
                    }else if(com == BU){
                        System.out.println("您出的是剪刀,电脑出的是布,您赢了");
                    }
                    break;
                case BU:
                    if(com == SHI_TOU){
                        System.out.println("您出的是布,电脑出的是石头,您赢了");
                    }else if(com == JIAN_DAO){
                        System.out.println("您出的是布,电脑出的是剪刀,您输了");
                    }else if(com == BU){
                        System.out.println("您出的是布,电脑出的是布,平局");
                    }
                    break;
                case 4:
                    System.out.println("游戏结束,欢迎您再次玩本游戏");
                    return;
                default:
                    System.out.println("您输入的内容不正确,请重新输入");
                    break;
            }
        }





       /* for(int i = 0 ; i<100;i++){

        }

        int i = 100;
        do{
            i++;
            System.out.println(i);
        }while(i<100);*/



        /*int i = 0 ;//定义一个变量
        while(i<100){
            i++;
            if(i%7==0){
                System.out.println(i);
            }
        }*/







//        Person per = new Person();//在堆空间中创建一个Person的实例.
//        double a = per.sum(3,4,5);
//        System.out.println(a);
    }
}
