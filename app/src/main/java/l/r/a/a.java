package l.r.a;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import l.e;
import l.n;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;

/* compiled from: GsonConverterFactory.java */
/* loaded from: classes2.dex */
public final class a extends e.a {

    /* renamed from: a, reason: collision with root package name */
    private final com.google.gson.e f17237a;

    private a(com.google.gson.e eVar) {
        this.f17237a = eVar;
    }

    public static a a() {
        return a(new com.google.gson.e());
    }

    public static a a(com.google.gson.e eVar) {
        if (eVar != null) {
            return new a(eVar);
        }
        throw new NullPointerException("gson == null");
    }

    @Override // l.e.a
    public e<ResponseBody, ?> a(Type type, Annotation[] annotationArr, n nVar) {
        return new c(this.f17237a, this.f17237a.a((com.google.gson.d0.a) com.google.gson.d0.a.get(type)));
    }

    @Override // l.e.a
    public e<?, RequestBody> a(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, n nVar) {
        return new b(this.f17237a, this.f17237a.a((com.google.gson.d0.a) com.google.gson.d0.a.get(type)));
    }
}
