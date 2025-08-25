package k.a.a.a.j;

import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import k.a.a.a.j.c;

/* compiled from: FileLogger.java */
/* loaded from: classes2.dex */
public class a implements c.a, Runnable {

    /* renamed from: b, reason: collision with root package name */
    private Thread f17032b;

    /* renamed from: d, reason: collision with root package name */
    private File f17034d;

    /* renamed from: a, reason: collision with root package name */
    private final BlockingQueue<String> f17031a = new LinkedBlockingQueue();

    /* renamed from: c, reason: collision with root package name */
    private volatile boolean f17033c = true;

    private static void a(Closeable closeable) throws IOException {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    private void b(String str) {
        if (this.f17034d.length() + str.length() > 3145728) {
            this.f17034d.renameTo(new File(this.f17034d.getPath() + ".bak"));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v7 */
    private void c(String str) throws Throwable {
        FileOutputStream fileOutputStream;
        BufferedOutputStream bufferedOutputStream;
        Closeable closeable;
        Closeable closeable2;
        OutputStreamWriter outputStreamWriter;
        BufferedOutputStream bufferedOutputStream2 = null;
        try {
            fileOutputStream = new FileOutputStream(this.f17034d, true);
            try {
                bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
                try {
                    outputStreamWriter = new OutputStreamWriter(bufferedOutputStream, "UTF-8");
                } catch (FileNotFoundException unused) {
                    outputStreamWriter = 0;
                } catch (IOException unused2) {
                    outputStreamWriter = 0;
                } catch (Throwable th) {
                    th = th;
                }
            } catch (FileNotFoundException | IOException unused3) {
                closeable = null;
            } catch (Throwable th2) {
                th = th2;
                bufferedOutputStream = null;
            }
        } catch (FileNotFoundException | IOException unused4) {
            fileOutputStream = null;
            closeable = null;
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
            bufferedOutputStream = null;
        }
        try {
            outputStreamWriter.write(str);
            outputStreamWriter.flush();
            closeable2 = outputStreamWriter;
        } catch (FileNotFoundException | IOException unused5) {
            bufferedOutputStream2 = bufferedOutputStream;
            closeable = outputStreamWriter;
            bufferedOutputStream = bufferedOutputStream2;
            closeable2 = closeable;
            a(closeable2);
            a(bufferedOutputStream);
            a(fileOutputStream);
        } catch (Throwable th4) {
            th = th4;
            bufferedOutputStream2 = outputStreamWriter;
            a(bufferedOutputStream2);
            a(bufferedOutputStream);
            a(fileOutputStream);
            throw th;
        }
        a(closeable2);
        a(bufferedOutputStream);
        a(fileOutputStream);
    }

    @Override // java.lang.Runnable
    public void run() throws InterruptedException {
        this.f17033c = true;
        if (this.f17034d != null) {
            while (this.f17033c) {
                try {
                    String strPoll = this.f17031a.poll(1L, TimeUnit.SECONDS);
                    if (strPoll != null) {
                        b(strPoll);
                        c(strPoll);
                    }
                } catch (InterruptedException | Exception unused) {
                    return;
                }
            }
        }
    }

    @Override // k.a.a.a.j.c.a
    public void a(String str) {
        if (str == null || this.f17034d == null) {
            return;
        }
        this.f17031a.offer(str);
    }

    public void a(File file) {
        File parentFile;
        if (file == null || (parentFile = file.getParentFile()) == null) {
            return;
        }
        parentFile.mkdirs();
        if (parentFile.isDirectory()) {
            this.f17034d = file;
            Thread thread = new Thread(this, "hnid-log-thread");
            this.f17032b = thread;
            thread.start();
        }
    }
}
