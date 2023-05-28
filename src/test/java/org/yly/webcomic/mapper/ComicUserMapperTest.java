package org.yly.webcomic.mapper;

import org.junit.jupiter.api.Test;
import org.yly.webcomic.entity.ComicUser;
import org.yly.webcomic.utils.MyBatisUtils;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ComicUserMapperTest {

    @Test
    void selectAll() {
        List<ComicUser> list= (List<ComicUser>) MyBatisUtils.executeQuery(sqlSession -> {
           ComicUserMapper mapper=sqlSession.getMapper(ComicUserMapper.class);
           return mapper.selectAll();
        });
        list.forEach(System.out::println);
    }

    @Test
    void selectById() {
        List<ComicUser> list=(List<ComicUser>) MyBatisUtils.executeQuery(sqlSession -> {
           ComicUserMapper mapper=sqlSession.getMapper(ComicUserMapper.class);
           return mapper.selectById(1L);
        });
        list.forEach(System.out::println);
    }

    @Test
    void insert() {
        Integer result = (Integer) MyBatisUtils.executeUpdate(sqlSession -> {
            ComicUserMapper mapper=sqlSession.getMapper(ComicUserMapper.class);
            ComicUser user=new ComicUser();
            user.setuId(1L);
            user.setuName("a1");
            user.setuPassword("123456");
            int i= mapper.insert(user);
            sqlSession.commit();
            return i;
        });
    }

    @Test
    void delete() {
        Integer result=(Integer) MyBatisUtils.executeUpdate(sqlSession -> {
            ComicUserMapper mapper= sqlSession.getMapper(ComicUserMapper.class);
            return mapper.delete(1L);
        });
    }

    @Test
    void update() {
        Integer result= (Integer) MyBatisUtils.executeUpdate(sqlSession -> {
           ComicUserMapper mapper=sqlSession.getMapper(ComicUserMapper.class);
           ComicUser user=new ComicUser();
           user.setuId(1L);
           user.setuName("b1");
           user.setuPassword("234567");
           int i=mapper.update(user);
           sqlSession.commit();
           return i;
        });
    }
}