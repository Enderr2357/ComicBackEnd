package org.yly.webcomic.mapper;

import org.yly.webcomic.entity.ComicRead;

import java.util.List;

public interface ComicReadMapper {
    List<ComicRead> selectAll();

    List<ComicRead> selectByuId(Long uId);

    Integer deleteByrId(Long rId);

    ComicRead selectByuIdbId(Long uId,Long bId);
    Integer insert(ComicRead comicRead);
}
