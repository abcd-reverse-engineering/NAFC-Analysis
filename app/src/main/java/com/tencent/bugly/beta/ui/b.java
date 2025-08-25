package com.tencent.bugly.beta.ui;

import android.view.KeyEvent;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public abstract class b extends Fragment {

    /* renamed from: m, reason: collision with root package name */
    protected boolean f8828m = false;

    public synchronized void a() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    public abstract boolean a(int i2, KeyEvent keyEvent);

    public synchronized boolean b() {
        return this.f8828m;
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        synchronized (this) {
            this.f8828m = false;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        synchronized (this) {
            this.f8828m = true;
        }
    }
}
