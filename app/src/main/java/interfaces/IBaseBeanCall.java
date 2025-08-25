package interfaces;

import network.account.APIresult;

/* loaded from: classes2.dex */
public interface IBaseBeanCall<T extends APIresult> {
    void onClose();

    void onfail();

    void onsuccess(T t);
}
