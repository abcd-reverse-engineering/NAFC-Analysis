# N`ational` A`nti`-F`raud` C`enter` —— `Analysis`

使用 JADX 分析国家反诈中心安装包得到的源代码。

部分源码目录经过了混淆而无法正确呈现。

## 可能有用的目录

- [/app/src/main/okhttp3/internal/publicsuffix/publicsuffixes](https://github.com/Anonymous220623/NAFC-Analysis/blob/main/app/src/main/okhttp3/internal/publicsuffix/publicsuffixes)：APP 监控网络访问的域名列表，从 `app/src/main/okhttp3/internal/publicsuffix/publicsuffixes.gz` 中解压。

## third-party

|第三方库名称|描述|源代码仓库|相关文件|
|--|--|--|--|
|libmd|提供消息摘要函数的库，通常源自 BSD 系统|[https://github.com/guillemj/libmd](https://github.com/guillemj/libmd) [https://gitlab.freedesktop.org/libbsd/libmd](https://gitlab.freedesktop.org/libbsd/libmd)| `app/src/main/lib/*/libmd.so`
|okhttp|针对 JVM、Android 和 GraalVM 的 HTTP 客户端|[https://github.com/square/okhttp](https://github.com/square/okhttp)|`app/src/main/java/okhttp3/*` `app/src/main/okhttp3/internal/publicsuffix/*`|
|gson|一个 Java 序列化/反序列化库，用于将 Java 对象转换为 JSON 并返回|[https://github.com/google/gson](https://github.com/google/gson)|`app/src/main/java/network/gson/*`|
|zxing|用于 Java、Android 的条码码扫描库|[https://github.com/zxing/zxing](https://github.com/zxing/zxing)|`app/src/main/java/zxing/*`|
|okio|适用于 Android、Java 和 Kotlin Multiplatform 的现代 I/O 库。|[https://github.com/square/okio](https://github.com/square/okio)|`app/src/main/java/okio/*`|

## 可能有用的链接

### 假的国家反诈中心

1. [https://github.com/XJP-GIT/AntiZhaPian](https://github.com/XJP-GIT/AntiZhaPian)（已存档）
2. [https://github.com/arenekosreal/AntiZhaPian](https://github.com/arenekosreal/AntiZhaPian)（已存档）
3. https://github.com/wangdaye078/AntiZhaPian
