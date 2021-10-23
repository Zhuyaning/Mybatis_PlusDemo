package com.zhu.mybatis_plusdemo;

/***
 *   Created by IntelliJ IDEA.
 *   User: ZhuYaning
 *   Date: 2021/10/23
 *   Time: 1:21
 */

public class OperatorTest {
    public static void main(String[] args) {
        boolean x = true;
        boolean y = false;
        short z = 40;
        if ((z++ == 40) && (y = true)) {
            z++;
        }
        if ((x = false) || (++z == 43)) {
            z++;
        }
        System.out.println("z = " + z);

        Circle circle = new Circle();
        circle.setRadius(5);
        Double area = circle.getCircularArea();
        System.out.println(area);
    }
}


