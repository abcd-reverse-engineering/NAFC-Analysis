package com.hihonor.push.sdk;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.hihonor.push.framework.aidl.entity.RequestHeader;
import com.hihonor.push.sdk.bean.RemoteServiceBean;
import com.hihonor.push.sdk.common.data.ApiException;
import com.hihonor.push.sdk.internal.HonorPushErrorEnum;
import com.hihonor.push.sdk.ipc.HonorApiAvailability$PackageStates;
import com.xiaomi.mipush.sdk.Constants;
import java.io.Closeable;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;

/* loaded from: classes.dex */
public class b {
    public static String a(byte[] bArr) {
        if (bArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (byte b2 : bArr) {
            String hexString = Integer.toHexString(b2 & h.f1.f16099c);
            if (hexString.length() == 1) {
                sb.append('0');
            }
            sb.append(hexString);
        }
        return sb.toString();
    }

    public static void a(Closeable closeable) throws IOException {
        try {
            closeable.close();
        } catch (Exception e2) {
            c.a("DeflateUtil", "close", e2);
        }
    }

    public static byte[] a(String str) {
        if (TextUtils.isEmpty(str)) {
            return new byte[0];
        }
        String upperCase = str.toUpperCase(Locale.ENGLISH);
        int length = upperCase.length() / 2;
        byte[] bArr = new byte[length];
        try {
            byte[] bytes = upperCase.getBytes(StandardCharsets.UTF_8);
            for (int i2 = 0; i2 < length; i2++) {
                StringBuilder sb = new StringBuilder();
                sb.append("0x");
                int i3 = i2 * 2;
                sb.append(new String(new byte[]{bytes[i3]}, StandardCharsets.UTF_8));
                bArr[i2] = (byte) (((byte) (Byte.decode(sb.toString()).byteValue() << 4)) ^ Byte.decode("0x" + new String(new byte[]{bytes[i3 + 1]}, StandardCharsets.UTF_8)).byteValue());
            }
        } catch (NumberFormatException e2) {
            String str2 = "hex string 2 byte array exception : " + e2.getMessage();
        }
        return bArr;
    }

    public static byte[] a(byte[] bArr, int i2) {
        if (bArr == null) {
            return bArr;
        }
        for (int i3 = 0; i3 < bArr.length; i3++) {
            if (i2 < 0) {
                bArr[i3] = (byte) (bArr[i3] << (-i2));
            } else {
                bArr[i3] = (byte) (bArr[i3] >> i2);
            }
        }
        return bArr;
    }

    public static byte[] a(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = null;
        if (bArr != null) {
            int length = bArr.length;
            if (bArr2.length != length) {
                return null;
            }
            bArr3 = new byte[length];
            for (int i2 = 0; i2 < length; i2++) {
                bArr3[i2] = (byte) (bArr[i2] ^ bArr2[i2]);
            }
        }
        return bArr3;
    }

    public static int b(Context context) throws PackageManager.NameNotFoundException {
        HonorApiAvailability$PackageStates honorApiAvailability$PackageStates;
        if (context == null) {
            throw new NullPointerException("context must not be null.");
        }
        RemoteServiceBean remoteServiceBeanA = a(context);
        String packageName = remoteServiceBeanA.getPackageName();
        String str = "service package name is " + packageName;
        if (TextUtils.isEmpty(packageName)) {
            honorApiAvailability$PackageStates = HonorApiAvailability$PackageStates.NOT_INSTALLED;
        } else {
            try {
                honorApiAvailability$PackageStates = context.getPackageManager().getApplicationInfo(packageName, 0).enabled ? HonorApiAvailability$PackageStates.ENABLED : HonorApiAvailability$PackageStates.DISABLED;
            } catch (PackageManager.NameNotFoundException unused) {
                honorApiAvailability$PackageStates = HonorApiAvailability$PackageStates.NOT_INSTALLED;
            }
        }
        if (HonorApiAvailability$PackageStates.NOT_INSTALLED.equals(honorApiAvailability$PackageStates)) {
            return 8002008;
        }
        if (HonorApiAvailability$PackageStates.DISABLED.equals(honorApiAvailability$PackageStates)) {
            return 8002007;
        }
        if (!TextUtils.equals(packageName, DispatchConstants.ANDROID) || TextUtils.isEmpty(remoteServiceBeanA.getPackageSignature())) {
            return 8002006;
        }
        return HonorPushErrorEnum.SUCCESS.statusCode;
    }

    public static <TResult> a1<TResult> a(Callable<TResult> callable) {
        ExecutorService executorService = o0.f6312c.f6314b;
        n0 n0Var = new n0();
        try {
            executorService.execute(new z0(n0Var, callable));
        } catch (Exception e2) {
            n0Var.a(e2);
        }
        return n0Var.f6310a;
    }

    public static void a(Handler handler) {
        if (Looper.myLooper() != handler.getLooper()) {
            throw new IllegalStateException("Must be called on the handler thread");
        }
    }

    public static <TResult> TResult a(a1<TResult> a1Var) throws ExecutionException, InterruptedException {
        boolean z;
        if (Looper.myLooper() != Looper.getMainLooper()) {
            synchronized (a1Var.f6249a) {
                z = a1Var.f6250b;
            }
            if (!z) {
                y0 y0Var = new y0();
                o0 o0Var = o0.f6312c;
                a1Var.a(new x0(o0Var.f6313a, y0Var)).a(new v0(o0Var.f6313a, y0Var)).a(new r0(o0Var.f6313a, y0Var));
                y0Var.f6356a.await();
            }
            if (a1Var.e()) {
                return a1Var.c();
            }
            throw new ExecutionException(a1Var.b());
        }
        throw new IllegalStateException("await must not be called on the UI thread");
    }

    public static RequestHeader a() throws PackageManager.NameNotFoundException, ApiException {
        String string;
        Context contextA = l.f6299e.a();
        String strValueOf = null;
        try {
            Object obj = contextA.getPackageManager().getApplicationInfo(contextA.getPackageName(), 128).metaData.get("com.hihonor.push.app_id");
            if (obj != null) {
                strValueOf = String.valueOf(obj);
            }
        } catch (PackageManager.NameNotFoundException e2) {
            c.a("ConfigUtils", "getPushAppId", e2);
        }
        if (!TextUtils.isEmpty(strValueOf)) {
            String str = "checkPushAppId Parameter is " + strValueOf;
            String strA = a(contextA, contextA.getPackageName());
            if (!TextUtils.isEmpty(strA)) {
                String str2 = "checkPushCertFingerprint Parameter is " + strA;
                RequestHeader requestHeader = new RequestHeader();
                requestHeader.setPackageName(contextA.getPackageName());
                requestHeader.setAppId(strValueOf);
                requestHeader.setCertificateFingerprint(strA);
                d dVar = d.f6260b;
                requestHeader.setPushToken(dVar.b(contextA));
                synchronized (dVar) {
                    dVar.a(contextA);
                    SharedPreferences sharedPreferences = d.f6259a.f6290a;
                    string = sharedPreferences != null ? sharedPreferences.getString("key_aaid", "") : "";
                    if (TextUtils.isEmpty(string)) {
                        string = UUID.randomUUID().toString().replace(Constants.ACCEPT_TIME_SEPARATOR_SERVER, "");
                        String str3 = "getRandomUUID UUID =" + string;
                        d.f6259a.a("key_aaid", string);
                    }
                }
                requestHeader.setAAID(string);
                requestHeader.setSdkVersion(70061303);
                return requestHeader;
            }
            c.a("checkPushConfig Parameter is missing.");
            throw HonorPushErrorEnum.ERROR_CERT_FINGERPRINT_EMPTY.toApiException();
        }
        c.a("checkPushConfig Parameter is missing");
        throw HonorPushErrorEnum.ERROR_NO_APPID.toApiException();
    }

    public static ApiException a(Exception exc) {
        if (exc.getCause() instanceof ApiException) {
            return (ApiException) exc.getCause();
        }
        if (exc instanceof ApiException) {
            return (ApiException) exc;
        }
        return new ApiException(-1, exc.getMessage());
    }

    public static RemoteServiceBean a(Context context) throws PackageManager.NameNotFoundException {
        RemoteServiceBean remoteServiceBean = new RemoteServiceBean();
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(DispatchConstants.ANDROID, "com.hihonor.android.pushagentproxy.HiPushService"));
        List<ResolveInfo> listQueryIntentServices = context.getPackageManager().queryIntentServices(intent, 128);
        if (listQueryIntentServices.size() > 0) {
            Iterator<ResolveInfo> it = listQueryIntentServices.iterator();
            if (it.hasNext()) {
                ResolveInfo next = it.next();
                String str = next.serviceInfo.applicationInfo.packageName;
                String strA = a(context, str);
                remoteServiceBean.setPackageName(str);
                remoteServiceBean.setPackageServiceName(next.serviceInfo.name);
                remoteServiceBean.setPackageSignature(strA);
            }
        }
        return remoteServiceBean;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0050  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0050 -> B:18:0x0051). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String a(android.content.Context r11, java.lang.String r12) throws android.content.pm.PackageManager.NameNotFoundException {
        /*
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "getCertFingerprint pkgName="
            r0.append(r1)
            r0.append(r12)
            java.lang.String r1 = "isOnlyOne="
            r0.append(r1)
            r1 = 1
            r0.append(r1)
            r0.toString()
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            android.content.pm.PackageManager r11 = r11.getPackageManager()
            r2 = 0
            int r3 = android.os.Build.VERSION.SDK_INT     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L50
            r4 = 30
            if (r3 < r4) goto L45
            r3 = 134217728(0x8000000, float:3.85186E-34)
            android.content.pm.PackageInfo r11 = r11.getPackageInfo(r12, r3)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L50
            if (r11 == 0) goto L50
            android.content.pm.SigningInfo r11 = r11.signingInfo     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L50
            if (r11 == 0) goto L50
            boolean r12 = r11.hasMultipleSigners()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L50
            if (r12 == 0) goto L40
            android.content.pm.Signature[] r11 = r11.getApkContentsSigners()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L50
            goto L51
        L40:
            android.content.pm.Signature[] r11 = r11.getSigningCertificateHistory()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L50
            goto L51
        L45:
            r3 = 64
            android.content.pm.PackageInfo r11 = r11.getPackageInfo(r12, r3)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L50
            if (r11 == 0) goto L50
            android.content.pm.Signature[] r11 = r11.signatures     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L50
            goto L51
        L50:
            r11 = r2
        L51:
            r12 = 0
            if (r11 == 0) goto La2
            int r3 = r11.length
            if (r3 <= 0) goto La2
            int r3 = r11.length
            r4 = 0
        L59:
            if (r4 >= r3) goto La2
            r5 = r11[r4]
            byte[] r5 = r5.toByteArray()
            java.lang.String r6 = "SHA256"
            java.security.MessageDigest r6 = java.security.MessageDigest.getInstance(r6)     // Catch: java.security.NoSuchAlgorithmException -> L98
            byte[] r5 = r6.digest(r5)     // Catch: java.security.NoSuchAlgorithmException -> L98
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.security.NoSuchAlgorithmException -> L98
            r6.<init>()     // Catch: java.security.NoSuchAlgorithmException -> L98
            int r7 = r5.length     // Catch: java.security.NoSuchAlgorithmException -> L98
            r8 = 0
        L72:
            if (r8 >= r7) goto L93
            r9 = r5[r8]     // Catch: java.security.NoSuchAlgorithmException -> L98
            r9 = r9 & 255(0xff, float:3.57E-43)
            java.lang.String r9 = java.lang.Integer.toHexString(r9)     // Catch: java.security.NoSuchAlgorithmException -> L98
            java.util.Locale r10 = java.util.Locale.ENGLISH     // Catch: java.security.NoSuchAlgorithmException -> L98
            java.lang.String r9 = r9.toUpperCase(r10)     // Catch: java.security.NoSuchAlgorithmException -> L98
            int r10 = r9.length()     // Catch: java.security.NoSuchAlgorithmException -> L98
            if (r10 != r1) goto L8d
            java.lang.String r10 = "0"
            r6.append(r10)     // Catch: java.security.NoSuchAlgorithmException -> L98
        L8d:
            r6.append(r9)     // Catch: java.security.NoSuchAlgorithmException -> L98
            int r8 = r8 + 1
            goto L72
        L93:
            java.lang.String r5 = r6.toString()     // Catch: java.security.NoSuchAlgorithmException -> L98
            goto L99
        L98:
            r5 = r2
        L99:
            if (r5 == 0) goto L9f
            r0.add(r5)
            goto La2
        L9f:
            int r4 = r4 + 1
            goto L59
        La2:
            boolean r11 = r0.isEmpty()
            if (r11 == 0) goto La9
            goto Lb0
        La9:
            java.lang.Object r11 = r0.get(r12)
            r2 = r11
            java.lang.String r2 = (java.lang.String) r2
        Lb0:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hihonor.push.sdk.b.a(android.content.Context, java.lang.String):java.lang.String");
    }
}
