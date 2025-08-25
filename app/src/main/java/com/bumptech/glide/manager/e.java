package com.bumptech.glide.manager;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.manager.c;

/* compiled from: DefaultConnectivityMonitor.java */
/* loaded from: classes.dex */
final class e implements c {

    /* renamed from: f, reason: collision with root package name */
    private static final String f5072f = "ConnectivityMonitor";

    /* renamed from: a, reason: collision with root package name */
    private final Context f5073a;

    /* renamed from: b, reason: collision with root package name */
    final c.a f5074b;

    /* renamed from: c, reason: collision with root package name */
    boolean f5075c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f5076d;

    /* renamed from: e, reason: collision with root package name */
    private final BroadcastReceiver f5077e = new a();

    /* compiled from: DefaultConnectivityMonitor.java */
    class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(@NonNull Context context, Intent intent) {
            e eVar = e.this;
            boolean z = eVar.f5075c;
            eVar.f5075c = eVar.a(context);
            if (z != e.this.f5075c) {
                if (Log.isLoggable(e.f5072f, 3)) {
                    String str = "connectivity changed, isConnected: " + e.this.f5075c;
                }
                e eVar2 = e.this;
                eVar2.f5074b.a(eVar2.f5075c);
            }
        }
    }

    e(@NonNull Context context, @NonNull c.a aVar) {
        this.f5073a = context.getApplicationContext();
        this.f5074b = aVar;
    }

    private void a() {
        if (this.f5076d) {
            return;
        }
        this.f5075c = a(this.f5073a);
        try {
            this.f5073a.registerReceiver(this.f5077e, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            this.f5076d = true;
        } catch (SecurityException unused) {
            Log.isLoggable(f5072f, 5);
        }
    }

    private void b() {
        if (this.f5076d) {
            this.f5073a.unregisterReceiver(this.f5077e);
            this.f5076d = false;
        }
    }

    @Override // com.bumptech.glide.manager.i
    public void onDestroy() {
    }

    @Override // com.bumptech.glide.manager.i
    public void onStart() {
        a();
    }

    @Override // com.bumptech.glide.manager.i
    public void onStop() {
        b();
    }

    @SuppressLint({"MissingPermission"})
    boolean a(@NonNull Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) com.bumptech.glide.util.j.a((ConnectivityManager) context.getSystemService("connectivity"))).getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isConnected();
        } catch (RuntimeException unused) {
            Log.isLoggable(f5072f, 5);
            return true;
        }
    }
}
