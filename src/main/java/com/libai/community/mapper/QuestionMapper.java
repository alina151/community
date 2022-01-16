package com.libai.community.mapper;

import com.libai.community.model.Question;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface QuestionMapper {
    @Select("select * from question limit #{offset}, #{size}")
    List<Question> list(Integer offsize, Integer size);

    @Insert("insert into question (id,title,description,tag,gmt_create,gmt_modified,creator,comment_count,view_count,like_count) values (#{id},#{title},#{description},#{tag},#{gmtCreate},#{gmtModified},#{creator},#{viewCount},#{likeCount},#{commentCount})")
    void create(Question question);

    @Select("select count(1) from question")
    Integer count();
}
