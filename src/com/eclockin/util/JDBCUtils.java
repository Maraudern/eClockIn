package com.eclockin.util;

import java.sql.*;
import java.util.ResourceBundle;

public class JDBCUtils {

    /*
     * 数据库连接
     */
    public static Connection getConnection() {

        //获取文件参数
        ResourceBundle bundle = ResourceBundle.getBundle("jdbc");
        String DRIVER = bundle.getString("driver");
        String URL = bundle.getString("url");
        String USER = bundle.getString("user");
        String PWD = bundle.getString("password");

        Connection con = null;
        try {
            // 加载驱动
            Class.forName(DRIVER);
            // 获取连接对象
            con = DriverManager.getConnection(URL, USER, PWD);
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return con;
    }

    /**
     * 关闭连接资源
     * @param con	连接对象
     * @param pstmt	预编译对象
     * @param rs	结果集
     */
    public static void close(Connection con, PreparedStatement pstmt, ResultSet rs) {

        try {
            if (rs != null){
                rs.close();
            }
            if (pstmt != null){
                pstmt.close();
            }
            if (con != null){
                con.close();
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}