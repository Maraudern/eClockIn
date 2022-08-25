package com.eclockin.ui;

import com.eclockin.entity.ClockIn;
import com.eclockin.entity.Student;
import com.eclockin.util.JDBCUtils;

import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

import javax.swing.*;

import com.eclockin.dao.StudentDao;
import com.eclockin.entity.Student;

public class MainFrame extends JFrame {

    public static void main(String[] args) {
        new MainFrame();
    }

    private JPanel contentPane;
    private StudentDao studentDao = new StudentDao();

    public MainFrame() {

        this.setTitle("E打卡");
        this.setResizable(false); // 不可改变窗口大小
        this.setSize(360, 750); // 设置宽高
        this.setLocationRelativeTo(null); // 默认居中显示
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 关闭即退出

        contentPane = new JPanel();
        contentPane.setLayout(null);
        contentPane.setBounds(0, 200, 360, 750);
        contentPane.setOpaque(true); // 背景设为不透明
        contentPane.setBackground(Color.white); // 背景白色
        contentPane.setForeground(Color.black); // 前景黑色
        setContentPane(contentPane); // 添加根容器到窗口

        JMenuBar menuBar = new JMenuBar();
        this.setJMenuBar(menuBar);
        JMenu menu = new JMenu("菜单");
        menuBar.add(menu);
        JMenuItem menuItem = new JMenuItem("历史记录");
        JMenuItem menuItem_1 = new JMenuItem("账号管理");
        JMenuItem menuItem_2 = new JMenuItem("退出登录");
        menu.add(menuItem);
        menu.add(menuItem_1);
        menu.add(menuItem_2);
        menu.setBounds(0, 0, 360, 20);
        menuItem.addActionListener((e) -> {
            new HistoryFrame();
            this.dispose();
        });
        menuItem_1.addActionListener((e) -> {
            UserListView frame = new UserListView();
            frame.setVisible(true);
            this.dispose();
        });
        menuItem_2.addActionListener((e) -> {
            new LoginFrame();
            this.dispose();
        });

        // 顶部文本
        JLabel label1 = new JLabel();
        label1.setText("每日健康打卡");
        label1.setHorizontalAlignment(0); // 水平居中对齐
        label1.setVerticalAlignment(0); // 垂直居中对齐
        label1.setFont(new Font("微软雅黑", Font.BOLD, 14));
        label1.setBounds(0, 0, 360, 30);
        contentPane.add(label1);

        // 基本信息
        JLabel label2 = new JLabel();
        label2.setText("  基本信息");
        label2.setOpaque(true);
        label2.setBackground(Color.LIGHT_GRAY);
        label2.setBounds(0, 30, 360, 20);

        JLabel label3 = new JLabel();
        label3.setText("姓名");
        label3.setBounds(10, 50, 100, 30);
        JLabel label4 = new JLabel();
        label4.setText("学号");
        label4.setBounds(10, 80, 100, 30);
        JLabel label5 = new JLabel();
        label5.setText("户籍所在地");
        label5.setBounds(10, 110, 100, 30);
        JLabel label6 = new JLabel();
        label6.setText("当前住址");
        label6.setBounds(10, 140, 100, 30);
        JLabel label7 = new JLabel();
        label7.setText("所在校区");
        label7.setBounds(10, 170, 100, 30);
        JLabel label8 = new JLabel();
        label8.setText("打卡位置");
        label8.setBounds(10, 200, 100, 30);

        JTextField textField1 = new JTextField();
        textField1.setBounds(110, 50, 230, 30);
        JTextField textField2 = new JTextField();
        textField2.setBounds(110, 80, 230, 30);
        JTextField textField3 = new JTextField();
        textField3.setBounds(110, 110, 230, 30);
        JTextField textField4 = new JTextField();
        textField4.setBounds(110, 140, 230, 30);
        JComboBox<String> comboBox1 = new JComboBox<>();
        comboBox1.setBounds(110, 170, 230, 30);
        comboBox1.addItem("下沙校区");
        comboBox1.addItem("南浔校区");
        JTextField textField5 = new JTextField();
        textField5.setBounds(110, 200, 230, 30);

        contentPane.add(label2);
        contentPane.add(label3);
        contentPane.add(label4);
        contentPane.add(label5);
        contentPane.add(label6);
        contentPane.add(label7);
        contentPane.add(label8);
        contentPane.add(textField1);
        contentPane.add(textField2);
        contentPane.add(textField3);
        contentPane.add(textField4);
        contentPane.add(comboBox1);
        contentPane.add(textField5);

        // 今日健康信息
        JLabel label9 = new JLabel();
        label9.setText("  今日健康信息");
        label9.setOpaque(true);
        label9.setBackground(Color.LIGHT_GRAY);
        label9.setBounds(0, 230, 360, 20);

        JLabel label10 = new JLabel();
        label10.setText("晨检体温:");
        label10.setBounds(10, 250, 350, 30);
        JRadioButton radioButton1 = new JRadioButton("37℃以下");
        radioButton1.setBounds(10, 280, 350, 30);
        radioButton1.setBackground(Color.white);
        JRadioButton radioButton2 = new JRadioButton("37℃~37.2℃");
        radioButton2.setBounds(10, 310, 350, 30);
        radioButton2.setBackground(Color.white);
        JRadioButton radioButton3 = new JRadioButton("37.2℃以上");
        radioButton3.setBounds(10, 340, 350, 30);
        radioButton3.setBackground(Color.white);
        ButtonGroup buttonGroup1 = new ButtonGroup();
        buttonGroup1.add(radioButton1);
        buttonGroup1.add(radioButton2);
        buttonGroup1.add(radioButton3);

        JLabel label11 = new JLabel();
        label11.setText("身体状况:");
        label11.setBounds(10, 370, 350, 30);
        JCheckBox checkBox1 = new JCheckBox("正常");
        checkBox1.setBounds(10, 400, 350, 30);
        checkBox1.setBackground(Color.white);
        JCheckBox checkBox2 = new JCheckBox("感冒");
        checkBox2.setBounds(10, 430, 350, 30);
        checkBox2.setBackground(Color.white);
        JCheckBox checkBox3 = new JCheckBox("发烧");
        checkBox3.setBounds(10, 460, 350, 30);
        checkBox3.setBackground(Color.white);
        JCheckBox checkBox4 = new JCheckBox("呼吸困难");
        checkBox4.setBounds(10, 490, 350, 30);
        checkBox4.setBackground(Color.white);
        JCheckBox checkBox5 = new JCheckBox("咽痛,咳嗽");
        checkBox5.setBounds(10, 520, 350, 30);
        checkBox5.setBackground(Color.white);
        JCheckBox checkBox6 = new JCheckBox("腹泻");
        checkBox6.setBounds(10, 550, 350, 30);
        checkBox6.setBackground(Color.white);
        JCheckBox checkBox7 = new JCheckBox("其它");
        checkBox7.setBounds(10, 580, 350, 30);
        checkBox7.setBackground(Color.white);

        contentPane.add(label9);
        contentPane.add(label10);
        contentPane.add(radioButton1);
        contentPane.add(radioButton2);
        contentPane.add(radioButton3);
        contentPane.add(label11);
        contentPane.add(checkBox1);
        contentPane.add(checkBox2);
        contentPane.add(checkBox3);
        contentPane.add(checkBox4);
        contentPane.add(checkBox5);
        contentPane.add(checkBox6);
        contentPane.add(checkBox7);

        // 真实性承诺
        JLabel label12 = new JLabel();
        label12.setText("  真实性承诺");
        label12.setOpaque(true);
        label12.setBackground(Color.LIGHT_GRAY);
        label12.setBounds(0, 610, 360, 20);
        JCheckBox checkBox8 = new JCheckBox("本人承诺以上数据真实性");
        checkBox8.setBounds(10, 630, 350, 30);
        checkBox8.setBackground(Color.white);

        contentPane.add(label12);
        contentPane.add(checkBox8);

        // 提交
        JButton button1 = new JButton("提交");
        button1.setBounds(150, 660, 60, 25);
        button1.setEnabled(false);
        button1.addActionListener((e) -> {
            ClockIn clockIn = new ClockIn();
            clockIn.setName(textField1.getText());
            clockIn.setId(textField2.getText());
            clockIn.setDate(new Date());
            if (radioButton1.isSelected()) {
                clockIn.setTmp("体温37℃以下");
            } else if (radioButton2.isSelected()) {
                clockIn.setTmp("体温37℃~37.2℃");
            } else if (radioButton3.isSelected()) {
                clockIn.setTmp("体温7.2℃以上");
            }
            boolean flag = studentDao.saveClock(clockIn);
            if (flag) {
                JOptionPane.showMessageDialog(contentPane, "提交成功！");
            } else {
                JOptionPane.showMessageDialog(contentPane, "学号不正确或信息未填写完整！", "系统提示", JOptionPane.WARNING_MESSAGE);
            }
            return;
        });
        checkBox8.addActionListener((e) -> {
            button1.setEnabled(checkBox8.isSelected());
        });

        contentPane.add(button1);
        this.setVisible(true);
    }
}
