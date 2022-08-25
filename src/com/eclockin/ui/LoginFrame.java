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
        setResizable(false); // ���ɸı䴰�ڴ�С
        setBounds(100, 100, 360, 200);
        setLocationRelativeTo(null); // Ĭ�Ͼ�����ʾ

        JPanel rootPanel = new JPanel();
        rootPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(rootPanel);
        rootPanel.setLayout(null);
        rootPanel.setOpaque(true); // ������Ϊ��͸��
        rootPanel.setBackground(Color.white); // ������ɫ
        rootPanel.setForeground(Color.black); // ǰ����ɫ
        rootPanel.setFont(new Font("΢���ź�", Font.PLAIN, 14));
        this.setContentPane(rootPanel); // ��Ӹ�����������
        this.setTitle("��¼");

        JLabel lblNewLabel = new JLabel("ѧ��:");
        lblNewLabel.setBounds(60, 30, 43, 15);

        JTextField stunoText = new JTextField();
        stunoText.setBounds(100, 27, 160, 21);

        JLabel lblNewLabel_1 = new JLabel("����:");
        lblNewLabel_1.setBounds(60, 60, 43, 15);

        JTextField passwordText = new JTextField();
        passwordText.setBounds(100, 57, 160, 21);

        JButton button1 = new JButton("��¼");
        button1.setBounds(110, 90, 60, 30);
        button1.addActionListener((e) -> {
            String stuno = stunoText.getText();
            String password = passwordText.getText();
            boolean student = studentDao.queryLogin(stuno, password);
            if (student) {
                JOptionPane.showMessageDialog(contentPane, "��¼�ɹ�", "ϵͳ��ʾ", JOptionPane.WARNING_MESSAGE);
                new MainFrame("E��");
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(contentPane, "�˻������û����������", "ϵͳ��ʾ", JOptionPane.WARNING_MESSAGE);
                return;
            }
        });

        JButton button2 = new JButton("ע��");
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
