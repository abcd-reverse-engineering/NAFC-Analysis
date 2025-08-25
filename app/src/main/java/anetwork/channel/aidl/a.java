package anetwork.channel.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import anetwork.channel.aidl.f;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public interface a extends IInterface {

    /* compiled from: Taobao */
    /* renamed from: anetwork.channel.aidl.a$a, reason: collision with other inner class name */
    public static abstract class AbstractBinderC0017a extends Binder implements a {

        /* renamed from: a, reason: collision with root package name */
        private static final String f2103a = "anetwork.channel.aidl.Connection";

        /* renamed from: b, reason: collision with root package name */
        static final int f2104b = 1;

        /* renamed from: c, reason: collision with root package name */
        static final int f2105c = 2;

        /* renamed from: d, reason: collision with root package name */
        static final int f2106d = 3;

        /* renamed from: e, reason: collision with root package name */
        static final int f2107e = 4;

        /* renamed from: f, reason: collision with root package name */
        static final int f2108f = 5;

        /* renamed from: g, reason: collision with root package name */
        static final int f2109g = 6;

        /* compiled from: Taobao */
        /* renamed from: anetwork.channel.aidl.a$a$a, reason: collision with other inner class name */
        private static class C0018a implements a {

            /* renamed from: a, reason: collision with root package name */
            private IBinder f2110a;

            C0018a(IBinder iBinder) {
                this.f2110a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f2110a;
            }

            @Override // anetwork.channel.aidl.a
            public void cancel() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(AbstractBinderC0017a.f2103a);
                    this.f2110a.transact(6, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // anetwork.channel.aidl.a
            public String d() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(AbstractBinderC0017a.f2103a);
                    this.f2110a.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // anetwork.channel.aidl.a
            public a.a.s.a e() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(AbstractBinderC0017a.f2103a);
                    this.f2110a.transact(5, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() == 1 ? (a.a.s.a) parcelObtain2.readSerializable() : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // anetwork.channel.aidl.a
            public Map f() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(AbstractBinderC0017a.f2103a);
                    this.f2110a.transact(4, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readHashMap(getClass().getClassLoader());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // anetwork.channel.aidl.a
            public int getStatusCode() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(AbstractBinderC0017a.f2103a);
                    this.f2110a.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // anetwork.channel.aidl.a
            public f k() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(AbstractBinderC0017a.f2103a);
                    this.f2110a.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return f.a.a(parcelObtain2.readStrongBinder());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public AbstractBinderC0017a() {
            attachInterface(this, f2103a);
        }

        public static a a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(f2103a);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof a)) ? new C0018a(iBinder) : (a) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
            if (i2 == 1598968902) {
                parcel2.writeString(f2103a);
                return true;
            }
            switch (i2) {
                case 1:
                    parcel.enforceInterface(f2103a);
                    f fVarK = k();
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(fVarK != null ? fVarK.asBinder() : null);
                    return true;
                case 2:
                    parcel.enforceInterface(f2103a);
                    int statusCode = getStatusCode();
                    parcel2.writeNoException();
                    parcel2.writeInt(statusCode);
                    return true;
                case 3:
                    parcel.enforceInterface(f2103a);
                    String strD = d();
                    parcel2.writeNoException();
                    parcel2.writeString(strD);
                    return true;
                case 4:
                    parcel.enforceInterface(f2103a);
                    Map mapF = f();
                    parcel2.writeNoException();
                    parcel2.writeMap(mapF);
                    return true;
                case 5:
                    parcel.enforceInterface(f2103a);
                    a.a.s.a aVarE = e();
                    parcel2.writeNoException();
                    if (aVarE != null) {
                        parcel2.writeInt(1);
                        parcel2.writeSerializable(aVarE);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 6:
                    parcel.enforceInterface(f2103a);
                    cancel();
                    parcel2.writeNoException();
                    return true;
                default:
                    return super.onTransact(i2, parcel, parcel2, i3);
            }
        }
    }

    void cancel() throws RemoteException;

    String d() throws RemoteException;

    a.a.s.a e() throws RemoteException;

    Map f() throws RemoteException;

    int getStatusCode() throws RemoteException;

    f k() throws RemoteException;
}
