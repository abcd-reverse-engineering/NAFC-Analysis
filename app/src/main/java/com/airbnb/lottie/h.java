package com.airbnb.lottie;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import androidx.annotation.Nullable;
import androidx.annotation.RawRes;
import androidx.annotation.WorkerThread;
import com.luck.picture.lib.config.PictureMimeType;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import okio.BufferedSource;
import okio.Okio;
import org.json.JSONObject;

/* compiled from: LottieCompositionFactory.java */
/* loaded from: classes.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    private static final Map<String, q<com.airbnb.lottie.g>> f3507a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    private static final byte[] f3508b = {80, 75, 3, 4};

    /* compiled from: LottieCompositionFactory.java */
    class a implements l<com.airbnb.lottie.g> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f3509a;

        a(String str) {
            this.f3509a = str;
        }

        @Override // com.airbnb.lottie.l
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResult(com.airbnb.lottie.g gVar) {
            h.f3507a.remove(this.f3509a);
        }
    }

    /* compiled from: LottieCompositionFactory.java */
    class b implements l<Throwable> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f3510a;

        b(String str) {
            this.f3510a = str;
        }

        @Override // com.airbnb.lottie.l
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResult(Throwable th) {
            h.f3507a.remove(this.f3510a);
        }
    }

    /* compiled from: LottieCompositionFactory.java */
    class c implements Callable<p<com.airbnb.lottie.g>> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f3511a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f3512b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f3513c;

        c(Context context, String str, String str2) {
            this.f3511a = context;
            this.f3512b = str;
            this.f3513c = str2;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public p<com.airbnb.lottie.g> call() {
            p<com.airbnb.lottie.g> pVarA = com.airbnb.lottie.e.b(this.f3511a).a(this.f3512b, this.f3513c);
            if (this.f3513c != null && pVarA.b() != null) {
                com.airbnb.lottie.y.g.b().a(this.f3513c, pVarA.b());
            }
            return pVarA;
        }
    }

    /* compiled from: LottieCompositionFactory.java */
    class d implements Callable<p<com.airbnb.lottie.g>> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f3514a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f3515b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f3516c;

        d(Context context, String str, String str2) {
            this.f3514a = context;
            this.f3515b = str;
            this.f3516c = str2;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public p<com.airbnb.lottie.g> call() {
            return h.b(this.f3514a, this.f3515b, this.f3516c);
        }
    }

    /* compiled from: LottieCompositionFactory.java */
    class e implements Callable<p<com.airbnb.lottie.g>> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ WeakReference f3517a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Context f3518b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f3519c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f3520d;

        e(WeakReference weakReference, Context context, int i2, String str) {
            this.f3517a = weakReference;
            this.f3518b = context;
            this.f3519c = i2;
            this.f3520d = str;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public p<com.airbnb.lottie.g> call() {
            Context context = (Context) this.f3517a.get();
            if (context == null) {
                context = this.f3518b;
            }
            return h.b(context, this.f3519c, this.f3520d);
        }
    }

    /* compiled from: LottieCompositionFactory.java */
    class f implements Callable<p<com.airbnb.lottie.g>> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ InputStream f3521a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f3522b;

        f(InputStream inputStream, String str) {
            this.f3521a = inputStream;
            this.f3522b = str;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public p<com.airbnb.lottie.g> call() {
            return h.b(this.f3521a, this.f3522b);
        }
    }

    /* compiled from: LottieCompositionFactory.java */
    class g implements Callable<p<com.airbnb.lottie.g>> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ JSONObject f3523a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f3524b;

        g(JSONObject jSONObject, String str) {
            this.f3523a = jSONObject;
            this.f3524b = str;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public p<com.airbnb.lottie.g> call() {
            return h.b(this.f3523a, this.f3524b);
        }
    }

    /* compiled from: LottieCompositionFactory.java */
    /* renamed from: com.airbnb.lottie.h$h, reason: collision with other inner class name */
    class CallableC0047h implements Callable<p<com.airbnb.lottie.g>> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f3525a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f3526b;

        CallableC0047h(String str, String str2) {
            this.f3525a = str;
            this.f3526b = str2;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public p<com.airbnb.lottie.g> call() {
            return h.b(this.f3525a, this.f3526b);
        }
    }

    /* compiled from: LottieCompositionFactory.java */
    class i implements Callable<p<com.airbnb.lottie.g>> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.airbnb.lottie.a0.l0.c f3527a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f3528b;

        i(com.airbnb.lottie.a0.l0.c cVar, String str) {
            this.f3527a = cVar;
            this.f3528b = str;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public p<com.airbnb.lottie.g> call() {
            return h.b(this.f3527a, this.f3528b);
        }
    }

    /* compiled from: LottieCompositionFactory.java */
    class j implements Callable<p<com.airbnb.lottie.g>> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ZipInputStream f3529a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f3530b;

        j(ZipInputStream zipInputStream, String str) {
            this.f3529a = zipInputStream;
            this.f3530b = str;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public p<com.airbnb.lottie.g> call() {
            return h.b(this.f3529a, this.f3530b);
        }
    }

    /* compiled from: LottieCompositionFactory.java */
    class k implements Callable<p<com.airbnb.lottie.g>> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.airbnb.lottie.g f3531a;

        k(com.airbnb.lottie.g gVar) {
            this.f3531a = gVar;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public p<com.airbnb.lottie.g> call() {
            return new p<>(this.f3531a);
        }
    }

    private h() {
    }

    @WorkerThread
    public static p<com.airbnb.lottie.g> b(Context context, String str) {
        return b(context, str, "asset_" + str);
    }

    public static q<com.airbnb.lottie.g> c(Context context, String str) {
        return c(context, str, "url_" + str);
    }

    @WorkerThread
    public static p<com.airbnb.lottie.g> d(Context context, String str) {
        return d(context, str, str);
    }

    public static void a(int i2) {
        com.airbnb.lottie.y.g.b().a(i2);
    }

    public static q<com.airbnb.lottie.g> c(Context context, String str, @Nullable String str2) {
        return a(str2, new c(context, str, str2));
    }

    @WorkerThread
    public static p<com.airbnb.lottie.g> d(Context context, String str, @Nullable String str2) {
        p<com.airbnb.lottie.g> pVarA = com.airbnb.lottie.e.b(context).a(str, str2);
        if (str2 != null && pVarA.b() != null) {
            com.airbnb.lottie.y.g.b().a(str2, pVarA.b());
        }
        return pVarA;
    }

    public static void a(Context context) {
        f3507a.clear();
        com.airbnb.lottie.y.g.b().a();
        com.airbnb.lottie.e.a(context).a();
    }

    @WorkerThread
    public static p<com.airbnb.lottie.g> b(Context context, String str, @Nullable String str2) {
        try {
            if (!str.endsWith(".zip") && !str.endsWith(".lottie")) {
                return b(context.getAssets().open(str), str2);
            }
            return b(new ZipInputStream(context.getAssets().open(str)), str2);
        } catch (IOException e2) {
            return new p<>((Throwable) e2);
        }
    }

    private static String c(Context context, @RawRes int i2) {
        StringBuilder sb = new StringBuilder();
        sb.append("rawRes");
        sb.append(b(context) ? "_night_" : "_day_");
        sb.append(i2);
        return sb.toString();
    }

    @WorkerThread
    private static p<com.airbnb.lottie.g> c(ZipInputStream zipInputStream, @Nullable String str) throws IOException {
        HashMap map = new HashMap();
        try {
            ZipEntry nextEntry = zipInputStream.getNextEntry();
            com.airbnb.lottie.g gVarB = null;
            while (nextEntry != null) {
                String name = nextEntry.getName();
                if (name.contains("__MACOSX")) {
                    zipInputStream.closeEntry();
                } else if (nextEntry.getName().equalsIgnoreCase("manifest.json")) {
                    zipInputStream.closeEntry();
                } else if (nextEntry.getName().contains(".json")) {
                    gVarB = a(com.airbnb.lottie.a0.l0.c.a(Okio.buffer(Okio.source(zipInputStream))), (String) null, false).b();
                } else if (!name.contains(PictureMimeType.PNG) && !name.contains(".webp") && !name.contains(".jpg") && !name.contains(".jpeg")) {
                    zipInputStream.closeEntry();
                } else {
                    map.put(name.split("/")[r1.length - 1], BitmapFactory.decodeStream(zipInputStream));
                }
                nextEntry = zipInputStream.getNextEntry();
            }
            if (gVarB == null) {
                return new p<>((Throwable) new IllegalArgumentException("Unable to parse composition"));
            }
            for (Map.Entry entry : map.entrySet()) {
                com.airbnb.lottie.k kVarA = a(gVarB, (String) entry.getKey());
                if (kVarA != null) {
                    kVarA.a(com.airbnb.lottie.b0.h.a((Bitmap) entry.getValue(), kVarA.f(), kVarA.d()));
                }
            }
            for (Map.Entry<String, com.airbnb.lottie.k> entry2 : gVarB.h().entrySet()) {
                if (entry2.getValue().a() == null) {
                    return new p<>((Throwable) new IllegalStateException("There is no image for " + entry2.getValue().c()));
                }
            }
            if (str != null) {
                com.airbnb.lottie.y.g.b().a(str, gVarB);
            }
            return new p<>(gVarB);
        } catch (IOException e2) {
            return new p<>((Throwable) e2);
        }
    }

    public static q<com.airbnb.lottie.g> a(Context context, String str) {
        return a(context, str, "asset_" + str);
    }

    @WorkerThread
    public static p<com.airbnb.lottie.g> b(Context context, @RawRes int i2) {
        return b(context, i2, c(context, i2));
    }

    public static q<com.airbnb.lottie.g> a(Context context, String str, @Nullable String str2) {
        return a(str2, new d(context.getApplicationContext(), str, str2));
    }

    @WorkerThread
    public static p<com.airbnb.lottie.g> b(Context context, @RawRes int i2, @Nullable String str) {
        try {
            BufferedSource bufferedSourceBuffer = Okio.buffer(Okio.source(context.getResources().openRawResource(i2)));
            if (a(bufferedSourceBuffer).booleanValue()) {
                return b(new ZipInputStream(bufferedSourceBuffer.inputStream()), str);
            }
            return b(bufferedSourceBuffer.inputStream(), str);
        } catch (Resources.NotFoundException e2) {
            return new p<>((Throwable) e2);
        }
    }

    public static q<com.airbnb.lottie.g> a(Context context, @RawRes int i2) {
        return a(context, i2, c(context, i2));
    }

    public static q<com.airbnb.lottie.g> a(Context context, @RawRes int i2, @Nullable String str) {
        return a(str, new e(new WeakReference(context), context.getApplicationContext(), i2, str));
    }

    private static boolean b(Context context) {
        return (context.getResources().getConfiguration().uiMode & 48) == 32;
    }

    public static q<com.airbnb.lottie.g> a(InputStream inputStream, @Nullable String str) {
        return a(str, new f(inputStream, str));
    }

    @WorkerThread
    public static p<com.airbnb.lottie.g> b(InputStream inputStream, @Nullable String str) {
        return a(inputStream, str, true);
    }

    @WorkerThread
    private static p<com.airbnb.lottie.g> a(InputStream inputStream, @Nullable String str, boolean z) throws IOException {
        try {
            return b(com.airbnb.lottie.a0.l0.c.a(Okio.buffer(Okio.source(inputStream))), str);
        } finally {
            if (z) {
                com.airbnb.lottie.b0.h.a(inputStream);
            }
        }
    }

    @WorkerThread
    @Deprecated
    public static p<com.airbnb.lottie.g> b(JSONObject jSONObject, @Nullable String str) {
        return b(jSONObject.toString(), str);
    }

    @WorkerThread
    public static p<com.airbnb.lottie.g> b(String str, @Nullable String str2) {
        return b(com.airbnb.lottie.a0.l0.c.a(Okio.buffer(Okio.source(new ByteArrayInputStream(str.getBytes())))), str2);
    }

    @Deprecated
    public static q<com.airbnb.lottie.g> a(JSONObject jSONObject, @Nullable String str) {
        return a(str, new g(jSONObject, str));
    }

    @WorkerThread
    public static p<com.airbnb.lottie.g> b(com.airbnb.lottie.a0.l0.c cVar, @Nullable String str) {
        return a(cVar, str, true);
    }

    public static q<com.airbnb.lottie.g> a(String str, @Nullable String str2) {
        return a(str2, new CallableC0047h(str, str2));
    }

    @WorkerThread
    public static p<com.airbnb.lottie.g> b(ZipInputStream zipInputStream, @Nullable String str) throws IOException {
        try {
            return c(zipInputStream, str);
        } finally {
            com.airbnb.lottie.b0.h.a(zipInputStream);
        }
    }

    public static q<com.airbnb.lottie.g> a(com.airbnb.lottie.a0.l0.c cVar, @Nullable String str) {
        return a(str, new i(cVar, str));
    }

    private static p<com.airbnb.lottie.g> a(com.airbnb.lottie.a0.l0.c cVar, @Nullable String str, boolean z) throws IOException {
        try {
            try {
                com.airbnb.lottie.g gVarA = com.airbnb.lottie.a0.t.a(cVar);
                if (str != null) {
                    com.airbnb.lottie.y.g.b().a(str, gVarA);
                }
                p<com.airbnb.lottie.g> pVar = new p<>(gVarA);
                if (z) {
                    com.airbnb.lottie.b0.h.a(cVar);
                }
                return pVar;
            } catch (Exception e2) {
                p<com.airbnb.lottie.g> pVar2 = new p<>(e2);
                if (z) {
                    com.airbnb.lottie.b0.h.a(cVar);
                }
                return pVar2;
            }
        } catch (Throwable th) {
            if (z) {
                com.airbnb.lottie.b0.h.a(cVar);
            }
            throw th;
        }
    }

    public static q<com.airbnb.lottie.g> a(ZipInputStream zipInputStream, @Nullable String str) {
        return a(str, new j(zipInputStream, str));
    }

    private static Boolean a(BufferedSource bufferedSource) {
        try {
            BufferedSource bufferedSourcePeek = bufferedSource.peek();
            for (byte b2 : f3508b) {
                if (bufferedSourcePeek.readByte() != b2) {
                    return false;
                }
            }
            bufferedSourcePeek.close();
            return true;
        } catch (Exception e2) {
            com.airbnb.lottie.b0.d.b("Failed to check zip file header", e2);
            return false;
        }
    }

    @Nullable
    private static com.airbnb.lottie.k a(com.airbnb.lottie.g gVar, String str) {
        for (com.airbnb.lottie.k kVar : gVar.h().values()) {
            if (kVar.c().equals(str)) {
                return kVar;
            }
        }
        return null;
    }

    private static q<com.airbnb.lottie.g> a(@Nullable String str, Callable<p<com.airbnb.lottie.g>> callable) {
        com.airbnb.lottie.g gVarA = str == null ? null : com.airbnb.lottie.y.g.b().a(str);
        if (gVarA != null) {
            return new q<>(new k(gVarA));
        }
        if (str != null && f3507a.containsKey(str)) {
            return f3507a.get(str);
        }
        q<com.airbnb.lottie.g> qVar = new q<>(callable);
        if (str != null) {
            qVar.b(new a(str));
            qVar.a(new b(str));
            f3507a.put(str, qVar);
        }
        return qVar;
    }
}
