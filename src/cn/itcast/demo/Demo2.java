package cn.itcast.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Demo2 {
    public static void main(String[] args) throws Exception{
        Connection connection=null;
        Statement statement=null;
        ResultSet resultSet=null;
        try {
            String url="jdbc:mysql://localhost:3306/mydb?useSSL=false&useUnicode=true&characterEncoding=utf8";
            String username="root";
            String password="123456";
            connection= DriverManager.getConnection(url,username,password);
            statement=connection.createStatement();
            String sql="select * from stu";
            resultSet=statement.executeQuery(sql);
//            while (resultSet.next()){
//                System.out.println(resultSet.getString("name")+":"
//                        +resultSet.getString("age"));
//            }
            int count=resultSet.getMetaData().getColumnCount();
            while (resultSet.next()){
                for (int i=1;i<=count;i++){
                    System.out.print(resultSet.getString(i));
                    if (i<count){
                        System.out.print(", ");
                    }
                }
                System.out.println();
            }
        }catch (Exception e){
            throw  new RuntimeException(e);
        }finally {
            if (resultSet!=null) resultSet.close();
            if (statement!=null)statement.close();
            if (connection!=null)connection.close();
        }
    }
}
