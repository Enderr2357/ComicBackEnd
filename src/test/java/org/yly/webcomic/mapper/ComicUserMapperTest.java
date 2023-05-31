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
    void delete() {
        Integer result=(Integer) MyBatisUtils.executeUpdate(sqlSession -> {
            ComicUserMapper mapper= sqlSession.getMapper(ComicUserMapper.class);
            return mapper.delete(1L);
        });
    }


}