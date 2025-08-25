package com.bumptech.glide;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import androidx.annotation.CheckResult;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RawRes;
import com.bumptech.glide.r.l.m;
import com.bumptech.glide.r.l.p;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;

/* compiled from: RequestBuilder.java */
/* loaded from: classes.dex */
public class j<TranscodeType> extends com.bumptech.glide.r.a<j<TranscodeType>> implements Cloneable, g<j<TranscodeType>> {
    protected static final com.bumptech.glide.r.h v0 = new com.bumptech.glide.r.h().a(com.bumptech.glide.load.p.j.f4572c).a(h.LOW).b(true);
    private final Context h0;
    private final k i0;
    private final Class<TranscodeType> j0;
    private final b k0;
    private final d l0;

    @NonNull
    private l<?, ? super TranscodeType> m0;

    @Nullable
    private Object n0;

    @Nullable
    private List<com.bumptech.glide.r.g<TranscodeType>> o0;

    @Nullable
    private j<TranscodeType> p0;

    @Nullable
    private j<TranscodeType> q0;

    @Nullable
    private Float r0;
    private boolean s0;
    private boolean t0;
    private boolean u0;

    /* compiled from: RequestBuilder.java */
    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f4216a;

        /* renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f4217b = new int[h.values().length];

        static {
            try {
                f4217b[h.LOW.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f4217b[h.NORMAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f4217b[h.HIGH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f4217b[h.IMMEDIATE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f4216a = new int[ImageView.ScaleType.values().length];
            try {
                f4216a[ImageView.ScaleType.CENTER_CROP.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f4216a[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f4216a[ImageView.ScaleType.FIT_CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f4216a[ImageView.ScaleType.FIT_START.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f4216a[ImageView.ScaleType.FIT_END.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f4216a[ImageView.ScaleType.FIT_XY.ordinal()] = 6;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f4216a[ImageView.ScaleType.CENTER.ordinal()] = 7;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f4216a[ImageView.ScaleType.MATRIX.ordinal()] = 8;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    @SuppressLint({"CheckResult"})
    protected j(@NonNull b bVar, k kVar, Class<TranscodeType> cls, Context context) {
        this.s0 = true;
        this.k0 = bVar;
        this.i0 = kVar;
        this.j0 = cls;
        this.h0 = context;
        this.m0 = kVar.b((Class) cls);
        this.l0 = bVar.g();
        a(kVar.g());
        a((com.bumptech.glide.r.a<?>) kVar.h());
    }

    @NonNull
    @CheckResult
    protected j<File> R() {
        return new j(File.class, this).a((com.bumptech.glide.r.a<?>) v0);
    }

    @NonNull
    public p<TranscodeType> S() {
        return d(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    @NonNull
    public com.bumptech.glide.r.c<TranscodeType> T() {
        return e(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    @Override // com.bumptech.glide.r.a
    @NonNull
    @CheckResult
    public /* bridge */ /* synthetic */ com.bumptech.glide.r.a a(@NonNull com.bumptech.glide.r.a aVar) {
        return a((com.bumptech.glide.r.a<?>) aVar);
    }

    @NonNull
    @CheckResult
    public j<TranscodeType> b(@Nullable com.bumptech.glide.r.g<TranscodeType> gVar) {
        this.o0 = null;
        return a((com.bumptech.glide.r.g) gVar);
    }

    @Deprecated
    public com.bumptech.glide.r.c<TranscodeType> c(int i2, int i3) {
        return e(i2, i3);
    }

    @NonNull
    public com.bumptech.glide.r.c<TranscodeType> e(int i2, int i3) {
        com.bumptech.glide.r.f fVar = new com.bumptech.glide.r.f(i2, i3);
        return (com.bumptech.glide.r.c) a((j<TranscodeType>) fVar, fVar, com.bumptech.glide.util.d.a());
    }

    @Override // com.bumptech.glide.g
    @NonNull
    @CheckResult
    public j<TranscodeType> d(@Nullable Drawable drawable) {
        return b((Object) drawable).a((com.bumptech.glide.r.a<?>) com.bumptech.glide.r.h.b(com.bumptech.glide.load.p.j.f4571b));
    }

    @NonNull
    @CheckResult
    public j<TranscodeType> b(@Nullable j<TranscodeType> jVar) {
        this.p0 = jVar;
        return this;
    }

    @Override // com.bumptech.glide.r.a
    @CheckResult
    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public j<TranscodeType> mo36clone() {
        j<TranscodeType> jVar = (j) super.mo36clone();
        jVar.m0 = jVar.m0.m37clone();
        return jVar;
    }

    @NonNull
    public p<TranscodeType> d(int i2, int i3) {
        return b((j<TranscodeType>) m.a(this.i0, i2, i3));
    }

    @NonNull
    @CheckResult
    public j<TranscodeType> b(float f2) {
        if (f2 >= 0.0f && f2 <= 1.0f) {
            this.r0 = Float.valueOf(f2);
            return this;
        }
        throw new IllegalArgumentException("sizeMultiplier must be between 0 and 1");
    }

    @NonNull
    private j<TranscodeType> b(@Nullable Object obj) {
        this.n0 = obj;
        this.t0 = true;
        return this;
    }

    @NonNull
    public <Y extends p<TranscodeType>> Y b(@NonNull Y y) {
        return (Y) a((j<TranscodeType>) y, (com.bumptech.glide.r.g) null, com.bumptech.glide.util.d.b());
    }

    private <Y extends p<TranscodeType>> Y b(@NonNull Y y, @Nullable com.bumptech.glide.r.g<TranscodeType> gVar, com.bumptech.glide.r.a<?> aVar, Executor executor) {
        com.bumptech.glide.util.j.a(y);
        if (this.t0) {
            com.bumptech.glide.r.d dVarA = a(y, gVar, aVar, executor);
            com.bumptech.glide.r.d dVarA2 = y.a();
            if (dVarA.a(dVarA2) && !a(aVar, dVarA2)) {
                if (!((com.bumptech.glide.r.d) com.bumptech.glide.util.j.a(dVarA2)).isRunning()) {
                    dVarA2.c();
                }
                return y;
            }
            this.i0.a((p<?>) y);
            y.a(dVarA);
            this.i0.a(y, dVarA);
            return y;
        }
        throw new IllegalArgumentException("You must call #load() before calling #into()");
    }

    @SuppressLint({"CheckResult"})
    private void a(List<com.bumptech.glide.r.g<Object>> list) {
        Iterator<com.bumptech.glide.r.g<Object>> it = list.iterator();
        while (it.hasNext()) {
            a((com.bumptech.glide.r.g) it.next());
        }
    }

    @SuppressLint({"CheckResult"})
    protected j(Class<TranscodeType> cls, j<?> jVar) {
        this(jVar.k0, jVar.i0, cls, jVar.h0);
        this.n0 = jVar.n0;
        this.t0 = jVar.t0;
        a((com.bumptech.glide.r.a<?>) jVar);
    }

    @Override // com.bumptech.glide.r.a
    @NonNull
    @CheckResult
    public j<TranscodeType> a(@NonNull com.bumptech.glide.r.a<?> aVar) {
        com.bumptech.glide.util.j.a(aVar);
        return (j) super.a(aVar);
    }

    @NonNull
    @CheckResult
    public j<TranscodeType> a(@NonNull l<?, ? super TranscodeType> lVar) {
        this.m0 = (l) com.bumptech.glide.util.j.a(lVar);
        this.s0 = false;
        return this;
    }

    @NonNull
    @CheckResult
    public j<TranscodeType> a(@Nullable com.bumptech.glide.r.g<TranscodeType> gVar) {
        if (gVar != null) {
            if (this.o0 == null) {
                this.o0 = new ArrayList();
            }
            this.o0.add(gVar);
        }
        return this;
    }

    @NonNull
    public j<TranscodeType> a(@Nullable j<TranscodeType> jVar) {
        this.q0 = jVar;
        return this;
    }

    @NonNull
    @CheckResult
    public j<TranscodeType> a(@Nullable j<TranscodeType>... jVarArr) {
        j<TranscodeType> jVarB = null;
        if (jVarArr != null && jVarArr.length != 0) {
            for (int length = jVarArr.length - 1; length >= 0; length--) {
                j<TranscodeType> jVar = jVarArr[length];
                if (jVar != null) {
                    jVarB = jVarB == null ? jVar : jVar.b((j) jVarB);
                }
            }
            return b((j) jVarB);
        }
        return b((j) null);
    }

    @CheckResult
    @Deprecated
    public com.bumptech.glide.r.c<File> b(int i2, int i3) {
        return R().e(i2, i3);
    }

    @NonNull
    private h b(@NonNull h hVar) {
        int i2 = a.f4217b[hVar.ordinal()];
        if (i2 == 1) {
            return h.NORMAL;
        }
        if (i2 == 2) {
            return h.HIGH;
        }
        if (i2 != 3 && i2 != 4) {
            throw new IllegalArgumentException("unknown priority: " + t());
        }
        return h.IMMEDIATE;
    }

    @Override // com.bumptech.glide.g
    @NonNull
    @CheckResult
    public j<TranscodeType> a(@Nullable Object obj) {
        return b(obj);
    }

    private com.bumptech.glide.r.d b(Object obj, p<TranscodeType> pVar, com.bumptech.glide.r.g<TranscodeType> gVar, @Nullable com.bumptech.glide.r.e eVar, l<?, ? super TranscodeType> lVar, h hVar, int i2, int i3, com.bumptech.glide.r.a<?> aVar, Executor executor) {
        h hVarB;
        j<TranscodeType> jVar = this.p0;
        if (jVar != null) {
            if (!this.u0) {
                l<?, ? super TranscodeType> lVar2 = jVar.s0 ? lVar : jVar.m0;
                if (this.p0.F()) {
                    hVarB = this.p0.t();
                } else {
                    hVarB = b(hVar);
                }
                h hVar2 = hVarB;
                int iQ = this.p0.q();
                int iP = this.p0.p();
                if (com.bumptech.glide.util.l.b(i2, i3) && !this.p0.L()) {
                    iQ = aVar.q();
                    iP = aVar.p();
                }
                com.bumptech.glide.r.k kVar = new com.bumptech.glide.r.k(obj, eVar);
                com.bumptech.glide.r.d dVarA = a(obj, pVar, gVar, aVar, kVar, lVar, hVar, i2, i3, executor);
                this.u0 = true;
                j<TranscodeType> jVar2 = this.p0;
                com.bumptech.glide.r.d dVarA2 = jVar2.a(obj, pVar, gVar, kVar, lVar2, hVar2, iQ, iP, jVar2, executor);
                this.u0 = false;
                kVar.a(dVarA, dVarA2);
                return kVar;
            }
            throw new IllegalStateException("You cannot use a request as both the main request and a thumbnail, consider using clone() on the request(s) passed to thumbnail()");
        }
        if (this.r0 != null) {
            com.bumptech.glide.r.k kVar2 = new com.bumptech.glide.r.k(obj, eVar);
            kVar2.a(a(obj, pVar, gVar, aVar, kVar2, lVar, hVar, i2, i3, executor), a(obj, pVar, gVar, aVar.mo36clone().a(this.r0.floatValue()), kVar2, lVar, b(hVar), i2, i3, executor));
            return kVar2;
        }
        return a(obj, pVar, gVar, aVar, eVar, lVar, hVar, i2, i3, executor);
    }

    @Override // com.bumptech.glide.g
    @NonNull
    @CheckResult
    public j<TranscodeType> a(@Nullable Bitmap bitmap) {
        return b(bitmap).a((com.bumptech.glide.r.a<?>) com.bumptech.glide.r.h.b(com.bumptech.glide.load.p.j.f4571b));
    }

    @Override // com.bumptech.glide.g
    @NonNull
    @CheckResult
    public j<TranscodeType> a(@Nullable String str) {
        return b(str);
    }

    @Override // com.bumptech.glide.g
    @NonNull
    @CheckResult
    public j<TranscodeType> a(@Nullable Uri uri) {
        return b(uri);
    }

    @Override // com.bumptech.glide.g
    @NonNull
    @CheckResult
    public j<TranscodeType> a(@Nullable File file) {
        return b(file);
    }

    @Override // com.bumptech.glide.g
    @NonNull
    @CheckResult
    public j<TranscodeType> a(@Nullable @DrawableRes @RawRes Integer num) {
        return b(num).a((com.bumptech.glide.r.a<?>) com.bumptech.glide.r.h.b(com.bumptech.glide.s.a.a(this.h0)));
    }

    @Override // com.bumptech.glide.g
    @CheckResult
    @Deprecated
    public j<TranscodeType> a(@Nullable URL url) {
        return b(url);
    }

    @Override // com.bumptech.glide.g
    @NonNull
    @CheckResult
    public j<TranscodeType> a(@Nullable byte[] bArr) {
        j<TranscodeType> jVarB = b(bArr);
        if (!jVarB.C()) {
            jVarB = jVarB.a((com.bumptech.glide.r.a<?>) com.bumptech.glide.r.h.b(com.bumptech.glide.load.p.j.f4571b));
        }
        return !jVarB.H() ? jVarB.a((com.bumptech.glide.r.a<?>) com.bumptech.glide.r.h.e(true)) : jVarB;
    }

    @NonNull
    <Y extends p<TranscodeType>> Y a(@NonNull Y y, @Nullable com.bumptech.glide.r.g<TranscodeType> gVar, Executor executor) {
        return (Y) b(y, gVar, this, executor);
    }

    private boolean a(com.bumptech.glide.r.a<?> aVar, com.bumptech.glide.r.d dVar) {
        return !aVar.E() && dVar.d();
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x004c  */
    @androidx.annotation.NonNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.bumptech.glide.r.l.r<android.widget.ImageView, TranscodeType> a(@androidx.annotation.NonNull android.widget.ImageView r4) {
        /*
            r3 = this;
            com.bumptech.glide.util.l.b()
            com.bumptech.glide.util.j.a(r4)
            boolean r0 = r3.K()
            if (r0 != 0) goto L4c
            boolean r0 = r3.I()
            if (r0 == 0) goto L4c
            android.widget.ImageView$ScaleType r0 = r4.getScaleType()
            if (r0 == 0) goto L4c
            int[] r0 = com.bumptech.glide.j.a.f4216a
            android.widget.ImageView$ScaleType r1 = r4.getScaleType()
            int r1 = r1.ordinal()
            r0 = r0[r1]
            switch(r0) {
                case 1: goto L43;
                case 2: goto L3a;
                case 3: goto L31;
                case 4: goto L31;
                case 5: goto L31;
                case 6: goto L28;
                default: goto L27;
            }
        L27:
            goto L4c
        L28:
            com.bumptech.glide.r.a r0 = r3.mo36clone()
            com.bumptech.glide.r.a r0 = r0.O()
            goto L4d
        L31:
            com.bumptech.glide.r.a r0 = r3.mo36clone()
            com.bumptech.glide.r.a r0 = r0.Q()
            goto L4d
        L3a:
            com.bumptech.glide.r.a r0 = r3.mo36clone()
            com.bumptech.glide.r.a r0 = r0.O()
            goto L4d
        L43:
            com.bumptech.glide.r.a r0 = r3.mo36clone()
            com.bumptech.glide.r.a r0 = r0.N()
            goto L4d
        L4c:
            r0 = r3
        L4d:
            com.bumptech.glide.d r1 = r3.l0
            java.lang.Class<TranscodeType> r2 = r3.j0
            com.bumptech.glide.r.l.r r4 = r1.a(r4, r2)
            r1 = 0
            java.util.concurrent.Executor r2 = com.bumptech.glide.util.d.b()
            com.bumptech.glide.r.l.p r4 = r3.b(r4, r1, r0, r2)
            com.bumptech.glide.r.l.r r4 = (com.bumptech.glide.r.l.r) r4
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.j.a(android.widget.ImageView):com.bumptech.glide.r.l.r");
    }

    @CheckResult
    @Deprecated
    public <Y extends p<File>> Y a(@NonNull Y y) {
        return (Y) R().b((j<File>) y);
    }

    private com.bumptech.glide.r.d a(p<TranscodeType> pVar, @Nullable com.bumptech.glide.r.g<TranscodeType> gVar, com.bumptech.glide.r.a<?> aVar, Executor executor) {
        return a(new Object(), pVar, gVar, (com.bumptech.glide.r.e) null, this.m0, aVar.t(), aVar.q(), aVar.p(), aVar, executor);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private com.bumptech.glide.r.d a(Object obj, p<TranscodeType> pVar, @Nullable com.bumptech.glide.r.g<TranscodeType> gVar, @Nullable com.bumptech.glide.r.e eVar, l<?, ? super TranscodeType> lVar, h hVar, int i2, int i3, com.bumptech.glide.r.a<?> aVar, Executor executor) {
        com.bumptech.glide.r.e eVar2;
        com.bumptech.glide.r.e bVar;
        if (this.q0 != null) {
            bVar = new com.bumptech.glide.r.b(obj, eVar);
            eVar2 = bVar;
        } else {
            eVar2 = null;
            bVar = eVar;
        }
        com.bumptech.glide.r.d dVarB = b(obj, pVar, gVar, bVar, lVar, hVar, i2, i3, aVar, executor);
        if (eVar2 == null) {
            return dVarB;
        }
        int iQ = this.q0.q();
        int iP = this.q0.p();
        if (com.bumptech.glide.util.l.b(i2, i3) && !this.q0.L()) {
            iQ = aVar.q();
            iP = aVar.p();
        }
        j<TranscodeType> jVar = this.q0;
        com.bumptech.glide.r.b bVar2 = eVar2;
        bVar2.a(dVarB, jVar.a(obj, pVar, gVar, bVar2, jVar.m0, jVar.t(), iQ, iP, this.q0, executor));
        return bVar2;
    }

    private com.bumptech.glide.r.d a(Object obj, p<TranscodeType> pVar, com.bumptech.glide.r.g<TranscodeType> gVar, com.bumptech.glide.r.a<?> aVar, com.bumptech.glide.r.e eVar, l<?, ? super TranscodeType> lVar, h hVar, int i2, int i3, Executor executor) {
        Context context = this.h0;
        d dVar = this.l0;
        return com.bumptech.glide.r.j.a(context, dVar, obj, this.n0, this.j0, aVar, i2, i3, hVar, pVar, gVar, this.o0, eVar, dVar.d(), lVar.b(), executor);
    }
}
