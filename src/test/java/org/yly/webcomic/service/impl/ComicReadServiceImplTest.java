package org.yly.webcomic.service.impl;

import org.junit.jupiter.api.Test;
import org.yly.webcomic.entity.ComicList;
import org.yly.webcomic.entity.ComicRead;
import org.yly.webcomic.service.ComicReadService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ComicReadServiceImplTest {

    @Test
    void selectAll() {
        ComicReadServiceImpl comicReadService=new ComicReadServiceImpl();
        List<ComicRead> comicReadList=comicReadService.selectAll();
        comicReadList.forEach(System.out::println);
    }

    @Test
    void deleteByrId() {
        ComicReadServiceImpl comicReadService=new ComicReadServiceImpl();
        Integer result= comicReadService.deleteByrId(3L);
        System.out.println(result);
    }

    @Test
    void selectByuId() {
        ComicReadServiceImpl comicReadService=new ComicReadServiceImpl();
        List<ComicRead> comicRead=comicReadService.selectByuId(1L);
        comicRead.forEach(System.out::println);
    }

    @Test
    void selectByRead(){
        ComicReadServiceImpl comicReadService=new ComicReadServiceImpl();
        List<ComicRead> comicRead=comicReadService.selectByuId(1L);
        ComicListServiceImpl comicListService=new ComicListServiceImpl();
        List<ComicList> lists=new ArrayList<>();
        for (int i=0;i<comicRead.size();i++){
            ComicRead read=comicRead.get(i);
            ComicList comic=comicListService.selectById(read.getBId());
            System.out.println(comic);
            lists.add(comic);
        }
        lists.forEach(System.out::println);
    }

    @Test
    void selectByuIdbId() {
        ComicReadServiceImpl comicReadService=new ComicReadServiceImpl();
        ComicRead comicRead=comicReadService.selectByuIdbId(1L,3L);
        System.out.println(comicRead);
    }

    @Test
    void insert() {
        ComicReadServiceImpl comicReadService=new ComicReadServiceImpl();
        List<ComicRead> comicReadList=comicReadService.selectAll();
        Long id=Long.valueOf(comicReadList.size());
        ComicRead comicRead=new ComicRead(id+1L,1L,1L);
        Integer i= comicReadService.insert(comicRead);
        System.out.println(i);
    }
}