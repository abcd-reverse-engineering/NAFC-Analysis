package com.huawei.hms.adapter;

import android.content.Context;
import com.huawei.hms.support.log.HMSLog;
import ui.activity.BaseProgressUploadActivity;

/* loaded from: classes.dex */
public class InnerBinderAdapter extends BinderAdapter {

    /* renamed from: j, reason: collision with root package name */
    private static final Object f6578j = new Object();

    /* renamed from: k, reason: collision with root package name */
    private static BinderAdapter f6579k;

    private InnerBinderAdapter(Context context, String str, String str2) {
        super(context, str, str2);
    }

    public static BinderAdapter getInstance(Context context, String str, String str2) {
        BinderAdapter binderAdapter;
        HMSLog.i("InnerBinderAdapter", "InnerBinderAdapter getInstance.");
        synchronized (f6578j) {
            if (f6579k == null) {
                f6579k = new InnerBinderAdapter(context, str, str2);
            }
            binderAdapter = f6579k;
        }
        return binderAdapter;
    }

    @Override // com.huawei.hms.adapter.BinderAdapter
    protected int getConnTimeOut() {
        return BaseProgressUploadActivity.REQUESTION_CODE_RECORD_AUDIO_1;
    }

    @Override // com.huawei.hms.adapter.BinderAdapter
    protected int getMsgDelayDisconnect() {
        return BaseProgressUploadActivity.REQUESTION_CODE_RECORD_AUDIO_2;
    }
}
