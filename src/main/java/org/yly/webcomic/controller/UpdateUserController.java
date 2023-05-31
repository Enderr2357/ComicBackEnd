package org.yly.webcomic.controller;

import org.yly.webcomic.entity.ComicUser;
import org.yly.webcomic.service.ComicUserService;
import org.yly.webcomic.service.impl.ComicUserServiceImpl;
import org.yly.webcomic.vo.ComicUserVO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/UpdateUser")
public class UpdateUserController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String Npassword=req.getParameter("Npassword");
        String Nusername=req.getParameter("newUsername");
        Long uid=Long.valueOf(req.getParameter("uId"));
        if(Npassword!=null){
            System.out.println(Npassword);
            System.out.println(uid);
            ComicUserServiceImpl comicUserService=new ComicUserServiceImpl();
            ComicUser comicUser=new ComicUser();
            comicUser=comicUserService.selectById(uid);
            comicUser.setUPassword(Npassword);
            Integer i= comicUserService.update(comicUser);
            if(i==1){
                System.out.println("修改成功");
                resp.setContentType("text/html;charset=utf-8");
                PrintWriter writer = resp.getWriter();
                writer.println(1);
            }
        }
        else{
            System.out.println(Nusername);
            ComicUserServiceImpl comicUserService=new ComicUserServiceImpl();
            ComicUser comicUser=new ComicUser();
            comicUser=comicUserService.selectById(uid);
            comicUser.setUName(Nusername);
            Integer i= comicUserService.update(comicUser);
            if(i==1){
                System.out.println("修改成功");
                resp.setContentType("text/html;charset=utf-8");
                PrintWriter writer = resp.getWriter();
                writer.println(1);
            }
        }
    }
}
