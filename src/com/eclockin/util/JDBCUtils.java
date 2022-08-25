package com.eclockin.util;

import java.sql.*;
import java.util.ResourceBundle;

public class JDBCUtils {

    /*
     * ���ݿ�����
     */
    public static Connection getConnection() {

        //��ȡ�ļ�����
        ResourceBundle bundle = ResourceBundle.getBundle("jdbc");
        String DRIVER = bundle.getString("driver");
        String URL = bundle.getString("url");
        String USER = bundle.getString("user");
        String PWD = bundle.getString("password");

        Connection con = null;
        try {
            // ��������
            Class.forName(DRIVER);
            // ��ȡ���Ӷ���
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
     * �ر�������Դ
     * @param con	���Ӷ���
     * @param pstmt	Ԥ�������
     * @param rs	�����
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