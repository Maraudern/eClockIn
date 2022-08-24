package com.eclockin.ui;

import java.awt.*;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 * 主界面
 */
public class MainFrame extends JFrame {

    //启动e打卡界面
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MainFrame frame = new MainFrame();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public MainFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 关闭即退出
        this.setSize(360, 750); // 设置宽高
        this.setResizable(false); // 不可改变窗口大小
        this.setLocationRelativeTo(null); // 默认居中显示
        JPanel rootPanel = new JPanel();
        rootPanel.setLayout(null);
        rootPanel.setBounds(0, 200, 360, 750);
        rootPanel.setOpaque(true); // 背景设为不透明
        rootPanel.setBackground(Color.white); // 背景白色
        rootPanel.setForeground(Color.black); // 前景黑色
        rootPanel.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        this.setContentPane(rootPanel); // 添加根容器到窗口

        // 顶部文本
        JLabel label1 = new JLabel();
        label1.setText("每日健康打卡");
        label1.setHorizontalAlignment(0); // 水平居中对齐
        label1.setVerticalAlignment(0); // 垂直居中对齐
        label1.setFont(new Font("微软雅黑", Font.BOLD, 16));
        label1.setBounds(0, 0, 360, 50);
        rootPanel.add(label1);

        // 基本信息
        JLabel label2 = new JLabel();
        label2.setText("  基本信息");
        label2.setOpaque(true);
        label2.setBackground(Color.LIGHT_GRAY);
        label2.setBounds(0, 50, 360, 20);

        JLabel label3 = new JLabel();
        label3.setText("姓名");
        label3.setBounds(10, 70, 100, 30);
        JLabel label4 = new JLabel();
        label4.setText("学号");
        label4.setBounds(10, 100, 100, 30);
        JLabel label5 = new JLabel();
        label5.setText("户籍所在地");
        label5.setBounds(10, 130, 100, 30);
        JLabel label6 = new JLabel();
        label6.setText("当前住址");
        label6.setBounds(10, 160, 100, 30);
        JLabel label7 = new JLabel();
        label7.setText("所在校区");
        label7.setBounds(10, 190, 100, 30);
        JLabel label8 = new JLabel();
        label8.setText("打卡位置");
        label8.setBounds(10, 220, 100, 30);

        JTextField textField1 = new JTextField();
        textField1.setBounds(110, 70, 230, 30);
        JTextField textField2 = new JTextField();
        textField2.setBounds(110, 100, 230, 30);
        JTextField textField3 = new JTextField();
        textField3.setBounds(110, 130, 230, 30);
        JTextField textField4 = new JTextField();
        textField4.setBounds(110, 160, 230, 30);
        JComboBox<String> comboBox1 = new JComboBox<>();
        comboBox1.setBounds(110, 190, 230, 30);
        comboBox1.addItem("下沙校区");
        comboBox1.addItem("南浔校区");
        JTextField textField5 = new JTextField();
        textField5.setBounds(110, 220, 230, 30);

        rootPanel.add(label2);
        rootPanel.add(label3);
        rootPanel.add(label4);
        rootPanel.add(label5);
        rootPanel.add(label6);
        rootPanel.add(label7);
        rootPanel.add(label8);
        rootPanel.add(textField1);
        rootPanel.add(textField2);
        rootPanel.add(textField3);
        rootPanel.add(textField4);
        rootPanel.add(comboBox1);
        rootPanel.add(textField5);

        // 今日健康信息
        JLabel label9 = new JLabel();
        label9.setText("  今日健康信息");
        label9.setOpaque(true);
        label9.setBackground(Color.LIGHT_GRAY);
        label9.setBounds(0, 250, 360, 20);

        JLabel label10 = new JLabel();
        label10.setText("晨检体温:");
        label10.setBounds(10, 270, 350, 30);
        JRadioButton radioButton1 = new JRadioButton("37℃以下");
        radioButton1.setBounds(10, 300, 350, 30);
        radioButton1.setBackground(Color.white);
        JRadioButton radioButton2 = new JRadioButton("37℃~37.2℃");
        radioButton2.setBounds(10, 330, 350, 30);
        radioButton2.setBackground(Color.white);
        JRadioButton radioButton3 = new JRadioButton("37.2℃以上");
        radioButton3.setBounds(10, 360, 350, 30);
        radioButton3.setBackground(Color.white);
        ButtonGroup buttonGroup1 = new ButtonGroup();
        buttonGroup1.add(radioButton1);
        buttonGroup1.add(radioButton2);
        buttonGroup1.add(radioButton3);

        JLabel label11 = new JLabel();
        label11.setText("身体状况:");
        label11.setBounds(10, 390, 350, 30);
        JCheckBox checkBox1 = new JCheckBox("正常");
        checkBox1.setBounds(10, 420, 350, 30);
        checkBox1.setBackground(Color.white);
        JCheckBox checkBox2 = new JCheckBox("感冒");
        checkBox2.setBounds(10, 450, 350, 30);
        checkBox2.setBackground(Color.white);
        JCheckBox checkBox3 = new JCheckBox("发烧");
        checkBox3.setBounds(10, 480, 350, 30);
        checkBox3.setBackground(Color.white);
        JCheckBox checkBox4 = new JCheckBox("呼吸困难");
        checkBox4.setBounds(10, 510, 350, 30);
        checkBox4.setBackground(Color.white);
        JCheckBox checkBox5 = new JCheckBox("咽痛,咳嗽");
        checkBox5.setBounds(10, 540, 350, 30);
        checkBox5.setBackground(Color.white);
        JCheckBox checkBox6 = new JCheckBox("腹泻");
        checkBox6.setBounds(10, 570, 350, 30);
        checkBox6.setBackground(Color.white);
        JCheckBox checkBox7 = new JCheckBox("其它");
        checkBox7.setBounds(10, 600, 350, 30);
        checkBox7.setBackground(Color.white);

        rootPanel.add(label9);
        rootPanel.add(label10);
        rootPanel.add(radioButton1);
        rootPanel.add(radioButton2);
        rootPanel.add(radioButton3);
        rootPanel.add(label11);
        rootPanel.add(checkBox1);
        rootPanel.add(checkBox2);
        rootPanel.add(checkBox3);
        rootPanel.add(checkBox4);
        rootPanel.add(checkBox5);
        rootPanel.add(checkBox6);
        rootPanel.add(checkBox7);

        // 真实性承诺
        JLabel label12 = new JLabel();
        label12.setText("  真实性承诺");
        label12.setOpaque(true);
        label12.setBackground(Color.LIGHT_GRAY);
        label12.setBounds(0, 630, 360, 20);
        JCheckBox checkBox8 = new JCheckBox("本人承诺以上数据真实性");
        checkBox8.setBounds(10, 650, 350, 30);
        checkBox8.setBackground(Color.white);

        rootPanel.add(label12);
        rootPanel.add(checkBox8);

        // 提交
        JButton button1=new JButton("提交");
        button1.setBounds(150, 680, 60, 30);
        button1.setEnabled(false);

        checkBox8.addActionListener((e) -> {
            button1.setEnabled(checkBox8.isSelected());
        });

        rootPanel.add(button1);

        this.setVisible(true);
    }
}
