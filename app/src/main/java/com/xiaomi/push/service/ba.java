package com.xiaomi.push.service;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.push.gj;
import com.xiaomi.push.hp;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.Arrays;

/* loaded from: classes2.dex */
public class ba {

    /* renamed from: a, reason: collision with root package name */
    public static final Object f13409a = new Object();

    public static void a(final Context context, final gj gjVar) {
        if (az.a(gjVar.e())) {
            com.xiaomi.push.ae.a(context).a(new Runnable() { // from class: com.xiaomi.push.service.ba.1
                @Override // java.lang.Runnable
                public void run() {
                    RandomAccessFile randomAccessFile;
                    synchronized (ba.f13409a) {
                        FileLock fileLockLock = null;
                        try {
                            File file = new File(context.getFilesDir(), "tiny_data.lock");
                            com.xiaomi.push.w.m765a(file);
                            randomAccessFile = new RandomAccessFile(file, "rw");
                        } catch (Exception e2) {
                            e = e2;
                            randomAccessFile = null;
                        } catch (Throwable th) {
                            th = th;
                            randomAccessFile = null;
                            if (fileLockLock != null) {
                                try {
                                    fileLockLock.release();
                                } catch (IOException e3) {
                                    com.xiaomi.channel.commonutils.logger.b.a(e3);
                                }
                            }
                            com.xiaomi.push.w.a(randomAccessFile);
                            throw th;
                        }
                        try {
                            try {
                                fileLockLock = randomAccessFile.getChannel().lock();
                                ba.c(context, gjVar);
                                if (fileLockLock != null && fileLockLock.isValid()) {
                                    try {
                                        fileLockLock.release();
                                    } catch (IOException e4) {
                                        com.xiaomi.channel.commonutils.logger.b.a(e4);
                                    }
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                if (fileLockLock != null && fileLockLock.isValid()) {
                                    fileLockLock.release();
                                }
                                com.xiaomi.push.w.a(randomAccessFile);
                                throw th;
                            }
                        } catch (Exception e5) {
                            e = e5;
                            com.xiaomi.channel.commonutils.logger.b.a(e);
                            if (fileLockLock != null && fileLockLock.isValid()) {
                                try {
                                    fileLockLock.release();
                                } catch (IOException e6) {
                                    com.xiaomi.channel.commonutils.logger.b.a(e6);
                                }
                            }
                            com.xiaomi.push.w.a(randomAccessFile);
                        }
                        com.xiaomi.push.w.a(randomAccessFile);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [byte[]] */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v19 */
    /* JADX WARN: Type inference failed for: r0v20 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r0v7, types: [java.io.Closeable] */
    public static void c(Context context, gj gjVar) throws Throwable {
        BufferedOutputStream bufferedOutputStream;
        BufferedOutputStream bufferedOutputStream2;
        ?? A = a(context);
        try {
            try {
                byte[] bArrB = com.xiaomi.push.h.b(A, hp.a(gjVar));
                if (bArrB == null || bArrB.length < 1) {
                    com.xiaomi.channel.commonutils.logger.b.m50a("TinyData write to cache file failed case encryption fail item:" + gjVar.d() + "  ts:" + System.currentTimeMillis());
                } else {
                    if (bArrB.length <= 30720) {
                        BufferedOutputStream bufferedOutputStream3 = new BufferedOutputStream(new FileOutputStream(new File(context.getFilesDir(), "tiny_data.data"), true));
                        try {
                            bufferedOutputStream3.write(com.xiaomi.push.y.a(bArrB.length));
                            bufferedOutputStream3.write(bArrB);
                            bufferedOutputStream3.flush();
                            com.xiaomi.push.w.a((Closeable) null);
                            com.xiaomi.push.w.a(bufferedOutputStream3);
                            return;
                        } catch (IOException e2) {
                            bufferedOutputStream2 = bufferedOutputStream3;
                            e = e2;
                            com.xiaomi.channel.commonutils.logger.b.a("TinyData write to cache file failed cause io exception item:" + gjVar.d(), e);
                            A = bufferedOutputStream2;
                            com.xiaomi.push.w.a((Closeable) null);
                            com.xiaomi.push.w.a((Closeable) A);
                            return;
                        } catch (Exception e3) {
                            bufferedOutputStream = bufferedOutputStream3;
                            e = e3;
                            com.xiaomi.channel.commonutils.logger.b.a("TinyData write to cache file  failed item:" + gjVar.d(), e);
                            A = bufferedOutputStream;
                            com.xiaomi.push.w.a((Closeable) null);
                            com.xiaomi.push.w.a((Closeable) A);
                            return;
                        } catch (Throwable th) {
                            A = bufferedOutputStream3;
                            th = th;
                            com.xiaomi.push.w.a((Closeable) null);
                            com.xiaomi.push.w.a((Closeable) A);
                            throw th;
                        }
                    }
                    com.xiaomi.channel.commonutils.logger.b.m50a("TinyData write to cache file failed case too much data content item:" + gjVar.d() + "  ts:" + System.currentTimeMillis());
                }
                com.xiaomi.push.w.a((Closeable) null);
                com.xiaomi.push.w.a((Closeable) null);
            } catch (IOException e4) {
                e = e4;
                bufferedOutputStream2 = null;
            } catch (Exception e5) {
                e = e5;
                bufferedOutputStream = null;
            } catch (Throwable th2) {
                th = th2;
                A = 0;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public static byte[] a(Context context) {
        String strA = com.xiaomi.push.o.a(context).a("mipush", "td_key", "");
        if (TextUtils.isEmpty(strA)) {
            strA = com.xiaomi.push.bb.a(20);
            com.xiaomi.push.o.a(context).m635a("mipush", "td_key", strA);
        }
        return a(strA);
    }

    private static byte[] a(String str) {
        byte[] bArrCopyOf = Arrays.copyOf(com.xiaomi.push.ay.m161a(str), 16);
        bArrCopyOf[0] = 68;
        bArrCopyOf[15] = 84;
        return bArrCopyOf;
    }
}
