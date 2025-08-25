package com.huawei.agconnect.config.impl;

import android.content.Context;
import com.huawei.agconnect.config.AesDecrypt;
import com.huawei.agconnect.config.IDecrypt;
import java.io.UnsupportedEncodingException;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class h implements AesDecrypt {

    /* renamed from: a, reason: collision with root package name */
    private final Context f6408a;

    /* renamed from: b, reason: collision with root package name */
    private final String f6409b;

    /* renamed from: c, reason: collision with root package name */
    private IDecrypt f6410c;

    public h(Context context, String str) {
        this.f6408a = context;
        this.f6409b = str;
    }

    @Override // com.huawei.agconnect.config.AesDecrypt
    public String decrypt(String str, String str2) {
        if (this.f6410c == null) {
            this.f6410c = decryptComponent();
        }
        if (this.f6410c == null) {
            this.f6410c = new g(this.f6408a, this.f6409b).decryptComponent();
        }
        return this.f6410c.decrypt(l.a(this.f6408a, this.f6409b, "agc_plugin_", str), str2);
    }

    @Override // com.huawei.agconnect.config.AesDecrypt
    public IDecrypt decryptComponent() throws JSONException {
        String strA = l.a(this.f6408a, this.f6409b, "agc_plugin_", "crypto_component");
        if (strA == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(new String(Hex.decodeHexString(strA), "utf-8"));
            return new f(new d(jSONObject.getString("rx"), jSONObject.getString("ry"), jSONObject.getString("rz"), jSONObject.getString("salt"), jSONObject.getString("algorithm"), jSONObject.getInt("iterationCount")));
        } catch (UnsupportedEncodingException | IllegalArgumentException | JSONException e2) {
            String str = "FlexibleDecrypt exception: " + e2.getMessage();
            return null;
        }
    }
}
