package l;

import h.f1;
import java.io.IOException;
import javax.annotation.Nullable;
import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.RequestBody;
import okio.Buffer;
import okio.BufferedSink;

/* compiled from: RequestBuilder.java */
/* loaded from: classes2.dex */
final class l {

    /* renamed from: k, reason: collision with root package name */
    private static final char[] f17144k = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* renamed from: l, reason: collision with root package name */
    private static final String f17145l = " \"<>^`{}|\\?#";

    /* renamed from: a, reason: collision with root package name */
    private final String f17146a;

    /* renamed from: b, reason: collision with root package name */
    private final HttpUrl f17147b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    private String f17148c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    private HttpUrl.Builder f17149d;

    /* renamed from: e, reason: collision with root package name */
    private final Request.Builder f17150e = new Request.Builder();

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    private MediaType f17151f;

    /* renamed from: g, reason: collision with root package name */
    private final boolean f17152g;

    /* renamed from: h, reason: collision with root package name */
    @Nullable
    private MultipartBody.Builder f17153h;

    /* renamed from: i, reason: collision with root package name */
    @Nullable
    private FormBody.Builder f17154i;

    /* renamed from: j, reason: collision with root package name */
    @Nullable
    private RequestBody f17155j;

    /* compiled from: RequestBuilder.java */
    private static class a extends RequestBody {

        /* renamed from: a, reason: collision with root package name */
        private final RequestBody f17156a;

        /* renamed from: b, reason: collision with root package name */
        private final MediaType f17157b;

        a(RequestBody requestBody, MediaType mediaType) {
            this.f17156a = requestBody;
            this.f17157b = mediaType;
        }

        @Override // okhttp3.RequestBody
        public long contentLength() throws IOException {
            return this.f17156a.contentLength();
        }

        @Override // okhttp3.RequestBody
        public MediaType contentType() {
            return this.f17157b;
        }

        @Override // okhttp3.RequestBody
        public void writeTo(BufferedSink bufferedSink) throws IOException {
            this.f17156a.writeTo(bufferedSink);
        }
    }

    l(String str, HttpUrl httpUrl, @Nullable String str2, @Nullable Headers headers, @Nullable MediaType mediaType, boolean z, boolean z2, boolean z3) {
        this.f17146a = str;
        this.f17147b = httpUrl;
        this.f17148c = str2;
        this.f17151f = mediaType;
        this.f17152g = z;
        if (headers != null) {
            this.f17150e.headers(headers);
        }
        if (z2) {
            this.f17154i = new FormBody.Builder();
        } else if (z3) {
            this.f17153h = new MultipartBody.Builder();
            this.f17153h.setType(MultipartBody.FORM);
        }
    }

    void a(Object obj) {
        this.f17148c = obj.toString();
    }

    void b(String str, String str2, boolean z) {
        String str3 = this.f17148c;
        if (str3 == null) {
            throw new AssertionError();
        }
        this.f17148c = str3.replace("{" + str + "}", a(str2, z));
    }

    void c(String str, @Nullable String str2, boolean z) {
        String str3 = this.f17148c;
        if (str3 != null) {
            this.f17149d = this.f17147b.newBuilder(str3);
            if (this.f17149d == null) {
                throw new IllegalArgumentException("Malformed URL. Base: " + this.f17147b + ", Relative: " + this.f17148c);
            }
            this.f17148c = null;
        }
        if (z) {
            this.f17149d.addEncodedQueryParameter(str, str2);
        } else {
            this.f17149d.addQueryParameter(str, str2);
        }
    }

    void a(String str, String str2) {
        if (!"Content-Type".equalsIgnoreCase(str)) {
            this.f17150e.addHeader(str, str2);
            return;
        }
        MediaType mediaType = MediaType.parse(str2);
        if (mediaType != null) {
            this.f17151f = mediaType;
            return;
        }
        throw new IllegalArgumentException("Malformed content type: " + str2);
    }

    private static String a(String str, boolean z) {
        int length = str.length();
        int iCharCount = 0;
        while (iCharCount < length) {
            int iCodePointAt = str.codePointAt(iCharCount);
            if (iCodePointAt >= 32 && iCodePointAt < 127 && f17145l.indexOf(iCodePointAt) == -1 && (z || (iCodePointAt != 47 && iCodePointAt != 37))) {
                iCharCount += Character.charCount(iCodePointAt);
            } else {
                Buffer buffer = new Buffer();
                buffer.writeUtf8(str, 0, iCharCount);
                a(buffer, str, iCharCount, length, z);
                return buffer.readUtf8();
            }
        }
        return str;
    }

    private static void a(Buffer buffer, String str, int i2, int i3, boolean z) {
        Buffer buffer2 = null;
        while (i2 < i3) {
            int iCodePointAt = str.codePointAt(i2);
            if (!z || (iCodePointAt != 9 && iCodePointAt != 10 && iCodePointAt != 12 && iCodePointAt != 13)) {
                if (iCodePointAt >= 32 && iCodePointAt < 127 && f17145l.indexOf(iCodePointAt) == -1 && (z || (iCodePointAt != 47 && iCodePointAt != 37))) {
                    buffer.writeUtf8CodePoint(iCodePointAt);
                } else {
                    if (buffer2 == null) {
                        buffer2 = new Buffer();
                    }
                    buffer2.writeUtf8CodePoint(iCodePointAt);
                    while (!buffer2.exhausted()) {
                        int i4 = buffer2.readByte() & f1.f16099c;
                        buffer.writeByte(37);
                        buffer.writeByte((int) f17144k[(i4 >> 4) & 15]);
                        buffer.writeByte((int) f17144k[i4 & 15]);
                    }
                }
            }
            i2 += Character.charCount(iCodePointAt);
        }
    }

    void a(String str, String str2, boolean z) {
        if (z) {
            this.f17154i.addEncoded(str, str2);
        } else {
            this.f17154i.add(str, str2);
        }
    }

    void a(Headers headers, RequestBody requestBody) {
        this.f17153h.addPart(headers, requestBody);
    }

    void a(MultipartBody.Part part) {
        this.f17153h.addPart(part);
    }

    void a(RequestBody requestBody) {
        this.f17155j = requestBody;
    }

    Request a() {
        HttpUrl httpUrlResolve;
        HttpUrl.Builder builder = this.f17149d;
        if (builder != null) {
            httpUrlResolve = builder.build();
        } else {
            httpUrlResolve = this.f17147b.resolve(this.f17148c);
            if (httpUrlResolve == null) {
                throw new IllegalArgumentException("Malformed URL. Base: " + this.f17147b + ", Relative: " + this.f17148c);
            }
        }
        RequestBody aVar = this.f17155j;
        if (aVar == null) {
            FormBody.Builder builder2 = this.f17154i;
            if (builder2 != null) {
                aVar = builder2.build();
            } else {
                MultipartBody.Builder builder3 = this.f17153h;
                if (builder3 != null) {
                    aVar = builder3.build();
                } else if (this.f17152g) {
                    aVar = RequestBody.create((MediaType) null, new byte[0]);
                }
            }
        }
        MediaType mediaType = this.f17151f;
        if (mediaType != null) {
            if (aVar != null) {
                aVar = new a(aVar, mediaType);
            } else {
                this.f17150e.addHeader("Content-Type", mediaType.toString());
            }
        }
        return this.f17150e.url(httpUrlResolve).method(this.f17146a, aVar).build();
    }
}
