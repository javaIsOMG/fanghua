package com.springxuexi.springboot04;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class YEMIANcontroller  {
    //等等@GetMapping@PutMapping
   @GetMapping("/heying")
    public String login(@RequestParam("username") String name, @RequestParam("password") String password, Map<String,Object> map, HttpSession session){
       if(!StringUtils.isEmpty(name)&&password.equals("123456")) {
           session.setAttribute("indexname",name);
           //防止表单重复提交，可以重定向到主页
           return "redirect:/main.html";
       }else{
           map.put("msg","用户名密码错误");
           return "index";
       }
    }
}
