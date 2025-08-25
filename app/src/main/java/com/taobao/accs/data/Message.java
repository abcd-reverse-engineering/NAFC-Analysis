package com.taobao.accs.data;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.taobao.accs.ACCSManager;
import com.taobao.accs.base.TaoBaseService;
import com.taobao.accs.client.GlobalClientInfo;
import com.taobao.accs.common.Constants;
import com.taobao.accs.ut.monitor.NetPerformanceMonitor;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.UtilityImpl;
import com.taobao.accs.utl.o;
import com.taobao.accs.utl.p;
import com.taobao.accs.utl.r;
import h.q2.t.n;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.zip.GZIPOutputStream;
import org.json.JSONException;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class Message implements Serializable {
    public static int CONTROL_MAX_RETRY_TIMES = 5;
    public static final int EXT_HEADER_VALUE_MAX_LEN = 1023;
    public static final int FLAG_ACK_TYPE = 32;
    public static final int FLAG_BIZ_RET = 64;
    public static final int FLAG_DATA_TYPE = 32768;
    public static final int FLAG_ERR = 4096;
    public static final int FLAG_REQ_BIT1 = 16384;
    public static final int FLAG_REQ_BIT2 = 8192;
    public static final int FLAG_RET = 2048;
    public static final String KEY_BINDAPP = "ctrl_bindapp";
    public static final String KEY_BINDSERVICE = "ctrl_bindservice";
    public static final String KEY_BINDUSER = "ctrl_binduser";
    public static final String KEY_UNBINDAPP = "ctrl_unbindapp";
    public static final String KEY_UNBINDSERVICE = "ctrl_unbindservice";
    public static final String KEY_UNBINDUSER = "ctrl_unbinduser";
    public static final int MAX_RETRY_TIMES = 3;

    /* renamed from: a, reason: collision with root package name */
    static long f8422a = 1;
    byte[] D;
    int E;
    long F;
    transient NetPerformanceMonitor G;
    Id I;
    public String cunstomDataId;

    /* renamed from: d, reason: collision with root package name */
    short f8425d;
    public String dataId;

    /* renamed from: e, reason: collision with root package name */
    short f8426e;

    /* renamed from: f, reason: collision with root package name */
    short f8427f;

    /* renamed from: g, reason: collision with root package name */
    byte f8428g;

    /* renamed from: h, reason: collision with root package name */
    byte f8429h;
    public URL host;

    /* renamed from: i, reason: collision with root package name */
    String f8430i;

    /* renamed from: j, reason: collision with root package name */
    String f8431j;

    /* renamed from: l, reason: collision with root package name */
    Map<Integer, String> f8433l;
    public long startSendTime;
    public boolean isAck = false;
    public boolean force = false;
    public boolean isCancel = false;

    /* renamed from: b, reason: collision with root package name */
    byte f8423b = 0;

    /* renamed from: c, reason: collision with root package name */
    byte f8424c = 0;

    /* renamed from: k, reason: collision with root package name */
    int f8432k = -1;

    /* renamed from: m, reason: collision with root package name */
    String f8434m = null;
    public Integer command = null;
    Integer n = 0;
    String o = null;
    public String appSign = null;
    Integer p = null;
    String q = null;
    String r = null;
    String s = null;
    String t = null;
    String u = null;
    Integer v = null;
    String w = null;
    String x = null;
    public String userinfo = null;
    public String serviceId = null;
    String y = null;
    String z = null;
    String A = null;
    String B = null;
    String C = null;
    public long delyTime = 0;
    public int retryTimes = 0;
    public int timeout = com.taobao.accs.net.a.ACCS_RECEIVE_TIMEOUT;
    public String bizId = null;
    String H = null;

    /* compiled from: Taobao */
    public static class Id implements Serializable {

        /* renamed from: a, reason: collision with root package name */
        private int f8435a;

        /* renamed from: b, reason: collision with root package name */
        private String f8436b;

        public Id(int i2, String str) {
            this.f8435a = i2;
            this.f8436b = str;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || Id.class != obj.getClass()) {
                return false;
            }
            Id id = (Id) obj;
            return this.f8435a == id.getId() || this.f8436b.equals(id.getDataId());
        }

        public String getDataId() {
            return this.f8436b;
        }

        public int getId() {
            return this.f8435a;
        }

        public int hashCode() {
            return this.f8436b.hashCode();
        }
    }

    /* compiled from: Taobao */
    public static class MsgResType implements Serializable {
        public static final int INVALID = -1;
        public static final int NEED_ACK = 1;
        public static final int NO_ACK = 0;

        public static String name(int i2) {
            return i2 != 0 ? i2 != 1 ? "INVALID" : "NEED_ACK" : "NO_ACK";
        }

        public static int valueOf(int i2) {
            if (i2 == 0) {
                return 0;
            }
            if (i2 != 1) {
            }
            return 1;
        }
    }

    /* compiled from: Taobao */
    public static class MsgType implements Serializable {
        public static final int CONTROL = 0;
        public static final int DATA = 1;
        public static final int HANDSHAKE = 3;
        public static final int INVALID = -1;
        public static final int PING = 2;

        public static String name(int i2) {
            return i2 != 0 ? i2 != 1 ? i2 != 2 ? i2 != 3 ? "INVALID" : "HANDSHAKE" : "PING" : "DATA" : "CONTROL";
        }

        public static int valueOf(int i2) {
            if (i2 == 0) {
                return 0;
            }
            int i3 = 1;
            if (i2 != 1) {
                i3 = 2;
                if (i2 != 2) {
                    i3 = 3;
                    if (i2 != 3) {
                        return 0;
                    }
                }
            }
            return i3;
        }
    }

    /* compiled from: Taobao */
    public enum ReqType {
        DATA,
        ACK,
        REQ,
        RES;

        public static ReqType valueOf(int i2) {
            return i2 != 0 ? i2 != 1 ? i2 != 2 ? i2 != 3 ? DATA : RES : REQ : ACK : DATA;
        }
    }

    private Message() {
        synchronized (Message.class) {
            this.startSendTime = System.currentTimeMillis();
            this.dataId = this.startSendTime + "." + f8422a;
            long j2 = f8422a;
            f8422a = 1 + j2;
            this.I = new Id((int) j2, this.dataId);
        }
    }

    public static Message BuildPing(boolean z, int i2) {
        Message message = new Message();
        message.f8432k = 2;
        message.command = 201;
        message.force = z;
        message.delyTime = i2;
        return message;
    }

    public static Message buildBackground(String str) {
        Message message = new Message();
        message.a(1, ReqType.DATA, 0);
        message.command = 100;
        message.f8430i = Constants.TARGET_BACK;
        a(str, message);
        return message;
    }

    @Deprecated
    public static Message buildBindApp(com.taobao.accs.net.a aVar, Context context, Intent intent) {
        return buildBindApp(aVar.b((String) null), aVar.f8512m, context, intent);
    }

    @Deprecated
    public static Message buildBindService(com.taobao.accs.net.a aVar, Context context, Intent intent) {
        return buildBindService(aVar.b((String) null), aVar.f8512m, intent);
    }

    @Deprecated
    public static Message buildBindUser(com.taobao.accs.net.a aVar, Context context, Intent intent) {
        return buildBindUser(aVar.b((String) null), aVar.f8512m, intent);
    }

    public static Message buildErrorReportMessage(String str, String str2, String str3, int i2) {
        Message message = new Message();
        try {
            message.host = new URL(str3);
        } catch (MalformedURLException e2) {
            e2.printStackTrace();
        }
        message.f8430i = Constants.TARGET_SERVICE_ST;
        message.a(1, ReqType.DATA, 0);
        message.command = 100;
        message.D = (0 + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + i2 + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + str + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + com.taobao.accs.utl.j.b(GlobalClientInfo.getContext()) + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + str2).getBytes();
        return message;
    }

    public static Message buildForeground(String str) {
        Message message = new Message();
        message.a(1, ReqType.DATA, 0);
        message.command = 100;
        message.f8430i = Constants.TARGET_FORE;
        a(str, message);
        return message;
    }

    public static Message buildHandshake(String str) {
        Message message = new Message();
        message.a(3, ReqType.DATA, 1);
        message.f8434m = str;
        message.f8430i = Constants.TARGET_CONTROL;
        message.command = 200;
        return message;
    }

    public static Message buildParameterError(String str, int i2) {
        Message message = new Message();
        message.a(1, ReqType.ACK, 0);
        message.command = Integer.valueOf(i2);
        message.f8434m = str;
        return message;
    }

    @Deprecated
    public static Message buildPushAck(com.taobao.accs.net.a aVar, String str, String str2, String str3, boolean z, short s, String str4, Map<Integer, String> map) {
        return buildPushAck(aVar.b((String) null), aVar.f8512m, str, str2, str3, z, s, str4, map);
    }

    @Deprecated
    public static Message buildRequest(com.taobao.accs.net.a aVar, Context context, String str, String str2, String str3, ACCSManager.AccsRequest accsRequest, boolean z) {
        return buildRequest(context, aVar.b((String) null), aVar.f8512m, aVar.f8508i.getStoreId(), str, str2, accsRequest, z);
    }

    @Deprecated
    public static Message buildSendData(com.taobao.accs.net.a aVar, Context context, String str, String str2, ACCSManager.AccsRequest accsRequest) {
        return buildSendData(aVar.b((String) null), aVar.f8512m, aVar.f8508i.getStoreId(), context, str, accsRequest, true);
    }

    @Deprecated
    public static Message buildUnbindApp(com.taobao.accs.net.a aVar, Context context, Intent intent) {
        return buildUnbindApp(aVar.b((String) null), intent);
    }

    @Deprecated
    public static Message buildUnbindService(com.taobao.accs.net.a aVar, Context context, Intent intent) {
        return buildUnbindService(aVar.b((String) null), aVar.f8512m, intent);
    }

    @Deprecated
    public static Message buildUnbindUser(com.taobao.accs.net.a aVar, Context context, Intent intent) {
        return buildUnbindUser(aVar.b((String) null), aVar.f8512m, intent);
    }

    private String c() {
        return "Msg" + c.c.a.b.a.a.s1 + this.H;
    }

    short a(Map<Integer, String> map) {
        short length = 0;
        if (map != null) {
            try {
                Iterator<Integer> it = map.keySet().iterator();
                while (it.hasNext()) {
                    String str = map.get(Integer.valueOf(it.next().intValue()));
                    if (!TextUtils.isEmpty(str)) {
                        length = (short) (length + ((short) (str.getBytes("utf-8").length & EXT_HEADER_VALUE_MAX_LEN)) + 2);
                    }
                }
            } catch (Exception e2) {
                e2.toString();
            }
        }
        return length;
    }

    void b() throws JSONException, UnsupportedEncodingException {
        Integer num = this.command;
        if (num == null || num.intValue() == 100 || this.command.intValue() == 102) {
            return;
        }
        this.D = new p.a().a("command", this.command.intValue() == 100 ? null : this.command).a("appKey", this.o).a(Constants.KEY_OS_TYPE, this.p).a("sign", this.appSign).a("sdkVersion", this.v).a("appVersion", this.u).a(Constants.KEY_TTID, this.w).a(Constants.KEY_MODEL, this.y).a("brand", this.z).a("imei", this.A).a(Constants.KEY_IMSI, this.B).a(Constants.KYE_MAC_ADDRESS, this.x).a("os", this.q).a(Constants.KEY_EXTS, this.t).a().toString().getBytes("utf-8");
    }

    public byte[] build(Context context, int i2) throws IOException {
        byte[] bytes;
        try {
            b();
        } catch (UnsupportedEncodingException e2) {
            ALog.e(c(), "build2", e2, new Object[0]);
        } catch (JSONException e3) {
            ALog.e(c(), "build1", e3, new Object[0]);
        }
        byte[] bArr = this.D;
        String str = bArr != null ? new String(bArr) : "";
        a();
        if (!this.isAck) {
            StringBuilder sb = new StringBuilder();
            sb.append(UtilityImpl.j(context));
            sb.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
            sb.append(this.f8434m);
            sb.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
            String str2 = this.serviceId;
            if (str2 == null) {
                str2 = "";
            }
            sb.append(str2);
            sb.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
            String str3 = this.userinfo;
            if (str3 == null) {
                str3 = "";
            }
            sb.append(str3);
            this.f8431j = sb.toString();
        }
        try {
            bytes = (this.dataId + "").getBytes("utf-8");
            this.f8429h = (byte) this.f8431j.getBytes("utf-8").length;
            this.f8428g = (byte) this.f8430i.getBytes("utf-8").length;
        } catch (Exception e4) {
            e4.printStackTrace();
            ALog.e(c(), "build3", e4, new Object[0]);
            bytes = (this.dataId + "").getBytes();
            this.f8429h = (byte) this.f8431j.getBytes().length;
            this.f8428g = (byte) this.f8430i.getBytes().length;
        }
        short sA = a(this.f8433l);
        int length = this.f8428g + 3 + 1 + this.f8429h + 1 + bytes.length;
        byte[] bArr2 = this.D;
        this.f8426e = (short) (length + (bArr2 == null ? 0 : bArr2.length) + sA + 2);
        this.f8425d = (short) (this.f8426e + 2);
        r rVar = new r(this.f8425d + 2 + 4);
        if (ALog.isPrintLog(ALog.Level.D)) {
            ALog.d(c(), "Build Message", Constants.KEY_DATA_ID, new String(bytes));
        }
        try {
            rVar.a((byte) (this.f8423b | 32));
            if (ALog.isPrintLog(ALog.Level.D)) {
                ALog.d(c(), "\tversion:2 compress:" + ((int) this.f8423b), new Object[0]);
            }
            if (i2 == 0) {
                rVar.a(n.f16413a);
                if (ALog.isPrintLog(ALog.Level.D)) {
                    ALog.d(c(), "\tflag: 0x80", new Object[0]);
                }
            } else {
                rVar.a((byte) 64);
                if (ALog.isPrintLog(ALog.Level.D)) {
                    ALog.d(c(), "\tflag: 0x40", new Object[0]);
                }
            }
            rVar.a(this.f8425d);
            if (ALog.isPrintLog(ALog.Level.D)) {
                ALog.d(c(), "\ttotalLength:" + ((int) this.f8425d), new Object[0]);
            }
            rVar.a(this.f8426e);
            if (ALog.isPrintLog(ALog.Level.D)) {
                ALog.d(c(), "\tdataLength:" + ((int) this.f8426e), new Object[0]);
            }
            rVar.a(this.f8427f);
            if (ALog.isPrintLog(ALog.Level.D)) {
                ALog.d(c(), "\tflags:" + Integer.toHexString(this.f8427f), new Object[0]);
            }
            rVar.a(this.f8428g);
            if (ALog.isPrintLog(ALog.Level.D)) {
                ALog.d(c(), "\ttargetLength:" + ((int) this.f8428g), new Object[0]);
            }
            rVar.write(this.f8430i.getBytes("utf-8"));
            if (ALog.isPrintLog(ALog.Level.D)) {
                ALog.d(c(), "\ttarget:" + this.f8430i, new Object[0]);
            }
            rVar.a(this.f8429h);
            if (ALog.isPrintLog(ALog.Level.D)) {
                ALog.d(c(), "\tsourceLength:" + ((int) this.f8429h), new Object[0]);
            }
            rVar.write(this.f8431j.getBytes("utf-8"));
            if (ALog.isPrintLog(ALog.Level.D)) {
                ALog.d(c(), "\tsource:" + this.f8431j, new Object[0]);
            }
            rVar.a((byte) bytes.length);
            if (ALog.isPrintLog(ALog.Level.D)) {
                ALog.d(c(), "\tdataIdLength:" + bytes.length, new Object[0]);
            }
            rVar.write(bytes);
            if (ALog.isPrintLog(ALog.Level.D)) {
                ALog.d(c(), "\tdataId:" + new String(bytes), new Object[0]);
            }
            rVar.a(sA);
            if (ALog.isPrintLog(ALog.Level.D)) {
                ALog.d(c(), "\textHeader len:" + ((int) sA), new Object[0]);
            }
            if (this.f8433l != null) {
                Iterator<Integer> it = this.f8433l.keySet().iterator();
                while (it.hasNext()) {
                    int iIntValue = it.next().intValue();
                    String str4 = this.f8433l.get(Integer.valueOf(iIntValue));
                    if (!TextUtils.isEmpty(str4)) {
                        rVar.a((short) ((((short) iIntValue) << 10) | ((short) (str4.getBytes("utf-8").length & EXT_HEADER_VALUE_MAX_LEN))));
                        rVar.write(str4.getBytes("utf-8"));
                        if (ALog.isPrintLog(ALog.Level.D)) {
                            ALog.d(c(), "\textHeader key:" + iIntValue + " value:" + str4, new Object[0]);
                        }
                    }
                }
            }
            if (this.D != null) {
                rVar.write(this.D);
            }
            if (ALog.isPrintLog(ALog.Level.D)) {
                ALog.d(c(), "\toriData:" + str, new Object[0]);
            }
            rVar.flush();
        } catch (IOException e5) {
            ALog.e(c(), "build4", e5, new Object[0]);
        }
        byte[] byteArray = rVar.toByteArray();
        try {
            rVar.close();
        } catch (IOException e6) {
            ALog.e(c(), "build5", e6, new Object[0]);
        }
        return byteArray;
    }

    public String getDataId() {
        return this.dataId;
    }

    public long getDelyTime() {
        return this.delyTime;
    }

    public Id getMsgId() {
        return this.I;
    }

    public NetPerformanceMonitor getNetPermanceMonitor() {
        return this.G;
    }

    public int getNode() {
        return this.E;
    }

    public String getPackageName() {
        String str = this.f8434m;
        return str == null ? "" : str;
    }

    public int getRetryTimes() {
        return this.retryTimes;
    }

    public int getType() {
        return this.f8432k;
    }

    public boolean isControlFrame() {
        return Constants.TARGET_CONTROL.equals(this.f8430i);
    }

    public boolean isTimeOut() {
        boolean z = (System.currentTimeMillis() - this.startSendTime) + this.delyTime >= ((long) this.timeout);
        if (z) {
            ALog.e(c(), "delay time:" + this.delyTime + " beforeSendTime:" + (System.currentTimeMillis() - this.startSendTime) + " timeout" + this.timeout, new Object[0]);
        }
        return z;
    }

    public void setSendTime(long j2) {
        this.F = j2;
    }

    public static Message buildBindApp(String str, String str2, Context context, Intent intent) {
        Message messageBuildBindApp = null;
        try {
            messageBuildBindApp = buildBindApp(context, str2, intent.getStringExtra("appKey"), intent.getStringExtra("app_sercet"), intent.getStringExtra(Constants.KEY_PACKAGE_NAME), intent.getStringExtra(Constants.KEY_TTID), intent.getStringExtra("appVersion"));
            a(str, messageBuildBindApp);
            return messageBuildBindApp;
        } catch (Exception e2) {
            ALog.e("Msg", "buildBindApp", e2.getMessage());
            return messageBuildBindApp;
        }
    }

    public static Message buildBindService(String str, String str2, Intent intent) {
        Message messageBuildBindService = null;
        try {
            messageBuildBindService = buildBindService(intent.getStringExtra(Constants.KEY_PACKAGE_NAME), intent.getStringExtra(Constants.KEY_SERVICE_ID));
            messageBuildBindService.H = str2;
            a(str, messageBuildBindService);
            return messageBuildBindService;
        } catch (Exception e2) {
            ALog.e("Msg", "buildBindService", e2, new Object[0]);
            e2.printStackTrace();
            return messageBuildBindService;
        }
    }

    public static Message buildBindUser(String str, String str2, Intent intent) {
        Message messageBuildBindUser = null;
        try {
            messageBuildBindUser = buildBindUser(intent.getStringExtra(Constants.KEY_PACKAGE_NAME), intent.getStringExtra("userInfo"));
            if (messageBuildBindUser != null) {
                messageBuildBindUser.H = str2;
                a(str, messageBuildBindUser);
            }
        } catch (Exception e2) {
            ALog.e("Msg", "buildBindUser", e2, new Object[0]);
            e2.printStackTrace();
        }
        return messageBuildBindUser;
    }

    public static Message buildPushAck(String str, String str2, String str3, String str4, String str5, boolean z, short s, String str6, Map<Integer, String> map) {
        Message message = new Message();
        message.E = 1;
        message.a(s, z);
        message.f8431j = str3;
        message.f8430i = str4;
        message.dataId = str5;
        message.isAck = true;
        message.f8433l = map;
        try {
            try {
                if (TextUtils.isEmpty(str6)) {
                    message.host = new URL(str);
                } else {
                    message.host = new URL(str6);
                }
                message.H = str2;
                if (message.host == null) {
                    message.host = new URL(str);
                }
            } catch (MalformedURLException e2) {
                e2.printStackTrace();
            }
        } catch (Throwable th) {
            try {
                ALog.e("Msg", "buildPushAck", th, new Object[0]);
                if (message.host == null) {
                    message.host = new URL(str);
                }
            } catch (Throwable th2) {
                if (message.host == null) {
                    try {
                        message.host = new URL(str);
                    } catch (MalformedURLException e3) {
                        e3.printStackTrace();
                    }
                }
                throw th2;
            }
        }
        return message;
    }

    public static Message buildRequest(Context context, String str, String str2, String str3, String str4, String str5, ACCSManager.AccsRequest accsRequest, boolean z) {
        if (TextUtils.isEmpty(str4)) {
            return null;
        }
        Message message = new Message();
        message.E = 1;
        message.a(1, ReqType.REQ, 1);
        message.command = 100;
        message.f8434m = str4;
        message.serviceId = accsRequest.serviceId;
        message.userinfo = accsRequest.userId;
        message.D = accsRequest.data;
        String str6 = TextUtils.isEmpty(accsRequest.targetServiceName) ? accsRequest.serviceId : accsRequest.targetServiceName;
        StringBuilder sb = new StringBuilder();
        sb.append(str5);
        sb.append(str6);
        sb.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
        String str7 = accsRequest.target;
        if (str7 == null) {
            str7 = "";
        }
        sb.append(str7);
        message.f8430i = sb.toString();
        if (TextUtils.isEmpty(accsRequest.dataId)) {
            accsRequest.dataId = message.getMsgId().getDataId();
        }
        message.cunstomDataId = accsRequest.dataId;
        message.bizId = accsRequest.businessId;
        message.H = str2;
        int i2 = accsRequest.timeout;
        if (i2 > 0) {
            message.timeout = i2;
        }
        if (z) {
            a(str, message, accsRequest);
        } else {
            message.host = accsRequest.host;
        }
        a(message, GlobalClientInfo.getInstance(context).getSid(str2), GlobalClientInfo.getInstance(context).getUserId(str2), str3, GlobalClientInfo.f8394c, accsRequest.businessId, accsRequest.tag);
        message.G = new NetPerformanceMonitor();
        message.G.setDataId(accsRequest.dataId);
        message.G.setServiceId(accsRequest.serviceId);
        message.G.setHost(message.host.toString());
        message.H = str2;
        return message;
    }

    @Deprecated
    public static Message buildSendData(com.taobao.accs.net.a aVar, Context context, String str, String str2, ACCSManager.AccsRequest accsRequest, boolean z) {
        return buildSendData(aVar.b((String) null), aVar.f8512m, aVar.f8508i.getStoreId(), context, str, accsRequest, z);
    }

    public static Message buildUnbindApp(String str, Intent intent) {
        ALog.e("Msg", "buildUnbindApp1" + UtilityImpl.a(new Exception()), new Object[0]);
        Message messageBuildUnbindApp = null;
        try {
            messageBuildUnbindApp = buildUnbindApp(str, intent.getStringExtra(Constants.KEY_PACKAGE_NAME));
            a(str, messageBuildUnbindApp);
            return messageBuildUnbindApp;
        } catch (Exception e2) {
            ALog.e("Msg", "buildUnbindApp1", e2.getMessage());
            return messageBuildUnbindApp;
        }
    }

    public static Message buildUnbindService(String str, String str2, Intent intent) {
        Message messageBuildUnbindService = null;
        try {
            messageBuildUnbindService = buildUnbindService(intent.getStringExtra(Constants.KEY_PACKAGE_NAME), intent.getStringExtra(Constants.KEY_SERVICE_ID));
            messageBuildUnbindService.H = str2;
            a(str, messageBuildUnbindService);
            return messageBuildUnbindService;
        } catch (Exception e2) {
            ALog.e("Msg", "buildUnbindService", e2, new Object[0]);
            e2.printStackTrace();
            return messageBuildUnbindService;
        }
    }

    public static Message buildUnbindUser(String str, String str2, Intent intent) {
        Message messageBuildUnbindUser = null;
        try {
            messageBuildUnbindUser = buildUnbindUser(intent.getStringExtra(Constants.KEY_PACKAGE_NAME));
            messageBuildUnbindUser.H = str2;
            a(str, messageBuildUnbindUser);
            return messageBuildUnbindUser;
        } catch (Exception e2) {
            ALog.e("Msg", "buildUnbindUser", e2, new Object[0]);
            e2.printStackTrace();
            return messageBuildUnbindUser;
        }
    }

    public static Message buildSendData(String str, String str2, String str3, Context context, String str4, ACCSManager.AccsRequest accsRequest) {
        return buildSendData(str, str2, str3, context, str4, accsRequest, true);
    }

    public static Message buildSendData(String str, String str2, String str3, Context context, String str4, ACCSManager.AccsRequest accsRequest, boolean z) {
        if (TextUtils.isEmpty(str4)) {
            return null;
        }
        Message message = new Message();
        message.E = 1;
        message.a(1, ReqType.DATA, 1);
        message.command = 100;
        message.f8434m = str4;
        message.serviceId = accsRequest.serviceId;
        message.userinfo = accsRequest.userId;
        message.D = accsRequest.data;
        String str5 = TextUtils.isEmpty(accsRequest.targetServiceName) ? accsRequest.serviceId : accsRequest.targetServiceName;
        StringBuilder sb = new StringBuilder();
        sb.append(Constants.TARGET_SERVICE_PRE);
        sb.append(str5);
        sb.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
        String str6 = accsRequest.target;
        if (str6 == null) {
            str6 = "";
        }
        sb.append(str6);
        message.f8430i = sb.toString();
        if (TextUtils.isEmpty(accsRequest.dataId)) {
            accsRequest.dataId = message.getMsgId().getDataId();
        }
        message.cunstomDataId = accsRequest.dataId;
        message.bizId = accsRequest.businessId;
        int i2 = accsRequest.timeout;
        if (i2 > 0) {
            message.timeout = i2;
        }
        if (z) {
            a(str, message, accsRequest);
        } else {
            message.host = accsRequest.host;
        }
        a(message, GlobalClientInfo.getInstance(context).getSid(str2), GlobalClientInfo.getInstance(context).getUserId(str2), str3, GlobalClientInfo.f8394c, accsRequest.businessId, accsRequest.tag);
        message.G = new NetPerformanceMonitor();
        message.G.setMsgType(0);
        message.G.setDataId(accsRequest.dataId);
        message.G.setServiceId(accsRequest.serviceId);
        message.G.setHost(message.host.toString());
        message.H = str2;
        return message;
    }

    void a() throws IOException {
        GZIPOutputStream gZIPOutputStream;
        Throwable th;
        ByteArrayOutputStream byteArrayOutputStream;
        try {
            try {
            } catch (Throwable th2) {
                gZIPOutputStream = null;
                th = th2;
                byteArrayOutputStream = null;
            }
            if (this.D == null) {
                return;
            }
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            } catch (Throwable th3) {
                gZIPOutputStream = null;
                th = th3;
            }
            try {
                gZIPOutputStream.write(this.D);
                gZIPOutputStream.finish();
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                if (byteArray != null && byteArray.length < this.D.length) {
                    this.D = byteArray;
                    this.f8423b = (byte) 1;
                }
                gZIPOutputStream.close();
            } catch (Throwable th4) {
                th = th4;
                try {
                    c();
                    th.toString();
                    th.printStackTrace();
                    if (gZIPOutputStream != null) {
                        gZIPOutputStream.close();
                    }
                    if (byteArrayOutputStream == null) {
                        return;
                    }
                    byteArrayOutputStream.close();
                } catch (Throwable th5) {
                    if (gZIPOutputStream != null) {
                        try {
                            gZIPOutputStream.close();
                        } catch (Exception unused) {
                            throw th5;
                        }
                    }
                    if (byteArrayOutputStream != null) {
                        byteArrayOutputStream.close();
                    }
                    throw th5;
                }
            }
            byteArrayOutputStream.close();
        } catch (Exception unused2) {
        }
    }

    @Deprecated
    public static Message buildUnbindApp(com.taobao.accs.net.a aVar, Context context, String str, String str2, String str3, String str4) {
        return buildUnbindApp(aVar.b((String) null), str);
    }

    public static Message buildUnbindApp(String str, String str2) {
        Message message;
        try {
            ALog.d("Msg", "buildUnbindApp", new Object[0]);
        } catch (Exception e2) {
            e = e2;
            message = null;
        }
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        message = new Message();
        try {
            message.E = 1;
            message.a(1, ReqType.DATA, 1);
            message.f8434m = str2;
            message.f8430i = Constants.TARGET_CONTROL;
            message.command = 2;
            message.f8434m = str2;
            message.v = 221;
            message.cunstomDataId = KEY_UNBINDAPP;
            a(str, message);
        } catch (Exception e3) {
            e = e3;
            ALog.e("Msg", "buildUnbindApp", e.getMessage());
            return message;
        }
        return message;
    }

    @Deprecated
    public static Message buildUnbindUser(Context context, String str, String str2, String str3, String str4, String str5) {
        return buildUnbindUser(str);
    }

    @Deprecated
    public static Message buildBindService(Context context, String str, String str2, String str3, String str4, String str5, String str6) {
        return buildBindService(str, str3);
    }

    @Deprecated
    public static Message buildBindUser(Context context, String str, String str2, String str3, String str4, String str5) {
        return buildBindUser(str, str4);
    }

    @Deprecated
    public static Message buildUnbindService(Context context, String str, String str2, String str3, String str4, String str5, String str6) {
        return buildUnbindService(str, str3);
    }

    public static Message buildUnbindUser(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Message message = new Message();
        message.E = 1;
        message.a(1, ReqType.DATA, 1);
        message.f8434m = str;
        message.f8430i = Constants.TARGET_CONTROL;
        message.command = 4;
        message.v = 221;
        message.cunstomDataId = KEY_UNBINDUSER;
        return message;
    }

    @Deprecated
    public static Message buildBindApp(Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        return buildBindApp(context, str, str2, str3, str4, str5, str6);
    }

    public static Message buildBindService(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        Message message = new Message();
        message.E = 1;
        message.a(1, ReqType.DATA, 1);
        message.f8434m = str;
        message.serviceId = str2;
        message.f8430i = Constants.TARGET_CONTROL;
        message.command = 5;
        message.f8434m = str;
        message.serviceId = str2;
        message.v = 221;
        message.cunstomDataId = KEY_BINDSERVICE;
        return message;
    }

    public static Message buildBindUser(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        Message message = new Message();
        message.E = 1;
        message.a(1, ReqType.DATA, 1);
        message.f8434m = str;
        message.userinfo = str2;
        message.f8430i = Constants.TARGET_CONTROL;
        message.command = 3;
        message.f8434m = str;
        message.userinfo = str2;
        message.v = 221;
        message.cunstomDataId = KEY_BINDUSER;
        return message;
    }

    public static Message buildUnbindService(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        Message message = new Message();
        message.E = 1;
        message.a(1, ReqType.DATA, 1);
        message.f8434m = str;
        message.serviceId = str2;
        message.f8430i = Constants.TARGET_CONTROL;
        message.command = 6;
        message.f8434m = str;
        message.serviceId = str2;
        message.v = 221;
        message.cunstomDataId = KEY_UNBINDSERVICE;
        return message;
    }

    public static Message buildBindApp(Context context, String str, String str2, String str3, String str4, String str5, String str6) {
        if (TextUtils.isEmpty(str4)) {
            return null;
        }
        Message message = new Message();
        message.E = 1;
        message.a(1, ReqType.DATA, 1);
        message.p = 1;
        message.q = Build.VERSION.SDK_INT + "";
        message.f8434m = str4;
        message.f8430i = Constants.TARGET_CONTROL;
        message.command = 1;
        message.o = str2;
        message.appSign = UtilityImpl.a(str2, str3, UtilityImpl.j(context));
        message.v = 221;
        message.u = str6;
        message.f8434m = str4;
        message.w = str5;
        message.y = Build.MODEL;
        message.z = Build.BRAND;
        message.cunstomDataId = KEY_BINDAPP;
        message.H = str;
        message.t = new p.a().a("notifyEnable", UtilityImpl.o(context)).a("romInfo", new o().a()).a().toString();
        UtilityImpl.a(context, Constants.SP_FILE_NAME, UtilityImpl.o(context));
        return message;
    }

    private static void a(String str, Message message, ACCSManager.AccsRequest accsRequest) {
        URL url = accsRequest.host;
        if (url == null) {
            try {
                message.host = new URL(str);
                return;
            } catch (MalformedURLException e2) {
                ALog.e("Msg", "setUnit", e2, new Object[0]);
                e2.printStackTrace();
                return;
            }
        }
        message.host = url;
    }

    private static void a(String str, Message message) {
        try {
            message.host = new URL(str);
        } catch (Exception e2) {
            ALog.e("Msg", "setControlHost", e2, new Object[0]);
        }
    }

    private static void a(Message message, String str, String str2, String str3, String str4, String str5, String str6) {
        if (TextUtils.isEmpty(str5) && TextUtils.isEmpty(str) && TextUtils.isEmpty(str2) && TextUtils.isEmpty(str6) && str4 == null) {
            return;
        }
        message.f8433l = new HashMap();
        if (str5 != null && UtilityImpl.a(str5) <= 1023) {
            message.f8433l.put(Integer.valueOf(TaoBaseService.ExtHeaderType.TYPE_BUSINESS.ordinal()), str5);
        }
        if (str != null && UtilityImpl.a(str) <= 1023) {
            message.f8433l.put(Integer.valueOf(TaoBaseService.ExtHeaderType.TYPE_SID.ordinal()), str);
        }
        if (str2 != null && UtilityImpl.a(str2) <= 1023) {
            message.f8433l.put(Integer.valueOf(TaoBaseService.ExtHeaderType.TYPE_USERID.ordinal()), str2);
        }
        if (str6 != null && UtilityImpl.a(str6) <= 1023) {
            message.f8433l.put(Integer.valueOf(TaoBaseService.ExtHeaderType.TYPE_TAG.ordinal()), str6);
        }
        if (str4 != null && UtilityImpl.a(str4) <= 1023) {
            message.f8433l.put(Integer.valueOf(TaoBaseService.ExtHeaderType.TYPE_COOKIE.ordinal()), str4);
        }
        if (str3 == null || UtilityImpl.a(str3) > 1023) {
            return;
        }
        message.f8433l.put(19, str3);
    }

    private void a(int i2, ReqType reqType, int i3) {
        this.f8432k = i2;
        if (i2 != 2) {
            this.f8427f = (short) (((((i2 & 1) << 4) | (reqType.ordinal() << 2)) | i3) << 11);
        }
    }

    private void a(short s, boolean z) {
        this.f8432k = 1;
        this.f8427f = s;
        this.f8427f = (short) (this.f8427f & (-16385));
        this.f8427f = (short) (this.f8427f | 8192);
        this.f8427f = (short) (this.f8427f & (-2049));
        this.f8427f = (short) (this.f8427f & (-65));
        if (z) {
            this.f8427f = (short) (this.f8427f | 32);
        }
    }
}
