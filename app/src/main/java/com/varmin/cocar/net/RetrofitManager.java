package com.varmin.cocar.net;

import com.franmontiel.persistentcookiejar.PersistentCookieJar;
import com.franmontiel.persistentcookiejar.cache.SetCookieCache;
import com.franmontiel.persistentcookiejar.persistence.SharedPrefsCookiePersistor;
import com.varmin.cocar.BuildConfig;
import com.varmin.cocar.base.App;

import java.io.File;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.CookieJar;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by HuangYang
 * on 2019/3/6  18:52.
 * 文件描述：
 */
public class RetrofitManager {
    private static long CONNECT_TIMEOUT = 20L;
    private static long READ_TIMEOUT = 10L;
    private static long WRITE_TIMEOUT = 10L;
    //设缓存有效期为1天
    private static final long CACHE_STALE_SEC = 60 * 60 * 24 * 1;
    //查询缓存的Cache-Control设置，为if-only-cache时只查询缓存而不会请求服务器，max-stale可以配合设置缓存失效时间
    public static final String CACHE_CONTROL_CACHE = "only-if-cached, max-stale=" + CACHE_STALE_SEC;

    private static OkHttpClient mOkHttpClient;

    public static OkHttpClient getOkHttpClient(){
        if (mOkHttpClient == null) {
            synchronized (RetrofitManager.class){
                if (mOkHttpClient == null) {
                    HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
                    if (BuildConfig.DEBUG) {
                        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
                    }
                    Cache cache = new Cache(new File(App.getApplication().getCacheDir(), "CoCar_Cache"), 1024*1024*50);
                    CookieJar cookieJar = new PersistentCookieJar(new SetCookieCache(), new SharedPrefsCookiePersistor(App.getApplication()));
                    mOkHttpClient = new OkHttpClient.Builder()
                            .cache(cache)
                            .connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
                            .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
                            .writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
                            .addInterceptor(logging)
                            .cookieJar(cookieJar)
                            .build();

                }
            }
        }
        return mOkHttpClient;
    }

    public static ApiService create(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(UrlApi.REQUEST_BASE_URL)
                .client(getOkHttpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        return retrofit.create(ApiService.class);
    }
}
