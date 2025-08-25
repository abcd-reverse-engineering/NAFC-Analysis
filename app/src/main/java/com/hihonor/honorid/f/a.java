package com.hihonor.honorid.f;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.text.TextUtils;
import cn.cloudwalk.util.LogUtils;
import com.hihonor.honorid.core.data.HonorAccount;
import com.honor.openSdk.R;
import h.f1;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import k.a.a.a.h;
import k.a.a.a.j.e;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: BaseUtil.java */
/* loaded from: classes.dex */
public class a {
    public static String a(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (byte b2 : bArr) {
            String hexString = Integer.toHexString(b2 & f1.f16099c);
            if (hexString.length() == 1) {
                sb.append('0');
            }
            sb.append(hexString);
        }
        return sb.toString();
    }

    public static byte[] b(String str) {
        if (TextUtils.isEmpty(str)) {
            e.a("BaseUtil", "getUTF8Bytes, str is empty", true);
            return new byte[0];
        }
        try {
            return str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException unused) {
            e.a("BaseUtil", "getBytes error", true);
            return new byte[0];
        }
    }

    public static boolean c(String str) throws UnsupportedEncodingException {
        int i2;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            byte[] bytes = str.getBytes("UTF-8");
            while (i2 < bytes.length) {
                int i3 = bytes[i2] & f1.f16099c;
                i2 = (i3 > 31 && i3 < 127) ? i2 + 1 : 0;
                e.b("BaseUtil", "byte not printable", true);
                return false;
            }
        } catch (UnsupportedEncodingException unused) {
            e.b("BaseUtil", "UnsupportedEncodingException", true);
        }
        return true;
    }

    public static String d(Context context) {
        return context != null ? context.getPackageName() : "";
    }

    public static boolean e(Context context) {
        return context.getPackageName().equals(k.a.a.a.e.a(context).a());
    }

    private static List<String> f(Context context) throws Resources.NotFoundException {
        ArrayList arrayList = new ArrayList();
        XmlResourceParser xml = context.getResources().getXml(R.xml.usesdk_packagename);
        if (xml == null) {
            return arrayList;
        }
        try {
            for (int eventType = xml.getEventType(); 1 != eventType; eventType = xml.next()) {
                String name = xml.getName();
                if (eventType == 2 && "package".equals(name)) {
                    arrayList.add(xml.nextText());
                }
            }
        } catch (IOException unused) {
            e.a("BaseUtil", "Parser xml exception: IOException", true);
        } catch (XmlPullParserException unused2) {
            e.a("BaseUtil", "Parser xml exception: XmlPullParserException", true);
        }
        return arrayList;
    }

    public static boolean b(Context context) {
        if (context == null) {
            e.a("BaseUtil", "context is null.", true);
            return true;
        }
        List<String> listF = null;
        com.hihonor.honorid.a aVarC = com.hihonor.honorid.a.c();
        if (aVarC.b() == null) {
            try {
                listF = f(context);
                aVarC.a(listF);
            } catch (Exception unused) {
                e.a("BaseUtil", LogUtils.LOG_EXCEPTION, true);
            }
        } else {
            listF = aVarC.b();
        }
        return listF == null || !listF.contains(context.getPackageName());
    }

    public static String c(Context context) {
        String strA = h.a(context, 0);
        if (!TextUtils.isEmpty(strA) && !"NULL".equals(strA)) {
            return com.hihonor.honorid.d.a.e.b(strA + a());
        }
        e.b("BaseUtil", "TransID get imei is null", true);
        return null;
    }

    public static String a() {
        return a("yyyyMMddHHmmssSSS");
    }

    public static boolean a(HonorAccount honorAccount) {
        if (honorAccount == null) {
            return false;
        }
        if (!TextUtils.isEmpty(honorAccount.b())) {
            return true;
        }
        if (!TextUtils.isEmpty(honorAccount.c()) && !TextUtils.isEmpty(honorAccount.w()) && !TextUtils.isEmpty(honorAccount.t()) && !TextUtils.isEmpty(honorAccount.s())) {
            return true;
        }
        e.b("BaseUtil", "addHonorAccount is invalid", true);
        return false;
    }

    public static boolean a(Context context, String str) {
        PackageManager packageManager = context.getPackageManager();
        Intent intent = new Intent(str);
        intent.setPackage(k.a.a.a.e.a(context).a());
        if ((packageManager != null ? packageManager.queryIntentServices(intent, 0) : null) != null) {
            return !r3.isEmpty();
        }
        return false;
    }

    public static boolean a(Context context) {
        if (context == null) {
            return false;
        }
        try {
            boolean z = context.getPackageManager().getApplicationInfo(k.a.a.a.e.a(context).a(), 128) != null;
            e.b("BaseUtil", "result is:" + z, true);
            return z;
        } catch (PackageManager.NameNotFoundException unused) {
            e.b("BaseUtil", "NameNotFoundException", true);
            return false;
        }
    }

    public static String a(String str) {
        return new SimpleDateFormat(str, Locale.ENGLISH).format(new Date(System.currentTimeMillis()));
    }
}
