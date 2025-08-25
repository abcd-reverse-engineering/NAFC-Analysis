package com.tencent.bugly.beta.download;

import java.io.File;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public abstract class DownloadTask {
    public static final int COMPLETE = 1;
    public static final int DELETED = 4;
    public static final int DOWNLOADING = 2;
    public static final int FAILED = 5;
    public static final int INIT = 0;
    public static final int PAUSED = 3;
    public static final int TYPE_HOTFIX = 2;
    public static final int TYPE_UPGRADE = 1;

    /* renamed from: a, reason: collision with root package name */
    protected String f8766a;

    /* renamed from: b, reason: collision with root package name */
    protected String f8767b;

    /* renamed from: c, reason: collision with root package name */
    protected String f8768c;

    /* renamed from: e, reason: collision with root package name */
    protected long f8770e;

    /* renamed from: f, reason: collision with root package name */
    protected long f8771f;

    /* renamed from: h, reason: collision with root package name */
    protected String f8773h;

    /* renamed from: d, reason: collision with root package name */
    protected List<DownloadListener> f8769d = new CopyOnWriteArrayList();

    /* renamed from: g, reason: collision with root package name */
    protected boolean f8772g = true;

    /* renamed from: i, reason: collision with root package name */
    protected int f8774i = 0;

    /* renamed from: j, reason: collision with root package name */
    protected int f8775j = 1;

    protected DownloadTask(String str, String str2, String str3, String str4) {
        this.f8773h = "";
        this.f8766a = str;
        this.f8767b = str2;
        this.f8768c = str3;
        this.f8773h = str4;
    }

    public void addListener(DownloadListener downloadListener) {
        if (downloadListener == null || this.f8769d.contains(downloadListener)) {
            return;
        }
        this.f8769d.add(downloadListener);
    }

    public abstract void delete(boolean z);

    public abstract void download();

    public abstract long getCostTime();

    public int getDownloadType() {
        return this.f8775j;
    }

    public String getDownloadUrl() {
        return this.f8766a;
    }

    public String getMD5() {
        return this.f8773h;
    }

    public abstract File getSaveFile();

    public long getSavedLength() {
        return this.f8770e;
    }

    public abstract int getStatus();

    public long getTotalLength() {
        return this.f8771f;
    }

    public boolean isNeededNotify() {
        return this.f8772g;
    }

    public boolean removeListener(DownloadListener downloadListener) {
        return downloadListener != null && this.f8769d.remove(downloadListener);
    }

    public void setDownloadType(int i2) {
        this.f8775j = i2;
    }

    public void setNeededNotify(boolean z) {
        this.f8772g = z;
    }

    public void setSavedLength(long j2) {
        this.f8770e = j2;
    }

    public void setTotalLength(long j2) {
        this.f8771f = j2;
    }

    public abstract void stop();
}
