package anetwork.channel.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import anetwork.channel.aidl.h;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public interface b extends IInterface {

    /* compiled from: Taobao */
    public static abstract class a extends Binder implements b {

        /* renamed from: a, reason: collision with root package name */
        private static final String f2111a = "anetwork.channel.aidl.IRemoteNetworkGetter";

        /* renamed from: b, reason: collision with root package name */
        static final int f2112b = 1;

        /* compiled from: Taobao */
        /* renamed from: anetwork.channel.aidl.b$a$a, reason: collision with other inner class name */
        private static class C0019a implements b {

            /* renamed from: a, reason: collision with root package name */
            private IBinder f2113a;

            C0019a(IBinder iBinder) {
                this.f2113a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f2113a;
            }

            @Override // anetwork.channel.aidl.b
            public h get(int i2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(a.f2111a);
                    parcelObtain.writeInt(i2);
                    this.f2113a.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return h.a.a(parcelObtain2.readStrongBinder());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public a() {
            attachInterface(this, f2111a);
        }

        public static b a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(f2111a);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof b)) ? new C0019a(iBinder) : (b) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
            if (i2 != 1) {
                if (i2 != 1598968902) {
                    return super.onTransact(i2, parcel, parcel2, i3);
                }
                parcel2.writeString(f2111a);
                return true;
            }
            parcel.enforceInterface(f2111a);
            h hVar = get(parcel.readInt());
            parcel2.writeNoException();
            parcel2.writeStrongBinder(hVar != null ? hVar.asBinder() : null);
            return true;
        }
    }

    h get(int i2) throws RemoteException;
}
