package com.vivo.push.restructure.request;

/* loaded from: classes2.dex */
public interface IPushRequestCallback<T> {
    void onError(int i2);

    void onSuccess(T t);
}
