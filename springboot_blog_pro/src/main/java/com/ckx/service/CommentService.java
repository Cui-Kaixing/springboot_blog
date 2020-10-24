package com.ckx.service;

import com.ckx.domain.Comment;

import java.util.List;

/**
 * Created by Administrator on 2020/10/20.
 */
public interface CommentService {

    List<Comment> getCommentListByBlogId(Long blogId);

    int save(Comment comment);

    void deleteAllByBlogId(Long id);
}
