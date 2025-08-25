package g.a.t0;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* compiled from: SchedulerSupport.java */
@Target({ElementType.METHOD, ElementType.TYPE})
@Documented
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes2.dex */
public @interface h {

    /* renamed from: h, reason: collision with root package name */
    public static final String f13868h = "none";

    /* renamed from: i, reason: collision with root package name */
    public static final String f13869i = "custom";

    /* renamed from: j, reason: collision with root package name */
    public static final String f13870j = "io.reactivex:computation";

    /* renamed from: k, reason: collision with root package name */
    public static final String f13871k = "io.reactivex:io";

    /* renamed from: l, reason: collision with root package name */
    public static final String f13872l = "io.reactivex:new-thread";

    /* renamed from: m, reason: collision with root package name */
    public static final String f13873m = "io.reactivex:trampoline";

    @e
    public static final String n = "io.reactivex:single";

    String value();
}
