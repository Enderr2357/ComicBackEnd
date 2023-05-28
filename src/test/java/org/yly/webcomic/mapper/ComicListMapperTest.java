package org.yly.webcomic.mapper;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import org.yly.webcomic.entity.ComicList;
import org.yly.webcomic.utils.MyBatisUtils;

import java.util.List;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.*;

class ComicListMapperTest {

    @Test
    void selectAll() {
        List<ComicList> list = (List<ComicList>) MyBatisUtils.executeQuery((sqlSession) -> {
            ComicListMapper mapper = sqlSession.getMapper(ComicListMapper.class);
            return mapper.selectAll();
        });
        list.forEach(System.out::println);
    }
    @Test
    void selectById(){
        List<ComicList> list=(List<ComicList>) MyBatisUtils.executeQuery(sqlSession -> {
           ComicListMapper mapper=sqlSession.getMapper(ComicListMapper.class);
           return mapper.selectById(1L);
        });
        list.forEach(System.out::println);
    }
}