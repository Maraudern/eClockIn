package com.eclockin.ui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.eclockin.dao.StudentDao;
import com.eclockin.entity.Student;

public class AddView extends JFrame {

    private JPanel contentPane;
    private JTextField stunoText;
    private JTextField passwordText;
    private JTextField nameText;
    private JTextField gradeText;

    private StudentDao studentDao = new StudentDao();

    //�����޸���Ϣ
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AddView frame = new AddView(0);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    //�������
    public AddView(final int i) {
        if (i == 0) {
            setTitle("ѧ�����");
        } else if (i == 1) {
            setTitle("ע���˺�");
        }
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 443, 300);
        setResizable(false); // ���ɸı䴰�ڴ�С
        setLocationRelativeTo(null);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("ѧ�ţ�");
        lblNewLabel.setBounds(112, 40, 43, 15);
        contentPane.add(lblNewLabel);

        stunoText = new JTextField();
        stunoText.setBounds(151, 37, 160, 21);
        contentPane.add(stunoText);
        stunoText.setColumns(10);

        JLabel lblNewLabel_1 = new JLabel("���룺");
        lblNewLabel_1.setBounds(112, 70, 43, 15);
        contentPane.add(lblNewLabel_1);

        passwordText = new JTextField();
        passwordText.setBounds(151, 67, 160, 21);
        contentPane.add(passwordText);
        passwordText.setColumns(10);

        JLabel lblNewLabel_2 = new JLabel("������");
        lblNewLabel_2.setBounds(112, 100, 43, 15);
        contentPane.add(lblNewLabel_2);

        nameText = new JTextField();
        nameText.setBounds(151, 97, 160, 21);
        contentPane.add(nameText);
        nameText.setColumns(10);

        JLabel lblNewLabel_3 = new JLabel("�༶��");
        lblNewLabel_3.setBounds(111, 130, 43, 15);
        contentPane.add(lblNewLabel_3);

        gradeText = new JTextField();
        gradeText.setBounds(151, 127, 160, 21);
        contentPane.add(gradeText);
        gradeText.setColumns(10);

        //����
        JButton saveBtn = new JButton("����");
        saveBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String stuno = stunoText.getText();
                String password = passwordText.getText();
                String name = nameText.getText();
                String grade = gradeText.getText();
                if (stuno == null || "".equals(stuno)) {
                    JOptionPane.showMessageDialog(contentPane, "������ѧ��", "ϵͳ��ʾ", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                if (password == null || "".equals(password)) {
                    JOptionPane.showMessageDialog(contentPane, "����������", "ϵͳ��ʾ", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                if (name == null || "".equals(name)) {
                    JOptionPane.showMessageDialog(contentPane, "����������", "ϵͳ��ʾ", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                if (grade == null || "".equals(grade)) {
                    JOptionPane.showMessageDialog(contentPane, "������༶", "ϵͳ��ʾ", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                Student student = new Student();
                student.setPassword(password);
                student.setStuno(stuno);
                student.setName(name);
                student.setGrade(grade);
                boolean flag = studentDao.save(student);
                if (flag) {
                    dispose();
                    JOptionPane.showMessageDialog(contentPane, "��ӳɹ�!");
                } else {
                    JOptionPane.showMessageDialog(contentPane, "����ʧ��", "ϵͳ��ʾ", JOptionPane.WARNING_MESSAGE);
                }
                return;


            }
        });
        saveBtn.setBounds(151, 180, 74, 23);
        contentPane.add(saveBtn);

        //ȡ��
        JButton cancleBtn = new JButton("ȡ��");
        cancleBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        cancleBtn.setBounds(237, 180, 74, 23);
        contentPane.add(cancleBtn);
    }

}