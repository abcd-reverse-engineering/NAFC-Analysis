package com.hihonor.push.sdk;

import android.content.Context;
import com.hihonor.push.sdk.common.data.ApiException;
import com.hihonor.push.sdk.internal.HonorPushErrorEnum;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
public class s {

    /* renamed from: a, reason: collision with root package name */
    public final Context f6324a;

    /* renamed from: b, reason: collision with root package name */
    public a0 f6325b = new a0();

    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Callable f6326a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ HonorPushCallback f6327b;

        public a(Callable callable, HonorPushCallback honorPushCallback) {
            this.f6326a = callable;
            this.f6327b = honorPushCallback;
        }

        @Override // java.lang.Runnable
        public void run() throws Exception {
            try {
                Object objCall = this.f6326a.call();
                s sVar = s.this;
                HonorPushCallback honorPushCallback = this.f6327b;
                sVar.getClass();
                b1.a(new t(sVar, honorPushCallback, objCall));
            } catch (ApiException e2) {
                s.a(s.this, this.f6327b, e2.getErrorCode(), e2.getMessage());
            } catch (Exception unused) {
                s sVar2 = s.this;
                HonorPushCallback honorPushCallback2 = this.f6327b;
                HonorPushErrorEnum honorPushErrorEnum = HonorPushErrorEnum.ERROR_INTERNAL_ERROR;
                s.a(sVar2, honorPushCallback2, honorPushErrorEnum.getErrorCode(), honorPushErrorEnum.getMessage());
            }
        }
    }

    public s(Context context) {
        this.f6324a = context;
    }

    public static void a(s sVar, HonorPushCallback honorPushCallback, int i2, String str) {
        sVar.getClass();
        b1.a(new u(sVar, honorPushCallback, i2, str));
    }

    public final <T> void a(Callable<T> callable, HonorPushCallback<T> honorPushCallback) {
        a aVar = new a(callable, honorPushCallback);
        b1 b1Var = b1.f6254d;
        if (b1Var.f6256b == null) {
            synchronized (b1Var.f6257c) {
                if (b1Var.f6256b == null) {
                    b1Var.f6256b = b1Var.b();
                }
            }
        }
        b1Var.f6256b.execute(aVar);
    }
}
