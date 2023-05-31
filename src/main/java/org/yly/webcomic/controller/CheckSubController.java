package org.yly.webcomic.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.yly.webcomic.entity.ComicRead;
import org.yly.webcomic.service.ComicReadService;
import org.yly.webcomic.service.impl.ComicReadServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(urlPatterns = "/CheckSub")
public class CheckSubController extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userid=req.getParameter("uid");
        String comicid=req.getParameter("bid");
        String sub=req.getParameter("sub");
        ComicReadServiceImpl comicReadService=new ComicReadServiceImpl();
        ComicRead comicRead=comicReadService.selectByuIdbId(Long.valueOf(userid),Long.valueOf(comicid));

        if(comicRead!=null){
            System.out.println(comicRead);
            ObjectMapper mapper = new ObjectMapper();
            String json=mapper.writeValueAsString(comicRead);
            resp.setContentType("application/json; charset=utf-8");//设置响应编码
            resp.getWriter().write(json);
            System.out.println("成功返回订阅结果");
        }
        if(sub!=null){
            System.out.println("是订阅按钮");
            List<ComicRead> comicReadList=comicReadService.selectAll();
            Long id=Long.valueOf(comicReadList.size());
            ComicRead newcomicRead=new ComicRead(id+1L,Long.valueOf(userid),Long.valueOf(comicid));
            Integer i= comicReadService.insert(newcomicRead);
            System.out.println(i);
            if(i==1){
                resp.setContentType("text/html;charset=utf-8");
                PrintWriter writer = resp.getWriter();
                writer.println(1);
            }
        }
    }
}
