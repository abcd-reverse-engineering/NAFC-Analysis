package com.xiaomi.push;

import android.content.Context;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes2.dex */
public final class t {

    /* renamed from: a, reason: collision with root package name */
    private static final Set<String> f13481a = Collections.synchronizedSet(new HashSet());

    /* renamed from: a, reason: collision with other field name */
    private Context f1101a;

    /* renamed from: a, reason: collision with other field name */
    private RandomAccessFile f1102a;

    /* renamed from: a, reason: collision with other field name */
    private String f1103a;

    /* renamed from: a, reason: collision with other field name */
    private FileLock f1104a;

    private t(Context context) {
        this.f1101a = context;
    }

    public static t a(Context context, File file) throws IOException {
        com.xiaomi.channel.commonutils.logger.b.c("Locking: " + file.getAbsolutePath());
        String str = file.getAbsolutePath() + ".LOCK";
        File file2 = new File(str);
        if (!file2.exists()) {
            file2.getParentFile().mkdirs();
            file2.createNewFile();
        }
        if (!f13481a.add(str)) {
            throw new IOException("abtain lock failure");
        }
        t tVar = new t(context);
        tVar.f1103a = str;
        try {
            tVar.f1102a = new RandomAccessFile(file2, "rw");
            tVar.f1104a = tVar.f1102a.getChannel().lock();
            com.xiaomi.channel.commonutils.logger.b.c("Locked: " + str + " :" + tVar.f1104a);
            return tVar;
        } finally {
            if (tVar.f1104a == null) {
                RandomAccessFile randomAccessFile = tVar.f1102a;
                if (randomAccessFile != null) {
                    w.a(randomAccessFile);
                }
                f13481a.remove(tVar.f1103a);
            }
        }
    }

    public void a() throws IOException {
        com.xiaomi.channel.commonutils.logger.b.c("unLock: " + this.f1104a);
        FileLock fileLock = this.f1104a;
        if (fileLock != null && fileLock.isValid()) {
            try {
                this.f1104a.release();
            } catch (IOException unused) {
            }
            this.f1104a = null;
        }
        RandomAccessFile randomAccessFile = this.f1102a;
        if (randomAccessFile != null) {
            w.a(randomAccessFile);
        }
        f13481a.remove(this.f1103a);
    }
}
