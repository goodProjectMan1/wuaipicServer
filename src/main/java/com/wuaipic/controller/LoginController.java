package com.wuaipic.controller;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.wuaipic.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {


    // 发送post请求，代替了RequestMapping（value="/user/login", method="post"）
    @PostMapping(value = "/login")
    // 对登录请求判断request的参数值，并存放在map中
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Map<String, Object> map, HttpSession httpSession, HttpServletResponse response) {
        // 我们判断，如果登录名不是空，并且，密码是 123456 就登录成功（暂不涉及数据库）
        if (!StringUtils.isEmpty(username) && "111111".equals(password)) {
            User user = new User();
            user.setId(username);
            user.setPassword(password);
            String token =  getToken(user);
            System.out.println(token);
            httpSession.setAttribute("token",token);
            Cookie cookie = new Cookie("token",token);
            cookie.setPath("/");
            response.addCookie(cookie);

            // 登录成功，就跳转到下一个页面
            String userId = JWT.decode(token).getAudience().get(0);
            System.out.println(userId);
            return "redirect:/index";
        } else {
            // 登录失败，刷新本登录页
            map.put("msg", "用户名密码错误或session过期");
            return "redirect:/";
        }

    }

    @GetMapping("/")
    public String login() {
        return "login";
    }


    @GetMapping("/toLogin")
    public String toLogin() {
        return "login";
    }


    @GetMapping("/index")
    public String welcome() {
        return "welcome";
    }

    public String getToken(User user) {
        String token="";
        token= JWT.create().withAudience(user.getId())
                .sign(Algorithm.HMAC256(user.getPassword()));
        return token;
    }


}