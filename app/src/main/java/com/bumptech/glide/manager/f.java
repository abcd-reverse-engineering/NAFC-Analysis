package com.bumptech.glide.manager;

import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import com.bumptech.glide.manager.c;

/* compiled from: DefaultConnectivityMonitorFactory.java */
/* loaded from: classes.dex */
public class f implements d {

    /* renamed from: a, reason: collision with root package name */
    private static final String f5079a = "ConnectivityMonitor";

    /* renamed from: b, reason: collision with root package name */
    private static final String f5080b = "android.permission.ACCESS_NETWORK_STATE";

    @Override // com.bumptech.glide.manager.d
    @NonNull
    public c a(@NonNull Context context, @NonNull c.a aVar) {
        boolean z = ContextCompat.checkSelfPermission(context, f5080b) == 0;
        Log.isLoggable(f5079a, 3);
        return z ? new e(context, aVar) : new j();
    }
}
