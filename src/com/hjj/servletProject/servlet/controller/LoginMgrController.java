package com.hjj.servletProject.servlet.controller;

import com.hjj.servletProject.entity.Manager;
import com.hjj.servletProject.service.ManagerService;
import com.hjj.servletProject.service.impl.ManagerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LoginMgrController",value = "/loginMgr")
public class LoginMgrController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.处理乱码
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        //2.接受页面传入的用户名和密码
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //3.调用业务方法
        ManagerService managerService = new ManagerServiceImpl();
        Manager manager = managerService.login(username,password);
        //4.处理结果
        if(manager != null){
            //登录成功
            //将管理员信息存储在session里
            HttpSession session = request.getSession();
            session.setAttribute("mgr",manager);
            //跳转 目标 方式
            response.sendRedirect("/My_Servlet_war_exploded/showAllController");
            System.out.println("登录成功");
        }else{
            //登录失败，跳转回登录页面
            response.sendRedirect("/My_Servlet_war_exploded/loginMgr.html");
            System.out.println("登录失败" + username + " " + password);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
