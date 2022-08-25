package com.eclockin.ui;

import com.eclockin.dao.StudentDao;
import com.eclockin.entity.Student;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class LoginFrame extends JFrame {

    public static void main(String[] args) {
        new LoginFrame();
    }

    private JPanel contentPane;
    private StudentDao studentDao = new StudentDao();

    //�������
    public LoginFrame() {
        setTitle("��¼");
        setResizable(false); // ���ɸı䴰�ڴ�С
        setBounds(100, 100, 360, 200);
        setLocationRelativeTo(null); // Ĭ�Ͼ�����ʾ
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // �رռ��˳�

        contentPane = new JPanel();
        contentPane.setLayout(null);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane); // ��Ӹ�����������

        JLabel lblNewLabel = new JLabel("ѧ��:");
        lblNewLabel.setBounds(60, 30, 43, 15);

        JTextField idText = new JTextField();
        idText.setBounds(100, 27, 160, 21);

        JLabel lblNewLabel_1 = new JLabel("����:");
        lblNewLabel_1.setBounds(60, 60, 43, 15);

        JTextField passwordText = new JTextField();
        passwordText.setBounds(100, 57, 160, 21);

        JButton button1 = new JButton("��¼");
        button1.setBounds(110, 90, 60, 30);
        button1.addActionListener((e) -> {
            String id = idText.getText();
            String password = passwordText.getText();
            boolean student = studentDao.queryLogin(id, password);
            if (student) {
                JOptionPane.showMessageDialog(contentPane, "��¼�ɹ�", "ϵͳ��ʾ", JOptionPane.WARNING_MESSAGE);
                new MainFrame();
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(contentPane, "�˻������û����������", "ϵͳ��ʾ", JOptionPane.WARNING_MESSAGE);
                return;
            }
        });

        JButton button2 = new JButton("ע��");
        button2.setBounds(200, 90, 60, 30);
        button2.addActionListener((e) -> {
            JFrame loginF = new AddView("ע���˺�");
            loginF.setVisible(true);
        });


        contentPane.add(idText);
        contentPane.add(passwordText);
        contentPane.add(lblNewLabel_1);
        contentPane.add(lblNewLabel);
        contentPane.add(button1);
        contentPane.add(button2);

        this.setVisible(true);
    }
}
