package com.vivo.push.b;

import android.text.TextUtils;
import com.vivo.push.model.InsideNotificationItem;

/* compiled from: OnNotifyArrivedReceiveCommand.java */
/* loaded from: classes2.dex */
public final class q extends v {

    /* renamed from: a, reason: collision with root package name */
    protected InsideNotificationItem f11971a;

    /* renamed from: b, reason: collision with root package name */
    private String f11972b;

    public q() {
        super(4);
    }

    @Override // com.vivo.push.b.v, com.vivo.push.b.s, com.vivo.push.v
    protected final void c(com.vivo.push.d dVar) {
        super.c(dVar);
        this.f11972b = com.vivo.push.util.v.b(this.f11971a);
        dVar.a("notification_v1", this.f11972b);
    }

    public final InsideNotificationItem d() {
        return this.f11971a;
    }

    public final String e() {
        if (!TextUtils.isEmpty(this.f11972b)) {
            return this.f11972b;
        }
        InsideNotificationItem insideNotificationItem = this.f11971a;
        if (insideNotificationItem == null) {
            return null;
        }
        return com.vivo.push.util.v.b(insideNotificationItem);
    }

    @Override // com.vivo.push.b.s, com.vivo.push.v
    public final String toString() {
        return "OnNotifyArrivedCommand";
    }

    @Override // com.vivo.push.b.v, com.vivo.push.b.s, com.vivo.push.v
    protected final void d(com.vivo.push.d dVar) {
        super.d(dVar);
        this.f11972b = dVar.a("notification_v1");
        if (TextUtils.isEmpty(this.f11972b)) {
            return;
        }
        this.f11971a = com.vivo.push.util.v.a(this.f11972b);
        InsideNotificationItem insideNotificationItem = this.f11971a;
        if (insideNotificationItem != null) {
            insideNotificationItem.setMsgId(f());
        }
    }
}
