package org.yly.webcomic.controller;

import org.yly.webcomic.entity.ComicUser;
import org.yly.webcomic.service.impl.ComicUserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "login",urlPatterns = "/login.html")
public class LoginController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("1");

        String account=req.getParameter("useraccount");
        System.out.println(account);
        ComicUserServiceImpl comicUserService=new ComicUserServiceImpl();
        ComicUser comicUser=comicUserService.selectByAccount(account);
        System.out.println(comicUser);
        if (comicUser!=null) {
            resp.setContentType("text/html;charset=utf-8");
            PrintWriter writer = resp.getWriter();
            writer.println("登录成功！");
            System.out.println("登陆成功");
        }
        if (comicUser==null){
            System.out.println("账号错误");
        }
    }

}
