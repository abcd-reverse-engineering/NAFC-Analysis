package c.c.a.a.e;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import com.hihonor.cloudservice.framework.aidl.DataBuffer;
import com.hihonor.cloudservice.framework.aidl.a;
import com.hihonor.honorid.core.helper.handler.ErrorStatus;
import k.a.a.a.j.e;

/* compiled from: AuthOperationTask.java */
/* loaded from: classes.dex */
public class a extends k.a.a.c.a.b {

    /* renamed from: d, reason: collision with root package name */
    private final Bundle f3085d;

    /* renamed from: e, reason: collision with root package name */
    private final c.c.a.a.d.b f3086e;

    /* renamed from: f, reason: collision with root package name */
    private final String f3087f;

    /* compiled from: AuthOperationTask.java */
    /* renamed from: c.c.a.a.e.a$a, reason: collision with other inner class name */
    class BinderC0039a extends a.AbstractBinderC0098a {
        BinderC0039a() {
        }

        @Override // com.hihonor.cloudservice.framework.aidl.a
        public void a(DataBuffer dataBuffer) {
            e.b("AuthOperationTask", "onResult", true);
            if (((k.a.a.c.a.b) a.this).f17079b.get()) {
                e.b("AuthOperationTask", "has cancelled by timeout, return directly", true);
                return;
            }
            a.this.b();
            String str = dataBuffer.f5984b;
            Bundle bundle = dataBuffer.f5986d;
            int i2 = bundle.getInt("retCode");
            e.b("AuthOperationTask", "onResult retCode:" + i2, true);
            if (i2 == 0) {
                if (str.equals("honorid.signout")) {
                    e.b("AuthOperationTask", "opensdk signOut", true);
                    a.this.f3086e.a(bundle);
                    return;
                } else if (str.equals("honorid.revokeaccess")) {
                    a.this.f3086e.a(bundle);
                    return;
                } else if (!str.equals("honorid.getScope")) {
                    a.this.f3086e.a(bundle);
                    return;
                } else {
                    a.this.f3086e.a(((Intent) bundle.getParcelable("data")).getExtras());
                    return;
                }
            }
            if (i2 == 2001) {
                a.this.f3086e.a(new ErrorStatus(31, "Account has not login"));
                return;
            }
            if (i2 == 7) {
                a.this.f3086e.a(new ErrorStatus(42, "userid not system account"));
                return;
            }
            if (i2 == 8) {
                a.this.f3086e.a(new ErrorStatus(44, "packagename was not matched"));
                return;
            }
            if (i2 == 9) {
                a.this.f3086e.a(new ErrorStatus(43, "packagename not in honorid list"));
                return;
            }
            if (i2 == 1) {
                a.this.f3086e.a(new ErrorStatus(29, "Signature invalid"));
            } else if (i2 == 5) {
                a.this.f3086e.a(new ErrorStatus(69, "uid not match"));
            } else {
                a.this.f3086e.a(new ErrorStatus(44, "other error"));
                e.b("AuthOperationTask", "DONT KNOW RET_CODE:", true);
            }
        }
    }

    public a(Context context, Bundle bundle, String str, c.c.a.a.d.b bVar) {
        super(context);
        this.f3085d = bundle;
        this.f3086e = bVar;
        this.f3087f = str;
    }

    @Override // k.a.a.c.a.b
    protected void a() {
        DataBuffer dataBuffer = new DataBuffer(this.f3087f, 1001);
        dataBuffer.f5986d = this.f3085d;
        try {
            k.a.a.c.a.a.a(this.f17080c).a().a(dataBuffer, new BinderC0039a());
        } catch (RemoteException unused) {
            e.a("AuthOperationTask", "authOperation remote exception", true);
        }
    }

    @Override // k.a.a.c.a.b
    public void a(ErrorStatus errorStatus) {
        if (errorStatus == null) {
            errorStatus = new ErrorStatus(39, "authOperation timeout. retry again");
        }
        this.f3086e.a(errorStatus);
    }
}
