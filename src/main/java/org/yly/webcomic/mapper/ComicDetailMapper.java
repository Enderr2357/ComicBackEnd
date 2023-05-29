package org.yly.webcomic.mapper;

import org.yly.webcomic.entity.ComicDetail;

import java.util.List;

public interface ComicDetailMapper {
    List<ComicDetail> selectAll();

    ComicDetail selectById(Long cid);
    List<ComicDetail> selectBybId(Long bid);

    ComicDetail selectByNoId(Long nId,Long bId);
}
