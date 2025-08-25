package com.tencent.open.web.security;

import com.tencent.open.b;
import com.tencent.open.log.SLog;

/* compiled from: ProGuard */
/* loaded from: classes2.dex */
public class SecureJsInterface extends b.C0130b {
    public static boolean isPWDEdit = false;

    /* renamed from: a, reason: collision with root package name */
    private String f9950a;

    public void clearAllEdit() {
        SLog.i("openSDK_LOG.SecureJsInterface", "-->clear all edit.");
        try {
            JniInterface.clearAllPWD();
        } catch (Exception e2) {
            SLog.e("openSDK_LOG.SecureJsInterface", "-->clear all edit exception: " + e2.getMessage());
            throw new RuntimeException(e2);
        }
    }

    public void curPosFromJS(String str) throws NumberFormatException {
        int i2;
        SLog.d("openSDK_LOG.SecureJsInterface", "-->curPosFromJS: " + str);
        try {
            i2 = Integer.parseInt(str);
        } catch (NumberFormatException e2) {
            SLog.e("openSDK_LOG.SecureJsInterface", "-->curPosFromJS number format exception.", e2);
            i2 = -1;
        }
        if (i2 < 0) {
            throw new RuntimeException("position is illegal.");
        }
        boolean z = a.f9953c;
        boolean z2 = a.f9952b;
        if (z2) {
            if (Boolean.valueOf(JniInterface.BackSpaceChar(z2, i2)).booleanValue()) {
                a.f9952b = false;
                return;
            }
            return;
        }
        this.f9950a = a.f9951a;
        String str2 = this.f9950a;
        JniInterface.insetTextToArray(i2, str2, str2.length());
        SLog.v("openSDK_LOG.SecureJsInterface", "curPosFromJS mKey: " + this.f9950a);
    }

    @Override // com.tencent.open.b.C0130b
    public boolean customCallback() {
        return true;
    }

    public String getMD5FromNative() {
        SLog.i("openSDK_LOG.SecureJsInterface", "-->get md5 form native");
        try {
            String pWDKeyToMD5 = JniInterface.getPWDKeyToMD5(null);
            SLog.v("openSDK_LOG.SecureJsInterface", "-->getMD5FromNative, MD5= " + pWDKeyToMD5);
            return pWDKeyToMD5;
        } catch (Exception e2) {
            SLog.e("openSDK_LOG.SecureJsInterface", "-->get md5 form native exception: " + e2.getMessage());
            throw new RuntimeException(e2);
        }
    }

    public void isPasswordEdit(String str) throws NumberFormatException {
        int i2;
        SLog.i("openSDK_LOG.SecureJsInterface", "-->is pswd edit, flag: " + str);
        try {
            i2 = Integer.parseInt(str);
        } catch (Exception e2) {
            SLog.e("openSDK_LOG.SecureJsInterface", "-->is pswd edit exception: " + e2.getMessage());
            i2 = -1;
        }
        if (i2 != 0 && i2 != 1) {
            throw new RuntimeException("is pswd edit flag is illegal.");
        }
        if (i2 == 0) {
            isPWDEdit = false;
        } else if (i2 == 1) {
            isPWDEdit = true;
        }
    }
}
