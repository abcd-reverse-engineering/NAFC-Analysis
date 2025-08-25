package receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import bean.CheckTimeBean;
import util.u1;
import util.v0;

/* loaded from: classes2.dex */
public class TimeChangeReceiver extends BroadcastReceiver {
    private void a(Context context) {
        CheckTimeBean checkTimeBean = (CheckTimeBean) u1.a(u1.I0, CheckTimeBean.class);
        if (checkTimeBean != null) {
            new v0().a(context, checkTimeBean.getCode());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0028  */
    @Override // android.content.BroadcastReceiver
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onReceive(android.content.Context r4, android.content.Intent r5) {
        /*
            r3 = this;
            java.lang.String r5 = r5.getAction()
            int r0 = r5.hashCode()
            r1 = 502473491(0x1df32313, float:6.435783E-21)
            r2 = 1
            if (r0 == r1) goto L1e
            r1 = 505380757(0x1e1f7f95, float:8.443773E-21)
            if (r0 == r1) goto L14
            goto L28
        L14:
            java.lang.String r0 = "android.intent.action.TIME_SET"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L28
            r5 = 0
            goto L29
        L1e:
            java.lang.String r0 = "android.intent.action.TIMEZONE_CHANGED"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L28
            r5 = 1
            goto L29
        L28:
            r5 = -1
        L29:
            if (r5 == 0) goto L2e
            if (r5 == r2) goto L33
            goto L3b
        L2e:
            java.lang.String r5 = "system time changed"
            util.n1.a(r5)
        L33:
            java.lang.String r5 = "system time zone changed"
            util.n1.a(r5)
            r3.a(r4)
        L3b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: receiver.TimeChangeReceiver.onReceive(android.content.Context, android.content.Intent):void");
    }
}
