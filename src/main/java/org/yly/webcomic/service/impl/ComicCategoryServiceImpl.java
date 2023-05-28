package org.yly.webcomic.service.impl;

import org.yly.webcomic.entity.ComicCategory;
import org.yly.webcomic.entity.ComicDetail;
import org.yly.webcomic.mapper.ComicCategoryMapper;
import org.yly.webcomic.mapper.ComicDetailMapper;
import org.yly.webcomic.service.ComicCategoryService;
import org.yly.webcomic.utils.MyBatisUtils;

import java.util.List;

public class ComicCategoryServiceImpl implements ComicCategoryService {
    @Override
    public List<ComicCategory> selectAll() {
        return (List<ComicCategory>) MyBatisUtils.executeQuery(sqlSession -> {
            ComicCategoryMapper mapper = sqlSession.getMapper(ComicCategoryMapper.class);
            return mapper.selectAll();
        });
    }

    @Override
    public ComicCategory selectById(Long cId) {
        return (ComicCategory) MyBatisUtils.executeQuery(sqlSession -> {
            ComicCategoryMapper mapper = sqlSession.getMapper(ComicCategoryMapper.class);
            return mapper.selectById(cId);
        });
    }
}
