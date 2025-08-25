package com.huawei.agconnect.config.impl;

import com.huawei.agconnect.config.ConfigReader;
import com.umeng.socialize.common.SocializeConstants;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class i implements ConfigReader {

    /* renamed from: a, reason: collision with root package name */
    private final JSONObject f6411a;

    i(InputStream inputStream, String str) throws JSONException {
        this.f6411a = a(inputStream);
        a(str);
    }

    private JSONObject a(InputStream inputStream) {
        if (inputStream != null) {
            try {
                return new JSONObject(Utils.toString(inputStream, "UTF-8"));
            } catch (IOException | JSONException unused) {
            }
        }
        return new JSONObject();
    }

    private void a(String str) throws JSONException {
        try {
            JSONObject jSONObjectB = b(str);
            if (jSONObjectB == null) {
                return;
            }
            String string = getString("/configuration_version", "");
            BigDecimal bigDecimal = new BigDecimal("0.0");
            try {
                bigDecimal = BigDecimal.valueOf(Double.parseDouble(string));
            } catch (NumberFormatException unused) {
            }
            if (bigDecimal.compareTo(new BigDecimal("2.0")) == 0) {
                this.f6411a.getJSONObject("client").put("app_id", jSONObjectB.getString("app_id"));
                return;
            }
            if (bigDecimal.compareTo(new BigDecimal(SocializeConstants.PROTOCOL_VERSON)) >= 0) {
                Iterator<String> itKeys = jSONObjectB.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    if (!"package_name".equals(next)) {
                        a(next, jSONObjectB.get(next), this.f6411a);
                    }
                }
            }
        } catch (JSONException unused2) {
        }
    }

    private void a(String str, Object obj, JSONObject jSONObject) throws JSONException {
        if (str == null || obj == null || jSONObject == null) {
            return;
        }
        if (!(obj instanceof JSONObject)) {
            jSONObject.put(str, obj);
            return;
        }
        JSONObject jSONObject2 = (JSONObject) obj;
        Iterator<String> itKeys = jSONObject2.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            a(next, jSONObject2.get(next), jSONObject.getJSONObject(str));
        }
    }

    private JSONObject b(String str) throws JSONException {
        JSONArray jSONArray = this.f6411a.getJSONArray("appInfos");
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i2);
            if (jSONObject.getString("package_name").equals(str)) {
                return jSONObject;
            }
        }
        return null;
    }

    @Override // com.huawei.agconnect.config.ConfigReader
    public String getString(String str, String str2) throws JSONException {
        if (str.endsWith("/")) {
            return str2;
        }
        String[] strArrSplit = str.split("/");
        try {
            JSONObject jSONObject = this.f6411a;
            for (int i2 = 1; i2 < strArrSplit.length; i2++) {
                if (i2 == strArrSplit.length - 1) {
                    str = jSONObject.get(strArrSplit[i2]).toString();
                    return str;
                }
                jSONObject = jSONObject.getJSONObject(strArrSplit[i2]);
            }
        } catch (JSONException unused) {
            String str3 = "JSONException when reading 'path': " + str;
        }
        return str2;
    }

    public String toString() {
        return "InputStreamReader{config=" + this.f6411a.toString().hashCode() + '}';
    }
}
