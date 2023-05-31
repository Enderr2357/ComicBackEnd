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
import java.util.List;

@WebServlet(urlPatterns = "/Register")
public class RegisterController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username=req.getParameter("username");
        String account=req.getParameter("account");
        String password=req.getParameter("psw");
        System.out.println(username+" "+account+" "+password+"");

        ComicUserServiceImpl comicUserService=new ComicUserServiceImpl();

        ComicUser result=comicUserService.selectByAccount(account);
        if(result!=null){
            resp.setContentType("text/html;charset=utf-8");
            PrintWriter writer = resp.getWriter();
            writer.println(0);
        }
        else{
        ComicUser comicUser=new ComicUser();
        List<ComicUser> comicUserList=comicUserService.selectAll();
        Long id=comicUserService.getMaxId();
        comicUser.setUId(id+1L);
        comicUser.setURole(0L);
        comicUser.setUName(username);
        comicUser.setUAccount(account);
        comicUser.setUPassword(password);
        Integer i=comicUserService.insert(comicUser);

        if(i!=null){
            System.out.println("添加成功");
            resp.setContentType("text/html;charset=utf-8");
            PrintWriter writer = resp.getWriter();
            writer.println(1);
        }

    }
    }
}
