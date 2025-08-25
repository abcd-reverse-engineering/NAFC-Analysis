package com.huawei.hms.adapter;

import android.content.Context;
import com.huawei.hms.common.internal.Objects;
import com.huawei.hms.support.log.HMSLog;

/* loaded from: classes.dex */
public class OuterBinderAdapter extends BinderAdapter {

    /* renamed from: j, reason: collision with root package name */
    private static final Object f6580j = new Object();

    /* renamed from: k, reason: collision with root package name */
    private static BinderAdapter f6581k;

    /* renamed from: l, reason: collision with root package name */
    private static String f6582l;

    /* renamed from: m, reason: collision with root package name */
    private static String f6583m;

    private OuterBinderAdapter(Context context, String str, String str2) {
        super(context, str, str2);
    }

    public static BinderAdapter getInstance(Context context, String str, String str2) {
        BinderAdapter binderAdapter;
        HMSLog.i("OuterBinderAdapter", "OuterBinderAdapter getInstance.");
        synchronized (f6580j) {
            if (f6581k == null) {
                f6582l = str;
                f6583m = str2;
                f6581k = new OuterBinderAdapter(context, str, str2);
            } else {
                if ((Objects.equal(f6582l, str) && Objects.equal(f6583m, str2)) ? false : true) {
                    HMSLog.i("OuterBinderAdapter", "OuterBinderAdapter getInstance refresh adapter");
                    f6582l = str;
                    f6583m = str2;
                    f6581k.unBind();
                    f6581k = new OuterBinderAdapter(context, str, str2);
                }
            }
            binderAdapter = f6581k;
        }
        return binderAdapter;
    }

    @Override // com.huawei.hms.adapter.BinderAdapter
    protected int getConnTimeOut() {
        return 1001;
    }

    @Override // com.huawei.hms.adapter.BinderAdapter
    protected int getMsgDelayDisconnect() {
        return 1002;
    }
}
