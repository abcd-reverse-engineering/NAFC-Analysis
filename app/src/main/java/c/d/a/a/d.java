package c.d.a.a;

import c.d.a.a.f.a;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;

/* compiled from: V1SchemeUtil.java */
/* loaded from: classes.dex */
public class d {

    /* compiled from: V1SchemeUtil.java */
    public static class a extends Exception {
        static final long serialVersionUID = -3387516993124229949L;

        public a() {
        }

        public a(String str) {
            super(str);
        }
    }

    public static void a(File file, String str) throws Exception {
        RandomAccessFile randomAccessFile;
        RandomAccessFile randomAccessFile2;
        if (file == null || !file.exists() || !file.isFile() || str == null || str.isEmpty()) {
            throw new Exception("param error , file : " + file + " , channel : " + str);
        }
        byte[] bytes = str.getBytes("UTF-8");
        c<ByteBuffer, Long> cVarC = c(file);
        if (cVarC.a().remaining() == 22) {
            System.out.println("file : " + file.getAbsolutePath() + " , has no comment");
            try {
                randomAccessFile2 = new RandomAccessFile(file, "rw");
            } catch (Throwable th) {
                th = th;
                randomAccessFile2 = null;
            }
            try {
                randomAccessFile2.seek(file.length() - 2);
                a(bytes.length + 2 + b.f3151d.length, randomAccessFile2);
                randomAccessFile2.write(bytes);
                a(bytes.length, randomAccessFile2);
                randomAccessFile2.write(b.f3151d);
                randomAccessFile2.close();
                return;
            } catch (Throwable th2) {
                th = th2;
                if (randomAccessFile2 != null) {
                    randomAccessFile2.close();
                }
                throw th;
            }
        }
        System.out.println("file : " + file.getAbsolutePath() + " , has comment");
        if (a(file)) {
            try {
                String strD = d(file);
                if (strD != null) {
                    file.delete();
                    throw new a("file : " + file.getAbsolutePath() + " has a channel : " + strD + ", only ignore");
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        int iA = c.d.a.a.f.b.a(cVarC.a(), 20);
        int length = bytes.length + iA + 2 + b.f3151d.length;
        try {
            randomAccessFile = new RandomAccessFile(file, "rw");
        } catch (Throwable th3) {
            th = th3;
            randomAccessFile = null;
        }
        try {
            randomAccessFile.seek((cVarC.b().longValue() + 22) - 2);
            a(length, randomAccessFile);
            randomAccessFile.seek(cVarC.b().longValue() + 22 + iA);
            randomAccessFile.write(bytes);
            a(bytes.length, randomAccessFile);
            randomAccessFile.write(b.f3151d);
            randomAccessFile.close();
        } catch (Throwable th4) {
            th = th4;
            if (randomAccessFile != null) {
                randomAccessFile.close();
            }
            throw th;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0028, code lost:
    
        r1 = r0.getJarEntry(r3.getName());
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean b(java.io.File r6) {
        /*
            java.util.jar.JarFile r0 = new java.util.jar.JarFile     // Catch: java.io.IOException -> L36
            r0.<init>(r6)     // Catch: java.io.IOException -> L36
            java.lang.String r6 = "META-INF/MANIFEST.MF"
            java.util.jar.JarEntry r6 = r0.getJarEntry(r6)     // Catch: java.io.IOException -> L36
            r1 = 0
            java.util.Enumeration r2 = r0.entries()     // Catch: java.io.IOException -> L36
        L10:
            boolean r3 = r2.hasMoreElements()     // Catch: java.io.IOException -> L36
            if (r3 == 0) goto L30
            java.lang.Object r3 = r2.nextElement()     // Catch: java.io.IOException -> L36
            java.util.jar.JarEntry r3 = (java.util.jar.JarEntry) r3     // Catch: java.io.IOException -> L36
            java.lang.String r4 = r3.getName()     // Catch: java.io.IOException -> L36
            java.lang.String r5 = "META-INF/\\w+\\.SF"
            boolean r4 = r4.matches(r5)     // Catch: java.io.IOException -> L36
            if (r4 == 0) goto L10
            java.lang.String r1 = r3.getName()     // Catch: java.io.IOException -> L36
            java.util.jar.JarEntry r1 = r0.getJarEntry(r1)     // Catch: java.io.IOException -> L36
        L30:
            if (r6 == 0) goto L3a
            if (r1 == 0) goto L3a
            r6 = 1
            return r6
        L36:
            r6 = move-exception
            r6.printStackTrace()
        L3a:
            r6 = 0
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: c.d.a.a.d.b(java.io.File):boolean");
    }

    public static c<ByteBuffer, Long> c(File file) throws Throwable {
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
            if (c.d.a.a.f.b.a(randomAccessFile, cVarB.b().longValue())) {
                throw new a.c("ZIP64 APK not supported");
            }
            randomAccessFile.close();
            return cVarB;
        } catch (Throwable th2) {
            th = th2;
            if (randomAccessFile != null) {
                randomAccessFile.close();
            }
            throw th;
        }
    }

    public static String d(File file) throws Exception {
        RandomAccessFile randomAccessFile;
        try {
            randomAccessFile = new RandomAccessFile(file, "r");
        } catch (Throwable th) {
            th = th;
            randomAccessFile = null;
        }
        try {
            long length = randomAccessFile.length();
            byte[] bArr = new byte[b.f3151d.length];
            long length2 = length - b.f3151d.length;
            randomAccessFile.seek(length2);
            randomAccessFile.readFully(bArr);
            if (!a(bArr)) {
                throw new Exception("zip v1 magic not found");
            }
            long j2 = length2 - 2;
            randomAccessFile.seek(j2);
            int iA = a(randomAccessFile);
            if (iA <= 0) {
                throw new Exception("zip channel info not found");
            }
            randomAccessFile.seek(j2 - iA);
            byte[] bArr2 = new byte[iA];
            randomAccessFile.readFully(bArr2);
            String str = new String(bArr2, "UTF-8");
            randomAccessFile.close();
            return str;
        } catch (Throwable th2) {
            th = th2;
            if (randomAccessFile != null) {
                randomAccessFile.close();
            }
            throw th;
        }
    }

    private static void a(int i2, DataOutput dataOutput) throws IOException {
        ByteBuffer byteBufferOrder = ByteBuffer.allocate(2).order(ByteOrder.LITTLE_ENDIAN);
        byteBufferOrder.putShort((short) i2);
        dataOutput.write(byteBufferOrder.array());
    }

    private static short a(DataInput dataInput) throws IOException {
        byte[] bArr = new byte[2];
        dataInput.readFully(bArr);
        return ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN).getShort(0);
    }

    public static boolean a(File file) throws Throwable {
        RandomAccessFile randomAccessFile;
        try {
            randomAccessFile = new RandomAccessFile(file, "r");
        } catch (Throwable th) {
            th = th;
            randomAccessFile = null;
        }
        try {
            long length = randomAccessFile.length();
            byte[] bArr = new byte[b.f3151d.length];
            randomAccessFile.seek(length - b.f3151d.length);
            randomAccessFile.readFully(bArr);
            boolean zA = a(bArr);
            randomAccessFile.close();
            return zA;
        } catch (Throwable th2) {
            th = th2;
            if (randomAccessFile != null) {
                randomAccessFile.close();
            }
            throw th;
        }
    }

    private static boolean a(byte[] bArr) {
        if (bArr.length != b.f3151d.length) {
            return false;
        }
        int i2 = 0;
        while (true) {
            byte[] bArr2 = b.f3151d;
            if (i2 >= bArr2.length) {
                return true;
            }
            if (bArr[i2] != bArr2[i2]) {
                return false;
            }
            i2++;
        }
    }

    public static void a(File file, File file2) throws Throwable {
        FileChannel channel;
        FileChannel channel2;
        if (!file2.exists()) {
            file2.createNewFile();
        }
        FileChannel fileChannel = null;
        try {
            channel2 = new FileInputStream(file).getChannel();
            try {
                channel = new FileOutputStream(file2).getChannel();
            } catch (Throwable th) {
                fileChannel = channel2;
                th = th;
                channel = null;
            }
        } catch (Throwable th2) {
            th = th2;
            channel = null;
        }
        try {
            channel.transferFrom(channel2, 0L, channel2.size());
            if (channel2 != null) {
                channel2.close();
            }
            if (channel != null) {
                channel.close();
            }
        } catch (Throwable th3) {
            fileChannel = channel2;
            th = th3;
            if (fileChannel != null) {
                fileChannel.close();
            }
            if (channel != null) {
                channel.close();
            }
            throw th;
        }
    }
}
