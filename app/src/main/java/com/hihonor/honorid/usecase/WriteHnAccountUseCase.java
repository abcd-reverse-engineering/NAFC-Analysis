package com.hihonor.honorid.usecase;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import cn.cloudwalk.util.LogUtils;
import com.hihonor.honorid.UseCase;
import com.hihonor.honorid.core.data.HonorAccount;
import com.hihonor.honorid.g.c.b;
import java.util.ArrayList;
import k.a.a.a.c;
import k.a.a.a.j.e;

/* loaded from: classes.dex */
public class WriteHnAccountUseCase extends UseCase<RequestValues> {

    /* renamed from: b, reason: collision with root package name */
    private Context f6235b;

    /* renamed from: c, reason: collision with root package name */
    private ArrayList<HonorAccount> f6236c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f6237d;

    public WriteHnAccountUseCase(Context context, ArrayList<HonorAccount> arrayList, boolean z) {
        this.f6235b = context;
        this.f6236c = arrayList;
        this.f6237d = z;
    }

    public static final class RequestValues extends UseCase.RequestValues {
        public static final Parcelable.Creator<RequestValues> CREATOR = new a();

        /* renamed from: a, reason: collision with root package name */
        private String f6238a;

        class a implements Parcelable.Creator<RequestValues> {
            a() {
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public RequestValues createFromParcel(Parcel parcel) {
                return new RequestValues(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public RequestValues[] newArray(int i2) {
                return new RequestValues[i2];
            }
        }

        public RequestValues(String str) {
            this.f6238a = str;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeString(this.f6238a);
        }

        protected RequestValues(Parcel parcel) {
            this.f6238a = parcel.readString();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.hihonor.honorid.UseCase
    public void a(RequestValues requestValues) {
        e.b("WriteHnAccountUseCase", "writeHnAccount", true);
        c.a(this.f6235b, "accounts.xml");
        try {
            b.a(this.f6235b, "accounts.xml", this.f6236c, this.f6237d);
        } catch (Exception unused) {
            e.d("WriteHnAccountUseCase", LogUtils.LOG_EXCEPTION, true);
        }
    }
}
