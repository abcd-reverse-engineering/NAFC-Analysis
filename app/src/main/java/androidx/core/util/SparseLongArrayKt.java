package androidx.core.util;

import android.util.SparseLongArray;
import androidx.annotation.RequiresApi;
import anet.channel.strategy.dispatch.DispatchConstants;
import bean.SurveyH5Bean;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import h.g2.u0;
import h.g2.v0;
import h.q2.s.a;
import h.q2.s.p;
import h.q2.t.i0;
import h.y;
import h.y1;
import i.c.a.d;

/* compiled from: SparseLongArray.kt */
@y(bv = {1, 0, 2}, d1 = {"\u0000D\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u001a\u0015\u0010\u0005\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0001H\u0087\n\u001a\u0015\u0010\b\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0001H\u0087\b\u001a\u0015\u0010\t\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bH\u0087\b\u001aE\u0010\f\u001a\u00020\r*\u00020\u000226\u0010\u000e\u001a2\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\r0\u000fH\u0087\b\u001a\u001d\u0010\u0012\u001a\u00020\u000b*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u000bH\u0087\b\u001a#\u0010\u0014\u001a\u00020\u000b*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0015H\u0087\b\u001a\r\u0010\u0016\u001a\u00020\u0006*\u00020\u0002H\u0087\b\u001a\r\u0010\u0017\u001a\u00020\u0006*\u00020\u0002H\u0087\b\u001a\f\u0010\u0018\u001a\u00020\u0019*\u00020\u0002H\u0007\u001a\u0015\u0010\u001a\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0002H\u0087\u0002\u001a\u0014\u0010\u001c\u001a\u00020\r*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0002H\u0007\u001a\u001c\u0010\u001d\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000bH\u0007\u001a\u001d\u0010\u001e\u001a\u00020\r*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000bH\u0087\n\u001a\f\u0010\u001f\u001a\u00020 *\u00020\u0002H\u0007\"\u0016\u0010\u0000\u001a\u00020\u0001*\u00020\u00028Ç\u0002¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006!"}, d2 = {"size", "", "Landroid/util/SparseLongArray;", "getSize", "(Landroid/util/SparseLongArray;)I", "contains", "", "key", "containsKey", "containsValue", SurveyH5Bean.VALUE, "", "forEach", "", "action", "Lkotlin/Function2;", "Lkotlin/ParameterName;", CommonNetImpl.NAME, "getOrDefault", "defaultValue", "getOrElse", "Lkotlin/Function0;", "isEmpty", "isNotEmpty", "keyIterator", "Lkotlin/collections/IntIterator;", "plus", DispatchConstants.OTHER, "putAll", "remove", "set", "valueIterator", "Lkotlin/collections/LongIterator;", "core-ktx_release"}, k = 2, mv = {1, 1, 10})
/* loaded from: classes.dex */
public final class SparseLongArrayKt {
    @RequiresApi(18)
    public static final boolean contains(@d SparseLongArray sparseLongArray, int i2) {
        i0.f(sparseLongArray, "$receiver");
        return sparseLongArray.indexOfKey(i2) >= 0;
    }

    @RequiresApi(18)
    public static final boolean containsKey(@d SparseLongArray sparseLongArray, int i2) {
        i0.f(sparseLongArray, "$receiver");
        return sparseLongArray.indexOfKey(i2) >= 0;
    }

    @RequiresApi(18)
    public static final boolean containsValue(@d SparseLongArray sparseLongArray, long j2) {
        i0.f(sparseLongArray, "$receiver");
        return sparseLongArray.indexOfValue(j2) != -1;
    }

    @RequiresApi(18)
    public static final void forEach(@d SparseLongArray sparseLongArray, @d p<? super Integer, ? super Long, y1> pVar) {
        i0.f(sparseLongArray, "$receiver");
        i0.f(pVar, "action");
        int size = sparseLongArray.size();
        for (int i2 = 0; i2 < size; i2++) {
            pVar.invoke(Integer.valueOf(sparseLongArray.keyAt(i2)), Long.valueOf(sparseLongArray.valueAt(i2)));
        }
    }

    @RequiresApi(18)
    public static final long getOrDefault(@d SparseLongArray sparseLongArray, int i2, long j2) {
        i0.f(sparseLongArray, "$receiver");
        return sparseLongArray.get(i2, j2);
    }

    @RequiresApi(18)
    public static final long getOrElse(@d SparseLongArray sparseLongArray, int i2, @d a<Long> aVar) {
        i0.f(sparseLongArray, "$receiver");
        i0.f(aVar, "defaultValue");
        int iIndexOfKey = sparseLongArray.indexOfKey(i2);
        return iIndexOfKey != -1 ? sparseLongArray.valueAt(iIndexOfKey) : aVar.invoke().longValue();
    }

    @RequiresApi(18)
    public static final int getSize(@d SparseLongArray sparseLongArray) {
        i0.f(sparseLongArray, "$receiver");
        return sparseLongArray.size();
    }

    @RequiresApi(18)
    public static final boolean isEmpty(@d SparseLongArray sparseLongArray) {
        i0.f(sparseLongArray, "$receiver");
        return sparseLongArray.size() == 0;
    }

    @RequiresApi(18)
    public static final boolean isNotEmpty(@d SparseLongArray sparseLongArray) {
        i0.f(sparseLongArray, "$receiver");
        return sparseLongArray.size() != 0;
    }

    @RequiresApi(18)
    @d
    public static final u0 keyIterator(@d final SparseLongArray sparseLongArray) {
        i0.f(sparseLongArray, "$receiver");
        return new u0() { // from class: androidx.core.util.SparseLongArrayKt.keyIterator.1
            private int index;

            public final int getIndex() {
                return this.index;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.index < sparseLongArray.size();
            }

            @Override // h.g2.u0
            public int nextInt() {
                SparseLongArray sparseLongArray2 = sparseLongArray;
                int i2 = this.index;
                this.index = i2 + 1;
                return sparseLongArray2.keyAt(i2);
            }

            public final void setIndex(int i2) {
                this.index = i2;
            }
        };
    }

    @RequiresApi(18)
    @d
    public static final SparseLongArray plus(@d SparseLongArray sparseLongArray, @d SparseLongArray sparseLongArray2) {
        i0.f(sparseLongArray, "$receiver");
        i0.f(sparseLongArray2, DispatchConstants.OTHER);
        SparseLongArray sparseLongArray3 = new SparseLongArray(sparseLongArray.size() + sparseLongArray2.size());
        putAll(sparseLongArray3, sparseLongArray);
        putAll(sparseLongArray3, sparseLongArray2);
        return sparseLongArray3;
    }

    @RequiresApi(18)
    public static final void putAll(@d SparseLongArray sparseLongArray, @d SparseLongArray sparseLongArray2) {
        i0.f(sparseLongArray, "$receiver");
        i0.f(sparseLongArray2, DispatchConstants.OTHER);
        int size = sparseLongArray2.size();
        for (int i2 = 0; i2 < size; i2++) {
            sparseLongArray.put(sparseLongArray2.keyAt(i2), sparseLongArray2.valueAt(i2));
        }
    }

    @RequiresApi(18)
    public static final boolean remove(@d SparseLongArray sparseLongArray, int i2, long j2) {
        i0.f(sparseLongArray, "$receiver");
        int iIndexOfKey = sparseLongArray.indexOfKey(i2);
        if (iIndexOfKey == -1 || j2 != sparseLongArray.valueAt(iIndexOfKey)) {
            return false;
        }
        sparseLongArray.removeAt(iIndexOfKey);
        return true;
    }

    @RequiresApi(18)
    public static final void set(@d SparseLongArray sparseLongArray, int i2, long j2) {
        i0.f(sparseLongArray, "$receiver");
        sparseLongArray.put(i2, j2);
    }

    @RequiresApi(18)
    @d
    public static final v0 valueIterator(@d final SparseLongArray sparseLongArray) {
        i0.f(sparseLongArray, "$receiver");
        return new v0() { // from class: androidx.core.util.SparseLongArrayKt.valueIterator.1
            private int index;

            public final int getIndex() {
                return this.index;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.index < sparseLongArray.size();
            }

            @Override // h.g2.v0
            public long nextLong() {
                SparseLongArray sparseLongArray2 = sparseLongArray;
                int i2 = this.index;
                this.index = i2 + 1;
                return sparseLongArray2.valueAt(i2);
            }

            public final void setIndex(int i2) {
                this.index = i2;
            }
        };
    }
}
