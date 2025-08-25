package h.n2;

import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import h.q2.t.i0;
import java.io.File;

/* compiled from: FileTreeWalk.kt */
/* loaded from: classes2.dex */
class q extends p {
    public static /* synthetic */ k a(File file, m mVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            mVar = m.TOP_DOWN;
        }
        return a(file, mVar);
    }

    @i.c.a.d
    public static final k e(@i.c.a.d File file) {
        i0.f(file, "$this$walkBottomUp");
        return a(file, m.BOTTOM_UP);
    }

    @i.c.a.d
    public static final k f(@i.c.a.d File file) {
        i0.f(file, "$this$walkTopDown");
        return a(file, m.TOP_DOWN);
    }

    @i.c.a.d
    public static final k a(@i.c.a.d File file, @i.c.a.d m mVar) {
        i0.f(file, "$this$walk");
        i0.f(mVar, HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION);
        return new k(file, mVar);
    }
}
