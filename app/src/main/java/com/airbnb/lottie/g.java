package com.airbnb.lottie;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import androidx.annotation.Nullable;
import androidx.annotation.RawRes;
import androidx.annotation.RestrictTo;
import androidx.annotation.WorkerThread;
import androidx.collection.LongSparseArray;
import androidx.collection.SparseArrayCompat;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: LottieComposition.java */
/* loaded from: classes.dex */
public class g {

    /* renamed from: c, reason: collision with root package name */
    private Map<String, List<com.airbnb.lottie.y.l.d>> f3494c;

    /* renamed from: d, reason: collision with root package name */
    private Map<String, k> f3495d;

    /* renamed from: e, reason: collision with root package name */
    private Map<String, com.airbnb.lottie.y.c> f3496e;

    /* renamed from: f, reason: collision with root package name */
    private List<com.airbnb.lottie.y.h> f3497f;

    /* renamed from: g, reason: collision with root package name */
    private SparseArrayCompat<com.airbnb.lottie.y.d> f3498g;

    /* renamed from: h, reason: collision with root package name */
    private LongSparseArray<com.airbnb.lottie.y.l.d> f3499h;

    /* renamed from: i, reason: collision with root package name */
    private List<com.airbnb.lottie.y.l.d> f3500i;

    /* renamed from: j, reason: collision with root package name */
    private Rect f3501j;

    /* renamed from: k, reason: collision with root package name */
    private float f3502k;

    /* renamed from: l, reason: collision with root package name */
    private float f3503l;

    /* renamed from: m, reason: collision with root package name */
    private float f3504m;
    private boolean n;

    /* renamed from: a, reason: collision with root package name */
    private final s f3492a = new s();

    /* renamed from: b, reason: collision with root package name */
    private final HashSet<String> f3493b = new HashSet<>();
    private int o = 0;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void a(Rect rect, float f2, float f3, float f4, List<com.airbnb.lottie.y.l.d> list, LongSparseArray<com.airbnb.lottie.y.l.d> longSparseArray, Map<String, List<com.airbnb.lottie.y.l.d>> map, Map<String, k> map2, SparseArrayCompat<com.airbnb.lottie.y.d> sparseArrayCompat, Map<String, com.airbnb.lottie.y.c> map3, List<com.airbnb.lottie.y.h> list2) {
        this.f3501j = rect;
        this.f3502k = f2;
        this.f3503l = f3;
        this.f3504m = f4;
        this.f3500i = list;
        this.f3499h = longSparseArray;
        this.f3494c = map;
        this.f3495d = map2;
        this.f3498g = sparseArrayCompat;
        this.f3496e = map3;
        this.f3497f = list2;
    }

    public void b(boolean z) {
        this.f3492a.a(z);
    }

    public float c() {
        return (long) ((d() / this.f3504m) * 1000.0f);
    }

    public float d() {
        return this.f3503l - this.f3502k;
    }

    public float e() {
        return this.f3503l;
    }

    public Map<String, com.airbnb.lottie.y.c> f() {
        return this.f3496e;
    }

    public float g() {
        return this.f3504m;
    }

    public Map<String, k> h() {
        return this.f3495d;
    }

    public List<com.airbnb.lottie.y.l.d> i() {
        return this.f3500i;
    }

    public List<com.airbnb.lottie.y.h> j() {
        return this.f3497f;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public int k() {
        return this.o;
    }

    public s l() {
        return this.f3492a;
    }

    public float m() {
        return this.f3502k;
    }

    public ArrayList<String> n() {
        HashSet<String> hashSet = this.f3493b;
        return new ArrayList<>(Arrays.asList(hashSet.toArray(new String[hashSet.size()])));
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean o() {
        return this.n;
    }

    public boolean p() {
        return !this.f3495d.isEmpty();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("LottieComposition:\n");
        Iterator<com.airbnb.lottie.y.l.d> it = this.f3500i.iterator();
        while (it.hasNext()) {
            sb.append(it.next().a("\t"));
        }
        return sb.toString();
    }

    /* compiled from: LottieComposition.java */
    @Deprecated
    public static class b {

        /* compiled from: LottieComposition.java */
        private static final class a implements l<g>, com.airbnb.lottie.b {

            /* renamed from: a, reason: collision with root package name */
            private final InterfaceC0339r f3505a;

            /* renamed from: b, reason: collision with root package name */
            private boolean f3506b;

            @Override // com.airbnb.lottie.l
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onResult(g gVar) {
                if (this.f3506b) {
                    return;
                }
                this.f3505a.a(gVar);
            }

            @Override // com.airbnb.lottie.b
            public void cancel() {
                this.f3506b = true;
            }

            private a(InterfaceC0339r interfaceC0339r) {
                this.f3506b = false;
                this.f3505a = interfaceC0339r;
            }
        }

        private b() {
        }

        @Deprecated
        public static com.airbnb.lottie.b a(Context context, String str, InterfaceC0339r interfaceC0339r) {
            a aVar = new a(interfaceC0339r);
            h.a(context, str).b(aVar);
            return aVar;
        }

        @Deprecated
        public static com.airbnb.lottie.b a(Context context, @RawRes int i2, InterfaceC0339r interfaceC0339r) {
            a aVar = new a(interfaceC0339r);
            h.a(context, i2).b(aVar);
            return aVar;
        }

        @Deprecated
        public static com.airbnb.lottie.b a(InputStream inputStream, InterfaceC0339r interfaceC0339r) {
            a aVar = new a(interfaceC0339r);
            h.a(inputStream, (String) null).b(aVar);
            return aVar;
        }

        @Deprecated
        public static com.airbnb.lottie.b a(String str, InterfaceC0339r interfaceC0339r) {
            a aVar = new a(interfaceC0339r);
            h.a(str, (String) null).b(aVar);
            return aVar;
        }

        @Deprecated
        public static com.airbnb.lottie.b a(com.airbnb.lottie.a0.l0.c cVar, InterfaceC0339r interfaceC0339r) {
            a aVar = new a(interfaceC0339r);
            h.a(cVar, (String) null).b(aVar);
            return aVar;
        }

        @Nullable
        @WorkerThread
        @Deprecated
        public static g a(Context context, String str) {
            return h.b(context, str).b();
        }

        @Nullable
        @WorkerThread
        @Deprecated
        public static g a(InputStream inputStream) {
            return h.b(inputStream, (String) null).b();
        }

        @Nullable
        @WorkerThread
        @Deprecated
        public static g a(InputStream inputStream, boolean z) {
            if (z) {
                com.airbnb.lottie.b0.d.b("Lottie now auto-closes input stream!");
            }
            return h.b(inputStream, (String) null).b();
        }

        @Nullable
        @WorkerThread
        @Deprecated
        public static g a(Resources resources, JSONObject jSONObject) {
            return h.b(jSONObject, (String) null).b();
        }

        @Nullable
        @WorkerThread
        @Deprecated
        public static g a(String str) {
            return h.b(str, (String) null).b();
        }

        @Nullable
        @WorkerThread
        @Deprecated
        public static g a(com.airbnb.lottie.a0.l0.c cVar) {
            return h.b(cVar, (String) null).b();
        }
    }

    public float b(float f2) {
        float f3 = this.f3502k;
        return (f2 - f3) / (this.f3503l - f3);
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public List<com.airbnb.lottie.y.l.d> c(String str) {
        return this.f3494c.get(str);
    }

    public SparseArrayCompat<com.airbnb.lottie.y.d> b() {
        return this.f3498g;
    }

    @Nullable
    public com.airbnb.lottie.y.h b(String str) {
        int size = this.f3497f.size();
        for (int i2 = 0; i2 < size; i2++) {
            com.airbnb.lottie.y.h hVar = this.f3497f.get(i2);
            if (hVar.a(str)) {
                return hVar;
            }
        }
        return null;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void a(String str) {
        com.airbnb.lottie.b0.d.b(str);
        this.f3493b.add(str);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void a(boolean z) {
        this.n = z;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void a(int i2) {
        this.o += i2;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public com.airbnb.lottie.y.l.d a(long j2) {
        return this.f3499h.get(j2);
    }

    public Rect a() {
        return this.f3501j;
    }

    public float a(float f2) {
        return com.airbnb.lottie.b0.g.c(this.f3502k, this.f3503l, f2);
    }
}
