package h.w2;

import androidx.exifinterface.media.ExifInterface;
import anet.channel.strategy.dispatch.DispatchConstants;
import bean.SurveyH5Bean;
import com.huawei.hms.push.constant.RemoteMessageConst;
import h.t0;
import h.y;
import java.util.Collection;
import java.util.List;

/* compiled from: KClass.kt */
@y(bv = {1, 0, 3}, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005J\u0013\u0010<\u001a\u00020\f2\b\u0010=\u001a\u0004\u0018\u00010\u0002H¦\u0002J\b\u0010>\u001a\u00020?H&J\u0012\u0010@\u001a\u00020\f2\b\u0010A\u001a\u0004\u0018\u00010\u0002H'R\u001e\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\b0\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\f8&X§\u0004¢\u0006\f\u0012\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\f8&X§\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0010\u0010\u000fR\u001a\u0010\u0012\u001a\u00020\f8&X§\u0004¢\u0006\f\u0012\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0012\u0010\u000fR\u001a\u0010\u0014\u001a\u00020\f8&X§\u0004¢\u0006\f\u0012\u0004\b\u0015\u0010\u000e\u001a\u0004\b\u0014\u0010\u000fR\u001a\u0010\u0016\u001a\u00020\f8&X§\u0004¢\u0006\f\u0012\u0004\b\u0017\u0010\u000e\u001a\u0004\b\u0016\u0010\u000fR\u001a\u0010\u0018\u001a\u00020\f8&X§\u0004¢\u0006\f\u0012\u0004\b\u0019\u0010\u000e\u001a\u0004\b\u0018\u0010\u000fR\u001a\u0010\u001a\u001a\u00020\f8&X§\u0004¢\u0006\f\u0012\u0004\b\u001b\u0010\u000e\u001a\u0004\b\u001a\u0010\u000fR\u001c\u0010\u001c\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u001d0\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\nR\u001c\u0010\u001f\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00000\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b \u0010\nR\u0014\u0010!\u001a\u0004\u0018\u00018\u0000X¦\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u0014\u0010$\u001a\u0004\u0018\u00010%X¦\u0004¢\u0006\u0006\u001a\u0004\b&\u0010'R(\u0010(\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00000)8&X§\u0004¢\u0006\f\u0012\u0004\b*\u0010\u000e\u001a\u0004\b+\u0010,R\u0014\u0010-\u001a\u0004\u0018\u00010%X¦\u0004¢\u0006\u0006\u001a\u0004\b.\u0010'R \u0010/\u001a\b\u0012\u0004\u0012\u0002000)8&X§\u0004¢\u0006\f\u0012\u0004\b1\u0010\u000e\u001a\u0004\b2\u0010,R \u00103\u001a\b\u0012\u0004\u0012\u0002040)8&X§\u0004¢\u0006\f\u0012\u0004\b5\u0010\u000e\u001a\u0004\b6\u0010,R\u001c\u00107\u001a\u0004\u0018\u0001088&X§\u0004¢\u0006\f\u0012\u0004\b9\u0010\u000e\u001a\u0004\b:\u0010;¨\u0006B"}, d2 = {"Lkotlin/reflect/KClass;", ExifInterface.GPS_DIRECTION_TRUE, "", "Lkotlin/reflect/KDeclarationContainer;", "Lkotlin/reflect/KAnnotatedElement;", "Lkotlin/reflect/KClassifier;", "constructors", "", "Lkotlin/reflect/KFunction;", "getConstructors", "()Ljava/util/Collection;", "isAbstract", "", "isAbstract$annotations", "()V", "()Z", "isCompanion", "isCompanion$annotations", "isData", "isData$annotations", "isFinal", "isFinal$annotations", "isInner", "isInner$annotations", "isOpen", "isOpen$annotations", "isSealed", "isSealed$annotations", "members", "Lkotlin/reflect/KCallable;", "getMembers", "nestedClasses", "getNestedClasses", "objectInstance", "getObjectInstance", "()Ljava/lang/Object;", "qualifiedName", "", "getQualifiedName", "()Ljava/lang/String;", "sealedSubclasses", "", "sealedSubclasses$annotations", "getSealedSubclasses", "()Ljava/util/List;", "simpleName", "getSimpleName", "supertypes", "Lkotlin/reflect/KType;", "supertypes$annotations", "getSupertypes", "typeParameters", "Lkotlin/reflect/KTypeParameter;", "typeParameters$annotations", "getTypeParameters", RemoteMessageConst.Notification.VISIBILITY, "Lkotlin/reflect/KVisibility;", "visibility$annotations", "getVisibility", "()Lkotlin/reflect/KVisibility;", "equals", DispatchConstants.OTHER, "hashCode", "", "isInstance", SurveyH5Bean.VALUE, "kotlin-stdlib"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes2.dex */
public interface c<T> extends f, h.w2.a, e {

    /* compiled from: KClass.kt */
    public static final class a {
        @t0(version = "1.1")
        public static /* synthetic */ void a() {
        }

        @t0(version = "1.1")
        public static /* synthetic */ void b() {
        }

        @t0(version = "1.1")
        public static /* synthetic */ void c() {
        }

        @t0(version = "1.1")
        public static /* synthetic */ void d() {
        }

        @t0(version = "1.1")
        public static /* synthetic */ void e() {
        }

        @t0(version = "1.1")
        public static /* synthetic */ void f() {
        }

        @t0(version = "1.1")
        public static /* synthetic */ void g() {
        }

        @t0(version = "1.3")
        public static /* synthetic */ void h() {
        }

        @t0(version = "1.1")
        public static /* synthetic */ void i() {
        }

        @t0(version = "1.1")
        public static /* synthetic */ void j() {
        }

        @t0(version = "1.1")
        public static /* synthetic */ void k() {
        }
    }

    @Override // h.w2.f
    @i.c.a.d
    Collection<b<?>> a();

    @t0(version = "1.1")
    boolean a(@i.c.a.e Object obj);

    @i.c.a.e
    String b();

    @i.c.a.d
    Collection<c<?>> c();

    @i.c.a.d
    Collection<g<T>> d();

    @i.c.a.d
    List<c<? extends T>> e();

    boolean equals(@i.c.a.e Object obj);

    boolean f();

    @i.c.a.e
    String g();

    @i.c.a.d
    List<r> getTypeParameters();

    @i.c.a.e
    u getVisibility();

    @i.c.a.d
    List<q> h();

    int hashCode();

    @i.c.a.e
    T i();

    boolean isAbstract();

    boolean isFinal();

    boolean isOpen();

    boolean j();

    boolean k();

    boolean l();
}
