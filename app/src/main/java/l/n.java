package l;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import l.a;
import l.c;
import l.e;
import l.o;
import okhttp3.Call;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;

/* compiled from: Retrofit.java */
/* loaded from: classes2.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    private final Map<Method, o<?, ?>> f17161a = new ConcurrentHashMap();

    /* renamed from: b, reason: collision with root package name */
    final Call.Factory f17162b;

    /* renamed from: c, reason: collision with root package name */
    final HttpUrl f17163c;

    /* renamed from: d, reason: collision with root package name */
    final List<e.a> f17164d;

    /* renamed from: e, reason: collision with root package name */
    final List<c.a> f17165e;

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    final Executor f17166f;

    /* renamed from: g, reason: collision with root package name */
    final boolean f17167g;

    /* compiled from: Retrofit.java */
    class a implements InvocationHandler {

        /* renamed from: a, reason: collision with root package name */
        private final k f17168a = k.c();

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Class f17169b;

        a(Class cls) {
            this.f17169b = cls;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, @Nullable Object[] objArr) throws Throwable {
            if (method.getDeclaringClass() == Object.class) {
                return method.invoke(this, objArr);
            }
            if (this.f17168a.a(method)) {
                return this.f17168a.a(method, this.f17169b, obj, objArr);
            }
            o<?, ?> oVarA = n.this.a(method);
            return oVarA.a(new i(oVarA, objArr));
        }
    }

    /* compiled from: Retrofit.java */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        private final k f17171a;

        /* renamed from: b, reason: collision with root package name */
        @Nullable
        private Call.Factory f17172b;

        /* renamed from: c, reason: collision with root package name */
        private HttpUrl f17173c;

        /* renamed from: d, reason: collision with root package name */
        private final List<e.a> f17174d;

        /* renamed from: e, reason: collision with root package name */
        private final List<c.a> f17175e;

        /* renamed from: f, reason: collision with root package name */
        @Nullable
        private Executor f17176f;

        /* renamed from: g, reason: collision with root package name */
        private boolean f17177g;

        b(k kVar) {
            this.f17174d = new ArrayList();
            this.f17175e = new ArrayList();
            this.f17171a = kVar;
        }

        public b a(OkHttpClient okHttpClient) {
            return a((Call.Factory) p.a(okHttpClient, "client == null"));
        }

        public List<c.a> b() {
            return this.f17175e;
        }

        public List<e.a> c() {
            return this.f17174d;
        }

        public b a(Call.Factory factory) {
            this.f17172b = (Call.Factory) p.a(factory, "factory == null");
            return this;
        }

        public b a(String str) {
            p.a(str, "baseUrl == null");
            HttpUrl httpUrl = HttpUrl.parse(str);
            if (httpUrl != null) {
                return a(httpUrl);
            }
            throw new IllegalArgumentException("Illegal URL: " + str);
        }

        public b() {
            this(k.c());
        }

        b(n nVar) {
            this.f17174d = new ArrayList();
            this.f17175e = new ArrayList();
            this.f17171a = k.c();
            this.f17172b = nVar.f17162b;
            this.f17173c = nVar.f17163c;
            this.f17174d.addAll(nVar.f17164d);
            this.f17174d.remove(0);
            this.f17175e.addAll(nVar.f17165e);
            this.f17175e.remove(r0.size() - 1);
            this.f17176f = nVar.f17166f;
            this.f17177g = nVar.f17167g;
        }

        public b a(HttpUrl httpUrl) {
            p.a(httpUrl, "baseUrl == null");
            if ("".equals(httpUrl.pathSegments().get(r0.size() - 1))) {
                this.f17173c = httpUrl;
                return this;
            }
            throw new IllegalArgumentException("baseUrl must end in /: " + httpUrl);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public b a(e.a aVar) {
            this.f17174d.add(p.a(aVar, "factory == null"));
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public b a(c.a aVar) {
            this.f17175e.add(p.a(aVar, "factory == null"));
            return this;
        }

        public b a(Executor executor) {
            this.f17176f = (Executor) p.a(executor, "executor == null");
            return this;
        }

        public b a(boolean z) {
            this.f17177g = z;
            return this;
        }

        public n a() {
            if (this.f17173c != null) {
                Call.Factory okHttpClient = this.f17172b;
                if (okHttpClient == null) {
                    okHttpClient = new OkHttpClient();
                }
                Call.Factory factory = okHttpClient;
                Executor executorA = this.f17176f;
                if (executorA == null) {
                    executorA = this.f17171a.a();
                }
                Executor executor = executorA;
                ArrayList arrayList = new ArrayList(this.f17175e);
                arrayList.add(this.f17171a.a(executor));
                ArrayList arrayList2 = new ArrayList(this.f17174d.size() + 1);
                arrayList2.add(new l.a());
                arrayList2.addAll(this.f17174d);
                return new n(factory, this.f17173c, Collections.unmodifiableList(arrayList2), Collections.unmodifiableList(arrayList), executor, this.f17177g);
            }
            throw new IllegalStateException("Base URL required.");
        }
    }

    n(Call.Factory factory, HttpUrl httpUrl, List<e.a> list, List<c.a> list2, @Nullable Executor executor, boolean z) {
        this.f17162b = factory;
        this.f17163c = httpUrl;
        this.f17164d = list;
        this.f17165e = list2;
        this.f17166f = executor;
        this.f17167g = z;
    }

    private void b(Class<?> cls) throws SecurityException {
        k kVarC = k.c();
        for (Method method : cls.getDeclaredMethods()) {
            if (!kVarC.a(method)) {
                a(method);
            }
        }
    }

    public <T> T a(Class<T> cls) throws SecurityException {
        p.a((Class) cls);
        if (this.f17167g) {
            b(cls);
        }
        return (T) Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new a(cls));
    }

    public Call.Factory c() {
        return this.f17162b;
    }

    @Nullable
    public Executor d() {
        return this.f17166f;
    }

    public List<e.a> e() {
        return this.f17164d;
    }

    public b f() {
        return new b(this);
    }

    public <T> e<T, String> c(Type type, Annotation[] annotationArr) {
        p.a(type, "type == null");
        p.a(annotationArr, "annotations == null");
        int size = this.f17164d.size();
        for (int i2 = 0; i2 < size; i2++) {
            e<T, String> eVar = (e<T, String>) this.f17164d.get(i2).b(type, annotationArr, this);
            if (eVar != null) {
                return eVar;
            }
        }
        return a.d.f17086a;
    }

    o<?, ?> a(Method method) {
        o oVarA;
        o<?, ?> oVar = this.f17161a.get(method);
        if (oVar != null) {
            return oVar;
        }
        synchronized (this.f17161a) {
            oVarA = this.f17161a.get(method);
            if (oVarA == null) {
                oVarA = new o.a(this, method).a();
                this.f17161a.put(method, oVarA);
            }
        }
        return oVarA;
    }

    public List<c.a> b() {
        return this.f17165e;
    }

    public <T> e<ResponseBody, T> b(Type type, Annotation[] annotationArr) {
        return a((e.a) null, type, annotationArr);
    }

    public HttpUrl a() {
        return this.f17163c;
    }

    public c<?, ?> a(Type type, Annotation[] annotationArr) {
        return a((c.a) null, type, annotationArr);
    }

    public c<?, ?> a(@Nullable c.a aVar, Type type, Annotation[] annotationArr) {
        p.a(type, "returnType == null");
        p.a(annotationArr, "annotations == null");
        int iIndexOf = this.f17165e.indexOf(aVar) + 1;
        int size = this.f17165e.size();
        for (int i2 = iIndexOf; i2 < size; i2++) {
            c<?, ?> cVarA = this.f17165e.get(i2).a(type, annotationArr, this);
            if (cVarA != null) {
                return cVarA;
            }
        }
        StringBuilder sb = new StringBuilder("Could not locate call adapter for ");
        sb.append(type);
        sb.append(".\n");
        if (aVar != null) {
            sb.append("  Skipped:");
            for (int i3 = 0; i3 < iIndexOf; i3++) {
                sb.append("\n   * ");
                sb.append(this.f17165e.get(i3).getClass().getName());
            }
            sb.append('\n');
        }
        sb.append("  Tried:");
        int size2 = this.f17165e.size();
        while (iIndexOf < size2) {
            sb.append("\n   * ");
            sb.append(this.f17165e.get(iIndexOf).getClass().getName());
            iIndexOf++;
        }
        throw new IllegalArgumentException(sb.toString());
    }

    public <T> e<T, RequestBody> a(Type type, Annotation[] annotationArr, Annotation[] annotationArr2) {
        return a(null, type, annotationArr, annotationArr2);
    }

    public <T> e<T, RequestBody> a(@Nullable e.a aVar, Type type, Annotation[] annotationArr, Annotation[] annotationArr2) {
        p.a(type, "type == null");
        p.a(annotationArr, "parameterAnnotations == null");
        p.a(annotationArr2, "methodAnnotations == null");
        int iIndexOf = this.f17164d.indexOf(aVar) + 1;
        int size = this.f17164d.size();
        for (int i2 = iIndexOf; i2 < size; i2++) {
            e<T, RequestBody> eVar = (e<T, RequestBody>) this.f17164d.get(i2).a(type, annotationArr, annotationArr2, this);
            if (eVar != null) {
                return eVar;
            }
        }
        StringBuilder sb = new StringBuilder("Could not locate RequestBody converter for ");
        sb.append(type);
        sb.append(".\n");
        if (aVar != null) {
            sb.append("  Skipped:");
            for (int i3 = 0; i3 < iIndexOf; i3++) {
                sb.append("\n   * ");
                sb.append(this.f17164d.get(i3).getClass().getName());
            }
            sb.append('\n');
        }
        sb.append("  Tried:");
        int size2 = this.f17164d.size();
        while (iIndexOf < size2) {
            sb.append("\n   * ");
            sb.append(this.f17164d.get(iIndexOf).getClass().getName());
            iIndexOf++;
        }
        throw new IllegalArgumentException(sb.toString());
    }

    public <T> e<ResponseBody, T> a(@Nullable e.a aVar, Type type, Annotation[] annotationArr) {
        p.a(type, "type == null");
        p.a(annotationArr, "annotations == null");
        int iIndexOf = this.f17164d.indexOf(aVar) + 1;
        int size = this.f17164d.size();
        for (int i2 = iIndexOf; i2 < size; i2++) {
            e<ResponseBody, T> eVar = (e<ResponseBody, T>) this.f17164d.get(i2).a(type, annotationArr, this);
            if (eVar != null) {
                return eVar;
            }
        }
        StringBuilder sb = new StringBuilder("Could not locate ResponseBody converter for ");
        sb.append(type);
        sb.append(".\n");
        if (aVar != null) {
            sb.append("  Skipped:");
            for (int i3 = 0; i3 < iIndexOf; i3++) {
                sb.append("\n   * ");
                sb.append(this.f17164d.get(i3).getClass().getName());
            }
            sb.append('\n');
        }
        sb.append("  Tried:");
        int size2 = this.f17164d.size();
        while (iIndexOf < size2) {
            sb.append("\n   * ");
            sb.append(this.f17164d.get(iIndexOf).getClass().getName());
            iIndexOf++;
        }
        throw new IllegalArgumentException(sb.toString());
    }
}
