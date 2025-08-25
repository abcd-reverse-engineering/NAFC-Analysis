package com.sina.weibo.sdk.share;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import com.sina.weibo.sdk.api.WeiboMultiMessage;
import com.sina.weibo.sdk.b.a;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class ShareTransActivity extends BaseActivity {
    private Intent t;
    private FrameLayout u;
    private d v;
    private String w;
    private Handler x = new Handler(Looper.getMainLooper()) { // from class: com.sina.weibo.sdk.share.ShareTransActivity.1
        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == 1) {
                Object obj = message.obj;
                if (obj instanceof Intent) {
                    ShareTransActivity.this.b((Intent) obj);
                    return;
                }
            }
            ShareTransActivity.this.j();
        }
    };

    private static void c(Intent intent) {
        if (intent == null || intent.getFlags() == 0) {
            return;
        }
        int flags = intent.getFlags();
        String binaryString = Integer.toBinaryString(flags);
        ArrayList arrayList = new ArrayList();
        if (Build.VERSION.SDK_INT >= 19) {
            arrayList.add(64);
        }
        if (Build.VERSION.SDK_INT >= 21) {
            arrayList.add(128);
        }
        arrayList.add(1);
        arrayList.add(2);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            flags &= ~((Integer) it.next()).intValue();
        }
        com.sina.weibo.sdk.b.c.a("WBShareTag", "clear flags: " + binaryString + "->" + Integer.toBinaryString(flags));
        intent.setFlags(flags);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        FrameLayout frameLayout = this.u;
        if (frameLayout != null) {
            frameLayout.setVisibility(8);
        }
        Handler handler = this.x;
        if (handler != null) {
            handler.removeMessages(0);
            this.x = null;
        }
        try {
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putInt("_weibo_resp_errcode", 1);
            intent.putExtras(bundle);
            setResult(-1, intent);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        finish();
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        com.sina.weibo.sdk.b.c.a("WBShareTag", "onActivityResult. Means share result coming!");
        Handler handler = this.x;
        if (handler != null) {
            if (i3 != -1) {
                handler.sendEmptyMessageDelayed(0, 100L);
                return;
            }
            Message messageObtain = Message.obtain(handler, 1);
            messageObtain.obj = intent;
            this.x.sendMessageDelayed(messageObtain, 100L);
        }
    }

    @Override // com.sina.weibo.sdk.share.BaseActivity, android.app.Activity
    protected void onCreate(Bundle bundle) throws NoSuchFieldException {
        super.onCreate(bundle);
        com.sina.weibo.sdk.b.c.a("WBShareTag", "start share activity.");
        this.t = getIntent();
        Intent intent = this.t;
        if (intent == null) {
            finish();
            return;
        }
        if (intent.getIntExtra("start_flag", -1) != 1001) {
            finish();
            return;
        }
        this.u = new FrameLayout(this);
        int intExtra = getIntent().getIntExtra("progress_id", -1);
        View viewInflate = intExtra != -1 ? ((LayoutInflater) getSystemService("layout_inflater")).inflate(intExtra, (ViewGroup) null) : new ProgressBar(this);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        this.u.addView(viewInflate, layoutParams);
        this.u.setBackgroundColor(855638016);
        setContentView(this.u);
        com.sina.weibo.sdk.b.c.a("WBShareTag", "prepare wb resource.");
        Bundle extras = this.t.getExtras();
        if (extras == null) {
            finish();
            return;
        }
        WeiboMultiMessage weiboMultiMessage = new WeiboMultiMessage();
        weiboMultiMessage.readFromBundle(extras);
        if (weiboMultiMessage.multiImageObject == null && weiboMultiMessage.videoSourceObject == null) {
            a(weiboMultiMessage);
            return;
        }
        d dVar = this.v;
        if (dVar != null) {
            dVar.cancel(true);
        }
        this.v = new d(this, new b() { // from class: com.sina.weibo.sdk.share.ShareTransActivity.2
            @Override // com.sina.weibo.sdk.share.b
            public final void a(c cVar) {
                ShareTransActivity.this.u.setVisibility(4);
                if (cVar == null) {
                    ShareTransActivity.this.c("Trans result is null.");
                    return;
                }
                if (cVar.z) {
                    ShareTransActivity.this.a(cVar.A);
                } else if (TextUtils.isEmpty(cVar.errorMessage)) {
                    ShareTransActivity.this.c("Trans resource fail.");
                } else {
                    ShareTransActivity.this.c(cVar.errorMessage);
                }
            }
        });
        this.v.execute(weiboMultiMessage);
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        com.sina.weibo.sdk.b.c.a("WBShareTag", "start share activity again. Means share result coming!");
        int intExtra = intent.getIntExtra("start_flag", -1);
        if (intExtra == 1001) {
            return;
        }
        if (intExtra == 1002) {
            b(intent);
        } else {
            j();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Intent intent) {
        FrameLayout frameLayout = this.u;
        if (frameLayout != null) {
            frameLayout.setVisibility(4);
        }
        Handler handler = this.x;
        if (handler != null) {
            handler.removeMessages(0);
            this.x = null;
        }
        if (!a(intent)) {
            j();
            return;
        }
        c(intent);
        setResult(-1, intent);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(WeiboMultiMessage weiboMultiMessage) {
        com.sina.weibo.sdk.b.c.a("WBShareTag", "start wb composer");
        try {
            this.t.putExtra("start_flag", 1002);
            this.w = com.sina.weibo.sdk.b.d.f(String.valueOf((Math.random() * 10000.0d) + System.currentTimeMillis()));
            this.t.putExtra("share_back_flag", this.w);
            this.t.putExtra("share_flag_for_new_version", 1);
            Bundle extras = this.t.getExtras();
            Intent intent = new Intent("com.sina.weibo.sdk.action.ACTION_WEIBO_ACTIVITY");
            a.C0121a c0121aC = com.sina.weibo.sdk.b.a.c(this);
            if (c0121aC != null) {
                intent.setPackage(c0121aC.packageName);
            }
            intent.putExtras(weiboMultiMessage.writeToBundle(extras));
            intent.putExtra("_weibo_sdkVersion", "0041005000");
            intent.putExtra("_weibo_appPackage", getPackageName());
            intent.putExtra("_weibo_appKey", com.sina.weibo.sdk.a.a().getAppKey());
            intent.putExtra("_weibo_flag", 538116905);
            intent.putExtra("_weibo_sign", com.sina.weibo.sdk.b.d.f(com.sina.weibo.sdk.b.e.b(this, getPackageName())));
            String stringExtra = this.t.getStringExtra("start_web_activity");
            if (!TextUtils.isEmpty(stringExtra) && "com.sina.weibo.sdk.web.WebActivity".equals(stringExtra)) {
                intent.setClassName(this, stringExtra);
                startActivityForResult(intent, 10001);
            } else {
                if (com.sina.weibo.sdk.a.a(this)) {
                    if (c0121aC != null) {
                        intent.setPackage(c0121aC.packageName);
                    }
                    startActivityForResult(intent, 10001);
                    return;
                }
                c("Start weibo client's composer fail. And Weibo client is not installed.");
            }
        } catch (Throwable th) {
            com.sina.weibo.sdk.b.c.b("WBShareTag", "start wb composer fail," + th.getMessage());
            c("Start weibo client's composer fail. " + th.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str) {
        FrameLayout frameLayout = this.u;
        if (frameLayout != null) {
            frameLayout.setVisibility(4);
        }
        Handler handler = this.x;
        if (handler != null) {
            handler.removeMessages(0);
            this.x = null;
        }
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putInt("_weibo_resp_errcode", 2);
        bundle.putString("_weibo_resp_errstr", str);
        intent.putExtras(bundle);
        setResult(-1, intent);
        finish();
    }

    private boolean a(Intent intent) {
        if (TextUtils.isEmpty(this.w) || intent == null || !intent.getExtras().containsKey("share_back_flag")) {
            return false;
        }
        return TextUtils.equals(this.w, intent.getStringExtra("share_back_flag"));
    }
}
