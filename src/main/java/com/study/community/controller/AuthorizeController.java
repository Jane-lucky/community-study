package com.study.community.controller;

import com.study.community.Mapper.UserMapper;
import com.study.community.Model.User;
import com.study.community.dto.AccessTokenDTO;
import com.study.community.dto.GitHubUser;
import com.study.community.provider.GitHubprovider;
import com.study.community.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@Controller
public class AuthorizeController {
    @Autowired
    private GitHubprovider gitHubprovider;

    @Value("${github.client.id}")
    private String clientId;
    @Value("${github.client.secret}")
    private String clientSecret;
    @Value("${github.redirect.uri}")
    private String redirectUri;

    @Autowired
    private UserService userService;

    @GetMapping("/callback")
    public String callback(@RequestParam(name="code") String code,
                           @RequestParam(name="state") String state,
                           HttpServletRequest request,
                           HttpServletResponse response){
        //https://square.github.io/okhttp/调用获得东西GitHubprovider
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setClient_id(clientId);
        accessTokenDTO.setClient_secret(clientSecret);
        accessTokenDTO.setCode(code);
        accessTokenDTO.setRedirect_uri(redirectUri);
        accessTokenDTO.setState(state);
        String accessToken = gitHubprovider.getAccessToken(accessTokenDTO);
        GitHubUser gituser = gitHubprovider.getUser(accessToken);
        if(gituser!=null && gituser.getId()!=null){
            User user = new User();
            //存储数据库
            String token = UUID.randomUUID().toString();
            user.setToken(token);
            user.setAccountId(String.valueOf(gituser.getId()));
            user.setName(gituser.getName());
            user.setAvatarUrl(gituser.getAvatar_url());
            userService.creatOrUpdate(user);
            //登陆成功，写cookie和session
            //将token 放进cookie中
            response.addCookie(new Cookie("token",token));
//
//            request.getSession().setAttribute("user",gituser);
            return "redirect:/";
        }else {
            //登录失败
            return "redirect:/";
        }
    }

    @GetMapping("/logout")
    public  String logout(HttpServletRequest request,
                          HttpServletResponse response){
        request.getSession().removeAttribute("user");
        Cookie cookie=new Cookie("token",null);
        cookie.setMaxAge(0);
        response.addCookie(cookie);
        return "redirect:/";
    }
}
