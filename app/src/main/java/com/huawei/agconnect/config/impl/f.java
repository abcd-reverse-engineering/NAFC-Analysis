package com.huawei.agconnect.config.impl;

import android.text.TextUtils;
import com.huawei.agconnect.config.IDecrypt;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.SecretKey;

/* loaded from: classes.dex */
public class f implements IDecrypt {

    /* renamed from: a, reason: collision with root package name */
    private SecretKey f6402a;

    /* renamed from: b, reason: collision with root package name */
    private final d f6403b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f6404c = false;

    public f(d dVar) {
        this.f6403b = dVar;
    }

    private void a() {
        try {
            this.f6402a = j.a(this.f6403b);
        } catch (IllegalArgumentException | NoSuchAlgorithmException | InvalidKeySpecException unused) {
            this.f6402a = null;
        }
        this.f6404c = true;
    }

    @Override // com.huawei.agconnect.config.IDecrypt
    public String decrypt(String str, String str2) {
        if (!this.f6404c) {
            a();
        }
        if (this.f6402a != null && !TextUtils.isEmpty(str)) {
            try {
                return new String(j.a(this.f6402a, Hex.decodeHexString(str)), "UTF-8");
            } catch (UnsupportedEncodingException | IllegalArgumentException | GeneralSecurityException e2) {
                String str3 = "decrypt exception:" + e2.getMessage();
            }
        }
        return str2;
    }
}
