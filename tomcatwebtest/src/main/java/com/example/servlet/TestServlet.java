package com.example.servlet;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/test")
public class TestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        resp.getWriter().write("<h1>HttpServlet是Servlet接口的一个实现类<h1>");
    }
}
//Servlet 生命周期
//构造函数完成Servlet的初始化
//调init()完成初始化
//使用Service()完成响应、
//destroy()关闭
//jvm垃圾回收
