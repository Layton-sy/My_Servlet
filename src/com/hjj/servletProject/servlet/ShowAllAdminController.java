package com.hjj.servletProject.servlet;

import com.hjj.servletProject.entity.Admin;
import com.hjj.servletProject.service.AdminService;
import com.hjj.servletProject.service.impl.AdminServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
        //只负责调用业务逻辑功能
        AdminService adminService = new AdminServiceImpl();

        List<Admin> admins = adminService.showAllAdmin();

        //request作用域存数据
        req.setAttribute("admins",admins);
        //通过转发 跳转到显示结果servlet
        req.getRequestDispatcher("/showAllJSP").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
