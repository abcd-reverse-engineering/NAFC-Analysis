package com.vivo.push.b;

import android.text.TextUtils;
import com.vivo.push.model.UnvarnishedMessage;

/* compiled from: OnMessageReceiveCommand.java */
/* loaded from: classes2.dex */
public final class o extends v {

    /* renamed from: a, reason: collision with root package name */
    protected UnvarnishedMessage f11960a;

    public o() {
        super(3);
    }

    @Override // com.vivo.push.b.v, com.vivo.push.b.s, com.vivo.push.v
    protected final void c(com.vivo.push.d dVar) {
        super.c(dVar);
        dVar.a("msg_v1", this.f11960a.unpackToJson());
    }

    @Override // com.vivo.push.b.v, com.vivo.push.b.s, com.vivo.push.v
    protected final void d(com.vivo.push.d dVar) {
        super.d(dVar);
        String strA = dVar.a("msg_v1");
        if (TextUtils.isEmpty(strA)) {
            return;
        }
        this.f11960a = new UnvarnishedMessage(strA);
        this.f11960a.setMsgId(f());
    }

    public final UnvarnishedMessage e() {
        return this.f11960a;
    }

    @Override // com.vivo.push.b.s, com.vivo.push.v
    public final String toString() {
        return "OnMessageCommand";
    }

    public final String d() {
        UnvarnishedMessage unvarnishedMessage = this.f11960a;
        if (unvarnishedMessage == null) {
            return null;
        }
        return unvarnishedMessage.unpackToJson();
    }
}
