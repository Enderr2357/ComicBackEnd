package org.yly.webcomic.service.impl;

import org.junit.jupiter.api.Test;
import org.yly.webcomic.entity.ComicUser;
import org.yly.webcomic.service.ComicUserService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ComicUserServiceImplTest {

    @Test
    void selectAll() {
        ComicUserServiceImpl comicUserService = new ComicUserServiceImpl();
        List<ComicUser> comicUsers = comicUserService.selectAll();
        comicUsers.forEach(System.out::println);
    }

    @Test
    void selectById() {
        ComicUserServiceImpl comicUserService = new ComicUserServiceImpl();
        ComicUser comicUser = comicUserService.selectById(1L);
        System.out.println(comicUser);
    }



    @Test
    void delete() {
        ComicUserServiceImpl comicUserService = new ComicUserServiceImpl();
        Integer delete = comicUserService.delete(2L);
        System.out.println(delete);
    }



    @Test
    void selectByAccount() {
        ComicUserServiceImpl comicUserService=new ComicUserServiceImpl();
        ComicUser user=comicUserService.selectByAccount("a1");
        System.out.println(user);
    }

}