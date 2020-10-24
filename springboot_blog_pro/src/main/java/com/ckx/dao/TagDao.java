package com.ckx.dao;

import com.ckx.domain.Tag;
import com.ckx.domain.Type;
import com.ckx.queryvo.BlogIdAndTagIdQuery;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2020/9/29.
 */
@Mapper
@Repository
public interface TagDao {

    List<Tag> findAll();

    Type findBytagName(String tagName);

    int saveTag(String tagName);

    void deleteTag(Long id);

    List<Tag> getAllTag(List<Long> list);

    Tag getTag(Long id);

    List<Integer> getBlogIdsByTagId(Long tagId);

    void deleteBlogIdAndTagIdByTagId(Long tagId);
}
