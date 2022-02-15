package com.njganlili.finalkey;

/**
 * @author njgan
 * @description
 * @date 2022/2/15 10:24
 */
public class Parent {


    private final String name = "miky";

    protected  Integer age = 18;

    protected final String sex = "M";

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }
}
