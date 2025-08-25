package com.umeng.message.inapp;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import com.umeng.commonsdk.debug.UMLog;
import com.umeng.message.common.UPLog;
import com.umeng.message.entity.UInAppMessage;
import com.umeng.message.proguard.ae;
import com.umeng.message.proguard.ag;
import com.umeng.message.proguard.ai;
import com.umeng.message.proguard.aq;
import com.umeng.message.proguard.b;
import com.umeng.message.proguard.f;
import com.umeng.message.proguard.h;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

/* loaded from: classes2.dex */
public class InAppMessageManager {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f11149a = false;

    /* renamed from: d, reason: collision with root package name */
    public static int f11150d = 1800000;

    /* renamed from: e, reason: collision with root package name */
    public static int f11151e = 1000;

    /* renamed from: f, reason: collision with root package name */
    private static InAppMessageManager f11152f;

    /* renamed from: b, reason: collision with root package name */
    public final Context f11153b;

    /* renamed from: c, reason: collision with root package name */
    String f11154c;

    /* renamed from: h, reason: collision with root package name */
    private final aq f11156h = new aq("in_app");

    /* renamed from: g, reason: collision with root package name */
    private UInAppHandler f11155g = new UmengInAppClickHandler();

    private InAppMessageManager(Context context) {
        this.f11153b = context.getApplicationContext();
    }

    private int d(String str) {
        return Integer.parseInt(a(str, "0"));
    }

    public static InAppMessageManager getInstance(Context context) {
        if (f11152f == null) {
            synchronized (InAppMessageManager.class) {
                if (f11152f == null) {
                    f11152f = new InAppMessageManager(context);
                }
            }
        }
        return f11152f;
    }

    public final long c(String str) {
        return Long.parseLong(a("KEY_LAST_SHOW_CARD_TS_".concat(String.valueOf(str)), "0"));
    }

    public UInAppHandler getInAppHandler() {
        return this.f11155g;
    }

    public void setInAppHandler(UInAppHandler uInAppHandler) {
        this.f11155g = uInAppHandler;
    }

    public void setInAppMsgDebugMode(boolean z) {
        f11149a = z;
    }

    public void setMainActivityPath(String str) {
        this.f11154c = str;
    }

    public void setPlainTextSize(int i2, int i3, int i4) {
        if (i2 <= 0 || i3 <= 0 || i4 <= 0) {
            UMLog.mutlInfo("InAppMessageManager", 0, "纯文本字体大小不能小于0");
            return;
        }
        b("KEY_PLAIN_TEXT_SIZE", i2 + Constants.ACCEPT_TIME_SEPARATOR_SP + i3 + Constants.ACCEPT_TIME_SEPARATOR_SP + i4);
    }

    public void showCardMessage(Activity activity, String str, IUmengInAppMsgCloseCallback iUmengInAppMsgCloseCallback) {
        if (f.b()) {
            UPLog.d("InAppMessageManager", "showCardMessage failed, silent mode!");
            return;
        }
        ag agVar = new ag(activity, str, iUmengInAppMsgCloseCallback);
        if (TextUtils.isEmpty(agVar.f11242c.trim())) {
            UMLog.mutlInfo(ag.f11240a, 0, "插屏消息的标签不能为空");
            return;
        }
        if (!agVar.a(agVar.f11242c)) {
            UMLog.mutlInfo(ag.f11240a, 0, "插屏消息的最大标签数为 10");
            return;
        }
        if (f11149a) {
            ai.a(agVar.f11241b).a(agVar.f11242c, agVar);
        } else if (System.currentTimeMillis() - Long.parseLong(getInstance(agVar.f11241b).a("KEY_CARD_TS_".concat(String.valueOf(agVar.f11242c)), "0")) > f11150d) {
            ai.a(agVar.f11241b).a(agVar.f11242c, agVar);
        } else {
            agVar.b((UInAppMessage) null);
        }
    }

    public final void a(UInAppMessage uInAppMessage) {
        if (uInAppMessage == null) {
            b("KEY_LAST_SPLASH_ID", "");
        } else if (uInAppMessage.getRaw() != null) {
            b("KEY_LAST_SPLASH_ID", uInAppMessage.getRaw().toString());
        }
    }

    public final void b(String str) {
        String strConcat = "KEY_LAST_SHOW_CARD_TS_".concat(String.valueOf(str));
        StringBuilder sb = new StringBuilder();
        sb.append(System.currentTimeMillis());
        b(strConcat, sb.toString());
    }

    public final boolean c(UInAppMessage uInAppMessage) {
        return uInAppMessage.show_times == 0 || d(uInAppMessage.msg_id) < uInAppMessage.show_times;
    }

    public static boolean b(UInAppMessage uInAppMessage) {
        try {
            return System.currentTimeMillis() < new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA).parse(uInAppMessage.expire_time).getTime();
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public final String a() {
        return a("KEY_LAST_SPLASH_ID", "");
    }

    public final void a(UInAppMessage uInAppMessage, String str) {
        if (uInAppMessage == null) {
            b("KEY_LAST_CARD_ID_".concat(String.valueOf(str)), "");
        } else if (uInAppMessage.getRaw() != null) {
            b("KEY_LAST_CARD_ID_".concat(String.valueOf(str)), uInAppMessage.getRaw().toString());
        }
    }

    public final ArrayList<ae> b() {
        ArrayList<ae> arrayList = new ArrayList<>();
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = this.f11153b.getContentResolver().query(h.e(this.f11153b), null, null, null, null);
                for (boolean zMoveToFirst = cursorQuery != null ? cursorQuery.moveToFirst() : false; zMoveToFirst; zMoveToFirst = cursorQuery.moveToNext()) {
                    arrayList.add(new ae(cursorQuery));
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                if (cursorQuery != null) {
                }
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            return arrayList;
        } catch (Throwable th) {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            throw th;
        }
    }

    public final String a(String str) {
        return a("KEY_LAST_CARD_ID_".concat(String.valueOf(str)), "");
    }

    public final void a(String str, int i2) {
        if (i2 == 0) {
            b(str, "0");
        }
        if (i2 == 1) {
            b(str, String.valueOf(d(str) + 1));
        }
    }

    public final String a(String str, String str2) {
        return this.f11156h.b(str, str2);
    }

    public final void a(final File file) {
        b.c(new Runnable() { // from class: com.umeng.message.inapp.InAppMessageManager.3
            @Override // java.lang.Runnable
            public final void run() {
                File file2 = file;
                if (file2 != null && file2.exists() && file.canWrite() && file.isDirectory()) {
                    for (File file3 : file.listFiles()) {
                        if (!file3.isDirectory()) {
                            file3.delete();
                        }
                    }
                    file.delete();
                }
            }
        });
    }

    static /* synthetic */ ae a(InAppMessageManager inAppMessageManager, String str) {
        Cursor cursorQuery = inAppMessageManager.f11153b.getContentResolver().query(h.e(inAppMessageManager.f11153b), null, "MsgId=?", new String[]{str}, null);
        ae aeVar = cursorQuery != null ? cursorQuery.moveToFirst() : false ? new ae(cursorQuery) : null;
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        return aeVar;
    }

    public final void b(final String str, final String str2) {
        b.c(new Runnable() { // from class: com.umeng.message.inapp.InAppMessageManager.2
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    InAppMessageManager.this.f11156h.a(str, str2);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
    }
}
