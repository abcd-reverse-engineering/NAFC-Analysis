package com.vivo.push;

import com.vivo.push.restructure.request.a.a.c;

/* compiled from: ClientSdkQueryResultDS.java */
/* loaded from: classes2.dex */
final class h implements c.a<g> {
    h() {
    }

    private static g b(String str) {
        try {
            return new g(new com.vivo.push.restructure.request.a.a.a(str));
        } catch (Exception e2) {
            com.vivo.push.util.u.a(8101, e2.getMessage());
            return null;
        }
    }

    @Override // com.vivo.push.restructure.request.a.a.c.a
    public final /* synthetic */ g a(String str) {
        return b(str);
    }
}
