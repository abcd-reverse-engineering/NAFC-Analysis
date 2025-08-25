package com.hicorenational.antifraud.service;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Build;
import android.os.IBinder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import com.hicorenational.antifraud.R;
import manager.FloatingWindow;
import manager.IFloatingWindow;
import manager.NotificationHelper;
import util.n1;

/* loaded from: classes.dex */
public class WarnGuidService extends Service {
    public static final String w = "extra_warn_guide_content";
    public static int x = 1;

    /* renamed from: a, reason: collision with root package name */
    TextView f5963a;

    /* renamed from: b, reason: collision with root package name */
    TextView f5964b;

    /* renamed from: c, reason: collision with root package name */
    ImageView f5965c;

    /* renamed from: d, reason: collision with root package name */
    View f5966d;

    /* renamed from: e, reason: collision with root package name */
    View f5967e;

    /* renamed from: f, reason: collision with root package name */
    TextView f5968f;

    /* renamed from: g, reason: collision with root package name */
    View f5969g;

    /* renamed from: h, reason: collision with root package name */
    IFloatingWindow f5970h;

    /* renamed from: i, reason: collision with root package name */
    WindowManager.LayoutParams f5971i;

    /* renamed from: j, reason: collision with root package name */
    private WindowManager f5972j;

    /* renamed from: k, reason: collision with root package name */
    private float f5973k;

    /* renamed from: l, reason: collision with root package name */
    private float f5974l;

    /* renamed from: m, reason: collision with root package name */
    private float f5975m;
    private float n;
    private float o;
    private float p;
    private int q;
    private int r;
    private NotificationManager s;
    private String t = "appid";
    private String u = NotificationHelper.CHANEL_NAME;
    private View.OnTouchListener v = new a();

    class a implements View.OnTouchListener {
        a() {
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x0016  */
        @Override // android.view.View.OnTouchListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public boolean onTouch(android.view.View r3, android.view.MotionEvent r4) {
            /*
                r2 = this;
                int r3 = r4.getAction()
                r0 = 1
                if (r3 == 0) goto L1c
                if (r3 == r0) goto L16
                r1 = 2
                if (r3 == r1) goto L10
                r4 = 3
                if (r3 == r4) goto L16
                goto L21
            L10:
                com.hicorenational.antifraud.service.WarnGuidService r3 = com.hicorenational.antifraud.service.WarnGuidService.this
                com.hicorenational.antifraud.service.WarnGuidService.b(r3, r4)
                goto L21
            L16:
                com.hicorenational.antifraud.service.WarnGuidService r3 = com.hicorenational.antifraud.service.WarnGuidService.this
                com.hicorenational.antifraud.service.WarnGuidService.a(r3)
                goto L21
            L1c:
                com.hicorenational.antifraud.service.WarnGuidService r3 = com.hicorenational.antifraud.service.WarnGuidService.this
                com.hicorenational.antifraud.service.WarnGuidService.a(r3, r4)
            L21:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.hicorenational.antifraud.service.WarnGuidService.a.onTouch(android.view.View, android.view.MotionEvent):boolean");
        }
    }

    public class b extends Binder {
        public b() {
        }

        public WarnGuidService a() {
            return WarnGuidService.this;
        }
    }

    private Notification c() {
        Notification.Builder contentText = new Notification.Builder(this).setSmallIcon(R.mipmap.logo).setContentTitle(NotificationHelper.CHANEL_NAME).setContentText("打击防范网络诈骗");
        if (Build.VERSION.SDK_INT < 26) {
            return contentText.build();
        }
        this.s.createNotificationChannel(new NotificationChannel(this.t, this.u, 4));
        return new Notification.Builder(getApplicationContext(), this.t).build();
    }

    private void d() {
        if (Build.VERSION.SDK_INT >= 18) {
            startForeground(x, c());
        } else {
            startForeground(x, new Notification());
        }
    }

    private void e() {
        try {
            this.f5972j.updateViewLayout(this.f5969g, this.f5971i);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        n1.c(a.a.u.a.n, "WarnGuidService-----------------------onBind");
        return new b();
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.f5972j = (WindowManager) getSystemService("window");
        this.s = (NotificationManager) getSystemService("notification");
        d();
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        n1.c(a.a.u.a.n, "服务onDestroy-----------------------    ");
        IFloatingWindow iFloatingWindow = this.f5970h;
        if (iFloatingWindow != null) {
            iFloatingWindow.removeAll();
            this.f5970h.dismiss();
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i2, int i3) {
        String stringExtra;
        try {
            stringExtra = intent.getStringExtra(w);
        } catch (Exception e2) {
            e2.printStackTrace();
            stringExtra = "";
        }
        if (TextUtils.isEmpty(stringExtra)) {
            stringExtra = "请进入相应设置";
        }
        a(stringExtra);
        return super.onStartCommand(intent, i2, i3);
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        n1.c(a.a.u.a.n, "WarnGuidService-----------------------onUnbind");
        return super.onUnbind(intent);
    }

    public /* synthetic */ void b(View view) {
        this.f5966d.setVisibility(0);
        this.f5967e.setVisibility(8);
    }

    private void a(String str) {
        this.f5970h = new FloatingWindow(this);
        this.f5971i = this.f5970h.getWarnGuideLayoutParams();
        this.f5970h.setParams(this.f5971i);
        this.f5969g = LayoutInflater.from(this).inflate(R.layout.layout_warn_guide, (ViewGroup) null);
        this.f5966d = this.f5969g.findViewById(R.id.layout_open);
        this.f5967e = this.f5969g.findViewById(R.id.layout_close);
        this.f5963a = (TextView) this.f5969g.findViewById(R.id.tv_scale_open);
        this.f5964b = (TextView) this.f5969g.findViewById(R.id.tv_scale_close);
        this.f5965c = (ImageView) this.f5969g.findViewById(R.id.iv_close);
        this.f5968f = (TextView) this.f5969g.findViewById(R.id.tv_guide);
        if (!TextUtils.isEmpty(str)) {
            this.f5968f.setText(str);
        }
        this.f5969g.setOnTouchListener(this.v);
        this.q = this.f5972j.getDefaultDisplay().getWidth();
        this.r = this.f5972j.getDefaultDisplay().getHeight();
        this.f5964b.setOnClickListener(new View.OnClickListener() { // from class: com.hicorenational.antifraud.service.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f5980a.a(view);
            }
        });
        this.f5963a.setOnClickListener(new View.OnClickListener() { // from class: com.hicorenational.antifraud.service.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f5982a.b(view);
            }
        });
        this.f5965c.setOnClickListener(new View.OnClickListener() { // from class: com.hicorenational.antifraud.service.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f5981a.c(view);
            }
        });
        this.f5970h.setContentView(this.f5969g);
        this.f5970h.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(MotionEvent motionEvent) {
        this.f5973k = motionEvent.getRawX();
        this.f5974l = motionEvent.getRawY();
        String str = "mXInView====" + this.o;
        String str2 = "mXInScreen====" + this.f5973k;
        WindowManager.LayoutParams layoutParams = this.f5971i;
        layoutParams.x = (int) this.f5973k;
        layoutParams.y = ((int) (this.f5974l - this.p)) - (this.f5969g.getHeight() / 2);
        e();
    }

    public /* synthetic */ void c(View view) {
        this.f5970h.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        a();
    }

    public /* synthetic */ void a(View view) {
        this.f5966d.setVisibility(8);
        this.f5967e.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(MotionEvent motionEvent) {
        this.o = motionEvent.getX();
        this.p = motionEvent.getY();
        this.f5975m = motionEvent.getRawX();
        this.n = motionEvent.getRawY();
        this.f5973k = motionEvent.getRawX();
        this.f5974l = motionEvent.getRawY();
    }

    private void a() {
        String str = "wmParams.x ====" + this.f5971i.x;
        String str2 = "mScreenWidth====" + this.q;
        int i2 = this.f5971i.x;
        if (i2 > 0 && i2 < this.q) {
            e();
            return;
        }
        if (Math.abs(this.f5971i.x) < 0) {
            this.f5971i.x = 0;
        } else {
            int iAbs = Math.abs(this.f5971i.x);
            int i3 = this.q;
            if (iAbs > i3) {
                this.f5971i.x = i3;
            }
        }
        e();
    }
}
