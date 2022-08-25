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

public class UpdateView extends JFrame {

    private JPanel contentPane;
    private JTextField idText;
    private JTextField passwordText;
    private JTextField nameText;
    private JTextField gradeText;

    private StudentDao studentDao = new StudentDao();

    //创建框架
    public UpdateView(final String id) {
        setTitle("修改信息");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 443, 300);
        setResizable(false); // 不可改变窗口大小
        setLocationRelativeTo(null);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("学号：");
        lblNewLabel.setBounds(112, 40, 43, 15);
        contentPane.add(lblNewLabel);

        idText = new JTextField();
        idText.setBounds(151, 37, 160, 21);
        contentPane.add(idText);
        idText.setColumns(10);

        JLabel lblNewLabel_1 = new JLabel("密码：");
        lblNewLabel_1.setBounds(112, 70, 43, 15);
        contentPane.add(lblNewLabel_1);

        passwordText = new JTextField();
        passwordText.setBounds(151, 67, 160, 21);
        contentPane.add(passwordText);
        passwordText.setColumns(10);

        JLabel lblNewLabel_2 = new JLabel("姓名：");
        lblNewLabel_2.setBounds(112, 100, 43, 15);
        contentPane.add(lblNewLabel_2);

        nameText = new JTextField();
        nameText.setBounds(151, 97, 160, 21);
        contentPane.add(nameText);
        nameText.setColumns(10);

        JLabel lblNewLabel_3 = new JLabel("班级：");
        lblNewLabel_3.setBounds(111, 130, 43, 15);
        contentPane.add(lblNewLabel_3);

        gradeText = new JTextField();
        gradeText.setBounds(151, 127, 160, 21);
        contentPane.add(gradeText);
        gradeText.setColumns(10);

        //保存
        JButton saveBtn = new JButton("保存");
        saveBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String stuno = idText.getText();
                String password = passwordText.getText();
                String name = nameText.getText();
                String grade = gradeText.getText();
                if (stuno == null || "".equals(stuno)) {
                    JOptionPane.showMessageDialog(contentPane, "请输入学号", "系统提示", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                if (password == null || "".equals(password)) {
                    JOptionPane.showMessageDialog(contentPane, "请输入密码", "系统提示", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                if (name == null || "".equals(name)) {
                    JOptionPane.showMessageDialog(contentPane, "请输入姓名", "系统提示", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                if (grade == null || "".equals(grade)) {
                    JOptionPane.showMessageDialog(contentPane, "请输入班级", "系统提示", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                Student student = new Student();
                student.setId(id);
                student.setPassword(password);
                student.setName(name);
                student.setGrade(grade);
                boolean flag = studentDao.update(student);
                if (flag) {
                    dispose();
                    JOptionPane.showMessageDialog(contentPane, "修改成功，刷新可查看!");
                } else {
                    JOptionPane.showMessageDialog(contentPane, "操作失败", "系统提示", JOptionPane.WARNING_MESSAGE);
                }
                return;


            }
        });
        saveBtn.setBounds(151, 180, 74, 23);
        contentPane.add(saveBtn);

        //取消
        JButton cancleBtn = new JButton("取消");
        cancleBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        cancleBtn.setBounds(237, 180, 74, 23);
        contentPane.add(cancleBtn);

        //数据回显
        Student student = studentDao.getById(id);
        idText.setText(student.getId());
        passwordText.setText(student.getPassword());
        nameText.setText(student.getName());
        gradeText.setText(student.getGrade());
    }

}
