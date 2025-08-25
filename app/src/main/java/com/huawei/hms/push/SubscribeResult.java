package com.huawei.hms.push;

import com.huawei.hms.push.notification.SubscribedItem;
import com.huawei.hms.support.api.client.Result;
import java.util.List;

/* loaded from: classes.dex */
public class SubscribeResult extends Result {

    /* renamed from: a, reason: collision with root package name */
    private String f7194a;

    /* renamed from: b, reason: collision with root package name */
    private List<SubscribedItem> f7195b;

    public String getErrorMsg() {
        return this.f7194a;
    }

    public List<SubscribedItem> getSubscribedItems() {
        return this.f7195b;
    }

    public void setErrorMsg(String str) {
        this.f7194a = str;
    }

    public void setSubscribedItems(List<SubscribedItem> list) {
        this.f7195b = list;
    }
}
