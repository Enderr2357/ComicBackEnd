package org.yly.webcomic.controller;

import org.yly.webcomic.entity.ComicCategory;
import org.yly.webcomic.entity.ComicList;
import org.yly.webcomic.entity.ComicUser;
import org.yly.webcomic.service.impl.ComicCategoryServiceImpl;
import org.yly.webcomic.service.impl.ComicListServiceImpl;
import org.yly.webcomic.utils.JsonUtils;
import org.yly.webcomic.vo.ComicListVO;
import org.yly.webcomic.vo.ComicUserVO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/AddComic")
public class AddComicController extends HttpServlet {
    private ComicListServiceImpl comicListService=new ComicListServiceImpl();
    private ComicCategoryServiceImpl comicCategoryService=new ComicCategoryServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name= URLDecoder.decode(req.getParameter("name"),"UTF-8");
        String author= URLDecoder.decode(req.getParameter("author"),"UTF-8");
        String category= URLDecoder.decode(req.getParameter("category"),"UTF-8");

        System.out.println(name+","+author+","+category);
        ComicList comicList=new ComicList();
        List<ComicList> comicListList = comicListService.selectAll();
        comicList.setbAuthor(author);
        comicList.setbId(comicListService.getMaxId()+1L);
        comicList.setbName(name);
        comicList.setbCategory((comicCategoryService.selectByName(category).getCateId()).toString());
        comicList.setbInfo("默认");
        comicList.setbSrcname("默认");
        comicList.setbMaxno(1L);
        comicListService.Insert(comicList);
        System.out.println("插入成功");

        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        writer.println(1);
    }
}
