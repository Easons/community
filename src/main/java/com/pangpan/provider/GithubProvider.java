package com.pangpan.provider;

import com.alibaba.fastjson.JSON;
import com.pangpan.dto.AccessTokenDTO;
import com.pangpan.dto.GitHubUser;
import okhttp3.*;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class GithubProvider {

    public  String getAccessToken(AccessTokenDTO accessTokenDTO){

        MediaType mediaType = MediaType.get("application/json; charset=utf-8");

        String url = "https://github.com/login/oauth/access_token";

        OkHttpClient client = new OkHttpClient();

        RequestBody body = RequestBody.create(mediaType,JSON.toJSONString(accessTokenDTO));
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {

            String string = response.body().string();
            String token = string.split("&")[0].split("=")[1];
            System.out.println(string);
            return token;

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }


    public GitHubUser getUser(String accessToken){

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://api.github.com/user?access_token="+accessToken)
                .build();

        try {
            Response response = client.newCall(request).execute();
            String string = response.body().string();
            GitHubUser gitHubUser = JSON.parseObject(string,GitHubUser.class);
            return  gitHubUser;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
