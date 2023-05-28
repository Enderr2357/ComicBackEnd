package org.yly.webcomic.service.impl;

import org.yly.webcomic.entity.ComicDetail;
import org.yly.webcomic.mapper.ComicDetailMapper;
import org.yly.webcomic.service.ComicDetailService;
import org.yly.webcomic.utils.MyBatisUtils;

import java.util.List;

public class ComicDetailServiceImpl implements ComicDetailService {

    @Override
    public List<ComicDetail> selectAll() {
        return (List<ComicDetail>) MyBatisUtils.executeQuery(sqlSession -> {
            ComicDetailMapper mapper = sqlSession.getMapper(ComicDetailMapper.class);
            return mapper.selectAll();
        });
    }

    @Override
    public ComicDetail selectById(Long cId) {
        return (ComicDetail) MyBatisUtils.executeQuery(sqlSession -> {
            ComicDetailMapper mapper = sqlSession.getMapper(ComicDetailMapper.class);
            return mapper.selectById(cId);
        });
    }

    @Override
    public List<ComicDetail> selectBybId(Long bId) {
        return (List<ComicDetail>) MyBatisUtils.executeQuery(sqlSession -> {
            ComicDetailMapper mapper = sqlSession.getMapper(ComicDetailMapper.class);
            return mapper.selectBybId(bId);
        });
    }


}
