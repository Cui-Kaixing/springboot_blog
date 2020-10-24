package com.ckx.service.impl;

import com.ckx.dao.CommentDao;
import com.ckx.domain.Comment;
import com.ckx.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2020/10/20.
 */
@Service
@Transactional
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentDao commentDao;

    @Override
    public List<Comment> getCommentListByBlogId(Long blogId) {
        return commentDao.getCommentListByBlogId(blogId);
    }

    @Override
    public int save(Comment comment) {
        return commentDao.save(comment);
    }

    @Override
    public void deleteAllByBlogId(Long id) {
        commentDao.deleteAllByBlogId(id);
    }
}
