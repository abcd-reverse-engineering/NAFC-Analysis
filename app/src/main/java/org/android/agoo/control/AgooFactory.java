package org.android.agoo.control;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.text.TextUtils;
import android.util.Base64;
import com.taobao.accs.base.TaoBaseService;
import com.taobao.accs.common.Constants;
import com.taobao.accs.common.ThreadPoolExecutorFactory;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.UTMini;
import com.taobao.accs.utl.UtilityImpl;
import com.umeng.analytics.pro.bh;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import javax.crypto.spec.SecretKeySpec;
import org.android.agoo.common.AgooConstants;
import org.android.agoo.common.Config;
import org.android.agoo.common.MsgDO;
import org.android.agoo.message.MessageService;
import org.android.agoo.service.SendMessage;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class AgooFactory {
    private static final String DEAL_MESSAGE = "accs.msgRecevie";
    private static final String TAG = "AgooFactory";
    private static Context mContext;
    protected NotifManager notifyManager = null;
    private MessageService messageService = null;

    /* compiled from: Taobao */
    static class a implements ServiceConnection {

        /* renamed from: a, reason: collision with root package name */
        private Intent f17317a;

        /* renamed from: b, reason: collision with root package name */
        private String f17318b;

        /* renamed from: c, reason: collision with root package name */
        private SendMessage f17319c;

        /* renamed from: d, reason: collision with root package name */
        private ServiceConnection f17320d = this;

        public a(String str, Intent intent) {
            this.f17318b = str;
            this.f17317a = intent;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            ALog.d(AgooFactory.TAG, "MessageConnection conneted:" + componentName, new Object[0]);
            this.f17319c = SendMessage.Stub.asInterface(iBinder);
            ALog.d(AgooFactory.TAG, "onConnected current tid:" + Thread.currentThread().getId(), new Object[0]);
            ALog.d(AgooFactory.TAG, "MessageConnection sent:" + this.f17317a, new Object[0]);
            if (this.f17319c != null) {
                ThreadPoolExecutorFactory.execute(new f(this));
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            ALog.d(AgooFactory.TAG, "MessageConnection disConnected", new Object[0]);
        }
    }

    /* compiled from: Taobao */
    class b implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        private String f17322b;

        /* renamed from: c, reason: collision with root package name */
        private Intent f17323c;

        public b(String str, Intent intent) {
            this.f17322b = str;
            this.f17323c = intent;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                ALog.d(AgooFactory.TAG, "running tid:" + Thread.currentThread().getId() + ",pack=" + this.f17322b, new Object[0]);
                AgooFactory.mContext.sendBroadcast(this.f17323c);
                StringBuilder sb = new StringBuilder();
                sb.append("SendMessageRunnable for accs,pack=");
                sb.append(this.f17322b);
                ALog.d(AgooFactory.TAG, sb.toString(), new Object[0]);
                try {
                    this.f17323c.setPackage(this.f17322b);
                    this.f17323c.setAction(AgooConstants.INTENT_FROM_AGOO_MESSAGE);
                    com.taobao.accs.a.a.a(AgooFactory.mContext, this.f17323c);
                } catch (Throwable unused) {
                }
                Intent intent = new Intent(AgooConstants.BINDER_MSGRECEIVER_ACTION);
                intent.setPackage(this.f17322b);
                ALog.d(AgooFactory.TAG, "this message pack:" + this.f17322b, new Object[0]);
                ALog.d(AgooFactory.TAG, "start to service...", new Object[0]);
                boolean zBindService = AgooFactory.mContext.bindService(intent, new a(this.f17323c.getStringExtra("id"), this.f17323c), 17);
                ALog.d(AgooFactory.TAG, "start service ret:" + zBindService, new Object[0]);
                if (zBindService) {
                    return;
                }
                ALog.d(AgooFactory.TAG, "SendMessageRunnable is error", new Object[0]);
            } catch (Throwable th) {
                ALog.e(AgooFactory.TAG, "SendMessageRunnable is error,e=" + th.toString(), new Object[0]);
            }
        }
    }

    private static final boolean checkPackage(Context context, String str) {
        return context.getPackageManager().getApplicationInfo(str, 0) != null;
    }

    private static Bundle getFlag(long j2, MsgDO msgDO) {
        Bundle bundle = new Bundle();
        try {
            char[] charArray = Long.toBinaryString(j2).toCharArray();
            if (charArray != null && 8 <= charArray.length) {
                if (8 <= charArray.length) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("");
                    sb.append(Integer.parseInt("" + charArray[1] + charArray[2] + charArray[3] + charArray[4], 2));
                    bundle.putString(AgooConstants.MESSAGE_ENCRYPTED, sb.toString());
                    if (charArray[6] == '1') {
                        bundle.putString(AgooConstants.MESSAGE_REPORT, "1");
                        msgDO.reportStr = "1";
                    }
                    if (charArray[7] == '1') {
                        bundle.putString(AgooConstants.MESSAGE_NOTIFICATION, "1");
                    }
                }
                if (9 <= charArray.length && charArray[8] == '1') {
                    bundle.putString(AgooConstants.MESSAGE_HAS_TEST, "1");
                }
                if (10 <= charArray.length && charArray[9] == '1') {
                    bundle.putString(AgooConstants.MESSAGE_DUPLICATE, "1");
                }
                if (11 <= charArray.length && charArray[10] == '1') {
                    bundle.putInt(AgooConstants.MESSAGE_POPUP, 1);
                }
            }
        } catch (Throwable unused) {
        }
        return bundle;
    }

    public static String parseEncryptedMsg(String str) {
        byte[] bArrA;
        String str2 = null;
        try {
            String strA = Config.a(mContext);
            String strB = Config.b(mContext);
            String strJ = UtilityImpl.j(mContext);
            if (TextUtils.isEmpty(strB)) {
                ALog.e(TAG, "getAppsign secret null", new Object[0]);
                bArrA = null;
            } else {
                bArrA = org.android.agoo.common.a.a(strB.getBytes("utf-8"), (strA + strJ).getBytes("utf-8"));
            }
            if (bArrA == null || bArrA.length <= 0) {
                ALog.e(TAG, "aesDecrypt key is null!", new Object[0]);
            } else {
                str2 = new String(org.android.agoo.common.a.a(Base64.decode(str, 8), new SecretKeySpec(org.android.agoo.common.a.a(bArrA), "AES"), org.android.agoo.common.a.a(strA.getBytes("utf-8"))), "utf-8");
            }
        } catch (Throwable th) {
            ALog.e(TAG, "parseEncryptedMsg failure: ", th, new Object[0]);
        }
        return TextUtils.isEmpty(str2) ? parseEncryptedMsgByOldDid(str) : str2;
    }

    private static String parseEncryptedMsgByOldDid(String str) {
        byte[] bArrA;
        try {
            String strD = UtilityImpl.d(Constants.SP_FILE_NAME, mContext);
            if (TextUtils.isEmpty(strD) || TextUtils.equals(strD, UtilityImpl.j(mContext))) {
                return null;
            }
            String strA = Config.a(mContext);
            String strB = Config.b(mContext);
            if (TextUtils.isEmpty(strB)) {
                ALog.e(TAG, "oldDid getAppsign secret null", new Object[0]);
                bArrA = null;
            } else {
                bArrA = org.android.agoo.common.a.a(strB.getBytes("utf-8"), (strA + strD).getBytes("utf-8"));
            }
            if (bArrA != null && bArrA.length > 0) {
                return new String(org.android.agoo.common.a.a(Base64.decode(str, 8), new SecretKeySpec(org.android.agoo.common.a.a(bArrA), "AES"), org.android.agoo.common.a.a(strA.getBytes("utf-8"))), "utf-8");
            }
            ALog.e(TAG, "oldDid aesDecrypt key is null!", new Object[0]);
            return null;
        } catch (Throwable th) {
            ALog.e(TAG, "oldDid parseEncryptedMsg failure: ", th, new Object[0]);
            return null;
        }
    }

    private void sendMsgByBindService(String str, Intent intent) {
        try {
            if (ALog.isPrintLog(ALog.Level.D)) {
                ALog.d(TAG, "onHandleMessage current tid:" + Thread.currentThread().getId(), new Object[0]);
            }
            ThreadPoolExecutorFactory.execute(new b(str, intent));
        } catch (Throwable th) {
            ALog.e(TAG, "sendMsgByBindService error >>", th, new Object[0]);
        }
    }

    private void sendMsgToBussiness(Context context, String str, Bundle bundle, boolean z, String str2, TaoBaseService.ExtraInfo extraInfo) {
        Intent intent = new Intent();
        intent.setAction(AgooConstants.INTENT_FROM_AGOO_MESSAGE);
        intent.setPackage(str);
        intent.putExtras(bundle);
        intent.putExtra("type", "common-push");
        intent.putExtra(AgooConstants.MESSAGE_SOURCE, str2);
        intent.addFlags(32);
        try {
            Bundle bundle2 = new Bundle();
            bundle2.putSerializable(AgooConstants.MESSAGE_ACCS_EXTRA, extraInfo);
            intent.putExtra(AgooConstants.MESSAGE_AGOO_BUNDLE, bundle2);
        } catch (Throwable th) {
            ALog.e(TAG, "sendMsgToBussiness", th, new Object[0]);
        }
        if (ALog.isPrintLog(ALog.Level.I)) {
            ALog.i(TAG, "sendMsgToBussiness intent:" + bundle.toString() + ",utdid=" + com.taobao.accs.utl.j.b(context) + ",pack=" + str + ",agooFlag=" + z, new Object[0]);
        }
        if (z) {
            UTMini.getInstance().commitEvent(AgooConstants.AGOO_EVENT_ID, DEAL_MESSAGE, com.taobao.accs.utl.j.b(context), "agooMsg", "15");
            sendMsgByBindService(str, intent);
        } else {
            intent.setClassName(str, com.taobao.accs.client.a.b());
            com.taobao.accs.a.a.a(context, intent);
        }
    }

    public void init(Context context, NotifManager notifManager, MessageService messageService) {
        mContext = context.getApplicationContext();
        this.notifyManager = notifManager;
        if (this.notifyManager == null) {
            this.notifyManager = new NotifManager();
        }
        this.notifyManager.init(mContext);
        this.messageService = messageService;
        if (this.messageService == null) {
            this.messageService = new MessageService();
        }
        this.messageService.a(mContext);
    }

    public Bundle msgReceiverPreHandler(byte[] bArr, String str, TaoBaseService.ExtraInfo extraInfo, boolean z) {
        JSONArray jSONArray;
        String str2;
        boolean z2;
        Bundle bundle;
        String str3;
        String str4;
        int i2;
        StringBuilder sb;
        StringBuilder sb2;
        int i3;
        StringBuilder sb3;
        String str5 = SocializeProtocolConstants.PROTOCOL_KEY_EXTEND;
        if (bArr != null) {
            try {
                if (bArr.length > 0) {
                    String str6 = new String(bArr, "utf-8");
                    if (ALog.isPrintLog(ALog.Level.I)) {
                        ALog.i(TAG, "msgRecevie,message--->[" + str6 + "],utdid=" + com.taobao.accs.utl.j.b(mContext), new Object[0]);
                    }
                    if (TextUtils.isEmpty(str6)) {
                        UTMini.getInstance().commitEvent(AgooConstants.AGOO_EVENT_ID, DEAL_MESSAGE, com.taobao.accs.utl.j.b(mContext), "message==null");
                        ALog.i(TAG, "handleMessage message==null,utdid=" + com.taobao.accs.utl.j.b(mContext), new Object[0]);
                        return null;
                    }
                    JSONArray jSONArray2 = new JSONArray(str6);
                    int length = jSONArray2.length();
                    StringBuilder sb4 = new StringBuilder();
                    StringBuilder sb5 = new StringBuilder();
                    StringBuilder sb6 = new StringBuilder();
                    Bundle bundle2 = null;
                    String str7 = null;
                    int i4 = 0;
                    while (i4 < length) {
                        Bundle bundle3 = new Bundle();
                        JSONObject jSONObject = jSONArray2.getJSONObject(i4);
                        if (jSONObject == null) {
                            jSONArray = jSONArray2;
                            i2 = i4;
                            sb2 = sb6;
                            sb3 = sb4;
                            i3 = length;
                            str2 = str5;
                            str3 = str6;
                            bundle = bundle3;
                            sb = sb5;
                        } else {
                            MsgDO msgDO = new MsgDO();
                            jSONArray = jSONArray2;
                            String string = jSONObject.getString(bh.aA);
                            String str8 = str7;
                            String string2 = jSONObject.getString(bh.aF);
                            String str9 = str6;
                            String string3 = jSONObject.getString("b");
                            StringBuilder sb7 = sb6;
                            StringBuilder sb8 = sb5;
                            long j2 = jSONObject.getLong("f");
                            String string4 = !jSONObject.isNull(str5) ? jSONObject.getString(str5) : str8;
                            sb4.append(string2);
                            str2 = str5;
                            int i5 = length - 1;
                            int i6 = length;
                            if (i4 < i5) {
                                sb4.append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP);
                            }
                            msgDO.msgIds = string2;
                            msgDO.extData = string4;
                            msgDO.removePacks = string;
                            msgDO.messageSource = str;
                            if (TextUtils.isEmpty(string3)) {
                                msgDO.errorCode = "11";
                                this.notifyManager.handlerACKMessage(msgDO, extraInfo);
                            } else if (TextUtils.isEmpty(string)) {
                                msgDO.errorCode = "12";
                                this.notifyManager.handlerACKMessage(msgDO, extraInfo);
                            } else if (j2 == -1) {
                                msgDO.errorCode = "13";
                                this.notifyManager.handlerACKMessage(msgDO, extraInfo);
                            } else {
                                StringBuilder sb9 = sb4;
                                if (checkPackage(mContext, string)) {
                                    Bundle flag = getFlag(j2, msgDO);
                                    String string5 = flag.getString(AgooConstants.MESSAGE_ENCRYPTED);
                                    if (!mContext.getPackageName().equals(string)) {
                                        z2 = true;
                                    } else if (TextUtils.equals(string5, Integer.toString(4))) {
                                        z2 = false;
                                    } else {
                                        ALog.e(TAG, "msgRecevie msg encrypted flag not exist, cannot prase!!!", new Object[0]);
                                        UTMini.getInstance().commitEvent(AgooConstants.AGOO_EVENT_ID, DEAL_MESSAGE, com.taobao.accs.utl.j.b(mContext), "encrypted!=4", "15");
                                        msgDO.errorCode = "24";
                                        this.notifyManager.handlerACKMessage(msgDO, extraInfo);
                                        str4 = string4;
                                        i2 = i4;
                                        sb2 = sb7;
                                        sb = sb8;
                                    }
                                    if (flag != null) {
                                        bundle = bundle3;
                                        bundle.putAll(flag);
                                    } else {
                                        bundle = bundle3;
                                    }
                                    try {
                                        String string6 = jSONObject.getString("t");
                                        if (!TextUtils.isEmpty(string6)) {
                                            bundle.putString("time", string6);
                                        }
                                    } catch (Throwable unused) {
                                        if (ALog.isPrintLog(ALog.Level.I)) {
                                            ALog.i(TAG, "agoo msg has no time", new Object[0]);
                                        }
                                    }
                                    bundle.putLong(AgooConstants.MESSAGE_TRACE, System.currentTimeMillis());
                                    bundle.putString("id", string2);
                                    bundle.putString("body", string3);
                                    bundle.putString("source", string);
                                    bundle.putString(AgooConstants.MESSAGE_FROM_APPKEY, Config.a(mContext));
                                    bundle.putString(AgooConstants.MESSAGE_EXT, string4);
                                    str3 = str9;
                                    bundle.putString(AgooConstants.MESSAGE_ORI, str3);
                                    if (z) {
                                        str4 = string4;
                                        i2 = i4;
                                        sb2 = sb7;
                                        sb = sb8;
                                        sb3 = sb9;
                                        i3 = i6;
                                        sendMsgToBussiness(mContext, string, bundle, z2, str, extraInfo);
                                    } else {
                                        str4 = string4;
                                        i2 = i4;
                                        sb = sb8;
                                        sb2 = sb7;
                                        i3 = i6;
                                        sb3 = sb9;
                                        bundle.putString("type", "common-push");
                                        bundle.putString(AgooConstants.MESSAGE_SOURCE, str);
                                    }
                                    str7 = str4;
                                } else {
                                    ALog.d(TAG, "msgRecevie checkpackage is del,pack=" + string, new Object[0]);
                                    UTMini.getInstance().commitEvent(AgooConstants.AGOO_EVENT_ID, DEAL_MESSAGE, com.taobao.accs.utl.j.b(mContext), "deletePack", string);
                                    sb7.append(string);
                                    sb8.append(string2);
                                    if (i4 < i5) {
                                        sb7.append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP);
                                        sb8.append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP);
                                    }
                                    sb = sb8;
                                    str4 = string4;
                                    i2 = i4;
                                    sb2 = sb7;
                                }
                                str3 = str9;
                                bundle = bundle3;
                                i3 = i6;
                                sb3 = sb9;
                                str7 = str4;
                            }
                            str4 = string4;
                            i2 = i4;
                            sb3 = sb4;
                            str3 = str9;
                            bundle = bundle3;
                            sb = sb8;
                            sb2 = sb7;
                            i3 = i6;
                            str7 = str4;
                        }
                        i4 = i2 + 1;
                        sb6 = sb2;
                        bundle2 = bundle;
                        sb5 = sb;
                        sb4 = sb3;
                        length = i3;
                        str5 = str2;
                        jSONArray2 = jSONArray;
                        str6 = str3;
                    }
                    StringBuilder sb10 = sb6;
                    StringBuilder sb11 = sb5;
                    if (sb10.length() > 0) {
                        MsgDO msgDO2 = new MsgDO();
                        msgDO2.msgIds = sb11.toString();
                        msgDO2.removePacks = sb10.toString();
                        msgDO2.errorCode = "10";
                        msgDO2.messageSource = str;
                        this.notifyManager.handlerACKMessage(msgDO2, extraInfo);
                    }
                    return bundle2;
                }
            } catch (Throwable th) {
                if (!ALog.isPrintLog(ALog.Level.E)) {
                    return null;
                }
                ALog.e(TAG, "msgRecevie is error,e=" + th, new Object[0]);
                return null;
            }
        }
        UTMini.getInstance().commitEvent(AgooConstants.AGOO_EVENT_ID, DEAL_MESSAGE, com.taobao.accs.utl.j.b(mContext), "data==null");
        ALog.i(TAG, "handleMessage data==null,utdid=" + com.taobao.accs.utl.j.b(mContext), new Object[0]);
        return null;
    }

    public void msgRecevie(byte[] bArr, String str) {
        msgRecevie(bArr, str, null);
    }

    public void reportCacheMsg() {
        try {
            ThreadPoolExecutorFactory.execute(new c(this));
        } catch (Throwable th) {
            ALog.e(TAG, "reportCacheMsg fail:" + th.toString(), new Object[0]);
        }
    }

    public void saveMsg(byte[] bArr) {
        saveMsg(bArr, null);
    }

    public void updateMsg(byte[] bArr, boolean z) {
        ThreadPoolExecutorFactory.execute(new d(this, bArr, z));
    }

    public void updateMsgStatus(String str, String str2) {
        try {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                if (ALog.isPrintLog(ALog.Level.I)) {
                    ALog.i(TAG, "updateNotifyMsg begin,messageId=" + str + ",status=" + str2 + ",reportTimes=" + Config.f(mContext), new Object[0]);
                }
                if (TextUtils.equals(str2, "8")) {
                    this.messageService.a(str, "2");
                } else if (TextUtils.equals(str2, "9")) {
                    this.messageService.a(str, "3");
                }
            }
        } catch (Throwable th) {
            ALog.e(TAG, "updateNotifyMsg e=" + th.toString(), new Object[0]);
        }
    }

    public void updateNotifyMsg(String str, String str2) {
        ThreadPoolExecutorFactory.execute(new e(this, str, str2));
    }

    public void msgRecevie(byte[] bArr, String str, TaoBaseService.ExtraInfo extraInfo) {
        try {
            if (ALog.isPrintLog(ALog.Level.I)) {
                ALog.i(TAG, "into--[AgooFactory,msgRecevie]:messageSource=" + str, new Object[0]);
            }
            ThreadPoolExecutorFactory.execute(new org.android.agoo.control.b(this, bArr, str, extraInfo));
        } catch (Throwable th) {
            ALog.e(TAG, "serviceImpl init task fail:" + th.toString(), new Object[0]);
        }
    }

    public void saveMsg(byte[] bArr, String str) {
        if (bArr == null || bArr.length <= 0) {
            return;
        }
        ThreadPoolExecutorFactory.execute(new org.android.agoo.control.a(this, bArr, str));
    }
}
