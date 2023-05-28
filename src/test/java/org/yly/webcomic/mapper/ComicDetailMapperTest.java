package org.yly.webcomic.mapper;

import org.junit.jupiter.api.Test;
import org.yly.webcomic.entity.ComicDetail;
import org.yly.webcomic.utils.MyBatisUtils;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ComicDetailMapperTest {

    @Test
    void selectAll(){
        List<ComicDetail> list=(List<ComicDetail>) MyBatisUtils.executeQuery(sqlSession -> {
           ComicDetailMapper mapper=sqlSession.getMapper(ComicDetailMapper.class);
           return mapper.selectAll();
        });
        list.forEach(System.out::println);
    }
    @Test
    void selectById() {
        List<ComicDetail> list= (List<ComicDetail>) MyBatisUtils.executeQuery(sqlSession -> {
            ComicDetailMapper mapper= sqlSession.getMapper(ComicDetailMapper.class);
            return mapper.selectById(53L);
        });
        list.forEach(System.out::println);
    }
}