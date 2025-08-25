package receiver;

import android.app.Activity;
import android.app.Application;
import android.app.Dialog;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.app.NotificationManagerCompat;
import bean.PushEntity;
import com.hicorenational.antifraud.R;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.message.IUmengCallback;
import com.umeng.message.PushAgent;
import com.umeng.message.UmengNotificationClickHandler;
import com.umeng.message.api.UPushRegisterCallback;
import com.umeng.message.api.UPushTagCallback;
import com.umeng.message.common.UPushNotificationChannel;
import com.umeng.message.common.inter.ITagManager;
import com.umeng.message.entity.UMessage;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import interfaces.IClickListener;
import java.util.HashMap;
import java.util.List;
import manager.AccountManager;
import org.android.agoo.honor.HonorRegister;
import org.android.agoo.huawei.HuaWeiRegister;
import org.android.agoo.oppo.OppoRegister;
import org.android.agoo.vivo.VivoRegister;
import org.android.agoo.xiaomi.MiPushRegistar;
import ui.activity.HistoryReportEvdListActivity;
import ui.activity.IDVarfyListActivity;
import ui.activity.MainActivity;
import ui.activity.PromosWebDetActivity;
import ui.activity.ReportRecordsActivity;
import ui.activity.WebActivity;
import ui.activity.WebFullActivity;
import ui.activity.WelcomeActivity;
import util.b1;
import util.k1;
import util.m1;
import util.n1;
import util.u1;
import util.v1;

/* compiled from: UmengPushMessage.java */
/* loaded from: classes2.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public static String f17545a = "";

    /* renamed from: b, reason: collision with root package name */
    static Dialog f17546b = null;

    /* renamed from: c, reason: collision with root package name */
    static PushAgent f17547c = null;

    /* renamed from: d, reason: collision with root package name */
    public static String f17548d = "10007";

    /* renamed from: e, reason: collision with root package name */
    static UmengNotificationClickHandler f17549e = new b();

    /* compiled from: UmengPushMessage.java */
    static class a implements UPushRegisterCallback {
        a() {
        }

        @Override // com.umeng.message.api.UPushRegisterCallback
        public void onFailure(String str, String str2) {
            n1.b("hsc", "注册失败：-------->s:" + str + ",s1:" + str2);
        }

        @Override // com.umeng.message.api.UPushRegisterCallback
        public void onSuccess(String str) {
            n1.c("hsc", "注册成功：deviceToken：-------->" + str);
            e.f17545a = str;
        }
    }

    /* compiled from: UmengPushMessage.java */
    static class b extends UmengNotificationClickHandler {
        b() {
        }

        @Override // com.umeng.message.UmengNotificationClickHandler
        public void launchApp(Context context, UMessage uMessage) {
            HashMap map;
            super.launchApp(context, uMessage);
            if (uMessage == null || (map = (HashMap) uMessage.extra) == null || map.size() <= 0) {
                return;
            }
            String str = map.containsKey("type") ? (String) map.get("type") : "";
            String str2 = map.containsKey("url") ? (String) map.get("url") : "";
            String str3 = map.containsKey("title") ? (String) map.get("title") : "";
            String str4 = map.containsKey("id") ? (String) map.get("id") : "";
            PushEntity.ExtraBean extraBean = new PushEntity.ExtraBean();
            extraBean.setType(str);
            extraBean.setId(str4);
            extraBean.setTitle(str3);
            extraBean.setUrl(str2);
            e.a(extraBean, context);
        }
    }

    /* compiled from: UmengPushMessage.java */
    static class c implements IUmengCallback {
        c() {
        }

        @Override // com.umeng.message.api.UPushSettingCallback
        public void onFailure(String str, String str2) {
            String str3 = "关闭通知失败s:" + str + ",s1:" + str2;
        }

        @Override // com.umeng.message.api.UPushSettingCallback
        public void onSuccess() {
        }
    }

    /* compiled from: UmengPushMessage.java */
    static class d implements IUmengCallback {
        d() {
        }

        @Override // com.umeng.message.api.UPushSettingCallback
        public void onFailure(String str, String str2) {
            String str3 = "打开通知失败s:" + str + ",s1:" + str2;
        }

        @Override // com.umeng.message.api.UPushSettingCallback
        public void onSuccess() {
        }
    }

    /* compiled from: UmengPushMessage.java */
    /* renamed from: receiver.e$e, reason: collision with other inner class name */
    static class C0280e implements IClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Activity f17550a;

        C0280e(Activity activity) {
            this.f17550a = activity;
        }

        @Override // interfaces.IClickListener
        public void cancelBtn() {
            u1.b(u1.A, true);
        }

        @Override // interfaces.IClickListener
        public void clickOKBtn() {
            v1.k(this.f17550a);
        }
    }

    public static void a(final List<String> list) {
        if (f17547c == null) {
            return;
        }
        List<String> tags = AccountManager.getAccountInfo().getTags();
        if (tags == null || tags.size() <= 0) {
            b(list);
        } else {
            f17547c.getTagManager().deleteTags(new UPushTagCallback() { // from class: receiver.d
                @Override // com.umeng.message.api.UPushTagCallback
                public final void onMessage(boolean z, Object obj) {
                    e.a(list, z, (ITagManager.Result) obj);
                }
            }, (String[]) tags.toArray(new String[tags.size()]));
        }
    }

    public static void b(Application application, String str) {
        UMConfigure.preInit(application, m1.u.l(), str);
    }

    public static void c(Activity activity) {
        PushAgent.getInstance(activity).onAppStart();
        PushAgent.getInstance(activity).enable(new d());
    }

    public static boolean d(Activity activity) {
        if (Build.VERSION.SDK_INT >= 26 || !((Build.BRAND.equalsIgnoreCase("vivo") || Build.BRAND.equalsIgnoreCase("oppo")) && u1.a(u1.B, false))) {
            return a(activity, UPushNotificationChannel.PRIMARY_CHANNEL);
        }
        return true;
    }

    public static void e(Activity activity) {
        if (!u1.a(u1.B, false)) {
            f(activity);
        }
        if (Build.VERSION.SDK_INT < 26) {
            if (Build.BRAND.equalsIgnoreCase("vivo") || Build.BRAND.equalsIgnoreCase("oppo")) {
                u1.b(u1.B, true);
            }
        }
    }

    private static void f(Activity activity) {
        Dialog dialog = f17546b;
        if (dialog == null || !dialog.isShowing()) {
            f17546b = b1.b(activity, R.drawable.iv_flow_primiss, "开启宣传及功能消息推送", (Build.VERSION.SDK_INT >= 26 || !(Build.BRAND.equalsIgnoreCase("vivo") || Build.BRAND.equalsIgnoreCase("oppo"))) ? "可至”设置-通知栏与状态“中开启”允许通知、类别通知“权限" : "可至”设置-通知栏与状态“中开启”允许通知、更多通知“权限", "不允许", "允许", new C0280e(activity));
        }
    }

    private static void b(List<String> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        f17547c.getTagManager().addTags(new UPushTagCallback() { // from class: receiver.c
            @Override // com.umeng.message.api.UPushTagCallback
            public final void onMessage(boolean z, Object obj) {
                n1.a("hsc", "添加标签==" + z);
            }
        }, (String[]) list.toArray(new String[list.size()]));
    }

    public static void b(Activity activity) {
        PushAgent.getInstance(activity).disable(new c());
    }

    static /* synthetic */ void a(List list, boolean z, ITagManager.Result result) {
        n1.a("hsc", "删除标签==" + z);
        b((List<String>) list);
    }

    public static void a(Application application, String str) {
        try {
            UMConfigure.init(application, m1.u.l(), str, 1, m1.u.m());
            f17547c = PushAgent.getInstance(application);
            f17547c.register(new a());
            f17547c.setDisplayNotificationNumber(10);
            f17547c.setNotificationClickHandler(f17549e);
            MiPushRegistar.register(application, m1.u.n(), m1.u.o());
            HuaWeiRegister.register(application);
            OppoRegister.register(application, m1.u.p(), m1.u.q());
            VivoRegister.register(application);
            HonorRegister.register(application);
        } catch (Exception unused) {
        }
    }

    public static void a(PushEntity.ExtraBean extraBean, Context context) {
        if (extraBean == null) {
            return;
        }
        n1.a("bean.getType()==" + extraBean.getType() + " bean.getTitle()==" + extraBean.getTitle() + " bean.getUrl()==" + extraBean.getUrl());
        if (extraBean.getType().equalsIgnoreCase("10001")) {
            Intent intent = new Intent(context, (Class<?>) IDVarfyListActivity.class);
            intent.setFlags(805306368);
            context.startActivity(intent);
        }
        if (extraBean.getType().equalsIgnoreCase("10002")) {
            Intent intent2 = new Intent(context, (Class<?>) PromosWebDetActivity.class);
            intent2.putExtra(k1.P, extraBean.getTitle());
            intent2.putExtra(k1.Q, extraBean.getUrl());
            intent2.putExtra(k1.T, extraBean.getId());
            intent2.putExtra(k1.U, 2);
            intent2.setFlags(CommonNetImpl.FLAG_AUTH);
            context.startActivity(intent2);
            return;
        }
        if (!extraBean.getType().equalsIgnoreCase("10004") && !extraBean.getType().equalsIgnoreCase("10005")) {
            if (extraBean.getType().equalsIgnoreCase("10006")) {
                Intent intent3 = new Intent("android.intent.action.VIEW", Uri.parse(extraBean.getUrl()));
                intent3.setFlags(CommonNetImpl.FLAG_AUTH);
                context.startActivity(intent3);
                return;
            }
            if (extraBean.getType().equalsIgnoreCase(f17548d)) {
                ui.c.i().f();
                Intent intent4 = new Intent(context, (Class<?>) WelcomeActivity.class);
                intent4.putExtra(k1.f20846d, extraBean.getType());
                intent4.putExtra(k1.Q, extraBean.getUrl());
                intent4.setFlags(CommonNetImpl.FLAG_AUTH);
                MainActivity.getPushIntent(intent4);
                context.startActivity(intent4);
                return;
            }
            if (extraBean.getType().equalsIgnoreCase("10008")) {
                Intent intent5 = new Intent(context, (Class<?>) HistoryReportEvdListActivity.class);
                intent5.setFlags(CommonNetImpl.FLAG_AUTH);
                context.startActivity(intent5);
                return;
            } else if (extraBean.getType().equalsIgnoreCase("10009")) {
                Intent intent6 = new Intent(context, (Class<?>) ReportRecordsActivity.class);
                intent6.setFlags(CommonNetImpl.FLAG_AUTH);
                context.startActivity(intent6);
                return;
            } else {
                if (extraBean.getType().equalsIgnoreCase("10010")) {
                    Intent intent7 = new Intent(context, (Class<?>) WebFullActivity.class);
                    intent7.putExtra(k1.Q, extraBean.getUrl());
                    intent7.setFlags(CommonNetImpl.FLAG_AUTH);
                    context.startActivity(intent7);
                    return;
                }
                return;
            }
        }
        String title = extraBean.getTitle();
        Intent intent8 = new Intent(context, (Class<?>) WebActivity.class);
        if (TextUtils.isEmpty(title)) {
            title = "";
        }
        intent8.putExtra(k1.P, title);
        intent8.putExtra(k1.Q, extraBean.getUrl());
        intent8.setFlags(CommonNetImpl.FLAG_AUTH);
        context.startActivity(intent8);
    }

    public static void a(Activity activity) {
        if (d(activity) || u1.a(u1.A, false)) {
            return;
        }
        if (Build.VERSION.SDK_INT < 26 && (Build.BRAND.equalsIgnoreCase("vivo") || Build.BRAND.equalsIgnoreCase("oppo"))) {
            u1.b(u1.A, true);
        }
        f(activity);
    }

    private static boolean a(Context context, String str) {
        NotificationManagerCompat notificationManagerCompatFrom = NotificationManagerCompat.from(context);
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        boolean zAreNotificationsEnabled = notificationManagerCompatFrom.areNotificationsEnabled();
        if (notificationManager != null && Build.VERSION.SDK_INT >= 26) {
            NotificationChannel notificationChannel = notificationManager.getNotificationChannel(str);
            if (notificationChannel == null) {
                notificationManager.createNotificationChannel(new NotificationChannel(str, a(context), 4));
                notificationChannel = notificationManager.getNotificationChannel(str);
            }
            return zAreNotificationsEnabled && notificationChannel.getImportance() != 0;
        }
        if (Build.BRAND.equalsIgnoreCase("vivo") || Build.BRAND.equalsIgnoreCase("oppo")) {
            return false;
        }
        return zAreNotificationsEnabled;
    }

    private static String a(Context context) {
        String notificationChannelName = PushAgent.getInstance(context).getNotificationChannelName();
        return TextUtils.isEmpty(notificationChannelName) ? UPushNotificationChannel.DEFAULT_NOTIFICATION_CHANNEL_NAME : notificationChannelName;
    }
}
