package com.hihonor.cloudservice.support.account.result;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.hihonor.cloudservice.support.api.entity.auth.Scope;
import com.hihonor.cloudservice.support.feature.result.AbstractSignInAccountInfo;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import k.a.a.a.b;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class SignInAccountInfo extends AbstractSignInAccountInfo {
    public static final Parcelable.Creator<SignInAccountInfo> CREATOR = new a();

    /* renamed from: k, reason: collision with root package name */
    public int f5989k;

    class a implements Parcelable.Creator<SignInAccountInfo> {
        a() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SignInAccountInfo createFromParcel(Parcel parcel) {
            return new SignInAccountInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SignInAccountInfo[] newArray(int i2) {
            return new SignInAccountInfo[i2];
        }
    }

    public SignInAccountInfo(String str, String str2, Set<Scope> set, String str3, String str4, String str5) {
        super(str, str2, set, str3, str4, str5);
    }

    public static SignInAccountInfo a(String str, String str2, Set<Scope> set, String str3, String str4, String str5) {
        return new SignInAccountInfo(str, str2, set, str3, str4, str5);
    }

    public static SignInAccountInfo d(JSONObject jSONObject) throws JSONException {
        SignInAccountInfo signInAccountInfo = new SignInAccountInfo();
        signInAccountInfo.c(jSONObject);
        return signInAccountInfo;
    }

    public static SignInAccountInfo e(String str) throws JSONException {
        if (TextUtils.isEmpty(str)) {
            throw new JSONException("invalid json format");
        }
        return d(new JSONObject(str));
    }

    public static SignInAccountInfo r() {
        return a(null, null, new HashSet(), null, null, null);
    }

    @Override // com.hihonor.cloudservice.support.feature.result.AbstractSignInAccountInfo
    public void c(JSONObject jSONObject) throws JSONException {
        super.c(jSONObject);
        this.f5989k = jSONObject.optInt("accountFlag", 0);
    }

    @Override // com.hihonor.cloudservice.support.feature.result.AbstractSignInAccountInfo
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof SignInAccountInfo) {
            return c().equals(((SignInAccountInfo) obj).c());
        }
        return false;
    }

    @Override // com.hihonor.cloudservice.support.feature.result.AbstractSignInAccountInfo
    public int hashCode() {
        return k().hashCode();
    }

    @Override // com.hihonor.cloudservice.support.feature.result.AbstractSignInAccountInfo
    public JSONObject o() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (j() != null) {
            jSONObject.put("openId", j());
        }
        if (e() != null) {
            jSONObject.put("photoUriString", e());
        }
        if (b() != null) {
            jSONObject.put("serverAuthCode", b());
        }
        if (l() != null) {
            jSONObject.put("unionId", l());
        }
        if (f() != null) {
            jSONObject.put(NotificationCompat.CATEGORY_EMAIL, f());
        }
        if (i() != null) {
            jSONObject.put("idToken", i());
        }
        jSONObject.put("expirationTimeSecs", g());
        jSONObject.put("accountFlag", q());
        return a(b(jSONObject));
    }

    public Account p() {
        if (TextUtils.isEmpty(this.f6038f)) {
            return null;
        }
        return new Account(this.f6038f, "com.hihonor");
    }

    public int q() {
        return this.f5989k;
    }

    @Override // com.hihonor.cloudservice.support.feature.result.AbstractSignInAccountInfo
    public String toString() {
        return "{photoUriString: " + this.f6034b + ",accountFlag" + this.f5989k + '}';
    }

    @Override // com.hihonor.cloudservice.support.feature.result.AbstractSignInAccountInfo, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        super.writeToParcel(parcel, i2);
        parcel.writeInt(this.f5989k);
    }

    public SignInAccountInfo(Parcel parcel) {
        a(parcel);
    }

    @Override // com.hihonor.cloudservice.support.feature.result.AbstractSignInAccountInfo
    public void a(Parcel parcel) {
        super.a(parcel);
        this.f5989k = parcel.readInt();
    }

    public SignInAccountInfo() {
        this.f6035c = new HashSet();
        this.f5989k = 0;
    }

    @Override // com.hihonor.cloudservice.support.feature.result.AbstractSignInAccountInfo
    public /* bridge */ /* synthetic */ AbstractSignInAccountInfo a(List list) {
        return a((List<Scope>) list);
    }

    @Override // com.hihonor.cloudservice.support.feature.result.AbstractSignInAccountInfo
    public SignInAccountInfo a(List<Scope> list) {
        if (b.b(list)) {
            this.f6039g.addAll(list);
        }
        return this;
    }
}
