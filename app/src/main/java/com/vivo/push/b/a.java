package com.vivo.push.b;

import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.util.ArrayList;
import ui.activity.BaseProgressUploadActivity;

/* compiled from: AliasCommand.java */
/* loaded from: classes2.dex */
public final class a extends c {

    /* renamed from: a, reason: collision with root package name */
    private ArrayList<String> f11931a;

    public a(boolean z, String str, ArrayList<String> arrayList) {
        super(z ? BaseProgressUploadActivity.REQUESTION_CODE_RECORD_AUDIO_2 : 2003, str);
        this.f11931a = arrayList;
    }

    @Override // com.vivo.push.b.c, com.vivo.push.v
    public final void c(com.vivo.push.d dVar) {
        super.c(dVar);
        dVar.a(SocializeProtocolConstants.TAGS, this.f11931a);
    }

    @Override // com.vivo.push.b.c, com.vivo.push.v
    public final void d(com.vivo.push.d dVar) {
        super.d(dVar);
        this.f11931a = dVar.c(SocializeProtocolConstants.TAGS);
    }

    @Override // com.vivo.push.b.c, com.vivo.push.v
    public final String toString() {
        return "AliasCommand:" + b();
    }
}
