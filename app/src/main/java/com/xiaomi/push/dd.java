package com.xiaomi.push;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Process;
import android.util.Log;
import android.util.Pair;
import com.xiaomi.channel.commonutils.logger.LoggerInterface;
import com.xiaomi.mipush.sdk.Constants;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/* loaded from: classes2.dex */
public class dd implements LoggerInterface {

    /* renamed from: a, reason: collision with root package name */
    private static volatile dd f12636a;

    /* renamed from: a, reason: collision with other field name */
    private Context f321a;

    /* renamed from: a, reason: collision with other field name */
    private Handler f322a;

    /* renamed from: b, reason: collision with root package name */
    private String f12637b;

    /* renamed from: a, reason: collision with other field name */
    private static final SimpleDateFormat f319a = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss aaa");

    /* renamed from: a, reason: collision with other field name */
    public static String f318a = "/MiPushLog";

    /* renamed from: a, reason: collision with other field name */
    private static List<Pair<String, Throwable>> f320a = Collections.synchronizedList(new ArrayList());

    private dd(Context context) {
        this.f321a = context;
        if (context.getApplicationContext() != null) {
            this.f321a = context.getApplicationContext();
        }
        this.f12637b = this.f321a.getPackageName() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + Process.myPid();
        HandlerThread handlerThread = new HandlerThread("Log2FileHandlerThread");
        handlerThread.start();
        this.f322a = new Handler(handlerThread.getLooper());
    }

    @Override // com.xiaomi.channel.commonutils.logger.LoggerInterface
    public final void log(String str) {
        log(str, null);
    }

    @Override // com.xiaomi.channel.commonutils.logger.LoggerInterface
    public final void setTag(String str) {
        this.f12637b = str;
    }

    @Override // com.xiaomi.channel.commonutils.logger.LoggerInterface
    public final void log(final String str, final Throwable th) {
        this.f322a.post(new Runnable() { // from class: com.xiaomi.push.dd.1
            @Override // java.lang.Runnable
            public void run() throws Throwable {
                dd.f320a.add(new Pair(String.format("%1$s %2$s %3$s ", dd.f319a.format(new Date()), dd.this.f12637b, str), th));
                if (dd.f320a.size() > 20000) {
                    int size = (dd.f320a.size() - 20000) + 50;
                    for (int i2 = 0; i2 < size; i2++) {
                        try {
                            if (dd.f320a.size() > 0) {
                                dd.f320a.remove(0);
                            }
                        } catch (IndexOutOfBoundsException unused) {
                        }
                    }
                    dd.f320a.add(new Pair(String.format("%1$s %2$s %3$s ", dd.f319a.format(new Date()), dd.this.f12637b, "flush " + size + " lines logs."), null));
                }
                try {
                    dd.this.m267a();
                } catch (Exception unused2) {
                    String unused3 = dd.this.f12637b;
                }
            }
        });
    }

    public static dd a(Context context) {
        if (f12636a == null) {
            synchronized (dd.class) {
                if (f12636a == null) {
                    f12636a = new dd(context);
                }
            }
        }
        return f12636a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a, reason: collision with other method in class */
    public void m267a() throws Throwable {
        FileLock fileLockLock;
        RandomAccessFile randomAccessFile;
        File file;
        BufferedWriter bufferedWriter = null;
        try {
            file = new File(this.f321a.getFilesDir(), f318a);
        } catch (Exception unused) {
            fileLockLock = null;
            randomAccessFile = null;
        } catch (Throwable th) {
            th = th;
            fileLockLock = null;
            randomAccessFile = null;
        }
        if (!v.m764a(file)) {
            String str = "Cannot wirte internal file: " + file;
            return;
        }
        if ((file.exists() && file.isDirectory()) || file.mkdirs()) {
            File file2 = new File(file, "log.lock");
            if (!file2.exists() || file2.isDirectory()) {
                file2.createNewFile();
            }
            randomAccessFile = new RandomAccessFile(file2, "rw");
            try {
                fileLockLock = randomAccessFile.getChannel().lock();
                try {
                    BufferedWriter bufferedWriter2 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(file, "log1.txt"), true)));
                    while (!f320a.isEmpty()) {
                        try {
                            Pair<String, Throwable> pairRemove = f320a.remove(0);
                            String str2 = (String) pairRemove.first;
                            if (pairRemove.second != null) {
                                str2 = (str2 + "\n") + Log.getStackTraceString((Throwable) pairRemove.second);
                            }
                            bufferedWriter2.write(str2 + "\n");
                        } catch (Exception unused2) {
                            bufferedWriter = bufferedWriter2;
                            if (bufferedWriter != null) {
                                try {
                                    bufferedWriter.close();
                                } catch (IOException unused3) {
                                }
                            }
                            if (fileLockLock != null && fileLockLock.isValid()) {
                                try {
                                    fileLockLock.release();
                                } catch (IOException unused4) {
                                }
                            }
                            if (randomAccessFile == null) {
                                return;
                            }
                            randomAccessFile.close();
                        } catch (Throwable th2) {
                            th = th2;
                            bufferedWriter = bufferedWriter2;
                            if (bufferedWriter != null) {
                                try {
                                    bufferedWriter.close();
                                } catch (IOException unused5) {
                                }
                            }
                            if (fileLockLock != null && fileLockLock.isValid()) {
                                try {
                                    fileLockLock.release();
                                } catch (IOException unused6) {
                                }
                            }
                            if (randomAccessFile != null) {
                                try {
                                    randomAccessFile.close();
                                    throw th;
                                } catch (IOException unused7) {
                                    throw th;
                                }
                            }
                            throw th;
                        }
                    }
                    bufferedWriter2.flush();
                    bufferedWriter2.close();
                    File file3 = new File(file, "log1.txt");
                    if (file3.length() >= 1048576) {
                        File file4 = new File(file, "log0.txt");
                        if (file4.exists() && file4.isFile()) {
                            file4.delete();
                        }
                        file3.renameTo(file4);
                    }
                    if (0 != 0) {
                        try {
                            bufferedWriter.close();
                        } catch (IOException unused8) {
                        }
                    }
                    if (fileLockLock != null && fileLockLock.isValid()) {
                        try {
                            fileLockLock.release();
                        } catch (IOException unused9) {
                        }
                    }
                } catch (Exception unused10) {
                } catch (Throwable th3) {
                    th = th3;
                }
            } catch (Exception unused11) {
                fileLockLock = null;
            } catch (Throwable th4) {
                th = th4;
                fileLockLock = null;
            }
            try {
                randomAccessFile.close();
            } catch (IOException unused12) {
            }
        }
    }
}
