package com.example.basictemplate.controller;

import com.example.basictemplate.model.user;
import com.example.basictemplate.pojo.Result;
import com.example.basictemplate.server.UserServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Arrays;

@Controller
public class HelloWorldController {
    @Autowired
    public UserServer userServer;
    /*  只能通过Controller访问Template下的文件      */
    @RequestMapping("/welcome")
    public ModelAndView thymeleaf(ModelAndView modelAndView){
        modelAndView.addObject("msg","测试thymeleaf模板引擎");
        modelAndView.addObject("utext","<h2>通过utext标签可以导入html语言</h2>");
        modelAndView.addObject("users", Arrays.asList("qinjiang","kuangshen"));

        modelAndView.setViewName("welcome");
        return modelAndView;
    }
    @RequestMapping("login")
    @ResponseBody
    public Result login(String username, String password,HttpSession session){
        Result result=null;
        user User=userServer.queryAuthorityToUser(username);

        if(User==null){
            result=new Result(false,200,"用户名不存在");
        }else {
            System.out.println(User.toString());
            if(User.getPassword().equals(password)){
                session.setAttribute("user",User);
                result=new Result(true,200,"登录成功,2秒后跳转页面");
            }else {
                result=new Result(false,200,"密码错误");
            }
        }
        return result;
    }
    @RequestMapping("/indexinit")
    public String loginInitialization(Model model,HttpSession httpSession){
        user User=(user) httpSession.getAttribute("user");
        model.addAttribute("User",User);
        return "index";
    }
}
