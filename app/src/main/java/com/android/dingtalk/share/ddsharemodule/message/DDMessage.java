package com.android.dingtalk.share.ddsharemodule.message;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.android.dingtalk.share.ddsharemodule.ShareConstant;
import com.android.dingtalk.share.ddsharemodule.plugin.SignatureCheck;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class DDMessage {
    private static final String TAG = "DDMessage";

    public interface CallBack {
        void handleMessage(Intent intent);
    }

    public static final class Receiver extends BroadcastReceiver {
        public static final Map<String, CallBack> mCallbacks = new HashMap();
        private final CallBack mCallback;

        public Receiver() {
            this(null);
        }

        public static void registerCallBack(String str, CallBack callBack) {
            mCallbacks.put(str, callBack);
        }

        public static void unregisterCallBack(String str) {
            mCallbacks.remove(str);
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            String str = "receive intent=" + intent;
            CallBack callBack = this.mCallback;
            if (callBack != null) {
                callBack.handleMessage(intent);
                return;
            }
            CallBack callBack2 = mCallbacks.get(intent.getAction());
            if (callBack2 != null) {
                callBack2.handleMessage(intent);
            }
        }

        public Receiver(CallBack callBack) {
            this.mCallback = callBack;
        }
    }

    public static boolean send(Context context, String str, String str2, String str3, Bundle bundle) {
        String str4 = str + ".permission.MM_MESSAGE";
        Intent intent = new Intent(str2);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        String packageName = context.getPackageName();
        intent.putExtra(ShareConstant.EXTRA_MESSAGE_SDK_VERSION, 20160101);
        intent.putExtra(ShareConstant.EXTRA_MESSAGE_APP_PACKAGE_NAME, packageName);
        intent.putExtra(ShareConstant.EXTRA_MESSAGE_CONTENT, str3);
        intent.putExtra(ShareConstant.EXTRA_MESSAGE_APP_SIGNATURE, SignatureCheck.getMD5Signature(context, packageName));
        context.sendBroadcast(intent, str4);
        String str5 = "send dd message, intent=" + intent + ", perm=" + str4;
        return true;
    }

    public static void send(Context context, String str, String str2) {
        send(context, str, ShareConstant.ACTION_MESSAGE, str2);
    }

    public static void send(Context context, String str, String str2, String str3) {
        send(context, str, str2, str3, null);
    }
}
