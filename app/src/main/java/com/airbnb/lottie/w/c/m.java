package com.airbnb.lottie.w.c;

import android.graphics.PointF;
import androidx.annotation.Nullable;
import java.util.Collections;

/* compiled from: SplitDimensionPathKeyframeAnimation.java */
/* loaded from: classes.dex */
public class m extends a<PointF, PointF> {

    /* renamed from: i, reason: collision with root package name */
    private final PointF f3770i;

    /* renamed from: j, reason: collision with root package name */
    private final PointF f3771j;

    /* renamed from: k, reason: collision with root package name */
    private final a<Float, Float> f3772k;

    /* renamed from: l, reason: collision with root package name */
    private final a<Float, Float> f3773l;

    /* renamed from: m, reason: collision with root package name */
    @Nullable
    protected com.airbnb.lottie.c0.j<Float> f3774m;

    @Nullable
    protected com.airbnb.lottie.c0.j<Float> n;

    public m(a<Float, Float> aVar, a<Float, Float> aVar2) {
        super(Collections.emptyList());
        this.f3770i = new PointF();
        this.f3771j = new PointF();
        this.f3772k = aVar;
        this.f3773l = aVar2;
        a(e());
    }

    public void b(@Nullable com.airbnb.lottie.c0.j<Float> jVar) {
        com.airbnb.lottie.c0.j<Float> jVar2 = this.f3774m;
        if (jVar2 != null) {
            jVar2.a((a<?, ?>) null);
        }
        this.f3774m = jVar;
        if (jVar != null) {
            jVar.a(this);
        }
    }

    public void c(@Nullable com.airbnb.lottie.c0.j<Float> jVar) {
        com.airbnb.lottie.c0.j<Float> jVar2 = this.n;
        if (jVar2 != null) {
            jVar2.a((a<?, ?>) null);
        }
        this.n = jVar;
        if (jVar != null) {
            jVar.a(this);
        }
    }

    @Override // com.airbnb.lottie.w.c.a
    public void a(float f2) {
        this.f3772k.a(f2);
        this.f3773l.a(f2);
        this.f3770i.set(this.f3772k.f().floatValue(), this.f3773l.f().floatValue());
        for (int i2 = 0; i2 < this.f3744a.size(); i2++) {
            this.f3744a.get(i2).a();
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.airbnb.lottie.w.c.a
    public PointF f() {
        return a((com.airbnb.lottie.c0.a<PointF>) null, 0.0f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.airbnb.lottie.w.c.a
    public PointF a(com.airbnb.lottie.c0.a<PointF> aVar, float f2) {
        Float fA;
        com.airbnb.lottie.c0.a<Float> aVarA;
        com.airbnb.lottie.c0.a<Float> aVarA2;
        Float fA2 = null;
        if (this.f3774m == null || (aVarA2 = this.f3772k.a()) == null) {
            fA = null;
        } else {
            float fC = this.f3772k.c();
            Float f3 = aVarA2.f3456h;
            com.airbnb.lottie.c0.j<Float> jVar = this.f3774m;
            float f4 = aVarA2.f3455g;
            fA = jVar.a(f4, f3 == null ? f4 : f3.floatValue(), aVarA2.f3450b, aVarA2.f3451c, f2, f2, fC);
        }
        if (this.n != null && (aVarA = this.f3773l.a()) != null) {
            float fC2 = this.f3773l.c();
            Float f5 = aVarA.f3456h;
            com.airbnb.lottie.c0.j<Float> jVar2 = this.n;
            float f6 = aVarA.f3455g;
            fA2 = jVar2.a(f6, f5 == null ? f6 : f5.floatValue(), aVarA.f3450b, aVarA.f3451c, f2, f2, fC2);
        }
        if (fA == null) {
            this.f3771j.set(this.f3770i.x, 0.0f);
        } else {
            this.f3771j.set(fA.floatValue(), 0.0f);
        }
        if (fA2 == null) {
            PointF pointF = this.f3771j;
            pointF.set(pointF.x, this.f3770i.y);
        } else {
            PointF pointF2 = this.f3771j;
            pointF2.set(pointF2.x, fA2.floatValue());
        }
        return this.f3771j;
    }
}
