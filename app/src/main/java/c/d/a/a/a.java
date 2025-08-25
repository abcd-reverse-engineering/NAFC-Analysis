package c.d.a.a;

import c.d.a.a.f.a;
import java.nio.ByteBuffer;

/* compiled from: ApkSectionInfo.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public boolean f3142a = false;

    /* renamed from: b, reason: collision with root package name */
    public long f3143b;

    /* renamed from: c, reason: collision with root package name */
    public c<ByteBuffer, Long> f3144c;

    /* renamed from: d, reason: collision with root package name */
    public c<ByteBuffer, Long> f3145d;

    /* renamed from: e, reason: collision with root package name */
    public c<ByteBuffer, Long> f3146e;

    /* renamed from: f, reason: collision with root package name */
    public c<ByteBuffer, Long> f3147f;

    public void a() throws a.c {
        long jA = c.d.a.a.f.a.a(this.f3147f.a(), this.f3147f.b().longValue());
        if (jA == this.f3146e.b().longValue()) {
            return;
        }
        throw new RuntimeException("CentralDirOffset mismatch , EocdCentralDirOffset : " + jA + ", centralDirOffset : " + this.f3146e.b());
    }

    public void b() throws a.c {
        if ((!this.f3142a && this.f3144c == null) || this.f3145d == null || this.f3146e == null || this.f3147f == null) {
            throw new RuntimeException("ApkSectionInfo paramters is not valid : " + toString());
        }
        if ((this.f3142a || (this.f3144c.b().longValue() == 0 && ((long) this.f3144c.a().remaining()) + this.f3144c.b().longValue() == this.f3145d.b().longValue())) && ((long) this.f3145d.a().remaining()) + this.f3145d.b().longValue() == this.f3146e.b().longValue() && ((long) this.f3146e.a().remaining()) + this.f3146e.b().longValue() == this.f3147f.b().longValue() && ((long) this.f3147f.a().remaining()) + this.f3147f.b().longValue() == this.f3143b) {
            a();
            return;
        }
        throw new RuntimeException("ApkSectionInfo paramters is not valid : " + toString());
    }

    public void c() {
        c<ByteBuffer, Long> cVar = this.f3144c;
        if (cVar != null) {
            cVar.a().rewind();
        }
        c<ByteBuffer, Long> cVar2 = this.f3145d;
        if (cVar2 != null) {
            cVar2.a().rewind();
        }
        c<ByteBuffer, Long> cVar3 = this.f3146e;
        if (cVar3 != null) {
            cVar3.a().rewind();
        }
        c<ByteBuffer, Long> cVar4 = this.f3147f;
        if (cVar4 != null) {
            cVar4.a().rewind();
        }
    }

    public String toString() {
        return "lowMemory : " + this.f3142a + "\n apkSize : " + this.f3143b + "\n contentEntry : " + this.f3144c + "\n schemeV2Block : " + this.f3145d + "\n centralDir : " + this.f3146e + "\n eocd : " + this.f3147f;
    }
}
