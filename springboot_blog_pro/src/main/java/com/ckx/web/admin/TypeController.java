package com.ckx.web.admin;

import com.ckx.domain.Type;
import com.ckx.service.BlogService;
import com.ckx.service.CommentService;
import com.ckx.service.TypeService;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.javassist.bytecode.stackmap.TypeData;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.SearchStrategy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.util.IntrospectorCleanupListener;

import java.util.List;

/**
 * Created by Administrator on 2020/9/26.
 */
@Controller
@RequestMapping("/admin")
public class TypeController {

    @Autowired
    private TypeService typeService;

    @Autowired
    private BlogService blogService;

    @Autowired
    private CommentService commentService;

    //分页查询
    @GetMapping("/types")
    public ModelAndView findAll(@RequestParam(name = "page",required = true,defaultValue = "1")Integer page, @RequestParam(name = "size",required = true,defaultValue = "10") Integer size){
        ModelAndView mv=new ModelAndView();
        List<Type> typeList=typeService.findAll(page,size);

        PageInfo pageInfo=new PageInfo(typeList);

        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("admin/admin-category");
        return mv;


    }

    @GetMapping("/types/edit")
    public String edit(Model model){
        model.addAttribute("type", new Type());
        return "admin/admin-category-edit";
    }

    @GetMapping("/types/{id}/edit")
    public String editId(@PathVariable Long id, Model model){
        model.addAttribute("type",typeService.getType(id));
        return "admin/admin-category-edit";
    }

    @PostMapping("/types/post")
    public String post(String typeName, RedirectAttributes attributes){
        Type bytypeName = typeService.findBytypeName(typeName);
        if(bytypeName!=null){
            attributes.addFlashAttribute("message","类别已经存在");
            return "redirect:/admin/types?page=1&size=5";
        }
        int status = typeService.saveType(typeName);
        if(status==1){
            attributes.addFlashAttribute("message","操作成功");
        }else {
            attributes.addFlashAttribute("message","操作失败");
        }
        return "redirect:/admin/types?page=1&size=5";
    }

    @PostMapping("/types/post/{id}")
    public String eidtPost(String typeName,@PathVariable Long id, RedirectAttributes attributes){
        System.out.println(id+" "+typeName);
        Type bytypeName = typeService.findBytypeName(typeName);
        System.out.println(bytypeName);
        if(bytypeName!=null){
            attributes.addFlashAttribute("message","类别已经存在");
            return "redirect:/admin/types?page=1&size=5";
        }
        int status = typeService.updateType(id,typeName);
        if(status==1){
            attributes.addFlashAttribute("message","操作成功");
        }else {
            attributes.addFlashAttribute("message","操作失败");
        }
        return "redirect:/admin/types?page=1&size=5";
    }


    @RequestMapping("/types/{id}/delete")
    public String delete(@PathVariable Long id,RedirectAttributes attributes){
        commentService.deleteAllByBlogId(id);
        blogService.deleteAllBlogIdTagIdByTypeId(id);
        blogService.deleteBlogByTypeId(id);
        typeService.deleteType(id);
        attributes.addFlashAttribute("message","删除成功");
        return "redirect:/admin/types";

    }
}
