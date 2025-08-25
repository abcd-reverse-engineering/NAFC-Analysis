package i.e.b.e.a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: IDeviceidInterface.java */
/* loaded from: classes2.dex */
public interface a extends IInterface {
    String a() throws RemoteException;

    String a(String str) throws RemoteException;

    String b() throws RemoteException;

    String b(String str) throws RemoteException;

    boolean c() throws RemoteException;

    boolean c(String str) throws RemoteException;

    /* compiled from: IDeviceidInterface.java */
    /* renamed from: i.e.b.e.a.a$a, reason: collision with other inner class name */
    public static abstract class AbstractBinderC0260a extends Binder implements a {

        /* renamed from: a, reason: collision with root package name */
        private static final String f16969a = "org.repackage.com.zui.deviceidservice.IDeviceidInterface";

        /* renamed from: b, reason: collision with root package name */
        static final int f16970b = 1;

        /* renamed from: c, reason: collision with root package name */
        static final int f16971c = 2;

        /* renamed from: d, reason: collision with root package name */
        static final int f16972d = 3;

        /* renamed from: e, reason: collision with root package name */
        static final int f16973e = 4;

        /* renamed from: f, reason: collision with root package name */
        static final int f16974f = 5;

        /* renamed from: g, reason: collision with root package name */
        static final int f16975g = 6;

        public AbstractBinderC0260a() {
            attachInterface(this, f16969a);
        }

        public static a a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(f16969a);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof a)) ? new C0261a(iBinder) : (a) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
            if (i2 == 1598968902) {
                parcel2.writeString(f16969a);
                return true;
            }
            switch (i2) {
                case 1:
                    parcel.enforceInterface(f16969a);
                    String strA = a();
                    parcel2.writeNoException();
                    parcel2.writeString(strA);
                    return true;
                case 2:
                    parcel.enforceInterface(f16969a);
                    String strB = b();
                    parcel2.writeNoException();
                    parcel2.writeString(strB);
                    return true;
                case 3:
                    parcel.enforceInterface(f16969a);
                    boolean zC = c();
                    parcel2.writeNoException();
                    parcel2.writeInt(zC ? 1 : 0);
                    return true;
                case 4:
                    parcel.enforceInterface(f16969a);
                    String strA2 = a(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(strA2);
                    return true;
                case 5:
                    parcel.enforceInterface(f16969a);
                    String strB2 = b(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(strB2);
                    return true;
                case 6:
                    parcel.enforceInterface(f16969a);
                    boolean zC2 = c(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(zC2 ? 1 : 0);
                    return true;
                default:
                    return super.onTransact(i2, parcel, parcel2, i3);
            }
        }

        /* compiled from: IDeviceidInterface.java */
        /* renamed from: i.e.b.e.a.a$a$a, reason: collision with other inner class name */
        private static class C0261a implements a {

            /* renamed from: a, reason: collision with root package name */
            private IBinder f16976a;

            C0261a(IBinder iBinder) {
                this.f16976a = iBinder;
            }

            @Override // i.e.b.e.a.a
            public String a() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(AbstractBinderC0260a.f16969a);
                    this.f16976a.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f16976a;
            }

            @Override // i.e.b.e.a.a
            public String b() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(AbstractBinderC0260a.f16969a);
                    this.f16976a.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // i.e.b.e.a.a
            public boolean c() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(AbstractBinderC0260a.f16969a);
                    this.f16976a.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            public String d() {
                return AbstractBinderC0260a.f16969a;
            }

            @Override // i.e.b.e.a.a
            public String a(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(AbstractBinderC0260a.f16969a);
                    parcelObtain.writeString(str);
                    this.f16976a.transact(4, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // i.e.b.e.a.a
            public String b(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(AbstractBinderC0260a.f16969a);
                    parcelObtain.writeString(str);
                    this.f16976a.transact(5, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // i.e.b.e.a.a
            public boolean c(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(AbstractBinderC0260a.f16969a);
                    parcelObtain.writeString(str);
                    this.f16976a.transact(6, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }
    }
}
