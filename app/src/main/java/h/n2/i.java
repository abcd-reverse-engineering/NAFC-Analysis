package h.n2;

import h.g2.g0;
import h.q2.t.i0;
import java.io.File;
import java.util.List;

/* compiled from: FilePathComponents.kt */
/* loaded from: classes2.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    @i.c.a.d
    private final File f16329a;

    /* renamed from: b, reason: collision with root package name */
    @i.c.a.d
    private final List<File> f16330b;

    /* JADX WARN: Multi-variable type inference failed */
    public i(@i.c.a.d File file, @i.c.a.d List<? extends File> list) {
        i0.f(file, "root");
        i0.f(list, "segments");
        this.f16329a = file;
        this.f16330b = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ i a(i iVar, File file, List list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            file = iVar.f16329a;
        }
        if ((i2 & 2) != 0) {
            list = iVar.f16330b;
        }
        return iVar.a(file, (List<? extends File>) list);
    }

    @i.c.a.d
    public final i a(@i.c.a.d File file, @i.c.a.d List<? extends File> list) {
        i0.f(file, "root");
        i0.f(list, "segments");
        return new i(file, list);
    }

    @i.c.a.d
    public final File a() {
        return this.f16329a;
    }

    @i.c.a.d
    public final File a(int i2, int i3) {
        if (i2 < 0 || i2 > i3 || i3 > f()) {
            throw new IllegalArgumentException();
        }
        List<File> listSubList = this.f16330b.subList(i2, i3);
        String str = File.separator;
        i0.a((Object) str, "File.separator");
        return new File(g0.a(listSubList, str, null, null, 0, null, null, 62, null));
    }

    @i.c.a.d
    public final List<File> b() {
        return this.f16330b;
    }

    @i.c.a.d
    public final File c() {
        return this.f16329a;
    }

    @i.c.a.d
    public final String d() {
        String path = this.f16329a.getPath();
        i0.a((Object) path, "root.path");
        return path;
    }

    @i.c.a.d
    public final List<File> e() {
        return this.f16330b;
    }

    public boolean equals(@i.c.a.e Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        return i0.a(this.f16329a, iVar.f16329a) && i0.a(this.f16330b, iVar.f16330b);
    }

    public final int f() {
        return this.f16330b.size();
    }

    public final boolean g() {
        String path = this.f16329a.getPath();
        i0.a((Object) path, "root.path");
        return path.length() > 0;
    }

    public int hashCode() {
        File file = this.f16329a;
        int iHashCode = (file != null ? file.hashCode() : 0) * 31;
        List<File> list = this.f16330b;
        return iHashCode + (list != null ? list.hashCode() : 0);
    }

    @i.c.a.d
    public String toString() {
        return "FilePathComponents(root=" + this.f16329a + ", segments=" + this.f16330b + ")";
    }
}
