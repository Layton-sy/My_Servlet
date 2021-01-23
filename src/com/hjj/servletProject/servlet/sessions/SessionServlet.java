package com.hjj.servletProject.servlet.sessions;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "SessionServlet",value = "/ss")
public class SessionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        //1.通过request对象获取session对象
//        HttpSession session = request.getSession();
//        //2.查看sessionId
//        System.out.println(session.getId());
//
//        //保存数据
//        session.setAttribute("key",value);
//        //获取数据
//        session.getAttribute("key");
//        //移除数据
//        session.removeAttribute("key");
//
//        session.setMaxInactiveInterval(seconds);
////        session.invalidate();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
