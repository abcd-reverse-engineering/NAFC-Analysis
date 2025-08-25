package anetwork.channel.aidl;

import a.a.e;
import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class DefaultProgressEvent implements Parcelable, e.b {
    public static final Parcelable.Creator<DefaultProgressEvent> CREATOR = new k();

    /* renamed from: a, reason: collision with root package name */
    int f2072a;

    /* renamed from: b, reason: collision with root package name */
    int f2073b;

    /* renamed from: c, reason: collision with root package name */
    int f2074c;

    /* renamed from: d, reason: collision with root package name */
    Object f2075d;

    /* renamed from: e, reason: collision with root package name */
    byte[] f2076e;

    public DefaultProgressEvent() {
    }

    @Override // a.a.e.b
    public int a() {
        return this.f2073b;
    }

    public Object b() {
        return this.f2075d;
    }

    @Override // a.a.e.b
    public String d() {
        return "";
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // a.a.e.b
    public int m() {
        return this.f2072a;
    }

    @Override // a.a.e.b
    public byte[] n() {
        return this.f2076e;
    }

    @Override // a.a.e.b
    public int o() {
        return this.f2074c;
    }

    public String toString() {
        return "DefaultProgressEvent [index=" + this.f2072a + ", size=" + this.f2073b + ", total=" + this.f2074c + "]";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f2072a);
        parcel.writeInt(this.f2073b);
        parcel.writeInt(this.f2074c);
        byte[] bArr = this.f2076e;
        parcel.writeInt(bArr != null ? bArr.length : 0);
        parcel.writeByteArray(this.f2076e);
    }

    public DefaultProgressEvent(int i2, int i3, int i4, byte[] bArr) {
        this.f2072a = i2;
        this.f2073b = i3;
        this.f2074c = i4;
        this.f2076e = bArr;
    }

    public void a(Object obj) {
        this.f2075d = obj;
    }

    public static DefaultProgressEvent a(Parcel parcel) {
        DefaultProgressEvent defaultProgressEvent = new DefaultProgressEvent();
        try {
            defaultProgressEvent.f2072a = parcel.readInt();
            defaultProgressEvent.f2073b = parcel.readInt();
            defaultProgressEvent.f2074c = parcel.readInt();
            int i2 = parcel.readInt();
            if (i2 > 0) {
                byte[] bArr = new byte[i2];
                parcel.readByteArray(bArr);
                defaultProgressEvent.f2076e = bArr;
            }
        } catch (Exception unused) {
        }
        return defaultProgressEvent;
    }
}
