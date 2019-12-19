package com.hblg.admin;

import java.util.Random;

/**
 * 电脑类.
 *  三个属性.石头,剪刀,布
 *
 *
 *
 */
public class Computer {

    private int shi_tou;
    private int jian_dao;
    private int bu;
    private Random random;
    /**getter/setter略*/

    public Computer(){
        random = new Random();
    }


    public int guess(){
        return random.nextInt(3)+1 ;
    }


}
