package l;

import java.io.IOException;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import okio.ForwardingSource;
import okio.Okio;
import okio.Source;

/* compiled from: OkHttpCall.java */
/* loaded from: classes2.dex */
final class i<T> implements l.b<T> {

    /* renamed from: a, reason: collision with root package name */
    private final o<T, ?> f17103a;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    private final Object[] f17104b;

    /* renamed from: c, reason: collision with root package name */
    private volatile boolean f17105c;

    /* renamed from: d, reason: collision with root package name */
    @GuardedBy("this")
    @Nullable
    private Call f17106d;

    /* renamed from: e, reason: collision with root package name */
    @GuardedBy("this")
    @Nullable
    private Throwable f17107e;

    /* renamed from: f, reason: collision with root package name */
    @GuardedBy("this")
    private boolean f17108f;

    /* compiled from: OkHttpCall.java */
    class a implements Callback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ d f17109a;

        a(d dVar) {
            this.f17109a = dVar;
        }

        private void a(Throwable th) {
            try {
                this.f17109a.onFailure(i.this, th);
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            a(iOException);
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, Response response) {
            try {
                try {
                    this.f17109a.onResponse(i.this, i.this.a(response));
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            } catch (Throwable th2) {
                a(th2);
            }
        }
    }

    /* compiled from: OkHttpCall.java */
    static final class b extends ResponseBody {

        /* renamed from: a, reason: collision with root package name */
        private final ResponseBody f17111a;

        /* renamed from: b, reason: collision with root package name */
        IOException f17112b;

        /* compiled from: OkHttpCall.java */
        class a extends ForwardingSource {
            a(Source source) {
                super(source);
            }

            @Override // okio.ForwardingSource, okio.Source
            public long read(Buffer buffer, long j2) throws IOException {
                try {
                    return super.read(buffer, j2);
                } catch (IOException e2) {
                    b.this.f17112b = e2;
                    throw e2;
                }
            }
        }

        b(ResponseBody responseBody) {
            this.f17111a = responseBody;
        }

        void c() throws IOException {
            IOException iOException = this.f17112b;
            if (iOException != null) {
                throw iOException;
            }
        }

        @Override // okhttp3.ResponseBody, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.f17111a.close();
        }

        @Override // okhttp3.ResponseBody
        public long contentLength() {
            return this.f17111a.contentLength();
        }

        @Override // okhttp3.ResponseBody
        public MediaType contentType() {
            return this.f17111a.contentType();
        }

        @Override // okhttp3.ResponseBody
        public BufferedSource source() {
            return Okio.buffer(new a(this.f17111a.source()));
        }
    }

    /* compiled from: OkHttpCall.java */
    static final class c extends ResponseBody {

        /* renamed from: a, reason: collision with root package name */
        private final MediaType f17114a;

        /* renamed from: b, reason: collision with root package name */
        private final long f17115b;

        c(MediaType mediaType, long j2) {
            this.f17114a = mediaType;
            this.f17115b = j2;
        }

        @Override // okhttp3.ResponseBody
        public long contentLength() {
            return this.f17115b;
        }

        @Override // okhttp3.ResponseBody
        public MediaType contentType() {
            return this.f17114a;
        }

        @Override // okhttp3.ResponseBody
        public BufferedSource source() {
            throw new IllegalStateException("Cannot read raw response body of a converted body.");
        }
    }

    i(o<T, ?> oVar, @Nullable Object[] objArr) {
        this.f17103a = oVar;
        this.f17104b = objArr;
    }

    @Override // l.b
    public void a(d<T> dVar) {
        Call call;
        Throwable th;
        p.a(dVar, "callback == null");
        synchronized (this) {
            if (this.f17108f) {
                throw new IllegalStateException("Already executed.");
            }
            this.f17108f = true;
            call = this.f17106d;
            th = this.f17107e;
            if (call == null && th == null) {
                try {
                    Call callA = a();
                    this.f17106d = callA;
                    call = callA;
                } catch (Throwable th2) {
                    th = th2;
                    p.a(th);
                    this.f17107e = th;
                }
            }
        }
        if (th != null) {
            dVar.onFailure(this, th);
            return;
        }
        if (this.f17105c) {
            call.cancel();
        }
        call.enqueue(new a(dVar));
    }

    @Override // l.b
    public void cancel() {
        Call call;
        this.f17105c = true;
        synchronized (this) {
            call = this.f17106d;
        }
        if (call != null) {
            call.cancel();
        }
    }

    @Override // l.b
    public m<T> execute() throws IOException {
        Call callA;
        synchronized (this) {
            if (this.f17108f) {
                throw new IllegalStateException("Already executed.");
            }
            this.f17108f = true;
            if (this.f17107e != null) {
                if (this.f17107e instanceof IOException) {
                    throw ((IOException) this.f17107e);
                }
                if (this.f17107e instanceof RuntimeException) {
                    throw ((RuntimeException) this.f17107e);
                }
                throw ((Error) this.f17107e);
            }
            callA = this.f17106d;
            if (callA == null) {
                try {
                    callA = a();
                    this.f17106d = callA;
                } catch (IOException | Error | RuntimeException e2) {
                    p.a(e2);
                    this.f17107e = e2;
                    throw e2;
                }
            }
        }
        if (this.f17105c) {
            callA.cancel();
        }
        return a(callA.execute());
    }

    @Override // l.b
    public boolean isCanceled() {
        boolean z = true;
        if (this.f17105c) {
            return true;
        }
        synchronized (this) {
            if (this.f17106d == null || !this.f17106d.isCanceled()) {
                z = false;
            }
        }
        return z;
    }

    @Override // l.b
    public synchronized boolean isExecuted() {
        return this.f17108f;
    }

    @Override // l.b
    public synchronized Request request() {
        Call call = this.f17106d;
        if (call != null) {
            return call.request();
        }
        if (this.f17107e != null) {
            if (this.f17107e instanceof IOException) {
                throw new RuntimeException("Unable to create request.", this.f17107e);
            }
            if (this.f17107e instanceof RuntimeException) {
                throw ((RuntimeException) this.f17107e);
            }
            throw ((Error) this.f17107e);
        }
        try {
            Call callA = a();
            this.f17106d = callA;
            return callA.request();
        } catch (IOException e2) {
            this.f17107e = e2;
            throw new RuntimeException("Unable to create request.", e2);
        } catch (Error e3) {
            e = e3;
            p.a(e);
            this.f17107e = e;
            throw e;
        } catch (RuntimeException e4) {
            e = e4;
            p.a(e);
            this.f17107e = e;
            throw e;
        }
    }

    @Override // l.b
    public i<T> clone() {
        return new i<>(this.f17103a, this.f17104b);
    }

    private Call a() throws IOException {
        Call callA = this.f17103a.a(this.f17104b);
        if (callA != null) {
            return callA;
        }
        throw new NullPointerException("Call.Factory returned null.");
    }

    m<T> a(Response response) throws IOException {
        ResponseBody responseBodyBody = response.body();
        Response responseBuild = response.newBuilder().body(new c(responseBodyBody.contentType(), responseBodyBody.contentLength())).build();
        int iCode = responseBuild.code();
        if (iCode < 200 || iCode >= 300) {
            try {
                return m.a(p.a(responseBodyBody), responseBuild);
            } finally {
                responseBodyBody.close();
            }
        }
        if (iCode != 204 && iCode != 205) {
            b bVar = new b(responseBodyBody);
            try {
                return m.a(this.f17103a.a(bVar), responseBuild);
            } catch (RuntimeException e2) {
                bVar.c();
                throw e2;
            }
        }
        responseBodyBody.close();
        return m.a((Object) null, responseBuild);
    }
}
