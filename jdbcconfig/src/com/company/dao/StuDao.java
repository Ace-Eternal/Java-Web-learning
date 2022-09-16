package com.company.dao;

import com.company.entity.Student;
import util.ConfigManager;
import util.ConnectionCreactor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StuDao {
    //数据操作接口
    private ConnectionCreactor connectionCreactor;
    public StuDao(){
        connectionCreactor=new ConnectionCreactor();//每次调Dao创建一次连接
    }

    //获取学生列表
    public List<Student>getAll(){
        Connection connection=null;
        Statement statement=null;
        ResultSet resultSet=null;
        List<Student>result=new ArrayList();

        try{
            connection=this.connectionCreactor.createconn();
            connection.createStatement();
            statement=connection.createStatement();

            String sql="select * from studnetinfo";//查询用statement可以了，有条件的查询要用preparedstatement
            resultSet = statement.executeQuery(sql);
            while(resultSet.next()) {
                Student student=new Student();
                String name=resultSet.getString("StudentName");
                boolean sex=resultSet.getBoolean("StudentSex");
                String id=resultSet.getString("StudentId");
                student.setStudentName(name);
                student.setStudentSex(sex);
                student.setStudentId(id);
                result.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    //获取指定id学生
    public Student getById(String id){
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        Student student=new Student();//不能设置为null
        try{
            String sql="select * from studnetinfo where StudentId=?";//先预执行sql语句，然后放？的数据，最后执行
            connection=this.connectionCreactor.createconn();
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,id);
            resultSet=preparedStatement.executeQuery();
                resultSet.next();
                String name=resultSet.getString("StudentName");
                boolean sex=resultSet.getBoolean("StudentSex");
                student.setStudentName(name);
                student.setStudentSex(sex);
                student.setStudentId(id);

        }catch(Exception e){
            e.printStackTrace();
        }
        return student;
    }
    public Boolean insertStudent(Student student){
        Connection connection=connectionCreactor.createconn();
        String sql="insert into studnetinfo(StudentName,StudentSex,StudentId) values(?,?,?) ";
        int result=0;
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,student.getStudentName());
            preparedStatement.setBoolean(2,student.getStudentSex());
            preparedStatement.setString(3,student.getStudentId());
            result=preparedStatement.executeUpdate();//executeUpdate返回insert update delete 更新行数，执行失败返回0
            //executeQuery返回select结果集
            //execute 包括了sql所有操作,true 说明返回结果集，false说明返回行数;
        } catch (SQLException e) {
            e.printStackTrace();
        }if(result!=0){
            return true;
        }else{
            return false;
        }
    }
}
