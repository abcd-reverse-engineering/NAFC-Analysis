package com.heytap.mcssdk;

import android.content.Context;
import com.heytap.msp.push.callback.ICallBackResultService;
import com.heytap.msp.push.callback.IGetAppNotificationCallBackService;
import com.heytap.msp.push.callback.ISetAppNotificationCallBackService;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes.dex */
interface e {
    void a();

    @Deprecated
    void a(int i2);

    @Deprecated
    void a(int i2, JSONObject jSONObject);

    void a(Context context, String str, String str2, ICallBackResultService iCallBackResultService);

    void a(Context context, String str, String str2, JSONObject jSONObject, ICallBackResultService iCallBackResultService);

    void a(IGetAppNotificationCallBackService iGetAppNotificationCallBackService);

    void a(ISetAppNotificationCallBackService iSetAppNotificationCallBackService);

    void a(String str);

    void a(List<Integer> list, int i2, int i3, int i4, int i5);

    void a(List<Integer> list, int i2, int i3, int i4, int i5, JSONObject jSONObject);

    void a(JSONObject jSONObject);

    void b();

    void b(ISetAppNotificationCallBackService iSetAppNotificationCallBackService);

    @Deprecated
    void b(JSONObject jSONObject);

    void c();

    void c(JSONObject jSONObject);

    String d();

    void d(JSONObject jSONObject);

    void e();

    void e(JSONObject jSONObject);

    void f();

    void f(JSONObject jSONObject);

    @Deprecated
    void g();

    void g(JSONObject jSONObject);

    void h();

    void h(JSONObject jSONObject);

    void i();

    void i(JSONObject jSONObject);

    void unRegister();
}
