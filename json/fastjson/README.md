# [fastjson](https://github.com/alibaba/fastjson)

- 依赖

```java
        compile'com.alibaba:fastjson:1.2.76'
        compile'com.alibaba:fastjson:1.1.72.android'
```

- 使用
```java
    String text = JSON.toJSONString(obj); //序列化
    VO vo = JSON.parseObject("{...}", VO.class); //反序列化
```