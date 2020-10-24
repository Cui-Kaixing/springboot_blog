package com.ckx.web;

import com.ckx.queryvo.Message;
import com.ckx.util.MailUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.mail.MessagingException;

/**
 * Created by Administrator on 2020/10/21.
 */
@Controller
public class ContactControll {

    @RequestMapping("/contact")
    public String contact(){
        return "/blog/blog-contact";
    }

    @PostMapping("/contact/email")
    public String email(Message message,RedirectAttributes attributes) throws MessagingException {
        System.out.println(message);
        attributes.addFlashAttribute("message","发送成功，信息将发送到作者邮箱");
        MailUtils.sendMail("1291407533@qq.com",message.getSubject(), message.getEmail()+"内容："+message.getMessage());
        return "redirect:/contact";
    }
}
