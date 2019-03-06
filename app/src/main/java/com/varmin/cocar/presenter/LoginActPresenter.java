package com.varmin.cocar.presenter;

import com.blankj.utilcode.util.LogUtils;
import com.franmontiel.persistentcookiejar.PersistentCookieJar;
import com.franmontiel.persistentcookiejar.cache.SetCookieCache;
import com.franmontiel.persistentcookiejar.persistence.SharedPrefsCookiePersistor;
import com.varmin.cocar.base.App;
import com.varmin.cocar.base.BasePresenter;
import com.varmin.cocar.constant.CommonFields;
import com.varmin.cocar.contract.LoginActContract;
import com.varmin.cocar.net.RetrofitManager;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Cookie;
import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by HuangYang
 * on 2018/11/8  17:13.
 * 文件描述：
 */
public class LoginActPresenter extends BasePresenter<LoginActContract.View> implements LoginActContract.Presenter {
    @Inject
    public LoginActPresenter(){}

    @Override
    public void login(String account, String password) {
        /*MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        String json = "{\"username\":"+account+",password:"+password+"}";
        RequestBody body = RequestBody.create(JSON, json);*/


        /*OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .cookieJar(new PersistentCookieJar(new SetCookieCache(), new SharedPrefsCookiePersistor(App.getApplication())))
                .connectTimeout(2, TimeUnit.SECONDS).build();*/

        String url = "http://www.wanandroid.com/user/login";
        OkHttpClient okHttpClient = RetrofitManager.getOkHttpClient();

        List<Cookie> cookies = okHttpClient.cookieJar().loadForRequest(HttpUrl.parse(url));
        for (Cookie cookie : cookies) {
            LogUtils.d("cookie_request_name="+cookie.name()+", value="+cookie.value());
        }

        RequestBody formBody = new FormBody.Builder()
                .add("username", account)
                .add("password", password)
                .build();

        Request request = new Request.Builder()
                .url(url)
                .post(formBody)
                .build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                LogUtils.d(e.toString());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                try {
                    JSONObject json = new JSONObject(response.body().string());
                    LogUtils.d(json.toString());
                    int code = json.getInt("errorCode");
                    if (code == 0) {
                        spUtils.put(CommonFields.HAS_LOGIN, true);
                        mView.loginSuccess();
                    }else {
                        mView.showFaild(json.getString("errorMsg"));
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });


    }
}
