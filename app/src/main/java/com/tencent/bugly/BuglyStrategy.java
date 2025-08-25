package com.tencent.bugly;

import java.util.Map;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public class BuglyStrategy {

    /* renamed from: c, reason: collision with root package name */
    private String f8741c;

    /* renamed from: d, reason: collision with root package name */
    private String f8742d;

    /* renamed from: e, reason: collision with root package name */
    private String f8743e;

    /* renamed from: f, reason: collision with root package name */
    private long f8744f;

    /* renamed from: g, reason: collision with root package name */
    private String f8745g;

    /* renamed from: h, reason: collision with root package name */
    private String f8746h;
    private a q;

    /* renamed from: i, reason: collision with root package name */
    private boolean f8747i = true;

    /* renamed from: j, reason: collision with root package name */
    private boolean f8748j = true;

    /* renamed from: k, reason: collision with root package name */
    private boolean f8749k = true;

    /* renamed from: l, reason: collision with root package name */
    private Class<?> f8750l = null;

    /* renamed from: m, reason: collision with root package name */
    private boolean f8751m = true;
    private boolean n = true;
    private boolean o = true;
    private boolean p = false;

    /* renamed from: a, reason: collision with root package name */
    protected int f8739a = 31;

    /* renamed from: b, reason: collision with root package name */
    protected boolean f8740b = false;

    /* compiled from: BUGLY */
    public static class a {
        public static final int CRASHTYPE_ANR = 4;
        public static final int CRASHTYPE_BLOCK = 7;
        public static final int CRASHTYPE_COCOS2DX_JS = 5;
        public static final int CRASHTYPE_COCOS2DX_LUA = 6;
        public static final int CRASHTYPE_JAVA_CATCH = 1;
        public static final int CRASHTYPE_JAVA_CRASH = 0;
        public static final int CRASHTYPE_NATIVE = 2;
        public static final int CRASHTYPE_U3D = 3;
        public static final int MAX_USERDATA_KEY_LENGTH = 100;
        public static final int MAX_USERDATA_VALUE_LENGTH = 30000;

        public synchronized Map<String, String> onCrashHandleStart(int i2, String str, String str2, String str3) {
            return null;
        }

        public synchronized byte[] onCrashHandleStart2GetExtraDatas(int i2, String str, String str2, String str3) {
            return null;
        }
    }

    public synchronized String getAppChannel() {
        return this.f8742d == null ? com.tencent.bugly.crashreport.common.info.a.b().s : this.f8742d;
    }

    public synchronized String getAppPackageName() {
        return this.f8743e == null ? com.tencent.bugly.crashreport.common.info.a.b().f8977d : this.f8743e;
    }

    public synchronized long getAppReportDelay() {
        return this.f8744f;
    }

    public synchronized String getAppVersion() {
        return this.f8741c == null ? com.tencent.bugly.crashreport.common.info.a.b().p : this.f8741c;
    }

    public synchronized int getCallBackType() {
        return this.f8739a;
    }

    public synchronized boolean getCloseErrorCallback() {
        return this.f8740b;
    }

    public synchronized a getCrashHandleCallback() {
        return this.q;
    }

    public synchronized String getDeviceID() {
        return this.f8746h;
    }

    public synchronized String getLibBuglySOFilePath() {
        return this.f8745g;
    }

    public synchronized Class<?> getUserInfoActivity() {
        return this.f8750l;
    }

    public synchronized boolean isBuglyLogUpload() {
        return this.f8751m;
    }

    public synchronized boolean isEnableANRCrashMonitor() {
        return this.f8748j;
    }

    public synchronized boolean isEnableNativeCrashMonitor() {
        return this.f8747i;
    }

    public synchronized boolean isEnableUserInfo() {
        return this.f8749k;
    }

    public boolean isReplaceOldChannel() {
        return this.n;
    }

    public synchronized boolean isUploadProcess() {
        return this.o;
    }

    public synchronized boolean recordUserInfoOnceADay() {
        return this.p;
    }

    public synchronized BuglyStrategy setAppChannel(String str) {
        this.f8742d = str;
        return this;
    }

    public synchronized BuglyStrategy setAppPackageName(String str) {
        this.f8743e = str;
        return this;
    }

    public synchronized BuglyStrategy setAppReportDelay(long j2) {
        this.f8744f = j2;
        return this;
    }

    public synchronized BuglyStrategy setAppVersion(String str) {
        this.f8741c = str;
        return this;
    }

    public synchronized BuglyStrategy setBuglyLogUpload(boolean z) {
        this.f8751m = z;
        return this;
    }

    public synchronized void setCallBackType(int i2) {
        this.f8739a = i2;
    }

    public synchronized void setCloseErrorCallback(boolean z) {
        this.f8740b = z;
    }

    public synchronized BuglyStrategy setCrashHandleCallback(a aVar) {
        this.q = aVar;
        return this;
    }

    public synchronized BuglyStrategy setDeviceID(String str) {
        this.f8746h = str;
        return this;
    }

    public synchronized BuglyStrategy setEnableANRCrashMonitor(boolean z) {
        this.f8748j = z;
        return this;
    }

    public synchronized BuglyStrategy setEnableNativeCrashMonitor(boolean z) {
        this.f8747i = z;
        return this;
    }

    public synchronized BuglyStrategy setEnableUserInfo(boolean z) {
        this.f8749k = z;
        return this;
    }

    public synchronized BuglyStrategy setLibBuglySOFilePath(String str) {
        this.f8745g = str;
        return this;
    }

    public synchronized BuglyStrategy setRecordUserInfoOnceADay(boolean z) {
        this.p = z;
        return this;
    }

    public void setReplaceOldChannel(boolean z) {
        this.n = z;
    }

    public synchronized BuglyStrategy setUploadProcess(boolean z) {
        this.o = z;
        return this;
    }

    public synchronized BuglyStrategy setUserInfoActivity(Class<?> cls) {
        this.f8750l = cls;
        return this;
    }
}
