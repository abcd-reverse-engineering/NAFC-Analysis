package com.tencent.bugly.proguard;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public class ay implements bb {

    /* renamed from: a, reason: collision with root package name */
    private String f9293a = null;

    @Override // com.tencent.bugly.proguard.bb
    public byte[] a(byte[] bArr) throws Exception {
        if (this.f9293a == null || bArr == null) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b2 : bArr) {
            stringBuffer.append(((int) b2) + c.c.a.b.a.a.f3100g);
        }
        SecretKeySpec secretKeySpec = new SecretKeySpec(this.f9293a.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(2, secretKeySpec, new IvParameterSpec(this.f9293a.getBytes()));
        byte[] bArrDoFinal = cipher.doFinal(bArr);
        StringBuffer stringBuffer2 = new StringBuffer();
        for (byte b3 : bArrDoFinal) {
            stringBuffer2.append(((int) b3) + c.c.a.b.a.a.f3100g);
        }
        return bArrDoFinal;
    }

    @Override // com.tencent.bugly.proguard.bb
    public byte[] b(byte[] bArr) throws Exception {
        if (this.f9293a == null || bArr == null) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b2 : bArr) {
            stringBuffer.append(((int) b2) + c.c.a.b.a.a.f3100g);
        }
        SecretKeySpec secretKeySpec = new SecretKeySpec(this.f9293a.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(1, secretKeySpec, new IvParameterSpec(this.f9293a.getBytes()));
        byte[] bArrDoFinal = cipher.doFinal(bArr);
        StringBuffer stringBuffer2 = new StringBuffer();
        for (byte b3 : bArrDoFinal) {
            stringBuffer2.append(((int) b3) + c.c.a.b.a.a.f3100g);
        }
        return bArrDoFinal;
    }

    @Override // com.tencent.bugly.proguard.bb
    public void a(String str) {
        if (str != null) {
            for (int length = str.length(); length < 16; length++) {
                str = str + "0";
            }
            this.f9293a = str.substring(0, 16);
        }
    }
}
