package com.tencent.connect.common;

import android.content.Intent;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.k;
import com.tencent.open.utils.m;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ProGuard */
/* loaded from: classes2.dex */
public class UIListenerManager {

    /* renamed from: a, reason: collision with root package name */
    private static UIListenerManager f9640a;

    /* renamed from: b, reason: collision with root package name */
    private Map<String, ApiTask> f9641b;

    /* compiled from: ProGuard */
    public class ApiTask {
        public IUiListener mListener;
        public int mRequestCode;

        public ApiTask(int i2, IUiListener iUiListener) {
            this.mRequestCode = i2;
            this.mListener = iUiListener;
        }
    }

    private UIListenerManager() {
        this.f9641b = Collections.synchronizedMap(new HashMap());
        if (this.f9641b == null) {
            this.f9641b = Collections.synchronizedMap(new HashMap());
        }
    }

    private IUiListener a(int i2, IUiListener iUiListener) {
        if (i2 == 11101) {
            SLog.e("openSDK_LOG.UIListenerManager", "登录的接口回调不能重新构建，暂时无法提供，先记录下来这种情况是否存在");
        } else if (i2 == 11105) {
            SLog.e("openSDK_LOG.UIListenerManager", "Social Api 的接口回调需要使用param来重新构建，暂时无法提供，先记录下来这种情况是否存在");
        } else if (i2 == 11106) {
            SLog.e("openSDK_LOG.UIListenerManager", "Social Api 的H5接口回调需要使用param来重新构建，暂时无法提供，先记录下来这种情况是否存在");
        }
        return iUiListener;
    }

    public static UIListenerManager getInstance() {
        if (f9640a == null) {
            f9640a = new UIListenerManager();
        }
        return f9640a;
    }

    public IUiListener getListnerWithAction(String str) {
        ApiTask apiTask;
        if (str == null) {
            SLog.e("openSDK_LOG.UIListenerManager", "getListnerWithAction action is null!");
            return null;
        }
        synchronized (this.f9641b) {
            apiTask = this.f9641b.get(str);
            this.f9641b.remove(str);
        }
        if (apiTask == null) {
            return null;
        }
        return apiTask.mListener;
    }

    public IUiListener getListnerWithRequestCode(int i2) {
        String strA = k.a(i2);
        if (strA != null) {
            return getListnerWithAction(strA);
        }
        SLog.e("openSDK_LOG.UIListenerManager", "getListner action is null! rquestCode=" + i2);
        return null;
    }

    public void handleDataToListener(Intent intent, IUiListener iUiListener) {
        SLog.i("openSDK_LOG.UIListenerManager", "handleDataToListener");
        if (intent == null) {
            iUiListener.onCancel();
            return;
        }
        String stringExtra = intent.getStringExtra(Constants.KEY_ACTION);
        if ("action_login".equals(stringExtra)) {
            int intExtra = intent.getIntExtra(Constants.KEY_ERROR_CODE, 0);
            if (intExtra != 0) {
                SLog.e("openSDK_LOG.UIListenerManager", "OpenUi, onActivityResult, onError = " + intExtra + "");
                iUiListener.onError(new UiError(intExtra, intent.getStringExtra(Constants.KEY_ERROR_MSG), intent.getStringExtra(Constants.KEY_ERROR_DETAIL)));
                return;
            }
            String stringExtra2 = intent.getStringExtra(Constants.KEY_RESPONSE);
            if (stringExtra2 == null) {
                SLog.d("openSDK_LOG.UIListenerManager", "OpenUi, onActivityResult, onComplete");
                iUiListener.onComplete(new JSONObject());
                return;
            }
            try {
                iUiListener.onComplete(m.d(stringExtra2));
                return;
            } catch (JSONException e2) {
                iUiListener.onError(new UiError(-4, Constants.MSG_JSON_ERROR, stringExtra2));
                SLog.e("openSDK_LOG.UIListenerManager", "OpenUi, onActivityResult, json error", e2);
                return;
            }
        }
        if ("action_share".equals(stringExtra)) {
            String stringExtra3 = intent.getStringExtra("result");
            String stringExtra4 = intent.getStringExtra("response");
            if (CommonNetImpl.CANCEL.equals(stringExtra3)) {
                iUiListener.onCancel();
                return;
            }
            if ("error".equals(stringExtra3)) {
                iUiListener.onError(new UiError(-6, "unknown error", stringExtra4 + ""));
                return;
            }
            if ("complete".equals(stringExtra3)) {
                try {
                    iUiListener.onComplete(new JSONObject(stringExtra4 == null ? "{\"ret\": 0}" : stringExtra4));
                } catch (JSONException e3) {
                    e3.printStackTrace();
                    iUiListener.onError(new UiError(-4, "json error", stringExtra4 + ""));
                }
            }
        }
    }

    public boolean onActivityResult(int i2, int i3, Intent intent, IUiListener iUiListener) throws JSONException {
        SLog.i("openSDK_LOG.UIListenerManager", "onActivityResult req=" + i2 + " res=" + i3);
        IUiListener listnerWithRequestCode = getListnerWithRequestCode(i2);
        if (listnerWithRequestCode == null) {
            if (iUiListener == null) {
                SLog.e("openSDK_LOG.UIListenerManager", "onActivityResult can't find the listener");
                return false;
            }
            listnerWithRequestCode = a(i2, iUiListener);
        }
        if (i3 != -1) {
            listnerWithRequestCode.onCancel();
            return true;
        }
        if (intent == null) {
            listnerWithRequestCode.onError(new UiError(-6, "onActivityResult intent data is null.", "onActivityResult intent data is null."));
            return true;
        }
        String stringExtra = intent.getStringExtra(Constants.KEY_ACTION);
        if ("action_login".equals(stringExtra)) {
            int intExtra = intent.getIntExtra(Constants.KEY_ERROR_CODE, 0);
            if (intExtra != 0) {
                SLog.e("openSDK_LOG.UIListenerManager", "OpenUi, onActivityResult, onError = " + intExtra + "");
                listnerWithRequestCode.onError(new UiError(intExtra, intent.getStringExtra(Constants.KEY_ERROR_MSG), intent.getStringExtra(Constants.KEY_ERROR_DETAIL)));
                return true;
            }
            String stringExtra2 = intent.getStringExtra(Constants.KEY_RESPONSE);
            if (stringExtra2 == null) {
                SLog.d("openSDK_LOG.UIListenerManager", "OpenUi, onActivityResult, onComplete");
                listnerWithRequestCode.onComplete(new JSONObject());
                return true;
            }
            try {
                listnerWithRequestCode.onComplete(m.d(stringExtra2));
                return true;
            } catch (JSONException e2) {
                listnerWithRequestCode.onError(new UiError(-4, Constants.MSG_JSON_ERROR, stringExtra2));
                SLog.e("openSDK_LOG.UIListenerManager", "OpenUi, onActivityResult, json error", e2);
                return true;
            }
        }
        if ("action_share".equals(stringExtra) || "action_request_avatar".equals(stringExtra) || "action_request_dynamic_avatar".equals(stringExtra) || "action_request_set_emotion".equals(stringExtra) || "guildOpen".equals(stringExtra)) {
            String stringExtra3 = intent.getStringExtra("result");
            String stringExtra4 = intent.getStringExtra("response");
            if (CommonNetImpl.CANCEL.equals(stringExtra3)) {
                listnerWithRequestCode.onCancel();
                return true;
            }
            if ("error".equals(stringExtra3)) {
                listnerWithRequestCode.onError(new UiError(-6, "unknown error", stringExtra4 + ""));
                return true;
            }
            if (!"complete".equals(stringExtra3)) {
                return true;
            }
            try {
                listnerWithRequestCode.onComplete(new JSONObject(stringExtra4 == null ? "{\"ret\": 0}" : stringExtra4));
                return true;
            } catch (JSONException e3) {
                SLog.e("openSDK_LOG.UIListenerManager", "JSONException", e3);
                listnerWithRequestCode.onError(new UiError(-4, "json error", stringExtra4 + ""));
                return true;
            }
        }
        if (!"action_common_channel".equals(stringExtra)) {
            int intExtra2 = intent.getIntExtra(Constants.KEY_ERROR_CODE, 0);
            if (intExtra2 != 0) {
                listnerWithRequestCode.onError(new UiError(intExtra2, intent.getStringExtra(Constants.KEY_ERROR_MSG), intent.getStringExtra(Constants.KEY_ERROR_DETAIL)));
                return true;
            }
            String stringExtra5 = intent.getStringExtra(Constants.KEY_RESPONSE);
            if (stringExtra5 == null) {
                listnerWithRequestCode.onComplete(new JSONObject());
                return true;
            }
            try {
                listnerWithRequestCode.onComplete(m.d(stringExtra5));
                return true;
            } catch (JSONException unused) {
                listnerWithRequestCode.onError(new UiError(-4, Constants.MSG_JSON_ERROR, stringExtra5));
                return true;
            }
        }
        int intExtra3 = intent.getIntExtra(Constants.KEY_ERROR_CODE, 0);
        if (intExtra3 != 0) {
            listnerWithRequestCode.onError(new UiError(intExtra3, intent.getStringExtra(Constants.KEY_ERROR_MSG), intent.getStringExtra(Constants.KEY_ERROR_DETAIL)));
            return true;
        }
        String stringExtra6 = intent.getStringExtra("response");
        if (stringExtra6 == null) {
            listnerWithRequestCode.onComplete(new JSONObject());
            return true;
        }
        try {
            String stringExtra7 = intent.getStringExtra("message");
            JSONObject jSONObjectD = m.d(stringExtra6);
            jSONObjectD.put("message", stringExtra7);
            listnerWithRequestCode.onComplete(jSONObjectD);
            return true;
        } catch (JSONException unused2) {
            listnerWithRequestCode.onError(new UiError(-4, Constants.MSG_JSON_ERROR, stringExtra6));
            return true;
        }
    }

    public Object setListenerWithRequestcode(int i2, IUiListener iUiListener) {
        ApiTask apiTaskPut;
        String strA = k.a(i2);
        if (strA == null) {
            SLog.e("openSDK_LOG.UIListenerManager", "setListener action is null! rquestCode=" + i2);
            return null;
        }
        synchronized (this.f9641b) {
            apiTaskPut = this.f9641b.put(strA, new ApiTask(i2, iUiListener));
        }
        if (apiTaskPut == null) {
            return null;
        }
        return apiTaskPut.mListener;
    }

    public Object setListnerWithAction(String str, IUiListener iUiListener) {
        ApiTask apiTaskPut;
        int iB = k.b(str);
        if (iB == -1) {
            SLog.e("openSDK_LOG.UIListenerManager", "setListnerWithAction fail, action = " + str);
            return null;
        }
        synchronized (this.f9641b) {
            apiTaskPut = this.f9641b.put(str, new ApiTask(iB, iUiListener));
        }
        if (apiTaskPut == null) {
            return null;
        }
        return apiTaskPut.mListener;
    }
}
