package com.huawei.hms.common.internal;

import android.app.Activity;
import com.huawei.hms.support.api.client.SubAppInfo;
import com.huawei.hms.support.api.entity.auth.Scope;
import java.lang.ref.WeakReference;
import java.util.List;

/* loaded from: classes.dex */
public class ClientSettings {

    /* renamed from: a, reason: collision with root package name */
    private String f6746a;

    /* renamed from: b, reason: collision with root package name */
    private String f6747b;

    /* renamed from: c, reason: collision with root package name */
    private List<Scope> f6748c;

    /* renamed from: d, reason: collision with root package name */
    private String f6749d;

    /* renamed from: e, reason: collision with root package name */
    private List<String> f6750e;

    /* renamed from: f, reason: collision with root package name */
    private String f6751f;

    /* renamed from: g, reason: collision with root package name */
    private SubAppInfo f6752g;

    /* renamed from: h, reason: collision with root package name */
    private WeakReference<Activity> f6753h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f6754i;

    /* renamed from: j, reason: collision with root package name */
    private String f6755j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f6756k;

    public ClientSettings(String str, String str2, List<Scope> list, String str3, List<String> list2) {
        this.f6746a = str;
        this.f6747b = str2;
        this.f6748c = list;
        this.f6749d = str3;
        this.f6750e = list2;
    }

    public List<String> getApiName() {
        return this.f6750e;
    }

    public String getAppID() {
        return this.f6749d;
    }

    public String getClientClassName() {
        return this.f6747b;
    }

    public String getClientPackageName() {
        return this.f6746a;
    }

    public Activity getCpActivity() {
        WeakReference<Activity> weakReference = this.f6753h;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public String getCpID() {
        return this.f6751f;
    }

    public String getInnerHmsPkg() {
        return this.f6755j;
    }

    public List<Scope> getScopes() {
        return this.f6748c;
    }

    public SubAppInfo getSubAppID() {
        return this.f6752g;
    }

    public boolean isHasActivity() {
        return this.f6754i;
    }

    public boolean isUseInnerHms() {
        return this.f6756k;
    }

    public void setApiName(List<String> list) {
        this.f6750e = list;
    }

    public void setAppID(String str) {
        this.f6749d = str;
    }

    public void setClientClassName(String str) {
        this.f6747b = str;
    }

    public void setClientPackageName(String str) {
        this.f6746a = str;
    }

    public void setCpActivity(Activity activity) {
        this.f6753h = new WeakReference<>(activity);
        this.f6754i = true;
    }

    public void setCpID(String str) {
        this.f6751f = str;
    }

    public void setInnerHmsPkg(String str) {
        this.f6755j = str;
    }

    public void setScopes(List<Scope> list) {
        this.f6748c = list;
    }

    public void setSubAppId(SubAppInfo subAppInfo) {
        this.f6752g = subAppInfo;
    }

    public void setUseInnerHms(boolean z) {
        this.f6756k = z;
    }

    public ClientSettings(String str, String str2, List<Scope> list, String str3, List<String> list2, SubAppInfo subAppInfo) {
        this(str, str2, list, str3, list2);
        this.f6752g = subAppInfo;
    }
}
