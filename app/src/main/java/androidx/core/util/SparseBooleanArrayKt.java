package androidx.core.util;

import android.util.SparseBooleanArray;
import anet.channel.strategy.dispatch.DispatchConstants;
import bean.SurveyH5Bean;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import h.g2.t;
import h.g2.u0;
import h.q2.s.a;
import h.q2.s.p;
import h.q2.t.i0;
import h.y;
import h.y1;
import i.c.a.d;

/* compiled from: SparseBooleanArray.kt */
@y(bv = {1, 0, 2}, d1 = {"\u0000>\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u001a\u0015\u0010\u0005\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0001H\u0086\n\u001a\u0015\u0010\b\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0001H\u0086\b\u001a\u0015\u0010\t\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\n\u001a\u00020\u0006H\u0086\b\u001aE\u0010\u000b\u001a\u00020\f*\u00020\u000226\u0010\r\u001a2\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\f0\u000eH\u0086\b\u001a\u001d\u0010\u0011\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u0006H\u0086\b\u001a#\u0010\u0013\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u0014H\u0086\b\u001a\r\u0010\u0015\u001a\u00020\u0006*\u00020\u0002H\u0086\b\u001a\r\u0010\u0016\u001a\u00020\u0006*\u00020\u0002H\u0086\b\u001a\n\u0010\u0017\u001a\u00020\u0018*\u00020\u0002\u001a\u0015\u0010\u0019\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0002H\u0086\u0002\u001a\u0012\u0010\u001b\u001a\u00020\f*\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0002\u001a\u001a\u0010\u001c\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u0006\u001a\u001d\u0010\u001d\u001a\u00020\f*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u0006H\u0086\n\u001a\n\u0010\u001e\u001a\u00020\u001f*\u00020\u0002\"\u0016\u0010\u0000\u001a\u00020\u0001*\u00020\u00028Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006 "}, d2 = {"size", "", "Landroid/util/SparseBooleanArray;", "getSize", "(Landroid/util/SparseBooleanArray;)I", "contains", "", "key", "containsKey", "containsValue", SurveyH5Bean.VALUE, "forEach", "", "action", "Lkotlin/Function2;", "Lkotlin/ParameterName;", CommonNetImpl.NAME, "getOrDefault", "defaultValue", "getOrElse", "Lkotlin/Function0;", "isEmpty", "isNotEmpty", "keyIterator", "Lkotlin/collections/IntIterator;", "plus", DispatchConstants.OTHER, "putAll", "remove", "set", "valueIterator", "Lkotlin/collections/BooleanIterator;", "core-ktx_release"}, k = 2, mv = {1, 1, 10})
/* loaded from: classes.dex */
public final class SparseBooleanArrayKt {
    public static final boolean contains(@d SparseBooleanArray sparseBooleanArray, int i2) {
        i0.f(sparseBooleanArray, "$receiver");
        return sparseBooleanArray.indexOfKey(i2) >= 0;
    }

    public static final boolean containsKey(@d SparseBooleanArray sparseBooleanArray, int i2) {
        i0.f(sparseBooleanArray, "$receiver");
        return sparseBooleanArray.indexOfKey(i2) >= 0;
    }

    public static final boolean containsValue(@d SparseBooleanArray sparseBooleanArray, boolean z) {
        i0.f(sparseBooleanArray, "$receiver");
        return sparseBooleanArray.indexOfValue(z) != -1;
    }

    public static final void forEach(@d SparseBooleanArray sparseBooleanArray, @d p<? super Integer, ? super Boolean, y1> pVar) {
        i0.f(sparseBooleanArray, "$receiver");
        i0.f(pVar, "action");
        int size = sparseBooleanArray.size();
        for (int i2 = 0; i2 < size; i2++) {
            pVar.invoke(Integer.valueOf(sparseBooleanArray.keyAt(i2)), Boolean.valueOf(sparseBooleanArray.valueAt(i2)));
        }
    }

    public static final boolean getOrDefault(@d SparseBooleanArray sparseBooleanArray, int i2, boolean z) {
        i0.f(sparseBooleanArray, "$receiver");
        return sparseBooleanArray.get(i2, z);
    }

    public static final boolean getOrElse(@d SparseBooleanArray sparseBooleanArray, int i2, @d a<Boolean> aVar) {
        i0.f(sparseBooleanArray, "$receiver");
        i0.f(aVar, "defaultValue");
        int iIndexOfKey = sparseBooleanArray.indexOfKey(i2);
        return iIndexOfKey != -1 ? sparseBooleanArray.valueAt(iIndexOfKey) : aVar.invoke().booleanValue();
    }

    public static final int getSize(@d SparseBooleanArray sparseBooleanArray) {
        i0.f(sparseBooleanArray, "$receiver");
        return sparseBooleanArray.size();
    }

    public static final boolean isEmpty(@d SparseBooleanArray sparseBooleanArray) {
        i0.f(sparseBooleanArray, "$receiver");
        return sparseBooleanArray.size() == 0;
    }

    public static final boolean isNotEmpty(@d SparseBooleanArray sparseBooleanArray) {
        i0.f(sparseBooleanArray, "$receiver");
        return sparseBooleanArray.size() != 0;
    }

    @d
    public static final u0 keyIterator(@d final SparseBooleanArray sparseBooleanArray) {
        i0.f(sparseBooleanArray, "$receiver");
        return new u0() { // from class: androidx.core.util.SparseBooleanArrayKt.keyIterator.1
            private int index;

            public final int getIndex() {
                return this.index;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.index < sparseBooleanArray.size();
            }

            @Override // h.g2.u0
            public int nextInt() {
                SparseBooleanArray sparseBooleanArray2 = sparseBooleanArray;
                int i2 = this.index;
                this.index = i2 + 1;
                return sparseBooleanArray2.keyAt(i2);
            }

            public final void setIndex(int i2) {
                this.index = i2;
            }
        };
    }

    @d
    public static final SparseBooleanArray plus(@d SparseBooleanArray sparseBooleanArray, @d SparseBooleanArray sparseBooleanArray2) {
        i0.f(sparseBooleanArray, "$receiver");
        i0.f(sparseBooleanArray2, DispatchConstants.OTHER);
        SparseBooleanArray sparseBooleanArray3 = new SparseBooleanArray(sparseBooleanArray.size() + sparseBooleanArray2.size());
        putAll(sparseBooleanArray3, sparseBooleanArray);
        putAll(sparseBooleanArray3, sparseBooleanArray2);
        return sparseBooleanArray3;
    }

    public static final void putAll(@d SparseBooleanArray sparseBooleanArray, @d SparseBooleanArray sparseBooleanArray2) {
        i0.f(sparseBooleanArray, "$receiver");
        i0.f(sparseBooleanArray2, DispatchConstants.OTHER);
        int size = sparseBooleanArray2.size();
        for (int i2 = 0; i2 < size; i2++) {
            sparseBooleanArray.put(sparseBooleanArray2.keyAt(i2), sparseBooleanArray2.valueAt(i2));
        }
    }

    public static final boolean remove(@d SparseBooleanArray sparseBooleanArray, int i2, boolean z) {
        i0.f(sparseBooleanArray, "$receiver");
        int iIndexOfKey = sparseBooleanArray.indexOfKey(i2);
        if (iIndexOfKey == -1 || z != sparseBooleanArray.valueAt(iIndexOfKey)) {
            return false;
        }
        sparseBooleanArray.delete(i2);
        return true;
    }

    public static final void set(@d SparseBooleanArray sparseBooleanArray, int i2, boolean z) {
        i0.f(sparseBooleanArray, "$receiver");
        sparseBooleanArray.put(i2, z);
    }

    @d
    public static final t valueIterator(@d final SparseBooleanArray sparseBooleanArray) {
        i0.f(sparseBooleanArray, "$receiver");
        return new t() { // from class: androidx.core.util.SparseBooleanArrayKt.valueIterator.1
            private int index;

            public final int getIndex() {
                return this.index;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.index < sparseBooleanArray.size();
            }

            @Override // h.g2.t
            public boolean nextBoolean() {
                SparseBooleanArray sparseBooleanArray2 = sparseBooleanArray;
                int i2 = this.index;
                this.index = i2 + 1;
                return sparseBooleanArray2.valueAt(i2);
            }

            public final void setIndex(int i2) {
                this.index = i2;
            }
        };
    }
}
