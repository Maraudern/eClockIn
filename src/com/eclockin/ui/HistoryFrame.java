package com.eclockin.ui;

import com.eclockin.entity.ClockIn;
import com.eclockin.util.JDBCUtils;

import java.awt.event.*;
import java.sql.*;
import java.util.*;

import javax.swing.*;

public class HistoryFrame extends JFrame{

    public static Connection con = null;
    public static PreparedStatement pstmt = null;

    public static void main(String[] args) {
        new HistoryFrame();

    }


    public HistoryFrame(){
        this.setSize(500, 500);// 设置窗口大小
        this.setLocationRelativeTo(null);// 设置窗口居中
        // 关闭时打开MainFrame
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                new MainFrame();
                dispose();
            }
        });

        con = JDBCUtils.getConnection();

        List<ClockIn> list = this.aaa();//调用当前类对象并把数据存入Student类中
        String[] index = {"学号", "姓名", "日期", "体温"};//表格的第一行文字
        Object[][] data = new Object[list.size()][index.length];
        //向data中添加数据
        for (int i = 0; i < list.size(); i++) {
            ClockIn clockIn = list.get(i);
            data[i][0] = clockIn.getId();
            data[i][1] = clockIn.getName();
            data[i][2] = clockIn.getDate();
            data[i][3] = clockIn.getTmp();
        }
        JTable JT = new JTable(data, index);//创建表格，第一个参数为显示的数据（数组），第二个数组是表格的第一行文字
        //VERTICAL_SCROLLBAR_AS_NEEDED纵向,HORIZONTAL_SCROLLBAR_AS_NEEDED横向
        JScrollPane JS = new JScrollPane(JT, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        this.setVisible(true);// 显示窗口
        this.add(JS);//将滚动条加入窗口
    }
    public List<ClockIn> aaa() {
        List<ClockIn> list = new ArrayList();//创建集合，用于存查询到的数据
        String sql = "select * from clock_in";//查询的sql语句
        try {        //3,连接对象con的方法prepareStatement获取SQL语句的预编译对象
            pstmt = con.prepareStatement(sql);
            ResultSet result = pstmt.executeQuery();
            while (result.next()) {
                ClockIn clockIn = new ClockIn();
                clockIn.setId(result.getString("id"));
                clockIn.setName(result.getString("name"));
                clockIn.setDate(result.getDate("date"));
                clockIn.setTmp(result.getString("tmp"));
                list.add(clockIn);
                System.out.println("id:" + result.getObject("id") + " " + "name:" + result.getObject("name") + " "
                        + "date:" + result.getString("date") + " " + "tmp:" + result.getString("tmp"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}