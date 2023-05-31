package org.yly.webcomic.controller;

import org.yly.webcomic.service.impl.ComicListServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/DeleteComic")
public class DeleteComicController extends HttpServlet {
    ComicListServiceImpl comicListService=new ComicListServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id= req.getParameter("id");
        System.out.println("删除"+Long.valueOf(id));
       Integer i= comicListService.delete(Long.valueOf(id));
        if(i==1)
        {
            System.out.println("删除成功");
            resp.setContentType("text/html;charset=utf-8");
            PrintWriter writer = resp.getWriter();
            writer.println(1);
        }


    }
}
