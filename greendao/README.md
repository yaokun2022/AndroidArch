## [greenDAO](https://github.com/greenrobot/greenDAO)
greenDAO 在 Maven Central 上可用。请确保您使用的是最新版本的`greendao`和`greendao-gradle-plugin`工件。

将以下 `Gradle` 配置添加到您的 Android 项目中。在您的根`build.gradle`文件中：
```groovy
buildscript { 
    repositories { 
        jcenter() 
        mavenCentral() //添加存储库
    }
    依赖项 { 
        classpath ' com.android.tools.build:gradle:3.5.3 ' 
        classpath ' org.greenrobot:greendao-gradle-plugin:3.3.0 '  / /添加插件
    } 
}
```
在您的应用模块`app`/`build.gradle`文件中：
```groovy
apply plugin : ' com.android.application ' 
apply plugin : ' org.greenrobot.greendao '  //应用插件
 
依赖 { 
    implementation ' org.greenrobot:greendao:3.3.0 '  //添加库
}
```
