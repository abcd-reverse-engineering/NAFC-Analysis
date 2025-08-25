package anetwork.channel.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public interface e extends IInterface {

    /* compiled from: Taobao */
    public static abstract class a extends Binder implements e {

        /* renamed from: a, reason: collision with root package name */
        private static final String f2119a = "anetwork.channel.aidl.ParcelableFuture";

        /* renamed from: b, reason: collision with root package name */
        static final int f2120b = 1;

        /* renamed from: c, reason: collision with root package name */
        static final int f2121c = 2;

        /* renamed from: d, reason: collision with root package name */
        static final int f2122d = 3;

        /* renamed from: e, reason: collision with root package name */
        static final int f2123e = 4;

        /* compiled from: Taobao */
        /* renamed from: anetwork.channel.aidl.e$a$a, reason: collision with other inner class name */
        private static class C0021a implements e {

            /* renamed from: a, reason: collision with root package name */
            private IBinder f2124a;

            C0021a(IBinder iBinder) {
                this.f2124a = iBinder;
            }

            @Override // anetwork.channel.aidl.e
            public NetworkResponse a(long j2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(a.f2119a);
                    parcelObtain.writeLong(j2);
                    this.f2124a.transact(4, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? NetworkResponse.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f2124a;
            }

            @Override // anetwork.channel.aidl.e
            public boolean cancel(boolean z) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(a.f2119a);
                    parcelObtain.writeInt(z ? 1 : 0);
                    this.f2124a.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // anetwork.channel.aidl.e
            public boolean isCancelled() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(a.f2119a);
                    this.f2124a.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // anetwork.channel.aidl.e
            public boolean isDone() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(a.f2119a);
                    this.f2124a.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public a() {
            attachInterface(this, f2119a);
        }

        public static e a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(f2119a);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof e)) ? new C0021a(iBinder) : (e) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
            if (i2 == 1) {
                parcel.enforceInterface(f2119a);
                boolean zCancel = cancel(parcel.readInt() != 0);
                parcel2.writeNoException();
                parcel2.writeInt(zCancel ? 1 : 0);
                return true;
            }
            if (i2 == 2) {
                parcel.enforceInterface(f2119a);
                boolean zIsCancelled = isCancelled();
                parcel2.writeNoException();
                parcel2.writeInt(zIsCancelled ? 1 : 0);
                return true;
            }
            if (i2 == 3) {
                parcel.enforceInterface(f2119a);
                boolean zIsDone = isDone();
                parcel2.writeNoException();
                parcel2.writeInt(zIsDone ? 1 : 0);
                return true;
            }
            if (i2 != 4) {
                if (i2 != 1598968902) {
                    return super.onTransact(i2, parcel, parcel2, i3);
                }
                parcel2.writeString(f2119a);
                return true;
            }
            parcel.enforceInterface(f2119a);
            NetworkResponse networkResponseA = a(parcel.readLong());
            parcel2.writeNoException();
            if (networkResponseA != null) {
                parcel2.writeInt(1);
                networkResponseA.writeToParcel(parcel2, 1);
            } else {
                parcel2.writeInt(0);
            }
            return true;
        }
    }

    NetworkResponse a(long j2) throws RemoteException;

    boolean cancel(boolean z) throws RemoteException;

    boolean isCancelled() throws RemoteException;

    boolean isDone() throws RemoteException;
}
