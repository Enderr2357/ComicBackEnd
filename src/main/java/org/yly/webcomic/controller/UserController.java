package org.yly.webcomic.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.yly.webcomic.entity.ComicRead;
import org.yly.webcomic.entity.ComicUser;
import org.yly.webcomic.service.impl.ComicUserServiceImpl;
import org.yly.webcomic.utils.JsonUtils;
import org.yly.webcomic.vo.ComicUserVO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(urlPatterns = "/AddUser")
public class UserController extends HttpServlet {

    private ComicUserServiceImpl comicUserService=new ComicUserServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ComicUserVO comicUserVO= (ComicUserVO) JsonUtils.parseObj(req, ComicUserVO.class);
        System.out.println(comicUserVO);
        ComicUser comicUser = new ComicUser();
        List<ComicUser> comicUserList = comicUserService.selectAll();
        comicUser.setUName(comicUserVO.getUsername());
        comicUser.setUAccount(comicUserVO.getAccount());
        comicUser.setUPassword(comicUserVO.getPassword());
        comicUser.setUId(comicUserService.getMaxId()+1L);
        comicUser.setURole(0L);

        comicUserService.insert(comicUser);
        System.out.println("插入成功");

        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        writer.println(1);
    }
}
