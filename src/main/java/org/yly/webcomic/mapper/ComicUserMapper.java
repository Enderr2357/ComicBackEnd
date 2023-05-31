package org.yly.webcomic.mapper;

import org.yly.webcomic.entity.ComicList;
import org.yly.webcomic.entity.ComicUser;

import java.util.List;

public interface ComicUserMapper {
    List<ComicUser> selectAll();
    ComicUser selectById(Long uId);
    Integer insert(ComicUser user);
    ComicUser selectByAccount(String uAccount);
    Integer delete(Long uId);
    Integer update(ComicUser user);

    Long getMaxId();
}
