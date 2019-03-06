### TODO:先做开展下一步
* LoadingView：方案
    * 自己实现：
        * RelativeLayout 在 layout 时需要 measure 两次？
        * 如何实现第三方库：注意什么、资源命名等
        * 注解代替枚举？怎么做？

* LogUtils
* OKhttp、Retrofit、RxJava、RxLife



### todo：
* Leak
* 本地测试、仪器测试：测试方案。
* ButterKnife 使用，原理--注解
* implementation、api方式和complie的区别
* 启动白屏

### Tips：
* ./gradlew app:dependencies

#### Okhttp:
* response.body().string() 访问第二次就会报错，已closed


### Note
* Utils工具：获取最上层Activity，Application声明周期callback
* 系统空格、换行
```
System.getProperty("file.separator");
System.getProperty("line.separator");
```
* 获取当前执行信息：
```
StackTraceElement[] stackTrace = new Throwable().getStackTrace();
StackTraceElement targetElement = stackTrace[3];
String fileName = targetElement.getFileName();
String methodName = targetElement.getMethodName();
int lineNum = targetElement.getLineNumber();
```

#### App 标配
* Log、Toast、Dialog、Sp、时间格式...封装
* 状态View
* 解析Json
* 刷新View