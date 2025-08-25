package com.taobao.accs.net;

import com.taobao.accs.data.Message;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
class w implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Message f8563a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ boolean f8564b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ v f8565c;

    w(v vVar, Message message, boolean z) {
        this.f8565c = vVar;
        this.f8563a = message;
        this.f8564b = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        synchronized (this.f8565c.u) {
            this.f8565c.a(this.f8563a);
            if (this.f8565c.u.size() == 0) {
                this.f8565c.u.add(this.f8563a);
            } else {
                Message message = (Message) this.f8565c.u.getFirst();
                if (this.f8563a.getType() == 1 || this.f8563a.getType() == 0) {
                    this.f8565c.u.addLast(this.f8563a);
                    if (message.getType() == 2) {
                        this.f8565c.u.removeFirst();
                    }
                } else if (this.f8563a.getType() != 2 || message.getType() != 2) {
                    this.f8565c.u.addLast(this.f8563a);
                } else if (!message.force && this.f8563a.force) {
                    this.f8565c.u.removeFirst();
                    this.f8565c.u.addFirst(this.f8563a);
                }
            }
            if (this.f8564b || this.f8565c.t == 3) {
                try {
                    this.f8565c.u.notifyAll();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }
}
