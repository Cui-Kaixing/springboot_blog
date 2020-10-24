package com.ckx.web;

import com.ckx.NotFindException;
import com.ckx.domain.Blog;
import com.ckx.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by Administrator on 2020/9/21.
 */
@Controller
public class IndexController {

    @Autowired
    private BlogService blogService;

    @GetMapping("/")
    public String index(Model model){
        List<Blog> fourBlogList=blogService.findFourBlog();
        model.addAttribute("fourBlogList",fourBlogList);

        return "blog/blog-index";
    }
}
