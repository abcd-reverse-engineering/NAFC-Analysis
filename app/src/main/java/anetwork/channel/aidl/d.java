package anetwork.channel.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public interface d extends IInterface {

    /* compiled from: Taobao */
    public static abstract class a extends Binder implements d {

        /* renamed from: a, reason: collision with root package name */
        private static final String f2115a = "anetwork.channel.aidl.ParcelableBodyHandler";

        /* renamed from: b, reason: collision with root package name */
        static final int f2116b = 1;

        /* renamed from: c, reason: collision with root package name */
        static final int f2117c = 2;

        /* compiled from: Taobao */
        /* renamed from: anetwork.channel.aidl.d$a$a, reason: collision with other inner class name */
        private static class C0020a implements d {

            /* renamed from: a, reason: collision with root package name */
            private IBinder f2118a;

            C0020a(IBinder iBinder) {
                this.f2118a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f2118a;
            }

            @Override // anetwork.channel.aidl.d
            public boolean g() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(a.f2115a);
                    this.f2118a.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // anetwork.channel.aidl.d
            public int read(byte[] bArr) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(a.f2115a);
                    parcelObtain.writeByteArray(bArr);
                    this.f2118a.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    int i2 = parcelObtain2.readInt();
                    parcelObtain2.readByteArray(bArr);
                    return i2;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public a() {
            attachInterface(this, f2115a);
        }

        public static d a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(f2115a);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof d)) ? new C0020a(iBinder) : (d) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
            if (i2 == 1) {
                parcel.enforceInterface(f2115a);
                byte[] bArrCreateByteArray = parcel.createByteArray();
                int i4 = read(bArrCreateByteArray);
                parcel2.writeNoException();
                parcel2.writeInt(i4);
                parcel2.writeByteArray(bArrCreateByteArray);
                return true;
            }
            if (i2 != 2) {
                if (i2 != 1598968902) {
                    return super.onTransact(i2, parcel, parcel2, i3);
                }
                parcel2.writeString(f2115a);
                return true;
            }
            parcel.enforceInterface(f2115a);
            boolean zG = g();
            parcel2.writeNoException();
            parcel2.writeInt(zG ? 1 : 0);
            return true;
        }
    }

    boolean g() throws RemoteException;

    int read(byte[] bArr) throws RemoteException;
}
