package com.huawei.hms.support.api.push;

import android.app.Activity;
import android.os.Bundle;
import c.c.a.b.a.a;
import com.huawei.android.hms.push.R;
import com.huawei.hms.push.t;

/* loaded from: classes.dex */
public class TransActivity extends Activity {
    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.hwpush_trans_activity);
        getWindow().addFlags(a.B1);
        t.a(this, getIntent());
        finish();
    }
}
