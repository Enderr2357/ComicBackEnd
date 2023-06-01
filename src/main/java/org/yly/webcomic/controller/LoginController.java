package org.yly.webcomic.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
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
        String password=req.getParameter("password");

        System.out.println(account+""+password);
        ComicUserServiceImpl comicUserService=new ComicUserServiceImpl();
        ComicUser comicUser=comicUserService.selectByAccount(account);
        if (comicUser!=null) {
            System.out.println("查找到用户");
           String Dpassword=comicUser.getUPassword();
            System.out.println(Dpassword);
            if(password.equals(Dpassword)){
                System.out.println("登陆成功");
                ObjectMapper mapper = new ObjectMapper();
                String json=mapper.writeValueAsString(comicUser);
                resp.setContentType("application/json; charset=utf-8");//设置响应编码
                resp.getWriter().write(json);
                System.out.println(1);
            }

        }
        if (comicUser==null){
            System.out.println("账号错误");
            resp.setContentType("text/html;charset=utf-8");
            PrintWriter writer = resp.getWriter();
            writer.println(0);
        }
    }

}
