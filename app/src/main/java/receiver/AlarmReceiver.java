package receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import bean.CheckTimeBean;
import manager.NotificationHelper;
import ui.presenter.WelocmPresenter;
import util.a2;
import util.n1;
import util.u1;
import util.v0;

/* loaded from: classes2.dex */
public class AlarmReceiver extends BroadcastReceiver {
    private void a(Context context) {
        CheckTimeBean checkTimeBean = (CheckTimeBean) u1.a(u1.I0, CheckTimeBean.class);
        if (checkTimeBean != null) {
            new v0().b(context, checkTimeBean.getCode());
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (!NotificationHelper.isNotificationEnabled(context, a2.f20717g, a2.f20718h)) {
            u1.a((Object) null, u1.I0);
            u1.b(u1.J0, 0L);
            u1.b(u1.K0, 0L);
        } else {
            if (TextUtils.equals(WelocmPresenter.VIRAPPCHECK, "0")) {
                return;
            }
            if (((CheckTimeBean) u1.a(u1.I0, CheckTimeBean.class)) != null) {
                n1.a("hello alarm ing");
                a(context);
                new a2(context, a2.f20716f);
            }
            n1.a("hello alarm");
        }
    }
}
