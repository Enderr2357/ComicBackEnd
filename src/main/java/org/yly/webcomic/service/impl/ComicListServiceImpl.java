package org.yly.webcomic.service.impl;

import org.yly.webcomic.entity.ComicList;
import org.yly.webcomic.mapper.ComicListMapper;
import org.yly.webcomic.service.ComicListService;
import org.yly.webcomic.utils.MyBatisUtils;

import java.util.List;

public class ComicListServiceImpl implements ComicListService {
    @Override
    public List<ComicList> selectAll() {
        return (List<ComicList>) MyBatisUtils.executeQuery(sqlSession -> {
            ComicListMapper mapper = sqlSession.getMapper(ComicListMapper.class);
            return mapper.selectAll();
        });

    }

    @Override
    public Integer Insert(ComicList comicList) {
        return (Integer) MyBatisUtils.executeUpdate(sqlSession -> {
            ComicListMapper mapper=sqlSession.getMapper(ComicListMapper.class);
            return mapper.Insert(comicList);
        });
    }

    @Override
    public ComicList selectById(Long bId) {
        return (ComicList) MyBatisUtils.executeQuery(sqlSession -> {
            ComicListMapper mapper = sqlSession.getMapper(ComicListMapper.class);
            return mapper.selectById(bId);
        });
    }

    @Override
    public List<ComicList> selectByCategory(Long cId) {
        return (List<ComicList>) MyBatisUtils.executeQuery(sqlSession -> {
            ComicListMapper mapper = sqlSession.getMapper(ComicListMapper.class);
            return mapper.selectByCategory(cId);
        });
    }

    @Override
    public Long getMaxId() {
        return (Long) MyBatisUtils.executeQuery(sqlSession -> {
           ComicListMapper mapper=sqlSession.getMapper(ComicListMapper.class);
           return mapper.getMaxId();
        });
    }

    @Override
    public Integer delete(Long bId) {
        return (Integer) MyBatisUtils.executeUpdate(sqlSession -> {
            ComicListMapper mapper=sqlSession.getMapper(ComicListMapper.class);
            return mapper.delete(bId);
        });
    }
}
