package com.eclockin.ui;

import com.eclockin.dao.StudentDao;
import com.eclockin.entity.Student;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class LoginFrame extends JFrame {

    private JPanel contentPane;

    private StudentDao studentDao = new StudentDao();

    public LoginFrame(String title) {
        setTitle(title);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false); // 不可改变窗口大小
        setBounds(100, 100, 360, 200);
        setLocationRelativeTo(null); // 默认居中显示

        JPanel rootPanel = new JPanel();
        rootPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(rootPanel);
        rootPanel.setLayout(null);
        rootPanel.setOpaque(true); // 背景设为不透明
        rootPanel.setBackground(Color.white); // 背景白色
        rootPanel.setForeground(Color.black); // 前景黑色
        rootPanel.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        this.setContentPane(rootPanel); // 添加根容器到窗口
        this.setTitle("登录");

        JLabel lblNewLabel = new JLabel("学号:");
        lblNewLabel.setBounds(60, 30, 43, 15);

        JTextField stunoText = new JTextField();
        stunoText.setBounds(100, 27, 160, 21);

        JLabel lblNewLabel_1 = new JLabel("密码:");
        lblNewLabel_1.setBounds(60, 60, 43, 15);

        JTextField passwordText = new JTextField();
        passwordText.setBounds(100, 57, 160, 21);

        JButton button1 = new JButton("登录");
        button1.setBounds(110, 90, 60, 30);
        button1.addActionListener((e) -> {
            String stuno = stunoText.getText();
            String password = passwordText.getText();
            boolean student = studentDao.queryLogin(stuno, password);
            if (student) {
                JOptionPane.showMessageDialog(contentPane, "登录成功", "系统提示", JOptionPane.WARNING_MESSAGE);
                new MainFrame("E打卡");
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(contentPane, "账户或者用户名输入错误", "系统提示", JOptionPane.WARNING_MESSAGE);
                return;
            }
        });

        JButton button2 = new JButton("注册");
        button2.setBounds(200, 90, 60, 30);
        button2.addActionListener((e) -> {
            JFrame loginF = new AddView(1);
            loginF.setVisible(true);
        });


        rootPanel.add(stunoText);
        rootPanel.add(passwordText);
        rootPanel.add(lblNewLabel_1);
        rootPanel.add(lblNewLabel);
        rootPanel.add(button1);
        rootPanel.add(button2);

        this.setVisible(true);
    }
}
