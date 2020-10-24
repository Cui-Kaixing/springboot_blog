package com.ckx.web.admin;

import com.ckx.domain.Blog;
import com.ckx.domain.Tag;
import com.ckx.domain.Type;
import com.ckx.domain.User;
import com.ckx.queryvo.BlogIdAndTagIdQuery;
import com.ckx.queryvo.BlogQuery;
import com.ckx.service.BlogService;
import com.ckx.service.CommentService;
import com.ckx.service.TagService;
import com.ckx.service.TypeService;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Administrator on 2020/9/25.
 */
@Controller
@RequestMapping("/admin")
public class BlogController {

    @Autowired
    private BlogService blogService;

    @Autowired
    private TypeService typeService;

    @Autowired
    private TagService tagService;

    @Autowired
    private CommentService commentService;

    @GetMapping("/index")
    public String index(Model model,@RequestParam(name = "page",required = true,defaultValue = "1") Integer page, @RequestParam(name = "size",required = true,defaultValue = "10") Integer size){
        List<Blog> blogList = blogService.findAll(page, size);
        PageInfo pageInfo=new PageInfo(blogList);
        model.addAttribute("pageInfo",pageInfo);
        return "admin/admin-index";
    }

//获取博客列表
    @GetMapping("/blog")
    public ModelAndView blogs(@RequestParam(name = "page",required = true,defaultValue = "1") Integer page, @RequestParam(name = "size",required = true,defaultValue = "10") Integer size){
        ModelAndView mv=new ModelAndView();
        List<Blog> blogList = blogService.findAll(page, size);
        PageInfo pageInfo=new PageInfo(blogList);
        List<Type> types=typeService.getAllType();


        mv.addObject("pageInfo",pageInfo);
        mv.addObject("types",types);
        mv.setViewName("admin/admin-blog");
        return mv;
    }

//按条件搜索博客
    @PostMapping("/blog/search")
    public String search(Model model, @RequestParam(name = "page",required = true,defaultValue = "1") Integer page, @RequestParam(name = "size",required = true,defaultValue = "10") Integer size, BlogQuery blogQuery){
        List<Blog> blogList = blogService.findByTitleAndType(page, size,blogQuery);

        PageInfo pageInfo=new PageInfo(blogList);
        List<Type> types=typeService.getAllType();
        System.out.println(pageInfo.getList().toString());
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("types",types);

        return "admin/admin-blog :: blogList";
    }

//博客发布页面
    @GetMapping("/blog/input")
    public String input(Model model){
        List<Type> types=typeService.findAll();
        List<Tag> tags=tagService.getAllTag();
        model.addAttribute("blog",new Blog());
        model.addAttribute("types",types);
        model.addAttribute("tags",tags);
        return "admin/admin-blog-edit";
    }

//保存博客
    @PostMapping("/blog")
    public String post(Blog blog, RedirectAttributes attributes, HttpSession session){
        User user = (User) session.getAttribute("user");
        blog.setUser(user);
        blog.setUserId(user.getId());
        blog.setType(typeService.getType(blog.getTypeId()));
        blog.setTags(tagService.getAllTag(blog.getTagIds()));

        int b = blogService.saveBlog(blog);
        blogService.addTagToBlog(blog.getId(),blog.getTagIds());
        if(b==1){
            attributes.addFlashAttribute("message","操作成功");
        }else {
            attributes.addFlashAttribute("message","操作失败");
        }
        return "redirect:/admin/blog";
    }

//编辑博客
    @GetMapping("/blog/{id}/input")
    public String editInput(Model model,@PathVariable Long id){
        List<Type> types=typeService.findAll();
        List<Tag> tags=tagService.getAllTag();
        model.addAttribute("types",types);
        model.addAttribute("tags",tags);

        //查找tagId
        Blog blog = blogService.getBlog(id);
        List<BlogIdAndTagIdQuery> tagIdQueryList=blogService.getTagIdsByBlogId(id);
        if(!tagIdQueryList.isEmpty()){
            StringBuffer ids=new StringBuffer();
            boolean flag=false;
            for(BlogIdAndTagIdQuery obj:tagIdQueryList){
                if(flag){
                    ids.append(",");
                }else {
                    flag=true;
                }
                ids.append(obj.getTagId());
            }
            blog.setTagIds(ids.toString());
        }


        model.addAttribute("blog",blog);
        return "admin/admin-blog-edit";
    }

// 编辑博客保存
    @PostMapping("/blog/{id}")
    public String editPost(Blog blog, RedirectAttributes attributes, HttpSession session) throws NotFoundException {
        User user = (User) session.getAttribute("user");
        blog.setUser(user);
        blog.setUserId(user.getId());
        blog.setType(typeService.getType(blog.getTypeId()));
        blog.setTags(tagService.getAllTag(blog.getTagIds()));
        int b = blogService.updateBlog(blog);
        //删除原来所有的含有blogid的记录
        blogService.deleteAllBlogIdTagId(blog.getId());
        blogService.addTagToBlog(blog.getId(),blog.getTagIds());
        if(b==1){
            attributes.addFlashAttribute("message","操作成功");
        }else {
            attributes.addFlashAttribute("message","操作失败");
        }
        return "redirect:/admin/blog";
    }

//删除博客
    @GetMapping("/blog/{id}/delete")
    public String deleteBlog(RedirectAttributes attributes,@PathVariable Long id){
        commentService.deleteAllByBlogId(id);
        blogService.deleteAllBlogIdTagId(id);
        blogService.deleteBlog(id);
        attributes.addFlashAttribute("message","操作成功");
        return "redirect:/admin/blog";

    }



}
