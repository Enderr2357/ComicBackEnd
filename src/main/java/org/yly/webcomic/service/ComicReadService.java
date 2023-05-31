package org.yly.webcomic.service;

import org.yly.webcomic.entity.ComicRead;

import java.util.List;

public interface ComicReadService {

    List<ComicRead> selectAll();

    Integer deleteByrId(Long rId);

    List<ComicRead> selectByuId(Long uId);

    ComicRead selectByuIdbId(Long uId,Long bId);

    Integer insert(ComicRead comicRead);
}
