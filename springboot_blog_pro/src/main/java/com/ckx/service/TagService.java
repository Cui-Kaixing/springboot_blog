package com.ckx.service;

import com.ckx.domain.Tag;
import com.ckx.domain.Type;
import com.ckx.queryvo.BlogIdAndTagIdQuery;

import java.util.List;

/**
 * Created by Administrator on 2020/9/29.
 */
public interface TagService {

    List<Tag> findAll(Integer page, Integer size);

    List<Tag> findAll();

    Type findBytagName(String tagName);

    int saveTag(String tagName);

    void deleteTag(Long id);

    List<Tag> getAllTag();

    Tag getTag(Long id);

    List<Tag> getAllTag(String ids);

    List<Integer> getBlogIdsByTagId(Long tagId);

    void deleteBlogIdAndTagIdByTagId(Long tagId);
}
