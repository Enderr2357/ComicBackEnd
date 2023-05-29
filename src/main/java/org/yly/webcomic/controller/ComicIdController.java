package org.yly.webcomic.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.yly.webcomic.entity.ComicList;
import org.yly.webcomic.service.impl.ComicListServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/comicId")
public class ComicIdController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String comicid=req.getParameter("comicid");
        System.out.println("我是comicid");
        System.out.println(comicid);
        Long id=Long.valueOf(comicid);
        System.out.println(id);
        ComicListServiceImpl comicListService =new ComicListServiceImpl();
        if (comicid!=null){
            ComicList comicList=comicListService.selectById(id);
            System.out.println(comicList);
            ObjectMapper mapper = new ObjectMapper();
            String json=mapper.writeValueAsString(comicList);
            resp.setContentType("application/json; charset=utf-8");//设置响应编码
            resp.getWriter().write(json);
            System.out.println("成功返回");
        }
    }

}