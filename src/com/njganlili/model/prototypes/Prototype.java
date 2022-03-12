package com.njganlili.model.prototypes;

import java.io.*;

/**
 * @author njgan
 * @description
 * @date 2022/3/12 21:35
 */
class Man extends Serializabletype{
    private String name;
    private String sex;

    public String getName() {
        return name;
    }

    public Man setName(String name) {
        this.name = name;
        return this;
    }

    public String getSex() {
        return sex;
    }

    public Man setSex(String sex) {
        this.sex = sex;
        return this;
    }
}

//具体原型类
class Realizetype implements Cloneable {
    Realizetype() {
        System.out.println("具体原型创建成功！");
    }

    private Man man;

    public Man getMan() {
        return man;
    }

    public void setMan(Man man) {
        this.man = man;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        System.out.println("具体原型复制成功！");
        return (Realizetype) super.clone();
    }
}

class Serializabletype implements Serializable{

    private Man man;

    public Man getMan() {
        return man;
    }

    public void setMan(Man man) {
        this.man = man;
    }

    Serializabletype(){
        System.out.println("Serializable 成功");
    }

    public void sout(){
        System.out.println("printf");
    }

}



//原型模式的测试类
public class Prototype {

    /**
     *序列化对象
     *@return 返回序列化后的对象
     */
    private static <T> T CloneObj(T obj) {
        T retobj = null;
        try {
            // 写入流中
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(obj);
            // 从流中读取
            ObjectInputStream ios = new ObjectInputStream(new ByteArrayInputStream(baos.toByteArray()));
            return (T) ios.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return retobj;
    }

    public static void main(String[] args) throws CloneNotSupportedException {



        Realizetype obj1 = new Realizetype();
        obj1.setMan((new Man()).setName("miky").setSex("m"));
        Realizetype obj2 = (Realizetype) obj1.clone();
        System.out.println("obj1==obj2?" + (obj1 == obj2));
        System.out.println("obj1.man==obj2.man?" + (obj1.getMan() == obj2.getMan()));

        Serializabletype serializabletype1 = new Serializabletype();
        serializabletype1.setMan((new Man()).setName("miky").setSex("m"));
        Serializabletype serializabletype2 = CloneObj(serializabletype1);
        System.out.println("serializabletype1==serializabletype2?" + ( serializabletype1  == serializabletype2 ));
        System.out.println("serializabletype1.man==serializabletype2.man?" + ( serializabletype1.getMan() == serializabletype2.getMan() ));


    }
}
