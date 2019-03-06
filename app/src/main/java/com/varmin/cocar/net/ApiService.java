package com.varmin.cocar.net;


import com.varmin.cocar.bean.DataResponse;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by HuangYang
 * on 2018/12/24  16:56.
 * 文件描述：
 */
public interface ApiService {

    /**
     * 注册用户的方法
     * http://www.wanandroid.com/user/register
     */
    @POST("/user/register")
    @FormUrlEncoded
    Observable<DataResponse> register(@Field("username") String username, @Field("password") String password, @Field("repassword") String repassword);

}
