package com.scwang.smartrefresh.layout.b;

import android.animation.ValueAnimator;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.NonNull;

/* compiled from: RefreshContent.java */
/* loaded from: classes.dex */
public interface e {
    ValueAnimator.AnimatorUpdateListener a(int i2);

    void a(int i2, int i3, int i4);

    void a(MotionEvent motionEvent);

    void a(i iVar, View view, View view2);

    void a(k kVar);

    boolean a();

    void b(boolean z);

    boolean b();

    @NonNull
    View c();

    @NonNull
    View getView();
}
