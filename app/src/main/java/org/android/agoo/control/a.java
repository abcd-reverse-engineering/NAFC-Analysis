package org.android.agoo.control;

import android.text.TextUtils;
import com.taobao.accs.utl.ALog;
import com.umeng.analytics.pro.bh;
import org.android.agoo.common.Config;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ byte[] f17324a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f17325b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ AgooFactory f17326c;

    a(AgooFactory agooFactory, byte[] bArr, String str) {
        this.f17326c = agooFactory;
        this.f17324a = bArr;
        this.f17325b = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            String str = new String(this.f17324a, "utf-8");
            JSONArray jSONArray = new JSONArray(str);
            int length = jSONArray.length();
            if (length == 1) {
                String string = null;
                String string2 = null;
                for (int i2 = 0; i2 < length; i2++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i2);
                    if (jSONObject != null) {
                        string = jSONObject.getString(bh.aF);
                        string2 = jSONObject.getString(bh.aA);
                    }
                }
                if (ALog.isPrintLog(ALog.Level.I)) {
                    ALog.i("AgooFactory", "saveMsg msgId:" + string + ",message=" + str + ",currentPack=" + string2 + ",reportTimes=" + Config.f(AgooFactory.mContext), new Object[0]);
                }
                if (TextUtils.isEmpty(string2) || !TextUtils.equals(string2, AgooFactory.mContext.getPackageName())) {
                    return;
                }
                if (TextUtils.isEmpty(this.f17325b)) {
                    this.f17326c.messageService.a(string, str, "0");
                } else {
                    this.f17326c.messageService.a(string, str, this.f17325b);
                }
            }
        } catch (Throwable th) {
            ALog.e("AgooFactory", "saveMsg fail:" + th.toString(), new Object[0]);
        }
    }
}
