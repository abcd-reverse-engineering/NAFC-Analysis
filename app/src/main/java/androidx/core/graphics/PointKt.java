package androidx.core.graphics;

import android.graphics.Point;
import android.graphics.PointF;
import com.umeng.analytics.pro.bh;
import h.q2.t.i0;
import h.y;
import i.c.a.d;

/* compiled from: Point.kt */
@y(bv = {1, 0, 2}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\t\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0086\n\u001a\r\u0010\u0000\u001a\u00020\u0003*\u00020\u0004H\u0086\n\u001a\r\u0010\u0005\u001a\u00020\u0001*\u00020\u0002H\u0086\n\u001a\r\u0010\u0005\u001a\u00020\u0003*\u00020\u0004H\u0086\n\u001a\u0015\u0010\u0006\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0086\n\u001a\u0015\u0010\u0006\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\b\u001a\u00020\u0001H\u0086\n\u001a\u0015\u0010\u0006\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0086\n\u001a\u0015\u0010\u0006\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\b\u001a\u00020\u0003H\u0086\n\u001a\u0015\u0010\t\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0086\n\u001a\u0015\u0010\t\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\b\u001a\u00020\u0001H\u0086\n\u001a\u0015\u0010\t\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0086\n\u001a\u0015\u0010\t\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\b\u001a\u00020\u0003H\u0086\n\u001a\r\u0010\n\u001a\u00020\u0002*\u00020\u0004H\u0086\b\u001a\r\u0010\u000b\u001a\u00020\u0004*\u00020\u0002H\u0086\b\u001a\r\u0010\f\u001a\u00020\u0002*\u00020\u0002H\u0086\n\u001a\r\u0010\f\u001a\u00020\u0004*\u00020\u0004H\u0086\n¨\u0006\r"}, d2 = {"component1", "", "Landroid/graphics/Point;", "", "Landroid/graphics/PointF;", "component2", "minus", bh.aA, "xy", "plus", "toPoint", "toPointF", "unaryMinus", "core-ktx_release"}, k = 2, mv = {1, 1, 10})
/* loaded from: classes.dex */
public final class PointKt {
    public static final int component1(@d Point point) {
        i0.f(point, "$receiver");
        return point.x;
    }

    public static final int component2(@d Point point) {
        i0.f(point, "$receiver");
        return point.y;
    }

    @d
    public static final Point minus(@d Point point, @d Point point2) {
        i0.f(point, "$receiver");
        i0.f(point2, bh.aA);
        Point point3 = new Point(point.x, point.y);
        point3.offset(-point2.x, -point2.y);
        return point3;
    }

    @d
    public static final Point plus(@d Point point, @d Point point2) {
        i0.f(point, "$receiver");
        i0.f(point2, bh.aA);
        Point point3 = new Point(point.x, point.y);
        point3.offset(point2.x, point2.y);
        return point3;
    }

    @d
    public static final Point toPoint(@d PointF pointF) {
        i0.f(pointF, "$receiver");
        return new Point((int) pointF.x, (int) pointF.y);
    }

    @d
    public static final PointF toPointF(@d Point point) {
        i0.f(point, "$receiver");
        return new PointF(point);
    }

    @d
    public static final Point unaryMinus(@d Point point) {
        i0.f(point, "$receiver");
        return new Point(-point.x, -point.y);
    }

    public static final float component1(@d PointF pointF) {
        i0.f(pointF, "$receiver");
        return pointF.x;
    }

    public static final float component2(@d PointF pointF) {
        i0.f(pointF, "$receiver");
        return pointF.y;
    }

    @d
    public static final PointF unaryMinus(@d PointF pointF) {
        i0.f(pointF, "$receiver");
        return new PointF(-pointF.x, -pointF.y);
    }

    @d
    public static final PointF minus(@d PointF pointF, @d PointF pointF2) {
        i0.f(pointF, "$receiver");
        i0.f(pointF2, bh.aA);
        PointF pointF3 = new PointF(pointF.x, pointF.y);
        pointF3.offset(-pointF2.x, -pointF2.y);
        return pointF3;
    }

    @d
    public static final PointF plus(@d PointF pointF, @d PointF pointF2) {
        i0.f(pointF, "$receiver");
        i0.f(pointF2, bh.aA);
        PointF pointF3 = new PointF(pointF.x, pointF.y);
        pointF3.offset(pointF2.x, pointF2.y);
        return pointF3;
    }

    @d
    public static final Point minus(@d Point point, int i2) {
        i0.f(point, "$receiver");
        Point point2 = new Point(point.x, point.y);
        int i3 = -i2;
        point2.offset(i3, i3);
        return point2;
    }

    @d
    public static final Point plus(@d Point point, int i2) {
        i0.f(point, "$receiver");
        Point point2 = new Point(point.x, point.y);
        point2.offset(i2, i2);
        return point2;
    }

    @d
    public static final PointF minus(@d PointF pointF, float f2) {
        i0.f(pointF, "$receiver");
        PointF pointF2 = new PointF(pointF.x, pointF.y);
        float f3 = -f2;
        pointF2.offset(f3, f3);
        return pointF2;
    }

    @d
    public static final PointF plus(@d PointF pointF, float f2) {
        i0.f(pointF, "$receiver");
        PointF pointF2 = new PointF(pointF.x, pointF.y);
        pointF2.offset(f2, f2);
        return pointF2;
    }
}
