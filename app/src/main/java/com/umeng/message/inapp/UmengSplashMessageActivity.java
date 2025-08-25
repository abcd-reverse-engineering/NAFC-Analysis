package com.umeng.message.inapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.umeng.commonsdk.debug.UMLog;
import com.umeng.message.entity.UInAppMessage;
import com.umeng.message.proguard.ad;
import com.umeng.message.proguard.af;
import com.umeng.message.proguard.ah;
import com.umeng.message.proguard.ai;
import com.umeng.message.proguard.bb;
import com.umeng.message.proguard.f;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.io.File;
import java.util.Calendar;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class UmengSplashMessageActivity extends Activity {

    /* renamed from: a, reason: collision with root package name */
    private static final String f11195a = UmengSplashMessageActivity.class.getName();
    private static int s = 2000;
    private static int t = 1000;

    /* renamed from: b, reason: collision with root package name */
    private Activity f11196b;

    /* renamed from: c, reason: collision with root package name */
    private af f11197c;

    /* renamed from: d, reason: collision with root package name */
    private ImageView f11198d;

    /* renamed from: e, reason: collision with root package name */
    private ImageView f11199e;

    /* renamed from: f, reason: collision with root package name */
    private TextView f11200f;

    /* renamed from: i, reason: collision with root package name */
    private a f11203i;

    /* renamed from: j, reason: collision with root package name */
    private a f11204j;

    /* renamed from: k, reason: collision with root package name */
    private UInAppMessage f11205k;

    /* renamed from: l, reason: collision with root package name */
    private UInAppHandler f11206l;
    private long q;
    private long r;

    /* renamed from: g, reason: collision with root package name */
    private boolean f11201g = true;

    /* renamed from: h, reason: collision with root package name */
    private boolean f11202h = true;

    /* renamed from: m, reason: collision with root package name */
    private boolean f11207m = false;
    private boolean n = false;
    private boolean o = false;
    private boolean p = false;
    private af.a u = new af.a() { // from class: com.umeng.message.inapp.UmengSplashMessageActivity.1
        @Override // com.umeng.message.proguard.af.a
        public final void a(Bitmap[] bitmapArr) {
            if (UmengSplashMessageActivity.this.c()) {
                return;
            }
            if (UmengSplashMessageActivity.this.f11203i != null) {
                UmengSplashMessageActivity.this.f11203i.a();
                UmengSplashMessageActivity.c(UmengSplashMessageActivity.this);
            }
            try {
                if (bitmapArr.length == 1) {
                    UmengSplashMessageActivity.this.f11198d.setOnClickListener(new View.OnClickListener() { // from class: com.umeng.message.inapp.UmengSplashMessageActivity.1.1
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            UmengSplashMessageActivity.d(UmengSplashMessageActivity.this);
                            if (TextUtils.equals("none", UmengSplashMessageActivity.this.f11205k.action_type)) {
                                return;
                            }
                            UmengSplashMessageActivity.a(UmengSplashMessageActivity.this, SystemClock.elapsedRealtime() - UmengSplashMessageActivity.this.q);
                            ai.a(UmengSplashMessageActivity.this.f11196b).a(UmengSplashMessageActivity.this.f11205k.msg_id, UmengSplashMessageActivity.this.f11205k.msg_type, 1, 1, 0, 0, 0, (int) UmengSplashMessageActivity.this.r, 0);
                            UmengSplashMessageActivity.this.d();
                            UmengSplashMessageActivity.this.f11206l.handleInAppMessage(UmengSplashMessageActivity.this.f11196b, UmengSplashMessageActivity.this.f11205k, 16);
                            UmengSplashMessageActivity.this.finish();
                        }
                    });
                    UmengSplashMessageActivity.this.f11199e.setVisibility(8);
                    UmengSplashMessageActivity.this.f11198d.setImageBitmap(bitmapArr[0]);
                    UmengSplashMessageActivity.a(UmengSplashMessageActivity.this.f11198d);
                }
                if (bitmapArr.length == 2) {
                    UmengSplashMessageActivity.this.f11198d.setOnClickListener(new View.OnClickListener() { // from class: com.umeng.message.inapp.UmengSplashMessageActivity.1.2
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            UmengSplashMessageActivity.m(UmengSplashMessageActivity.this);
                            if (TextUtils.equals("none", UmengSplashMessageActivity.this.f11205k.action_type)) {
                                return;
                            }
                            UmengSplashMessageActivity.a(UmengSplashMessageActivity.this, SystemClock.elapsedRealtime() - UmengSplashMessageActivity.this.q);
                            ai.a(UmengSplashMessageActivity.this.f11196b).a(UmengSplashMessageActivity.this.f11205k.msg_id, UmengSplashMessageActivity.this.f11205k.msg_type, 1, 0, 1, UmengSplashMessageActivity.a(UmengSplashMessageActivity.this.o), 0, (int) UmengSplashMessageActivity.this.r, 0);
                            UmengSplashMessageActivity.this.d();
                            UmengSplashMessageActivity.this.f11206l.handleInAppMessage(UmengSplashMessageActivity.this.f11196b, UmengSplashMessageActivity.this.f11205k, 16);
                            UmengSplashMessageActivity.this.finish();
                        }
                    });
                    UmengSplashMessageActivity.this.f11199e.setOnClickListener(new View.OnClickListener() { // from class: com.umeng.message.inapp.UmengSplashMessageActivity.1.3
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            UmengSplashMessageActivity.o(UmengSplashMessageActivity.this);
                            if (TextUtils.equals("none", UmengSplashMessageActivity.this.f11205k.bottom_action_type)) {
                                return;
                            }
                            UmengSplashMessageActivity.a(UmengSplashMessageActivity.this, SystemClock.elapsedRealtime() - UmengSplashMessageActivity.this.q);
                            ai.a(UmengSplashMessageActivity.this.f11196b).a(UmengSplashMessageActivity.this.f11205k.msg_id, UmengSplashMessageActivity.this.f11205k.msg_type, 1, 0, UmengSplashMessageActivity.a(UmengSplashMessageActivity.this.n), 1, 0, (int) UmengSplashMessageActivity.this.r, 0);
                            UmengSplashMessageActivity.this.d();
                            UmengSplashMessageActivity.this.f11206l.handleInAppMessage(UmengSplashMessageActivity.this.f11196b, UmengSplashMessageActivity.this.f11205k, 17);
                            UmengSplashMessageActivity.this.finish();
                        }
                    });
                    UmengSplashMessageActivity.this.f11198d.setImageBitmap(bitmapArr[0]);
                    UmengSplashMessageActivity.this.f11199e.setImageBitmap(bitmapArr[1]);
                    UmengSplashMessageActivity.a(UmengSplashMessageActivity.this.f11198d);
                    UmengSplashMessageActivity.a(UmengSplashMessageActivity.this.f11199e);
                }
                UmengSplashMessageActivity.this.q = SystemClock.elapsedRealtime();
                if (UmengSplashMessageActivity.this.f11205k.display_button) {
                    UmengSplashMessageActivity.this.f11200f.setVisibility(0);
                    UmengSplashMessageActivity.this.f11200f.setOnClickListener(new View.OnClickListener() { // from class: com.umeng.message.inapp.UmengSplashMessageActivity.1.4
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            UmengSplashMessageActivity.a(UmengSplashMessageActivity.this, SystemClock.elapsedRealtime() - UmengSplashMessageActivity.this.q);
                            ai.a(UmengSplashMessageActivity.this.f11196b).a(UmengSplashMessageActivity.this.f11205k.msg_id, UmengSplashMessageActivity.this.f11205k.msg_type, 1, UmengSplashMessageActivity.a(UmengSplashMessageActivity.this.f11207m), UmengSplashMessageActivity.a(UmengSplashMessageActivity.this.n), UmengSplashMessageActivity.a(UmengSplashMessageActivity.this.o), 1, (int) UmengSplashMessageActivity.this.r, 0);
                            UmengSplashMessageActivity.this.d();
                            UmengSplashMessageActivity.this.finish();
                        }
                    });
                } else {
                    UmengSplashMessageActivity.this.f11200f.setVisibility(8);
                }
                InAppMessageManager.getInstance(UmengSplashMessageActivity.this.f11196b).a(UmengSplashMessageActivity.this.f11205k);
                InAppMessageManager.getInstance(UmengSplashMessageActivity.this.f11196b).a(UmengSplashMessageActivity.this.f11205k.msg_id, 1);
                InAppMessageManager inAppMessageManager = InAppMessageManager.getInstance(UmengSplashMessageActivity.this.f11196b);
                StringBuilder sb = new StringBuilder();
                sb.append(System.currentTimeMillis());
                inAppMessageManager.b("KEY_LAST_SHOW_SPLASH_TS", sb.toString());
                UmengSplashMessageActivity.s(UmengSplashMessageActivity.this);
                UmengSplashMessageActivity.this.f11204j = UmengSplashMessageActivity.this.new a(UmengSplashMessageActivity.this.f11205k.display_time * 1000, UmengSplashMessageActivity.t);
                UmengSplashMessageActivity.this.f11204j.b();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    };
    private final ad v = new ad() { // from class: com.umeng.message.inapp.UmengSplashMessageActivity.2
        @Override // com.umeng.message.proguard.ad
        public final void a(UInAppMessage uInAppMessage) {
            UInAppMessage uInAppMessage2;
            String strA = InAppMessageManager.getInstance(UmengSplashMessageActivity.this.f11196b).a();
            if (TextUtils.isEmpty(strA)) {
                uInAppMessage2 = null;
            } else {
                try {
                    uInAppMessage2 = new UInAppMessage(new JSONObject(strA));
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
            if (uInAppMessage != null) {
                if (uInAppMessage2 != null && !uInAppMessage.msg_id.equals(uInAppMessage2.msg_id)) {
                    InAppMessageManager.getInstance(UmengSplashMessageActivity.this.f11196b).a(new File(f.a((Context) UmengSplashMessageActivity.this.f11196b, uInAppMessage2.msg_id)));
                }
                UmengSplashMessageActivity.this.f11205k = uInAppMessage;
            } else if (uInAppMessage2 == null) {
                return;
            } else {
                UmengSplashMessageActivity.this.f11205k = uInAppMessage2;
            }
            if (UmengSplashMessageActivity.this.f11205k.show_type == 1 && !UmengSplashMessageActivity.u(UmengSplashMessageActivity.this)) {
                InAppMessageManager.getInstance(UmengSplashMessageActivity.this.f11196b).a(UmengSplashMessageActivity.this.f11205k.msg_id, 0);
            }
            InAppMessageManager.getInstance(UmengSplashMessageActivity.this.f11196b);
            if (InAppMessageManager.b(UmengSplashMessageActivity.this.f11205k) && InAppMessageManager.getInstance(UmengSplashMessageActivity.this.f11196b).c(UmengSplashMessageActivity.this.f11205k)) {
                if (UmengSplashMessageActivity.this.f11205k.msg_type == 0) {
                    UMLog.mutlInfo(UmengSplashMessageActivity.f11195a, 2, "SPLASH_A");
                    UmengSplashMessageActivity umengSplashMessageActivity = UmengSplashMessageActivity.this;
                    umengSplashMessageActivity.f11197c = new af(umengSplashMessageActivity.f11196b, UmengSplashMessageActivity.this.f11205k);
                    UmengSplashMessageActivity.this.f11197c.f11237a = UmengSplashMessageActivity.this.u;
                    UmengSplashMessageActivity.this.f11197c.execute(UmengSplashMessageActivity.this.f11205k.image_url);
                }
                if (UmengSplashMessageActivity.this.f11205k.msg_type == 1) {
                    UMLog.mutlInfo(UmengSplashMessageActivity.f11195a, 2, "SPLASH_B");
                    UmengSplashMessageActivity umengSplashMessageActivity2 = UmengSplashMessageActivity.this;
                    umengSplashMessageActivity2.f11197c = new af(umengSplashMessageActivity2.f11196b, UmengSplashMessageActivity.this.f11205k);
                    UmengSplashMessageActivity.this.f11197c.f11237a = UmengSplashMessageActivity.this.u;
                    UmengSplashMessageActivity.this.f11197c.execute(UmengSplashMessageActivity.this.f11205k.image_url, UmengSplashMessageActivity.this.f11205k.bottom_image_url);
                }
            }
        }

        @Override // com.umeng.message.proguard.ad
        public final void b(UInAppMessage uInAppMessage) {
        }
    };

    class a extends ah {
        a(long j2, long j3) {
            super(j2, j3);
        }

        @Override // com.umeng.message.proguard.ah
        public final void a(long j2) {
            if (UmengSplashMessageActivity.this.f11201g) {
                return;
            }
            UmengSplashMessageActivity.this.f11200f.setVisibility(0);
            UmengSplashMessageActivity.this.f11200f.setText(((int) Math.ceil((j2 * 1.0d) / UmengSplashMessageActivity.t)) + c.c.a.b.a.a.f3100g + UmengSplashMessageActivity.this.f11205k.display_name);
        }

        @Override // com.umeng.message.proguard.ah
        public final void e() {
            if (UmengSplashMessageActivity.this.c() && UmengSplashMessageActivity.this.f11201g) {
                return;
            }
            if (!UmengSplashMessageActivity.this.f11201g) {
                ai.a(UmengSplashMessageActivity.this.f11196b).a(UmengSplashMessageActivity.this.f11205k.msg_id, UmengSplashMessageActivity.this.f11205k.msg_type, 1, UmengSplashMessageActivity.a(UmengSplashMessageActivity.this.f11207m), UmengSplashMessageActivity.a(UmengSplashMessageActivity.this.n), UmengSplashMessageActivity.a(UmengSplashMessageActivity.this.o), 0, UmengSplashMessageActivity.this.f11205k.display_time * 1000, 0);
            }
            UmengSplashMessageActivity.this.d();
            UmengSplashMessageActivity.this.finish();
        }
    }

    static /* synthetic */ int a(boolean z) {
        return z ? 1 : 0;
    }

    static /* synthetic */ a c(UmengSplashMessageActivity umengSplashMessageActivity) {
        umengSplashMessageActivity.f11203i = null;
        return null;
    }

    static /* synthetic */ boolean d(UmengSplashMessageActivity umengSplashMessageActivity) {
        umengSplashMessageActivity.f11207m = true;
        return true;
    }

    static /* synthetic */ boolean m(UmengSplashMessageActivity umengSplashMessageActivity) {
        umengSplashMessageActivity.n = true;
        return true;
    }

    static /* synthetic */ boolean o(UmengSplashMessageActivity umengSplashMessageActivity) {
        umengSplashMessageActivity.o = true;
        return true;
    }

    static /* synthetic */ boolean s(UmengSplashMessageActivity umengSplashMessageActivity) {
        umengSplashMessageActivity.f11201g = false;
        return false;
    }

    static /* synthetic */ boolean u(UmengSplashMessageActivity umengSplashMessageActivity) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(Long.parseLong(InAppMessageManager.getInstance(umengSplashMessageActivity.f11196b).a("KEY_LAST_SHOW_SPLASH_TS", "0")));
        Calendar calendar2 = Calendar.getInstance();
        return calendar.get(6) == calendar2.get(6) && calendar.get(1) == calendar2.get(1);
    }

    @Override // android.app.Activity
    public final void onBackPressed() {
    }

    @Override // android.app.Activity
    protected final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f11196b = this;
        if ((getIntent().getFlags() & 4194304) > 0) {
            finish();
            return;
        }
        if (onCustomPretreatment()) {
            return;
        }
        setRequestedOrientation(1);
        FrameLayout frameLayout = new FrameLayout(this.f11196b);
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        LinearLayout linearLayout = new LinearLayout(this.f11196b);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        linearLayout.setOrientation(1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0, 13.0f);
        this.f11198d = new ImageView(this.f11196b);
        this.f11198d.setLayoutParams(layoutParams);
        this.f11198d.setScaleType(ImageView.ScaleType.FIT_XY);
        linearLayout.addView(this.f11198d);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, 0, 3.0f);
        this.f11199e = new ImageView(this.f11196b);
        this.f11199e.setLayoutParams(layoutParams2);
        this.f11199e.setScaleType(ImageView.ScaleType.FIT_XY);
        linearLayout.addView(this.f11199e);
        frameLayout.addView(linearLayout);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 5;
        layoutParams3.rightMargin = bb.a(30.0f);
        layoutParams3.topMargin = bb.a(20.0f);
        this.f11200f = new TextView(this.f11196b);
        this.f11200f.setLayoutParams(layoutParams3);
        int iA = bb.a(6.0f);
        int i2 = iA / 3;
        this.f11200f.setPadding(iA, i2, iA, i2);
        this.f11200f.setTextSize(14.0f);
        this.f11200f.setBackgroundColor(Color.parseColor("#80000000"));
        this.f11200f.setTextColor(-1);
        this.f11200f.setVisibility(8);
        frameLayout.addView(this.f11200f);
        setContentView(frameLayout);
        if (!InAppMessageManager.f11149a && System.currentTimeMillis() - Long.parseLong(InAppMessageManager.getInstance(this.f11196b).a("KEY_SPLASH_TS", "0")) <= InAppMessageManager.f11150d) {
            this.v.a(null);
        } else {
            ai.a(this).a(this.v);
        }
        this.f11206l = InAppMessageManager.getInstance(this.f11196b).getInAppHandler();
        this.f11203i = new a(s, t);
        this.f11203i.b();
    }

    public boolean onCustomPretreatment() {
        return false;
    }

    @Override // android.app.Activity
    protected final void onDestroy() {
        a aVar = this.f11203i;
        if (aVar != null) {
            aVar.a();
        }
        a aVar2 = this.f11204j;
        if (aVar2 != null) {
            aVar2.a();
        }
        af afVar = this.f11197c;
        if (afVar != null) {
            afVar.f11237a = null;
        }
        this.p = false;
        this.f11207m = false;
        this.n = false;
        this.o = false;
        super.onDestroy();
    }

    @Override // android.app.Activity
    protected final void onPause() {
        super.onPause();
        a aVar = this.f11203i;
        if (aVar != null) {
            aVar.c();
        }
        if (this.f11204j != null) {
            this.r += SystemClock.elapsedRealtime() - this.q;
            this.f11204j.c();
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        a aVar = this.f11203i;
        if (aVar != null) {
            aVar.d();
        }
        if (this.f11204j != null) {
            this.q = SystemClock.elapsedRealtime();
            this.f11204j.d();
        }
    }

    @Override // android.app.Activity
    protected final void onStart() {
        super.onStart();
    }

    static /* synthetic */ long a(UmengSplashMessageActivity umengSplashMessageActivity, long j2) {
        long j3 = umengSplashMessageActivity.r + j2;
        umengSplashMessageActivity.r = j3;
        return j3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean c() {
        boolean z;
        z = this.p;
        this.p = true;
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void d() {
        if (this.f11202h) {
            this.f11202h = false;
            Intent intent = new Intent();
            intent.setClassName(this.f11196b, InAppMessageManager.getInstance(this).f11154c);
            intent.setFlags(CommonNetImpl.FLAG_SHARE);
            try {
                this.f11196b.startActivity(intent);
            } catch (Exception unused) {
            }
        }
    }

    static /* synthetic */ void a(View view) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.3f, 1.0f);
        alphaAnimation.setDuration(500L);
        view.startAnimation(alphaAnimation);
    }

    @Override // android.app.Activity
    public final void onCreate(Bundle bundle, PersistableBundle persistableBundle) {
        super.onCreate(bundle, persistableBundle);
    }
}
