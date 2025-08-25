package l;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import l.c;

/* compiled from: DefaultCallAdapterFactory.java */
/* loaded from: classes2.dex */
final class f extends c.a {

    /* renamed from: a, reason: collision with root package name */
    static final c.a f17088a = new f();

    /* compiled from: DefaultCallAdapterFactory.java */
    class a implements c<Object, b<?>> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Type f17089a;

        a(Type type) {
            this.f17089a = type;
        }

        @Override // l.c
        public b<?> a(b<Object> bVar) {
            return bVar;
        }

        @Override // l.c
        public Type a() {
            return this.f17089a;
        }
    }

    f() {
    }

    @Override // l.c.a
    public c<?, ?> a(Type type, Annotation[] annotationArr, n nVar) {
        if (c.a.a(type) != b.class) {
            return null;
        }
        return new a(p.b(type));
    }
}
