package com.ckx.web;

import com.ckx.domain.Blog;
import com.ckx.domain.Type;
import com.ckx.queryvo.BlogIdAndTagIdQuery;
import com.ckx.service.BlogService;
import com.ckx.service.TagService;
import com.ckx.service.TypeService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Administrator on 2020/10/15.
 */
@Controller
public class AnimationController {

    @Autowired
    private BlogService blogService;

    @Autowired
    private TypeService typeService;

    @Autowired
    private TagService tagService;

    //查找type对应的所有文章
    @RequestMapping("/type/{id}")
    public String getAllBlogByTypeId(Model model, @PathVariable Long id){
        List<Blog> blogList = blogService.getBlogByTypeId(id);
        model.addAttribute("obj1",blogList);
        return "blog/blog-animation-type";
    }

    //查找tag对应的所有文章
    @RequestMapping("/tag/{id}")
    public String getAllBlogByTagId(Model model, @PathVariable Long id){
        List<Integer> blogIdList=tagService.getBlogIdsByTagId(id);
        Set<Integer> set=new HashSet<>();
        for(Integer blogId:blogIdList){
            set.add(blogId);
        }
        List<Blog> blogList=new ArrayList<>();
        for(Integer blogId:set){
            Blog blog = blogService.getBlog(new Long(blogId));
            blogList.add(blog);
        }


        model.addAttribute("obj2",blogList);
        return "blog/blog-animation-tag";
    }

    //搜索文章
    @PostMapping("/search")
    public String getAllBlogByQuery(Model model,@RequestParam String query){

        List<Blog> blogList = blogService.findBlogByQuery(query);

        model.addAttribute("obj3",blogList);
        return "blog/blog-animation-search";
    }


    @RequestMapping("/achive/{time}")
    public String getAllBlogByTagId(Model model, @PathVariable String time){
        List<Blog> blogList=blogService.getBlogByTime(time);

        model.addAttribute("obj4",blogList);
        return "blog/blog-animation-time";
    }

}
