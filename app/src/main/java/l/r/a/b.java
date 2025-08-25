package l.r.a;

import com.google.gson.y;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import l.e;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.Buffer;

/* compiled from: GsonRequestBodyConverter.java */
/* loaded from: classes2.dex */
final class b<T> implements e<T, RequestBody> {

    /* renamed from: c, reason: collision with root package name */
    private static final MediaType f17238c = MediaType.parse("application/json; charset=UTF-8");

    /* renamed from: d, reason: collision with root package name */
    private static final Charset f17239d = Charset.forName("UTF-8");

    /* renamed from: a, reason: collision with root package name */
    private final com.google.gson.e f17240a;

    /* renamed from: b, reason: collision with root package name */
    private final y<T> f17241b;

    b(com.google.gson.e eVar, y<T> yVar) {
        this.f17240a = eVar;
        this.f17241b = yVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // l.e
    public /* bridge */ /* synthetic */ RequestBody a(Object obj) throws IOException {
        return a((b<T>) obj);
    }

    @Override // l.e
    public RequestBody a(T t) throws IOException {
        Buffer buffer = new Buffer();
        com.google.gson.e0.d dVarA = this.f17240a.a((Writer) new OutputStreamWriter(buffer.outputStream(), f17239d));
        this.f17241b.write(dVarA, t);
        dVarA.close();
        return RequestBody.create(f17238c, buffer.readByteString());
    }
}
