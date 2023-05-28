package org.yly.webcomic.controller;

import com.alibaba.fastjson.JSONArray;
import org.yly.webcomic.entity.ComicList;
import org.yly.webcomic.service.impl.ComicListServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/comicName")
public class ComicNameController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String comicname=req.getParameter("comicname");
        ComicListServiceImpl comicListService =new ComicListServiceImpl();
        System.out.println(comicname);
        if (!comicname.equals(null)) {
            if (comicname.equals("all")) {
                List<ComicList> comicLists = comicListService.selectAll();
                JSONArray jsonArray = new JSONArray();
                String json = jsonArray.toJSONString(comicLists);
                resp.setContentType("application/json; charset=utf-8");//设置响应编码
                resp.getWriter().write(json);
            }
            else{
                List<ComicList> comicLists=comicListService.selectByCategory(Long.valueOf(comicname));
                JSONArray jsonArray = new JSONArray();
                String json = jsonArray.toJSONString(comicLists);
                resp.setContentType("application/json; charset=utf-8");//设置响应编码
                resp.getWriter().write(json);
            }
        }
    }

}