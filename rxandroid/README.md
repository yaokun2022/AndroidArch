# RxAndroid:Android的响应式扩展


## Binaries
```java

allprojects {
    repositories {
        maven { url "https://oss.jfrog.org/libs-snapshot" }
    }
}

dependencies {
    implementation 'io.reactivex.rxjava3:rxandroid:3.0.0'
    //因为 RxAndroid 版本很少而且很远之间，建议您也
    //明确依赖 RxJava 的最新版本来修复错误和新功能。
    //（最新 3.xx 版本见 https://github.com/ReactiveX/RxJava/releases）
    implementation 'io.reactivex.rxjava3:rxjava:3.0.0'
}
```

## 示例使用

### 在主线程上观察

在 Android 上处理异步任务时最常见的操作之一是在主线程上观察任务的结果或结果。使用 vanilla Android，这通常可以通过 `AsyncTask`. 使用 RxJava，你可以声明你`Observable`在主线程上被观察：
```java
Observable.just("one", "two", "three", "four", "five")
    .subscribeOn(Schedulers.newThread())
    .observeOn(AndroidSchedulers.mainThread())
    .subscribe(/* an Observer */);
```
这将在一个新线程上执行，并通过主线程`Observable`发出结果。`onNext`

### 观察任意循环器


前面的示例只是一个更一般概念的特化：将异步通信绑定到 Android 消息循环，或`Looper`. 为了观察一个`Observable`任意 的，通过调用`Looper`创建一个关联：`SchedulerAndroidSchedulers.from`
```java
Looper backgroundLooper = // ...
Observable.just("one", "two", "three", "four", "five")
    .observeOn(AndroidSchedulers.from(backgroundLooper))
    .subscribe(/* an Observer */)
```

这将在一个新线程上执行 `Observable`，并onNext在任何正在运行的线程上发出结果`backgroundLooper`。