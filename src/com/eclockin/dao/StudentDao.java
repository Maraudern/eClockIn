package com.eclockin.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.eclockin.entity.Student;
import com.eclockin.entity.ClockIn;
import com.eclockin.util.JDBCUtils;

/**
 * ѧ�����ݿ����
 */
public class StudentDao {

    public static Connection con = null;
    public static PreparedStatement pstmt = null;

    //��ѯѧ���б�
    public List<Student> queryList(String name) {

        List<Student> list = new ArrayList<Student>();
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            con = JDBCUtils.getConnection();
            String sql = "select * from Student";
            //3,���Ӷ���con�ķ���prepareStatement��ȡSQL����Ԥ�������
            PreparedStatement parameter = con.prepareStatement(sql);
            //4,ִ��sql
            ResultSet result = parameter.executeQuery();
            while (result.next()) {

                Student Student = new Student();
                Student.setId(result.getString("id"));
                Student.setName(result.getString("name"));
                Student.setPassword(result.getString("password"));
                Student.setGrade(result.getString("grade"));
                list.add(Student);
                System.out.println("id:" + result.getObject("id") + " " + "name:" + result.getObject("name") + " "
                        + "password:" + result.getString("password") + " " + "grade:" + result.getString("grade"));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            JDBCUtils.close(con, pstmt, rs);
        }
        return list;

    }



    //����ѧ����Ϣ
    public boolean save(Student student) {

        Connection con = null;
        String sql = "insert into student(id,password,name,grade,create_time,update_time) values(?,?,?,?,?,?)";
        PreparedStatement pstmt = null;
        try {
            con = JDBCUtils.getConnection();
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, student.getId());
            pstmt.setString(2, student.getPassword());
            pstmt.setString(3, student.getName());
            pstmt.setString(4, student.getGrade());
            Date date = new Date();
            pstmt.setTimestamp(5, new Timestamp(date.getTime()));
            pstmt.setTimestamp(6, new Timestamp(date.getTime()));
            int rows = pstmt.executeUpdate();
            if (rows > 0) {
                return true;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            JDBCUtils.close(con, pstmt, null);
        }
        return false;

    }

    //�ύ�����ݱ���Ϣ
    public boolean saveClock(ClockIn clockIn) {

        Connection con = null;
        String sql = "insert into clock_in(clock_id,id,name,date,tmp) values(?,?,?,?,?)";
        PreparedStatement pstmt = null;
        try {
            con = JDBCUtils.getConnection();
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, clockIn.getClockId());
            pstmt.setString(2, clockIn.getId());
            pstmt.setString(3, clockIn.getName());
            Date date = new Date();
            pstmt.setTimestamp(4, new Timestamp(date.getTime()));
            pstmt.setString(5, clockIn.getTmp());
            int rows = pstmt.executeUpdate();
            if (rows > 0) {
                return true;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            JDBCUtils.close(con, pstmt, null);
        }
        return false;

    }

    //
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


    //�޸�ѧ����Ϣ
    public boolean update(Student student) {

        Connection con = null;
        String sql = "update student set password=?,name=?,grade=?,update_time=? where id=?";
        PreparedStatement pstmt = null;
        try {
            con = JDBCUtils.getConnection();
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, student.getPassword());
            pstmt.setString(2, student.getName());
            pstmt.setString(3, student.getGrade());
            Date date = new Date();
            pstmt.setTimestamp(4, new Timestamp(date.getTime()));
            pstmt.setString(5, student.getId());
            int rows = pstmt.executeUpdate();
            if (rows > 0) {
                return true;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            JDBCUtils.close(con, pstmt, null);
        }
        return false;

    }

    //ɾ��ѧ����Ϣ
    public boolean delete(String id) {

        Connection con = null;
        String sql = "delete from student where id=?";
        PreparedStatement pstmt = null;
        try {
            con = JDBCUtils.getConnection();
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, id);
            int rows = pstmt.executeUpdate();
            if (rows > 0) {
                return true;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            JDBCUtils.close(con, pstmt, null);
        }
        return false;

    }

    //����ID��ѯѧ��
    public Student getById(String id) {

        Student student = null;
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            con = JDBCUtils.getConnection();
            String sql = "select * from student where id = ?";
            pstmt = con.prepareStatement(sql);
            pstmt.setObject(1, id);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                student = new Student();
                student.setId(rs.getString("id"));
                student.setPassword(rs.getString("password"));
                student.setName(rs.getString("name"));
                student.setGrade(rs.getString("grade"));
                student.setCreatTime(rs.getDate("create_time"));
                student.setUpdateTime(rs.getDate("update_time"));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            JDBCUtils.close(con, pstmt, rs);
        }
        return student;

    }

    //��¼�˺�
    public boolean queryLogin(String stuno, String password) {

        ResultSet rs = null;
        Connection con = null;
        Statement stmt = null;
        try {
            con = JDBCUtils.getConnection();
            stmt = con.createStatement();
            String sql = "select * from student where id = '" + stuno + "'and password = '" + password + "'";
            rs = stmt.executeQuery(sql);
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //�ر�����
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }
}