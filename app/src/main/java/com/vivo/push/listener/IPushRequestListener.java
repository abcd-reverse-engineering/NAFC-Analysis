package com.vivo.push.listener;

/* loaded from: classes2.dex */
interface IPushRequestListener<T, V> {
    void onFail(V v);

    void onSuccess(T t);
}
