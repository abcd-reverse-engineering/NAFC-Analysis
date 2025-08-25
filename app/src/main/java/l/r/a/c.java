package l.r.a;

import com.google.gson.l;
import com.google.gson.y;
import java.io.IOException;
import l.e;
import okhttp3.ResponseBody;

/* compiled from: GsonResponseBodyConverter.java */
/* loaded from: classes2.dex */
final class c<T> implements e<ResponseBody, T> {

    /* renamed from: a, reason: collision with root package name */
    private final com.google.gson.e f17242a;

    /* renamed from: b, reason: collision with root package name */
    private final y<T> f17243b;

    c(com.google.gson.e eVar, y<T> yVar) {
        this.f17242a = eVar;
        this.f17243b = yVar;
    }

    @Override // l.e
    public T a(ResponseBody responseBody) throws IOException {
        com.google.gson.e0.a aVarA = this.f17242a.a(responseBody.charStream());
        try {
            T t = this.f17243b.read2(aVarA);
            if (aVarA.peek() == com.google.gson.e0.c.END_DOCUMENT) {
                return t;
            }
            throw new l("JSON document was not fully consumed.");
        } finally {
            responseBody.close();
        }
    }
}
