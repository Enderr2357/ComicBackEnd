package org.yly.webcomic.service;

import org.yly.webcomic.entity.ComicCategory;
import org.yly.webcomic.entity.ComicDetail;

import java.util.List;

public interface ComicCategoryService {
    List<ComicCategory> selectAll();
    ComicCategory selectByName(String Name);
    ComicCategory selectById(Long cId);
}
