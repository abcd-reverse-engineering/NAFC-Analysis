package com.taobao.accs.internal;

import androidx.annotation.Keep;
import com.taobao.accs.AccsClientConfig;
import com.taobao.accs.base.AccsConnectStateListener;
import com.taobao.accs.client.GlobalClientInfo;
import com.taobao.accs.data.Message;
import com.taobao.accs.net.k;

/* compiled from: Taobao */
@Keep
/* loaded from: classes2.dex */
public class c implements com.taobao.accs.c {

    /* renamed from: a, reason: collision with root package name */
    private com.taobao.accs.net.a f8494a;

    public c(String str) {
        this.f8494a = new k(GlobalClientInfo.f8392a, 1, str);
    }

    @Override // com.taobao.accs.c
    public void a() {
        this.f8494a.a();
    }

    @Override // com.taobao.accs.c
    public void b() {
        this.f8494a.k();
    }

    @Override // com.taobao.accs.c
    public String c() {
        return this.f8494a.i();
    }

    @Override // com.taobao.accs.c
    public String d() {
        return this.f8494a.f8508i.getAppSecret();
    }

    @Override // com.taobao.accs.c
    public boolean e(String str) {
        return this.f8494a.j().c(str);
    }

    @Override // com.taobao.accs.c
    public boolean f(String str) {
        return this.f8494a.j().d(str);
    }

    @Override // com.taobao.accs.c
    public void a(boolean z, boolean z2) {
        this.f8494a.a(z, z2);
    }

    @Override // com.taobao.accs.c
    public String b(String str) {
        return this.f8494a.b(str);
    }

    @Override // com.taobao.accs.c
    public void c(String str) {
        this.f8494a.f8500a = str;
    }

    @Override // com.taobao.accs.c
    public void d(String str) {
        this.f8494a.f8501b = str;
    }

    @Override // com.taobao.accs.c
    public String e() {
        return this.f8494a.f8508i.getStoreId();
    }

    @Override // com.taobao.accs.c
    public boolean f() {
        return this.f8494a.m();
    }

    @Override // com.taobao.accs.c
    public boolean a(String str) {
        return this.f8494a.a(str);
    }

    @Override // com.taobao.accs.c
    public void b(AccsConnectStateListener accsConnectStateListener) {
        this.f8494a.b(accsConnectStateListener);
    }

    @Override // com.taobao.accs.c
    public void a(Message message, int i2) {
        this.f8494a.b(message, i2);
    }

    @Override // com.taobao.accs.c
    public void a(Message message, boolean z) {
        this.f8494a.b(message, z);
    }

    @Override // com.taobao.accs.c
    public void a(AccsClientConfig accsClientConfig) {
        com.taobao.accs.net.a aVar = this.f8494a;
        if (aVar instanceof k) {
            ((k) aVar).a(accsClientConfig);
        }
    }

    @Override // com.taobao.accs.c
    public boolean a(String str, String str2) {
        return this.f8494a.j().b(str, str2);
    }

    @Override // com.taobao.accs.c
    public void a(AccsConnectStateListener accsConnectStateListener) {
        this.f8494a.a(accsConnectStateListener);
    }
}
