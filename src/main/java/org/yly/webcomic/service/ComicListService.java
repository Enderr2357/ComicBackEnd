package org.yly.webcomic.service;

import org.yly.webcomic.entity.ComicList;

import java.util.List;

public interface ComicListService {
    List<ComicList> selectAll();

    ComicList selectById(Long bId);
    List<ComicList> selectByCategory(Long cId);
}
