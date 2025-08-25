package h.g2;

import androidx.exifinterface.media.ExifInterface;
import java.util.Enumeration;
import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IteratorsJVM.kt */
@h.y(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010(\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001f\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0086\u0002¨\u0006\u0004"}, d2 = {"iterator", "", ExifInterface.GPS_DIRECTION_TRUE, "Ljava/util/Enumeration;", "kotlin-stdlib"}, k = 5, mv = {1, 1, 16}, xi = 1, xs = "kotlin/collections/CollectionsKt")
/* loaded from: classes2.dex */
public class a0 extends z {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: IteratorsJVM.kt */
    public static final class a<T> implements Iterator<T>, h.q2.t.q1.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Enumeration f16109a;

        a(Enumeration<T> enumeration) {
            this.f16109a = enumeration;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f16109a.hasMoreElements();
        }

        @Override // java.util.Iterator
        public T next() {
            return (T) this.f16109a.nextElement();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    @i.c.a.d
    public static <T> Iterator<T> a(@i.c.a.d Enumeration<T> enumeration) {
        h.q2.t.i0.f(enumeration, "$this$iterator");
        return new a(enumeration);
    }
}
