package f.a.a;

import android.content.Context;
import android.graphics.Bitmap;
import g.a.l;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.Callable;

/* compiled from: Compressor.java */
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private int f13602a = 612;

    /* renamed from: b, reason: collision with root package name */
    private int f13603b = 816;

    /* renamed from: c, reason: collision with root package name */
    private Bitmap.CompressFormat f13604c = Bitmap.CompressFormat.JPEG;

    /* renamed from: d, reason: collision with root package name */
    private int f13605d = 80;

    /* renamed from: e, reason: collision with root package name */
    private String f13606e;

    /* compiled from: Compressor.java */
    class a implements Callable<l<File>> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ File f13607a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f13608b;

        a(File file, String str) {
            this.f13607a = file;
            this.f13608b = str;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public l<File> call() {
            try {
                return l.l(b.this.a(this.f13607a, this.f13608b));
            } catch (IOException e2) {
                return l.a((Throwable) e2);
            }
        }
    }

    /* compiled from: Compressor.java */
    /* renamed from: f.a.a.b$b, reason: collision with other inner class name */
    class CallableC0166b implements Callable<l<Bitmap>> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ File f13610a;

        CallableC0166b(File file) {
            this.f13610a = file;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public l<Bitmap> call() {
            try {
                return l.l(b.this.a(this.f13610a));
            } catch (IOException e2) {
                return l.a((Throwable) e2);
            }
        }
    }

    public b(Context context) {
        this.f13606e = context.getCacheDir().getPath() + File.separator + "images";
    }

    public b a(int i2) {
        this.f13603b = i2;
        return this;
    }

    public b b(int i2) {
        this.f13602a = i2;
        return this;
    }

    public b c(int i2) {
        this.f13605d = i2;
        return this;
    }

    public l<File> d(File file) {
        return b(file, file.getName());
    }

    public b a(Bitmap.CompressFormat compressFormat) {
        this.f13604c = compressFormat;
        return this;
    }

    public l<File> b(File file, String str) {
        return l.d((Callable) new a(file, str));
    }

    public File c(File file) throws IOException {
        return a(file, file.getName());
    }

    public b a(String str) {
        this.f13606e = str;
        return this;
    }

    public l<Bitmap> b(File file) {
        return l.d((Callable) new CallableC0166b(file));
    }

    public File a(File file, String str) throws IOException {
        return c.a(file, this.f13602a, this.f13603b, this.f13604c, this.f13605d, this.f13606e + File.separator + str);
    }

    public Bitmap a(File file) throws IOException {
        return c.a(file, this.f13602a, this.f13603b);
    }
}
