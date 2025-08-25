package com.hihonor.cloudservice.support.account.request;

import android.os.Parcel;
import android.os.Parcelable;
import com.hihonor.cloudservice.support.api.entity.auth.PermissionInfo;
import com.hihonor.cloudservice.support.api.entity.auth.Scope;
import com.hihonor.cloudservice.support.feature.request.AbstractSignInOptions;
import java.util.ArrayList;
import java.util.Set;

/* loaded from: classes.dex */
public class SignInOptions extends AbstractSignInOptions {
    public static final SignInOptions q = new com.hihonor.cloudservice.support.account.request.a().c().d().a();
    public static final Parcelable.Creator<SignInOptions> CREATOR = new a();

    class a implements Parcelable.Creator<SignInOptions> {
        a() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SignInOptions createFromParcel(Parcel parcel) {
            return null;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SignInOptions[] newArray(int i2) {
            return new SignInOptions[i2];
        }
    }

    public SignInOptions(Set<Scope> set, Set<PermissionInfo> set2, String str, String str2, String str3, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, String str4, String str5) {
        this((ArrayList<Scope>) new ArrayList(set), (ArrayList<PermissionInfo>) new ArrayList(set2), str, str2, str3, z, z2, z3, z4, z5, str4, str5);
    }

    @Override // com.hihonor.cloudservice.support.feature.request.AbstractSignInOptions
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SignInOptions)) {
            return false;
        }
        SignInOptions signInOptions = (SignInOptions) obj;
        return a(this.f6009a, signInOptions.f6009a) && a(this.f6010b, signInOptions.f6010b);
    }

    @Override // com.hihonor.cloudservice.support.feature.request.AbstractSignInOptions
    public int hashCode() {
        ArrayList<Scope> arrayList = this.f6009a;
        int iHashCode = ((arrayList == null ? 0 : arrayList.hashCode()) + 31) * 31;
        ArrayList<PermissionInfo> arrayList2 = this.f6010b;
        return iHashCode + (arrayList2 != null ? arrayList2.hashCode() : 0);
    }

    public SignInOptions(ArrayList<Scope> arrayList, ArrayList<PermissionInfo> arrayList2, String str, String str2, String str3, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, String str4, String str5) {
        super(arrayList, arrayList2, str, str2, str3, z, z2, z3, z4, z5, str4, str5);
    }
}
