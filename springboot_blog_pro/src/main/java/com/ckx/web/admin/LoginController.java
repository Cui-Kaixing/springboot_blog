package com.ckx.web.admin;

import com.ckx.service.UserService;
import com.ckx.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

/**
 * Created by Administrator on 2020/9/24.
 */
@Controller
@RequestMapping("/admin")
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping()
    public String loginPage(){
        return "admin/admin-login";
    }

    @PostMapping("/login")
    public String login(@RequestParam(name="username",required = true) String username, @RequestParam(name = "password",required = true) String password, HttpSession session, Map<String, Object> map) throws NoSuchAlgorithmException {
        User user = userService.checkUser(username,password);
        if(user!=null){
            session.setAttribute("user",user);
            return "redirect:/admin/index";
        }else {
            System.out.println(user);
            map.put("message","用户名或密码错误");
            return "admin/admin-login";
        }
    }


    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("user");
        return "redirect:/admin";
    }
}
