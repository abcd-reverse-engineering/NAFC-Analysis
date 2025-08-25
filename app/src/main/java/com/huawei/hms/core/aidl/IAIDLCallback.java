package com.huawei.hms.core.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface IAIDLCallback extends IInterface {
    public static final String DESCRIPTOR = "com.huawei.hms.core.aidl.IAIDLCallback";

    public static abstract class Stub extends Binder implements IAIDLCallback {
        static final int TRANSACTION_call = 1;

        private static class a implements IAIDLCallback {

            /* renamed from: b, reason: collision with root package name */
            public static IAIDLCallback f6793b;

            /* renamed from: a, reason: collision with root package name */
            private IBinder f6794a;

            a(IBinder iBinder) {
                this.f6794a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f6794a;
            }

            @Override // com.huawei.hms.core.aidl.IAIDLCallback
            public void call(DataBuffer dataBuffer) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IAIDLCallback.DESCRIPTOR);
                    if (dataBuffer != null) {
                        parcelObtain.writeInt(1);
                        dataBuffer.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.f6794a.transact(1, parcelObtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().call(dataBuffer);
                } finally {
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, IAIDLCallback.DESCRIPTOR);
        }

        public static IAIDLCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(IAIDLCallback.DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IAIDLCallback)) ? new a(iBinder) : (IAIDLCallback) iInterfaceQueryLocalInterface;
        }

        public static IAIDLCallback getDefaultImpl() {
            return a.f6793b;
        }

        public static boolean setDefaultImpl(IAIDLCallback iAIDLCallback) {
            if (a.f6793b != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iAIDLCallback == null) {
                return false;
            }
            a.f6793b = iAIDLCallback;
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
            if (i2 == 1598968902) {
                parcel2.writeString(IAIDLCallback.DESCRIPTOR);
                return true;
            }
            if (i2 != 1) {
                return super.onTransact(i2, parcel, parcel2, i3);
            }
            parcel.enforceInterface(IAIDLCallback.DESCRIPTOR);
            call(parcel.readInt() != 0 ? DataBuffer.CREATOR.createFromParcel(parcel) : null);
            return true;
        }
    }

    void call(DataBuffer dataBuffer) throws RemoteException;
}
