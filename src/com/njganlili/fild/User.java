package com.njganlili.fild;

/**
 * @author njgan
 * @description
 * @date 2022/2/16 10:57
 */
public class User{

    public User(int a,int b){
        this.no = b;
    }

    // Field
    int no;

    // Constructor
    public User(){

    }
    public User(int no){
        this.no = no;
    }

    // Method
    public void setNo(int no){
        this.no = no;
    }
    public int getNo(){
        return no;
    }

    public String sout(){
        System.out.println("sssssssssssssssssssssssssssssssssss,sssssssssssssssssssssssss");
        return "a";
    }

}

