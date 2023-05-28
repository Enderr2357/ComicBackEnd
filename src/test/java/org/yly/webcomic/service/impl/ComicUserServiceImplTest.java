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
    void insert() {
        ComicUserServiceImpl comicUserService = new ComicUserServiceImpl();
        ComicUser user1=new ComicUser();
        user1.setuId(2L);
        user1.setuName("b2");
        user1.setuPassword("123456");
        Integer insert = comicUserService.insert(user1);
        System.out.println(insert);
    }

    @Test
    void delete() {
        ComicUserServiceImpl comicUserService = new ComicUserServiceImpl();
        Integer delete = comicUserService.delete(2L);
        System.out.println(delete);
    }

    @Test
    void update() {
        ComicUserServiceImpl comicUserService = new ComicUserServiceImpl();
        ComicUser user=new ComicUser();
        user.setuId(1L);
        user.setuPassword("123456");
        user.setuName("a1");
        Integer update = comicUserService.update(user);
        System.out.println(update);
    }

    @Test
    void selectByAccount() {
        ComicUserServiceImpl comicUserService=new ComicUserServiceImpl();
        ComicUser user=comicUserService.selectByAccount("a1");
        System.out.println(user);
    }
}