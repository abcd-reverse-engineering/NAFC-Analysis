package cn.cloudwalk.libproject.dialog;

import android.app.Activity;
import android.content.DialogInterface;
import android.view.KeyEvent;

/* loaded from: classes.dex */
public class BaseOnKeyListener implements DialogInterface.OnKeyListener {
    private Activity activity;
    private int onKeyType;

    public BaseOnKeyListener(Activity activity, @OnKeyType int i2) {
        this.onKeyType = i2;
        this.activity = activity;
    }

    public static BaseOnKeyListener dismissKillActivity(Activity activity) {
        return new BaseOnKeyListener(activity, 0);
    }

    public static BaseOnKeyListener dismissNotKillActivity(Activity activity) {
        return new BaseOnKeyListener(activity, 1);
    }

    public static BaseOnKeyListener notDismissNotKillActivity(Activity activity) {
        return new BaseOnKeyListener(activity, 2);
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public boolean onKey(DialogInterface dialogInterface, int i2, KeyEvent keyEvent) {
        if (i2 == 4) {
            int i3 = this.onKeyType;
            if (i3 == 0) {
                dialogInterface.dismiss();
                this.activity.finish();
            } else if (1 == i3) {
                dialogInterface.dismiss();
            }
        }
        return true;
    }
}
