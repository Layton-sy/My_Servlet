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
import java.io.PrintWriter;

/**
 * @author Layton
 * @version 1.0
 * @date 2020/11/21 15:36
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        //1.收参
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        //2.调用业务逻辑
        AdminService adminService = new AdminServiceImpl();
        Admin admin = adminService.Login(username,password);
        //3.处理结果
        PrintWriter pw = resp.getWriter();
        if(admin != null){
            //响应给客户端一个结果页面，显示登录成功
            pw.println("<html>");
            pw.println("<head>");
            pw.println("<meta charset='UTF-8'>");
            pw.println("<title>结果页面</title>");
            pw.println("</head>");
            pw.println("<body>");
            pw.println("<h1>登录成功</h1>");
            pw.println("</body>");
            pw.println("</html>");
        }else{
            //响应给客户端一个结果页面，显示登录失败
            pw.println("<html>");
            pw.println("<head>");
            pw.println("<meta charset='UTF-8'>");
            pw.println("<title>结果页面</title>");
            pw.println("</head>");
            pw.println("<body>");
            pw.println("<h1>登录失败</h1>");
            pw.println("</body>");
            pw.println("</html>");
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
