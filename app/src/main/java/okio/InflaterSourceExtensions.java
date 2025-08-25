package okio;

import h.q2.e;
import h.q2.t.i0;
import h.y;
import i.c.a.d;
import java.util.zip.Inflater;

/* compiled from: InflaterSource.kt */
@e(name = "-InflaterSourceExtensions")
@y(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0017\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0086\b¨\u0006\u0005"}, d2 = {"inflate", "Lokio/InflaterSource;", "Lokio/Source;", "inflater", "Ljava/util/zip/Inflater;", "okio"}, k = 2, mv = {1, 1, 16})
/* renamed from: okio.-InflaterSourceExtensions, reason: invalid class name */
/* loaded from: classes2.dex */
public final class InflaterSourceExtensions {
    @d
    public static final InflaterSource inflate(@d Source source, @d Inflater inflater) {
        i0.f(source, "$this$inflate");
        i0.f(inflater, "inflater");
        return new InflaterSource(source, inflater);
    }

    public static /* synthetic */ InflaterSource inflate$default(Source source, Inflater inflater, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            inflater = new Inflater();
        }
        i0.f(source, "$this$inflate");
        i0.f(inflater, "inflater");
        return new InflaterSource(source, inflater);
    }
}
