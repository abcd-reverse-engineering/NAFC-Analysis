package l;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.concurrent.Executor;
import l.c;
import okhttp3.Request;

/* compiled from: ExecutorCallAdapterFactory.java */
/* loaded from: classes2.dex */
final class g extends c.a {

    /* renamed from: a, reason: collision with root package name */
    final Executor f17091a;

    /* compiled from: ExecutorCallAdapterFactory.java */
    class a implements c<Object, l.b<?>> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Type f17092a;

        a(Type type) {
            this.f17092a = type;
        }

        @Override // l.c
        public Type a() {
            return this.f17092a;
        }

        @Override // l.c
        public l.b<?> a(l.b<Object> bVar) {
            return new b(g.this.f17091a, bVar);
        }
    }

    /* compiled from: ExecutorCallAdapterFactory.java */
    static final class b<T> implements l.b<T> {

        /* renamed from: a, reason: collision with root package name */
        final Executor f17094a;

        /* renamed from: b, reason: collision with root package name */
        final l.b<T> f17095b;

        /* compiled from: ExecutorCallAdapterFactory.java */
        class a implements d<T> {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ d f17096a;

            /* compiled from: ExecutorCallAdapterFactory.java */
            /* renamed from: l.g$b$a$a, reason: collision with other inner class name */
            class RunnableC0269a implements Runnable {

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ m f17098a;

                RunnableC0269a(m mVar) {
                    this.f17098a = mVar;
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.f17095b.isCanceled()) {
                        a aVar = a.this;
                        aVar.f17096a.onFailure(b.this, new IOException("Canceled"));
                    } else {
                        a aVar2 = a.this;
                        aVar2.f17096a.onResponse(b.this, this.f17098a);
                    }
                }
            }

            /* compiled from: ExecutorCallAdapterFactory.java */
            /* renamed from: l.g$b$a$b, reason: collision with other inner class name */
            class RunnableC0270b implements Runnable {

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ Throwable f17100a;

                RunnableC0270b(Throwable th) {
                    this.f17100a = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    a aVar = a.this;
                    aVar.f17096a.onFailure(b.this, this.f17100a);
                }
            }

            a(d dVar) {
                this.f17096a = dVar;
            }

            @Override // l.d
            public void onFailure(l.b<T> bVar, Throwable th) {
                b.this.f17094a.execute(new RunnableC0270b(th));
            }

            @Override // l.d
            public void onResponse(l.b<T> bVar, m<T> mVar) {
                b.this.f17094a.execute(new RunnableC0269a(mVar));
            }
        }

        b(Executor executor, l.b<T> bVar) {
            this.f17094a = executor;
            this.f17095b = bVar;
        }

        @Override // l.b
        public void a(d<T> dVar) {
            p.a(dVar, "callback == null");
            this.f17095b.a(new a(dVar));
        }

        @Override // l.b
        public void cancel() {
            this.f17095b.cancel();
        }

        @Override // l.b
        public m<T> execute() throws IOException {
            return this.f17095b.execute();
        }

        @Override // l.b
        public boolean isCanceled() {
            return this.f17095b.isCanceled();
        }

        @Override // l.b
        public boolean isExecuted() {
            return this.f17095b.isExecuted();
        }

        @Override // l.b
        public Request request() {
            return this.f17095b.request();
        }

        @Override // l.b
        public l.b<T> clone() {
            return new b(this.f17094a, this.f17095b.clone());
        }
    }

    g(Executor executor) {
        this.f17091a = executor;
    }

    @Override // l.c.a
    public c<?, ?> a(Type type, Annotation[] annotationArr, n nVar) {
        if (c.a.a(type) != l.b.class) {
            return null;
        }
        return new a(p.b(type));
    }
}
