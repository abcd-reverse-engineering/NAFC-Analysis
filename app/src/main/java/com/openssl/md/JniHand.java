package com.openssl.md;

/* loaded from: classes.dex */
public class JniHand {
    static {
        System.loadLibrary("crypto");
        System.loadLibrary("md");
    }

    public native String getAppPubKey();

    public native String paramJsonDecode(String str);

    public native String paramJsonEncode(String str);

    public native void setApiPubKey(String str);
}
