package org.yly.webcomic.mapper;

import org.yly.webcomic.entity.ComicCategory;

import java.util.List;

public interface ComicCategoryMapper {
    List<ComicCategory> selectAll();
    ComicCategory selectByName(String Name);
    ComicCategory selectById(Long cId);

}
