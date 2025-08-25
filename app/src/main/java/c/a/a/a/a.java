package c.a.a.a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: ITelephony.java */
/* loaded from: classes.dex */
public interface a extends IInterface {

    /* compiled from: ITelephony.java */
    /* renamed from: c.a.a.a.a$a, reason: collision with other inner class name */
    public static abstract class AbstractBinderC0031a extends Binder implements a {

        /* renamed from: a, reason: collision with root package name */
        private static final String f2328a = "com.android.internal.telephony.ITelephony";

        /* renamed from: b, reason: collision with root package name */
        static final int f2329b = 1;

        /* renamed from: c, reason: collision with root package name */
        static final int f2330c = 2;

        /* renamed from: d, reason: collision with root package name */
        static final int f2331d = 3;

        /* compiled from: ITelephony.java */
        /* renamed from: c.a.a.a.a$a$a, reason: collision with other inner class name */
        private static class C0032a implements a {

            /* renamed from: a, reason: collision with root package name */
            private IBinder f2332a;

            C0032a(IBinder iBinder) {
                this.f2332a = iBinder;
            }

            public String a() {
                return AbstractBinderC0031a.f2328a;
            }

            @Override // c.a.a.a.a
            public void a(int i2, long j2, boolean z, float f2, double d2, String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(AbstractBinderC0031a.f2328a);
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeLong(j2);
                    parcelObtain.writeInt(z ? 1 : 0);
                    parcelObtain.writeFloat(f2);
                    parcelObtain.writeDouble(d2);
                    parcelObtain.writeString(str);
                    this.f2332a.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f2332a;
            }

            @Override // c.a.a.a.a
            public boolean h() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(AbstractBinderC0031a.f2328a);
                    this.f2332a.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // c.a.a.a.a
            public void i() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(AbstractBinderC0031a.f2328a);
                    this.f2332a.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public AbstractBinderC0031a() {
            attachInterface(this, f2328a);
        }

        public static a a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(f2328a);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof a)) ? new C0032a(iBinder) : (a) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
            if (i2 == 1) {
                parcel.enforceInterface(f2328a);
                a(parcel.readInt(), parcel.readLong(), parcel.readInt() != 0, parcel.readFloat(), parcel.readDouble(), parcel.readString());
                parcel2.writeNoException();
                return true;
            }
            if (i2 == 2) {
                parcel.enforceInterface(f2328a);
                boolean zH = h();
                parcel2.writeNoException();
                parcel2.writeInt(zH ? 1 : 0);
                return true;
            }
            if (i2 != 3) {
                if (i2 != 1598968902) {
                    return super.onTransact(i2, parcel, parcel2, i3);
                }
                parcel2.writeString(f2328a);
                return true;
            }
            parcel.enforceInterface(f2328a);
            i();
            parcel2.writeNoException();
            return true;
        }
    }

    void a(int i2, long j2, boolean z, float f2, double d2, String str) throws RemoteException;

    boolean h() throws RemoteException;

    void i() throws RemoteException;
}
