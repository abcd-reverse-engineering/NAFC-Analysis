package com.huawei.hms.common.internal;

import android.app.Activity;
import android.content.Intent;

/* loaded from: classes.dex */
public class DialogRedirectImpl extends DialogRedirect {

    /* renamed from: a, reason: collision with root package name */
    private final Activity f6757a;

    /* renamed from: b, reason: collision with root package name */
    private final int f6758b;

    /* renamed from: c, reason: collision with root package name */
    private final Intent f6759c;

    DialogRedirectImpl(Intent intent, Activity activity, int i2) {
        this.f6759c = intent;
        this.f6757a = activity;
        this.f6758b = i2;
    }

    @Override // com.huawei.hms.common.internal.DialogRedirect
    public final void redirect() {
        Activity activity;
        Intent intent = this.f6759c;
        if (intent == null || (activity = this.f6757a) == null) {
            return;
        }
        activity.startActivityForResult(intent, this.f6758b);
    }
}
