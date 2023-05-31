package org.yly.webcomic.service.impl;

import org.yly.webcomic.entity.ComicRead;
import org.yly.webcomic.entity.ComicUser;
import org.yly.webcomic.mapper.ComicReadMapper;
import org.yly.webcomic.mapper.ComicUserMapper;
import org.yly.webcomic.service.ComicReadService;
import org.yly.webcomic.utils.MyBatisUtils;

import java.util.List;

public class ComicReadServiceImpl implements ComicReadService {
    @Override
    public List<ComicRead> selectAll() {
        return (List<ComicRead>) MyBatisUtils.executeQuery(sqlSession -> {
            ComicReadMapper mapper = sqlSession.getMapper(ComicReadMapper.class);
            return mapper.selectAll();
        });
    }

    @Override
    public Integer deleteByrId(Long rId) {
       return (Integer) MyBatisUtils.executeUpdate(sqlSession -> {
          ComicReadMapper mapper=sqlSession.getMapper(ComicReadMapper.class);
          return mapper.deleteByrId(rId);
       });
    }

    @Override
    public List<ComicRead> selectByuId(Long uId) {
        return (List<ComicRead>) MyBatisUtils.executeQuery(sqlSession -> {
           ComicReadMapper mapper=sqlSession.getMapper(ComicReadMapper.class);
           return mapper.selectByuId(uId);
        });
    }

    @Override
    public ComicRead selectByuIdbId(Long uId, Long bId) {
        return (ComicRead) MyBatisUtils.executeQuery(sqlSession -> {
            ComicReadMapper mapper=sqlSession.getMapper(ComicReadMapper.class);
            return mapper.selectByuIdbId(uId,bId);
        });
    }

    @Override
    public Integer insert(ComicRead comicRead) {
        return (Integer) MyBatisUtils.executeUpdate(sqlSession -> {

            ComicReadMapper mapper = sqlSession.getMapper(ComicReadMapper.class);
            Integer i= mapper.insert(comicRead);
            sqlSession.commit();
            return i;
        });
    }


}