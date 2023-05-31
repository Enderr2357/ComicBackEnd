package org.yly.webcomic.controller;

import com.alibaba.fastjson.JSONArray;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.yly.webcomic.entity.ComicUser;
import org.yly.webcomic.service.ComicReadService;
import org.yly.webcomic.service.impl.ComicUserServiceImpl;
import org.yly.webcomic.vo.ComicUserVO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/getUser")
public class GetUserController extends HttpServlet {
    private ComicUserServiceImpl comicUserService=new ComicUserServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id=req.getParameter("id");
        if(id==null){
            List<ComicUser> comicUserList = comicUserService.selectAll();
            List<ComicUserVO> comicUserVOList=new ArrayList<>();
            for (ComicUser comicUser : comicUserList) {
                ComicUserVO comicUserVO = new ComicUserVO();
                comicUserVO.setId(comicUser.getUId());
                comicUserVO.setUsername(comicUser.getUName());
                comicUserVO.setPassword(comicUser.getUPassword());
                comicUserVO.setAccount(comicUser.getUAccount());
                comicUserVOList.add(comicUserVO);
            }
            comicUserVOList.forEach(System.out::println);
            JSONArray jsonArray = new JSONArray();
            String json = jsonArray.toJSONString(comicUserVOList);
            resp.setContentType("application/json; charset=utf-8");//设置响应编码
            resp.getWriter().write(json);
        }
        else{
            ComicUser comicUser=new ComicUser();
            comicUser=comicUserService.selectById(Long.valueOf(id));
            ObjectMapper mapper = new ObjectMapper();
            String json=mapper.writeValueAsString(comicUser);
            resp.setContentType("application/json; charset=utf-8");//设置响应编码
            resp.getWriter().write(json);
            System.out.println(1);
        }
    }
}
