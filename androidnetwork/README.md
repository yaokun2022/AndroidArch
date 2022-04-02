# 网络获取图片

> https://www.sunofbeach.net/a/1201024692236963840

## 网络权限和配置

在AndroidManifest.xml添加

```groovy

< manifest
· · ·
< uses - permission android: name = "android.permission.INTERNET" / >

        < application
· · ·
android:
networkSecurityConfig = "@xml/network_security_config"

```

```xml
    <?xml version="1.0" encoding="utf-8"?>
<network-security-config>
    <domain-config>
        <domain includeSubdomains="true">sunofbeaches.com</domain>
        <domain-config cleartextTrafficPermitted="true">
            <domain includeSubdomains="true">www.sunofbeach.net</domain>
            <domain includeSubdomains="true">imgs.sunofbeaches.com</domain>
        </domain-config>
    </domain-config>
</network-security-config>
```

允许这些域名明文访问，否则http会报错

## 请求图片内容

```groovy
 public void requestImage(View view) {
    new Thread(new Runnable() {
        @Override
        public void run() {
            loadImage();
        }
    }).start();
}

private void loadImage() {
    try {
        URL url = new URL("https://imgs.sunofbeaches.com/group1/M00/00/05/rBsADV2rEz-AIzSoAABi-6nfiqs456.png");
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setRequestMethod("GET");
        httpURLConnection.setConnectTimeout(10000);
        httpURLConnection.connect();
        InputStream is = httpURLConnection.getInputStream();
        final Bitmap bitmap = BitmapFactory.decodeStream(is);
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                ImageView resultView = findViewById(R.id.image_result);
                resultView.setImageBitmap(bitmap);
            }
        });
    } catch (Exception e) {
        e.printStackTrace();
    }
}
```
##处理结果显示图片

```groovy
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="https://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical">

    <Button
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:onClick="requestImage"
        android:text="请求图片" />

    <ImageView
        android:id="@+id/image_result"
        android:layout_width="match_parent"
        android:layout_height="match_parent" />

</LinearLayout>
```
