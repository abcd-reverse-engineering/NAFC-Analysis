package h.w2;

import h.t0;
import h.y;

/* compiled from: KProperty.kt */
@y(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\bf\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002:\u0002\u000e\u000fR\u0018\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\b8&X§\u0004¢\u0006\f\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\u000bR\u001a\u0010\f\u001a\u00020\b8&X§\u0004¢\u0006\f\u0012\u0004\b\r\u0010\n\u001a\u0004\b\f\u0010\u000b¨\u0006\u0010"}, d2 = {"Lkotlin/reflect/KProperty;", "R", "Lkotlin/reflect/KCallable;", "getter", "Lkotlin/reflect/KProperty$Getter;", "getGetter", "()Lkotlin/reflect/KProperty$Getter;", "isConst", "", "isConst$annotations", "()V", "()Z", "isLateinit", "isLateinit$annotations", "Accessor", "Getter", "kotlin-stdlib"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes2.dex */
public interface m<R> extends h.w2.b<R> {

    /* compiled from: KProperty.kt */
    public interface a<R> {
        @i.c.a.d
        m<R> a();
    }

    /* compiled from: KProperty.kt */
    public static final class b {
        @t0(version = "1.1")
        public static /* synthetic */ void a() {
        }

        @t0(version = "1.1")
        public static /* synthetic */ void b() {
        }
    }

    /* compiled from: KProperty.kt */
    public interface c<R> extends a<R>, g<R> {
    }

    @i.c.a.d
    c<R> getGetter();

    boolean isConst();

    boolean isLateinit();
}
