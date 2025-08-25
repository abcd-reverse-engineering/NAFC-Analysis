package com.airbnb.lottie.y.l;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Typeface;
import androidx.annotation.Nullable;
import androidx.collection.LongSparseArray;
import com.airbnb.lottie.j;
import com.airbnb.lottie.o;
import com.airbnb.lottie.w.c.n;
import com.airbnb.lottie.w.c.p;
import com.airbnb.lottie.y.b;
import com.airbnb.lottie.y.j.k;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: TextLayer.java */
/* loaded from: classes.dex */
public class h extends com.airbnb.lottie.y.l.a {
    private final StringBuilder D;
    private final RectF E;
    private final Matrix F;
    private final Paint G;
    private final Paint H;
    private final Map<com.airbnb.lottie.y.d, List<com.airbnb.lottie.w.b.d>> I;
    private final LongSparseArray<String> J;
    private final n K;
    private final j L;
    private final com.airbnb.lottie.g M;

    @Nullable
    private com.airbnb.lottie.w.c.a<Integer, Integer> N;

    @Nullable
    private com.airbnb.lottie.w.c.a<Integer, Integer> O;

    @Nullable
    private com.airbnb.lottie.w.c.a<Integer, Integer> P;

    @Nullable
    private com.airbnb.lottie.w.c.a<Integer, Integer> Q;

    @Nullable
    private com.airbnb.lottie.w.c.a<Float, Float> R;

    @Nullable
    private com.airbnb.lottie.w.c.a<Float, Float> S;

    @Nullable
    private com.airbnb.lottie.w.c.a<Float, Float> T;

    @Nullable
    private com.airbnb.lottie.w.c.a<Float, Float> U;

    @Nullable
    private com.airbnb.lottie.w.c.a<Float, Float> V;

    @Nullable
    private com.airbnb.lottie.w.c.a<Float, Float> W;

    @Nullable
    private com.airbnb.lottie.w.c.a<Typeface, Typeface> X;

    /* compiled from: TextLayer.java */
    class a extends Paint {
        a(int i2) {
            super(i2);
            setStyle(Paint.Style.FILL);
        }
    }

    /* compiled from: TextLayer.java */
    class b extends Paint {
        b(int i2) {
            super(i2);
            setStyle(Paint.Style.STROKE);
        }
    }

    /* compiled from: TextLayer.java */
    static /* synthetic */ class c {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f3987a = new int[b.a.values().length];

        static {
            try {
                f3987a[b.a.LEFT_ALIGN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3987a[b.a.RIGHT_ALIGN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3987a[b.a.CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    h(j jVar, d dVar) {
        com.airbnb.lottie.y.j.b bVar;
        com.airbnb.lottie.y.j.b bVar2;
        com.airbnb.lottie.y.j.a aVar;
        com.airbnb.lottie.y.j.a aVar2;
        super(jVar, dVar);
        this.D = new StringBuilder(2);
        this.E = new RectF();
        this.F = new Matrix();
        this.G = new a(1);
        this.H = new b(1);
        this.I = new HashMap();
        this.J = new LongSparseArray<>();
        this.L = jVar;
        this.M = dVar.a();
        this.K = dVar.q().a();
        this.K.a(this);
        a(this.K);
        k kVarR = dVar.r();
        if (kVarR != null && (aVar2 = kVarR.f3841a) != null) {
            this.N = aVar2.a();
            this.N.a(this);
            a(this.N);
        }
        if (kVarR != null && (aVar = kVarR.f3842b) != null) {
            this.P = aVar.a();
            this.P.a(this);
            a(this.P);
        }
        if (kVarR != null && (bVar2 = kVarR.f3843c) != null) {
            this.R = bVar2.a();
            this.R.a(this);
            a(this.R);
        }
        if (kVarR == null || (bVar = kVarR.f3844d) == null) {
            return;
        }
        this.T = bVar.a();
        this.T.a(this);
        a(this.T);
    }

    @Override // com.airbnb.lottie.y.l.a, com.airbnb.lottie.w.b.e
    public void a(RectF rectF, Matrix matrix, boolean z) {
        super.a(rectF, matrix, z);
        rectF.set(0.0f, 0.0f, this.M.a().width(), this.M.a().height());
    }

    @Override // com.airbnb.lottie.y.l.a
    void b(Canvas canvas, Matrix matrix, int i2) {
        canvas.save();
        if (!this.L.D()) {
            canvas.concat(matrix);
        }
        com.airbnb.lottie.y.b bVarF = this.K.f();
        com.airbnb.lottie.y.c cVar = this.M.f().get(bVarF.f3805b);
        if (cVar == null) {
            canvas.restore();
            return;
        }
        com.airbnb.lottie.w.c.a<Integer, Integer> aVar = this.O;
        if (aVar != null) {
            this.G.setColor(aVar.f().intValue());
        } else {
            com.airbnb.lottie.w.c.a<Integer, Integer> aVar2 = this.N;
            if (aVar2 != null) {
                this.G.setColor(aVar2.f().intValue());
            } else {
                this.G.setColor(bVarF.f3811h);
            }
        }
        com.airbnb.lottie.w.c.a<Integer, Integer> aVar3 = this.Q;
        if (aVar3 != null) {
            this.H.setColor(aVar3.f().intValue());
        } else {
            com.airbnb.lottie.w.c.a<Integer, Integer> aVar4 = this.P;
            if (aVar4 != null) {
                this.H.setColor(aVar4.f().intValue());
            } else {
                this.H.setColor(bVarF.f3812i);
            }
        }
        int iIntValue = ((this.v.c() == null ? 100 : this.v.c().f().intValue()) * 255) / 100;
        this.G.setAlpha(iIntValue);
        this.H.setAlpha(iIntValue);
        com.airbnb.lottie.w.c.a<Float, Float> aVar5 = this.S;
        if (aVar5 != null) {
            this.H.setStrokeWidth(aVar5.f().floatValue());
        } else {
            com.airbnb.lottie.w.c.a<Float, Float> aVar6 = this.R;
            if (aVar6 != null) {
                this.H.setStrokeWidth(aVar6.f().floatValue());
            } else {
                this.H.setStrokeWidth(bVarF.f3813j * com.airbnb.lottie.b0.h.a() * com.airbnb.lottie.b0.h.a(matrix));
            }
        }
        if (this.L.D()) {
            a(bVarF, matrix, cVar, canvas);
        } else {
            a(bVarF, cVar, matrix, canvas);
        }
        canvas.restore();
    }

    private void a(com.airbnb.lottie.y.b bVar, Matrix matrix, com.airbnb.lottie.y.c cVar, Canvas canvas) {
        float fFloatValue;
        com.airbnb.lottie.w.c.a<Float, Float> aVar = this.W;
        if (aVar != null) {
            fFloatValue = aVar.f().floatValue();
        } else {
            com.airbnb.lottie.w.c.a<Float, Float> aVar2 = this.V;
            if (aVar2 != null) {
                fFloatValue = aVar2.f().floatValue();
            } else {
                fFloatValue = bVar.f3806c;
            }
        }
        float f2 = fFloatValue / 100.0f;
        float fA = com.airbnb.lottie.b0.h.a(matrix);
        String str = bVar.f3804a;
        float fA2 = bVar.f3809f * com.airbnb.lottie.b0.h.a();
        List<String> listA = a(str);
        int size = listA.size();
        for (int i2 = 0; i2 < size; i2++) {
            String str2 = listA.get(i2);
            float fA3 = a(str2, cVar, f2, fA);
            canvas.save();
            a(bVar.f3807d, canvas, fA3);
            canvas.translate(0.0f, (i2 * fA2) - (((size - 1) * fA2) / 2.0f));
            a(str2, bVar, matrix, cVar, canvas, fA, f2);
            canvas.restore();
        }
    }

    private void a(String str, com.airbnb.lottie.y.b bVar, Matrix matrix, com.airbnb.lottie.y.c cVar, Canvas canvas, float f2, float f3) {
        float fFloatValue;
        for (int i2 = 0; i2 < str.length(); i2++) {
            com.airbnb.lottie.y.d dVar = this.M.b().get(com.airbnb.lottie.y.d.a(str.charAt(i2), cVar.b(), cVar.d()));
            if (dVar != null) {
                a(dVar, matrix, f3, bVar, canvas);
                float fD = ((float) dVar.d()) * f3 * com.airbnb.lottie.b0.h.a() * f2;
                float f4 = bVar.f3808e / 10.0f;
                com.airbnb.lottie.w.c.a<Float, Float> aVar = this.U;
                if (aVar != null) {
                    fFloatValue = aVar.f().floatValue();
                } else {
                    com.airbnb.lottie.w.c.a<Float, Float> aVar2 = this.T;
                    if (aVar2 != null) {
                        fFloatValue = aVar2.f().floatValue();
                    }
                    canvas.translate(fD + (f4 * f2), 0.0f);
                }
                f4 += fFloatValue;
                canvas.translate(fD + (f4 * f2), 0.0f);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x009e A[LOOP:0: B:23:0x009c->B:24:0x009e, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(com.airbnb.lottie.y.b r7, com.airbnb.lottie.y.c r8, android.graphics.Matrix r9, android.graphics.Canvas r10) {
        /*
            r6 = this;
            android.graphics.Typeface r8 = r6.a(r8)
            if (r8 != 0) goto L7
            return
        L7:
            java.lang.String r9 = r7.f3804a
            com.airbnb.lottie.j r0 = r6.L
            com.airbnb.lottie.v r0 = r0.q()
            if (r0 == 0) goto L15
            java.lang.String r9 = r0.b(r9)
        L15:
            android.graphics.Paint r0 = r6.G
            r0.setTypeface(r8)
            com.airbnb.lottie.w.c.a<java.lang.Float, java.lang.Float> r8 = r6.W
            if (r8 == 0) goto L29
            java.lang.Object r8 = r8.f()
            java.lang.Float r8 = (java.lang.Float) r8
            float r8 = r8.floatValue()
            goto L3a
        L29:
            com.airbnb.lottie.w.c.a<java.lang.Float, java.lang.Float> r8 = r6.V
            if (r8 == 0) goto L38
            java.lang.Object r8 = r8.f()
            java.lang.Float r8 = (java.lang.Float) r8
            float r8 = r8.floatValue()
            goto L3a
        L38:
            float r8 = r7.f3806c
        L3a:
            android.graphics.Paint r0 = r6.G
            float r1 = com.airbnb.lottie.b0.h.a()
            float r1 = r1 * r8
            r0.setTextSize(r1)
            android.graphics.Paint r0 = r6.H
            android.graphics.Paint r1 = r6.G
            android.graphics.Typeface r1 = r1.getTypeface()
            r0.setTypeface(r1)
            android.graphics.Paint r0 = r6.H
            android.graphics.Paint r1 = r6.G
            float r1 = r1.getTextSize()
            r0.setTextSize(r1)
            float r0 = r7.f3809f
            float r1 = com.airbnb.lottie.b0.h.a()
            float r0 = r0 * r1
            int r1 = r7.f3808e
            float r1 = (float) r1
            r2 = 1092616192(0x41200000, float:10.0)
            float r1 = r1 / r2
            com.airbnb.lottie.w.c.a<java.lang.Float, java.lang.Float> r2 = r6.U
            if (r2 == 0) goto L79
            java.lang.Object r2 = r2.f()
            java.lang.Float r2 = (java.lang.Float) r2
            float r2 = r2.floatValue()
        L77:
            float r1 = r1 + r2
            goto L88
        L79:
            com.airbnb.lottie.w.c.a<java.lang.Float, java.lang.Float> r2 = r6.T
            if (r2 == 0) goto L88
            java.lang.Object r2 = r2.f()
            java.lang.Float r2 = (java.lang.Float) r2
            float r2 = r2.floatValue()
            goto L77
        L88:
            float r2 = com.airbnb.lottie.b0.h.a()
            float r1 = r1 * r2
            float r1 = r1 * r8
            r8 = 1120403456(0x42c80000, float:100.0)
            float r1 = r1 / r8
            java.util.List r8 = r6.a(r9)
            int r9 = r8.size()
            r2 = 0
        L9c:
            if (r2 >= r9) goto Ld5
            java.lang.Object r3 = r8.get(r2)
            java.lang.String r3 = (java.lang.String) r3
            android.graphics.Paint r4 = r6.H
            float r4 = r4.measureText(r3)
            int r5 = r3.length()
            int r5 = r5 + (-1)
            float r5 = (float) r5
            float r5 = r5 * r1
            float r4 = r4 + r5
            r10.save()
            com.airbnb.lottie.y.b$a r5 = r7.f3807d
            r6.a(r5, r10, r4)
            int r4 = r9 + (-1)
            float r4 = (float) r4
            float r4 = r4 * r0
            r5 = 1073741824(0x40000000, float:2.0)
            float r4 = r4 / r5
            float r5 = (float) r2
            float r5 = r5 * r0
            float r5 = r5 - r4
            r4 = 0
            r10.translate(r4, r5)
            r6.a(r3, r7, r10, r1)
            r10.restore()
            int r2 = r2 + 1
            goto L9c
        Ld5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.y.l.h.a(com.airbnb.lottie.y.b, com.airbnb.lottie.y.c, android.graphics.Matrix, android.graphics.Canvas):void");
    }

    @Nullable
    private Typeface a(com.airbnb.lottie.y.c cVar) {
        Typeface typefaceF;
        com.airbnb.lottie.w.c.a<Typeface, Typeface> aVar = this.X;
        if (aVar != null && (typefaceF = aVar.f()) != null) {
            return typefaceF;
        }
        Typeface typefaceA = this.L.a(cVar.b(), cVar.d());
        return typefaceA != null ? typefaceA : cVar.e();
    }

    private List<String> a(String str) {
        return Arrays.asList(str.replaceAll("\r\n", "\r").replaceAll("\n", "\r").split("\r"));
    }

    private void a(String str, com.airbnb.lottie.y.b bVar, Canvas canvas, float f2) {
        int length = 0;
        while (length < str.length()) {
            String strA = a(str, length);
            length += strA.length();
            a(strA, bVar, canvas);
            canvas.translate(this.G.measureText(strA) + f2, 0.0f);
        }
    }

    private float a(String str, com.airbnb.lottie.y.c cVar, float f2, float f3) {
        float fD = 0.0f;
        for (int i2 = 0; i2 < str.length(); i2++) {
            com.airbnb.lottie.y.d dVar = this.M.b().get(com.airbnb.lottie.y.d.a(str.charAt(i2), cVar.b(), cVar.d()));
            if (dVar != null) {
                fD = (float) (fD + (dVar.d() * f2 * com.airbnb.lottie.b0.h.a() * f3));
            }
        }
        return fD;
    }

    private void a(b.a aVar, Canvas canvas, float f2) {
        int i2 = c.f3987a[aVar.ordinal()];
        if (i2 != 1) {
            if (i2 == 2) {
                canvas.translate(-f2, 0.0f);
            } else {
                if (i2 != 3) {
                    return;
                }
                canvas.translate((-f2) / 2.0f, 0.0f);
            }
        }
    }

    private void a(com.airbnb.lottie.y.d dVar, Matrix matrix, float f2, com.airbnb.lottie.y.b bVar, Canvas canvas) {
        List<com.airbnb.lottie.w.b.d> listA = a(dVar);
        for (int i2 = 0; i2 < listA.size(); i2++) {
            Path path = listA.get(i2).getPath();
            path.computeBounds(this.E, false);
            this.F.set(matrix);
            this.F.preTranslate(0.0f, (-bVar.f3810g) * com.airbnb.lottie.b0.h.a());
            this.F.preScale(f2, f2);
            path.transform(this.F);
            if (bVar.f3814k) {
                a(path, this.G, canvas);
                a(path, this.H, canvas);
            } else {
                a(path, this.H, canvas);
                a(path, this.G, canvas);
            }
        }
    }

    private void a(Path path, Paint paint, Canvas canvas) {
        if (paint.getColor() == 0) {
            return;
        }
        if (paint.getStyle() == Paint.Style.STROKE && paint.getStrokeWidth() == 0.0f) {
            return;
        }
        canvas.drawPath(path, paint);
    }

    private void a(String str, com.airbnb.lottie.y.b bVar, Canvas canvas) {
        if (bVar.f3814k) {
            a(str, this.G, canvas);
            a(str, this.H, canvas);
        } else {
            a(str, this.H, canvas);
            a(str, this.G, canvas);
        }
    }

    private void a(String str, Paint paint, Canvas canvas) {
        if (paint.getColor() == 0) {
            return;
        }
        if (paint.getStyle() == Paint.Style.STROKE && paint.getStrokeWidth() == 0.0f) {
            return;
        }
        canvas.drawText(str, 0, str.length(), 0.0f, 0.0f, paint);
    }

    private List<com.airbnb.lottie.w.b.d> a(com.airbnb.lottie.y.d dVar) {
        if (this.I.containsKey(dVar)) {
            return this.I.get(dVar);
        }
        List<com.airbnb.lottie.y.k.n> listA = dVar.a();
        int size = listA.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i2 = 0; i2 < size; i2++) {
            arrayList.add(new com.airbnb.lottie.w.b.d(this.L, this, listA.get(i2)));
        }
        this.I.put(dVar, arrayList);
        return arrayList;
    }

    private String a(String str, int i2) {
        int iCodePointAt = str.codePointAt(i2);
        int iCharCount = Character.charCount(iCodePointAt) + i2;
        while (iCharCount < str.length()) {
            int iCodePointAt2 = str.codePointAt(iCharCount);
            if (!a(iCodePointAt2)) {
                break;
            }
            iCharCount += Character.charCount(iCodePointAt2);
            iCodePointAt = (iCodePointAt * 31) + iCodePointAt2;
        }
        long j2 = iCodePointAt;
        if (this.J.containsKey(j2)) {
            return this.J.get(j2);
        }
        this.D.setLength(0);
        while (i2 < iCharCount) {
            int iCodePointAt3 = str.codePointAt(i2);
            this.D.appendCodePoint(iCodePointAt3);
            i2 += Character.charCount(iCodePointAt3);
        }
        String string = this.D.toString();
        this.J.put(j2, string);
        return string;
    }

    private boolean a(int i2) {
        return Character.getType(i2) == 16 || Character.getType(i2) == 27 || Character.getType(i2) == 6 || Character.getType(i2) == 28 || Character.getType(i2) == 19;
    }

    @Override // com.airbnb.lottie.y.l.a, com.airbnb.lottie.y.f
    public <T> void a(T t, @Nullable com.airbnb.lottie.c0.j<T> jVar) {
        super.a((h) t, (com.airbnb.lottie.c0.j<h>) jVar);
        if (t == o.f3598a) {
            com.airbnb.lottie.w.c.a<Integer, Integer> aVar = this.O;
            if (aVar != null) {
                b(aVar);
            }
            if (jVar == null) {
                this.O = null;
                return;
            }
            this.O = new p(jVar);
            this.O.a(this);
            a(this.O);
            return;
        }
        if (t == o.f3599b) {
            com.airbnb.lottie.w.c.a<Integer, Integer> aVar2 = this.Q;
            if (aVar2 != null) {
                b(aVar2);
            }
            if (jVar == null) {
                this.Q = null;
                return;
            }
            this.Q = new p(jVar);
            this.Q.a(this);
            a(this.Q);
            return;
        }
        if (t == o.q) {
            com.airbnb.lottie.w.c.a<Float, Float> aVar3 = this.S;
            if (aVar3 != null) {
                b(aVar3);
            }
            if (jVar == null) {
                this.S = null;
                return;
            }
            this.S = new p(jVar);
            this.S.a(this);
            a(this.S);
            return;
        }
        if (t == o.r) {
            com.airbnb.lottie.w.c.a<Float, Float> aVar4 = this.U;
            if (aVar4 != null) {
                b(aVar4);
            }
            if (jVar == null) {
                this.U = null;
                return;
            }
            this.U = new p(jVar);
            this.U.a(this);
            a(this.U);
            return;
        }
        if (t == o.D) {
            com.airbnb.lottie.w.c.a<Float, Float> aVar5 = this.W;
            if (aVar5 != null) {
                b(aVar5);
            }
            if (jVar == null) {
                this.W = null;
                return;
            }
            this.W = new p(jVar);
            this.W.a(this);
            a(this.W);
            return;
        }
        if (t == o.G) {
            com.airbnb.lottie.w.c.a<Typeface, Typeface> aVar6 = this.X;
            if (aVar6 != null) {
                b(aVar6);
            }
            if (jVar == null) {
                this.X = null;
                return;
            }
            this.X = new p(jVar);
            this.X.a(this);
            a(this.X);
        }
    }
}
