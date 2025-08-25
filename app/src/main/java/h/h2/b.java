package h.h2;

import androidx.exifinterface.media.ExifInterface;
import com.umeng.analytics.pro.bh;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import h.e1;
import h.q2.s.p;
import h.q2.t.i0;
import h.y;
import java.util.Comparator;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Comparisons.kt */
@y(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a;\u0010\u0000\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u0003\"\u0004\b\u0000\u0010\u00022\u001a\b\u0004\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00060\u0005H\u0087\b\u001aY\u0010\u0000\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u0003\"\u0004\b\u0000\u0010\u000226\u0010\u0007\u001a\u001c\u0012\u0018\b\u0001\u0012\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00060\u00050\b\"\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00060\u0005¢\u0006\u0002\u0010\t\u001aW\u0010\u0000\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u0003\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\n2\u001a\u0010\u000b\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\n0\u0001j\n\u0012\u0006\b\u0000\u0012\u0002H\n`\u00032\u0014\b\u0004\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\n0\u0005H\u0087\b\u001a;\u0010\f\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u0003\"\u0004\b\u0000\u0010\u00022\u001a\b\u0004\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00060\u0005H\u0087\b\u001aW\u0010\f\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u0003\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\n2\u001a\u0010\u000b\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\n0\u0001j\n\u0012\u0006\b\u0000\u0012\u0002H\n`\u00032\u0014\b\u0004\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\n0\u0005H\u0087\b\u001a-\u0010\r\u001a\u00020\u000e\"\f\b\u0000\u0010\u0002*\u0006\u0012\u0002\b\u00030\u00062\b\u0010\u000f\u001a\u0004\u0018\u0001H\u00022\b\u0010\u0010\u001a\u0004\u0018\u0001H\u0002¢\u0006\u0002\u0010\u0011\u001a>\u0010\u0012\u001a\u00020\u000e\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u000f\u001a\u0002H\u00022\u0006\u0010\u0010\u001a\u0002H\u00022\u0018\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00060\u0005H\u0087\b¢\u0006\u0002\u0010\u0013\u001aY\u0010\u0012\u001a\u00020\u000e\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u000f\u001a\u0002H\u00022\u0006\u0010\u0010\u001a\u0002H\u000226\u0010\u0007\u001a\u001c\u0012\u0018\b\u0001\u0012\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00060\u00050\b\"\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00060\u0005¢\u0006\u0002\u0010\u0014\u001aZ\u0010\u0012\u001a\u00020\u000e\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\n2\u0006\u0010\u000f\u001a\u0002H\u00022\u0006\u0010\u0010\u001a\u0002H\u00022\u001a\u0010\u000b\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\n0\u0001j\n\u0012\u0006\b\u0000\u0012\u0002H\n`\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\n0\u0005H\u0087\b¢\u0006\u0002\u0010\u0015\u001aG\u0010\u0016\u001a\u00020\u000e\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u000f\u001a\u0002H\u00022\u0006\u0010\u0010\u001a\u0002H\u00022 \u0010\u0007\u001a\u001c\u0012\u0018\b\u0001\u0012\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00060\u00050\bH\u0002¢\u0006\u0004\b\u0017\u0010\u0014\u001a&\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u0003\"\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0006\u001a-\u0010\u0019\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u0001j\n\u0012\u0006\u0012\u0004\u0018\u0001H\u0002`\u0003\"\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0006H\u0087\b\u001a@\u0010\u0019\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u0001j\n\u0012\u0006\u0012\u0004\u0018\u0001H\u0002`\u0003\"\b\b\u0000\u0010\u0002*\u00020\u001a2\u001a\u0010\u000b\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u00020\u0001j\n\u0012\u0006\b\u0000\u0012\u0002H\u0002`\u0003\u001a-\u0010\u001b\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u0001j\n\u0012\u0006\u0012\u0004\u0018\u0001H\u0002`\u0003\"\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0006H\u0087\b\u001a@\u0010\u001b\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u0001j\n\u0012\u0006\u0012\u0004\u0018\u0001H\u0002`\u0003\"\b\b\u0000\u0010\u0002*\u00020\u001a2\u001a\u0010\u000b\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u00020\u0001j\n\u0012\u0006\b\u0000\u0012\u0002H\u0002`\u0003\u001a&\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u0003\"\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0006\u001a0\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u0003\"\u0004\b\u0000\u0010\u0002*\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u0003\u001aO\u0010\u001e\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u0003\"\u0004\b\u0000\u0010\u0002*\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u00032\u001a\u0010\u000b\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u00020\u0001j\n\u0012\u0006\b\u0000\u0012\u0002H\u0002`\u0003H\u0086\u0004\u001aO\u0010\u001f\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u0003\"\u0004\b\u0000\u0010\u0002*\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u00032\u001a\b\u0004\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00060\u0005H\u0087\b\u001ak\u0010\u001f\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u0003\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\n*\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u00032\u001a\u0010\u000b\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\n0\u0001j\n\u0012\u0006\b\u0000\u0012\u0002H\n`\u00032\u0014\b\u0004\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\n0\u0005H\u0087\b\u001aO\u0010 \u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u0003\"\u0004\b\u0000\u0010\u0002*\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u00032\u001a\b\u0004\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00060\u0005H\u0087\b\u001ak\u0010 \u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u0003\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\n*\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u00032\u001a\u0010\u000b\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\n0\u0001j\n\u0012\u0006\b\u0000\u0012\u0002H\n`\u00032\u0014\b\u0004\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\n0\u0005H\u0087\b\u001am\u0010!\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u0003\"\u0004\b\u0000\u0010\u0002*\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u000328\b\u0004\u0010\"\u001a2\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u000e0#H\u0087\b\u001aO\u0010&\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u0003\"\u0004\b\u0000\u0010\u0002*\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u00032\u001a\u0010\u000b\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u00020\u0001j\n\u0012\u0006\b\u0000\u0012\u0002H\u0002`\u0003H\u0086\u0004¨\u0006'"}, d2 = {"compareBy", "Ljava/util/Comparator;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/Comparator;", "selector", "Lkotlin/Function1;", "", "selectors", "", "([Lkotlin/jvm/functions/Function1;)Ljava/util/Comparator;", "K", "comparator", "compareByDescending", "compareValues", "", bh.ay, "b", "(Ljava/lang/Comparable;Ljava/lang/Comparable;)I", "compareValuesBy", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)I", "(Ljava/lang/Object;Ljava/lang/Object;[Lkotlin/jvm/functions/Function1;)I", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/util/Comparator;Lkotlin/jvm/functions/Function1;)I", "compareValuesByImpl", "compareValuesByImpl$ComparisonsKt__ComparisonsKt", "naturalOrder", "nullsFirst", "", "nullsLast", "reverseOrder", "reversed", "then", "thenBy", "thenByDescending", "thenComparator", "comparison", "Lkotlin/Function2;", "Lkotlin/ParameterName;", CommonNetImpl.NAME, "thenDescending", "kotlin-stdlib"}, k = 5, mv = {1, 1, 16}, xi = 1, xs = "kotlin/comparisons/ComparisonsKt")
/* loaded from: classes2.dex */
public class b {

    /* compiled from: Comparisons.kt */
    static final class a<T> implements Comparator<T> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ h.q2.s.l[] f16202a;

        a(h.q2.s.l[] lVarArr) {
            this.f16202a = lVarArr;
        }

        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            return b.c(t, t2, this.f16202a);
        }
    }

    /* compiled from: Comparisons.kt */
    /* renamed from: h.h2.b$b, reason: collision with other inner class name */
    public static final class C0239b<T> implements Comparator<T> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ h.q2.s.l f16203a;

        public C0239b(h.q2.s.l lVar) {
            this.f16203a = lVar;
        }

        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            return b.a((Comparable) this.f16203a.invoke(t), (Comparable) this.f16203a.invoke(t2));
        }
    }

    /* compiled from: Comparisons.kt */
    public static final class c<T> implements Comparator<T> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Comparator f16204a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ h.q2.s.l f16205b;

        public c(Comparator comparator, h.q2.s.l lVar) {
            this.f16204a = comparator;
            this.f16205b = lVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            return this.f16204a.compare(this.f16205b.invoke(t), this.f16205b.invoke(t2));
        }
    }

    /* compiled from: Comparisons.kt */
    public static final class d<T> implements Comparator<T> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ h.q2.s.l f16206a;

        public d(h.q2.s.l lVar) {
            this.f16206a = lVar;
        }

        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            return b.a((Comparable) this.f16206a.invoke(t2), (Comparable) this.f16206a.invoke(t));
        }
    }

    /* compiled from: Comparisons.kt */
    public static final class e<T> implements Comparator<T> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Comparator f16207a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ h.q2.s.l f16208b;

        public e(Comparator comparator, h.q2.s.l lVar) {
            this.f16207a = comparator;
            this.f16208b = lVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            return this.f16207a.compare(this.f16208b.invoke(t2), this.f16208b.invoke(t));
        }
    }

    /* compiled from: Comparisons.kt */
    static final class f<T> implements Comparator<T> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Comparator f16209a;

        f(Comparator comparator) {
            this.f16209a = comparator;
        }

        @Override // java.util.Comparator
        public final int compare(@i.c.a.e T t, @i.c.a.e T t2) {
            if (t == t2) {
                return 0;
            }
            if (t == null) {
                return -1;
            }
            if (t2 == null) {
                return 1;
            }
            return this.f16209a.compare(t, t2);
        }
    }

    /* compiled from: Comparisons.kt */
    static final class g<T> implements Comparator<T> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Comparator f16210a;

        g(Comparator comparator) {
            this.f16210a = comparator;
        }

        @Override // java.util.Comparator
        public final int compare(@i.c.a.e T t, @i.c.a.e T t2) {
            if (t == t2) {
                return 0;
            }
            if (t == null) {
                return 1;
            }
            if (t2 == null) {
                return -1;
            }
            return this.f16210a.compare(t, t2);
        }
    }

    /* compiled from: Comparisons.kt */
    static final class h<T> implements Comparator<T> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Comparator f16211a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Comparator f16212b;

        h(Comparator comparator, Comparator comparator2) {
            this.f16211a = comparator;
            this.f16212b = comparator2;
        }

        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            int iCompare = this.f16211a.compare(t, t2);
            return iCompare != 0 ? iCompare : this.f16212b.compare(t, t2);
        }
    }

    /* compiled from: Comparisons.kt */
    public static final class i<T> implements Comparator<T> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Comparator f16213a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ h.q2.s.l f16214b;

        public i(Comparator comparator, h.q2.s.l lVar) {
            this.f16213a = comparator;
            this.f16214b = lVar;
        }

        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            int iCompare = this.f16213a.compare(t, t2);
            return iCompare != 0 ? iCompare : b.a((Comparable) this.f16214b.invoke(t), (Comparable) this.f16214b.invoke(t2));
        }
    }

    /* compiled from: Comparisons.kt */
    public static final class j<T> implements Comparator<T> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Comparator f16215a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Comparator f16216b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ h.q2.s.l f16217c;

        public j(Comparator comparator, Comparator comparator2, h.q2.s.l lVar) {
            this.f16215a = comparator;
            this.f16216b = comparator2;
            this.f16217c = lVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            int iCompare = this.f16215a.compare(t, t2);
            return iCompare != 0 ? iCompare : this.f16216b.compare(this.f16217c.invoke(t), this.f16217c.invoke(t2));
        }
    }

    /* compiled from: Comparisons.kt */
    public static final class k<T> implements Comparator<T> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Comparator f16218a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ h.q2.s.l f16219b;

        public k(Comparator comparator, h.q2.s.l lVar) {
            this.f16218a = comparator;
            this.f16219b = lVar;
        }

        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            int iCompare = this.f16218a.compare(t, t2);
            return iCompare != 0 ? iCompare : b.a((Comparable) this.f16219b.invoke(t2), (Comparable) this.f16219b.invoke(t));
        }
    }

    /* compiled from: Comparisons.kt */
    public static final class l<T> implements Comparator<T> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Comparator f16220a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Comparator f16221b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ h.q2.s.l f16222c;

        public l(Comparator comparator, Comparator comparator2, h.q2.s.l lVar) {
            this.f16220a = comparator;
            this.f16221b = comparator2;
            this.f16222c = lVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            int iCompare = this.f16220a.compare(t, t2);
            return iCompare != 0 ? iCompare : this.f16221b.compare(this.f16222c.invoke(t2), this.f16222c.invoke(t));
        }
    }

    /* compiled from: Comparisons.kt */
    public static final class m<T> implements Comparator<T> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Comparator f16223a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ p f16224b;

        public m(Comparator comparator, p pVar) {
            this.f16223a = comparator;
            this.f16224b = pVar;
        }

        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            int iCompare = this.f16223a.compare(t, t2);
            return iCompare != 0 ? iCompare : ((Number) this.f16224b.invoke(t, t2)).intValue();
        }
    }

    /* compiled from: Comparisons.kt */
    static final class n<T> implements Comparator<T> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Comparator f16225a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Comparator f16226b;

        n(Comparator comparator, Comparator comparator2) {
            this.f16225a = comparator;
            this.f16226b = comparator2;
        }

        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            int iCompare = this.f16225a.compare(t, t2);
            return iCompare != 0 ? iCompare : this.f16226b.compare(t2, t);
        }
    }

    public static final <T> int b(T t, T t2, @i.c.a.d h.q2.s.l<? super T, ? extends Comparable<?>>... lVarArr) {
        i0.f(lVarArr, "selectors");
        if (lVarArr.length > 0) {
            return c(t, t2, lVarArr);
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T> int c(T t, T t2, h.q2.s.l<? super T, ? extends Comparable<?>>[] lVarArr) {
        for (h.q2.s.l<? super T, ? extends Comparable<?>> lVar : lVarArr) {
            int iA = a(lVar.invoke(t), lVar.invoke(t2));
            if (iA != 0) {
                return iA;
            }
        }
        return 0;
    }

    @h.m2.f
    private static final <T> Comparator<T> d(@i.c.a.d Comparator<T> comparator, h.q2.s.l<? super T, ? extends Comparable<?>> lVar) {
        return new k(comparator, lVar);
    }

    @h.m2.f
    private static final <T> int a(T t, T t2, h.q2.s.l<? super T, ? extends Comparable<?>> lVar) {
        return a(lVar.invoke(t), lVar.invoke(t2));
    }

    @i.c.a.d
    public static <T extends Comparable<? super T>> Comparator<T> d() {
        h.h2.f fVar = h.h2.f.f16228a;
        if (fVar != null) {
            return fVar;
        }
        throw new e1("null cannot be cast to non-null type kotlin.Comparator<T> /* = java.util.Comparator<T> */");
    }

    @h.m2.f
    private static final <T, K> int a(T t, T t2, Comparator<? super K> comparator, h.q2.s.l<? super T, ? extends K> lVar) {
        return comparator.compare(lVar.invoke(t), lVar.invoke(t2));
    }

    public static <T extends Comparable<?>> int a(@i.c.a.e T t, @i.c.a.e T t2) {
        if (t == t2) {
            return 0;
        }
        if (t == null) {
            return -1;
        }
        if (t2 == null) {
            return 1;
        }
        return t.compareTo(t2);
    }

    @h.m2.f
    private static final <T> Comparator<T> b(h.q2.s.l<? super T, ? extends Comparable<?>> lVar) {
        return new d(lVar);
    }

    @i.c.a.d
    public static final <T> Comparator<T> a(@i.c.a.d h.q2.s.l<? super T, ? extends Comparable<?>>... lVarArr) {
        i0.f(lVarArr, "selectors");
        if (lVarArr.length > 0) {
            return new a(lVarArr);
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    @h.m2.f
    private static final <T, K> Comparator<T> b(Comparator<? super K> comparator, h.q2.s.l<? super T, ? extends K> lVar) {
        return new e(comparator, lVar);
    }

    @h.m2.f
    private static final <T> Comparator<T> c(@i.c.a.d Comparator<T> comparator, h.q2.s.l<? super T, ? extends Comparable<?>> lVar) {
        return new i(comparator, lVar);
    }

    @h.m2.f
    private static final <T, K> Comparator<T> b(@i.c.a.d Comparator<T> comparator, Comparator<? super K> comparator2, h.q2.s.l<? super T, ? extends K> lVar) {
        return new l(comparator, comparator2, lVar);
    }

    @h.m2.f
    private static final <T extends Comparable<? super T>> Comparator<T> c() {
        return b(a());
    }

    @i.c.a.d
    public static final <T> Comparator<T> b(@i.c.a.d Comparator<T> comparator, @i.c.a.d Comparator<? super T> comparator2) {
        i0.f(comparator, "$this$thenDescending");
        i0.f(comparator2, "comparator");
        return new n(comparator, comparator2);
    }

    @i.c.a.d
    public static final <T> Comparator<T> c(@i.c.a.d Comparator<T> comparator) {
        i0.f(comparator, "$this$reversed");
        if (comparator instanceof h.h2.g) {
            return ((h.h2.g) comparator).a();
        }
        if (i0.a(comparator, h.h2.e.f16227a)) {
            h.h2.f fVar = h.h2.f.f16228a;
            if (fVar != null) {
                return fVar;
            }
            throw new e1("null cannot be cast to non-null type kotlin.Comparator<T> /* = java.util.Comparator<T> */");
        }
        if (!i0.a(comparator, h.h2.f.f16228a)) {
            return new h.h2.g(comparator);
        }
        h.h2.e eVar = h.h2.e.f16227a;
        if (eVar != null) {
            return eVar;
        }
        throw new e1("null cannot be cast to non-null type kotlin.Comparator<T> /* = java.util.Comparator<T> */");
    }

    @h.m2.f
    private static final <T> Comparator<T> a(h.q2.s.l<? super T, ? extends Comparable<?>> lVar) {
        return new C0239b(lVar);
    }

    @h.m2.f
    private static final <T extends Comparable<? super T>> Comparator<T> b() {
        return a(a());
    }

    @h.m2.f
    private static final <T, K> Comparator<T> a(Comparator<? super K> comparator, h.q2.s.l<? super T, ? extends K> lVar) {
        return new c(comparator, lVar);
    }

    @i.c.a.d
    public static final <T> Comparator<T> b(@i.c.a.d Comparator<? super T> comparator) {
        i0.f(comparator, "comparator");
        return new g(comparator);
    }

    @h.m2.f
    private static final <T, K> Comparator<T> a(@i.c.a.d Comparator<T> comparator, Comparator<? super K> comparator2, h.q2.s.l<? super T, ? extends K> lVar) {
        return new j(comparator, comparator2, lVar);
    }

    @h.m2.f
    private static final <T> Comparator<T> a(@i.c.a.d Comparator<T> comparator, p<? super T, ? super T, Integer> pVar) {
        return new m(comparator, pVar);
    }

    @i.c.a.d
    public static final <T> Comparator<T> a(@i.c.a.d Comparator<T> comparator, @i.c.a.d Comparator<? super T> comparator2) {
        i0.f(comparator, "$this$then");
        i0.f(comparator2, "comparator");
        return new h(comparator, comparator2);
    }

    @i.c.a.d
    public static final <T> Comparator<T> a(@i.c.a.d Comparator<? super T> comparator) {
        i0.f(comparator, "comparator");
        return new f(comparator);
    }

    @i.c.a.d
    public static final <T extends Comparable<? super T>> Comparator<T> a() {
        h.h2.e eVar = h.h2.e.f16227a;
        if (eVar != null) {
            return eVar;
        }
        throw new e1("null cannot be cast to non-null type kotlin.Comparator<T> /* = java.util.Comparator<T> */");
    }
}
