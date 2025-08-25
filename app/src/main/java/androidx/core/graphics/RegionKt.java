package androidx.core.graphics;

import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.RegionIterator;
import com.umeng.analytics.pro.bh;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import h.q2.s.l;
import h.q2.t.i0;
import h.q2.t.q1.a;
import h.y;
import h.y1;
import i.c.a.d;
import java.util.Iterator;

/* compiled from: Region.kt */
@y(bv = {1, 0, 2}, d1 = {"\u00004\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010(\n\u0002\b\u0007\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0086\f\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0086\f\u001a\u0015\u0010\u0004\u001a\u00020\u0005*\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0007H\u0086\n\u001a0\u0010\b\u001a\u00020\t*\u00020\u00012!\u0010\n\u001a\u001d\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\t0\u000bH\u0086\b\u001a\u0013\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0010*\u00020\u0001H\u0086\u0002\u001a\u0015\u0010\u0011\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0086\n\u001a\u0015\u0010\u0011\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0086\n\u001a\r\u0010\u0012\u001a\u00020\u0001*\u00020\u0001H\u0086\n\u001a\u0015\u0010\u0013\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0086\f\u001a\u0015\u0010\u0013\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0086\f\u001a\u0015\u0010\u0014\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0086\n\u001a\u0015\u0010\u0014\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0086\n\u001a\r\u0010\u0015\u001a\u00020\u0001*\u00020\u0001H\u0086\n\u001a\u0015\u0010\u0016\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0086\f\u001a\u0015\u0010\u0016\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0086\f¨\u0006\u0017"}, d2 = {"and", "Landroid/graphics/Region;", "r", "Landroid/graphics/Rect;", "contains", "", bh.aA, "Landroid/graphics/Point;", "forEach", "", "action", "Lkotlin/Function1;", "Lkotlin/ParameterName;", CommonNetImpl.NAME, "rect", "iterator", "", "minus", "not", "or", "plus", "unaryMinus", "xor", "core-ktx_release"}, k = 2, mv = {1, 1, 10})
/* loaded from: classes.dex */
public final class RegionKt {

    /* compiled from: Region.kt */
    @y(bv = {1, 0, 2}, d1 = {"\u0000\u001f\n\u0000\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\t\u0010\t\u001a\u00020\u0005H\u0096\u0002J\t\u0010\n\u001a\u00020\u0002H\u0096\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0002X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"androidx/core/graphics/RegionKt$iterator$1", "", "Landroid/graphics/Rect;", "(Landroid/graphics/Region;)V", "hasMore", "", "iterator", "Landroid/graphics/RegionIterator;", "rect", "hasNext", "next", "core-ktx_release"}, k = 1, mv = {1, 1, 10})
    /* renamed from: androidx.core.graphics.RegionKt$iterator$1, reason: invalid class name */
    public static final class AnonymousClass1 implements Iterator<Rect>, a {
        private boolean hasMore;
        private final RegionIterator iterator;
        final /* synthetic */ Region receiver$0;
        private final Rect rect = new Rect();

        AnonymousClass1(Region region) {
            this.receiver$0 = region;
            this.iterator = new RegionIterator(this.receiver$0);
            this.hasMore = this.iterator.next(this.rect);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.hasMore;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        @d
        public Rect next() {
            if (!this.hasMore) {
                throw new IndexOutOfBoundsException();
            }
            Rect rect = new Rect(this.rect);
            this.hasMore = this.iterator.next(this.rect);
            return rect;
        }
    }

    @d
    public static final Region and(@d Region region, @d Rect rect) {
        i0.f(region, "$receiver");
        i0.f(rect, "r");
        Region region2 = new Region(region);
        region2.op(rect, Region.Op.INTERSECT);
        return region2;
    }

    public static final boolean contains(@d Region region, @d Point point) {
        i0.f(region, "$receiver");
        i0.f(point, bh.aA);
        return region.contains(point.x, point.y);
    }

    public static final void forEach(@d Region region, @d l<? super Rect, y1> lVar) {
        i0.f(region, "$receiver");
        i0.f(lVar, "action");
        RegionIterator regionIterator = new RegionIterator(region);
        while (true) {
            Rect rect = new Rect();
            if (!regionIterator.next(rect)) {
                return;
            } else {
                lVar.invoke(rect);
            }
        }
    }

    @d
    public static final Iterator<Rect> iterator(@d Region region) {
        i0.f(region, "$receiver");
        return new AnonymousClass1(region);
    }

    @d
    public static final Region minus(@d Region region, @d Rect rect) {
        i0.f(region, "$receiver");
        i0.f(rect, "r");
        Region region2 = new Region(region);
        region2.op(rect, Region.Op.DIFFERENCE);
        return region2;
    }

    @d
    public static final Region not(@d Region region) {
        i0.f(region, "$receiver");
        Region region2 = new Region(region.getBounds());
        region2.op(region, Region.Op.DIFFERENCE);
        return region2;
    }

    @d
    public static final Region or(@d Region region, @d Rect rect) {
        i0.f(region, "$receiver");
        i0.f(rect, "r");
        Region region2 = new Region(region);
        region2.union(rect);
        return region2;
    }

    @d
    public static final Region plus(@d Region region, @d Rect rect) {
        i0.f(region, "$receiver");
        i0.f(rect, "r");
        Region region2 = new Region(region);
        region2.union(rect);
        return region2;
    }

    @d
    public static final Region unaryMinus(@d Region region) {
        i0.f(region, "$receiver");
        Region region2 = new Region(region.getBounds());
        region2.op(region, Region.Op.DIFFERENCE);
        return region2;
    }

    @d
    public static final Region xor(@d Region region, @d Rect rect) {
        i0.f(region, "$receiver");
        i0.f(rect, "r");
        Region region2 = new Region(region);
        region2.op(rect, Region.Op.XOR);
        return region2;
    }

    @d
    public static final Region and(@d Region region, @d Region region2) {
        i0.f(region, "$receiver");
        i0.f(region2, "r");
        Region region3 = new Region(region);
        region3.op(region2, Region.Op.INTERSECT);
        return region3;
    }

    @d
    public static final Region minus(@d Region region, @d Region region2) {
        i0.f(region, "$receiver");
        i0.f(region2, "r");
        Region region3 = new Region(region);
        region3.op(region2, Region.Op.DIFFERENCE);
        return region3;
    }

    @d
    public static final Region or(@d Region region, @d Region region2) {
        i0.f(region, "$receiver");
        i0.f(region2, "r");
        Region region3 = new Region(region);
        region3.op(region2, Region.Op.UNION);
        return region3;
    }

    @d
    public static final Region plus(@d Region region, @d Region region2) {
        i0.f(region, "$receiver");
        i0.f(region2, "r");
        Region region3 = new Region(region);
        region3.op(region2, Region.Op.UNION);
        return region3;
    }

    @d
    public static final Region xor(@d Region region, @d Region region2) {
        i0.f(region, "$receiver");
        i0.f(region2, "r");
        Region region3 = new Region(region);
        region3.op(region2, Region.Op.XOR);
        return region3;
    }
}
