package com.xiaomi.push;

import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.push.dp;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
public class er {

    /* renamed from: a, reason: collision with other field name */
    int f462a;

    /* renamed from: a, reason: collision with other field name */
    private dp.a f463a;

    /* renamed from: a, reason: collision with other field name */
    String f464a;

    /* renamed from: a, reason: collision with other field name */
    private short f465a;

    /* renamed from: b, reason: collision with other field name */
    private final long f466b;

    /* renamed from: b, reason: collision with other field name */
    private byte[] f467b;

    /* renamed from: b, reason: collision with root package name */
    private static String f12785b = fx.a(5) + Constants.ACCEPT_TIME_SEPARATOR_SERVER;

    /* renamed from: a, reason: collision with root package name */
    private static long f12784a = 0;

    /* renamed from: a, reason: collision with other field name */
    private static final byte[] f461a = new byte[0];

    public er() {
        this.f465a = (short) 2;
        this.f467b = f461a;
        this.f464a = null;
        this.f466b = System.currentTimeMillis();
        this.f463a = new dp.a();
        this.f462a = 1;
    }

    public static synchronized String d() {
        StringBuilder sb;
        sb = new StringBuilder();
        sb.append(f12785b);
        long j2 = f12784a;
        f12784a = 1 + j2;
        sb.append(Long.toString(j2));
        return sb.toString();
    }

    /* renamed from: a, reason: collision with other method in class */
    public long m389a() {
        return this.f466b;
    }

    /* renamed from: b, reason: collision with other method in class */
    public String m397b() {
        return this.f463a.m291d();
    }

    /* renamed from: c, reason: collision with other method in class */
    public String m400c() {
        return this.f463a.m295f();
    }

    public String e() {
        String strM293e = this.f463a.m293e();
        if ("ID_NOT_AVAILABLE".equals(strM293e)) {
            return null;
        }
        if (this.f463a.g()) {
            return strM293e;
        }
        String strD = d();
        this.f463a.e(strD);
        return strD;
    }

    public String f() {
        return this.f464a;
    }

    public String g() {
        if (!this.f463a.m287b()) {
            return null;
        }
        return Long.toString(this.f463a.m281a()) + "@" + this.f463a.m283a() + "/" + this.f463a.m286b();
    }

    public String toString() {
        return "Blob [chid=" + a() + "; Id=" + com.xiaomi.push.service.aj.a(e()) + "; cmd=" + m390a() + "; type=" + ((int) m392a()) + "; from=" + g() + " ]";
    }

    public void a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("command should not be empty");
        }
        this.f463a.c(str);
        this.f463a.m282a();
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        this.f463a.d(str2);
    }

    public int b() {
        return this.f463a.f();
    }

    public void c(long j2) {
        this.f463a.c(j2);
    }

    /* renamed from: b, reason: collision with other method in class */
    public boolean m398b() {
        return this.f463a.l();
    }

    /* renamed from: c, reason: collision with other method in class */
    public long m399c() {
        return this.f463a.m281a();
    }

    public void b(long j2) {
        this.f463a.b(j2);
    }

    public void c(String str) throws NumberFormatException {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        int iIndexOf = str.indexOf("@");
        try {
            long j2 = Long.parseLong(str.substring(0, iIndexOf));
            int iIndexOf2 = str.indexOf("/", iIndexOf);
            String strSubstring = str.substring(iIndexOf + 1, iIndexOf2);
            String strSubstring2 = str.substring(iIndexOf2 + 1);
            this.f463a.a(j2);
            this.f463a.a(strSubstring);
            this.f463a.b(strSubstring2);
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.m50a("Blob parse user err " + e2.getMessage());
        }
    }

    /* renamed from: b, reason: collision with other method in class */
    public long m396b() {
        return this.f463a.m285b();
    }

    public void b(String str) {
        this.f464a = str;
    }

    er(dp.a aVar, short s, byte[] bArr) {
        this.f465a = (short) 2;
        this.f467b = f461a;
        this.f464a = null;
        this.f466b = System.currentTimeMillis();
        this.f463a = aVar;
        this.f465a = s;
        this.f467b = bArr;
        this.f462a = 2;
    }

    /* renamed from: a, reason: collision with other method in class */
    public String m390a() {
        return this.f463a.m289c();
    }

    public void a(int i2) {
        this.f463a.a(i2);
    }

    public int a() {
        return this.f463a.c();
    }

    public void a(String str) {
        this.f463a.e(str);
    }

    public void a(long j2) {
        this.f463a.a(j2);
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m393a() {
        return this.f463a.j();
    }

    public void a(long j2, String str, String str2) {
        if (j2 != 0) {
            this.f463a.a(j2);
        }
        if (!TextUtils.isEmpty(str)) {
            this.f463a.a(str);
        }
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        this.f463a.b(str2);
    }

    public int c() {
        return this.f463a.b() + 8 + this.f467b.length;
    }

    public void a(byte[] bArr, String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f463a.c(1);
            this.f467b = com.xiaomi.push.service.ar.a(com.xiaomi.push.service.ar.a(str, e()), bArr);
        } else {
            this.f463a.c(0);
            this.f467b = bArr;
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public byte[] m394a() {
        return es.a(this, this.f467b);
    }

    /* renamed from: a, reason: collision with other method in class */
    public byte[] m395a(String str) {
        if (this.f463a.e() == 1) {
            return es.a(this, com.xiaomi.push.service.ar.a(com.xiaomi.push.service.ar.a(str, e()), this.f467b));
        }
        if (this.f463a.e() == 0) {
            return es.a(this, this.f467b);
        }
        com.xiaomi.channel.commonutils.logger.b.m50a("unknow cipher = " + this.f463a.e());
        return es.a(this, this.f467b);
    }

    @Deprecated
    public static er a(fo foVar, String str) throws NumberFormatException {
        int i2;
        er erVar = new er();
        try {
            i2 = Integer.parseInt(foVar.k());
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.m50a("Blob parse chid err " + e2.getMessage());
            i2 = 1;
        }
        erVar.a(i2);
        erVar.a(foVar.j());
        erVar.c(foVar.m());
        erVar.b(foVar.n());
        erVar.a("XMLMSG", (String) null);
        try {
            erVar.a(foVar.mo431a().getBytes("utf8"), str);
            if (TextUtils.isEmpty(str)) {
                erVar.a((short) 3);
            } else {
                erVar.a((short) 2);
                erVar.a("SECMSG", (String) null);
            }
        } catch (UnsupportedEncodingException e3) {
            com.xiaomi.channel.commonutils.logger.b.m50a("Blob setPayload err： " + e3.getMessage());
        }
        return erVar;
    }

    /* renamed from: a, reason: collision with other method in class */
    ByteBuffer mo391a(ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            byteBuffer = ByteBuffer.allocate(c());
        }
        byteBuffer.putShort(this.f465a);
        byteBuffer.putShort((short) this.f463a.a());
        byteBuffer.putInt(this.f467b.length);
        int iPosition = byteBuffer.position();
        this.f463a.m373a(byteBuffer.array(), byteBuffer.arrayOffset() + iPosition, this.f463a.a());
        byteBuffer.position(iPosition + this.f463a.a());
        byteBuffer.put(this.f467b);
        return byteBuffer;
    }

    static er a(ByteBuffer byteBuffer) throws IOException {
        try {
            ByteBuffer byteBufferSlice = byteBuffer.slice();
            short s = byteBufferSlice.getShort(0);
            short s2 = byteBufferSlice.getShort(2);
            int i2 = byteBufferSlice.getInt(4);
            dp.a aVar = new dp.a();
            aVar.a(byteBufferSlice.array(), byteBufferSlice.arrayOffset() + 8, (int) s2);
            byte[] bArr = new byte[i2];
            byteBufferSlice.position(s2 + 8);
            byteBufferSlice.get(bArr, 0, i2);
            return new er(aVar, s, bArr);
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.m50a("read Blob err :" + e2.getMessage());
            throw new IOException("Malformed Input");
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public short m392a() {
        return this.f465a;
    }

    public void a(short s) {
        this.f465a = s;
    }
}
