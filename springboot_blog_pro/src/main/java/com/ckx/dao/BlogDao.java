package com.ckx.dao;

import com.ckx.domain.Blog;
import com.ckx.queryvo.BlogIdAndTagIdQuery;
import com.ckx.queryvo.BlogQuery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2020/10/7.
 */
@Mapper
@Repository
public interface BlogDao {

    Blog getBlog(Long id);

    int saveBlog(Blog blog);

    int updateBlog(Blog blog);

    void deleteBlog(Long id);

    List<Blog> findAll();

    List<Blog> findByTitleAndType(BlogQuery blogQuery);

    void addTagToBlog(@Param(value = "blogId") Long blogId,@Param(value = "tagId") Long tagId);

    List<BlogIdAndTagIdQuery> getTagIdsByBlogId(Long blogId);

    void deleteAllBlogIdTagId(Long blogId);

    List<Blog> findFourBlog();

    List<Blog> findBlogByQuery(String query);

    void deleteAllBlogIdTagIdByTypeId(Long typeId);

    void deleteBlogByTypeId(Long typeId);

    List<BlogIdAndTagIdQuery> getBlogIdsByTagId(Long tagId);

    List<String> getAchiveGroup();

    List<Blog> getBlogByTime(String time);

    List<Blog> getBlogByTypeId(Long id);
}
