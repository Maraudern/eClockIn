package com.eclockin.ui;


import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.eclockin.dao.StudentDao;
import com.eclockin.entity.Student;

public class UserListView extends JFrame {

    private JPanel contentPane;
    private JTable table;
    private JTextField nameText;

    private StudentDao studentDao = new StudentDao();

    //�������
    public UserListView() {
        setVisible(true);
        setTitle("ѧ���б�");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 337);
        setResizable(false); // ���ɸı䴰�ڴ�С
        setLocationRelativeTo(null);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 39, 764, 232);
        contentPane.add(scrollPane);

        Object[] columns = {"ID", "ѧ��", "����" ,"����", "�꼶", "���ʱ��"};// �ֶ�
        Object[][] data = null;// ��Ҫչʾ������
        DefaultTableModel model = new DefaultTableModel(data, columns);
        table = new JTable(model);
        //����ѧ������
        load(null);
        scrollPane.setViewportView(table);

        JLabel lblNewLabel = new JLabel("����");
        lblNewLabel.setBounds(10, 10, 42, 15);
        contentPane.add(lblNewLabel);

        nameText = new JTextField();
        nameText.setBounds(44, 8, 115, 21);
        contentPane.add(nameText);
        nameText.setColumns(10);

        //��ѯ��ť
        JButton searchBtn = new JButton("��ѯ");
        searchBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                load(nameText.getText());
            }
        });
        searchBtn.setBounds(169, 8, 63, 23);
        contentPane.add(searchBtn);

        //��Ӱ�ť
        JButton addBtn = new JButton("���");
        addBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AddView view = new AddView(0);
                view.setVisible(true);
            }
        });
        addBtn.setBounds(365, 8, 63, 23);
        contentPane.add(addBtn);

        //�޸İ�ť
        JButton updateBtn = new JButton("�޸�");
        updateBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // ��ȡѡ����
                int row = table.getSelectedRow();
                if (row < 0) {
                    JOptionPane.showMessageDialog(contentPane, "��ѡ��һ����¼", "ϵͳ��ʾ", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                int id = Integer.valueOf(table.getValueAt(row, 0).toString());
                UpdateView view = new UpdateView(id);
                view.setVisible(true);

            }
        });
        updateBtn.setBounds(438, 8, 63, 23);

        //ɾ����ť
        JButton deleteBtn = new JButton("ɾ��");
        deleteBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // ��ȡѡ����
                int row = table.getSelectedRow();
                if (row < 0) {
                    JOptionPane.showMessageDialog(contentPane, "��ѡ��һ����¼", "ϵͳ��ʾ", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                int result = JOptionPane.showConfirmDialog(contentPane, "ȷ��ɾ����ѧ����", "��ʾ",
                        JOptionPane.YES_NO_OPTION);
                if (result == 0) {
                    int id = Integer.valueOf(table.getValueAt(row, 0).toString());
                    boolean flag = studentDao.delete(id);
                    if (flag) {
                        JOptionPane.showMessageDialog(contentPane, "ɾ���ɹ�!");
                        load(null);
                    } else {
                        JOptionPane.showMessageDialog(contentPane, "����ʧ��", "ϵͳ��ʾ", JOptionPane.WARNING_MESSAGE);

                    }
                }
                return;
            }
        });
        deleteBtn.setBounds(511, 8, 63, 23);
        contentPane.add(deleteBtn);
        contentPane.add(updateBtn);

        //���ذ�ť
        JButton backBtn = new JButton("����");
        backBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new MainFrame("E��");
                dispose();
            }
        });
        backBtn.setBounds(700, 8, 63, 23);
        contentPane.add(backBtn);
    }

    // �������������
    public void load(String name) {
        List<Student> list = studentDao.queryList(name);
        DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
        tableModel.setRowCount(0);// ���ԭ����
        // �������
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for (Student item : list) {
            String[] arr = new String[6];
            arr[0] = item.getId() + "";
            arr[1] = item.getStuno();
            arr[2] = item.getPassword();
            arr[3] = item.getName();
            arr[4] = item.getGrade();
            arr[5] = sdf.format(item.getCreatTime());
            // ������ݵ����
            tableModel.addRow(arr);
        }
    }
}
