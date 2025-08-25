package com.tencent.bugly.beta.ui;

import android.R;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.tencent.bugly.beta.Beta;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public class BetaActivity extends FragmentActivity {
    public Runnable onDestroyRunnable = null;

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            requestWindowFeature(1);
            if (Beta.dialogFullScreen) {
                getWindow().setFlags(1024, 1024);
            }
            View viewFindViewById = getWindow().getDecorView().findViewById(R.id.content);
            if (viewFindViewById != null) {
                viewFindViewById.setOnClickListener(new com.tencent.bugly.beta.global.b(1, this, viewFindViewById));
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        int intExtra = getIntent().getIntExtra("frag", -1);
        b bVar = g.f8844a.get(Integer.valueOf(intExtra));
        if (bVar == null) {
            finish();
        } else {
            getSupportFragmentManager().beginTransaction().add(R.id.content, bVar).commit();
            g.f8844a.remove(Integer.valueOf(intExtra));
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        Runnable runnable = this.onDestroyRunnable;
        if (runnable != null) {
            runnable.run();
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        Fragment fragmentFindFragmentById = getSupportFragmentManager().findFragmentById(R.id.content);
        boolean zA = false;
        try {
            if (fragmentFindFragmentById instanceof b) {
                zA = ((b) fragmentFindFragmentById).a(i2, keyEvent);
            }
        } catch (Exception unused) {
        }
        if (zA) {
            return true;
        }
        return super.onKeyDown(i2, keyEvent);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        overridePendingTransition(0, 0);
        super.onPause();
    }
}
