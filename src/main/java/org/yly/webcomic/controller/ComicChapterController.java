package org.yly.webcomic.controller;

import com.alibaba.fastjson.JSONArray;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.yly.webcomic.entity.ComicDetail;
import org.yly.webcomic.service.ComicDetailService;
import org.yly.webcomic.service.impl.ComicDetailServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/comicChapter")
public class ComicChapterController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String text=req.getParameter("id");
        System.out.println(text);

        if (text!=null){
            System.out.println("进入了chapter"+text);
            ComicDetailServiceImpl comicDetailService=new ComicDetailServiceImpl();
            List<ComicDetail> comicDetails=comicDetailService.selectBybId(Long.valueOf(text));
            System.out.println(comicDetails);
            JSONArray jsonArray = new JSONArray();
            String json = jsonArray.toJSONString(comicDetails);
            resp.setContentType("application/json; charset=utf-8");//设置响应编码
            resp.getWriter().write(json);
        }
        else{
            String noid=req.getParameter("currentnoid");
            String bid=req.getParameter("bid");
            System.out.println("通过currentnoid查找");
            ComicDetailServiceImpl comicDetailService=new ComicDetailServiceImpl();
            ComicDetail comicDetail=comicDetailService.selectByNoId(Long.valueOf(noid),Long.valueOf(bid));
            System.out.println(comicDetail);
            ObjectMapper mapper = new ObjectMapper();
            String json=mapper.writeValueAsString(comicDetail);
            resp.setContentType("application/json; charset=utf-8");//设置响应编码
            resp.getWriter().write(json);
            System.out.println("成功返回");
        }
    }
}
