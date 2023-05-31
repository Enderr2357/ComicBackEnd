package org.yly.webcomic.service;

import org.yly.webcomic.entity.ComicList;

import java.util.List;

public interface ComicListService {
    List<ComicList> selectAll();
    Integer Insert(ComicList comicList);
    ComicList selectById(Long bId);
    List<ComicList> selectByCategory(Long cId);
    Long getMaxId();
    Integer delete(Long bId);
}
