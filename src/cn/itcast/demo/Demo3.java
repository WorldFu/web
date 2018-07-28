package cn.itcast.demo;

import java.sql.*;

public class Demo3 {
    public static void main(String[] args) throws Exception{
        String username="张三";
        String password="123";
        System.out.println(login(username,password));
    }
    private static boolean login(String username,String password) throws Exception{
        Connection connection=null;
        PreparedStatement statement=null;
        ResultSet resultSet=null;
        try {
//            String mysqlUrl="jdbc:mysql://localhost:3306/mydb?useSSL=false&useUnicode=true&characterEncoding=utf8";
//            String mysqlUsername="root";
//            String mysqlPassword="123456";
//            connection= DriverManager.getConnection(mysqlUrl,mysqlUsername,mysqlPassword);
            connection=JdbcUtils.getConnection();
            String sql="select * from t_user where username=? AND password=?";
            statement=connection.prepareStatement(sql);
            statement.setString(1,username);
            statement.setString(2,password);
            resultSet=statement.executeQuery();
            return resultSet.next();
//            resultSet=statement.executeQuery(sql);
        }catch (Exception e){
            throw new  RuntimeException(e);
        }finally {
            if(resultSet!=null) resultSet.close();
            if (statement!=null) statement.close();
            if (connection!=null) connection.close();
        }
    }

}
