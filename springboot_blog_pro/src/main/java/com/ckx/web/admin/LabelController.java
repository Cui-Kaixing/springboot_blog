package com.ckx.web.admin;

import com.ckx.domain.Tag;
import com.ckx.domain.Type;
import com.ckx.queryvo.BlogIdAndTagIdQuery;
import com.ckx.service.BlogService;
import com.ckx.service.CommentService;
import com.ckx.service.TagService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

/**
 * Created by Administrator on 2020/9/29.
 */
@Controller
@RequestMapping("/admin")
public class LabelController {

    @Autowired
    private TagService tagService;

    @Autowired
    private BlogService blogService;

    @Autowired
    private CommentService commentService;


    //分页查询
    @GetMapping("/label")
    public ModelAndView findAll(@RequestParam(name = "page",required = true,defaultValue = "1")Integer page, @RequestParam(name = "size",required = true,defaultValue = "5") Integer size){
        ModelAndView mv=new ModelAndView();
        List<Tag> tagList=tagService.findAll(page,size);

        PageInfo pageInfo=new PageInfo(tagList);

        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("admin/admin-label");
        return mv;


    }

    @GetMapping("/label/edit")
    public String edit(Model model){
        model.addAttribute("type", new Type());
        return "admin/admin-label-edit";
    }


    @PostMapping("/label/post")
    public String post(String tagName,RedirectAttributes attributes){
        Type bytypeName = tagService.findBytagName(tagName);
        if(bytypeName!=null){
            attributes.addFlashAttribute("message","类别已经存在");
            return "redirect:/admin/label";
        }
        int status = tagService.saveTag(tagName);
        if(status==1){
            attributes.addFlashAttribute("message","操作成功");
        }else {
            attributes.addFlashAttribute("message","操作失败");
        }
        return "redirect:/admin/label";
    }

    @GetMapping("/label/{id}/delete")
    public String delete(@PathVariable Long id, RedirectAttributes attributes){
        List<BlogIdAndTagIdQuery> blogIdQueryList=blogService.getBlogIdsByTagId(id);
        tagService.deleteBlogIdAndTagIdByTagId(id);

        commentService.deleteAllByBlogId(id);
        for(BlogIdAndTagIdQuery obj:blogIdQueryList){
            blogService.deleteBlog(obj.getBlogId());
        }

        tagService.deleteTag(id);
        attributes.addFlashAttribute("message","删除成功");
        return "redirect:/admin/label";
    }
}
