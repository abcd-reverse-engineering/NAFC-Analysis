package com.huawei.hms.push.task;

import android.content.Context;
import android.content.Intent;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.push.utils.PushBiUtil;
import com.huawei.hms.support.api.entity.push.PushNaming;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
public class IntentCallable implements Callable<Void> {

    /* renamed from: a, reason: collision with root package name */
    private Context f7232a;

    /* renamed from: b, reason: collision with root package name */
    private Intent f7233b;

    /* renamed from: c, reason: collision with root package name */
    private String f7234c;

    public IntentCallable(Context context, Intent intent, String str) {
        this.f7232a = context;
        this.f7233b = intent;
        this.f7234c = str;
    }

    @Override // java.util.concurrent.Callable
    public Void call() throws Exception {
        this.f7232a.sendBroadcast(this.f7233b);
        PushBiUtil.reportExit(this.f7232a, PushNaming.SET_NOTIFY_FLAG, this.f7234c, ErrorEnum.SUCCESS);
        return null;
    }
}
