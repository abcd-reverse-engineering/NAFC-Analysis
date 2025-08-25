package a.a;

import anet.channel.request.BodyEntry;
import java.net.URI;
import java.net.URL;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public interface h {
    List<a> a();

    void a(int i2);

    void a(a aVar);

    @Deprecated
    void a(b bVar);

    void a(BodyEntry bodyEntry);

    void a(String str);

    void a(String str, String str2);

    @Deprecated
    void a(URI uri);

    void a(List<g> list);

    @Deprecated
    void a(boolean z);

    String b();

    @Deprecated
    void b(int i2);

    void b(a aVar);

    void b(String str);

    void b(String str, String str2);

    void b(List<a> list);

    void b(boolean z);

    @Deprecated
    b c();

    void c(int i2);

    a[] c(String str);

    Map<String, String> d();

    void d(int i2);

    void d(String str);

    void e(String str);

    @Deprecated
    boolean e();

    String f();

    String f(String str);

    String g();

    int getConnectTimeout();

    List<g> getParams();

    int getReadTimeout();

    boolean h();

    BodyEntry i();

    @Deprecated
    URL j();

    int k();

    String l();

    @Deprecated
    URI m();

    String n();
}
