package h.x2;

import androidx.exifinterface.media.ExifInterface;
import h.o0;
import h.q2.t.i0;
import h.t0;
import h.y1;
import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SequenceBuilder.kt */
@h.y(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aN\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\n0\t\"\u0004\b\u0000\u0010\n2/\b\t\u0010\u000b\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\n0\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u00100\f¢\u0006\u0002\b\u0011H\u0087\bø\u0001\u0000¢\u0006\u0002\u0010\u0012\u001aN\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\n0\u0014\"\u0004\b\u0000\u0010\n2/\b\t\u0010\u000b\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\n0\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u00100\f¢\u0006\u0002\b\u0011H\u0087\bø\u0001\u0000¢\u0006\u0002\u0010\u0015\u001aM\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\n0\t\"\u0004\b\u0000\u0010\n2/\b\u0001\u0010\u0017\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\n0\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u00100\f¢\u0006\u0002\b\u0011H\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u0012\u001aM\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\n0\u0014\"\u0004\b\u0000\u0010\n2/\b\u0001\u0010\u0017\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\n0\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u00100\f¢\u0006\u0002\b\u0011H\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u0015\"\u0012\u0010\u0000\u001a\u00060\u0001j\u0002`\u0002X\u0082T¢\u0006\u0002\n\u0000\"\u0012\u0010\u0003\u001a\u00060\u0001j\u0002`\u0002X\u0082T¢\u0006\u0002\n\u0000\"\u0012\u0010\u0004\u001a\u00060\u0001j\u0002`\u0002X\u0082T¢\u0006\u0002\n\u0000\"\u0012\u0010\u0005\u001a\u00060\u0001j\u0002`\u0002X\u0082T¢\u0006\u0002\n\u0000\"\u0012\u0010\u0006\u001a\u00060\u0001j\u0002`\u0002X\u0082T¢\u0006\u0002\n\u0000\"\u0012\u0010\u0007\u001a\u00060\u0001j\u0002`\u0002X\u0082T¢\u0006\u0002\n\u0000*V\b\u0007\u0010\u0019\u001a\u0004\b\u0000\u0010\n\"\b\u0012\u0004\u0012\u0002H\n0\r2\b\u0012\u0004\u0012\u0002H\n0\rB6\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u001c\b\u001d\u0012\u0018\b\u000bB\u0014\b\u001e\u0012\u0006\b\u001f\u0012\u0002\b\f\u0012\b\b \u0012\u0004\b\b(!\u0012\n\b\"\u0012\u0006\b\n0#8$*\f\b\u0002\u0010%\"\u00020\u00012\u00020\u0001\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006&"}, d2 = {"State_Done", "", "Lkotlin/sequences/State;", "State_Failed", "State_ManyNotReady", "State_ManyReady", "State_NotReady", "State_Ready", "buildIterator", "", ExifInterface.GPS_DIRECTION_TRUE, "builderAction", "Lkotlin/Function2;", "Lkotlin/sequences/SequenceScope;", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function2;)Ljava/util/Iterator;", "buildSequence", "Lkotlin/sequences/Sequence;", "(Lkotlin/jvm/functions/Function2;)Lkotlin/sequences/Sequence;", "iterator", "block", "sequence", "SequenceBuilder", "Lkotlin/Deprecated;", "message", "Use SequenceScope class instead.", "replaceWith", "Lkotlin/ReplaceWith;", "imports", "expression", "SequenceScope<T>", "level", "Lkotlin/DeprecationLevel;", "ERROR", "State", "kotlin-stdlib"}, k = 5, mv = {1, 1, 16}, xi = 1, xs = "kotlin/sequences/SequencesKt")
/* loaded from: classes2.dex */
public class q {

    /* renamed from: a, reason: collision with root package name */
    private static final int f16621a = 0;

    /* renamed from: b, reason: collision with root package name */
    private static final int f16622b = 1;

    /* renamed from: c, reason: collision with root package name */
    private static final int f16623c = 2;

    /* renamed from: d, reason: collision with root package name */
    private static final int f16624d = 3;

    /* renamed from: e, reason: collision with root package name */
    private static final int f16625e = 4;

    /* renamed from: f, reason: collision with root package name */
    private static final int f16626f = 5;

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: Sequences.kt */
    public static final class a<T> implements m<T> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ h.q2.s.p f16627a;

        public a(h.q2.s.p pVar) {
            this.f16627a = pVar;
        }

        @Override // h.x2.m
        @i.c.a.d
        public Iterator<T> iterator() {
            return q.c(this.f16627a);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: Sequences.kt */
    public static final class b<T> implements m<T> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ h.q2.s.p f16628a;

        public b(h.q2.s.p pVar) {
            this.f16628a = pVar;
        }

        @Override // h.x2.m
        @i.c.a.d
        public Iterator<T> iterator() {
            return q.c(this.f16628a);
        }
    }

    @h.m2.f
    @t0(version = "1.3")
    @h.c(level = h.d.ERROR, message = "Use 'iterator { }' function instead.", replaceWith = @o0(expression = "iterator(builderAction)", imports = {}))
    private static final <T> Iterator<T> a(@h.b h.q2.s.p<? super o<? super T>, ? super h.k2.d<? super y1>, ? extends Object> pVar) {
        return c(pVar);
    }

    @h.c(level = h.d.ERROR, message = "Use SequenceScope class instead.", replaceWith = @o0(expression = "SequenceScope<T>", imports = {}))
    public static /* synthetic */ void a() {
    }

    @h.m2.f
    @t0(version = "1.3")
    @h.c(level = h.d.ERROR, message = "Use 'sequence { }' function instead.", replaceWith = @o0(expression = "sequence(builderAction)", imports = {}))
    private static final <T> m<T> b(@h.b h.q2.s.p<? super o<? super T>, ? super h.k2.d<? super y1>, ? extends Object> pVar) {
        return new a(pVar);
    }

    @t0(version = "1.3")
    @i.c.a.d
    public static <T> Iterator<T> c(@h.b @i.c.a.d h.q2.s.p<? super o<? super T>, ? super h.k2.d<? super y1>, ? extends Object> pVar) {
        i0.f(pVar, "block");
        n nVar = new n();
        nVar.a(h.k2.m.c.a(pVar, nVar, nVar));
        return nVar;
    }

    @t0(version = "1.3")
    @i.c.a.d
    public static final <T> m<T> d(@h.b @i.c.a.d h.q2.s.p<? super o<? super T>, ? super h.k2.d<? super y1>, ? extends Object> pVar) {
        i0.f(pVar, "block");
        return new b(pVar);
    }
}
