package com.ai.shop10_back.controller;


import com.ai.shop10_back.po.User;
import com.ai.shop10_back.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@RequestMapping("/user")
@Controller
public class UserController {
    @Resource
    private IUserService userService;

       /*登录入口*/
        @RequestMapping("login")
        public String login(){
            return "login";
        }
       /*验证登录信息*/
        @RequestMapping("doLogin")
        public String doLogin(User user, Integer save, HttpSession session, HttpServletResponse response,Model model){
            String msg = "用户名或密码不能为空";
            if (user.getUsername()==null||user.getUsername()==""){
                model.addAttribute(msg);
                return "login";
            }
            if (user.getPassword()==null||user.getPassword()==""){
                model.addAttribute(msg);
                return "login";
            }
            User u = userService.findUserByNameAndPassword(user);
            String msg2 = "用户名或密码错误";
            if (u!=null) {
                Cookie cookie1 = new Cookie("username", u.getUsername());
                Cookie cookie2 = new Cookie("password", u.getPassword());

                session.setAttribute("user", u);
                if (save != null) {
                    cookie1.setMaxAge(60 * 60 * 24 * 7);
                    cookie2.setMaxAge(60 * 60 * 24 * 7);

                } else {
                    cookie1.setMaxAge(0);
                    cookie2.setMaxAge(0);
               }
                cookie1.setPath("/");
                cookie2.setPath("/");
                response.addCookie(cookie1);
                response.addCookie(cookie2);
            }else{
                model.addAttribute(msg2);
                return "login";
            }

            return "redirect:/product/allProduct";
        }
        @RequestMapping("updateUser")
    public String updateUser(){
            return "updateUser";
        }
        @RequestMapping("closeIndex")
    public String closeIndex(HttpSession session){
            session.invalidate();
            return "login";
        }
    }
