package androidx.core.graphics;

import android.graphics.Path;
import androidx.annotation.RequiresApi;
import com.umeng.analytics.pro.bh;
import h.q2.t.i0;
import h.y;
import i.c.a.d;
import java.util.Collection;

/* compiled from: Path.kt */
@y(bv = {1, 0, 2}, d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\f\u001a\u001c\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004*\u00020\u00012\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007\u001a\u0015\u0010\b\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\n\u001a\u0015\u0010\t\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\f\u001a\u0015\u0010\n\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\n\u001a\u0015\u0010\u000b\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\f¨\u0006\f"}, d2 = {"and", "Landroid/graphics/Path;", bh.aA, "flatten", "", "Landroidx/core/graphics/PathSegment;", "error", "", "minus", "or", "plus", "xor", "core-ktx_release"}, k = 2, mv = {1, 1, 10})
/* loaded from: classes.dex */
public final class PathKt {
    @RequiresApi(19)
    @d
    public static final Path and(@d Path path, @d Path path2) {
        i0.f(path, "$receiver");
        i0.f(path2, bh.aA);
        Path path3 = new Path();
        path3.op(path, path2, Path.Op.INTERSECT);
        return path3;
    }

    @RequiresApi(26)
    @d
    public static final Iterable<PathSegment> flatten(@d Path path, float f2) {
        i0.f(path, "$receiver");
        Collection<PathSegment> collectionFlatten = PathUtils.flatten(path, f2);
        i0.a((Object) collectionFlatten, "PathUtils.flatten(this, error)");
        return collectionFlatten;
    }

    @RequiresApi(26)
    @d
    public static /* bridge */ /* synthetic */ Iterable flatten$default(Path path, float f2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            f2 = 0.5f;
        }
        return flatten(path, f2);
    }

    @RequiresApi(19)
    @d
    public static final Path minus(@d Path path, @d Path path2) {
        i0.f(path, "$receiver");
        i0.f(path2, bh.aA);
        Path path3 = new Path(path);
        path3.op(path2, Path.Op.DIFFERENCE);
        return path3;
    }

    @RequiresApi(19)
    @d
    public static final Path or(@d Path path, @d Path path2) {
        i0.f(path, "$receiver");
        i0.f(path2, bh.aA);
        Path path3 = new Path(path);
        path3.op(path2, Path.Op.UNION);
        return path3;
    }

    @RequiresApi(19)
    @d
    public static final Path plus(@d Path path, @d Path path2) {
        i0.f(path, "$receiver");
        i0.f(path2, bh.aA);
        Path path3 = new Path(path);
        path3.op(path2, Path.Op.UNION);
        return path3;
    }

    @RequiresApi(19)
    @d
    public static final Path xor(@d Path path, @d Path path2) {
        i0.f(path, "$receiver");
        i0.f(path2, bh.aA);
        Path path3 = new Path(path);
        path3.op(path2, Path.Op.XOR);
        return path3;
    }
}
