package l;

import javax.annotation.Nullable;
import okhttp3.Headers;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* compiled from: Response.java */
/* loaded from: classes2.dex */
public final class m<T> {

    /* renamed from: a, reason: collision with root package name */
    private final Response f17158a;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    private final T f17159b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    private final ResponseBody f17160c;

    private m(Response response, @Nullable T t, @Nullable ResponseBody responseBody) {
        this.f17158a = response;
        this.f17159b = t;
        this.f17160c = responseBody;
    }

    public static <T> m<T> a(@Nullable T t) {
        return a(t, new Response.Builder().code(200).message("OK").protocol(Protocol.HTTP_1_1).request(new Request.Builder().url("http://localhost/").build()).build());
    }

    public int b() {
        return this.f17158a.code();
    }

    @Nullable
    public ResponseBody c() {
        return this.f17160c;
    }

    public Headers d() {
        return this.f17158a.headers();
    }

    public boolean e() {
        return this.f17158a.isSuccessful();
    }

    public String f() {
        return this.f17158a.message();
    }

    public Response g() {
        return this.f17158a;
    }

    public String toString() {
        return this.f17158a.toString();
    }

    public static <T> m<T> a(@Nullable T t, Headers headers) {
        p.a(headers, "headers == null");
        return a(t, new Response.Builder().code(200).message("OK").protocol(Protocol.HTTP_1_1).headers(headers).request(new Request.Builder().url("http://localhost/").build()).build());
    }

    public static <T> m<T> a(@Nullable T t, Response response) {
        p.a(response, "rawResponse == null");
        if (response.isSuccessful()) {
            return new m<>(response, t, null);
        }
        throw new IllegalArgumentException("rawResponse must be successful response");
    }

    public static <T> m<T> a(int i2, ResponseBody responseBody) {
        if (i2 >= 400) {
            return a(responseBody, new Response.Builder().code(i2).message("Response.error()").protocol(Protocol.HTTP_1_1).request(new Request.Builder().url("http://localhost/").build()).build());
        }
        throw new IllegalArgumentException("code < 400: " + i2);
    }

    public static <T> m<T> a(ResponseBody responseBody, Response response) {
        p.a(responseBody, "body == null");
        p.a(response, "rawResponse == null");
        if (!response.isSuccessful()) {
            return new m<>(response, null, responseBody);
        }
        throw new IllegalArgumentException("rawResponse should not be successful response");
    }

    @Nullable
    public T a() {
        return this.f17159b;
    }
}
