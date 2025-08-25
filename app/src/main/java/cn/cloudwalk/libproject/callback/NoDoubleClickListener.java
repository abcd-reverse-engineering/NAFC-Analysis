package cn.cloudwalk.libproject.callback;

import android.view.View;
import java.util.Calendar;

/* loaded from: classes.dex */
public abstract class NoDoubleClickListener implements View.OnClickListener {
    public static final int MIN_CLICK_DELAY_TIME = 500;
    private long lastClickTime = 0;

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        long timeInMillis = Calendar.getInstance().getTimeInMillis();
        if (timeInMillis - this.lastClickTime > 500) {
            this.lastClickTime = timeInMillis;
            onNoDoubleClick(view);
        }
    }

    public abstract void onNoDoubleClick(View view);
}
