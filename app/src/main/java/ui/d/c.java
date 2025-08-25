package ui.d;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.Window;
import com.hicorenational.antifraud.R;

/* compiled from: RecordFinishDialog.java */
/* loaded from: classes2.dex */
public class c extends d {
    public c(Context context) {
        super(context, R.style.SmsIntercepteDilog);
    }

    @Override // ui.d.d, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Window window = getWindow();
        if (Build.VERSION.SDK_INT >= 26) {
            window.setType(2038);
        } else {
            window.setType(2003);
        }
        this.f19507a.setText("通话录音已完成");
        this.f19509c.setVisibility(8);
        c("举报录音");
        setCanceledOnTouchOutside(false);
    }
}
