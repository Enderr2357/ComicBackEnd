package org.yly.webcomic.controller;

import com.alibaba.fastjson.JSONArray;
import org.yly.webcomic.entity.ComicDetail;
import org.yly.webcomic.entity.ComicList;
import org.yly.webcomic.entity.ComicRead;
import org.yly.webcomic.service.impl.ComicDetailServiceImpl;
import org.yly.webcomic.service.impl.ComicListServiceImpl;
import org.yly.webcomic.service.impl.ComicReadServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/Subscribe")
public class UserSubscribeController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id=req.getParameter("uid");
        System.out.println(id);
        if (id!=null){
            ComicReadServiceImpl comicReadService=new ComicReadServiceImpl();
            List<ComicRead> comicReadList=comicReadService.selectByuId(Long.valueOf(id));
            comicReadList.forEach(System.out::println);
            ComicListServiceImpl comicListService=new ComicListServiceImpl();
            List<ComicList> lists=new ArrayList<>();
            for (int i=0;i<comicReadList.size();i++){
                ComicRead read=comicReadList.get(i);
                ComicList comic=comicListService.selectById(read.getBId());
                System.out.println(comic);
                lists.add(comic);
            }
            lists.forEach(System.out::println);
            JSONArray jsonArray = new JSONArray();
            String json = jsonArray.toJSONString(lists);
            resp.setContentType("application/json; charset=utf-8");//设置响应编码
            resp.getWriter().write(json);
        }
    }
}
