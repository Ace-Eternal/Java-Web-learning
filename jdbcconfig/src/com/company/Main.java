package com.company;

import com.company.dao.StuDao;
import com.company.entity.Student;
import util.ConfigManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        StuDao stuDao=new StuDao();
        System.out.println(stuDao.getAll());
        System.out.println(stuDao.getById("222"));
        System.out.println(stuDao.insertStudent(new Student("小mm", false, "20211120013")));
    }
}
