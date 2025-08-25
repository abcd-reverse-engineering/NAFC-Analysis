package c.d.a.a;

import c.d.a.a.f.a;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: V2SchemeUtil.java */
/* loaded from: classes.dex */
public class e {
    public static Map<Integer, ByteBuffer> a(ByteBuffer byteBuffer) throws a.c {
        c.d.a.a.f.a.a(byteBuffer);
        ByteBuffer byteBufferA = c.d.a.a.f.a.a(byteBuffer, 8, byteBuffer.capacity() - 24);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int i2 = 0;
        while (byteBufferA.hasRemaining()) {
            i2++;
            if (byteBufferA.remaining() < 8) {
                throw new a.c("Insufficient data to read size of APK Signing Block entry #" + i2);
            }
            long j2 = byteBufferA.getLong();
            if (j2 < 4 || j2 > 2147483647L) {
                throw new a.c("APK Signing Block entry #" + i2 + " size out of range: " + j2);
            }
            int i3 = (int) j2;
            int iPosition = byteBufferA.position() + i3;
            if (i3 > byteBufferA.remaining()) {
                throw new a.c("APK Signing Block entry #" + i2 + " size out of range: " + i3 + ", available: " + byteBufferA.remaining());
            }
            int i4 = byteBufferA.getInt();
            linkedHashMap.put(Integer.valueOf(i4), c.d.a.a.f.a.a(byteBufferA, i3 - 4));
            if (i4 == 1896449818) {
                System.out.println("find V2 signature block Id : 1896449818");
            }
            byteBufferA.position(iPosition);
        }
        if (!linkedHashMap.isEmpty()) {
            return linkedHashMap;
        }
        throw new a.c("not have Id-Value Pair in APK Signing Block entry #" + i2);
    }

    public static ByteBuffer b(File file) throws Throwable {
        RandomAccessFile randomAccessFile;
        if (file == null || !file.exists() || !file.isFile()) {
            return null;
        }
        try {
            randomAccessFile = new RandomAccessFile(file, "r");
        } catch (Throwable th) {
            th = th;
            randomAccessFile = null;
        }
        try {
            c<ByteBuffer, Long> cVarB = c.d.a.a.f.a.b(randomAccessFile);
            ByteBuffer byteBufferA = cVarB.a();
            long jLongValue = cVarB.b().longValue();
            if (c.d.a.a.f.b.a(randomAccessFile, jLongValue)) {
                throw new a.c("ZIP64 APK not supported");
            }
            ByteBuffer byteBufferA2 = c.d.a.a.f.a.a(randomAccessFile, c.d.a.a.f.a.a(byteBufferA, jLongValue)).a();
            randomAccessFile.close();
            return byteBufferA2;
        } catch (Throwable th2) {
            th = th2;
            if (randomAccessFile != null) {
                randomAccessFile.close();
            }
            throw th;
        }
    }

    private static ByteBuffer b(RandomAccessFile randomAccessFile, long j2, int i2) throws IOException {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(i2);
        byteBufferAllocate.order(ByteOrder.LITTLE_ENDIAN);
        randomAccessFile.seek(j2);
        randomAccessFile.readFully(byteBufferAllocate.array(), byteBufferAllocate.arrayOffset(), byteBufferAllocate.capacity());
        return byteBufferAllocate;
    }

    public static a a(File file, boolean z) throws Throwable {
        RandomAccessFile randomAccessFile;
        try {
            randomAccessFile = new RandomAccessFile(file, "r");
        } catch (Throwable th) {
            th = th;
            randomAccessFile = null;
        }
        try {
            c<ByteBuffer, Long> cVarB = c.d.a.a.f.a.b(randomAccessFile);
            ByteBuffer byteBufferA = cVarB.a();
            long jLongValue = cVarB.b().longValue();
            if (!c.d.a.a.f.b.a(randomAccessFile, jLongValue)) {
                long jA = c.d.a.a.f.a.a(byteBufferA, jLongValue);
                c<ByteBuffer, Long> cVarA = c.d.a.a.f.a.a(randomAccessFile, jA);
                c<ByteBuffer, Long> cVarA2 = a(randomAccessFile, jA, (int) (jLongValue - jA));
                a aVar = new a();
                aVar.f3142a = z;
                aVar.f3143b = file.length();
                if (!z) {
                    aVar.f3144c = a(randomAccessFile, (int) cVarA.b().longValue());
                }
                aVar.f3145d = cVarA;
                aVar.f3146e = cVarA2;
                aVar.f3147f = cVarB;
                aVar.b();
                System.out.println("baseApk : " + file.getAbsolutePath() + "\nApkSectionInfo = " + aVar);
                randomAccessFile.close();
                return aVar;
            }
            throw new a.c("ZIP64 APK not supported");
        } catch (Throwable th2) {
            th = th2;
            if (randomAccessFile != null) {
                randomAccessFile.close();
            }
            throw th;
        }
    }

    public static c<ByteBuffer, Long> a(RandomAccessFile randomAccessFile, long j2, int i2) throws IOException {
        return c.a(b(randomAccessFile, j2, i2), Long.valueOf(j2));
    }

    public static c<ByteBuffer, Long> a(RandomAccessFile randomAccessFile, int i2) throws IOException {
        return c.a(b(randomAccessFile, 0L, i2), 0L);
    }

    public static ByteBuffer a(Map<Integer, ByteBuffer> map) {
        if (map != null && !map.isEmpty()) {
            long jRemaining = 24;
            while (map.entrySet().iterator().hasNext()) {
                jRemaining += r2.next().getValue().remaining() + 12;
            }
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate((int) (8 + jRemaining));
            byteBufferAllocate.order(ByteOrder.LITTLE_ENDIAN);
            byteBufferAllocate.putLong(jRemaining);
            for (Map.Entry<Integer, ByteBuffer> entry : map.entrySet()) {
                ByteBuffer value = entry.getValue();
                byteBufferAllocate.putLong(value.remaining() + 4);
                byteBufferAllocate.putInt(entry.getKey().intValue());
                byteBufferAllocate.put(value.array(), value.arrayOffset() + value.position(), value.remaining());
            }
            byteBufferAllocate.putLong(jRemaining);
            byteBufferAllocate.putLong(c.d.a.a.f.a.n);
            byteBufferAllocate.putLong(c.d.a.a.f.a.f3166m);
            if (byteBufferAllocate.remaining() <= 0) {
                byteBufferAllocate.flip();
                return byteBufferAllocate;
            }
            throw new RuntimeException("generateNewApkV2SchemeBlock error");
        }
        throw new RuntimeException("getNewApkV2SchemeBlock , id value pair is empty");
    }

    public static boolean a(String str) throws Exception {
        return c.d.a.a.f.a.a(str);
    }

    public static boolean a(File file) {
        try {
            return a(b(file)).containsKey(Integer.valueOf(c.d.a.a.f.a.p));
        } catch (a.c unused) {
            System.out.println("APK : " + file.getAbsolutePath() + " not have apk signature block");
            return false;
        } catch (IOException e2) {
            e2.printStackTrace();
            return false;
        }
    }
}
