package com.hihonor.cloudservice.support.feature.request;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.app.NotificationCompat;
import com.hihonor.cloudservice.support.api.entity.auth.PermissionInfo;
import com.hihonor.cloudservice.support.api.entity.auth.Scope;
import com.huawei.hms.push.AttributionReporter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import k.a.a.c.a.c;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public abstract class AbstractSignInOptions implements c.a.InterfaceC0266a, Parcelable {

    /* renamed from: m, reason: collision with root package name */
    public static final PermissionInfo f6008m = new PermissionInfo().a("com.hihonor.account.getUID");
    public static final Scope n = new Scope("profile");
    public static final Scope o = new Scope(NotificationCompat.CATEGORY_EMAIL);
    public static final Scope p = new Scope("openid");

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList<Scope> f6009a;

    /* renamed from: b, reason: collision with root package name */
    public ArrayList<PermissionInfo> f6010b;

    /* renamed from: c, reason: collision with root package name */
    protected String f6011c;

    /* renamed from: d, reason: collision with root package name */
    protected String f6012d;

    /* renamed from: e, reason: collision with root package name */
    protected String f6013e;

    /* renamed from: f, reason: collision with root package name */
    protected boolean f6014f;

    /* renamed from: g, reason: collision with root package name */
    protected boolean f6015g;

    /* renamed from: h, reason: collision with root package name */
    protected boolean f6016h;

    /* renamed from: i, reason: collision with root package name */
    protected boolean f6017i;

    /* renamed from: j, reason: collision with root package name */
    protected boolean f6018j;

    /* renamed from: k, reason: collision with root package name */
    protected String f6019k;

    /* renamed from: l, reason: collision with root package name */
    protected String f6020l;

    public AbstractSignInOptions(ArrayList<Scope> arrayList, ArrayList<PermissionInfo> arrayList2, String str, String str2, String str3, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, String str4, String str5) {
        this.f6011c = "";
        this.f6012d = "";
        this.f6013e = "";
        this.f6009a = arrayList;
        this.f6010b = arrayList2;
        this.f6011c = str;
        this.f6012d = str2;
        this.f6013e = str3;
        this.f6014f = z;
        this.f6015g = z2;
        this.f6016h = z3;
        this.f6017i = z4;
        this.f6018j = z5;
        this.f6019k = str4;
        this.f6020l = str5;
    }

    public String a() {
        return this.f6020l;
    }

    public String b() {
        return this.f6011c;
    }

    public String c() {
        return this.f6012d;
    }

    public List<PermissionInfo> d() {
        return this.f6010b;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String e() {
        return this.f6013e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AbstractSignInOptions)) {
            return false;
        }
        AbstractSignInOptions abstractSignInOptions = (AbstractSignInOptions) obj;
        return a(this.f6009a, abstractSignInOptions.f6009a) && a(this.f6010b, abstractSignInOptions.f6010b);
    }

    public List<Scope> f() {
        return this.f6009a;
    }

    public Scope[] g() {
        ArrayList<Scope> arrayList = this.f6009a;
        if (arrayList == null) {
            return null;
        }
        return (Scope[]) arrayList.toArray();
    }

    public String h() {
        return this.f6019k;
    }

    public int hashCode() {
        ArrayList<Scope> arrayList = this.f6009a;
        int iHashCode = ((arrayList == null ? 0 : arrayList.hashCode()) + 31) * 31;
        ArrayList<PermissionInfo> arrayList2 = this.f6010b;
        return iHashCode + (arrayList2 != null ? arrayList2.hashCode() : 0);
    }

    public boolean i() {
        return this.f6014f;
    }

    public boolean j() {
        return this.f6015g;
    }

    public boolean k() {
        return this.f6016h;
    }

    public boolean l() {
        return this.f6018j;
    }

    public boolean m() {
        return this.f6017i;
    }

    public String n() {
        return o().toString();
    }

    public JSONObject o() throws JSONException {
        new JSONObject();
        JSONObject jSONObject = new JSONObject();
        if (this.f6009a != null) {
            JSONArray jSONArray = new JSONArray();
            Iterator<Scope> it = this.f6009a.iterator();
            while (it.hasNext()) {
                jSONArray.put(a(it.next()));
            }
            jSONObject.put("scopeArrayList", jSONArray);
        }
        if (this.f6010b != null) {
            JSONArray jSONArray2 = new JSONArray();
            Iterator<PermissionInfo> it2 = this.f6010b.iterator();
            while (it2.hasNext()) {
                jSONArray2.put(a(it2.next()));
            }
            jSONObject.put("permissionArrayList", jSONArray2);
        }
        return jSONObject;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeList(this.f6009a);
        parcel.writeList(this.f6010b);
    }

    public static Scope b(JSONObject jSONObject) {
        return new Scope(jSONObject.optString("mScopeUri", null));
    }

    public <T> boolean a(ArrayList<T> arrayList, ArrayList<T> arrayList2) {
        if (arrayList == arrayList2) {
            return true;
        }
        if (arrayList.size() != arrayList2.size()) {
            return false;
        }
        return arrayList.containsAll(arrayList2);
    }

    public static PermissionInfo a(JSONObject jSONObject) {
        return new PermissionInfo().a(jSONObject.optString(AttributionReporter.SYSTEM_PERMISSION, null));
    }

    public JSONObject a(PermissionInfo permissionInfo) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (permissionInfo.a() != null) {
            jSONObject.put(AttributionReporter.SYSTEM_PERMISSION, permissionInfo.a());
        }
        return jSONObject;
    }

    public JSONObject a(Scope scope) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (scope.a() != null) {
            jSONObject.put("mScopeUri", scope.a());
        }
        return jSONObject;
    }

    public AbstractSignInOptions(Parcel parcel) {
        this.f6011c = "";
        this.f6012d = "";
        this.f6013e = "";
        this.f6009a = parcel.createTypedArrayList(Scope.CREATOR);
        this.f6010b = parcel.createTypedArrayList(PermissionInfo.CREATOR);
    }
}
