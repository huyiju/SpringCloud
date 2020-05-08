package com.thit.controller;

import java.util.Random;

/**
 * @author :huyiju
 * @date :2020-04-22 18:42
 */
public class test {
    public static void main(String[] args) {
        Random r=new Random();


        int current = r.nextInt(10000);
        System.out.println("随机数是："+current);
    }
}
