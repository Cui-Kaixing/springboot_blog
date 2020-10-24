package com.ckx.web;

import com.ckx.domain.Blog;
import com.ckx.domain.Tag;
import com.ckx.domain.Type;
import com.ckx.service.BlogService;
import com.ckx.service.TagService;
import com.ckx.service.TypeService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2020/10/14.
 */
@Controller
public class HomeController {

    @Autowired
    private BlogService blogService;

    @Autowired
    private TypeService typeService;

    @Autowired
    private TagService tagService;

    @GetMapping("/home")
    public String index(Model model, @RequestParam(name = "page",required = true,defaultValue = "1") Integer page, @RequestParam(name = "size",required = true,defaultValue = "4") Integer size){
        List<Blog> blogList=blogService.findAll(page,size);
        List<Blog> fourBlogList=blogService.findFourBlog();
        List<Type> types = typeService.getAllType();

        List<Tag> tags = tagService.getAllTag();
        PageInfo pageInfo=new PageInfo(blogList);

        List<String> achiveGroup=blogService.getAchiveGroup();

        model.addAttribute("fourBlogList",fourBlogList);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("types",types);
        model.addAttribute("tags",tags);
        model.addAttribute("achives",achiveGroup);
        return "blog/blog-home";
    }

}
