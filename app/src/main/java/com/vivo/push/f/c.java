package com.vivo.push.f;

import com.vivo.push.cache.ClientConfigManagerImpl;

/* compiled from: InitTask.java */
/* loaded from: classes2.dex */
final class c extends com.vivo.push.s {
    c(com.vivo.push.v vVar) {
        super(vVar);
    }

    @Override // com.vivo.push.s
    protected final void a(com.vivo.push.v vVar) {
        com.vivo.push.util.u.a(ClientConfigManagerImpl.getInstance(this.f12207a).isDebug());
    }
}
