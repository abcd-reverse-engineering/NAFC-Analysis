package androidx.core.util;

import android.util.LruCache;
import androidx.exifinterface.media.ExifInterface;
import bean.SurveyH5Bean;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import h.q2.s.l;
import h.q2.s.p;
import h.q2.s.r;
import h.q2.t.i0;
import h.q2.t.j0;
import h.y;
import h.y1;
import i.c.a.d;
import i.c.a.e;

/* compiled from: LruCache.kt */
@y(bv = {1, 0, 2}, d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\u001aø\u0001\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0004\"\b\b\u0001\u0010\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u000628\b\u0006\u0010\u0007\u001a2\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u0011H\u0003¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u00060\b2%\b\u0006\u0010\r\u001a\u001f\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0006\u0012\u0004\u0018\u0001H\u00030\u000e2d\b\u0006\u0010\u000f\u001a^\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u0011H\u0003¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0013\u0012\u0015\u0012\u0013\u0018\u0001H\u0003¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u00150\u0010H\u0086\b¨\u0006\u0016"}, d2 = {"lruCache", "Landroid/util/LruCache;", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "", "maxSize", "", "sizeOf", "Lkotlin/Function2;", "Lkotlin/ParameterName;", CommonNetImpl.NAME, "key", SurveyH5Bean.VALUE, "create", "Lkotlin/Function1;", "onEntryRemoved", "Lkotlin/Function4;", "", "evicted", "oldValue", "newValue", "", "core-ktx_release"}, k = 2, mv = {1, 1, 10})
/* loaded from: classes.dex */
public final class LruCacheKt {

    /* JADX INFO: Add missing generic type declarations: [V, K] */
    /* compiled from: LruCache.kt */
    @y(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u00032\u0006\u0010\u0005\u001a\u0002H\u00022\u0006\u0010\u0006\u001a\u0002H\u0004H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"<anonymous>", "", "K", "", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "<anonymous parameter 0>", "<anonymous parameter 1>", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)I"}, k = 3, mv = {1, 1, 10})
    /* renamed from: androidx.core.util.LruCacheKt$lruCache$1, reason: invalid class name */
    public static final class AnonymousClass1<K, V> extends j0 implements p<K, V, Integer> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(2);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final int invoke2(@d K k2, @d V v) {
            i0.f(k2, "<anonymous parameter 0>");
            i0.f(v, "<anonymous parameter 1>");
            return 1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // h.q2.s.p
        public /* bridge */ /* synthetic */ Integer invoke(Object obj, Object obj2) {
            return Integer.valueOf(invoke2((AnonymousClass1<K, V>) obj, obj2));
        }
    }

    /* JADX INFO: Add missing generic type declarations: [V, K] */
    /* compiled from: LruCache.kt */
    @y(bv = {1, 0, 2}, d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "K", "", "it", "invoke", "(Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 1, 10})
    /* renamed from: androidx.core.util.LruCacheKt$lruCache$2, reason: invalid class name */
    public static final class AnonymousClass2<K, V> extends j0 implements l<K, V> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        public AnonymousClass2() {
            super(1);
        }

        @Override // h.q2.s.l
        @e
        public final V invoke(@d K k2) {
            i0.f(k2, "it");
            return null;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [V, K] */
    /* compiled from: LruCache.kt */
    @y(bv = {1, 0, 2}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u0002H\u00022\u0006\u0010\b\u001a\u0002H\u00042\b\u0010\t\u001a\u0004\u0018\u0001H\u0004H\n¢\u0006\u0004\b\n\u0010\u000b"}, d2 = {"<anonymous>", "", "K", "", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "<anonymous parameter 0>", "", "<anonymous parameter 1>", "<anonymous parameter 2>", "<anonymous parameter 3>", "invoke", "(ZLjava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V"}, k = 3, mv = {1, 1, 10})
    /* renamed from: androidx.core.util.LruCacheKt$lruCache$3, reason: invalid class name */
    public static final class AnonymousClass3<K, V> extends j0 implements r<Boolean, K, V, V, y1> {
        public static final AnonymousClass3 INSTANCE = new AnonymousClass3();

        public AnonymousClass3() {
            super(4);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // h.q2.s.r
        public /* bridge */ /* synthetic */ y1 invoke(Boolean bool, Object obj, Object obj2, Object obj3) {
            invoke(bool.booleanValue(), (boolean) obj, obj2, obj3);
            return y1.f16671a;
        }

        public final void invoke(boolean z, @d K k2, @d V v, @e V v2) {
            i0.f(k2, "<anonymous parameter 1>");
            i0.f(v, "<anonymous parameter 2>");
        }
    }

    /* JADX INFO: Add missing generic type declarations: [V, K] */
    /* compiled from: LruCache.kt */
    @y(bv = {1, 0, 2}, d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0017\u0010\u0003\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0004\u001a\u00028\u0000H\u0014¢\u0006\u0002\u0010\u0005J/\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00028\u00002\u0006\u0010\n\u001a\u00028\u00012\b\u0010\u000b\u001a\u0004\u0018\u00018\u0001H\u0014¢\u0006\u0002\u0010\fJ\u001d\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00028\u00002\u0006\u0010\u000f\u001a\u00028\u0001H\u0014¢\u0006\u0002\u0010\u0010¨\u0006\u0011"}, d2 = {"androidx/core/util/LruCacheKt$lruCache$4", "Landroid/util/LruCache;", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;II)V", "create", "key", "(Ljava/lang/Object;)Ljava/lang/Object;", "entryRemoved", "", "evicted", "", "oldValue", "newValue", "(ZLjava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V", "sizeOf", "", SurveyH5Bean.VALUE, "(Ljava/lang/Object;Ljava/lang/Object;)I", "core-ktx_release"}, k = 1, mv = {1, 1, 10})
    /* renamed from: androidx.core.util.LruCacheKt$lruCache$4, reason: invalid class name */
    public static final class AnonymousClass4<K, V> extends LruCache<K, V> {
        final /* synthetic */ l $create;
        final /* synthetic */ int $maxSize;
        final /* synthetic */ r $onEntryRemoved;
        final /* synthetic */ p $sizeOf;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass4(p pVar, l lVar, r rVar, int i2, int i3) {
            super(i3);
            this.$sizeOf = pVar;
            this.$create = lVar;
            this.$onEntryRemoved = rVar;
            this.$maxSize = i2;
        }

        @Override // android.util.LruCache
        @e
        protected V create(@d K k2) {
            i0.f(k2, "key");
            return (V) this.$create.invoke(k2);
        }

        @Override // android.util.LruCache
        protected void entryRemoved(boolean z, @d K k2, @d V v, @e V v2) {
            i0.f(k2, "key");
            i0.f(v, "oldValue");
            this.$onEntryRemoved.invoke(Boolean.valueOf(z), k2, v, v2);
        }

        @Override // android.util.LruCache
        protected int sizeOf(@d K k2, @d V v) {
            i0.f(k2, "key");
            i0.f(v, SurveyH5Bean.VALUE);
            return ((Number) this.$sizeOf.invoke(k2, v)).intValue();
        }
    }

    @d
    public static final <K, V> LruCache<K, V> lruCache(int i2, @d p<? super K, ? super V, Integer> pVar, @d l<? super K, ? extends V> lVar, @d r<? super Boolean, ? super K, ? super V, ? super V, y1> rVar) {
        i0.f(pVar, "sizeOf");
        i0.f(lVar, "create");
        i0.f(rVar, "onEntryRemoved");
        return new AnonymousClass4(pVar, lVar, rVar, i2, i2);
    }

    @d
    public static /* bridge */ /* synthetic */ LruCache lruCache$default(int i2, p pVar, l lVar, r rVar, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            pVar = AnonymousClass1.INSTANCE;
        }
        p pVar2 = pVar;
        if ((i3 & 4) != 0) {
            lVar = AnonymousClass2.INSTANCE;
        }
        l lVar2 = lVar;
        if ((i3 & 8) != 0) {
            rVar = AnonymousClass3.INSTANCE;
        }
        r rVar2 = rVar;
        i0.f(pVar2, "sizeOf");
        i0.f(lVar2, "create");
        i0.f(rVar2, "onEntryRemoved");
        return new AnonymousClass4(pVar2, lVar2, rVar2, i2, i2);
    }
}
