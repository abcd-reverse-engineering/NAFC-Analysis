package com.umeng.commonsdk.stateless;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.statistics.common.DataHelper;

/* compiled from: UMSLNetWorkSenderHelper.java */
/* loaded from: classes2.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private String f10860a = "10.0.0.172";

    /* renamed from: b, reason: collision with root package name */
    private int f10861b = 80;

    /* renamed from: c, reason: collision with root package name */
    private Context f10862c;

    public c(Context context) {
        this.f10862c = context;
    }

    private void a() {
        String strImprintProperty = UMEnvelopeBuild.imprintProperty(this.f10862c, "sl_domain_p", "");
        if (TextUtils.isEmpty(strImprintProperty)) {
            return;
        }
        a.f10844i = DataHelper.assembleStatelessURL(strImprintProperty);
    }

    private void b() {
        String strImprintProperty = UMEnvelopeBuild.imprintProperty(this.f10862c, "sl_domain_p", "");
        String strImprintProperty2 = UMEnvelopeBuild.imprintProperty(this.f10862c, "oversea_sl_domain_p", "");
        if (!TextUtils.isEmpty(strImprintProperty)) {
            a.f10843h = DataHelper.assembleStatelessURL(strImprintProperty);
        }
        if (!TextUtils.isEmpty(strImprintProperty2)) {
            a.f10846k = DataHelper.assembleStatelessURL(strImprintProperty2);
        }
        a.f10844i = a.f10846k;
        if (TextUtils.isEmpty(com.umeng.commonsdk.statistics.b.f10870b)) {
            return;
        }
        if (com.umeng.commonsdk.statistics.b.f10870b.startsWith(c.c.a.b.a.a.K) || com.umeng.commonsdk.statistics.b.f10870b.startsWith("461")) {
            a.f10844i = a.f10843h;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:64:0x012f A[PHI: r1 r3 r11
  0x012f: PHI (r1v1 boolean) = (r1v0 boolean), (r1v0 boolean), (r1v2 boolean) binds: [B:38:0x011b, B:47:0x012c, B:25:0x0102] A[DONT_GENERATE, DONT_INLINE]
  0x012f: PHI (r3v9 java.io.OutputStream) = (r3v7 java.io.OutputStream), (r3v8 java.io.OutputStream), (r3v10 java.io.OutputStream) binds: [B:38:0x011b, B:47:0x012c, B:25:0x0102] A[DONT_GENERATE, DONT_INLINE]
  0x012f: PHI (r11v7 ??) = (r11v5 javax.net.ssl.HttpsURLConnection), (r11v6 javax.net.ssl.HttpsURLConnection), (r11v8 ??) binds: [B:38:0x011b, B:47:0x012c, B:25:0x0102] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0102 A[EXC_TOP_SPLITTER, PHI: r1 r3 r11
  0x0102: PHI (r1v2 boolean) = (r1v0 boolean), (r1v0 boolean), (r1v4 boolean) binds: [B:38:0x011b, B:47:0x012c, B:24:0x0100] A[DONT_GENERATE, DONT_INLINE]
  0x0102: PHI (r3v10 java.io.OutputStream) = (r3v7 java.io.OutputStream), (r3v8 java.io.OutputStream), (r3v13 java.io.OutputStream) binds: [B:38:0x011b, B:47:0x012c, B:24:0x0100] A[DONT_GENERATE, DONT_INLINE]
  0x0102: PHI (r11v8 ??) = (r11v5 javax.net.ssl.HttpsURLConnection), (r11v6 javax.net.ssl.HttpsURLConnection), (r11v12 ??) binds: [B:38:0x011b, B:47:0x012c, B:24:0x0100] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r11v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r11v12, types: [javax.net.ssl.HttpsURLConnection] */
    /* JADX WARN: Type inference failed for: r11v13 */
    /* JADX WARN: Type inference failed for: r11v14 */
    /* JADX WARN: Type inference failed for: r11v7 */
    /* JADX WARN: Type inference failed for: r11v8, types: [javax.net.ssl.HttpsURLConnection] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean a(byte[] r9, java.lang.String r10, java.lang.String r11, java.lang.String r12) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 333
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.stateless.c.a(byte[], java.lang.String, java.lang.String, java.lang.String):boolean");
    }
}
