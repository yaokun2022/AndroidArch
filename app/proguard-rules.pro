# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile

-keepclassmembers 类*扩展 org.greenrobot.greendao.AbstractDao {
public static java.lang.String TABLENAME ;
}
-keep 类** $Properties { * ; } #如果你使用 SQLCipher:
-keep class org.greenrobot.greendao.database.SqlCipherEncryptedHelper { * ; } #如果你不使用 SQLCipher：
-dontwarn net.sqlcipher.database。** #如果你不使用 RxJava：
-dontwarn rx. **

