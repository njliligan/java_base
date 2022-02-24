package com.njganlili.polymorphism.classes.constract;

/**
 * @author njgan
 * @description
 * @date 2022/2/14 20:17
 */


public class Child extends Parent {

    private String name;

    private String age;

    private String sex;

    Child() {
        System.out.println("调用子类的构造函数");
    }

    public Child(String name, String age) {
        super(name, age);
    }

    Child(String name, String age, String sex){
        this.sex = sex;
        this.age = super.age;
        this.name = super.name;
    }

    @Override
    void f(){
        super.f();
    }

    void g() {
        System.out.println("执行子类的g()方法");

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Child{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }

}
