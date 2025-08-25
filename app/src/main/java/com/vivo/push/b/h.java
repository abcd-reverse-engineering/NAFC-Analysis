package com.vivo.push.b;

import android.text.TextUtils;

/* compiled from: MsgArriveCommand.java */
/* loaded from: classes2.dex */
public final class h extends com.vivo.push.v {

    /* renamed from: a, reason: collision with root package name */
    private String f11946a;

    /* renamed from: b, reason: collision with root package name */
    private String f11947b;

    public h() {
        super(2013);
    }

    @Override // com.vivo.push.v
    protected final void c(com.vivo.push.d dVar) {
        dVar.a("MsgArriveCommand.MSG_TAG", this.f11946a);
        if (TextUtils.isEmpty(this.f11947b)) {
            return;
        }
        dVar.a("MsgArriveCommand.NODE_INFO", this.f11947b);
    }

    @Override // com.vivo.push.v
    protected final void d(com.vivo.push.d dVar) {
        this.f11946a = dVar.a("MsgArriveCommand.MSG_TAG");
        this.f11947b = dVar.a("MsgArriveCommand.NODE_INFO");
    }

    public h(String str) {
        this();
        this.f11946a = str;
    }

    public h(String str, String str2) {
        this(str);
        this.f11947b = str2;
    }
}
