package com.ckx.dao;

import com.ckx.domain.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2020/10/20.
 */
@Mapper
@Repository
public interface CommentDao {


    List<Comment> getCommentListByBlogId(Long blogId);

    int save(Comment comment);

    void deleteAllByBlogId(Long id);
}
