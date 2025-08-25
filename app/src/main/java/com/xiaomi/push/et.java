package com.xiaomi.push;

import android.text.TextUtils;
import com.xiaomi.push.dp;
import java.io.BufferedInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.zip.Adler32;

/* loaded from: classes2.dex */
class et {

    /* renamed from: a, reason: collision with other field name */
    private ey f468a;

    /* renamed from: a, reason: collision with other field name */
    private InputStream f469a;

    /* renamed from: a, reason: collision with other field name */
    private volatile boolean f472a;

    /* renamed from: a, reason: collision with other field name */
    private byte[] f473a;

    /* renamed from: a, reason: collision with other field name */
    private ByteBuffer f470a = ByteBuffer.allocate(2048);

    /* renamed from: b, reason: collision with root package name */
    private ByteBuffer f12788b = ByteBuffer.allocate(4);

    /* renamed from: a, reason: collision with other field name */
    private Adler32 f471a = new Adler32();

    /* renamed from: a, reason: collision with root package name */
    private ew f12787a = new ew();

    et(InputStream inputStream, ey eyVar) {
        this.f469a = new BufferedInputStream(inputStream);
        this.f468a = eyVar;
    }

    private void c() throws IOException {
        boolean z = false;
        this.f472a = false;
        er erVarM401a = m401a();
        if ("CONN".equals(erVarM401a.m390a())) {
            dp.f fVarA = dp.f.a(erVarM401a.m394a());
            if (fVarA.m332a()) {
                this.f468a.a(fVarA.m331a());
                z = true;
            }
            if (fVarA.c()) {
                dp.b bVarM330a = fVarA.m330a();
                er erVar = new er();
                erVar.a("SYNC", "CONF");
                erVar.a(bVarM330a.m374a(), (String) null);
                this.f468a.a(erVar);
            }
            com.xiaomi.channel.commonutils.logger.b.m50a("[Slim] CONN: host = " + fVarA.m333b());
        }
        if (!z) {
            com.xiaomi.channel.commonutils.logger.b.m50a("[Slim] Invalid CONN");
            throw new IOException("Invalid Connection");
        }
        this.f473a = this.f468a.m408a();
        while (!this.f472a) {
            er erVarM401a2 = m401a();
            long jCurrentTimeMillis = System.currentTimeMillis();
            this.f468a.c();
            short sM392a = erVarM401a2.m392a();
            if (sM392a == 1) {
                this.f468a.a(erVarM401a2);
            } else if (sM392a != 2) {
                if (sM392a != 3) {
                    com.xiaomi.channel.commonutils.logger.b.m50a("[Slim] unknow blob type " + ((int) erVarM401a2.m392a()));
                } else {
                    try {
                        this.f468a.b(this.f12787a.a(erVarM401a2.m394a(), this.f468a));
                    } catch (Exception e2) {
                        com.xiaomi.channel.commonutils.logger.b.m50a("[Slim] Parse packet from Blob chid=" + erVarM401a2.a() + "; Id=" + erVarM401a2.e() + " failure:" + e2.getMessage());
                    }
                }
            } else if ("SECMSG".equals(erVarM401a2.m390a()) && ((erVarM401a2.a() == 2 || erVarM401a2.a() == 3) && TextUtils.isEmpty(erVarM401a2.m397b()))) {
                try {
                    fo foVarA = this.f12787a.a(erVarM401a2.m395a(com.xiaomi.push.service.am.a().a(Integer.valueOf(erVarM401a2.a()).toString(), erVarM401a2.g()).f13351h), this.f468a);
                    foVarA.f529a = jCurrentTimeMillis;
                    this.f468a.b(foVarA);
                } catch (Exception e3) {
                    com.xiaomi.channel.commonutils.logger.b.m50a("[Slim] Parse packet from Blob chid=" + erVarM401a2.a() + "; Id=" + erVarM401a2.e() + " failure:" + e3.getMessage());
                }
            } else {
                this.f468a.a(erVarM401a2);
            }
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    void m402a() throws IOException {
        try {
            c();
        } catch (IOException e2) {
            if (!this.f472a) {
                throw e2;
            }
        }
    }

    void b() {
        this.f472a = true;
    }

    private ByteBuffer a() throws IOException {
        this.f470a.clear();
        a(this.f470a, 8);
        short s = this.f470a.getShort(0);
        short s2 = this.f470a.getShort(2);
        if (s == -15618 && s2 == 5) {
            int i2 = this.f470a.getInt(4);
            int iPosition = this.f470a.position();
            if (i2 <= 32768) {
                if (i2 + 4 > this.f470a.remaining()) {
                    ByteBuffer byteBufferAllocate = ByteBuffer.allocate(i2 + 2048);
                    byteBufferAllocate.put(this.f470a.array(), 0, this.f470a.arrayOffset() + this.f470a.position());
                    this.f470a = byteBufferAllocate;
                } else if (this.f470a.capacity() > 4096 && i2 < 2048) {
                    ByteBuffer byteBufferAllocate2 = ByteBuffer.allocate(2048);
                    byteBufferAllocate2.put(this.f470a.array(), 0, this.f470a.arrayOffset() + this.f470a.position());
                    this.f470a = byteBufferAllocate2;
                }
                a(this.f470a, i2);
                this.f12788b.clear();
                a(this.f12788b, 4);
                this.f12788b.position(0);
                int i3 = this.f12788b.getInt();
                this.f471a.reset();
                this.f471a.update(this.f470a.array(), 0, this.f470a.position());
                if (i3 == ((int) this.f471a.getValue())) {
                    byte[] bArr = this.f473a;
                    if (bArr != null) {
                        com.xiaomi.push.service.ar.a(bArr, this.f470a.array(), true, iPosition, i2);
                    }
                    return this.f470a;
                }
                com.xiaomi.channel.commonutils.logger.b.m50a("CRC = " + ((int) this.f471a.getValue()) + " and " + i3);
                throw new IOException("Corrupted Blob bad CRC");
            }
            throw new IOException("Blob size too large");
        }
        throw new IOException("Malformed Input");
    }

    /* renamed from: a, reason: collision with other method in class */
    er m401a() throws IOException {
        int iPosition;
        er erVarA;
        try {
            ByteBuffer byteBufferA = a();
            iPosition = byteBufferA.position();
            try {
                byteBufferA.flip();
                byteBufferA.position(8);
                if (iPosition == 8) {
                    erVarA = new ex();
                } else {
                    erVarA = er.a(byteBufferA.slice());
                }
                com.xiaomi.channel.commonutils.logger.b.c("[Slim] Read {cmd=" + erVarA.m390a() + ";chid=" + erVarA.a() + ";len=" + iPosition + "}");
                return erVarA;
            } catch (IOException e2) {
                e = e2;
                if (iPosition == 0) {
                    iPosition = this.f470a.position();
                }
                StringBuilder sb = new StringBuilder();
                sb.append("[Slim] read Blob [");
                byte[] bArrArray = this.f470a.array();
                if (iPosition > 128) {
                    iPosition = 128;
                }
                sb.append(ab.a(bArrArray, 0, iPosition));
                sb.append("] Err:");
                sb.append(e.getMessage());
                com.xiaomi.channel.commonutils.logger.b.m50a(sb.toString());
                throw e;
            }
        } catch (IOException e3) {
            e = e3;
            iPosition = 0;
        }
    }

    private void a(ByteBuffer byteBuffer, int i2) throws IOException {
        int iPosition = byteBuffer.position();
        do {
            int i3 = this.f469a.read(byteBuffer.array(), iPosition, i2);
            if (i3 == -1) {
                throw new EOFException();
            }
            i2 -= i3;
            iPosition += i3;
        } while (i2 > 0);
        byteBuffer.position(iPosition);
    }
}
