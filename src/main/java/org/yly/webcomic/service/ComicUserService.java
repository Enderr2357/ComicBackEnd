package org.yly.webcomic.service;

import org.yly.webcomic.entity.ComicUser;

import java.util.List;

public interface ComicUserService {
    List<ComicUser> selectAll();

    ComicUser selectById(Long uId);

    ComicUser selectByAccount(String uAccount);
    Integer insert(ComicUser user);
    Integer delete(Long uId);
    Integer update(ComicUser user);
    Long getMaxId();
}
