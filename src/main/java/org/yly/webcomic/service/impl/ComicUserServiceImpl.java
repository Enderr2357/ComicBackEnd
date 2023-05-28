package org.yly.webcomic.service.impl;

import org.yly.webcomic.entity.ComicUser;
import org.yly.webcomic.mapper.ComicUserMapper;
import org.yly.webcomic.service.ComicUserService;
import org.yly.webcomic.utils.MyBatisUtils;

import java.util.List;

public class ComicUserServiceImpl implements ComicUserService {
    @Override
    public List<ComicUser> selectAll() {
        return (List<ComicUser>) MyBatisUtils.executeQuery(sqlSession -> {
            ComicUserMapper mapper = sqlSession.getMapper(ComicUserMapper.class);
            return mapper.selectAll();
        });
    }

    @Override
    public ComicUser selectById(Long uId) {
        return (ComicUser) MyBatisUtils.executeQuery(sqlSession -> {
            ComicUserMapper mapper = sqlSession.getMapper(ComicUserMapper.class);
            return mapper.selectById(uId);
        });
    }

    @Override
    public ComicUser selectByAccount(String uAccount) {
        return (ComicUser) MyBatisUtils.executeQuery(sqlSession -> {
            ComicUserMapper mapper = sqlSession.getMapper(ComicUserMapper.class);
            return mapper.selectByAccount(uAccount);
        });
    }

    @Override
    public Integer insert(ComicUser user) {
        return (Integer) MyBatisUtils.executeUpdate(sqlSession -> {
            ComicUserMapper mapper = sqlSession.getMapper(ComicUserMapper.class);
            return mapper.insert(user);
        });
    }

    @Override
    public Integer delete(Long uId) {
        return (Integer) MyBatisUtils.executeUpdate(sqlSession -> {
            ComicUserMapper mapper = sqlSession.getMapper(ComicUserMapper.class);
            return mapper.delete(uId);
        });
    }

    @Override
    public Integer update(ComicUser user) {
        return (Integer) MyBatisUtils.executeUpdate(sqlSession -> {
            ComicUserMapper mapper = sqlSession.getMapper(ComicUserMapper.class);
            return mapper.update(user);
        });
    }
}
