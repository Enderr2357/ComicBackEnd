package org.yly.webcomic.mapper;

import org.yly.webcomic.entity.ComicList;

import java.util.List;

public interface ComicListMapper {

    List<ComicList> selectAll();
    ComicList selectById(Long bId);
    List<ComicList> selectByCategory(Long cId);
}
