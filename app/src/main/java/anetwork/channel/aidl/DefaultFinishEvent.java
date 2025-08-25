package anetwork.channel.aidl;

import a.a.e;
import android.os.Parcel;
import android.os.Parcelable;
import anet.channel.request.Request;
import anet.channel.statist.RequestStatistic;
import anet.channel.util.ErrorConstant;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class DefaultFinishEvent implements Parcelable, e.a {
    public static final Parcelable.Creator<DefaultFinishEvent> CREATOR = new i();

    /* renamed from: a, reason: collision with root package name */
    Object f2066a;

    /* renamed from: b, reason: collision with root package name */
    int f2067b;

    /* renamed from: c, reason: collision with root package name */
    String f2068c;

    /* renamed from: d, reason: collision with root package name */
    a.a.s.a f2069d;

    /* renamed from: e, reason: collision with root package name */
    public final RequestStatistic f2070e;

    /* renamed from: f, reason: collision with root package name */
    public final Request f2071f;

    public DefaultFinishEvent(int i2) {
        this(i2, null, null, null);
    }

    public Object a() {
        return this.f2066a;
    }

    @Override // a.a.e.a
    public String d() {
        return this.f2068c;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // a.a.e.a
    public a.a.s.a e() {
        return this.f2069d;
    }

    @Override // a.a.e.a
    public int f() {
        return this.f2067b;
    }

    public String toString() {
        return "DefaultFinishEvent [code=" + this.f2067b + ", desc=" + this.f2068c + ", context=" + this.f2066a + ", statisticData=" + this.f2069d + "]";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f2067b);
        parcel.writeString(this.f2068c);
        a.a.s.a aVar = this.f2069d;
        if (aVar != null) {
            parcel.writeSerializable(aVar);
        }
    }

    public DefaultFinishEvent(int i2, String str, RequestStatistic requestStatistic) {
        this(i2, str, null, requestStatistic);
    }

    public void a(Object obj) {
        this.f2066a = obj;
    }

    public DefaultFinishEvent(int i2, String str, Request request) {
        this(i2, str, request, request != null ? request.f1841a : null);
    }

    static DefaultFinishEvent a(Parcel parcel) {
        DefaultFinishEvent defaultFinishEvent = new DefaultFinishEvent(0);
        try {
            defaultFinishEvent.f2067b = parcel.readInt();
            defaultFinishEvent.f2068c = parcel.readString();
            defaultFinishEvent.f2069d = (a.a.s.a) parcel.readSerializable();
        } catch (Throwable unused) {
        }
        return defaultFinishEvent;
    }

    private DefaultFinishEvent(int i2, String str, Request request, RequestStatistic requestStatistic) {
        this.f2069d = new a.a.s.a();
        this.f2067b = i2;
        this.f2068c = str == null ? ErrorConstant.getErrMsg(i2) : str;
        this.f2071f = request;
        this.f2070e = requestStatistic;
    }
}
