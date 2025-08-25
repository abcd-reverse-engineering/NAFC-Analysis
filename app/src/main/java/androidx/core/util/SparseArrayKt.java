package androidx.core.util;

import android.util.SparseArray;
import androidx.exifinterface.media.ExifInterface;
import anet.channel.strategy.dispatch.DispatchConstants;
import bean.SurveyH5Bean;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import h.g2.u0;
import h.q2.s.p;
import h.q2.t.i0;
import h.q2.t.q1.a;
import h.y;
import h.y1;
import i.c.a.d;
import java.util.Iterator;

/* compiled from: SparseArray.kt */
@y(bv = {1, 0, 2}, d1 = {"\u0000@\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010(\n\u0000\u001a!\u0010\u0006\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\b\u001a\u00020\u0001H\u0086\n\u001a!\u0010\t\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\b\u001a\u00020\u0001H\u0086\b\u001a&\u0010\n\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u000b\u001a\u0002H\u0002H\u0086\b¢\u0006\u0002\u0010\f\u001aQ\u0010\r\u001a\u00020\u000e\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u000326\u0010\u000f\u001a2\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\b\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u000e0\u0010H\u0086\b\u001a.\u0010\u0013\u001a\u0002H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\b\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u0002H\u0002H\u0086\b¢\u0006\u0002\u0010\u0015\u001a4\u0010\u0016\u001a\u0002H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\b\u001a\u00020\u00012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0017H\u0086\b¢\u0006\u0002\u0010\u0018\u001a\u0019\u0010\u0019\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0086\b\u001a\u0019\u0010\u001a\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0086\b\u001a\u0016\u0010\u001b\u001a\u00020\u001c\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003\u001a-\u0010\u001d\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0086\u0002\u001a$\u0010\u001f\u001a\u00020\u000e\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003\u001a+\u0010 \u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\b\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u0002H\u0002¢\u0006\u0002\u0010!\u001a.\u0010\"\u001a\u00020\u000e\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\b\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u0002H\u0002H\u0086\n¢\u0006\u0002\u0010#\u001a\u001c\u0010$\u001a\b\u0012\u0004\u0012\u0002H\u00020%\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003\"\"\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00038Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006&"}, d2 = {"size", "", ExifInterface.GPS_DIRECTION_TRUE, "Landroid/util/SparseArray;", "getSize", "(Landroid/util/SparseArray;)I", "contains", "", "key", "containsKey", "containsValue", SurveyH5Bean.VALUE, "(Landroid/util/SparseArray;Ljava/lang/Object;)Z", "forEach", "", "action", "Lkotlin/Function2;", "Lkotlin/ParameterName;", CommonNetImpl.NAME, "getOrDefault", "defaultValue", "(Landroid/util/SparseArray;ILjava/lang/Object;)Ljava/lang/Object;", "getOrElse", "Lkotlin/Function0;", "(Landroid/util/SparseArray;ILkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "isEmpty", "isNotEmpty", "keyIterator", "Lkotlin/collections/IntIterator;", "plus", DispatchConstants.OTHER, "putAll", "remove", "(Landroid/util/SparseArray;ILjava/lang/Object;)Z", "set", "(Landroid/util/SparseArray;ILjava/lang/Object;)V", "valueIterator", "", "core-ktx_release"}, k = 2, mv = {1, 1, 10})
/* loaded from: classes.dex */
public final class SparseArrayKt {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: SparseArray.kt */
    @y(bv = {1, 0, 2}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001B\u0005¢\u0006\u0002\u0010\u0002J\t\u0010\t\u001a\u00020\nH\u0096\u0002J\u0016\u0010\u000b\u001a\n \f*\u0004\u0018\u00018\u00008\u0000H\u0096\u0002¢\u0006\u0002\u0010\rR\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000e"}, d2 = {"androidx/core/util/SparseArrayKt$valueIterator$1", "", "(Landroid/util/SparseArray;)V", "index", "", "getIndex", "()I", "setIndex", "(I)V", "hasNext", "", "next", "kotlin.jvm.PlatformType", "()Ljava/lang/Object;", "core-ktx_release"}, k = 1, mv = {1, 1, 10})
    /* renamed from: androidx.core.util.SparseArrayKt$valueIterator$1, reason: invalid class name and case insensitive filesystem */
    public static final class C03331<T> implements Iterator<T>, a {
        private int index;
        final /* synthetic */ SparseArray receiver$0;

        C03331(SparseArray<T> sparseArray) {
            this.receiver$0 = sparseArray;
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
            SparseArray sparseArray = this.receiver$0;
            int i2 = this.index;
            this.index = i2 + 1;
            return (T) sparseArray.valueAt(i2);
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public final void setIndex(int i2) {
            this.index = i2;
        }
    }

    public static final <T> boolean contains(@d SparseArray<T> sparseArray, int i2) {
        i0.f(sparseArray, "$receiver");
        return sparseArray.indexOfKey(i2) >= 0;
    }

    public static final <T> boolean containsKey(@d SparseArray<T> sparseArray, int i2) {
        i0.f(sparseArray, "$receiver");
        return sparseArray.indexOfKey(i2) >= 0;
    }

    public static final <T> boolean containsValue(@d SparseArray<T> sparseArray, T t) {
        i0.f(sparseArray, "$receiver");
        return sparseArray.indexOfValue(t) != -1;
    }

    public static final <T> void forEach(@d SparseArray<T> sparseArray, @d p<? super Integer, ? super T, y1> pVar) {
        i0.f(sparseArray, "$receiver");
        i0.f(pVar, "action");
        int size = sparseArray.size();
        for (int i2 = 0; i2 < size; i2++) {
            pVar.invoke(Integer.valueOf(sparseArray.keyAt(i2)), sparseArray.valueAt(i2));
        }
    }

    public static final <T> T getOrDefault(@d SparseArray<T> sparseArray, int i2, T t) {
        i0.f(sparseArray, "$receiver");
        T t2 = sparseArray.get(i2);
        return t2 != null ? t2 : t;
    }

    public static final <T> T getOrElse(@d SparseArray<T> sparseArray, int i2, @d h.q2.s.a<? extends T> aVar) {
        i0.f(sparseArray, "$receiver");
        i0.f(aVar, "defaultValue");
        T t = sparseArray.get(i2);
        return t != null ? t : aVar.invoke();
    }

    public static final <T> int getSize(@d SparseArray<T> sparseArray) {
        i0.f(sparseArray, "$receiver");
        return sparseArray.size();
    }

    public static final <T> boolean isEmpty(@d SparseArray<T> sparseArray) {
        i0.f(sparseArray, "$receiver");
        return sparseArray.size() == 0;
    }

    public static final <T> boolean isNotEmpty(@d SparseArray<T> sparseArray) {
        i0.f(sparseArray, "$receiver");
        return sparseArray.size() != 0;
    }

    @d
    public static final <T> u0 keyIterator(@d final SparseArray<T> sparseArray) {
        i0.f(sparseArray, "$receiver");
        return new u0() { // from class: androidx.core.util.SparseArrayKt.keyIterator.1
            private int index;

            public final int getIndex() {
                return this.index;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.index < sparseArray.size();
            }

            @Override // h.g2.u0
            public int nextInt() {
                SparseArray sparseArray2 = sparseArray;
                int i2 = this.index;
                this.index = i2 + 1;
                return sparseArray2.keyAt(i2);
            }

            public final void setIndex(int i2) {
                this.index = i2;
            }
        };
    }

    @d
    public static final <T> SparseArray<T> plus(@d SparseArray<T> sparseArray, @d SparseArray<T> sparseArray2) {
        i0.f(sparseArray, "$receiver");
        i0.f(sparseArray2, DispatchConstants.OTHER);
        SparseArray<T> sparseArray3 = new SparseArray<>(sparseArray.size() + sparseArray2.size());
        putAll(sparseArray3, sparseArray);
        putAll(sparseArray3, sparseArray2);
        return sparseArray3;
    }

    public static final <T> void putAll(@d SparseArray<T> sparseArray, @d SparseArray<T> sparseArray2) {
        i0.f(sparseArray, "$receiver");
        i0.f(sparseArray2, DispatchConstants.OTHER);
        int size = sparseArray2.size();
        for (int i2 = 0; i2 < size; i2++) {
            sparseArray.put(sparseArray2.keyAt(i2), sparseArray2.valueAt(i2));
        }
    }

    public static final <T> boolean remove(@d SparseArray<T> sparseArray, int i2, T t) {
        i0.f(sparseArray, "$receiver");
        int iIndexOfKey = sparseArray.indexOfKey(i2);
        if (iIndexOfKey == -1 || !i0.a(t, sparseArray.valueAt(iIndexOfKey))) {
            return false;
        }
        sparseArray.removeAt(iIndexOfKey);
        return true;
    }

    public static final <T> void set(@d SparseArray<T> sparseArray, int i2, T t) {
        i0.f(sparseArray, "$receiver");
        sparseArray.put(i2, t);
    }

    @d
    public static final <T> Iterator<T> valueIterator(@d SparseArray<T> sparseArray) {
        i0.f(sparseArray, "$receiver");
        return new C03331(sparseArray);
    }
}
