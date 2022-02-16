package com.njganlili.fild;

/**
 * @author njgan
 * @description
 * @date 2022/2/16 14:20
 */

import java.io.*;
import java.lang.reflect.*;
import java.util.Date;
import java.util.Properties;
import java.util.ResourceBundle;

/*
要操作一个类的字节码，需要首先获取到这个类的字节码，怎么获取java.lang.Class实例？
    三种方式
        第一种：Class c = Class.forName("完整类名带包名");
        第二种：Class c = 对象.getClass();
        第三种：Class c = 任何类型.class;

 */
class ReflectTest01 {
    public static void main(String[] args) throws ClassNotFoundException{
    /*
    第一种方式：Class.forName()
        1、静态方法
        2、方法的参数是一个字符串。
        3、字符串需要的是一个完整类名。
        4、完整类名必须带有包名。java.lang包也不能省略。
     */
        Class c1 = Class.forName("java.lang.String"); // c1代表String.class文件，或者说c1代表String类型。
        Class c2 = Class.forName("java.lang.Integer"); // c2代表Integer类型
        Class c3 = Class.forName("java.util.Date"); // c3代表Date类型


        // 第二种方式：java中任何一个对象都有一个方法：getClass()
        String a = "abc";
        Class c4 = a.getClass(); // c4代表String.class字节码文件；c4代表String类型。
        System.out.println(c4 == c1);//true（==判断的是对象的内存地址。）

        Date time = new Date();
        Class c5 = time.getClass();
        System.out.println(c5 == c3);//true(c5和c3两个变量中保存的内存地址都是一样的，都指向方法区中的字节码文件。)

        // 第三种方式：java语言中任何一种类型，包括基本数据类型，它都有.class属性。
        Class i = Integer.class; //i代表Integer类型
        Class d = Date.class; // d代表Date类型
        Class f = float.class; //f代表float类型

        System.out.println(i == c2);//true
    }
}

/*
获取到Class，能干什么？
    通过Class的newInstance()方法来实例化对象。
    注意：newInstance()方法内部实际上调用了无参数构造方法，必须保证无参构造存在才可以。
 */
class ReflectTest02{
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        // 下面这段代码是以反射机制的方式创建对象。

        // 通过反射机制，获取Class，通过Class来实例化对象
        Class c = Class.forName("com.njganlili.fild.User");
        // newInstance() 这个方法会调用User这个类的无参数构造方法，完成对象的创建。
        // 重点是：newInstance()调用的是无参构造，必须保证无参构造是存在的！
        Object obj = c.getDeclaredConstructor().newInstance();
        System.out.println(obj);
    }
}

/*
验证反射机制的灵活性。
    java代码写一遍，再不改变java源代码的基础之上，可以做到不同对象的实例化。
    非常之灵活。（符合OCP开闭原则：对扩展开放，对修改关闭。）
 */
class ReflectTest03{
    public static void main(String[] args) throws Exception{
        // 以下代码是灵活的，代码不需要改动，可以修改配置文件，配置文件修改之后，可以创建出不同的实例对象。
        // 通过IO流读取reflectClassInfo.properties文件
        FileReader reader = new FileReader("Practice/reflectClassInfo1.properties");
        // 创建属性类对象Map
        Properties pro = new Properties();// key value都是String
        //加载
        pro.load(reader);
        reader.close();

        // 通过key获取value
        String className = pro.getProperty("className");

        // 通过反射机制实例化对象
        Class c = Class.forName(className);
        Object obj = c.getDeclaredConstructor().newInstance();
        System.out.println(obj);
    }
}

/*
研究一下：Class.forName()发生了什么？
    记住，重点：
        如果你只是希望一个类的静态代码块执行，其它代码一律不执行，
        你可以使用：
            Class.forName("完整类名");
        这个方法的执行会导致类加载，类加载时，静态代码块执行。

提示：
    后面JDBC技术的时候我们还需要。
 */
class ReflectTest04{
    public static void main(String[] args) throws ClassNotFoundException {
        // Class.forName()这个方法的执行会导致：类加载。
        Class.forName("com.njganlili.fild.Test.MyClass");
    }
}
class MyClass{
    static {
        System.out.println("MyClass中的静态代码块执行了！");
    }
}

/*
研究一下文件路径的问题。
怎么获取一个文件的绝对路径。以下讲解的这种方式是通用的。但前提是：文件需要在类路径下。才能用这种方式。
 */
class AboutPath{
    public static void main(String[] args) throws FileNotFoundException {
        // 这种方式的路径缺点是：移植性差，在IDEA中默认的当前路径是project的根。
        // 这个代码假设离开了IDEA，换到了其它位置，可能当前路径就不是project的根了，这时这个路径就无效了。
        File reader = new File("Practice/src/reflectClassInfo2.properties");
        System.out.println(reader.exists() + " " + reader.getPath());

        // 接下来说一种比较通用的一种路径。即使代码换位置了，这样编写仍然是通用的。
        // 注意：使用以下通用方式的前提是：这个文件必须在类路径下。
        // 什么类路径下？方式在src下的都是类路径下。【记住它】
        // src是类的根路径。
    /*
    解释：
        Thread.currentThread() 当前线程对象
        getContextClassLoader() 是线程对象的方法，可以获取到当前线程的类加载器对象。
        getResource() 【获取资源】这是类加载器对象的方法，当前线程的类加载器默认从类的根路径下加载资源。
     */
        String path = Thread.currentThread().getContextClassLoader().getResource("reflectClassInfo2.properties").getPath();
        // 采用以上的代码可以拿到一个文件的绝对路径。
        // /D:/996-CodeSection/001-IDEA/0.JavaSE/TestProject/out/production/practice/reflectClassInfo2.properties
        System.out.println(path);

        String path2 = Thread.currentThread().getContextClassLoader().getResource("javase/reflectBean/db.properties").getPath();
        // /D:/996-CodeSection/001-IDEA/0.JavaSE/TestProject/out/production/practice/javase/reflectBean/db.properties
        System.out.println(path2);
    }
}

class IoPropertiesTest{
    public static void main(String[] args) throws IOException {
        //以前
    /*String path = Thread.currentThread().getContextClassLoader().getResource("reflectClassInfo2.properties").getPath();
    FileReader reader = new FileReader(path);*/

        //现在
        // 直接以流的形式返回。
        InputStream reader = Thread.currentThread().getContextClassLoader().getResourceAsStream("reflectClassInfo2.properties");
        Properties pro = new Properties();
        pro.load(reader);
        reader.close();
        // 通过key获取value
        String className = pro.getProperty("className");
        System.out.println(className);// java.util.Date

    }
}

/*
java.util包下提供了一个资源绑定器，便于获取属性配置文件中的内容。
使用以下这种方式的时候，属性配置文件xxx.properties必须放到类路径下。
 */
class ResourceBundleTest{
    public static void main(String[] args) {
        // 资源绑定器，只能绑定xxx.properties文件。并且这个文件必须在类路径下。文件扩展名也必须是properties
        // 并且在写路径的时候，路径后面的扩展名不能写。
//        ResourceBundle bundle = ResourceBundle.getBundle("reflectClassInfo2");
        ResourceBundle bundle = ResourceBundle.getBundle("javase/reflectBean/db");
        String className = bundle.getString("className");
        System.out.println(className);

    }
}

/*
反射Student类当中所有的Field（了解一下）
 */
class ReflectTest05{
    public static void main(String[] args) throws Exception {
        Class studentClass = Class.forName("com.njganlili.fild.User");

        String className = studentClass.getName();// Class类的getName方法
        System.out.println("完整类名： " + className);
        String simpleName = studentClass.getSimpleName();// Class类的getName方法
        System.out.println("简类名： " + simpleName);

        //获取public修饰的属性
        Field[] fields1 = studentClass.getFields();
        System.out.println(fields1.length);// 2
        //System.out.println(fields1[0].getName() + " " + fields1[1].getName()); //Field类中的getName犯法

        System.out.println("----------------------");

        //获取所有的属性
        Field[] fields2 = studentClass.getDeclaredFields();
        System.out.println(fields2.length);
        for (Field f : fields2){
            System.out.println(f.getName());
        }

        System.out.println("----------------------");

        //获取属性的修饰符列表
        for (Field f : fields2){
            // 获取属性的修饰符列表,返回的修饰符是一个数字，每个数字是修饰符的代号
            // 用Modifier类的toString转换成字符串
            System.out.println(Modifier.toString(f.getModifiers()));
            System.out.println(f.getType().getSimpleName());// 获取属性的类型
            System.out.println(f.getName());// 获取属性的名字
        }
    }
}

//通过反射机制，反编译一个类的属性Field（了解一下）
class ReflectTest06{
    public static void main(String[] args) throws ClassNotFoundException {
        StringBuilder s = new StringBuilder();

        Class studentClass = Class.forName("com.njganlili.fild.User");
        s.append(Modifier.toString(studentClass.getModifiers()) + " class " + studentClass.getSimpleName() + " {\n");// Class类的getName方法
        //获取所有的属性
        Field[] fields = studentClass.getDeclaredFields();
        for (Field f : fields){
            s.append("\t");
            // 获取属性的修饰符列表,返回的修饰符是一个数字，每个数字是修饰符的代号
            // 用Modifier类的toString转换成字符串
            s.append(Modifier.toString(f.getModifiers()));
            if (f.getModifiers() != 0) s.append(" ");
            s.append(f.getType().getSimpleName());// 获取属性的类型
            s.append(" ");
            s.append(f.getName());// 获取属性的名字
            s.append(";\n");
        }
        s.append("}");
        System.out.println(s);
    }
}

/*
必须掌握：
    怎么通过反射机制访问一个java对象的属性？
        给属性赋值set
        获取属性的值get
 */
class ReflectTest07{
    public static void main(String[] args) throws Exception {
        //不使用反射机制给属性赋值
        User student = new User();
        /**给属性赋值三要素：给s对象的no属性赋值1111
         * 要素1：对象s
         * 要素2：no属性
         * 要素3：1111
         */
        student.setNo(1111);
        /**读属性值两个要素：获取s对象的no属性的值。
         * 要素1：对象s
         * 要素2：no属性
         */
        System.out.println(student.no);

        //使用反射机制给属性赋值
        Class studentClass = Class.forName("com.njganlili.fild.User");
        Object obj = studentClass.getDeclaredConstructor().newInstance();// obj就是Student对象。（底层调用无参数构造方法）

        // 获取no属性（根据属性的名称来获取Field）
        Field noField = studentClass.getDeclaredField("no");
        // 给obj对象(Student对象)的no属性赋值
    /*
        虽然使用了反射机制，但是三要素还是缺一不可：
            要素1：obj对象
            要素2：no属性
            要素3：22222值
        注意：反射机制让代码复杂了，但是为了一个“灵活”，这也是值得的。
     */
        noField.setAccessible(true);
        noField.set(obj, 22222);

        // 读取属性的值
        // 两个要素：获取obj对象的no属性的值。
        System.out.println(noField.get(obj));


        // 可以访问私有的属性吗？
        Field nameField = studentClass.getDeclaredField("no");
        // 打破封装（反射机制的缺点：打破封装，可能会给不法分子留下机会！！！）
        // 这样设置完之后，在外部也是可以访问private的。
        nameField.setAccessible(true);
        // 给name属性赋值
        nameField.set(obj, 11111);
        // 获取name属性的值
        System.out.println(nameField.get(obj));
    }
}

/*
作为了解内容（不需要掌握）：
    反射Method
 */
class ReflectTest08{
    public static void main(String[] args) throws ClassNotFoundException {
        Class userServiceClass = Class.forName("com.njganlili.fild.User");
        // 获取所有的Method（包括私有的！）
        Method[] methods = userServiceClass.getDeclaredMethods();
        for (Method m : methods){
            // 获取修饰符列表
            System.out.println(Modifier.toString(m.getModifiers()));
            // 获取方法的返回值类型
            System.out.println(m.getReturnType().getSimpleName());
            // 获取方法名
            System.out.println(m.getName());
            // 方法的修饰符列表（一个方法的参数可能会有多个。）
            Class[] parameterTypes = m.getParameterTypes();
            for (Class pts : parameterTypes){
                System.out.println(pts.getSimpleName());
            }
            System.out.println("------------------------");
        }
    }
}

/*
了解一下，不需要掌握（反编译一个类的方法。）
 */
class ReflectTest09{
    public static void main(String[] args) throws ClassNotFoundException {
        StringBuilder s = new StringBuilder();

        Class userServiceClass = Class.forName("java.lang.String");

        s.append(Modifier.toString(userServiceClass.getModifiers()));
        s.append(" class ");
        s.append(userServiceClass.getSimpleName());
        s.append(" {\n");

        // 获取所有的Method（包括私有的！）
        Method[] methods = userServiceClass.getDeclaredMethods();
        for (Method m : methods){
            s.append("\t");
            // 获取修饰符列表
            s.append(Modifier.toString(m.getModifiers()));
            s.append(" ");
            // 获取方法的返回值类型
            s.append(m.getReturnType().getSimpleName());
            s.append(" ");
            // 获取方法名
            s.append(m.getName());
            s.append("(");
            // 方法的修饰符列表（一个方法的参数可能会有多个。）
            Class[] parameterTypes = m.getParameterTypes();
            for (int i = 0; i < parameterTypes.length; i++){
                s.append(parameterTypes[i].getSimpleName());
                if (i != parameterTypes.length - 1) s.append(", ");
            }
            s.append(") {}\n");
        }
        s.append("}");
        System.out.println(s);
    }
}

/*
重点：必须掌握，通过反射机制怎么调用一个对象的方法？
    五颗星*****

    反射机制，让代码很具有通用性，可变化的内容都是写到配置文件当中，
    将来修改配置文件之后，创建的对象不一样了，调用的方法也不同了，
    但是java代码不需要做任何改动。这就是反射机制的魅力。
 */
class ReflectTest10{
    public static void main(String[] args) throws Exception {
        // 不使用反射机制，怎么调用方法
        // 创建对象
        User userService = new User();
        // 调用方法
    /*
        要素分析：
            要素1：对象userService
            要素2：login方法名
            要素3：实参列表
            要素4：返回值
     */
        System.out.println(userService.sout());

        //使用反射机制调用方法
        Class userServiceClass = Class.forName("com.njganlili.fild.User");
        // 创建对象
        Object obj = userServiceClass.getDeclaredConstructor().newInstance();
        // 获取Method
        Method loginMethod = userServiceClass.getDeclaredMethod("sout");
//        Method loginMethod = userServiceClass.getDeclaredMethod("login");//注：没有形参就不传
        // 调用方法
        // 调用方法有几个要素？ 也需要4要素。
        // 反射机制中最最最最最重要的一个方法，必须记住。
    /*
        四要素：
        loginMethod方法
        obj对象
        "admin","123" 实参
        retValue 返回值
     */
        Object resValues = loginMethod.invoke(obj);//注：方法返回值是void 结果是null
        System.out.println(resValues);
    }
}

/*
反编译一个类的Constructor构造方法。
 */
class ReflectTest11{
    public static void main(String[] args) throws ClassNotFoundException {
        StringBuilder s = new StringBuilder();

        Class vipClass = Class.forName("com.njganlili.fild.User");

        //public class UserService {
        s.append(Modifier.toString(vipClass.getModifiers()));
        s.append(" class ");
        s.append(vipClass.getSimpleName());
        s.append("{\n");

        Constructor[] constructors = vipClass.getDeclaredConstructors();
        for (Constructor c : constructors){
            //public Vip(int no, String name, String birth, boolean sex) {
            s.append("\t");
            s.append(Modifier.toString(c.getModifiers()));
            s.append(" ");
//            s.append(c.getName());//包名+类名
            s.append(vipClass.getSimpleName());//类名
            s.append("(");
            Class[] parameterTypes = c.getParameterTypes();
            for (int i = 0; i < parameterTypes.length; i++){
                s.append(parameterTypes[i].getSimpleName());
                if (i != parameterTypes.length - 1 ) s.append(", ");
            }
            s.append("){}\n");
        }

        s.append("}");
        System.out.println(s);
    }
}

/*
比上一个例子(ReflectTest11)重要一些！！！

通过反射机制调用构造方法实例化java对象。（这个不是重点）
 */
class ReflectTest12{
    public static void main(String[] args) throws Exception {
        //不适用反射创建对象
        User vip1 = new User();
        User vip2 = new User(123, 12);

        //使用反射机制创建对象（以前）
        Class vipClass = Class.forName("com.njganlili.fild.User");
        // 调用无参数构造方法
        Object obj1 = vipClass.newInstance();//Class类的newInstance方法
        System.out.println(obj1);

        //使用反射机制创建对象（现在）
        // 调用有参数的构造方法怎么办？
        // 第一步：先获取到这个有参数的构造方法
        Constructor c1 = vipClass.getDeclaredConstructor(int.class, int.class);
        // 第二步：调用构造方法new对象
        Object obj2 = c1.newInstance(321, 18);//Constructor类的newInstance方法
        System.out.println(obj2);

        // 获取无参数构造方法
        Constructor c2 = vipClass.getDeclaredConstructor();
        Object obj3 = c2.newInstance();
        System.out.println(obj3);
    }
}

/*
重点：给你一个类，怎么获取这个类的父类，已经实现了哪些接口？
 */
class ReflectTest13{
    public static void main(String[] args) throws Exception{
        // String举例
        Class vipClass = Class.forName("java.lang.String");
        // 获取String的父类
        Class superclass = vipClass.getSuperclass();
        // 获取String类实现的所有接口（一个类可以实现多个接口。）
        Class[] interfaces = vipClass.getInterfaces();
        System.out.println(superclass.getName());
        for (Class i : interfaces) {
            System.out.println(i.getName());
        }
    }
}

