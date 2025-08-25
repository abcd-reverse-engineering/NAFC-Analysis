package com.vivo.push.listener;

/* loaded from: classes2.dex */
public interface IPushQueryActionListener extends IPushRequestListener<String, Integer> {
    @Override // com.vivo.push.listener.IPushRequestListener
    /* synthetic */ void onFail(V v);

    @Override // com.vivo.push.listener.IPushRequestListener
    /* synthetic */ void onSuccess(T t);
}
