package com.hjj.servletProject.servlet.cookies;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * @author Layton
 * @version 1.0
 * @date 2021/1/16 11:54
 */
@WebServlet("/test")
public class CookieTest extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //创建cookie
        Cookie cookie = new Cookie("hjj","123456");
        cookie.setPath("/My_Servlet_war_exploded/get1");//设置cookie的路径
        cookie.setMaxAge(-1);//内存储存，取值有三种：>0为有效期，单位为秒；=0浏览器关闭；<0内存存储，默认为-1
        resp.addCookie(cookie);
        //注意：有效路径：当前访问的资源的上一级目录，不带主机名

        Cookie cookie2 = new Cookie("hjj2","123");
        cookie2.setPath("/My_Servlet_war_exploded/get2");//设置cookie的路径
        cookie2.setMaxAge(-1);//内存储存，取值有三种：>0为有效期，单位为秒；=0浏览器关闭；<0内存存储，默认为-1
        resp.addCookie(cookie2);

//        //获取cookie
//        Cookie[] cookies = req.getCookies();
//        for (Cookie cookie : cookies) {
//            if(cookie.getName().equals("目标name")){
//                String code = cookie.getValue();//获取value
//                break;
//            }
//        }

//        //修改cookie
//        Cookie cookie = new Cookie("name","vlaue");//name写需要修改的cookie的name
//        cookie.setPath("/webs");//有效路径也是原来的
//        cookie.setMaxAge(-1);
//        resp.addCookie(cookie);//添加进cookie，也就是覆盖

//        //创建带中文的cookie
//        Cookie cookie = new Cookie(
//                URLEncoder.encode("姓名","UTF-8"),
//                URLEncoder.encode("黄某人","UTF-8")
//        );

//        //读取带中文的cookie
//        if(req.getCookies() != null){
//            for(Cookie cookie : req.getCookies()){
//                String name = URLDecoder.decode(cookie.getName(),"UTF-8");
//                String vlaue = URLDecoder.decode(cookie.getValue(),"UTF-8");
//            }
//        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
