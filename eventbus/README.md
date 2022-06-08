# EventBus
[EventBus](https://github.com/greenrobot/EventBus)
**EventBus是适用于Android/Java的发布/订阅事件总线**

![EventBus-Publish-Subscribe](https://user-images.githubusercontent.com/99581158/168569821-18504282-1afa-4289-ba9d-a45364855af5.png  )

**事件总线**

- 简化组件之间的通信
    - 解耦事件发送者和接收者
    - 在活动、片段和后台线程中的表现良好
    - 避免复杂且容易出错的依赖关系和生命周期问题
      - 让你的代码更加简单
      - 很快
      - 很小
      - 多次安装。。。。等

### EventBus分三个步骤
**1.定义事件：**
```java
public static calss MessageEvent{
        /*附件需要的字段*/
    }
```

**2.准备订阅者：声明并注释您的订阅方法，可选择指定[线程模式](https://greenrobot.org/eventbus/documentation/delivery-threads-threadmode/):**

```java
@Subscribe(threadMode = ThreadMode.MAIN)
public void onMessageEvent(MesssageEvent event){
        //do something
}
```
注册和注销您的订阅者，例如Android上，Activity和Fragment通常应该根据它们的生命周期进行注册：
```java
@Override
public void onStart(){
    supur.onStart();
    EventBus.getDefault().register(this);
    
@Override
public void onStop(){
    super.onStop();
    EventBus.getDefault().unregister(this);
    }
}
```
**3.发布事件：**
```java
EventBus.getDefault().post(new MessageEvent());
```
### 添加依赖
**Android projects:**

```java
implementation("org.greenrobot:eventbus:3.3.1")
```
**Java projects:**
```java
implementation("org.greenrobot:eventbus-java:3.3.1")
```
    <dependency>
    <groupId>org.greenrobot</groupId>
    <artifactId>eventbus-java</artifactId>
    <version>3.3.1</version>
</dependency>

