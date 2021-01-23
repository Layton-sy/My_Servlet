package com.hjj.servletProject.servlet.controller;

import com.hjj.servletProject.entity.Admin;
import com.hjj.servletProject.entity.Manager;
import com.hjj.servletProject.service.AdminService;
import com.hjj.servletProject.service.impl.AdminServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * @author Layton
 * @version 1.0
 * @date 2021/1/13 21:05
 */
@WebServlet("/showAllController")
public class ShowAllAdminController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //通过HttpSession完成权限控制
        HttpSession session = req.getSession();
        Manager manager = (Manager) session.getAttribute("mgr");
        if(manager != null){
            //证明已经登录过了
            //调用业务逻辑功能
            AdminService adminService = new AdminServiceImpl();

            List<Admin> admins = adminService.showAllAdmin();

            //request作用域存数据
            req.setAttribute("admins",admins);
            //通过转发 跳转到显示结果servlet
            req.getRequestDispatcher("/showAllJSP").forward(req,resp);
        }else{
            //证明没有登录，帮你跳转到登录界面
            resp.sendRedirect("/My_Servlet_war_exploded/loginMgr.html");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
