# Retrofit Demo

### 步骤一 :

- 添加依赖

```groovy
        // retrofit https://github.com/square/retrofit
implementation 'com.squareup.retrofit2:retrofit:2.9.0'
//gson https://github.com/google/gson
implementation 'com.google.code.gson:gson:2.9.0'

// define a BOM and its version
implementation(platform("com.squareup.okhttp3:okhttp-bom:4.9.3"))
```

- 添加权限

```aidl
    //网络权限
    <uses-permission android:name="android.permission.INTERNET"/>
```

### 步骤二 :

- 创建接受服务器返回数据的类 `Reception.java`

```groovy
    public class Reception {
    ...
    //根据返回的数据的格式和数据解析方式（JSON/XML等）定义
    //下面会在实例进行说明
}
```

### 步骤三 :

- Retrofit将 Http请求抽象成了JAVA接口: 采用注解描述网络请求参数和配置网络请求参数

```text
    1.用动态代理动态将注解”翻译“成一个Http请求，最后再执行Http请求
    2.注:接口中的每个方法的参数都用注解标注，否则会报错
```

`GetRequest_Interface.interface`

```groovy
import retrofit2.Call
import retrofit2.http.GET

public interface GetRequest_Interface {
    @GET("test/test.txt")
    Call<Translation> getCall();
    //@GET注解的作用，采用get方式发送请求
    //getCall(); = 接收请求数据的方法
    //其中返回的类型为Call<T>,T接收的是数据的类，即上面的Translation类
    //如果想直接获得ResponseBody中的内容，可以定义网络返还值为ResponseBody

}
```
### 注解类型
![EventBus-Publish-Subscribe](https://user-images.githubusercontent.com/99581158/170942346-13ddaed4-ffb1-4160-b01c-415f7b0628f5.png)

### 注解说明
**第一类：网络请求方法