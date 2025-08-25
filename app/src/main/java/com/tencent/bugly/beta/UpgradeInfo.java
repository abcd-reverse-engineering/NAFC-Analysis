package com.tencent.bugly.beta;

import com.tencent.bugly.proguard.u;
import com.tencent.bugly.proguard.v;
import com.tencent.bugly.proguard.y;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public class UpgradeInfo {
    public String apkMd5;
    public String apkUrl;
    public long fileSize;
    public String id;
    public String imageUrl;
    public String newFeature;
    public long popInterval;
    public int popTimes;
    public long publishTime;
    public int publishType;
    public String title;
    public int updateType;
    public int upgradeType;
    public int versionCode;
    public String versionName;

    public UpgradeInfo(y yVar) {
        this.id = "";
        this.title = "";
        this.newFeature = "";
        this.publishTime = 0L;
        this.publishType = 0;
        this.upgradeType = 1;
        this.popTimes = 0;
        this.popInterval = 0L;
        this.versionName = "";
        if (yVar != null) {
            this.id = yVar.f9487m;
            this.title = yVar.f9475a;
            this.newFeature = yVar.f9476b;
            this.publishTime = yVar.f9477c;
            this.publishType = yVar.f9478d;
            this.upgradeType = yVar.f9481g;
            this.popTimes = yVar.f9482h;
            this.popInterval = yVar.f9483i;
            v vVar = yVar.f9479e;
            this.versionCode = vVar.f9452c;
            this.versionName = vVar.f9453d;
            this.apkMd5 = vVar.f9458i;
            u uVar = yVar.f9480f;
            this.apkUrl = uVar.f9445b;
            this.fileSize = uVar.f9447d;
            this.imageUrl = yVar.f9486l.get("IMG_title");
            this.updateType = yVar.p;
        }
    }
}
