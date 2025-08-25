package com.tencent.bugly.proguard;

import android.text.TextUtils;
import com.tencent.bugly.beta.download.BetaReceiver;
import com.tencent.bugly.beta.download.DownloadTask;
import java.io.File;
import java.net.HttpURLConnection;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import util.r1;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public class t extends DownloadTask implements Runnable {

    /* renamed from: k, reason: collision with root package name */
    public long f9440k;

    /* renamed from: l, reason: collision with root package name */
    private File f9441l;

    /* renamed from: m, reason: collision with root package name */
    private long f9442m;

    public t(String str, String str2, long j2, long j3, String str3) {
        super(str, "", "", str3);
        this.f9440k = 0L;
        this.f9442m = 0L;
        this.f9441l = new File(str2);
        this.f8767b = this.f9441l.getParent();
        this.f8768c = this.f9441l.getName();
        this.f8770e = j2;
        this.f8771f = j3;
        getStatus();
    }

    private String a(HttpURLConnection httpURLConnection) {
        List<String> list;
        try {
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (!TextUtils.isEmpty(this.f8768c)) {
            return this.f8768c;
        }
        Map<String, List<String>> headerFields = httpURLConnection.getHeaderFields();
        if (headerFields != null) {
            for (String str : headerFields.keySet()) {
                if (str != null && (list = headerFields.get(str)) != null) {
                    for (String str2 : list) {
                        if (str2 != null && "content-disposition".equals(str.toLowerCase())) {
                            Matcher matcher = Pattern.compile(".*filename=(.*)").matcher(str2.toLowerCase());
                            if (matcher.find()) {
                                return matcher.group(1);
                            }
                        }
                    }
                }
            }
        }
        String strSubstring = getDownloadUrl().substring(getDownloadUrl().lastIndexOf(47) + 1);
        if (!TextUtils.isEmpty(strSubstring)) {
            return strSubstring;
        }
        return UUID.randomUUID() + r1.f20958d;
    }

    protected void b() {
        this.f8774i = 1;
        a();
        s.f9436a.f9437b.remove(getDownloadUrl());
        BetaReceiver.netListeners.remove(getDownloadUrl());
        com.tencent.bugly.beta.utils.e.a(new com.tencent.bugly.beta.global.d(8, this.f8769d, this));
    }

    @Override // com.tencent.bugly.beta.download.DownloadTask
    public void delete(boolean z) {
        stop();
        if (z) {
            if (getSaveFile() != null && getSaveFile().exists() && !getSaveFile().isDirectory()) {
                getSaveFile().delete();
            }
            p.f9423a.b(this);
        }
        BetaReceiver.netListeners.remove(getDownloadUrl());
        this.f8768c = null;
        this.f8770e = 0L;
        this.f8771f = 0L;
        this.f8774i = 4;
    }

    @Override // com.tencent.bugly.beta.download.DownloadTask
    public void download() {
        if (getStatus() == 1) {
            b();
            return;
        }
        if (getStatus() == 2) {
            return;
        }
        if (getSaveFile() == null || !getSaveFile().exists()) {
            this.f8770e = 0L;
            this.f8771f = 0L;
            this.f9440k = 0L;
        } else {
            this.f8770e = getSaveFile().length();
        }
        if (this.f8772g) {
            com.tencent.bugly.beta.ui.c.f8829a.a(this);
        }
        this.f9442m = System.currentTimeMillis();
        this.f8774i = 2;
        s.f9436a.f9437b.put(getDownloadUrl(), this);
        s.f9436a.a(this);
    }

    @Override // com.tencent.bugly.beta.download.DownloadTask
    public long getCostTime() {
        return this.f9440k;
    }

    @Override // com.tencent.bugly.beta.download.DownloadTask
    public File getSaveFile() {
        return this.f9441l;
    }

    @Override // com.tencent.bugly.beta.download.DownloadTask
    public int getStatus() {
        if (getSaveFile() != null && getSaveFile().exists() && getSaveFile().length() == this.f8771f && !s.f9436a.f9437b.contains(this)) {
            this.f8770e = this.f8771f;
            this.f8774i = 1;
        }
        if (getSaveFile() != null && getSaveFile().exists() && getSaveFile().length() > 0 && getSaveFile().length() < this.f8771f && !s.f9436a.f9437b.contains(this)) {
            this.f8770e = getSaveFile().length();
            this.f8774i = 3;
        }
        if ((getSaveFile() == null || !getSaveFile().exists()) && !s.f9436a.f9437b.contains(this)) {
            this.f8774i = 0;
        }
        return this.f8774i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:130:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:132:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0167, code lost:
    
        if (r0 < 3) goto L88;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0169, code lost:
    
        com.tencent.bugly.proguard.an.b(com.tencent.bugly.proguard.t.class, "have retry %d times", 3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x019a, code lost:
    
        if (r5 == null) goto L130;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x019c, code lost:
    
        r5.close();
     */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0163 A[Catch: all -> 0x017a, Exception -> 0x017d, TryCatch #4 {Exception -> 0x017d, blocks: (B:17:0x0099, B:31:0x00e4, B:48:0x0124, B:56:0x0136, B:70:0x0163, B:71:0x0166, B:67:0x015b, B:73:0x0169), top: B:97:0x015b, outer: #0 }] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void run() throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 442
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.t.run():void");
    }

    @Override // com.tencent.bugly.beta.download.DownloadTask
    public void stop() {
        if (this.f8774i != 5) {
            this.f8774i = 3;
        }
    }

    public t(String str, String str2, String str3, String str4) {
        super(str, str2, str3, str4);
        this.f9440k = 0L;
        this.f9442m = 0L;
        getStatus();
    }

    protected void a(int i2, String str) {
        this.f8774i = 5;
        com.tencent.bugly.beta.ui.c.f8829a.a();
        s.f9436a.f9437b.remove(getDownloadUrl());
        com.tencent.bugly.beta.utils.e.a(new com.tencent.bugly.beta.global.d(10, this.f8769d, this, Integer.valueOf(i2), str));
    }

    protected void a() {
        this.f9440k += System.currentTimeMillis() - this.f9442m;
        p.f9423a.a(this);
        this.f9442m = System.currentTimeMillis();
        com.tencent.bugly.beta.ui.c.f8829a.a();
        com.tencent.bugly.beta.utils.e.a(new com.tencent.bugly.beta.global.d(9, this.f8769d, this));
    }
}
