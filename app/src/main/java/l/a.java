package l;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import l.e;
import l.s.w;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;

/* compiled from: BuiltInConverters.java */
/* loaded from: classes2.dex */
final class a extends e.a {

    /* compiled from: BuiltInConverters.java */
    /* renamed from: l.a$a, reason: collision with other inner class name */
    static final class C0268a implements l.e<ResponseBody, ResponseBody> {

        /* renamed from: a, reason: collision with root package name */
        static final C0268a f17083a = new C0268a();

        C0268a() {
        }

        @Override // l.e
        public ResponseBody a(ResponseBody responseBody) throws IOException {
            try {
                return p.a(responseBody);
            } finally {
                responseBody.close();
            }
        }
    }

    /* compiled from: BuiltInConverters.java */
    static final class b implements l.e<RequestBody, RequestBody> {

        /* renamed from: a, reason: collision with root package name */
        static final b f17084a = new b();

        b() {
        }

        @Override // l.e
        public RequestBody a(RequestBody requestBody) {
            return requestBody;
        }
    }

    /* compiled from: BuiltInConverters.java */
    static final class c implements l.e<ResponseBody, ResponseBody> {

        /* renamed from: a, reason: collision with root package name */
        static final c f17085a = new c();

        c() {
        }

        @Override // l.e
        public ResponseBody a(ResponseBody responseBody) {
            return responseBody;
        }
    }

    /* compiled from: BuiltInConverters.java */
    static final class d implements l.e<Object, String> {

        /* renamed from: a, reason: collision with root package name */
        static final d f17086a = new d();

        d() {
        }

        @Override // l.e
        public String a(Object obj) {
            return obj.toString();
        }
    }

    /* compiled from: BuiltInConverters.java */
    static final class e implements l.e<ResponseBody, Void> {

        /* renamed from: a, reason: collision with root package name */
        static final e f17087a = new e();

        e() {
        }

        @Override // l.e
        public Void a(ResponseBody responseBody) {
            responseBody.close();
            return null;
        }
    }

    a() {
    }

    @Override // l.e.a
    public l.e<ResponseBody, ?> a(Type type, Annotation[] annotationArr, n nVar) {
        if (type == ResponseBody.class) {
            return p.a(annotationArr, (Class<? extends Annotation>) w.class) ? c.f17085a : C0268a.f17083a;
        }
        if (type == Void.class) {
            return e.f17087a;
        }
        return null;
    }

    @Override // l.e.a
    public l.e<?, RequestBody> a(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, n nVar) {
        if (RequestBody.class.isAssignableFrom(p.c(type))) {
            return b.f17084a;
        }
        return null;
    }
}
