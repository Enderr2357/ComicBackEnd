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
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.util.List;

@WebServlet(urlPatterns = "/GetSearch")
public class GetSearchComicController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name= req.getParameter("name");
        System.out.println(name);
        String bname= URLDecoder.decode(name,"UTF-8");

        if(bname==null){
            resp.setContentType("text/html;charset=utf-8");
            PrintWriter writer = resp.getWriter();
            writer.println(0);
        }
        else{
            ComicListServiceImpl comicListService=new ComicListServiceImpl();
            List<ComicList> comicLists = comicListService.selectByName(bname);
            JSONArray jsonArray = new JSONArray();
            String json = jsonArray.toJSONString(comicLists);
            resp.setContentType("application/json; charset=utf-8");//设置响应编码
            resp.getWriter().write(json);
        }
    }
}
