package c.e.a;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes.dex */
public interface a extends IInterface {

    /* renamed from: c.e.a.a$a, reason: collision with other inner class name */
    public static class C0042a implements a {
        @Override // c.e.a.a
        public void a(Bundle bundle) {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class b extends Binder implements a {

        /* renamed from: a, reason: collision with root package name */
        private static final String f3180a = "com.mcs.aidl.IMcsSdkService";

        /* renamed from: b, reason: collision with root package name */
        static final int f3181b = 1;

        /* renamed from: c.e.a.a$b$a, reason: collision with other inner class name */
        private static class C0043a implements a {

            /* renamed from: b, reason: collision with root package name */
            public static a f3182b;

            /* renamed from: a, reason: collision with root package name */
            private IBinder f3183a;

            C0043a(IBinder iBinder) {
                this.f3183a = iBinder;
            }

            public String a() {
                return b.f3180a;
            }

            @Override // c.e.a.a
            public void a(Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(b.f3180a);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.f3183a.transact(1, parcelObtain, parcelObtain2, 0) || b.a() == null) {
                        parcelObtain2.readException();
                    } else {
                        b.a().a(bundle);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f3183a;
            }
        }

        public b() {
            attachInterface(this, f3180a);
        }

        public static a a() {
            return C0043a.f3182b;
        }

        public static a a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(f3180a);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof a)) ? new C0043a(iBinder) : (a) iInterfaceQueryLocalInterface;
        }

        public static boolean a(a aVar) {
            if (C0043a.f3182b != null || aVar == null) {
                return false;
            }
            C0043a.f3182b = aVar;
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) {
            if (i2 != 1) {
                if (i2 != 1598968902) {
                    return super.onTransact(i2, parcel, parcel2, i3);
                }
                parcel2.writeString(f3180a);
                return true;
            }
            parcel.enforceInterface(f3180a);
            a(parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
            parcel2.writeNoException();
            return true;
        }
    }

    void a(Bundle bundle);
}
