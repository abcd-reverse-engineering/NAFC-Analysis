package com.tencent.open.utils;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.ProtocolException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Properties;
import java.util.zip.ZipException;

/* compiled from: ProGuard */
/* loaded from: classes2.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private static final n f9902a = new n(101010256);

    /* renamed from: b, reason: collision with root package name */
    private static final o f9903b = new o(38651);

    /* compiled from: ProGuard */
    private static class a {

        /* renamed from: a, reason: collision with root package name */
        Properties f9904a;

        /* renamed from: b, reason: collision with root package name */
        byte[] f9905b;

        private a() {
            this.f9904a = new Properties();
        }

        void a(byte[] bArr) throws IOException {
            if (bArr == null) {
                return;
            }
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
            int length = b.f9903b.a().length;
            byte[] bArr2 = new byte[length];
            byteBufferWrap.get(bArr2);
            if (!b.f9903b.equals(new o(bArr2))) {
                throw new ProtocolException("unknow protocl [" + Arrays.toString(bArr) + "]");
            }
            if (bArr.length - length <= 2) {
                return;
            }
            byte[] bArr3 = new byte[2];
            byteBufferWrap.get(bArr3);
            int iB = new o(bArr3).b();
            if ((bArr.length - length) - 2 < iB) {
                return;
            }
            byte[] bArr4 = new byte[iB];
            byteBufferWrap.get(bArr4);
            this.f9904a.load(new ByteArrayInputStream(bArr4));
            int length2 = ((bArr.length - length) - iB) - 2;
            if (length2 > 0) {
                this.f9905b = new byte[length2];
                byteBufferWrap.get(this.f9905b);
            }
        }

        public String toString() {
            return "ApkExternalInfo [p=" + this.f9904a + ", otherData=" + Arrays.toString(this.f9905b) + "]";
        }
    }

    public static String a(File file, String str) throws Throwable {
        RandomAccessFile randomAccessFile;
        try {
            randomAccessFile = new RandomAccessFile(file, "r");
        } catch (Throwable th) {
            th = th;
            randomAccessFile = null;
        }
        try {
            byte[] bArrA = a(randomAccessFile);
            if (bArrA == null) {
                randomAccessFile.close();
                return null;
            }
            a aVar = new a();
            aVar.a(bArrA);
            String property = aVar.f9904a.getProperty(str);
            randomAccessFile.close();
            return property;
        } catch (Throwable th2) {
            th = th2;
            if (randomAccessFile != null) {
                randomAccessFile.close();
            }
            throw th;
        }
    }

    public static String a(File file) throws IOException {
        return a(file, "channelNo");
    }

    private static byte[] a(RandomAccessFile randomAccessFile) throws IOException {
        boolean z;
        long length = randomAccessFile.length() - 22;
        randomAccessFile.seek(length);
        byte[] bArrA = f9902a.a();
        int i2 = randomAccessFile.read();
        while (true) {
            z = true;
            if (i2 == -1) {
                z = false;
                break;
            }
            if (i2 == bArrA[0] && randomAccessFile.read() == bArrA[1] && randomAccessFile.read() == bArrA[2] && randomAccessFile.read() == bArrA[3]) {
                break;
            }
            length--;
            randomAccessFile.seek(length);
            i2 = randomAccessFile.read();
        }
        if (z) {
            randomAccessFile.seek(length + 16 + 4);
            byte[] bArr = new byte[2];
            randomAccessFile.readFully(bArr);
            int iB = new o(bArr).b();
            if (iB == 0) {
                return null;
            }
            byte[] bArr2 = new byte[iB];
            randomAccessFile.read(bArr2);
            return bArr2;
        }
        throw new ZipException("archive is not a ZIP archive");
    }
}
