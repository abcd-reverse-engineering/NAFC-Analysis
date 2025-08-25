package com.scwang.smartrefresh.layout.b;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* compiled from: RefreshLayout.java */
/* loaded from: classes.dex */
public interface j {
    j a(@FloatRange(from = 1.0d, to = 10.0d) float f2);

    j a(int i2, boolean z);

    j a(int i2, boolean z, boolean z2);

    j a(@NonNull View view);

    j a(@NonNull View view, int i2, int i3);

    j a(@NonNull Interpolator interpolator);

    j a(@NonNull f fVar);

    j a(@NonNull f fVar, int i2, int i3);

    j a(@NonNull g gVar);

    j a(@NonNull g gVar, int i2, int i3);

    j a(k kVar);

    j a(com.scwang.smartrefresh.layout.d.b bVar);

    j a(com.scwang.smartrefresh.layout.d.c cVar);

    j a(com.scwang.smartrefresh.layout.d.d dVar);

    j a(com.scwang.smartrefresh.layout.d.e eVar);

    @Deprecated
    j a(boolean z);

    j a(@ColorRes int... iArr);

    boolean a();

    @Deprecated
    boolean a(int i2);

    boolean a(int i2, int i3, float f2, boolean z);

    j b();

    j b(@FloatRange(from = 0.0d, to = 1.0d) float f2);

    j b(int i2);

    j b(boolean z);

    boolean b(int i2, int i3, float f2, boolean z);

    j c();

    j c(float f2);

    j c(boolean z);

    @Deprecated
    boolean c(int i2);

    j d();

    j d(@FloatRange(from = 1.0d, to = 10.0d) float f2);

    j d(int i2);

    j d(boolean z);

    j e(float f2);

    j e(int i2);

    j e(boolean z);

    boolean e();

    j f();

    j f(float f2);

    j f(boolean z);

    j g();

    j g(@FloatRange(from = 0.0d, to = 1.0d) float f2);

    j g(boolean z);

    ViewGroup getLayout();

    @Nullable
    f getRefreshFooter();

    @Nullable
    g getRefreshHeader();

    com.scwang.smartrefresh.layout.c.b getState();

    j h(@FloatRange(from = 0.0d, to = 1.0d) float f2);

    j h(boolean z);

    boolean h();

    j i(float f2);

    j i(boolean z);

    boolean i();

    j j(boolean z);

    j k(boolean z);

    j l(boolean z);

    j m(boolean z);

    j n(boolean z);

    j o(boolean z);

    j p(boolean z);

    j q(boolean z);

    j r(boolean z);

    j s(boolean z);

    j setPrimaryColors(@ColorInt int... iArr);

    @Deprecated
    j t(boolean z);

    j u(boolean z);
}
