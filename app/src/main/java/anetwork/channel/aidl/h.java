package anetwork.channel.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import anetwork.channel.aidl.a;
import anetwork.channel.aidl.e;
import anetwork.channel.aidl.g;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public interface h extends IInterface {
    NetworkResponse a(ParcelableRequest parcelableRequest) throws RemoteException;

    e a(ParcelableRequest parcelableRequest, g gVar) throws RemoteException;

    anetwork.channel.aidl.a b(ParcelableRequest parcelableRequest) throws RemoteException;

    /* compiled from: Taobao */
    public static abstract class a extends Binder implements h {

        /* renamed from: a, reason: collision with root package name */
        private static final String f2141a = "anetwork.channel.aidl.RemoteNetwork";

        /* renamed from: b, reason: collision with root package name */
        static final int f2142b = 1;

        /* renamed from: c, reason: collision with root package name */
        static final int f2143c = 2;

        /* renamed from: d, reason: collision with root package name */
        static final int f2144d = 3;

        public a() {
            attachInterface(this, f2141a);
        }

        public static h a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(f2141a);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof h)) ? new C0024a(iBinder) : (h) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
            if (i2 == 1) {
                parcel.enforceInterface(f2141a);
                NetworkResponse networkResponseA = a(parcel.readInt() != 0 ? ParcelableRequest.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                if (networkResponseA != null) {
                    parcel2.writeInt(1);
                    networkResponseA.writeToParcel(parcel2, 1);
                } else {
                    parcel2.writeInt(0);
                }
                return true;
            }
            if (i2 == 2) {
                parcel.enforceInterface(f2141a);
                e eVarA = a(parcel.readInt() != 0 ? ParcelableRequest.CREATOR.createFromParcel(parcel) : null, g.a.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                parcel2.writeStrongBinder(eVarA != null ? eVarA.asBinder() : null);
                return true;
            }
            if (i2 != 3) {
                if (i2 != 1598968902) {
                    return super.onTransact(i2, parcel, parcel2, i3);
                }
                parcel2.writeString(f2141a);
                return true;
            }
            parcel.enforceInterface(f2141a);
            anetwork.channel.aidl.a aVarB = b(parcel.readInt() != 0 ? ParcelableRequest.CREATOR.createFromParcel(parcel) : null);
            parcel2.writeNoException();
            parcel2.writeStrongBinder(aVarB != null ? aVarB.asBinder() : null);
            return true;
        }

        /* compiled from: Taobao */
        /* renamed from: anetwork.channel.aidl.h$a$a, reason: collision with other inner class name */
        private static class C0024a implements h {

            /* renamed from: a, reason: collision with root package name */
            private IBinder f2145a;

            C0024a(IBinder iBinder) {
                this.f2145a = iBinder;
            }

            @Override // anetwork.channel.aidl.h
            public NetworkResponse a(ParcelableRequest parcelableRequest) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(a.f2141a);
                    if (parcelableRequest != null) {
                        parcelObtain.writeInt(1);
                        parcelableRequest.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    this.f2145a.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? NetworkResponse.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f2145a;
            }

            @Override // anetwork.channel.aidl.h
            public anetwork.channel.aidl.a b(ParcelableRequest parcelableRequest) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(a.f2141a);
                    if (parcelableRequest != null) {
                        parcelObtain.writeInt(1);
                        parcelableRequest.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    this.f2145a.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return a.AbstractBinderC0017a.a(parcelObtain2.readStrongBinder());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // anetwork.channel.aidl.h
            public e a(ParcelableRequest parcelableRequest, g gVar) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(a.f2141a);
                    if (parcelableRequest != null) {
                        parcelObtain.writeInt(1);
                        parcelableRequest.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(gVar != null ? gVar.asBinder() : null);
                    this.f2145a.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return e.a.a(parcelObtain2.readStrongBinder());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }
    }
}
