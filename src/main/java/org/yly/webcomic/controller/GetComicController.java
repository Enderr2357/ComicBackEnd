package org.yly.webcomic.controller;

import com.alibaba.fastjson.JSONArray;
import org.yly.webcomic.entity.ComicCategory;
import org.yly.webcomic.entity.ComicList;
import org.yly.webcomic.entity.ComicUser;
import org.yly.webcomic.service.impl.ComicCategoryServiceImpl;
import org.yly.webcomic.service.impl.ComicListServiceImpl;
import org.yly.webcomic.vo.ComicListVO;
import org.yly.webcomic.vo.ComicUserVO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/GetComic")
public class GetComicController extends HttpServlet {
    ComicListServiceImpl comicListService=new ComicListServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<ComicList> comicLists = comicListService.selectAll();
        List<ComicListVO> comicListVOList=new ArrayList<>();
        for (ComicList comicList : comicLists) {
            ComicListVO comicList1=new ComicListVO();
           comicList1.setAuthor(comicList.getBAuthor());
           comicList1.setName(comicList.getBName());
           comicList1.setId(comicList.getBId());
            ComicCategoryServiceImpl comicCategoryService=new ComicCategoryServiceImpl();
           comicList1.setCategory((comicCategoryService.selectById(Long.valueOf(comicList.getBCategory()))).getCateName());
            comicListVOList.add(comicList1);
        }
        comicListVOList.forEach(System.out::println);
        JSONArray jsonArray = new JSONArray();
        String json = jsonArray.toJSONString(comicListVOList);
        resp.setContentType("application/json; charset=utf-8");//设置响应编码
        resp.getWriter().write(json);
    }
}
