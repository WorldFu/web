package cn.itcast.demo;

import java.sql.*;

public class Demo {
    public static void main(String[] args) throws ClassNotFoundException,SQLException{
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url="jdbc:mysql://localhost:3306/mydb?useSSL=false&useUnicode=true&characterEncoding=utf8";
        String username="root";
        String password="123456";
        Connection connection= DriverManager.getConnection(url,username,password);
        Statement statement=connection.createStatement();
        String sql="select * FROM stu";
        ResultSet set=statement.executeQuery(sql);
        while (set.next()){
            String itnum=set.getString(1);
            String name=set.getString("name");
            System.out.println(itnum+":"+name);
        }
        set.close();
        statement.close();
        connection.close();

    }
}
