package com.taobao.accs.net;

import com.taobao.accs.data.Message;
import com.taobao.accs.utl.BaseMonitor;
import java.util.Iterator;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
class s implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f8552a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ boolean f8553b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ int f8554c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ k f8555d;

    s(k kVar, int i2, boolean z, int i3) {
        this.f8555d = kVar;
        this.f8552a = i2;
        this.f8553b = z;
        this.f8554c = i3;
    }

    @Override // java.lang.Runnable
    public void run() {
        Message messageB;
        int i2 = this.f8552a;
        if (i2 > 0) {
            Message.Id id = new Message.Id(i2, "");
            Message.Id id2 = null;
            Iterator<Message.Id> it = this.f8555d.f8504e.f().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Message.Id next = it.next();
                if (next.equals(id)) {
                    id2 = next;
                    break;
                }
            }
            if (id2 != null && (messageB = this.f8555d.f8504e.b(id2.getDataId())) != null) {
                if (this.f8553b) {
                    if (!this.f8555d.a(messageB, 2000)) {
                        this.f8555d.f8504e.a(messageB, this.f8554c);
                    }
                    if (messageB.getNetPermanceMonitor() != null) {
                        com.taobao.accs.utl.k.a("accs", BaseMonitor.COUNT_POINT_RESEND, "total_tnet", 0.0d);
                    }
                } else {
                    this.f8555d.f8504e.a(messageB, this.f8554c);
                }
            }
        }
        int i3 = this.f8552a;
        if (i3 >= 0 || !this.f8553b) {
            return;
        }
        this.f8555d.b(i3);
    }
}
