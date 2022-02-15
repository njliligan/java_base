package com.njganlili.finalkey;

/**
 * @author njgan
 * @description
 * @date 2022/2/15 10:20
 */
public class User extends Parent{

    private String name = "user";

    public Integer age = super.age;

    public final String sex = super.sex;

    private String qq ;

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                '}';
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Integer getAge() {
        return age;
    }

    @Override
    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String getSex() {
        return sex;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }
}
