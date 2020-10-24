package com.ckx.web;

import com.ckx.domain.Blog;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * Created by Administrator on 2020/10/21.
 */
@Controller
public class AboutShowController {

    @GetMapping("/about")
    public String index(Model model){

        return "blog/blog-about";
    }
}
