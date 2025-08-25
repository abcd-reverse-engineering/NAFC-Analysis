package com.huawei.hms.update.ui;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class UpdateBean implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    private boolean f7339a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f7340b;

    /* renamed from: c, reason: collision with root package name */
    private String f7341c;

    /* renamed from: d, reason: collision with root package name */
    private int f7342d;

    /* renamed from: e, reason: collision with root package name */
    private String f7343e;

    /* renamed from: f, reason: collision with root package name */
    private String f7344f;

    /* renamed from: g, reason: collision with root package name */
    private ArrayList f7345g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f7346h = true;

    private static <T> T a(T t) {
        return t;
    }

    public String getClientAppId() {
        return (String) a(this.f7343e);
    }

    public String getClientAppName() {
        return (String) a(this.f7344f);
    }

    public String getClientPackageName() {
        return (String) a(this.f7341c);
    }

    public int getClientVersionCode() {
        return ((Integer) a(Integer.valueOf(this.f7342d))).intValue();
    }

    public boolean getResolutionInstallHMS() {
        return this.f7340b;
    }

    public ArrayList getTypeList() {
        return (ArrayList) a(this.f7345g);
    }

    public boolean isHmsOrApkUpgrade() {
        return ((Boolean) a(Boolean.valueOf(this.f7339a))).booleanValue();
    }

    public boolean isNeedConfirm() {
        return ((Boolean) a(Boolean.valueOf(this.f7346h))).booleanValue();
    }

    public void setClientAppId(String str) {
        this.f7343e = str;
    }

    public void setClientAppName(String str) {
        this.f7344f = str;
    }

    public void setClientPackageName(String str) {
        this.f7341c = str;
    }

    public void setClientVersionCode(int i2) {
        this.f7342d = i2;
    }

    public void setHmsOrApkUpgrade(boolean z) {
        this.f7339a = z;
    }

    public void setNeedConfirm(boolean z) {
        this.f7346h = z;
    }

    public void setResolutionInstallHMS(boolean z) {
        this.f7340b = z;
    }

    public void setTypeList(ArrayList arrayList) {
        this.f7345g = arrayList;
    }
}
