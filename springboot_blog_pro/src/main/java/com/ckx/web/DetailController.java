package com.ckx.web;

import com.ckx.domain.Blog;
import com.ckx.domain.Comment;
import com.ckx.domain.Tag;
import com.ckx.domain.Type;
import com.ckx.queryvo.BlogIdAndTagIdQuery;
import com.ckx.service.BlogService;
import com.ckx.service.CommentService;
import com.ckx.service.TagService;
import com.ckx.service.TypeService;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2020/10/16.
 */
@Controller
public class DetailController {

    @Autowired
    private BlogService blogService;

    @Autowired
    private TypeService typeService;

    @Autowired
    private TagService tagService;

    @Autowired
    private CommentService commentService;

    @GetMapping("/detail/{id}")
    public String index(Model model,@PathVariable Long id) throws NotFoundException {
        Blog blog = blogService.getBlog(id);
        List<Blog> fourBlogList=blogService.findFourBlog();
        List<Type> types = typeService.getAllType();

        //查找blog对应的tag
        List<BlogIdAndTagIdQuery> tagIdsByBlogId = blogService.getTagIdsByBlogId(id);
        List<Tag> tags=new ArrayList<>();
        for(BlogIdAndTagIdQuery query:tagIdsByBlogId){
            tags.add(tagService.getTag(query.getTagId()));
        }

        List<Comment> commentListByBlogId = commentService.getCommentListByBlogId(id);
        model.addAttribute("comments",commentListByBlogId);

        //设置阅读量
        blog.setViews(blog.getViews()+1);
        blogService.updateBlog(blog);

        model.addAttribute("fourBlogList",fourBlogList);
        model.addAttribute("blog",blog);
        model.addAttribute("types",types);
        model.addAttribute("tags",tags);
        return "blog/blog-detail";
    }
}
