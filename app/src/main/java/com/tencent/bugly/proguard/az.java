package com.tencent.bugly.proguard;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public class az implements bb {

    /* renamed from: a, reason: collision with root package name */
    private String f9294a = null;

    @Override // com.tencent.bugly.proguard.bb
    public byte[] a(byte[] bArr) throws Exception {
        if (this.f9294a == null || bArr == null) {
            return null;
        }
        Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
        cipher.init(2, SecretKeyFactory.getInstance("DES").generateSecret(new DESKeySpec(this.f9294a.getBytes("UTF-8"))), new IvParameterSpec(this.f9294a.getBytes("UTF-8")));
        return cipher.doFinal(bArr);
    }

    @Override // com.tencent.bugly.proguard.bb
    public byte[] b(byte[] bArr) throws Exception {
        if (this.f9294a == null || bArr == null) {
            return null;
        }
        Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
        cipher.init(1, SecretKeyFactory.getInstance("DES").generateSecret(new DESKeySpec(this.f9294a.getBytes("UTF-8"))), new IvParameterSpec(this.f9294a.getBytes("UTF-8")));
        return cipher.doFinal(bArr);
    }

    @Override // com.tencent.bugly.proguard.bb
    public void a(String str) {
        if (str != null) {
            this.f9294a = str;
        }
    }
}
