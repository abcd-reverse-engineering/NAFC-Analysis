package com.tencent.bugly.beta.ui;

import android.graphics.Color;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.bugly.beta.Beta;
import com.tencent.bugly.proguard.an;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public class e extends a {
    protected TextView n;

    @Override // com.tencent.bugly.beta.ui.b
    public boolean a(int i2, KeyEvent keyEvent) {
        return false;
    }

    @Override // com.tencent.bugly.beta.ui.a, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f8819l = com.tencent.bugly.beta.global.e.G.f8802l;
        View viewOnCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        if (this.f8819l == 0) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            this.n = new TextView(this.f8808a);
            this.n.setLayoutParams(layoutParams);
            TextView textView = this.n;
            this.f8817j.getClass();
            textView.setTextColor(Color.parseColor("#757575"));
            this.n.setTextSize(16.0f);
            this.n.setTag(Beta.TAG_TIP_MESSAGE);
            this.f8816i.addView(this.n);
        } else if (viewOnCreateView != null) {
            this.n = (TextView) viewOnCreateView.findViewWithTag(Beta.TAG_TIP_MESSAGE);
        }
        try {
            this.n.setText("检测到当前版本需要重启，是否重启应用？");
            this.f8813f.setText("更新提示");
            a("取消", new com.tencent.bugly.beta.global.b(8, this), "重启应用", new com.tencent.bugly.beta.global.b(7, this));
        } catch (Exception e2) {
            if (this.f8819l != 0) {
                an.e("please confirm your argument: [Beta.tipsDialogLayoutId] is correct", new Object[0]);
            }
            if (!an.b(e2)) {
                e2.printStackTrace();
            }
        }
        return viewOnCreateView;
    }
}
