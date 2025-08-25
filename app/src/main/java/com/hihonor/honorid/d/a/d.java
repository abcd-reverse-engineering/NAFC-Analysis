package com.hihonor.honorid.d.a;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.tencent.connect.common.Constants;
import com.umeng.analytics.pro.bh;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* compiled from: Proguard.java */
/* loaded from: classes.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private static final List<String> f6220a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    private static String[] f6221b = {"userid", "password", "siteid", "plmn", "mobilephone", "deviceinfo", "uuid", "deviceid2", "secretdigest", "salt", "emmcid", "secretdigesttype", "clientip", "deviceid", "device_id", "securityphone", "securityemail", "cookie", "devicetype", "useremail", NotificationCompat.CATEGORY_EMAIL, c.c.a.b.a.a.I, "oldpassword", "newpassword", "thirdtoken", "smsauthcode", "phone", "access_token", "sc", "sso_st", "token", "ac", "pw", "dvid", bh.aC, "dvid2", "sc", "emid", "sct", bh.aI, "st", Constants.JumpUrlConstants.SRC_TYPE_APP, "uid", com.taobao.accs.common.Constants.KEY_IMSI, "thirdopenid", "thirdaccesstoken", c.c.a.b.a.a.H, "useraccount", "fulluseraccount", "nickName", "uniquelynickname", "loginusername", "thirdnickname", "fingerST"};

    static {
        a();
    }

    private static void a() {
        String[] strArr = f6221b;
        if (strArr != null) {
            for (String str : strArr) {
                if (!TextUtils.isEmpty(str)) {
                    f6220a.add(str.toLowerCase(Locale.ENGLISH));
                }
            }
        }
    }

    private static String a(char c2, int i2) {
        StringBuffer stringBuffer = new StringBuffer(i2);
        for (int i3 = 0; i3 < i2; i3++) {
            stringBuffer.append(c2);
        }
        return stringBuffer.toString();
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (str.length() == 1) {
            return "*";
        }
        int iCeil = (int) Math.ceil((str.length() * 50) / 100.0d);
        return a('*', iCeil) + str.substring(iCeil);
    }
}
