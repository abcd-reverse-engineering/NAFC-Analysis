package com.huawei.agconnect.config.impl;

import android.text.TextUtils;
import com.huawei.agconnect.config.ConfigReader;
import com.huawei.agconnect.config.IDecrypt;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.crypto.SecretKey;

/* loaded from: classes.dex */
public class e implements IDecrypt {

    /* renamed from: a, reason: collision with root package name */
    private final ConfigReader f6399a;

    /* renamed from: b, reason: collision with root package name */
    private SecretKey f6400b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f6401c = false;

    public e(ConfigReader configReader) {
        this.f6399a = configReader;
    }

    private void a() {
        try {
            this.f6400b = j.a(new d(this.f6399a.getString("/code/code1", null), this.f6399a.getString("/code/code2", null), this.f6399a.getString("/code/code3", null), this.f6399a.getString("/code/code4", null), "PBKDF2WithHmacSHA1", 10000));
        } catch (IllegalArgumentException | NoSuchAlgorithmException | InvalidKeySpecException unused) {
            this.f6400b = null;
        }
        this.f6401c = true;
    }

    public static boolean a(String str) {
        return !TextUtils.isEmpty(str) && Pattern.matches("^\\[!([A-Fa-f0-9]*)]", str);
    }

    private String b(String str) {
        try {
            Matcher matcher = Pattern.compile("^\\[!([A-Fa-f0-9]*)]").matcher(str);
            if (matcher.find()) {
                return matcher.group(1);
            }
        } catch (IllegalStateException | IndexOutOfBoundsException unused) {
        }
        return "";
    }

    @Override // com.huawei.agconnect.config.IDecrypt
    public String decrypt(String str, String str2) {
        if (!this.f6401c) {
            a();
        }
        if (this.f6400b != null && a(str)) {
            try {
                return new String(j.a(this.f6400b, Hex.decodeHexString(b(str))), "UTF-8");
            } catch (UnsupportedEncodingException | IllegalArgumentException | GeneralSecurityException unused) {
            }
        }
        return str2;
    }
}
