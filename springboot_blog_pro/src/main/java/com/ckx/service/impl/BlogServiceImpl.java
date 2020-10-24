package com.ckx.service.impl;

import com.ckx.dao.BlogDao;
import com.ckx.domain.Blog;
import com.ckx.queryvo.BlogIdAndTagIdQuery;
import com.ckx.queryvo.BlogQuery;
import com.ckx.service.BlogService;
import com.ckx.util.MarkdownUtils;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2020/10/7.
 */
@Service
@Transactional
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogDao blogDao;

    @Override
    public Blog getBlog(Long id) {
        return blogDao.getBlog(id);
    }

    @Override
    public List<Blog> findAll(Integer page, Integer size) {
        PageHelper.startPage(page,size);
        return blogDao.findAll();
    }

    @Override
    public int saveBlog(Blog blog) {
        blog.setCreateTime(new Date());
        blog.setViews(0);
        return blogDao.saveBlog(blog);
    }

    @Override
    public int updateBlog(Blog blog) throws NotFoundException {
        blog.setCreateTime(new Date());
        return blogDao.updateBlog(blog);
    }

    @Override
    public void deleteBlog(Long id) {
        blogDao.deleteBlog(id);
    }

    @Override
    public List<Blog> findByTitleAndType(Integer page, Integer size, BlogQuery blogQuery) {
        PageHelper.startPage(page,size);
        return blogDao.findByTitleAndType(blogQuery);
    }

    @Override
    public void addTagToBlog(Long blogId, String tagIds) {
        if(!"".equals(tagIds) && tagIds!=null){
            String[] idarray=tagIds.split(",");
            for(int i=0;i<idarray.length;i++){
                blogDao.addTagToBlog(blogId,new Long(idarray[i]));
            }
        }else {
            blogDao.addTagToBlog(blogId,null);
        }
    }

    @Override
    public List<BlogIdAndTagIdQuery> getTagIdsByBlogId(Long blogId) {
        return blogDao.getTagIdsByBlogId(blogId);
    }

    @Override
    public void deleteAllBlogIdTagId(Long blogId) {
        blogDao.deleteAllBlogIdTagId(blogId);
    }

    @Override
    public List<Blog> findFourBlog() {
        return blogDao.findFourBlog();
    }

    @Override
    public List<Blog> findBlogByQuery(String query) {
        return blogDao.findBlogByQuery(query);
    }

    @Override
    public void deleteAllBlogIdTagIdByTypeId(Long typeId) {
        blogDao.deleteAllBlogIdTagIdByTypeId(typeId);
    }

    @Override
    public void deleteBlogByTypeId(Long typeId) {
        blogDao.deleteBlogByTypeId(typeId);
    }


    @Override
    public List<BlogIdAndTagIdQuery> getBlogIdsByTagId(Long tagId) {
        return blogDao.getBlogIdsByTagId(tagId);
    }

    @Override
    public List<String> getAchiveGroup() {
        return blogDao.getAchiveGroup();
    }

    @Override
    public List<Blog> getBlogByTime(String time) {
        return blogDao.getBlogByTime(time);
    }

    @Override
    public List<Blog> getBlogByTypeId(Long id) {
        return blogDao.getBlogByTypeId(id);
    }


}
