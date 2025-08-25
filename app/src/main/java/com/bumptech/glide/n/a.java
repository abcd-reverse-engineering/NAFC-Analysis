package com.bumptech.glide.n;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.StrictMode;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: DiskLruCache.java */
/* loaded from: classes.dex */
public final class a implements Closeable {
    static final String o = "journal";
    static final String p = "journal.tmp";
    static final String q = "journal.bkp";
    static final String r = "libcore.io.DiskLruCache";
    static final String s = "1";
    static final long t = -1;
    private static final String u = "CLEAN";
    private static final String v = "DIRTY";
    private static final String w = "REMOVE";
    private static final String x = "READ";

    /* renamed from: a, reason: collision with root package name */
    private final File f5099a;

    /* renamed from: b, reason: collision with root package name */
    private final File f5100b;

    /* renamed from: c, reason: collision with root package name */
    private final File f5101c;

    /* renamed from: d, reason: collision with root package name */
    private final File f5102d;

    /* renamed from: e, reason: collision with root package name */
    private final int f5103e;

    /* renamed from: f, reason: collision with root package name */
    private long f5104f;

    /* renamed from: g, reason: collision with root package name */
    private final int f5105g;

    /* renamed from: i, reason: collision with root package name */
    private Writer f5107i;

    /* renamed from: k, reason: collision with root package name */
    private int f5109k;

    /* renamed from: h, reason: collision with root package name */
    private long f5106h = 0;

    /* renamed from: j, reason: collision with root package name */
    private final LinkedHashMap<String, d> f5108j = new LinkedHashMap<>(0, 0.75f, true);

    /* renamed from: l, reason: collision with root package name */
    private long f5110l = 0;

    /* renamed from: m, reason: collision with root package name */
    final ThreadPoolExecutor f5111m = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new b(null));
    private final Callable<Void> n = new CallableC0075a();

    /* compiled from: DiskLruCache.java */
    /* renamed from: com.bumptech.glide.n.a$a, reason: collision with other inner class name */
    class CallableC0075a implements Callable<Void> {
        CallableC0075a() {
        }

        @Override // java.util.concurrent.Callable
        public Void call() throws Exception {
            synchronized (a.this) {
                if (a.this.f5107i == null) {
                    return null;
                }
                a.this.l();
                if (a.this.h()) {
                    a.this.k();
                    a.this.f5109k = 0;
                }
                return null;
            }
        }
    }

    /* compiled from: DiskLruCache.java */
    private static final class b implements ThreadFactory {
        private b() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public synchronized Thread newThread(Runnable runnable) {
            Thread thread;
            thread = new Thread(runnable, "glide-disk-lru-cache-thread");
            thread.setPriority(1);
            return thread;
        }

        /* synthetic */ b(CallableC0075a callableC0075a) {
            this();
        }
    }

    /* compiled from: DiskLruCache.java */
    public final class c {

        /* renamed from: a, reason: collision with root package name */
        private final d f5113a;

        /* renamed from: b, reason: collision with root package name */
        private final boolean[] f5114b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f5115c;

        /* synthetic */ c(a aVar, d dVar, CallableC0075a callableC0075a) {
            this(dVar);
        }

        private InputStream c(int i2) throws IOException {
            synchronized (a.this) {
                if (this.f5113a.f5122f != this) {
                    throw new IllegalStateException();
                }
                if (!this.f5113a.f5121e) {
                    return null;
                }
                try {
                    return new FileInputStream(this.f5113a.a(i2));
                } catch (FileNotFoundException unused) {
                    return null;
                }
            }
        }

        private c(d dVar) {
            this.f5113a = dVar;
            this.f5114b = dVar.f5121e ? null : new boolean[a.this.f5105g];
        }

        public File a(int i2) throws IOException {
            File fileB;
            synchronized (a.this) {
                if (this.f5113a.f5122f != this) {
                    throw new IllegalStateException();
                }
                if (!this.f5113a.f5121e) {
                    this.f5114b[i2] = true;
                }
                fileB = this.f5113a.b(i2);
                if (!a.this.f5099a.exists()) {
                    a.this.f5099a.mkdirs();
                }
            }
            return fileB;
        }

        public String b(int i2) throws IOException {
            InputStream inputStreamC = c(i2);
            if (inputStreamC != null) {
                return a.b(inputStreamC);
            }
            return null;
        }

        public void b() {
            if (this.f5115c) {
                return;
            }
            try {
                a();
            } catch (IOException unused) {
            }
        }

        public void c() throws IOException {
            a.this.a(this, true);
            this.f5115c = true;
        }

        public void a(int i2, String str) throws Throwable {
            OutputStreamWriter outputStreamWriter;
            OutputStreamWriter outputStreamWriter2 = null;
            try {
                outputStreamWriter = new OutputStreamWriter(new FileOutputStream(a(i2)), com.bumptech.glide.n.c.f5139b);
            } catch (Throwable th) {
                th = th;
            }
            try {
                outputStreamWriter.write(str);
                com.bumptech.glide.n.c.a(outputStreamWriter);
            } catch (Throwable th2) {
                th = th2;
                outputStreamWriter2 = outputStreamWriter;
                com.bumptech.glide.n.c.a(outputStreamWriter2);
                throw th;
            }
        }

        public void a() throws IOException {
            a.this.a(this, false);
        }
    }

    /* compiled from: DiskLruCache.java */
    private final class d {

        /* renamed from: a, reason: collision with root package name */
        private final String f5117a;

        /* renamed from: b, reason: collision with root package name */
        private final long[] f5118b;

        /* renamed from: c, reason: collision with root package name */
        File[] f5119c;

        /* renamed from: d, reason: collision with root package name */
        File[] f5120d;

        /* renamed from: e, reason: collision with root package name */
        private boolean f5121e;

        /* renamed from: f, reason: collision with root package name */
        private c f5122f;

        /* renamed from: g, reason: collision with root package name */
        private long f5123g;

        /* synthetic */ d(a aVar, String str, CallableC0075a callableC0075a) {
            this(str);
        }

        private d(String str) {
            this.f5117a = str;
            this.f5118b = new long[a.this.f5105g];
            this.f5119c = new File[a.this.f5105g];
            this.f5120d = new File[a.this.f5105g];
            StringBuilder sb = new StringBuilder(str);
            sb.append('.');
            int length = sb.length();
            for (int i2 = 0; i2 < a.this.f5105g; i2++) {
                sb.append(i2);
                this.f5119c[i2] = new File(a.this.f5099a, sb.toString());
                sb.append(".tmp");
                this.f5120d[i2] = new File(a.this.f5099a, sb.toString());
                sb.setLength(length);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(String[] strArr) throws IOException {
            if (strArr.length != a.this.f5105g) {
                throw a(strArr);
            }
            for (int i2 = 0; i2 < strArr.length; i2++) {
                try {
                    this.f5118b[i2] = Long.parseLong(strArr[i2]);
                } catch (NumberFormatException unused) {
                    throw a(strArr);
                }
            }
        }

        public String a() throws IOException {
            StringBuilder sb = new StringBuilder();
            for (long j2 : this.f5118b) {
                sb.append(' ');
                sb.append(j2);
            }
            return sb.toString();
        }

        public File b(int i2) {
            return this.f5120d[i2];
        }

        private IOException a(String[] strArr) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        public File a(int i2) {
            return this.f5119c[i2];
        }
    }

    /* compiled from: DiskLruCache.java */
    public final class e {

        /* renamed from: a, reason: collision with root package name */
        private final String f5125a;

        /* renamed from: b, reason: collision with root package name */
        private final long f5126b;

        /* renamed from: c, reason: collision with root package name */
        private final long[] f5127c;

        /* renamed from: d, reason: collision with root package name */
        private final File[] f5128d;

        /* synthetic */ e(a aVar, String str, long j2, File[] fileArr, long[] jArr, CallableC0075a callableC0075a) {
            this(str, j2, fileArr, jArr);
        }

        public c a() throws IOException {
            return a.this.a(this.f5125a, this.f5126b);
        }

        public long b(int i2) {
            return this.f5127c[i2];
        }

        public String c(int i2) throws IOException {
            return a.b(new FileInputStream(this.f5128d[i2]));
        }

        private e(String str, long j2, File[] fileArr, long[] jArr) {
            this.f5125a = str;
            this.f5126b = j2;
            this.f5128d = fileArr;
            this.f5127c = jArr;
        }

        public File a(int i2) {
            return this.f5128d[i2];
        }
    }

    private a(File file, int i2, int i3, long j2) {
        this.f5099a = file;
        this.f5103e = i2;
        this.f5100b = new File(file, o);
        this.f5101c = new File(file, p);
        this.f5102d = new File(file, q);
        this.f5105g = i3;
        this.f5104f = j2;
    }

    private void g() {
        if (this.f5107i == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean h() {
        int i2 = this.f5109k;
        return i2 >= 2000 && i2 >= this.f5108j.size();
    }

    private void i() throws IOException {
        a(this.f5101c);
        Iterator<d> it = this.f5108j.values().iterator();
        while (it.hasNext()) {
            d next = it.next();
            int i2 = 0;
            if (next.f5122f == null) {
                while (i2 < this.f5105g) {
                    this.f5106h += next.f5118b[i2];
                    i2++;
                }
            } else {
                next.f5122f = null;
                while (i2 < this.f5105g) {
                    a(next.a(i2));
                    a(next.b(i2));
                    i2++;
                }
                it.remove();
            }
        }
    }

    private void j() throws IOException {
        com.bumptech.glide.n.b bVar = new com.bumptech.glide.n.b(new FileInputStream(this.f5100b), com.bumptech.glide.n.c.f5138a);
        try {
            String strD = bVar.d();
            String strD2 = bVar.d();
            String strD3 = bVar.d();
            String strD4 = bVar.d();
            String strD5 = bVar.d();
            if (!r.equals(strD) || !"1".equals(strD2) || !Integer.toString(this.f5103e).equals(strD3) || !Integer.toString(this.f5105g).equals(strD4) || !"".equals(strD5)) {
                throw new IOException("unexpected journal header: [" + strD + ", " + strD2 + ", " + strD4 + ", " + strD5 + "]");
            }
            int i2 = 0;
            while (true) {
                try {
                    d(bVar.d());
                    i2++;
                } catch (EOFException unused) {
                    this.f5109k = i2 - this.f5108j.size();
                    if (bVar.c()) {
                        k();
                    } else {
                        this.f5107i = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f5100b, true), com.bumptech.glide.n.c.f5138a));
                    }
                    com.bumptech.glide.n.c.a(bVar);
                    return;
                }
            }
        } catch (Throwable th) {
            com.bumptech.glide.n.c.a(bVar);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void k() throws IOException {
        if (this.f5107i != null) {
            a(this.f5107i);
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f5101c), com.bumptech.glide.n.c.f5138a));
        try {
            bufferedWriter.write(r);
            bufferedWriter.write("\n");
            bufferedWriter.write("1");
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.f5103e));
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.f5105g));
            bufferedWriter.write("\n");
            bufferedWriter.write("\n");
            for (d dVar : this.f5108j.values()) {
                if (dVar.f5122f != null) {
                    bufferedWriter.write("DIRTY " + dVar.f5117a + '\n');
                } else {
                    bufferedWriter.write("CLEAN " + dVar.f5117a + dVar.a() + '\n');
                }
            }
            a(bufferedWriter);
            if (this.f5100b.exists()) {
                a(this.f5100b, this.f5102d, true);
            }
            a(this.f5101c, this.f5100b, false);
            this.f5102d.delete();
            this.f5107i = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f5100b, true), com.bumptech.glide.n.c.f5138a));
        } catch (Throwable th) {
            a(bufferedWriter);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() throws IOException {
        while (this.f5106h > this.f5104f) {
            c(this.f5108j.entrySet().iterator().next().getKey());
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        if (this.f5107i == null) {
            return;
        }
        Iterator it = new ArrayList(this.f5108j.values()).iterator();
        while (it.hasNext()) {
            d dVar = (d) it.next();
            if (dVar.f5122f != null) {
                dVar.f5122f.a();
            }
        }
        l();
        a(this.f5107i);
        this.f5107i = null;
    }

    public synchronized void flush() throws IOException {
        g();
        l();
        b(this.f5107i);
    }

    public synchronized boolean isClosed() {
        return this.f5107i == null;
    }

    private void d(String str) throws IOException {
        String strSubstring;
        int iIndexOf = str.indexOf(32);
        if (iIndexOf == -1) {
            throw new IOException("unexpected journal line: " + str);
        }
        int i2 = iIndexOf + 1;
        int iIndexOf2 = str.indexOf(32, i2);
        if (iIndexOf2 == -1) {
            strSubstring = str.substring(i2);
            if (iIndexOf == 6 && str.startsWith(w)) {
                this.f5108j.remove(strSubstring);
                return;
            }
        } else {
            strSubstring = str.substring(i2, iIndexOf2);
        }
        d dVar = this.f5108j.get(strSubstring);
        CallableC0075a callableC0075a = null;
        if (dVar == null) {
            dVar = new d(this, strSubstring, callableC0075a);
            this.f5108j.put(strSubstring, dVar);
        }
        if (iIndexOf2 != -1 && iIndexOf == 5 && str.startsWith(u)) {
            String[] strArrSplit = str.substring(iIndexOf2 + 1).split(c.c.a.b.a.a.f3100g);
            dVar.f5121e = true;
            dVar.f5122f = null;
            dVar.b(strArrSplit);
            return;
        }
        if (iIndexOf2 == -1 && iIndexOf == 5 && str.startsWith(v)) {
            dVar.f5122f = new c(this, dVar, callableC0075a);
            return;
        }
        if (iIndexOf2 == -1 && iIndexOf == 4 && str.startsWith(x)) {
            return;
        }
        throw new IOException("unexpected journal line: " + str);
    }

    public synchronized e b(String str) throws IOException {
        g();
        d dVar = this.f5108j.get(str);
        if (dVar == null) {
            return null;
        }
        if (!dVar.f5121e) {
            return null;
        }
        for (File file : dVar.f5119c) {
            if (!file.exists()) {
                return null;
            }
        }
        this.f5109k++;
        this.f5107i.append((CharSequence) x);
        this.f5107i.append(' ');
        this.f5107i.append((CharSequence) str);
        this.f5107i.append('\n');
        if (h()) {
            this.f5111m.submit(this.n);
        }
        return new e(this, str, dVar.f5123g, dVar.f5119c, dVar.f5118b, null);
    }

    public synchronized boolean c(String str) throws IOException {
        g();
        d dVar = this.f5108j.get(str);
        if (dVar != null && dVar.f5122f == null) {
            for (int i2 = 0; i2 < this.f5105g; i2++) {
                File fileA = dVar.a(i2);
                if (fileA.exists() && !fileA.delete()) {
                    throw new IOException("failed to delete " + fileA);
                }
                this.f5106h -= dVar.f5118b[i2];
                dVar.f5118b[i2] = 0;
            }
            this.f5109k++;
            this.f5107i.append((CharSequence) w);
            this.f5107i.append(' ');
            this.f5107i.append((CharSequence) str);
            this.f5107i.append('\n');
            this.f5108j.remove(str);
            if (h()) {
                this.f5111m.submit(this.n);
            }
            return true;
        }
        return false;
    }

    public synchronized long e() {
        return this.f5104f;
    }

    public synchronized long f() {
        return this.f5106h;
    }

    public static a a(File file, int i2, int i3, long j2) throws IOException {
        if (j2 <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        if (i3 > 0) {
            File file2 = new File(file, q);
            if (file2.exists()) {
                File file3 = new File(file, o);
                if (file3.exists()) {
                    file2.delete();
                } else {
                    a(file2, file3, false);
                }
            }
            a aVar = new a(file, i2, i3, j2);
            if (aVar.f5100b.exists()) {
                try {
                    aVar.j();
                    aVar.i();
                    return aVar;
                } catch (IOException e2) {
                    System.out.println("DiskLruCache " + file + " is corrupt: " + e2.getMessage() + ", removing");
                    aVar.c();
                }
            }
            file.mkdirs();
            a aVar2 = new a(file, i2, i3, j2);
            aVar2.k();
            return aVar2;
        }
        throw new IllegalArgumentException("valueCount <= 0");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String b(InputStream inputStream) throws IOException {
        return com.bumptech.glide.n.c.a((Reader) new InputStreamReader(inputStream, com.bumptech.glide.n.c.f5139b));
    }

    @TargetApi(26)
    private static void b(Writer writer) throws IOException {
        if (Build.VERSION.SDK_INT < 26) {
            writer.flush();
            return;
        }
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitUnbufferedIo().build());
        try {
            writer.flush();
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }

    public void c() throws IOException {
        close();
        com.bumptech.glide.n.c.a(this.f5099a);
    }

    public File d() {
        return this.f5099a;
    }

    private static void a(File file) throws IOException {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    private static void a(File file, File file2, boolean z) throws IOException {
        if (z) {
            a(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    public c a(String str) throws IOException {
        return a(str, -1L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized c a(String str, long j2) throws IOException {
        g();
        d dVar = this.f5108j.get(str);
        CallableC0075a callableC0075a = null;
        if (j2 != -1 && (dVar == null || dVar.f5123g != j2)) {
            return null;
        }
        if (dVar != null) {
            if (dVar.f5122f != null) {
                return null;
            }
        } else {
            dVar = new d(this, str, callableC0075a);
            this.f5108j.put(str, dVar);
        }
        c cVar = new c(this, dVar, callableC0075a);
        dVar.f5122f = cVar;
        this.f5107i.append((CharSequence) v);
        this.f5107i.append(' ');
        this.f5107i.append((CharSequence) str);
        this.f5107i.append('\n');
        b(this.f5107i);
        return cVar;
    }

    public synchronized void a(long j2) {
        this.f5104f = j2;
        this.f5111m.submit(this.n);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(c cVar, boolean z) throws IOException {
        d dVar = cVar.f5113a;
        if (dVar.f5122f == cVar) {
            if (z && !dVar.f5121e) {
                for (int i2 = 0; i2 < this.f5105g; i2++) {
                    if (cVar.f5114b[i2]) {
                        if (!dVar.b(i2).exists()) {
                            cVar.a();
                            return;
                        }
                    } else {
                        cVar.a();
                        throw new IllegalStateException("Newly created entry didn't create value for index " + i2);
                    }
                }
            }
            for (int i3 = 0; i3 < this.f5105g; i3++) {
                File fileB = dVar.b(i3);
                if (z) {
                    if (fileB.exists()) {
                        File fileA = dVar.a(i3);
                        fileB.renameTo(fileA);
                        long j2 = dVar.f5118b[i3];
                        long length = fileA.length();
                        dVar.f5118b[i3] = length;
                        this.f5106h = (this.f5106h - j2) + length;
                    }
                } else {
                    a(fileB);
                }
            }
            this.f5109k++;
            dVar.f5122f = null;
            if (!(dVar.f5121e | z)) {
                this.f5108j.remove(dVar.f5117a);
                this.f5107i.append((CharSequence) w);
                this.f5107i.append(' ');
                this.f5107i.append((CharSequence) dVar.f5117a);
                this.f5107i.append('\n');
            } else {
                dVar.f5121e = true;
                this.f5107i.append((CharSequence) u);
                this.f5107i.append(' ');
                this.f5107i.append((CharSequence) dVar.f5117a);
                this.f5107i.append((CharSequence) dVar.a());
                this.f5107i.append('\n');
                if (z) {
                    long j3 = this.f5110l;
                    this.f5110l = 1 + j3;
                    dVar.f5123g = j3;
                }
            }
            b(this.f5107i);
            if (this.f5106h > this.f5104f || h()) {
                this.f5111m.submit(this.n);
            }
            return;
        }
        throw new IllegalStateException();
    }

    @TargetApi(26)
    private static void a(Writer writer) throws IOException {
        if (Build.VERSION.SDK_INT < 26) {
            writer.close();
            return;
        }
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitUnbufferedIo().build());
        try {
            writer.close();
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }
}
