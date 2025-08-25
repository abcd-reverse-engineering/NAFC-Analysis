package h.k2.l;

import androidx.exifinterface.media.ExifInterface;
import h.q2.s.p;
import h.q2.t.i0;
import h.t0;
import h.y;
import h.y1;
import java.util.Iterator;

/* compiled from: SequenceBuilder.kt */
@y(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aM\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\n0\t\"\u0004\b\u0000\u0010\n2/\b\u0001\u0010\u000b\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\n0\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u00100\f¢\u0006\u0002\b\u0011H\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u0012\u001aM\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\n0\u0014\"\u0004\b\u0000\u0010\n2/\b\u0001\u0010\u000b\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\n0\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u00100\f¢\u0006\u0002\b\u0011H\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u0015\"\u0012\u0010\u0000\u001a\u00060\u0001j\u0002`\u0002X\u0082T¢\u0006\u0002\n\u0000\"\u0012\u0010\u0003\u001a\u00060\u0001j\u0002`\u0002X\u0082T¢\u0006\u0002\n\u0000\"\u0012\u0010\u0004\u001a\u00060\u0001j\u0002`\u0002X\u0082T¢\u0006\u0002\n\u0000\"\u0012\u0010\u0005\u001a\u00060\u0001j\u0002`\u0002X\u0082T¢\u0006\u0002\n\u0000\"\u0012\u0010\u0006\u001a\u00060\u0001j\u0002`\u0002X\u0082T¢\u0006\u0002\n\u0000\"\u0012\u0010\u0007\u001a\u00060\u0001j\u0002`\u0002X\u0082T¢\u0006\u0002\n\u0000*\f\b\u0002\u0010\u0016\"\u00020\u00012\u00020\u0001\u0082\u0002\u0004\n\u0002\b\t¨\u0006\u0017"}, d2 = {"State_Done", "", "Lkotlin/coroutines/experimental/State;", "State_Failed", "State_ManyNotReady", "State_ManyReady", "State_NotReady", "State_Ready", "buildIterator", "", ExifInterface.GPS_DIRECTION_TRUE, "builderAction", "Lkotlin/Function2;", "Lkotlin/coroutines/experimental/SequenceBuilder;", "Lkotlin/coroutines/experimental/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function2;)Ljava/util/Iterator;", "buildSequence", "Lkotlin/sequences/Sequence;", "(Lkotlin/jvm/functions/Function2;)Lkotlin/sequences/Sequence;", "State", "kotlin-stdlib-coroutines"}, k = 5, mv = {1, 1, 16}, xi = 1, xs = "kotlin/coroutines/experimental/SequenceBuilderKt")
/* loaded from: classes2.dex */
class m {

    /* renamed from: a, reason: collision with root package name */
    private static final int f16269a = 0;

    /* renamed from: b, reason: collision with root package name */
    private static final int f16270b = 1;

    /* renamed from: c, reason: collision with root package name */
    private static final int f16271c = 2;

    /* renamed from: d, reason: collision with root package name */
    private static final int f16272d = 3;

    /* renamed from: e, reason: collision with root package name */
    private static final int f16273e = 4;

    /* renamed from: f, reason: collision with root package name */
    private static final int f16274f = 5;

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: Sequences.kt */
    public static final class a<T> implements h.x2.m<T> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ p f16275a;

        public a(p pVar) {
            this.f16275a = pVar;
        }

        @Override // h.x2.m
        @i.c.a.d
        public Iterator<T> iterator() {
            return m.a(this.f16275a);
        }
    }

    @t0(version = "1.1")
    @i.c.a.d
    public static final <T> Iterator<T> a(@h.b @i.c.a.d p<? super j<? super T>, ? super c<? super y1>, ? extends Object> pVar) {
        i0.f(pVar, "builderAction");
        k kVar = new k();
        kVar.a(h.k2.l.n.b.a(pVar, kVar, kVar));
        return kVar;
    }

    @t0(version = "1.1")
    @i.c.a.d
    public static final <T> h.x2.m<T> b(@h.b @i.c.a.d p<? super j<? super T>, ? super c<? super y1>, ? extends Object> pVar) {
        i0.f(pVar, "builderAction");
        return new a(pVar);
    }
}
