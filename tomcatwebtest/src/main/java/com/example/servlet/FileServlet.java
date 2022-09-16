package com.example.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import org.apache.commons.io.IOUtils;
import org.apache.ibatis.io.Resources;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
@MultipartConfig
@WebServlet("/file")
public class FileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("image/png");
        OutputStream outputStream= resp.getOutputStream();
        InputStream inputStream= Resources.getResourceAsStream("all-application.png");
        IOUtils.copy(inputStream,outputStream);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        FileOutputStream fileOutputStream=new FileOutputStream("D:\\code\\tomcatwebtest\\src\\main\\resources\\all-application.png");
        Part part=req.getPart("test-file");
        IOUtils.copy(part.getInputStream(),fileOutputStream);
        resp.setContentType("text/html;charset=UTF-8");
        resp.getWriter().write("文件上传成功");
    }
}
