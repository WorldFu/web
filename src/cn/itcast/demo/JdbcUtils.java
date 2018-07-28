package cn.itcast.demo;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcUtils {
    private static Properties props=null;
    static {
        try {
            InputStream in=JdbcUtils.class.getClassLoader().getResourceAsStream("dbconfig.properties");
            props=new Properties();
            props.load(in);
            in.close();
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }
    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(props.getProperty("url"),props.getProperty("username")
                ,props.getProperty("password"));
    }
}
