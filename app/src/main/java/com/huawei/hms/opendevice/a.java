package com.huawei.hms.opendevice;

import android.content.Context;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.aaid.entity.AAIDResult;
import java.util.concurrent.Callable;

/* compiled from: AAIDCallable.java */
/* loaded from: classes.dex */
public class a implements Callable<AAIDResult> {

    /* renamed from: a, reason: collision with root package name */
    private Context f7124a;

    public a(Context context) {
        this.f7124a = context;
    }

    @Override // java.util.concurrent.Callable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public AAIDResult call() throws Exception {
        Context context = this.f7124a;
        if (context == null) {
            throw ErrorEnum.ERROR_ARGUMENTS_INVALID.toApiException();
        }
        String strB = b.b(context);
        AAIDResult aAIDResult = new AAIDResult();
        aAIDResult.setId(strB);
        return aAIDResult;
    }
}
