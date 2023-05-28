package org.yly.webcomic.service;

import org.yly.webcomic.entity.ComicDetail;

import java.util.List;

public interface ComicDetailService {
    List<ComicDetail> selectAll();

   ComicDetail selectById(Long cId);
   List<ComicDetail> selectBybId(Long bId);
}
