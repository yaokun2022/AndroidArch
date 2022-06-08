# [Buffterknife](https://github.com/JakeWharton/butterknife)

- 依赖

```groovy
        implementation 'com.jakewharton:butterknife:10.2.3'
annotationProcessor 'com.jakewharton:butterknife-compiler:10.2.3'
```

```groovy
buildscript {
    repositories {
        mavenCentral()
        google()
    }
    dependencies {
        classpath 'com.jakewharton:butterknife-gradle-plugin:10.2.3'
    }
}
```

### 使用

```java
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class buffterknife() extends AppCompatActivity {
    //绑定控件
    @BindView(R.id.xxx)
    Button button;

    //绑定资源
    @BindString(R.string.xxx)
    String xxx;

    //绑定点击事件
    @OnClick(R.id.xxx)
    Void myClick(View view) {
        //to do something
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //绑定控件
        ButterKnife.bind;
    }
}
```
