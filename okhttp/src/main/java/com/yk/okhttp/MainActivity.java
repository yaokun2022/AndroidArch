package com.yk.okhttp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.BufferedSink;

public class MainActivity extends AppCompatActivity {
    //Log标记
    private final String TAG = "MainActivity";
    public static final MediaType MEDIA_TYPE_MARKDOWN
            = MediaType.parse("text/x-markdown; charset=utf-8");
    //实例化MOSHI对象
    private final Moshi moshi = new Moshi.Builder().build();
    private final JsonAdapter<Gist> gistJsonAdapter = moshi.adapter(Gist.class);
    //实例化客户端
    private final OkHttpClient client = new OkHttpClient();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
            //获取网络地址
//        OkhttpExample okhttpExample = new OkhttpExample();
//        try {
//            String[] response = okhttpExample.run("https://raw.github.com/square/okhttp/master/README.md");
//            System.out.println(response);
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    /**
     * GET发起网络请求（同步）
     *
     * @param view view
     */
    public void synchronousRequest(View view) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                //请求地址百度
                String url = "https://www.baidu.com";
                //实例化OKHttpClient
                OkHttpClient okHttpClient = new OkHttpClient();
                //通过Request的builder对象设置GET请求地址返回Request对象
                final Request request = new Request.Builder()
                        .url(url)
                        .get()//默认就是GET请求，可以不写
                        .build();
                //通过newCall方法获取到Call对象
                Call call = okHttpClient.newCall(request);
                try {
                    //通过call去进行网络请求并返回相应结果
                    Response response = call.execute();
                    if (response.isSuccessful()) {
                        //获取响应体
//                        Headers headers = response.headers();
                        ResponseBody responseBody = response.body();
                        String jsonStr = responseBody.string();
                        Log.d(TAG, "responseBody: " + jsonStr);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();


    }

    /**
     * GET发起网络请求（异步）
     *
     * @param view
     */
    public void asynchronousRequest(View view) {
        //请求地址
        String url = "https://www.baidu.com";
        //实例化OKHttpClient
        OkHttpClient client = new OkHttpClient();
        //通过Request的Builder对象发起网络请求返回Request对象
        final Request request = new Request.Builder()
                .url(url)
                .get()//默认是get，可以不写
                .build();
        //通过newCall方法获取call对象
        Call call = client.newCall(request);
        //同步异步的区别
        //通过call去进行网络请求队列并通过接口回调返回响应结果
        call.enqueue(new Callback() {

            //网络请求失败时提示
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                Log.d(TAG, "网络请求失败: " + e + "call: " + call);
            }

            //网络请求成功时，服务器响应结果
            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                //判断响应结果是否正确（200）
                if (response.isSuccessful()) {
                    //InputStream inputStream=response.body().byteStream();
                    //byte[] bytes = response.body().bytes();
                    //根据响应体获取到响应内容
                    ResponseBody body = response.body();
                    String jsonStr = body.string();
                    Log.i(TAG, "结果= " + jsonStr);

                }
            }
        });
    }

    /**
     * POST发起网络请求（同步）
     *
     * @param view
     */
    public void postSynchronousRequest(View view) {
        //新建子线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                String url = "https://www.baidu.com/";
                //实例化OKHttpClient
                OkHttpClient client = new OkHttpClient();
                //通过FormBody的Builder方法获取builder对象
                FormBody.Builder builder = new FormBody.Builder()
                        .add("userName", "Admin")
                        .add("passWord", "123456");
                //通过Request的builder对象设置post请求方式设置请求地址并返回请求对象request
                //第一种
                FormBody body = builder.build();
                Request request = new Request.Builder()
                        .post(body)
                        .url(url)
                        .build();
//

//                //第二种
//                Request request = new Request.Builder()
//                        .post(builder.build())
//                        .url(url)
//                        .build();
//                //通过调用newCall方法获取到Call对象
                Call call = client.newCall(request);
                //通过Call请求网络获取到响应对象Response
                try {
                    Response response = call.execute();
                    //判断响应结果是否正确（200）
                    if (response.isSuccessful()) {
                        String jsonStr = response.body().string();
                        Log.d(TAG, "请求到的结果: " + jsonStr
                        );
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    /**
     * POST发起网络请求（异步）
     *
     * @param view
     */
    public void postAsynchronousRequest(View view) {
        String url = "https://www.baidu.com/";
        //实例化对象
        OkHttpClient client = new OkHttpClient();
        //通过FormBody的builder对象设置请求参数
        FormBody.Builder builder = new FormBody.Builder()
                .add("userName", "Admin")
                .add("passWord", "123456");
        Request request = new Request.Builder()
                .post(builder.build())
                .url(url)
                .build();
        //通过newCall方法获取Call对象
        Call call = client.newCall(request);
        //通过Call对象调用enqueue进行异步请求并返回请求接口
        call.enqueue(new Callback() {
            //请求失败输出信息
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                Log.d(TAG, "onFailure: " + e + "\ncall: " + call);
            }

            //请求成功，服务器的响应结果
            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                //判断返回是否成功
                if (response.isSuccessful()) {
                    //通过响应体获取到响应内容
                    String jsonStr = response.body().string();
                    Log.d(TAG, "响应内容: " + jsonStr);
                }
            }
        });
    }

    /**
     * GET同步获取文件
     *
     * @param view
     */
    public void synchronousDownloadFile(View view) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                OkHttpClient client = new OkHttpClient();
                Request request = new Request.Builder()
                        .url("https://publicobject.com/helloworld.txt")
                        .build();
                try {
                    Response response = client.newCall(request).execute();
                    if (!response.isSuccessful()) {
                        Log.d(TAG, "downloadFile: " + response);
                    }
                    Headers headers = response.headers();
                    for (int i = 0; i < headers.size(); i++) {
                        System.out.println(headers.name(i) + ": " + headers.value(i));
                    }
                    System.out.println(response.body().string());

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    /**
     * GET异步获取网络文件
     *
     * @param view
     */
    public void asynchronousDownloadFile(View view) {
        //实例化
        OkHttpClient client = new OkHttpClient();
        //通过Request的Builder对象发起网络请求返回request对象
        Request request = new Request.Builder()
                .url("https://publicobject.com/helloworld.txt")
                .build();

        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                Log.d(TAG, "onFailure: 请求失败" + e);
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                ResponseBody responseBody = response.body();
                if (response.isSuccessful()) {
                    Headers headers = response.headers();
                    for (int i = 0; i < headers.size(); i++) {
                        System.out.println(headers.name(i) + ": " + headers.value(i));
                    }
                    System.out.println(responseBody.string());
                }
            }
        });
    }

    /**
     * 访问标头
     *
     * @param view
     */
    public void accessHeaders(View view) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                //实例化客户端
                OkHttpClient client = new OkHttpClient();
                //通过Request的Builder对象进行网络请求获取返回Request对象
                Request request = new Request.Builder()
                        .url("https://api.github.com/repos/square/okhttp/issues")
                        .header("User-Agent", "OkHttp Headers.java")
                        .addHeader("Accept", "application/json; q=0.5")
                        .addHeader("Accept", "application/vnd.github.v3+json")
                        .build();

                try {
                    Response response = client.newCall(request).execute();
                    if (!response.isSuccessful()) {
                        Log.d(TAG, "run: 网络请求失败");
                    }
                    System.out.println("Server: " + response.header("Server"));
                    System.out.println("Date: " + response.header("Date"));
                    System.out.println("Vary: " + response.headers("Vary"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }

    /**
     * 发布字符串
     *
     * @param view
     */

    public void pullString(View view) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                String postBody = ""
                        + "Releases\n"
                        + "--------\n"
                        + "\n"
                        + " * _1.0_ May 6, 2013\n"
                        + " * _1.1_ June 15, 2013\n"
                        + " * _1.2_ August 11, 2013\n";

                Request request = new Request.Builder()
                        .url("https://api.github.com/markdown/raw")
                        .post(RequestBody.create(MEDIA_TYPE_MARKDOWN, postBody))
                        .build();
                try {
                    Response response = client.newCall(request).execute();
                    if (response.isSuccessful()) {
                        System.out.print(response.body().string());
                    }
                } catch (IOException e) {
                    Log.d(TAG, "网络请求失败: " + e);
                }
            }
        }).start();
//        String postBody = ""
//                + "Releases\n"
//                + "--------\n"
//                + "\n"
//                + " * _1.0_ May 6, 2013\n"
//                + " * _1.1_ June 15, 2013\n"
//                + " * _1.2_ August 11, 2013\n";
//
//        Request request = new Request.Builder()
//                .url("https://api.github.com/markdown/raw")
//                .post(RequestBody.create(MEDIA_TYPE_MARKDOWN, postBody))
//                .build();
//        Call call = client.newCall(request);
//        call.enqueue(new Callback() {
//            @Override
//            public void onFailure(@NonNull Call call, @NonNull IOException e) {
//                Log.d(TAG, "onFailure: 网络请求失败");
//            }
//
//            @Override
//            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
//                if (response.isSuccessful()) {
//                    System.out.println(response.body().string());
//                }
//            }
//        });
    }

    /**
     * 后流式传输
     *
     * @param view
     */

    public void postStreaming(View view) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                RequestBody requestBody = new RequestBody() {
                    @Nullable
                    @Override
                    public MediaType contentType() {
                        return MEDIA_TYPE_MARKDOWN;
                    }

                    @Override
                    public void writeTo(@NonNull BufferedSink sink) throws IOException {
                        sink.writeUtf8("Numbers\n");
                        sink.writeUtf8("-----\n");
                        for (int i = 0; i < 997; i++) {
                            sink.writeUtf8(String.format(" * %s = %s\n", i, factor(i)));
                        }
                    }

                    private Object factor(int n) {
                        for (int i = 2; i < n; i++) {
                            int x = n / i;
                            if (x * i == n) return factor(x) + " × " + i;
                        }
                        return Integer.toString(n);
                    }
                };
                Request request = new Request.Builder()
                        .url("https://api.github.com/markdown/raw")
                        .post(requestBody)
                        .build();
                Response response = null;
                try {
                    response = client.newCall(request).execute();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (response.isSuccessful()) {
                    try {
                        System.out.println(response.body().string());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    /**
     * 发布文件
     *
     * @param view
     */
    public void postFile(View view) throws IOException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                File file = new File("README.md");
                Request request = new Request.Builder()
                        .url("https://api.github.com/markdown/raw")
                        .post(RequestBody.create(MEDIA_TYPE_MARKDOWN, file))
                        .build();
                try (Response response = client.newCall(request).execute()) {
                    if (!response.isSuccessful())

                        System.out.println(response.body().string());
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }).start();
    }

    /***
     * 使用 Moshi (.java )解析 JSON 响应
     * @param view
     */
    public void parseJson(View view) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Request request = new Request.Builder()
                        .url("https://api.github.com/gists/c2a7c39532239ff261be")
                        .build();
                try {
                    Response response = client.newCall(request).execute();
                    if (response.isSuccessful()) {
                        Gist gist = gistJsonAdapter.fromJson(response.body().source());
                        for (Map.Entry<String, GistFile> entry : gist.files.entrySet()
                        ) {
                            System.out.println(entry.getKey());
                            System.out.println(entry.getValue().content);
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    /***
     *
     * GET获取网络地址
     * @param view
     */
    public void GetUrl(View view) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Request request = new Request.Builder()
                        .url("https://www.json.cn/json/json2java.html")
                        .build();
                try {
                    Response response = client.newCall(request).execute();
                    System.out.println(response.body().string());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }

    public void sendRequestWithOkHttp(View view) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Request request = new Request.Builder()
                        .url("https://www.baidu.com")
                        .build();
                try {
                    Response response = client.newCall(request).execute();
                    String header = response.message();
                    System.out.println("header:-->  " + header);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }).start();
    }

    static class Gist {
        Map<String, GistFile> files;
    }

    static class GistFile {
        String content;
    }



}

