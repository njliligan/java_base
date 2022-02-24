package com.njganlili.annotations;

public class User {

    @CellStyle
    private String name;

    @CellStyle(age = "19")
    private String age;

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
}
