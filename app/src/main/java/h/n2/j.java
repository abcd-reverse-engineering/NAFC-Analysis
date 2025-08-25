package h.n2;

import h.q2.t.i0;
import java.io.File;
import java.io.IOException;

/* compiled from: Exceptions.kt */
/* loaded from: classes2.dex */
public class j extends IOException {

    @i.c.a.d
    private final File file;

    @i.c.a.e
    private final File other;

    @i.c.a.e
    private final String reason;

    public /* synthetic */ j(File file, File file2, String str, int i2, h.q2.t.v vVar) {
        this(file, (i2 & 2) != 0 ? null : file2, (i2 & 4) != 0 ? null : str);
    }

    @i.c.a.d
    public final File getFile() {
        return this.file;
    }

    @i.c.a.e
    public final File getOther() {
        return this.other;
    }

    @i.c.a.e
    public final String getReason() {
        return this.reason;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(@i.c.a.d File file, @i.c.a.e File file2, @i.c.a.e String str) {
        super(f.b(file, file2, str));
        i0.f(file, "file");
        this.file = file;
        this.other = file2;
        this.reason = str;
    }
}
