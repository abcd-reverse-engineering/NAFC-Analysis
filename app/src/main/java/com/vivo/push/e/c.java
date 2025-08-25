package com.vivo.push.e;

import android.content.Context;
import android.os.Build;
import android.security.KeyPairGeneratorSpec;
import android.text.TextUtils;
import android.util.Base64;
import com.vivo.push.util.u;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.UnrecoverableEntryException;
import java.security.cert.CertificateException;
import java.util.Calendar;
import javax.security.auth.x500.X500Principal;

/* compiled from: RsaSecurity.java */
/* loaded from: classes2.dex */
public final class c implements a {

    /* renamed from: a, reason: collision with root package name */
    private PrivateKey f12029a = null;

    /* renamed from: b, reason: collision with root package name */
    private PublicKey f12030b = null;

    /* renamed from: c, reason: collision with root package name */
    private KeyStore f12031c;

    /* renamed from: d, reason: collision with root package name */
    private X500Principal f12032d;

    /* renamed from: e, reason: collision with root package name */
    private Context f12033e;

    public c(Context context) {
        this.f12033e = context;
        a(this.f12033e);
    }

    private synchronized void a(Context context) {
        try {
            b();
            if (!b("PushRsaKeyAlias")) {
                b(context);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            u.a("RsaSecurity", "init error" + e2.getMessage());
        }
    }

    private void b(Context context) throws NoSuchAlgorithmException, NoSuchProviderException, InvalidAlgorithmParameterException {
        try {
            if (context == null) {
                u.d("RsaSecurity", " generateRSAKeyPairSign context == null ");
                return;
            }
            Calendar calendar = Calendar.getInstance();
            Calendar calendar2 = Calendar.getInstance();
            calendar2.add(1, 999);
            if (Build.VERSION.SDK_INT >= 18) {
                KeyPairGeneratorSpec keyPairGeneratorSpecBuild = new KeyPairGeneratorSpec.Builder(context.getApplicationContext()).setAlias("PushRsaKeyAlias").setSubject(this.f12032d).setSerialNumber(BigInteger.valueOf(1337L)).setStartDate(calendar.getTime()).setEndDate(calendar2.getTime()).build();
                KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA", "AndroidKeyStore");
                keyPairGenerator.initialize(keyPairGeneratorSpecBuild);
                keyPairGenerator.generateKeyPair();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            u.a("RsaSecurity", "generateRSAKeyPairSign error" + e2.getMessage());
        }
    }

    private PrivateKey c(Context context) {
        try {
        } catch (Exception e2) {
            e2.printStackTrace();
            u.a("RsaSecurity", "getPrivateKeySigin error" + e2.getMessage());
        }
        if (this.f12029a != null) {
            return this.f12029a;
        }
        if (context == null) {
            u.d("RsaSecurity", " getPrivateKeySigin context == null ");
            return null;
        }
        KeyStore.Entry entryD = d(context);
        if (entryD instanceof KeyStore.PrivateKeyEntry) {
            this.f12029a = ((KeyStore.PrivateKeyEntry) entryD).getPrivateKey();
            return this.f12029a;
        }
        return null;
    }

    private KeyStore.Entry d(Context context) throws NoSuchAlgorithmException, KeyStoreException, NoSuchProviderException, InvalidAlgorithmParameterException, UnrecoverableEntryException {
        try {
            if (context == null) {
                u.d("RsaSecurity", " getPrivateKeySigin context == null ");
                return null;
            }
            if (!b("PushRsaKeyAlias")) {
                b(context);
            }
            return this.f12031c.getEntry("PushRsaKeyAlias", null);
        } catch (Exception e2) {
            b(context);
            KeyStore.Entry entry = this.f12031c.getEntry("PushRsaKeyAlias", null);
            e2.printStackTrace();
            u.a("RsaSecurity", "getPrivateKeySigin error" + e2.getMessage());
            return entry;
        }
    }

    @Override // com.vivo.push.e.a
    public final String a(String str) throws NoSuchAlgorithmException, SignatureException, InvalidKeyException, UnsupportedEncodingException {
        try {
            if (TextUtils.isEmpty(str) || c(this.f12033e) == null) {
                return null;
            }
            byte[] bytes = str.getBytes("UTF-8");
            PrivateKey privateKeyC = c(this.f12033e);
            Signature signature = Signature.getInstance("SHA256withRSA");
            signature.initSign(privateKeyC);
            signature.update(bytes);
            String strEncodeToString = Base64.encodeToString(signature.sign(), 2);
            u.d("RsaSecurity", str.hashCode() + " = " + strEncodeToString);
            return strEncodeToString;
        } catch (Exception e2) {
            e2.printStackTrace();
            u.a("RsaSecurity", "signClientSDK error" + e2.getMessage());
            return null;
        }
    }

    private boolean b(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            if (this.f12031c == null) {
                b();
            }
            return this.f12031c.containsAlias(str);
        } catch (Exception e2) {
            e2.printStackTrace();
            u.a("RsaSecurity", "getPrivateKeySigin error" + e2.getMessage());
            return false;
        }
    }

    @Override // com.vivo.push.e.a
    public final boolean a(byte[] bArr, PublicKey publicKey, byte[] bArr2) throws NoSuchAlgorithmException, SignatureException, InvalidKeyException {
        try {
            Signature signature = Signature.getInstance("SHA256withRSA");
            signature.initVerify(publicKey);
            signature.update(bArr);
            return signature.verify(bArr2);
        } catch (Exception e2) {
            e2.printStackTrace();
            u.a("RsaSecurity", "verifyClientSDK error" + e2.getMessage());
            return false;
        }
    }

    private void b() throws NoSuchAlgorithmException, IOException, CertificateException {
        try {
            this.f12031c = KeyStore.getInstance("AndroidKeyStore");
            this.f12031c.load(null);
            this.f12032d = new X500Principal("CN=Push SDK, OU=VIVO, O=VIVO PUSH, C=CN");
        } catch (Exception e2) {
            e2.printStackTrace();
            u.a("RsaSecurity", "initKeyStore error" + e2.getMessage());
        }
    }

    @Override // com.vivo.push.e.a
    public final PublicKey a() {
        try {
            if (this.f12030b != null) {
                return this.f12030b;
            }
            KeyStore.Entry entryD = d(this.f12033e);
            if (!(entryD instanceof KeyStore.PrivateKeyEntry)) {
                return null;
            }
            this.f12030b = ((KeyStore.PrivateKeyEntry) entryD).getCertificate().getPublicKey();
            return this.f12030b;
        } catch (Exception e2) {
            e2.printStackTrace();
            u.a("RsaSecurity", "getPublicKeySign error" + e2.getMessage());
            return null;
        }
    }
}
