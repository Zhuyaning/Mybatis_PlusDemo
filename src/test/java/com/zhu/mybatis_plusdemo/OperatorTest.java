package com.zhu.mybatis_plusdemo;

import java.util.ArrayList;
import java.util.List;

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

        List<String> stringList = new ArrayList<>();
        Integer pri = pri(stringList);
        System.out.println(stringList);
    }


    public static Integer pri(List<String> v){
        v.add("zyn");
        return null;
    }
}


