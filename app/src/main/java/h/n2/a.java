package h.n2;

import h.q2.t.i0;
import java.io.File;

/* compiled from: Exceptions.kt */
/* loaded from: classes2.dex */
public final class a extends j {
    public /* synthetic */ a(File file, File file2, String str, int i2, h.q2.t.v vVar) {
        this(file, (i2 & 2) != 0 ? null : file2, (i2 & 4) != 0 ? null : str);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@i.c.a.d File file, @i.c.a.e File file2, @i.c.a.e String str) {
        super(file, file2, str);
        i0.f(file, "file");
    }
}
