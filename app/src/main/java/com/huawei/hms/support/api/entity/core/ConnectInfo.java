package com.huawei.hms.support.api.entity.core;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;
import com.huawei.hms.support.api.entity.auth.Scope;
import java.util.List;

/* loaded from: classes.dex */
public class ConnectInfo implements IMessageEntity {

    /* renamed from: a, reason: collision with root package name */
    @Packed
    private List<String> f7278a;

    /* renamed from: b, reason: collision with root package name */
    @Packed
    private List<Scope> f7279b;

    /* renamed from: c, reason: collision with root package name */
    @Packed
    private String f7280c;

    /* renamed from: d, reason: collision with root package name */
    @Packed
    private String f7281d;

    public ConnectInfo() {
    }

    public List<String> getApiNameList() {
        return this.f7278a;
    }

    public String getFingerprint() {
        return this.f7280c;
    }

    public List<Scope> getScopeList() {
        return this.f7279b;
    }

    public String getSubAppID() {
        return this.f7281d;
    }

    public void setApiNameList(List<String> list) {
        this.f7278a = list;
    }

    public void setFingerprint(String str) {
        this.f7280c = str;
    }

    public void setScopeList(List<Scope> list) {
        this.f7279b = list;
    }

    public void setSubAppID(String str) {
        this.f7281d = str;
    }

    public ConnectInfo(List<String> list, List<Scope> list2, String str, String str2) {
        this.f7278a = list;
        this.f7279b = list2;
        this.f7280c = str;
        this.f7281d = str2;
    }
}
