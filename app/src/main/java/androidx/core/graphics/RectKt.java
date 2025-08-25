package androidx.core.graphics;

import android.annotation.SuppressLint;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import com.umeng.analytics.pro.bh;
import h.q2.t.i0;
import h.y;
import i.c.a.d;

/* compiled from: Rect.kt */
@y(bv = {1, 0, 2}, d1 = {"\u0000<\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\f\u001a\u0015\u0010\u0000\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0003H\u0087\f\u001a\r\u0010\u0004\u001a\u00020\u0005*\u00020\u0001H\u0086\n\u001a\r\u0010\u0004\u001a\u00020\u0006*\u00020\u0003H\u0086\n\u001a\r\u0010\u0007\u001a\u00020\u0005*\u00020\u0001H\u0086\n\u001a\r\u0010\u0007\u001a\u00020\u0006*\u00020\u0003H\u0086\n\u001a\r\u0010\b\u001a\u00020\u0005*\u00020\u0001H\u0086\n\u001a\r\u0010\b\u001a\u00020\u0006*\u00020\u0003H\u0086\n\u001a\r\u0010\t\u001a\u00020\u0005*\u00020\u0001H\u0086\n\u001a\r\u0010\t\u001a\u00020\u0006*\u00020\u0003H\u0086\n\u001a\u0015\u0010\n\u001a\u00020\u000b*\u00020\u00012\u0006\u0010\f\u001a\u00020\rH\u0086\n\u001a\u0015\u0010\n\u001a\u00020\u000b*\u00020\u00032\u0006\u0010\f\u001a\u00020\u000eH\u0086\n\u001a\u0015\u0010\u000f\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0010\u001a\u00020\rH\u0086\n\u001a\u0015\u0010\u000f\u001a\u00020\u0011*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0086\n\u001a\u0015\u0010\u000f\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u0005H\u0086\n\u001a\u0015\u0010\u000f\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u000eH\u0086\n\u001a\u0015\u0010\u000f\u001a\u00020\u0011*\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0003H\u0086\n\u001a\u0015\u0010\u000f\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0006H\u0086\n\u001a\u0015\u0010\u0012\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0086\f\u001a\u0015\u0010\u0012\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0003H\u0086\f\u001a\u0015\u0010\u0013\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0010\u001a\u00020\rH\u0086\n\u001a\u0015\u0010\u0013\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0086\n\u001a\u0015\u0010\u0013\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u0005H\u0086\n\u001a\u0015\u0010\u0013\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u000eH\u0086\n\u001a\u0015\u0010\u0013\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0003H\u0086\n\u001a\u0015\u0010\u0013\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0006H\u0086\n\u001a\r\u0010\u0014\u001a\u00020\u0001*\u00020\u0003H\u0086\b\u001a\r\u0010\u0015\u001a\u00020\u0003*\u00020\u0001H\u0086\b\u001a\r\u0010\u0016\u001a\u00020\u0011*\u00020\u0001H\u0086\b\u001a\r\u0010\u0016\u001a\u00020\u0011*\u00020\u0003H\u0086\b\u001a\u0015\u0010\u0017\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u0019H\u0086\b\u001a\u0015\u0010\u001a\u001a\u00020\u0011*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0086\f\u001a\u0015\u0010\u001a\u001a\u00020\u0011*\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0003H\u0086\f¨\u0006\u001b"}, d2 = {"and", "Landroid/graphics/Rect;", "r", "Landroid/graphics/RectF;", "component1", "", "", "component2", "component3", "component4", "contains", "", bh.aA, "Landroid/graphics/Point;", "Landroid/graphics/PointF;", "minus", "xy", "Landroid/graphics/Region;", "or", "plus", "toRect", "toRectF", "toRegion", "transform", "m", "Landroid/graphics/Matrix;", "xor", "core-ktx_release"}, k = 2, mv = {1, 1, 10})
/* loaded from: classes.dex */
public final class RectKt {
    @SuppressLint({"CheckResult"})
    @d
    public static final Rect and(@d Rect rect, @d Rect rect2) {
        i0.f(rect, "$receiver");
        i0.f(rect2, "r");
        Rect rect3 = new Rect(rect);
        rect3.intersect(rect2);
        return rect3;
    }

    public static final int component1(@d Rect rect) {
        i0.f(rect, "$receiver");
        return rect.left;
    }

    public static final int component2(@d Rect rect) {
        i0.f(rect, "$receiver");
        return rect.top;
    }

    public static final int component3(@d Rect rect) {
        i0.f(rect, "$receiver");
        return rect.right;
    }

    public static final int component4(@d Rect rect) {
        i0.f(rect, "$receiver");
        return rect.bottom;
    }

    public static final boolean contains(@d Rect rect, @d Point point) {
        i0.f(rect, "$receiver");
        i0.f(point, bh.aA);
        return rect.contains(point.x, point.y);
    }

    @d
    public static final Region minus(@d Rect rect, @d Rect rect2) {
        i0.f(rect, "$receiver");
        i0.f(rect2, "r");
        Region region = new Region(rect);
        region.op(rect2, Region.Op.DIFFERENCE);
        return region;
    }

    @d
    public static final Rect or(@d Rect rect, @d Rect rect2) {
        i0.f(rect, "$receiver");
        i0.f(rect2, "r");
        Rect rect3 = new Rect(rect);
        rect3.union(rect2);
        return rect3;
    }

    @d
    public static final Rect plus(@d Rect rect, @d Rect rect2) {
        i0.f(rect, "$receiver");
        i0.f(rect2, "r");
        Rect rect3 = new Rect(rect);
        rect3.union(rect2);
        return rect3;
    }

    @d
    public static final Rect toRect(@d RectF rectF) {
        i0.f(rectF, "$receiver");
        Rect rect = new Rect();
        rectF.roundOut(rect);
        return rect;
    }

    @d
    public static final RectF toRectF(@d Rect rect) {
        i0.f(rect, "$receiver");
        return new RectF(rect);
    }

    @d
    public static final Region toRegion(@d Rect rect) {
        i0.f(rect, "$receiver");
        return new Region(rect);
    }

    @d
    public static final RectF transform(@d RectF rectF, @d Matrix matrix) {
        i0.f(rectF, "$receiver");
        i0.f(matrix, "m");
        matrix.mapRect(rectF);
        return rectF;
    }

    @d
    public static final Region xor(@d Rect rect, @d Rect rect2) {
        i0.f(rect, "$receiver");
        i0.f(rect2, "r");
        Region region = new Region(rect);
        region.op(rect2, Region.Op.XOR);
        return region;
    }

    public static final float component1(@d RectF rectF) {
        i0.f(rectF, "$receiver");
        return rectF.left;
    }

    public static final float component2(@d RectF rectF) {
        i0.f(rectF, "$receiver");
        return rectF.top;
    }

    public static final float component3(@d RectF rectF) {
        i0.f(rectF, "$receiver");
        return rectF.right;
    }

    public static final float component4(@d RectF rectF) {
        i0.f(rectF, "$receiver");
        return rectF.bottom;
    }

    public static final boolean contains(@d RectF rectF, @d PointF pointF) {
        i0.f(rectF, "$receiver");
        i0.f(pointF, bh.aA);
        return rectF.contains(pointF.x, pointF.y);
    }

    @d
    public static final Region toRegion(@d RectF rectF) {
        i0.f(rectF, "$receiver");
        Rect rect = new Rect();
        rectF.roundOut(rect);
        return new Region(rect);
    }

    @SuppressLint({"CheckResult"})
    @d
    public static final RectF and(@d RectF rectF, @d RectF rectF2) {
        i0.f(rectF, "$receiver");
        i0.f(rectF2, "r");
        RectF rectF3 = new RectF(rectF);
        rectF3.intersect(rectF2);
        return rectF3;
    }

    @d
    public static final Region minus(@d RectF rectF, @d RectF rectF2) {
        i0.f(rectF, "$receiver");
        i0.f(rectF2, "r");
        Rect rect = new Rect();
        rectF.roundOut(rect);
        Region region = new Region(rect);
        Rect rect2 = new Rect();
        rectF2.roundOut(rect2);
        region.op(rect2, Region.Op.DIFFERENCE);
        return region;
    }

    @d
    public static final RectF or(@d RectF rectF, @d RectF rectF2) {
        i0.f(rectF, "$receiver");
        i0.f(rectF2, "r");
        RectF rectF3 = new RectF(rectF);
        rectF3.union(rectF2);
        return rectF3;
    }

    @d
    public static final RectF plus(@d RectF rectF, @d RectF rectF2) {
        i0.f(rectF, "$receiver");
        i0.f(rectF2, "r");
        RectF rectF3 = new RectF(rectF);
        rectF3.union(rectF2);
        return rectF3;
    }

    @d
    public static final Region xor(@d RectF rectF, @d RectF rectF2) {
        i0.f(rectF, "$receiver");
        i0.f(rectF2, "r");
        Rect rect = new Rect();
        rectF.roundOut(rect);
        Region region = new Region(rect);
        Rect rect2 = new Rect();
        rectF2.roundOut(rect2);
        region.op(rect2, Region.Op.XOR);
        return region;
    }

    @d
    public static final Rect plus(@d Rect rect, int i2) {
        i0.f(rect, "$receiver");
        Rect rect2 = new Rect(rect);
        rect2.offset(i2, i2);
        return rect2;
    }

    @d
    public static final RectF plus(@d RectF rectF, float f2) {
        i0.f(rectF, "$receiver");
        RectF rectF2 = new RectF(rectF);
        rectF2.offset(f2, f2);
        return rectF2;
    }

    @d
    public static final Rect plus(@d Rect rect, @d Point point) {
        i0.f(rect, "$receiver");
        i0.f(point, "xy");
        Rect rect2 = new Rect(rect);
        rect2.offset(point.x, point.y);
        return rect2;
    }

    @d
    public static final Rect minus(@d Rect rect, int i2) {
        i0.f(rect, "$receiver");
        Rect rect2 = new Rect(rect);
        int i3 = -i2;
        rect2.offset(i3, i3);
        return rect2;
    }

    @d
    public static final RectF plus(@d RectF rectF, @d PointF pointF) {
        i0.f(rectF, "$receiver");
        i0.f(pointF, "xy");
        RectF rectF2 = new RectF(rectF);
        rectF2.offset(pointF.x, pointF.y);
        return rectF2;
    }

    @d
    public static final RectF minus(@d RectF rectF, float f2) {
        i0.f(rectF, "$receiver");
        RectF rectF2 = new RectF(rectF);
        float f3 = -f2;
        rectF2.offset(f3, f3);
        return rectF2;
    }

    @d
    public static final Rect minus(@d Rect rect, @d Point point) {
        i0.f(rect, "$receiver");
        i0.f(point, "xy");
        Rect rect2 = new Rect(rect);
        rect2.offset(-point.x, -point.y);
        return rect2;
    }

    @d
    public static final RectF minus(@d RectF rectF, @d PointF pointF) {
        i0.f(rectF, "$receiver");
        i0.f(pointF, "xy");
        RectF rectF2 = new RectF(rectF);
        rectF2.offset(-pointF.x, -pointF.y);
        return rectF2;
    }
}
