package org.yly.webcomic.controller;

import com.alibaba.fastjson.JSONArray;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.yly.webcomic.entity.ComicCategory;
import org.yly.webcomic.entity.ComicList;
import org.yly.webcomic.service.ComicCategoryService;
import org.yly.webcomic.service.impl.ComicCategoryServiceImpl;
import org.yly.webcomic.service.impl.ComicListServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/comiccategory")
public class ComicCategoryController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String text=req.getParameter("data");
       System.out.println("获取到category请求");
        System.out.println(text);
        ComicCategoryServiceImpl comicCategoryService = new ComicCategoryServiceImpl();
        if(text!=null){
            if (text.equals("all")) {
                List<ComicCategory> comicCategories = comicCategoryService.selectAll();
                System.out.println(comicCategories);
                JSONArray jsonArray = new JSONArray();
                String json = jsonArray.toJSONString(comicCategories);
                resp.setContentType("application/json; charset=utf-8");//设置响应编码
                resp.getWriter().write(json);
            }
            else {
                ComicCategoryServiceImpl comicCategoryService1 = new ComicCategoryServiceImpl();
                ComicCategory comicCategory=comicCategoryService1.selectById(Long.valueOf(text));
                ObjectMapper mapper = new ObjectMapper();
                String json=mapper.writeValueAsString(comicCategory);
                resp.setContentType("application/json; charset=utf-8");//设置响应编码
                resp.getWriter().write(json);
                System.out.println("成功返回");
            }
        }
    }
}
