package androidx.core.util;

import android.util.SparseIntArray;
import anet.channel.strategy.dispatch.DispatchConstants;
import bean.SurveyH5Bean;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import h.g2.u0;
import h.q2.s.a;
import h.q2.s.p;
import h.q2.t.i0;
import h.y;
import h.y1;
import i.c.a.d;

/* compiled from: SparseIntArray.kt */
@y(bv = {1, 0, 2}, d1 = {"\u00008\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u0015\u0010\u0005\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0001H\u0086\n\u001a\u0015\u0010\b\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0001H\u0086\b\u001a\u0015\u0010\t\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\n\u001a\u00020\u0001H\u0086\b\u001aE\u0010\u000b\u001a\u00020\f*\u00020\u000226\u0010\r\u001a2\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\f0\u000eH\u0086\b\u001a\u001d\u0010\u0011\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u0001H\u0086\b\u001a#\u0010\u0013\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00010\u0014H\u0086\b\u001a\r\u0010\u0015\u001a\u00020\u0006*\u00020\u0002H\u0086\b\u001a\r\u0010\u0016\u001a\u00020\u0006*\u00020\u0002H\u0086\b\u001a\n\u0010\u0017\u001a\u00020\u0018*\u00020\u0002\u001a\u0015\u0010\u0019\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0002H\u0086\u0002\u001a\u0012\u0010\u001b\u001a\u00020\f*\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0002\u001a\u001a\u0010\u001c\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u0001\u001a\u001d\u0010\u001d\u001a\u00020\f*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u0001H\u0086\n\u001a\n\u0010\u001e\u001a\u00020\u0018*\u00020\u0002\"\u0016\u0010\u0000\u001a\u00020\u0001*\u00020\u00028Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u001f"}, d2 = {"size", "", "Landroid/util/SparseIntArray;", "getSize", "(Landroid/util/SparseIntArray;)I", "contains", "", "key", "containsKey", "containsValue", SurveyH5Bean.VALUE, "forEach", "", "action", "Lkotlin/Function2;", "Lkotlin/ParameterName;", CommonNetImpl.NAME, "getOrDefault", "defaultValue", "getOrElse", "Lkotlin/Function0;", "isEmpty", "isNotEmpty", "keyIterator", "Lkotlin/collections/IntIterator;", "plus", DispatchConstants.OTHER, "putAll", "remove", "set", "valueIterator", "core-ktx_release"}, k = 2, mv = {1, 1, 10})
/* loaded from: classes.dex */
public final class SparseIntArrayKt {
    public static final boolean contains(@d SparseIntArray sparseIntArray, int i2) {
        i0.f(sparseIntArray, "$receiver");
        return sparseIntArray.indexOfKey(i2) >= 0;
    }

    public static final boolean containsKey(@d SparseIntArray sparseIntArray, int i2) {
        i0.f(sparseIntArray, "$receiver");
        return sparseIntArray.indexOfKey(i2) >= 0;
    }

    public static final boolean containsValue(@d SparseIntArray sparseIntArray, int i2) {
        i0.f(sparseIntArray, "$receiver");
        return sparseIntArray.indexOfValue(i2) != -1;
    }

    public static final void forEach(@d SparseIntArray sparseIntArray, @d p<? super Integer, ? super Integer, y1> pVar) {
        i0.f(sparseIntArray, "$receiver");
        i0.f(pVar, "action");
        int size = sparseIntArray.size();
        for (int i2 = 0; i2 < size; i2++) {
            pVar.invoke(Integer.valueOf(sparseIntArray.keyAt(i2)), Integer.valueOf(sparseIntArray.valueAt(i2)));
        }
    }

    public static final int getOrDefault(@d SparseIntArray sparseIntArray, int i2, int i3) {
        i0.f(sparseIntArray, "$receiver");
        return sparseIntArray.get(i2, i3);
    }

    public static final int getOrElse(@d SparseIntArray sparseIntArray, int i2, @d a<Integer> aVar) {
        i0.f(sparseIntArray, "$receiver");
        i0.f(aVar, "defaultValue");
        int iIndexOfKey = sparseIntArray.indexOfKey(i2);
        return iIndexOfKey != -1 ? sparseIntArray.valueAt(iIndexOfKey) : aVar.invoke().intValue();
    }

    public static final int getSize(@d SparseIntArray sparseIntArray) {
        i0.f(sparseIntArray, "$receiver");
        return sparseIntArray.size();
    }

    public static final boolean isEmpty(@d SparseIntArray sparseIntArray) {
        i0.f(sparseIntArray, "$receiver");
        return sparseIntArray.size() == 0;
    }

    public static final boolean isNotEmpty(@d SparseIntArray sparseIntArray) {
        i0.f(sparseIntArray, "$receiver");
        return sparseIntArray.size() != 0;
    }

    @d
    public static final u0 keyIterator(@d final SparseIntArray sparseIntArray) {
        i0.f(sparseIntArray, "$receiver");
        return new u0() { // from class: androidx.core.util.SparseIntArrayKt.keyIterator.1
            private int index;

            public final int getIndex() {
                return this.index;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.index < sparseIntArray.size();
            }

            @Override // h.g2.u0
            public int nextInt() {
                SparseIntArray sparseIntArray2 = sparseIntArray;
                int i2 = this.index;
                this.index = i2 + 1;
                return sparseIntArray2.keyAt(i2);
            }

            public final void setIndex(int i2) {
                this.index = i2;
            }
        };
    }

    @d
    public static final SparseIntArray plus(@d SparseIntArray sparseIntArray, @d SparseIntArray sparseIntArray2) {
        i0.f(sparseIntArray, "$receiver");
        i0.f(sparseIntArray2, DispatchConstants.OTHER);
        SparseIntArray sparseIntArray3 = new SparseIntArray(sparseIntArray.size() + sparseIntArray2.size());
        putAll(sparseIntArray3, sparseIntArray);
        putAll(sparseIntArray3, sparseIntArray2);
        return sparseIntArray3;
    }

    public static final void putAll(@d SparseIntArray sparseIntArray, @d SparseIntArray sparseIntArray2) {
        i0.f(sparseIntArray, "$receiver");
        i0.f(sparseIntArray2, DispatchConstants.OTHER);
        int size = sparseIntArray2.size();
        for (int i2 = 0; i2 < size; i2++) {
            sparseIntArray.put(sparseIntArray2.keyAt(i2), sparseIntArray2.valueAt(i2));
        }
    }

    public static final boolean remove(@d SparseIntArray sparseIntArray, int i2, int i3) {
        i0.f(sparseIntArray, "$receiver");
        int iIndexOfKey = sparseIntArray.indexOfKey(i2);
        if (iIndexOfKey == -1 || i3 != sparseIntArray.valueAt(iIndexOfKey)) {
            return false;
        }
        sparseIntArray.removeAt(iIndexOfKey);
        return true;
    }

    public static final void set(@d SparseIntArray sparseIntArray, int i2, int i3) {
        i0.f(sparseIntArray, "$receiver");
        sparseIntArray.put(i2, i3);
    }

    @d
    public static final u0 valueIterator(@d final SparseIntArray sparseIntArray) {
        i0.f(sparseIntArray, "$receiver");
        return new u0() { // from class: androidx.core.util.SparseIntArrayKt.valueIterator.1
            private int index;

            public final int getIndex() {
                return this.index;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.index < sparseIntArray.size();
            }

            @Override // h.g2.u0
            public int nextInt() {
                SparseIntArray sparseIntArray2 = sparseIntArray;
                int i2 = this.index;
                this.index = i2 + 1;
                return sparseIntArray2.valueAt(i2);
            }

            public final void setIndex(int i2) {
                this.index = i2;
            }
        };
    }
}
