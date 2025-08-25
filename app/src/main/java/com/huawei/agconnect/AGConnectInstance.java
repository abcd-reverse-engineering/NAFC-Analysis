package com.huawei.agconnect;

import android.content.Context;
import com.huawei.agconnect.core.a.b;

/* loaded from: classes.dex */
public abstract class AGConnectInstance {
    public static AGConnectInstance buildInstance(AGConnectOptions aGConnectOptions) {
        return b.a(aGConnectOptions);
    }

    public static AGConnectInstance getInstance() {
        return b.a();
    }

    public static AGConnectInstance getInstance(String str) {
        return b.a(str);
    }

    public static void initialize(Context context) {
        b.a(context);
    }

    public static void initialize(Context context, AGConnectOptionsBuilder aGConnectOptionsBuilder) {
        b.a(context, aGConnectOptionsBuilder);
    }

    public abstract Context getContext();

    public abstract String getIdentifier();

    public abstract AGConnectOptions getOptions();

    public abstract <T> T getService(Class<? super T> cls);
}
