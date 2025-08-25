package com.hihonor.cloudservice.support.feature.result;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.heytap.mcssdk.constant.b;
import com.hihonor.cloudservice.support.api.entity.auth.Scope;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public abstract class AbstractSignInAccountInfo implements Parcelable {

    /* renamed from: a, reason: collision with root package name */
    public String f6033a;

    /* renamed from: b, reason: collision with root package name */
    public String f6034b;

    /* renamed from: c, reason: collision with root package name */
    public Set<Scope> f6035c;

    /* renamed from: d, reason: collision with root package name */
    public String f6036d;

    /* renamed from: e, reason: collision with root package name */
    public String f6037e;

    /* renamed from: f, reason: collision with root package name */
    public String f6038f;

    /* renamed from: g, reason: collision with root package name */
    public Set<Scope> f6039g;

    /* renamed from: h, reason: collision with root package name */
    public String f6040h;

    /* renamed from: i, reason: collision with root package name */
    public long f6041i;

    /* renamed from: j, reason: collision with root package name */
    public String f6042j;

    public AbstractSignInAccountInfo(String str, String str2, Set<Scope> set, String str3, String str4, String str5) {
        this.f6039g = new HashSet();
        this.f6033a = str;
        this.f6034b = str2;
        this.f6035c = set;
        this.f6036d = str3;
        this.f6037e = str4;
        this.f6040h = str5;
    }

    public String a() {
        return this.f6042j;
    }

    public String b() {
        return this.f6036d;
    }

    public Set<Scope> c() {
        return this.f6035c;
    }

    public Uri d() {
        if (TextUtils.isEmpty(this.f6034b)) {
            this.f6034b = "";
        }
        return Uri.parse(this.f6034b);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String e() {
        return this.f6034b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AbstractSignInAccountInfo) {
            return c().equals(((AbstractSignInAccountInfo) obj).c());
        }
        return false;
    }

    public String f() {
        return this.f6038f;
    }

    public long g() {
        return this.f6041i;
    }

    public Set<Scope> h() {
        return this.f6039g;
    }

    public int hashCode() {
        return k().hashCode();
    }

    public String i() {
        return this.f6040h;
    }

    public String j() {
        return this.f6033a;
    }

    public Set<Scope> k() {
        return new HashSet(this.f6039g);
    }

    public String l() {
        return this.f6037e;
    }

    public boolean m() {
        return this.f6041i > 300 && System.currentTimeMillis() / 1000 >= this.f6041i - 300;
    }

    public String n() {
        return o().toString();
    }

    public JSONObject o() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (j() != null) {
            jSONObject.put("openId", j());
        }
        if (e() != null) {
            jSONObject.put("photoUriString", e());
        }
        if (l() != null) {
            jSONObject.put("unionId", l());
        }
        if (f() != null) {
            jSONObject.put(NotificationCompat.CATEGORY_EMAIL, f());
        }
        if (b() != null) {
            jSONObject.put("serverAuthCode", b());
        }
        if (i() != null) {
            jSONObject.put("idToken", i());
        }
        if (a() != null) {
            jSONObject.put(b.u, a());
        }
        jSONObject.put("expirationTimeSecs", g());
        return a(b(jSONObject));
    }

    public String toString() {
        return "{displayName: photoUriString: " + this.f6034b + ",serviceCountryCode: countryCode: ";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f6033a);
        parcel.writeString(this.f6034b);
        parcel.writeString(this.f6036d);
        parcel.writeList(new ArrayList(this.f6035c));
        parcel.writeString(this.f6037e);
        parcel.writeString(this.f6038f);
        parcel.writeString(this.f6040h);
        parcel.writeLong(this.f6041i);
        parcel.writeString(this.f6042j);
    }

    public JSONObject a(JSONObject jSONObject) throws JSONException {
        if (h() != null) {
            JSONArray jSONArray = new JSONArray();
            for (Scope scope : h()) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.putOpt("mScopeUri", scope.a());
                jSONArray.put(jSONObject2);
            }
            jSONObject.putOpt("extensionScopes", jSONArray);
        }
        return jSONObject;
    }

    public JSONObject b(JSONObject jSONObject) throws JSONException {
        if (c() != null) {
            JSONArray jSONArray = new JSONArray();
            for (Scope scope : c()) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.putOpt("mScopeUri", scope.a());
                jSONArray.put(jSONObject2);
            }
            jSONObject.put("grantedScopes", jSONArray);
        }
        return jSONObject;
    }

    public void c(JSONObject jSONObject) throws JSONException {
        this.f6033a = jSONObject.optString("openId", null);
        this.f6034b = jSONObject.optString("photoUriString", null);
        this.f6036d = jSONObject.optString("serverAuthCode", null);
        JSONArray jSONArray = jSONObject.getJSONArray("grantedScopes");
        if (jSONArray != null) {
            HashSet hashSet = new HashSet();
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                String strOptString = jSONArray.getJSONObject(i2).optString("mScopeUri", null);
                if (strOptString != null) {
                    hashSet.add(new Scope(strOptString));
                }
            }
            this.f6035c = hashSet;
        }
        this.f6037e = jSONObject.optString("unionId", null);
        this.f6038f = jSONObject.optString(NotificationCompat.CATEGORY_EMAIL, null);
        this.f6040h = jSONObject.optString("idToken", null);
        this.f6041i = Long.parseLong(jSONObject.getString("expirationTimeSecs"));
        this.f6042j = jSONObject.optString(b.u, null);
    }

    public void d(String str) {
        this.f6040h = str;
    }

    public AbstractSignInAccountInfo(Parcel parcel) {
        this.f6039g = new HashSet();
        this.f6039g = new HashSet();
        a(parcel);
    }

    public void b(String str) {
        this.f6034b = str;
    }

    public void a(Parcel parcel) {
        this.f6033a = parcel.readString();
        this.f6034b = parcel.readString();
        this.f6036d = parcel.readString();
        this.f6035c = new HashSet();
        this.f6037e = parcel.readString();
        this.f6038f = parcel.readString();
        this.f6040h = parcel.readString();
        this.f6041i = parcel.readLong();
        this.f6042j = parcel.readString();
    }

    public AbstractSignInAccountInfo() {
        this.f6039g = new HashSet();
    }

    public void c(String str) {
        this.f6038f = str;
    }

    public AbstractSignInAccountInfo a(List<Scope> list) {
        if (k.a.a.a.b.b(list)) {
            this.f6039g.addAll(list);
        }
        return this;
    }

    public void a(String str) {
        this.f6042j = str;
    }

    public void a(long j2) {
        this.f6041i = j2;
    }

    public void a(Set<Scope> set) {
        this.f6039g = set;
    }
}
