package org.yly.webcomic.service.impl;

import org.junit.jupiter.api.Test;
import org.yly.webcomic.entity.ComicCategory;
import org.yly.webcomic.service.ComicCategoryService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ComicCategoryServiceImplTest {

    @Test
    void selectAll() {
        ComicCategoryService comicCategoryService= new ComicCategoryServiceImpl();
        List<ComicCategory> comicCategories = comicCategoryService.selectAll();
        comicCategories.forEach(System.out::println);
    }

    @Test
    void selectById() {
        ComicCategoryService comicCategoryService= new ComicCategoryServiceImpl();
        ComicCategory comicCategory= comicCategoryService.selectById(2L);
        System.out.println(comicCategory);
    }
}