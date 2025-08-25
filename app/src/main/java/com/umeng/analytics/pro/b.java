package com.umeng.analytics.pro;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: IDeviceIdService.java */
/* loaded from: classes2.dex */
public interface b extends IInterface {

    /* compiled from: IDeviceIdService.java */
    public static class a implements b {
        @Override // com.umeng.analytics.pro.b
        public String a() throws RemoteException {
            return null;
        }

        @Override // com.umeng.analytics.pro.b
        public String a(String str) throws RemoteException {
            return null;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.umeng.analytics.pro.b
        public String b(String str) throws RemoteException {
            return null;
        }
    }

    String a() throws RemoteException;

    String a(String str) throws RemoteException;

    String b(String str) throws RemoteException;

    /* compiled from: IDeviceIdService.java */
    /* renamed from: com.umeng.analytics.pro.b$b, reason: collision with other inner class name */
    public static abstract class AbstractBinderC0136b extends Binder implements b {

        /* renamed from: a, reason: collision with root package name */
        static final int f10104a = 1;

        /* renamed from: b, reason: collision with root package name */
        static final int f10105b = 2;

        /* renamed from: c, reason: collision with root package name */
        static final int f10106c = 3;

        /* renamed from: d, reason: collision with root package name */
        private static final String f10107d = "com.samsung.android.deviceidservice.IDeviceIdService";

        public AbstractBinderC0136b() {
            attachInterface(this, f10107d);
        }

        public static b a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(f10107d);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof b)) ? new a(iBinder) : (b) iInterfaceQueryLocalInterface;
        }

        public static b b() {
            return a.f10108a;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
            if (i2 == 1) {
                parcel.enforceInterface(f10107d);
                String strA = a();
                parcel2.writeNoException();
                parcel2.writeString(strA);
                return true;
            }
            if (i2 == 2) {
                parcel.enforceInterface(f10107d);
                String strA2 = a(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeString(strA2);
                return true;
            }
            if (i2 != 3) {
                if (i2 != 1598968902) {
                    return super.onTransact(i2, parcel, parcel2, i3);
                }
                parcel2.writeString(f10107d);
                return true;
            }
            parcel.enforceInterface(f10107d);
            String strB = b(parcel.readString());
            parcel2.writeNoException();
            parcel2.writeString(strB);
            return true;
        }

        public static boolean a(b bVar) {
            if (a.f10108a != null || bVar == null) {
                return false;
            }
            a.f10108a = bVar;
            return true;
        }

        /* compiled from: IDeviceIdService.java */
        /* renamed from: com.umeng.analytics.pro.b$b$a */
        private static class a implements b {

            /* renamed from: a, reason: collision with root package name */
            public static b f10108a;

            /* renamed from: b, reason: collision with root package name */
            private IBinder f10109b;

            a(IBinder iBinder) {
                this.f10109b = iBinder;
            }

            @Override // com.umeng.analytics.pro.b
            public String a() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(AbstractBinderC0136b.f10107d);
                    if (!this.f10109b.transact(1, parcelObtain, parcelObtain2, 0) && AbstractBinderC0136b.b() != null) {
                        return AbstractBinderC0136b.b().a();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f10109b;
            }

            public String b() {
                return AbstractBinderC0136b.f10107d;
            }

            @Override // com.umeng.analytics.pro.b
            public String b(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(AbstractBinderC0136b.f10107d);
                    parcelObtain.writeString(str);
                    if (!this.f10109b.transact(3, parcelObtain, parcelObtain2, 0) && AbstractBinderC0136b.b() != null) {
                        return AbstractBinderC0136b.b().b(str);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.umeng.analytics.pro.b
            public String a(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(AbstractBinderC0136b.f10107d);
                    parcelObtain.writeString(str);
                    if (!this.f10109b.transact(2, parcelObtain, parcelObtain2, 0) && AbstractBinderC0136b.b() != null) {
                        return AbstractBinderC0136b.b().a(str);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }
    }
}
