package com.njganlili.mysql;


import com.mysql.cj.xdevapi.Result;

import java.sql.*;

/**
 * @author njgan
 * @description
 * @date 2022/2/16 9:35
 */
public class ConnectionBuilder {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Connection connection;
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/miky";
        String user = "root";
        String password = "123456";
        Class.forName(driver);
        connection = DriverManager.getConnection(url,user,password);
        if(!connection.isClosed()){
            System.out.println("连接成功");
        }
        Statement statement = connection.createStatement();
        String sql = "select * from user";
        ResultSet result = statement.executeQuery(sql);
        while (result.next()){
            System.out.println(result.getString("user_name"));
            System.out.println(result.getString("user_age"));
            System.out.println(result.getString("user_id_card"));
            System.out.println(result.getString("user_sex"));
        }
        Integer result1 = statement.executeUpdate(sql);


    }

}
