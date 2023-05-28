package org.yly.webcomic.service.impl;

import org.junit.jupiter.api.Test;
import org.yly.webcomic.entity.ComicList;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ComicListServiceImplTest {

    @Test
    void selectAll() {
        ComicListServiceImpl comicListService = new ComicListServiceImpl();
        List<ComicList> comicLists = comicListService.selectAll();
        comicLists.forEach(System.out::println);
    }

    @Test
    void selectById() {
        ComicListServiceImpl comicListService = new ComicListServiceImpl();
        ComicList comicLists = comicListService.selectById(2L);
        System.out.println(comicLists);

    }

    @Test
    void selectByCategory() {
        ComicListServiceImpl comicListService = new ComicListServiceImpl();
        List<ComicList> comicLists = comicListService.selectByCategory(1L);
        comicLists.forEach(System.out::println);
    }
}