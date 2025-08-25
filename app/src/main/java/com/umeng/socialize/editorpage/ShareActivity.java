package com.umeng.socialize.editorpage;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.umeng.socialize.bean.HandlerRequestCode;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.common.ResContainer;
import com.umeng.socialize.common.SocializeConstants;
import com.umeng.socialize.utils.SLog;
import com.umeng.socialize.utils.SocializeUtils;
import com.umeng.socialize.utils.UmengText;
import java.io.File;

/* loaded from: classes2.dex */
public class ShareActivity extends Activity implements View.OnClickListener {

    /* renamed from: c, reason: collision with root package name */
    private static final String f11674c = "ShareActivity";

    /* renamed from: d, reason: collision with root package name */
    private static int f11675d = 140;

    /* renamed from: a, reason: collision with root package name */
    protected ImageView f11676a;

    /* renamed from: f, reason: collision with root package name */
    private String f11679f;

    /* renamed from: g, reason: collision with root package name */
    private String f11680g;

    /* renamed from: h, reason: collision with root package name */
    private String f11681h;

    /* renamed from: i, reason: collision with root package name */
    private ResContainer f11682i;

    /* renamed from: j, reason: collision with root package name */
    private EditText f11683j;

    /* renamed from: k, reason: collision with root package name */
    private TextView f11684k;

    /* renamed from: l, reason: collision with root package name */
    private Context f11685l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f11686m;
    private SHARE_MEDIA n;
    private ImageView p;
    private TextView q;

    /* renamed from: e, reason: collision with root package name */
    private String f11678e = "7.3.2";
    private boolean o = false;

    /* renamed from: b, reason: collision with root package name */
    TextWatcher f11677b = new TextWatcher() { // from class: com.umeng.socialize.editorpage.ShareActivity.1
        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            ShareActivity shareActivity = ShareActivity.this;
            shareActivity.f11686m = shareActivity.e();
        }
    };

    private String b(String str) {
        return str.equals("TENCENT") ? getResources().getString(this.f11682i.string("umeng_socialize_sharetotencent")) : str.equals("RENREN") ? getResources().getString(this.f11682i.string("umeng_socialize_sharetorenren")) : str.equals("DOUBAN") ? getResources().getString(this.f11682i.string("umeng_socialize_sharetodouban")) : str.equals("TWITTER") ? getResources().getString(this.f11682i.string("umeng_socialize_sharetotwitter")) : str.equals("LINKEDIN") ? getResources().getString(this.f11682i.string("umeng_socialize_sharetolinkin")) : getResources().getString(this.f11682i.string("umeng_socialize_sharetosina"));
    }

    private void c() {
        SHARE_MEDIA share_media;
        String string = this.f11683j.getText().toString();
        if (TextUtils.isEmpty(string.trim()) && this.n == SHARE_MEDIA.SINA && (TextUtils.isEmpty(this.f11681h) || this.f11681h.equals("web") || this.f11681h.equals("video") || this.f11681h.equals("music"))) {
            Toast.makeText(this.f11685l, UmengText.SHARE.CONTEXT_EMPTY, 0).show();
            return;
        }
        if (SocializeUtils.countContentLength(string) <= f11675d || (share_media = this.n) == SHARE_MEDIA.TWITTER || share_media == SHARE_MEDIA.LINKEDIN) {
            if (this.f11686m && this.n != SHARE_MEDIA.TWITTER) {
                Toast.makeText(this.f11685l, UmengText.SHARE.CONTEXT_LONG, 0).show();
                return;
            }
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putString(SocializeConstants.KEY_TEXT, string);
            bundle.putString("pic", this.f11681h);
            intent.putExtras(bundle);
            setResult(-1, intent);
            a();
        }
    }

    private void d() {
        this.f11681h = null;
        findViewById(this.f11682i.id("root")).setBackgroundColor(Color.parseColor("#D4E0E5"));
        findViewById(this.f11682i.id("umeng_socialize_share_bottom_area")).setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean e() {
        int iCountContentLength = f11675d - SocializeUtils.countContentLength(this.f11683j.getText().toString());
        this.f11684k.setText(SocializeUtils.countContentLength(this.f11683j.getText().toString()) + "/" + f11675d);
        return iCountContentLength < 0;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (!SocializeConstants.BACKKEY_COMPLETE_CLOSE || keyEvent.getKeyCode() != 4) {
            return super.dispatchKeyEvent(keyEvent);
        }
        new Handler().postDelayed(new Runnable() { // from class: com.umeng.socialize.editorpage.ShareActivity.2
            @Override // java.lang.Runnable
            public void run() {
                ShareActivity.this.setResult(1000);
                ShareActivity.this.finish();
            }
        }, 400L);
        return true;
    }

    public void onCancel(View view) {
        setResult(1000);
        a();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == this.f11682i.id("umeng_back")) {
            onCancel(view);
        } else if (id == this.f11682i.id("umeng_share_btn")) {
            c();
        } else if (id == this.f11682i.id("umeng_del")) {
            d();
        }
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        this.f11682i = ResContainer.get(this);
        this.o = SocializeUtils.isFloatWindowStyle(this);
        super.onCreate(bundle);
        this.f11685l = this;
        setContentView(this.f11682i.layout("umeng_socialize_share"));
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.softInputMode = 32;
        if (this.o) {
            int[] floatWindowSize = SocializeUtils.getFloatWindowSize(this.f11685l);
            attributes.width = floatWindowSize[0];
            attributes.height = floatWindowSize[1];
        }
        getWindow().setAttributes(attributes);
        SLog.E(UmengText.SHARE.SHAREVIEWV + this.f11678e);
        Bundle extras = getIntent().getExtras();
        this.n = a(extras.getString(SocializeConstants.KEY_PLATFORM));
        f11675d = HandlerRequestCode.TWITTER_REQUEST_AUTH_CODE;
        this.f11679f = extras.getString(SocializeConstants.KEY_TEXT);
        this.f11681h = extras.getString("pic");
        this.f11680g = extras.getString("title");
        b();
        this.p = (ImageView) findViewById(this.f11682i.id("umeng_del"));
        this.f11683j.addTextChangedListener(this.f11677b);
        ((TextView) findViewById(this.f11682i.id("umeng_title"))).setText(b(extras.getString(SocializeConstants.KEY_PLATFORM)));
        findViewById(this.f11682i.id("umeng_back")).setOnClickListener(this);
        findViewById(this.f11682i.id("umeng_share_btn")).setOnClickListener(this);
        this.p.setOnClickListener(this);
        this.f11684k = (TextView) findViewById(this.f11682i.id("umeng_socialize_share_word_num"));
        this.f11686m = e();
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 == 4 && keyEvent.getRepeatCount() == 0) {
            setResult(1000);
        }
        return super.onKeyDown(i2, keyEvent);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        return super.onKeyUp(i2, keyEvent);
    }

    @Override // android.app.Activity
    protected void onResume() {
        this.f11683j.requestFocus();
        super.onResume();
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
    }

    private SHARE_MEDIA a(String str) {
        if (str.equals("DOUBAN")) {
            return SHARE_MEDIA.DOUBAN;
        }
        if (str.equals("TWITTER")) {
            return SHARE_MEDIA.TWITTER;
        }
        if (str.equals("LINKEDIN")) {
            return SHARE_MEDIA.LINKEDIN;
        }
        return SHARE_MEDIA.SINA;
    }

    protected void a() {
        finish();
    }

    private void b() {
        this.f11683j = (EditText) findViewById(this.f11682i.id("umeng_socialize_share_edittext"));
        if (!TextUtils.isEmpty(this.f11679f)) {
            this.f11683j.setText(this.f11679f);
            this.f11683j.setSelection(this.f11679f.length());
        }
        this.q = (TextView) findViewById(this.f11682i.id("umeng_web_title"));
        this.f11676a = (ImageView) findViewById(this.f11682i.id("umeng_share_icon"));
        if (this.f11681h != null) {
            findViewById(this.f11682i.id("umeng_socialize_share_bottom_area")).setVisibility(0);
            this.f11676a = (ImageView) findViewById(this.f11682i.id("umeng_share_icon"));
            this.f11676a.setVisibility(0);
            if (this.f11681h.equals("video")) {
                this.f11676a.setImageResource(ResContainer.getResourceId(this.f11685l, "drawable", "umeng_socialize_share_video"));
            } else if (this.f11681h.equals("music")) {
                this.f11676a.setImageResource(ResContainer.getResourceId(this.f11685l, "drawable", "umeng_socialize_share_music"));
            } else if (this.f11681h.equals("web")) {
                this.f11676a.setImageResource(ResContainer.getResourceId(this.f11685l, "drawable", "umeng_socialize_share_web"));
            } else {
                this.f11676a.setImageURI(Uri.fromFile(new File(this.f11681h)));
            }
            if (!TextUtils.isEmpty(this.f11680g)) {
                this.q.setVisibility(0);
                this.q.setText(this.f11680g);
            }
            findViewById(this.f11682i.id("root")).setBackgroundColor(-1);
            return;
        }
        if (TextUtils.isEmpty(this.f11680g)) {
            return;
        }
        this.f11676a.setImageResource(ResContainer.getResourceId(this.f11685l, "drawable", "umeng_socialize_share_web"));
        this.q.setVisibility(0);
        this.q.setText(this.f11680g);
    }
}
