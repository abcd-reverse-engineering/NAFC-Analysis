package okio;

import h.q2.e;
import h.q2.t.i0;
import h.y;
import i.c.a.d;
import java.util.zip.Deflater;

/* compiled from: DeflaterSink.kt */
@e(name = "-DeflaterSinkExtensions")
@y(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0017\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0086\b¨\u0006\u0005"}, d2 = {"deflate", "Lokio/DeflaterSink;", "Lokio/Sink;", "deflater", "Ljava/util/zip/Deflater;", "okio"}, k = 2, mv = {1, 1, 16})
/* renamed from: okio.-DeflaterSinkExtensions, reason: invalid class name */
/* loaded from: classes2.dex */
public final class DeflaterSinkExtensions {
    @d
    public static final DeflaterSink deflate(@d Sink sink, @d Deflater deflater) {
        i0.f(sink, "$this$deflate");
        i0.f(deflater, "deflater");
        return new DeflaterSink(sink, deflater);
    }

    public static /* synthetic */ DeflaterSink deflate$default(Sink sink, Deflater deflater, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            deflater = new Deflater();
        }
        i0.f(sink, "$this$deflate");
        i0.f(deflater, "deflater");
        return new DeflaterSink(sink, deflater);
    }
}
