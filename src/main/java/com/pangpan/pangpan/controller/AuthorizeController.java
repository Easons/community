package com.pangpan.pangpan.controller;

import com.pangpan.pangpan.dto.AccessTokenDTO;
import com.pangpan.pangpan.dto.GitHubUser;
import com.pangpan.pangpan.mapper.UserMapper;
import com.pangpan.pangpan.model.User;
import com.pangpan.pangpan.provider.GithubProvider;
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
    private GithubProvider githubProvider;

    @Value("${github.client.id}")
    private String clientId;
    @Value("${github.client.secret}")
    private  String clientSecret;
    @Value("${github.redirect.uri}")
    private  String redirectUri;

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/callback")
    public String callback(@RequestParam(name = "code") String code, @RequestParam(name = "state") String state,
                           HttpServletRequest request,
                           HttpServletResponse response){

        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();

//        accessTokenDTO.setClient_id("Iv1.e10453b85eabeec3");
//        accessTokenDTO.setClient_secret("8e9823f1640d6dcb306944d96adff4111bd5e474");
//        accessTokenDTO.setRedirect_uri("http://localhost:8887/callback");
        accessTokenDTO.setClient_id(clientId);
        accessTokenDTO.setClient_secret(clientSecret);
        accessTokenDTO.setCode(code);
        accessTokenDTO.setRedirect_uri(redirectUri);
        accessTokenDTO.setState(state);

        String accessToken = githubProvider.getAccessToken(accessTokenDTO);

        GitHubUser gitHubUser = githubProvider.getUser(accessToken);

        if(gitHubUser !=null)
        {//放入session 和 cookie

            User user = new User();

            user.setAccountId(String.valueOf(gitHubUser.getId()));
            user.setGmtCreate(System.currentTimeMillis());
            user.setGmtModefied(user.getGmtCreate());
            user.setName(gitHubUser.getName());
            user.setToken(UUID.randomUUID().toString());

            userMapper.insert(user);//写入数据库

            response.addCookie(new Cookie("token",user.getToken()));
//            request.getSession().setAttribute("user",gitHubUser);
            return "redirect:/";
        }else{
            //登陆失败，重新登陆
            return "redirect:/";
        }
    }
}
