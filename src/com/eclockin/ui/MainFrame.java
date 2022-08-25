package com.eclockin.ui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class MainFrame extends JFrame {
    public MainFrame(String title) {
        this.setTitle(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // �رռ��˳�
        this.setSize(360, 750); // ���ÿ��
        this.setResizable(false); // ���ɸı䴰�ڴ�С
        this.setLocationRelativeTo(null); // Ĭ�Ͼ�����ʾ
        JPanel rootPanel = new JPanel();
        rootPanel.setLayout(null);
        rootPanel.setBounds(0, 200, 360, 750);
        rootPanel.setOpaque(true); // ������Ϊ��͸��
        rootPanel.setBackground(Color.white); // ������ɫ
        rootPanel.setForeground(Color.black); // ǰ����ɫ
        rootPanel.setFont(new Font("΢���ź�", Font.PLAIN, 14));
        this.setContentPane(rootPanel); // ��Ӹ�����������

        JMenuBar menuBar1 = new JMenuBar();
        this.setJMenuBar(menuBar1);
        JMenu menu1 = new JMenu("�˵�");
        menuBar1.add(menu1);
        JMenuItem menuItem1 = new JMenuItem("��ʷ��¼");
        JMenuItem menuItem2 = new JMenuItem("�˳���¼");
        JMenuItem menuItem3 = new JMenuItem("�˺Ź���");
        menu1.add(menuItem1);
        menu1.add(menuItem2);
        menu1.add(menuItem3);
        menu1.setBounds(0, 0, 360, 20);
        menuItem2.addActionListener((e)->{
            new LoginFrame("��¼");
            this.dispose();
        });
        menuItem3.addActionListener((e)->{
            new UserListView();
            this.dispose();
        });

        // �����ı�
        JLabel label1 = new JLabel();
        label1.setText("ÿ�ս�����");
        label1.setHorizontalAlignment(0); // ˮƽ���ж���
        label1.setVerticalAlignment(0); // ��ֱ���ж���
        label1.setFont(new Font("΢���ź�", Font.BOLD, 14));
        label1.setBounds(0, 0, 360, 30);
        rootPanel.add(label1);

        // ������Ϣ
        JLabel label2 = new JLabel();
        label2.setText("  ������Ϣ");
        label2.setOpaque(true);
        label2.setBackground(Color.LIGHT_GRAY);
        label2.setBounds(0, 30, 360, 20);

        JLabel label3 = new JLabel();
        label3.setText("����");
        label3.setBounds(10, 50, 100, 30);
        JLabel label4 = new JLabel();
        label4.setText("ѧ��");
        label4.setBounds(10, 80, 100, 30);
        JLabel label5 = new JLabel();
        label5.setText("�������ڵ�");
        label5.setBounds(10, 110, 100, 30);
        JLabel label6 = new JLabel();
        label6.setText("��ǰסַ");
        label6.setBounds(10, 140, 100, 30);
        JLabel label7 = new JLabel();
        label7.setText("����У��");
        label7.setBounds(10, 170, 100, 30);
        JLabel label8 = new JLabel();
        label8.setText("��λ��");
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
        comboBox1.addItem("��ɳУ��");
        comboBox1.addItem("���У��");
        JTextField textField5 = new JTextField();
        textField5.setBounds(110, 200, 230, 30);

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

        // ���ս�����Ϣ
        JLabel label9 = new JLabel();
        label9.setText("  ���ս�����Ϣ");
        label9.setOpaque(true);
        label9.setBackground(Color.LIGHT_GRAY);
        label9.setBounds(0, 230, 360, 20);

        JLabel label10 = new JLabel();
        label10.setText("��������:");
        label10.setBounds(10, 250, 350, 30);
        JRadioButton radioButton1 = new JRadioButton("37������");
        radioButton1.setBounds(10, 280, 350, 30);
        radioButton1.setBackground(Color.white);
        JRadioButton radioButton2 = new JRadioButton("37��~37.2��");
        radioButton2.setBounds(10, 310, 350, 30);
        radioButton2.setBackground(Color.white);
        JRadioButton radioButton3 = new JRadioButton("37.2������");
        radioButton3.setBounds(10, 340, 350, 30);
        radioButton3.setBackground(Color.white);
        ButtonGroup buttonGroup1 = new ButtonGroup();
        buttonGroup1.add(radioButton1);
        buttonGroup1.add(radioButton2);
        buttonGroup1.add(radioButton3);

        JLabel label11 = new JLabel();
        label11.setText("����״��:");
        label11.setBounds(10, 370, 350, 30);
        JCheckBox checkBox1 = new JCheckBox("����");
        checkBox1.setBounds(10, 400, 350, 30);
        checkBox1.setBackground(Color.white);
        JCheckBox checkBox2 = new JCheckBox("��ð");
        checkBox2.setBounds(10, 430, 350, 30);
        checkBox2.setBackground(Color.white);
        JCheckBox checkBox3 = new JCheckBox("����");
        checkBox3.setBounds(10, 460, 350, 30);
        checkBox3.setBackground(Color.white);
        JCheckBox checkBox4 = new JCheckBox("��������");
        checkBox4.setBounds(10, 490, 350, 30);
        checkBox4.setBackground(Color.white);
        JCheckBox checkBox5 = new JCheckBox("��ʹ,����");
        checkBox5.setBounds(10, 520, 350, 30);
        checkBox5.setBackground(Color.white);
        JCheckBox checkBox6 = new JCheckBox("��к");
        checkBox6.setBounds(10, 550, 350, 30);
        checkBox6.setBackground(Color.white);
        JCheckBox checkBox7 = new JCheckBox("����");
        checkBox7.setBounds(10, 580, 350, 30);
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

        // ��ʵ�Գ�ŵ
        JLabel label12 = new JLabel();
        label12.setText("  ��ʵ�Գ�ŵ");
        label12.setOpaque(true);
        label12.setBackground(Color.LIGHT_GRAY);
        label12.setBounds(0, 610, 360, 20);
        JCheckBox checkBox8 = new JCheckBox("���˳�ŵ����������ʵ��");
        checkBox8.setBounds(10, 630, 350, 30);
        checkBox8.setBackground(Color.white);

        rootPanel.add(label12);
        rootPanel.add(checkBox8);

        // �ύ
        JButton button1 = new JButton("�ύ");
        button1.setBounds(150, 660, 60, 25);
        button1.setEnabled(false);

        checkBox8.addActionListener((e) -> {
            button1.setEnabled(checkBox8.isSelected());
        });

        rootPanel.add(button1);
        this.setVisible(true);
    }
}
