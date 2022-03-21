# DataBinding
> https://developer.android.com/topic/libraries/data-binding

## 编译环境

在module总build.gradle中添加

```groovy
android {
    ...

    dataBinding {
        enabled = true
    }
}
```


## 使用场景

以前写法
```java
TextView textView = findViewById(R.id.tv);
textView.setText(viewModel.getUserName());
```

现在写法
xml：
```XML
<TextView
    android:text="@{viewmodel.userName}" />
```

or


java
```java
bind.tv.setText(viewModel.getUserName());
```

## 布局和绑定表达式
```xml
<?xml version="1.0" encoding="utf-8"?>
    <layout xmlns:android="http://schemas.android.com/apk/res/android">
       <data>
           <variable name="" type="com.example.LoginViewModel"/>
       </data>
       <LinearLayout
           android:orientation="vertical"
           android:layout_width="match_parent"
           android:layout_height="match_parent">
           <TextView android:layout_width="wrap_content"
               android:layout_height="wrap_content"
               android:text="@{vm.firstName}"/>
           <TextView android:layout_width="wrap_content"
               android:layout_height="wrap_content"
               android:text="@{vm.lastName}"/>
       </LinearLayout>
    </layout>
    
```

### 数据对象
可以使实体对象(eg: User)或者ViewModel

### 绑定数据

在activit中使用：
```java
    @Override
    protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       // 设置Activity界面并获取设置xml对应的DataBinding
       ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
       User user = new User("Test", "User");
       // 绑定数据，方法名根据xml中variable的name
       binding.setUser(user);
    }

```

在Fragment、ListView 或 RecyclerView 适配器中使用：
```java
    ListItemBinding binding = ListItemBinding.inflate(layoutInflater, viewGroup, false);
    // or
    ListItemBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.list_item, viewGroup, false);

```


### 表达式语言
- 算术运算符 + - / * %
- 字符串连接运算符 +
- 逻辑运算符 && ||
- 二元运算符 & | ^
- 一元运算符 + - ! ~
- 移位运算符 >> >>> <<
- 比较运算符 == > < >= <=（请注意，< 需要转义为 &lt;）
- instanceof
- 分组运算符 ()
- 字面量运算符 - 字符、字符串、数字、null
- 类型转换
- 方法调用
- 字段访问
- 数组访问 []
- 三元运算符 ?: