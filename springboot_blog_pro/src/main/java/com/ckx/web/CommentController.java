package com.ckx.web;

import com.ckx.domain.Comment;
import com.ckx.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Date;

/**
 * Created by Administrator on 2020/10/20.
 */
@Controller
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping("/comments")
    public String post(Comment comment){
        comment.setCreateTime(new Date());
        commentService.save(comment);
        return "redirect:/detail/"+comment.getBlogId();
    }
}
