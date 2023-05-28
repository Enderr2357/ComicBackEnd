package org.yly.webcomic.service.impl;

import org.junit.jupiter.api.Test;
import org.yly.webcomic.entity.ComicDetail;
import org.yly.webcomic.entity.ComicUser;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ComicDetailServiceImplTest {

    @Test
    void selectAll() {
        ComicDetailServiceImpl comicDetailService = new ComicDetailServiceImpl();
        List<ComicDetail> comicDetails = comicDetailService.selectAll();
        comicDetails.forEach(System.out::println);
    }
    @Test
    void selectById() {
        ComicDetailServiceImpl comicDetailService = new ComicDetailServiceImpl();
        ComicDetail comicDetail= comicDetailService.selectById(2L);
        System.out.println(comicDetail);
    }

    @Test
    void selectBybId() {
        ComicDetailServiceImpl comicDetailService = new ComicDetailServiceImpl();
        List<ComicDetail> comicDetail=comicDetailService.selectBybId(1L);
        comicDetail.forEach(System.out::println
        );
    }
}