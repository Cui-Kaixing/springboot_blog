package com.ckx.service;

import com.ckx.domain.Blog;
import com.ckx.domain.Type;
import com.ckx.queryvo.BlogIdAndTagIdQuery;
import com.ckx.queryvo.BlogQuery;
import org.apache.ibatis.javassist.NotFoundException;

import java.util.List;

/**
 * Created by Administrator on 2020/10/7.
 */
public interface BlogService {
    Blog getBlog(Long id);

    List<Blog> findAll(Integer page, Integer size);

    int saveBlog(Blog blog);

    int updateBlog(Blog blog) throws NotFoundException;

    void deleteBlog(Long id);


    List<Blog> findByTitleAndType(Integer page, Integer size, BlogQuery blogQuery);

    //添加tagid和blogid进表
    void addTagToBlog(Long blogId, String tagIds);

    //查找blog_tag表中的blog的所有tag
    List<BlogIdAndTagIdQuery> getTagIdsByBlogId(Long blogId);

    void deleteAllBlogIdTagId(Long blogId);

    //查找首页的四个博客文章
    List<Blog> findFourBlog();

    List<Blog> findBlogByQuery(String query);


    void deleteAllBlogIdTagIdByTypeId(Long typeId);

    void deleteBlogByTypeId(Long typeId);


    List<BlogIdAndTagIdQuery> getBlogIdsByTagId(Long tagId);


    List<String> getAchiveGroup();

    List<Blog> getBlogByTime(String time);


    List<Blog> getBlogByTypeId(Long id);
}
