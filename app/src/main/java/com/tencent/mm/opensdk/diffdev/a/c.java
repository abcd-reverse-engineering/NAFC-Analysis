package com.tencent.mm.opensdk.diffdev.a;

import android.os.AsyncTask;
import com.tencent.mm.opensdk.diffdev.OAuthErrCode;
import com.tencent.mm.opensdk.diffdev.OAuthListener;

/* loaded from: classes2.dex */
class c extends AsyncTask<Void, Void, a> {

    /* renamed from: a, reason: collision with root package name */
    private String f9694a;

    /* renamed from: b, reason: collision with root package name */
    private String f9695b;

    /* renamed from: c, reason: collision with root package name */
    private OAuthListener f9696c;

    /* renamed from: d, reason: collision with root package name */
    private int f9697d;

    static class a {

        /* renamed from: a, reason: collision with root package name */
        public OAuthErrCode f9698a;

        /* renamed from: b, reason: collision with root package name */
        public String f9699b;

        /* renamed from: c, reason: collision with root package name */
        public int f9700c;

        a() {
        }
    }

    public c(String str, OAuthListener oAuthListener) {
        this.f9694a = str;
        this.f9696c = oAuthListener;
        this.f9695b = String.format("https://long.open.weixin.qq.com/connect/l/qrconnect?f=json&uuid=%s", str);
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x00cf A[Catch: Exception -> 0x00d4, TryCatch #0 {Exception -> 0x00d4, blocks: (B:20:0x008d, B:22:0x009c, B:26:0x00b5, B:28:0x00b9, B:29:0x00c6, B:33:0x00d1, B:30:0x00c9, B:31:0x00cc, B:32:0x00cf), top: B:63:0x008d }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0168 A[SYNTHETIC] */
    @Override // android.os.AsyncTask
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected com.tencent.mm.opensdk.diffdev.a.c.a doInBackground(java.lang.Void[] r14) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 426
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.opensdk.diffdev.a.c.doInBackground(java.lang.Object[]):java.lang.Object");
    }

    @Override // android.os.AsyncTask
    protected void onPostExecute(a aVar) {
        a aVar2 = aVar;
        this.f9696c.onAuthFinish(aVar2.f9698a, aVar2.f9699b);
    }
}
