package org.yly.webcomic.controller;

import org.yly.webcomic.service.impl.ComicUserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/DeleteUser")
public class DeleteUserController extends HttpServlet {

    ComicUserServiceImpl comicUserService=new ComicUserServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id=Long.valueOf(req.getParameter("id"));

        Integer i=comicUserService.delete(id);
        if(i==1){
            resp.setContentType("text/html;charset=utf-8");
            PrintWriter writer = resp.getWriter();
            writer.println(1);
        }
    }
}
