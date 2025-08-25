package androidx.core.util;

import android.util.LongSparseArray;
import androidx.annotation.RequiresApi;
import androidx.exifinterface.media.ExifInterface;
import anet.channel.strategy.dispatch.DispatchConstants;
import bean.SurveyH5Bean;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import h.g2.v0;
import h.q2.s.p;
import h.q2.t.i0;
import h.q2.t.q1.a;
import h.y;
import h.y1;
import i.c.a.d;
import java.util.Iterator;

/* compiled from: LongSparseArray.kt */
@y(bv = {1, 0, 2}, d1 = {"\u0000F\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010(\n\u0000\u001a!\u0010\u0006\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u0087\n\u001a!\u0010\n\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u0087\b\u001a&\u0010\u000b\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\f\u001a\u0002H\u0002H\u0087\b¢\u0006\u0002\u0010\r\u001aQ\u0010\u000e\u001a\u00020\u000f\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u000326\u0010\u0010\u001a2\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\b\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u000f0\u0011H\u0087\b\u001a.\u0010\u0014\u001a\u0002H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0015\u001a\u0002H\u0002H\u0087\b¢\u0006\u0002\u0010\u0016\u001a4\u0010\u0017\u001a\u0002H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0018H\u0087\b¢\u0006\u0002\u0010\u0019\u001a\u0019\u0010\u001a\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0087\b\u001a\u0019\u0010\u001b\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0087\b\u001a\u0018\u0010\u001c\u001a\u00020\u001d\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0007\u001a-\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0087\u0002\u001a&\u0010 \u001a\u00020\u000f\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0007\u001a-\u0010!\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u0002H\u0002H\u0007¢\u0006\u0002\u0010\"\u001a.\u0010#\u001a\u00020\u000f\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u0002H\u0002H\u0087\n¢\u0006\u0002\u0010$\u001a\u001e\u0010%\u001a\b\u0012\u0004\u0012\u0002H\u00020&\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0007\"\"\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00038Ç\u0002¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006'"}, d2 = {"size", "", ExifInterface.GPS_DIRECTION_TRUE, "Landroid/util/LongSparseArray;", "getSize", "(Landroid/util/LongSparseArray;)I", "contains", "", "key", "", "containsKey", "containsValue", SurveyH5Bean.VALUE, "(Landroid/util/LongSparseArray;Ljava/lang/Object;)Z", "forEach", "", "action", "Lkotlin/Function2;", "Lkotlin/ParameterName;", CommonNetImpl.NAME, "getOrDefault", "defaultValue", "(Landroid/util/LongSparseArray;JLjava/lang/Object;)Ljava/lang/Object;", "getOrElse", "Lkotlin/Function0;", "(Landroid/util/LongSparseArray;JLkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "isEmpty", "isNotEmpty", "keyIterator", "Lkotlin/collections/LongIterator;", "plus", DispatchConstants.OTHER, "putAll", "remove", "(Landroid/util/LongSparseArray;JLjava/lang/Object;)Z", "set", "(Landroid/util/LongSparseArray;JLjava/lang/Object;)V", "valueIterator", "", "core-ktx_release"}, k = 2, mv = {1, 1, 10})
/* loaded from: classes.dex */
public final class LongSparseArrayKt {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: LongSparseArray.kt */
    @y(bv = {1, 0, 2}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001B\u0005¢\u0006\u0002\u0010\u0002J\t\u0010\t\u001a\u00020\nH\u0096\u0002J\u0016\u0010\u000b\u001a\n \f*\u0004\u0018\u00018\u00008\u0000H\u0096\u0002¢\u0006\u0002\u0010\rR\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000e"}, d2 = {"androidx/core/util/LongSparseArrayKt$valueIterator$1", "", "(Landroid/util/LongSparseArray;)V", "index", "", "getIndex", "()I", "setIndex", "(I)V", "hasNext", "", "next", "kotlin.jvm.PlatformType", "()Ljava/lang/Object;", "core-ktx_release"}, k = 1, mv = {1, 1, 10})
    /* renamed from: androidx.core.util.LongSparseArrayKt$valueIterator$1, reason: invalid class name and case insensitive filesystem */
    public static final class C03321<T> implements Iterator<T>, a {
        private int index;
        final /* synthetic */ LongSparseArray receiver$0;

        C03321(LongSparseArray<T> longSparseArray) {
            this.receiver$0 = longSparseArray;
        }

        public final int getIndex() {
            return this.index;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.index < this.receiver$0.size();
        }

        @Override // java.util.Iterator
        public T next() {
            LongSparseArray longSparseArray = this.receiver$0;
            int i2 = this.index;
            this.index = i2 + 1;
            return (T) longSparseArray.valueAt(i2);
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public final void setIndex(int i2) {
            this.index = i2;
        }
    }

    @RequiresApi(16)
    public static final <T> boolean contains(@d LongSparseArray<T> longSparseArray, long j2) {
        i0.f(longSparseArray, "$receiver");
        return longSparseArray.indexOfKey(j2) >= 0;
    }

    @RequiresApi(16)
    public static final <T> boolean containsKey(@d LongSparseArray<T> longSparseArray, long j2) {
        i0.f(longSparseArray, "$receiver");
        return longSparseArray.indexOfKey(j2) >= 0;
    }

    @RequiresApi(16)
    public static final <T> boolean containsValue(@d LongSparseArray<T> longSparseArray, T t) {
        i0.f(longSparseArray, "$receiver");
        return longSparseArray.indexOfValue(t) != -1;
    }

    @RequiresApi(16)
    public static final <T> void forEach(@d LongSparseArray<T> longSparseArray, @d p<? super Long, ? super T, y1> pVar) {
        i0.f(longSparseArray, "$receiver");
        i0.f(pVar, "action");
        int size = longSparseArray.size();
        for (int i2 = 0; i2 < size; i2++) {
            pVar.invoke(Long.valueOf(longSparseArray.keyAt(i2)), longSparseArray.valueAt(i2));
        }
    }

    @RequiresApi(16)
    public static final <T> T getOrDefault(@d LongSparseArray<T> longSparseArray, long j2, T t) {
        i0.f(longSparseArray, "$receiver");
        T t2 = longSparseArray.get(j2);
        return t2 != null ? t2 : t;
    }

    @RequiresApi(16)
    public static final <T> T getOrElse(@d LongSparseArray<T> longSparseArray, long j2, @d h.q2.s.a<? extends T> aVar) {
        i0.f(longSparseArray, "$receiver");
        i0.f(aVar, "defaultValue");
        T t = longSparseArray.get(j2);
        return t != null ? t : aVar.invoke();
    }

    @RequiresApi(16)
    public static final <T> int getSize(@d LongSparseArray<T> longSparseArray) {
        i0.f(longSparseArray, "$receiver");
        return longSparseArray.size();
    }

    @RequiresApi(16)
    public static final <T> boolean isEmpty(@d LongSparseArray<T> longSparseArray) {
        i0.f(longSparseArray, "$receiver");
        return longSparseArray.size() == 0;
    }

    @RequiresApi(16)
    public static final <T> boolean isNotEmpty(@d LongSparseArray<T> longSparseArray) {
        i0.f(longSparseArray, "$receiver");
        return longSparseArray.size() != 0;
    }

    @RequiresApi(16)
    @d
    public static final <T> v0 keyIterator(@d final LongSparseArray<T> longSparseArray) {
        i0.f(longSparseArray, "$receiver");
        return new v0() { // from class: androidx.core.util.LongSparseArrayKt.keyIterator.1
            private int index;

            public final int getIndex() {
                return this.index;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.index < longSparseArray.size();
            }

            @Override // h.g2.v0
            public long nextLong() {
                LongSparseArray longSparseArray2 = longSparseArray;
                int i2 = this.index;
                this.index = i2 + 1;
                return longSparseArray2.keyAt(i2);
            }

            public final void setIndex(int i2) {
                this.index = i2;
            }
        };
    }

    @RequiresApi(16)
    @d
    public static final <T> LongSparseArray<T> plus(@d LongSparseArray<T> longSparseArray, @d LongSparseArray<T> longSparseArray2) {
        i0.f(longSparseArray, "$receiver");
        i0.f(longSparseArray2, DispatchConstants.OTHER);
        LongSparseArray<T> longSparseArray3 = new LongSparseArray<>(longSparseArray.size() + longSparseArray2.size());
        putAll(longSparseArray3, longSparseArray);
        putAll(longSparseArray3, longSparseArray2);
        return longSparseArray3;
    }

    @RequiresApi(16)
    public static final <T> void putAll(@d LongSparseArray<T> longSparseArray, @d LongSparseArray<T> longSparseArray2) {
        i0.f(longSparseArray, "$receiver");
        i0.f(longSparseArray2, DispatchConstants.OTHER);
        int size = longSparseArray2.size();
        for (int i2 = 0; i2 < size; i2++) {
            longSparseArray.put(longSparseArray2.keyAt(i2), longSparseArray2.valueAt(i2));
        }
    }

    @RequiresApi(16)
    public static final <T> boolean remove(@d LongSparseArray<T> longSparseArray, long j2, T t) {
        i0.f(longSparseArray, "$receiver");
        int iIndexOfKey = longSparseArray.indexOfKey(j2);
        if (iIndexOfKey == -1 || !i0.a(t, longSparseArray.valueAt(iIndexOfKey))) {
            return false;
        }
        longSparseArray.removeAt(iIndexOfKey);
        return true;
    }

    @RequiresApi(16)
    public static final <T> void set(@d LongSparseArray<T> longSparseArray, long j2, T t) {
        i0.f(longSparseArray, "$receiver");
        longSparseArray.put(j2, t);
    }

    @RequiresApi(16)
    @d
    public static final <T> Iterator<T> valueIterator(@d LongSparseArray<T> longSparseArray) {
        i0.f(longSparseArray, "$receiver");
        return new C03321(longSparseArray);
    }
}
