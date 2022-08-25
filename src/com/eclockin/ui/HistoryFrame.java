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
        this.setSize(500, 500);// ���ô��ڴ�С
        this.setLocationRelativeTo(null);// ���ô��ھ���
        // �ر�ʱ��MainFrame
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                new MainFrame();
                dispose();
            }
        });

        con = JDBCUtils.getConnection();

        List<ClockIn> list = this.aaa();//���õ�ǰ����󲢰����ݴ���Student����
        String[] index = {"ѧ��", "����", "����", "����"};//���ĵ�һ������
        Object[][] data = new Object[list.size()][index.length];
        //��data���������
        for (int i = 0; i < list.size(); i++) {
            ClockIn clockIn = list.get(i);
            data[i][0] = clockIn.getId();
            data[i][1] = clockIn.getName();
            data[i][2] = clockIn.getDate();
            data[i][3] = clockIn.getTmp();
        }
        JTable JT = new JTable(data, index);//������񣬵�һ������Ϊ��ʾ�����ݣ����飩���ڶ��������Ǳ��ĵ�һ������
        //VERTICAL_SCROLLBAR_AS_NEEDED����,HORIZONTAL_SCROLLBAR_AS_NEEDED����
        JScrollPane JS = new JScrollPane(JT, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        this.setVisible(true);// ��ʾ����
        this.add(JS);//�����������봰��
    }
    public List<ClockIn> aaa() {
        List<ClockIn> list = new ArrayList();//�������ϣ����ڴ��ѯ��������
        String sql = "select * from clock_in";//��ѯ��sql���
        try {        //3,���Ӷ���con�ķ���prepareStatement��ȡSQL����Ԥ�������
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