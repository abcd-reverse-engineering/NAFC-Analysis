package com.umeng.analytics.pro;

import android.text.TextUtils;
import com.umeng.ccg.ActionInfo;
import com.umeng.ccg.CcgAgent;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import org.json.JSONObject;

/* compiled from: Action.java */
/* loaded from: classes2.dex */
public class z implements ag {

    /* renamed from: a, reason: collision with root package name */
    private String f10540a;

    /* renamed from: b, reason: collision with root package name */
    private ArrayList<aa> f10541b;

    /* renamed from: c, reason: collision with root package name */
    private String f10542c = "";

    /* renamed from: d, reason: collision with root package name */
    private String f10543d = "";

    /* renamed from: e, reason: collision with root package name */
    private String f10544e = "";

    /* renamed from: f, reason: collision with root package name */
    private String f10545f = "";

    public z(String str, ArrayList<aa> arrayList) {
        this.f10540a = null;
        this.f10541b = new ArrayList<>();
        this.f10540a = str;
        this.f10541b = arrayList;
    }

    public String a() {
        return this.f10540a;
    }

    public String b() {
        return this.f10542c;
    }

    public String c() {
        return this.f10543d;
    }

    private String c(String str) {
        String[] strArrSplit = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
        if (strArrSplit.length <= 0) {
            return "";
        }
        ArrayList<String> forbidSdkArray = CcgAgent.getForbidSdkArray(this.f10540a);
        if (forbidSdkArray != null && forbidSdkArray.size() > 0) {
            this.f10545f = forbidSdkArray.toString();
            for (String str2 : strArrSplit) {
                if (CcgAgent.getActionInfo(str2) != null && !forbidSdkArray.contains(str2)) {
                    return str2;
                }
            }
            return "";
        }
        String str3 = "";
        for (String str4 : strArrSplit) {
            ActionInfo actionInfo = CcgAgent.getActionInfo(str4);
            if (actionInfo != null) {
                String[] supportAction = actionInfo.getSupportAction(UMGlobalContext.getAppContext());
                if (supportAction.length > 0) {
                    int i2 = 0;
                    while (true) {
                        if (i2 >= supportAction.length) {
                            break;
                        }
                        if (this.f10540a.equals(supportAction[i2])) {
                            str3 = str4;
                            break;
                        }
                        i2++;
                    }
                    if (!TextUtils.isEmpty(str3)) {
                        break;
                    }
                } else {
                    continue;
                }
            }
        }
        return str3;
    }

    public void a(String str) {
        this.f10542c = str;
    }

    public void b(String str) {
        this.f10543d = str;
    }

    @Override // com.umeng.analytics.pro.ag
    public JSONObject a(String str, JSONObject jSONObject) {
        try {
            int size = this.f10541b.size();
            if (size == 0) {
                return null;
            }
            for (int i2 = 0; i2 < size; i2++) {
                if (this.f10541b.get(i2).b()) {
                    return null;
                }
            }
            if (CcgAgent.hasRegistedActionInfo() && !TextUtils.isEmpty(this.f10543d)) {
                this.f10544e = c(this.f10543d);
                if (TextUtils.isEmpty(this.f10544e)) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "采集项：" + this.f10540a + "; 未选中可用Module ; sdk: " + this.f10543d);
                } else {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "采集项：" + this.f10540a + "; 选中Module: " + this.f10544e + "; sdk: " + this.f10543d);
                }
            }
            aa aaVar = this.f10541b.get(size - 1);
            if (aaVar == null || !(aaVar instanceof ac)) {
                return null;
            }
            long jC = aaVar.c();
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("actionName", this.f10540a);
                jSONObject2.put(com.umeng.ccg.a.r, this.f10543d);
                jSONObject2.put(com.umeng.ccg.a.o, this.f10542c);
                jSONObject2.put("delay", jC);
                jSONObject2.put(com.umeng.ccg.a.p, this.f10544e);
                jSONObject2.put(com.umeng.ccg.a.q, this.f10545f);
            } catch (Throwable unused) {
            }
            return jSONObject2;
        } catch (Throwable unused2) {
            return null;
        }
    }
}
