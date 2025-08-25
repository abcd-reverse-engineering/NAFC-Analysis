package org.greenrobot.eventbus.util;

import android.annotation.TargetApi;
import android.app.Fragment;
import android.os.Bundle;
import org.greenrobot.eventbus.util.ErrorDialogFragments;

/* compiled from: ErrorDialogFragmentFactory.java */
/* loaded from: classes2.dex */
public abstract class c<T> {

    /* renamed from: a, reason: collision with root package name */
    protected final org.greenrobot.eventbus.util.b f17494a;

    /* compiled from: ErrorDialogFragmentFactory.java */
    @TargetApi(11)
    public static class a extends c<Fragment> {
        public a(org.greenrobot.eventbus.util.b bVar) {
            super(bVar);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // org.greenrobot.eventbus.util.c
        public Fragment a(f fVar, Bundle bundle) {
            ErrorDialogFragments.Honeycomb honeycomb = new ErrorDialogFragments.Honeycomb();
            honeycomb.setArguments(bundle);
            return honeycomb;
        }
    }

    /* compiled from: ErrorDialogFragmentFactory.java */
    public static class b extends c<androidx.fragment.app.Fragment> {
        public b(org.greenrobot.eventbus.util.b bVar) {
            super(bVar);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // org.greenrobot.eventbus.util.c
        public androidx.fragment.app.Fragment a(f fVar, Bundle bundle) {
            ErrorDialogFragments.Support support = new ErrorDialogFragments.Support();
            support.setArguments(bundle);
            return support;
        }
    }

    protected c(org.greenrobot.eventbus.util.b bVar) {
        this.f17494a = bVar;
    }

    protected abstract T a(f fVar, Bundle bundle);

    protected T a(f fVar, boolean z, Bundle bundle) {
        int i2;
        Class<?> cls;
        if (fVar.c()) {
            return null;
        }
        Bundle bundle2 = bundle != null ? (Bundle) bundle.clone() : new Bundle();
        if (!bundle2.containsKey(ErrorDialogManager.f17462d)) {
            bundle2.putString(ErrorDialogManager.f17462d, c(fVar, bundle2));
        }
        if (!bundle2.containsKey(ErrorDialogManager.f17463e)) {
            bundle2.putString(ErrorDialogManager.f17463e, b(fVar, bundle2));
        }
        if (!bundle2.containsKey(ErrorDialogManager.f17464f)) {
            bundle2.putBoolean(ErrorDialogManager.f17464f, z);
        }
        if (!bundle2.containsKey(ErrorDialogManager.f17466h) && (cls = this.f17494a.f17493i) != null) {
            bundle2.putSerializable(ErrorDialogManager.f17466h, cls);
        }
        if (!bundle2.containsKey(ErrorDialogManager.f17465g) && (i2 = this.f17494a.f17492h) != 0) {
            bundle2.putInt(ErrorDialogManager.f17465g, i2);
        }
        return a(fVar, bundle2);
    }

    protected String b(f fVar, Bundle bundle) {
        return this.f17494a.f17485a.getString(this.f17494a.a(fVar.f17496a));
    }

    protected String c(f fVar, Bundle bundle) {
        org.greenrobot.eventbus.util.b bVar = this.f17494a;
        return bVar.f17485a.getString(bVar.f17486b);
    }
}
