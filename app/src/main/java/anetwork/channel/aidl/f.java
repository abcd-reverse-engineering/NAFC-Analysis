package anetwork.channel.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public interface f extends IInterface {
    int a(byte[] bArr, int i2, int i3) throws RemoteException;

    long a(int i2) throws RemoteException;

    int available() throws RemoteException;

    void close() throws RemoteException;

    int length() throws RemoteException;

    int read(byte[] bArr) throws RemoteException;

    int readByte() throws RemoteException;

    /* compiled from: Taobao */
    public static abstract class a extends Binder implements f {

        /* renamed from: a, reason: collision with root package name */
        private static final String f2125a = "anetwork.channel.aidl.ParcelableInputStream";

        /* renamed from: b, reason: collision with root package name */
        static final int f2126b = 1;

        /* renamed from: c, reason: collision with root package name */
        static final int f2127c = 2;

        /* renamed from: d, reason: collision with root package name */
        static final int f2128d = 3;

        /* renamed from: e, reason: collision with root package name */
        static final int f2129e = 4;

        /* renamed from: f, reason: collision with root package name */
        static final int f2130f = 5;

        /* renamed from: g, reason: collision with root package name */
        static final int f2131g = 6;

        /* renamed from: h, reason: collision with root package name */
        static final int f2132h = 7;

        public a() {
            attachInterface(this, f2125a);
        }

        public static f a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(f2125a);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof f)) ? new C0022a(iBinder) : (f) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
            byte[] bArr;
            if (i2 == 1598968902) {
                parcel2.writeString(f2125a);
                return true;
            }
            switch (i2) {
                case 1:
                    parcel.enforceInterface(f2125a);
                    int iAvailable = available();
                    parcel2.writeNoException();
                    parcel2.writeInt(iAvailable);
                    return true;
                case 2:
                    parcel.enforceInterface(f2125a);
                    close();
                    parcel2.writeNoException();
                    return true;
                case 3:
                    parcel.enforceInterface(f2125a);
                    int i4 = readByte();
                    parcel2.writeNoException();
                    parcel2.writeInt(i4);
                    return true;
                case 4:
                    parcel.enforceInterface(f2125a);
                    int i5 = parcel.readInt();
                    bArr = i5 >= 0 ? new byte[i5] : null;
                    int iA = a(bArr, parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(iA);
                    parcel2.writeByteArray(bArr);
                    return true;
                case 5:
                    parcel.enforceInterface(f2125a);
                    int i6 = parcel.readInt();
                    bArr = i6 >= 0 ? new byte[i6] : null;
                    int i7 = read(bArr);
                    parcel2.writeNoException();
                    parcel2.writeInt(i7);
                    parcel2.writeByteArray(bArr);
                    return true;
                case 6:
                    parcel.enforceInterface(f2125a);
                    long jA = a(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeLong(jA);
                    return true;
                case 7:
                    parcel.enforceInterface(f2125a);
                    int length = length();
                    parcel2.writeNoException();
                    parcel2.writeInt(length);
                    return true;
                default:
                    return super.onTransact(i2, parcel, parcel2, i3);
            }
        }

        /* compiled from: Taobao */
        /* renamed from: anetwork.channel.aidl.f$a$a, reason: collision with other inner class name */
        private static class C0022a implements f {

            /* renamed from: a, reason: collision with root package name */
            private IBinder f2133a;

            C0022a(IBinder iBinder) {
                this.f2133a = iBinder;
            }

            @Override // anetwork.channel.aidl.f
            public int a(byte[] bArr, int i2, int i3) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(a.f2125a);
                    if (bArr == null) {
                        parcelObtain.writeInt(-1);
                    } else {
                        parcelObtain.writeInt(bArr.length);
                    }
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeInt(i3);
                    this.f2133a.transact(4, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    int i4 = parcelObtain2.readInt();
                    parcelObtain2.readByteArray(bArr);
                    return i4;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f2133a;
            }

            @Override // anetwork.channel.aidl.f
            public int available() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(a.f2125a);
                    this.f2133a.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // anetwork.channel.aidl.f
            public void close() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(a.f2125a);
                    this.f2133a.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // anetwork.channel.aidl.f
            public int length() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(a.f2125a);
                    this.f2133a.transact(7, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // anetwork.channel.aidl.f
            public int read(byte[] bArr) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(a.f2125a);
                    if (bArr == null) {
                        parcelObtain.writeInt(-1);
                    } else {
                        parcelObtain.writeInt(bArr.length);
                    }
                    this.f2133a.transact(5, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    int i2 = parcelObtain2.readInt();
                    parcelObtain2.readByteArray(bArr);
                    return i2;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // anetwork.channel.aidl.f
            public int readByte() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(a.f2125a);
                    this.f2133a.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // anetwork.channel.aidl.f
            public long a(int i2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(a.f2125a);
                    parcelObtain.writeInt(i2);
                    this.f2133a.transact(6, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readLong();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }
    }
}
