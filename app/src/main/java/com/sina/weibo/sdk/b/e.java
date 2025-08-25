package com.sina.weibo.sdk.b;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Build;
import android.os.Bundle;
import com.huawei.hms.framework.common.ContainerUtils;
import com.xiaomi.mipush.sdk.Constants;
import h.f1;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLDecoder;
import okio.Utf8;

/* loaded from: classes.dex */
public final class e {
    private static char[] ak = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=".toCharArray();
    private static byte[] al = new byte[256];

    static {
        for (int i2 = 0; i2 < 256; i2++) {
            al[i2] = -1;
        }
        for (int i3 = 65; i3 <= 90; i3++) {
            al[i3] = (byte) (i3 - 65);
        }
        for (int i4 = 97; i4 <= 122; i4++) {
            al[i4] = (byte) ((i4 + 26) - 97);
        }
        for (int i5 = 48; i5 <= 57; i5++) {
            al[i5] = (byte) ((i5 + 52) - 48);
        }
        byte[] bArr = al;
        bArr[43] = 62;
        bArr[47] = Utf8.REPLACEMENT_BYTE;
    }

    public static int a(int i2, Context context) {
        return (int) ((i2 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static String b(Context context, String str) throws PackageManager.NameNotFoundException {
        Signature[] signatureArr;
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 64);
            if (packageInfo == null || (signatureArr = packageInfo.signatures) == null || signatureArr.length <= 0) {
                return null;
            }
            return d.a(signatureArr[0].toByteArray());
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return null;
        } catch (Exception e3) {
            e3.printStackTrace();
            return null;
        }
    }

    public static Bundle g(String str) {
        try {
            return i(new URL(str).getQuery());
        } catch (MalformedURLException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static Bundle h(String str) {
        try {
            return i(new URI(str).getQuery());
        } catch (URISyntaxException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private static Bundle i(String str) {
        Bundle bundle = new Bundle();
        if (str != null) {
            for (String str2 : str.split("&")) {
                String[] strArrSplit = str2.split(ContainerUtils.KEY_VALUE_DELIMITER);
                try {
                    if (strArrSplit.length == 2) {
                        bundle.putString(URLDecoder.decode(strArrSplit[0], "UTF-8"), URLDecoder.decode(strArrSplit[1], "UTF-8"));
                    } else if (strArrSplit.length == 1) {
                        bundle.putString(URLDecoder.decode(strArrSplit[0], "UTF-8"), "");
                    }
                } catch (UnsupportedEncodingException e2) {
                    e2.printStackTrace();
                }
            }
        }
        return bundle;
    }

    public static String o() {
        return Build.MANUFACTURER + Constants.ACCEPT_TIME_SEPARATOR_SERVER + Build.MODEL + c.c.a.b.a.a.s1 + Build.VERSION.RELEASE + c.c.a.b.a.a.s1 + "weibosdk" + c.c.a.b.a.a.s1 + "0041005000_android";
    }

    public static byte[] b(byte[] bArr) {
        boolean z;
        byte[] bArr2 = new byte[((bArr.length + 2) / 3) * 4];
        int i2 = 0;
        int i3 = 0;
        while (i2 < bArr.length) {
            int i4 = (bArr[i2] & f1.f16099c) << 8;
            int i5 = i2 + 1;
            boolean z2 = true;
            if (i5 < bArr.length) {
                i4 |= bArr[i5] & f1.f16099c;
                z = true;
            } else {
                z = false;
            }
            int i6 = i4 << 8;
            int i7 = i2 + 2;
            if (i7 < bArr.length) {
                i6 |= bArr[i7] & f1.f16099c;
            } else {
                z2 = false;
            }
            int i8 = 64;
            bArr2[i3 + 3] = (byte) ak[z2 ? i6 & 63 : 64];
            int i9 = i6 >> 6;
            int i10 = i3 + 2;
            char[] cArr = ak;
            if (z) {
                i8 = i9 & 63;
            }
            bArr2[i10] = (byte) cArr[i8];
            int i11 = i9 >> 6;
            char[] cArr2 = ak;
            bArr2[i3 + 1] = (byte) cArr2[i11 & 63];
            bArr2[i3 + 0] = (byte) cArr2[(i11 >> 6) & 63];
            i2 += 3;
            i3 += 4;
        }
        return bArr2;
    }
}
