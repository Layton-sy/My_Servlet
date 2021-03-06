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
import java.io.PipedWriter;
import java.io.PrintWriter;
import java.util.List;

/**
 * @author Layton
 * @version 1.0
 * @date 2020/11/23 18:36
 */
@WebServlet("/showall")
public class ShowAllAdminServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html;charset=utf-8");

        AdminService adminService = new AdminServiceImpl();

        List<Admin> admins = adminService.showAllAdmin();

        PrintWriter pw = resp.getWriter();

        if(admins != null){
            pw.println("<html>");
            pw.println("<head>");
            pw.println("<meta charset='UTF-8'>");
            pw.println("<title>显示所有</title>");
            pw.println("</head>");
            pw.println("<body>");

            pw.println("<table>");
            pw.println("    <tr>");
            pw.println("        <td>username</td>");
            pw.println("        <td>password</td>");
            pw.println("        <td>phone</td>");
            pw.println("        <td>address</td>");
            pw.println("    </tr>");
            for(Admin admin: admins){
                pw.println("    <tr>");
                pw.println("        <td>"+admin.getUsername()+"</td>");
                pw.println("        <td>"+admin.getPassword()+"</td>");
                pw.println("        <td>"+admin.getPhone()+"</td>");
                pw.println("        <td>"+admin.getAddress()+"</td>");
                pw.println("    </tr>");
            }
            pw.println("</table>");
            pw.println("</body>");
            pw.println("</html>");
        }else{
            pw.println("<html>");
            pw.println("<head>");
            pw.println("<meta charset='UTF-8>");
            pw.println("<title>显示所有<title>");
            pw.println("</head>");
            pw.println("<body>");
            pw.println("<h3>当前没有用户<h3>");
            pw.println("</body>");
            pw.println("</html>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
