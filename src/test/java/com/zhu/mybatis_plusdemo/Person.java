package com.zhu.mybatis_plusdemo;

/***
 *   Created by IntelliJ IDEA.
 *   User: ZhuYaning
 *   Date: 2021/10/19
 *   Time: 19:35
 */

public class Person {
    private String name;//姓名
    private String gender;//性别
    private String address;//地址

    public Person(String name, String gender, String address) {
        this.name = name;
        this.gender = gender;
        this.address = address;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    @Override
    public String toString() {
        return "Person{" + "name='" + name + '\'' + ", gender='" + gender + '\'' + ", address='" + address + '\'' + '}';
    }

    public static void main(String[] args) {
        System.out.println(new Person("习大大","男","北京中南海"));
        System.out.println(100%7);
    }
}
