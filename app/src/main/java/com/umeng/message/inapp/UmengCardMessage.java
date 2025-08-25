package com.umeng.message.inapp;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.connect.common.Constants;
import com.umeng.message.entity.UInAppMessage;
import com.umeng.message.proguard.a;
import com.umeng.message.proguard.ai;
import com.umeng.message.proguard.bb;
import com.umeng.message.proguard.bd;
import com.umeng.message.proguard.f;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class UmengCardMessage extends DialogFragment {

    /* renamed from: b, reason: collision with root package name */
    private static final String f11172b = UmengCardMessage.class.getName();

    /* renamed from: a, reason: collision with root package name */
    public IUmengInAppMsgCloseCallback f11173a;

    /* renamed from: c, reason: collision with root package name */
    private Activity f11174c;

    /* renamed from: d, reason: collision with root package name */
    private UInAppMessage f11175d;

    /* renamed from: e, reason: collision with root package name */
    private String f11176e;

    /* renamed from: f, reason: collision with root package name */
    private Bitmap f11177f;

    /* renamed from: g, reason: collision with root package name */
    private ViewGroup f11178g;

    /* renamed from: h, reason: collision with root package name */
    private int f11179h;

    /* renamed from: i, reason: collision with root package name */
    private int f11180i;

    /* renamed from: j, reason: collision with root package name */
    private int f11181j;

    /* renamed from: k, reason: collision with root package name */
    private int f11182k;

    /* renamed from: l, reason: collision with root package name */
    private UInAppHandler f11183l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f11184m = false;
    private boolean n = false;
    private boolean o = false;
    private boolean p = false;
    private String[] q = {"18", Constants.VIA_REPORT_TYPE_START_WAP, Constants.VIA_REPORT_TYPE_START_WAP};

    static /* synthetic */ boolean a(UmengCardMessage umengCardMessage) {
        umengCardMessage.n = true;
        return true;
    }

    static /* synthetic */ boolean e(UmengCardMessage umengCardMessage) {
        umengCardMessage.p = true;
        return true;
    }

    static /* synthetic */ boolean f(UmengCardMessage umengCardMessage) {
        umengCardMessage.o = true;
        return true;
    }

    @Override // android.app.Fragment, android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.f11178g != null) {
            RelativeLayout.LayoutParams layoutParams = configuration.orientation == 1 ? new RelativeLayout.LayoutParams(-1, -2) : new RelativeLayout.LayoutParams(-2, -1);
            int iA = bb.a(30.0f);
            int iA2 = bb.a(15.0f);
            layoutParams.setMargins(iA, iA2, iA, iA2);
            layoutParams.addRule(13);
            this.f11178g.setLayoutParams(layoutParams);
        }
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(2, R.style.Theme.NoTitleBar);
        setRetainInstance(true);
        try {
            this.f11174c = getActivity();
            Bundle arguments = getArguments();
            this.f11175d = new UInAppMessage(new JSONObject(arguments.getString("msg")));
            this.f11176e = arguments.getString("label");
            byte[] byteArray = arguments.getByteArray("bitmapByte");
            if (byteArray != null) {
                this.f11177f = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
            }
            this.f11183l = InAppMessageManager.getInstance(this.f11174c).getInAppHandler();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        int i2 = this.f11175d.msg_type;
        if (i2 == 5 || i2 == 6) {
            String strA = InAppMessageManager.getInstance(this.f11174c).a("KEY_PLAIN_TEXT_SIZE", "");
            String[] strArrSplit = !TextUtils.isEmpty(strA) ? strA.split(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP) : null;
            if (strArrSplit != null) {
                this.q = strArrSplit;
            }
        }
    }

    @Override // android.app.DialogFragment
    public final Dialog onCreateDialog(Bundle bundle) {
        Dialog dialogOnCreateDialog = super.onCreateDialog(bundle);
        dialogOnCreateDialog.requestWindowFeature(1);
        return dialogOnCreateDialog;
    }

    @Override // android.app.Fragment
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Rect rect;
        Window window = getDialog().getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
            rect = new Rect();
            window.getDecorView().getWindowVisibleDisplayFrame(rect);
            this.f11180i = rect.height() - bb.a(65.0f);
            this.f11179h = (int) (this.f11180i * 1.2d);
            this.f11181j = rect.width() - bb.a(70.0f);
            this.f11182k = (this.f11181j / 2) * 3;
        } else {
            rect = null;
        }
        int i2 = this.f11175d.msg_type;
        if (i2 == 2 || i2 == 3) {
            RelativeLayout relativeLayout = new RelativeLayout(this.f11174c);
            relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            relativeLayout.setBackgroundColor(Color.parseColor("#33000000"));
            RelativeLayout.LayoutParams layoutParams = getResources().getConfiguration().orientation == 1 ? new RelativeLayout.LayoutParams(-1, -2) : this.f11175d.msg_type == 2 ? new RelativeLayout.LayoutParams(this.f11179h, this.f11180i) : new RelativeLayout.LayoutParams(-2, -1);
            int iA = bb.a(30.0f);
            int iA2 = bb.a(15.0f);
            layoutParams.setMargins(iA, iA2, iA, iA2);
            layoutParams.addRule(13);
            this.f11178g = new FrameLayout(this.f11174c);
            this.f11178g.setLayoutParams(layoutParams);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
            int iA3 = bb.a(12.0f);
            layoutParams2.setMargins(iA3, iA3, iA3, iA3);
            ImageView imageView = new ImageView(this.f11174c);
            imageView.setLayoutParams(layoutParams2);
            imageView.setAdjustViewBounds(true);
            imageView.setId(f.a());
            imageView.setImageBitmap(this.f11177f);
            this.f11178g.addView(imageView);
            int iA4 = bb.a(24.0f);
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(iA4, iA4, 5);
            bd bdVar = new bd(this.f11174c);
            bdVar.setLayoutParams(layoutParams3);
            this.f11178g.addView(bdVar);
            relativeLayout.addView(this.f11178g);
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.umeng.message.inapp.UmengCardMessage.1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    UmengCardMessage.a(UmengCardMessage.this);
                    if (TextUtils.equals("none", UmengCardMessage.this.f11175d.action_type)) {
                        return;
                    }
                    UmengCardMessage.this.f11183l.handleInAppMessage(UmengCardMessage.this.f11174c, UmengCardMessage.this.f11175d, 16);
                    UmengCardMessage.this.dismiss();
                }
            });
            bdVar.setOnClickListener(new View.OnClickListener() { // from class: com.umeng.message.inapp.UmengCardMessage.2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    UmengCardMessage.e(UmengCardMessage.this);
                    UmengCardMessage.this.dismiss();
                }
            });
            return relativeLayout;
        }
        if (i2 == 4) {
            View viewInflate = layoutInflater.inflate(a.a(a.a().f11216a, "umeng_custom_card_message"), viewGroup, false);
            ImageView imageView2 = (ImageView) viewInflate.findViewById(a.a("umeng_card_message_image"));
            Button button = (Button) viewInflate.findViewById(a.a("umeng_card_message_ok"));
            Button button2 = (Button) viewInflate.findViewById(a.a("umeng_card_message_close"));
            imageView2.setImageBitmap(this.f11177f);
            imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.umeng.message.inapp.UmengCardMessage.4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    UmengCardMessage.a(UmengCardMessage.this);
                    if (TextUtils.equals("none", UmengCardMessage.this.f11175d.action_type)) {
                        return;
                    }
                    UmengCardMessage.this.f11183l.handleInAppMessage(UmengCardMessage.this.f11174c, UmengCardMessage.this.f11175d, 16);
                    UmengCardMessage.this.dismiss();
                }
            });
            button.setOnClickListener(new View.OnClickListener() { // from class: com.umeng.message.inapp.UmengCardMessage.5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    UmengCardMessage.f(UmengCardMessage.this);
                    if (TextUtils.equals("none", UmengCardMessage.this.f11175d.action_type)) {
                        return;
                    }
                    UmengCardMessage.this.f11183l.handleInAppMessage(UmengCardMessage.this.f11174c, UmengCardMessage.this.f11175d, 19);
                    UmengCardMessage.this.dismiss();
                }
            });
            button2.setOnClickListener(new View.OnClickListener() { // from class: com.umeng.message.inapp.UmengCardMessage.6
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    UmengCardMessage.e(UmengCardMessage.this);
                    UmengCardMessage.this.dismiss();
                }
            });
            return viewInflate;
        }
        if ((i2 != 5 && i2 != 6) || rect == null) {
            return null;
        }
        RelativeLayout relativeLayout2 = new RelativeLayout(this.f11174c);
        relativeLayout2.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        relativeLayout2.setBackgroundColor(Color.parseColor("#33000000"));
        if (getResources().getConfiguration().orientation == 1) {
            this.f11181j = rect.width() - bb.a(70.0f);
            if (this.f11175d.msg_type == 5) {
                this.f11182k = (this.f11181j / 6) * 5;
            } else {
                this.f11182k = (this.f11181j / 2) * 3;
            }
        } else {
            this.f11182k = rect.height() - bb.a(65.0f);
            this.f11181j = (this.f11182k / 5) * 6;
        }
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(this.f11181j, this.f11182k);
        layoutParams4.addRule(13);
        LinearLayout linearLayout = new LinearLayout(this.f11174c);
        linearLayout.setLayoutParams(layoutParams4);
        linearLayout.setGravity(1);
        linearLayout.setOrientation(1);
        linearLayout.setBackgroundColor(Color.parseColor("#FFFFFF"));
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-1, -2);
        int iA5 = bb.a(20.0f);
        layoutParams5.setMargins(iA5, iA5, iA5, iA5);
        TextView textView = new TextView(this.f11174c);
        textView.setLayoutParams(layoutParams5);
        textView.setGravity(17);
        textView.setText(this.f11175d.title);
        textView.setSingleLine(true);
        textView.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
        textView.setTextSize(Integer.parseInt(this.q[0]));
        textView.setTextColor(Color.parseColor("#000000"));
        linearLayout.addView(textView);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-1, 0);
        layoutParams6.setMargins(iA5, 0, iA5, 0);
        layoutParams6.weight = 1.0f;
        ScrollView scrollView = new ScrollView(this.f11174c);
        scrollView.setLayoutParams(layoutParams6);
        scrollView.setScrollBarStyle(16777216);
        scrollView.setVerticalScrollBarEnabled(false);
        TextView textView2 = new TextView(this.f11174c);
        textView2.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        textView2.setText(this.f11175d.content);
        textView2.setTextSize(Integer.parseInt(this.q[1]));
        textView2.setTextColor(Color.parseColor("#000000"));
        scrollView.addView(textView2);
        linearLayout.addView(scrollView);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setStroke(bb.a(1.0f), Color.parseColor("#D8D8D8"));
        gradientDrawable.setCornerRadius(20.0f);
        gradientDrawable.setColor(-1);
        LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(-1, bb.a(35.0f));
        layoutParams7.setMargins(iA5, bb.a(30.0f), iA5, iA5);
        TextView textView3 = new TextView(this.f11174c);
        textView3.setLayoutParams(layoutParams7);
        textView3.setGravity(17);
        textView3.setBackgroundColor(Color.parseColor("#FFFFFF"));
        textView3.setText(this.f11175d.button_text);
        textView3.setSingleLine(true);
        textView.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
        textView3.setTextSize(Integer.parseInt(this.q[2]));
        textView3.setTextColor(Color.parseColor("#000000"));
        textView3.setBackgroundDrawable(gradientDrawable);
        linearLayout.addView(textView3);
        relativeLayout2.addView(linearLayout);
        textView3.setOnClickListener(new View.OnClickListener() { // from class: com.umeng.message.inapp.UmengCardMessage.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UmengCardMessage.a(UmengCardMessage.this);
                UmengCardMessage.this.f11183l.handleInAppMessage(UmengCardMessage.this.f11174c, UmengCardMessage.this.f11175d, 18);
                UmengCardMessage.this.dismiss();
            }
        });
        return relativeLayout2;
    }

    @Override // android.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        ai aiVarA = ai.a(this.f11174c);
        UInAppMessage uInAppMessage = this.f11175d;
        aiVarA.a(uInAppMessage.msg_id, uInAppMessage.msg_type, 0, this.n ? 1 : 0, 0, 0, this.p ? 1 : 0, 0, this.o ? 1 : 0);
        this.p = false;
        this.n = false;
        this.o = false;
        this.f11184m = false;
        IUmengInAppMsgCloseCallback iUmengInAppMsgCloseCallback = this.f11173a;
        if (iUmengInAppMsgCloseCallback != null) {
            iUmengInAppMsgCloseCallback.onClose();
        }
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public final void onDestroyView() {
        if (getDialog() != null && getRetainInstance()) {
            getDialog().setDismissMessage(null);
        }
        super.onDestroyView();
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public final void onStart() {
        super.onStart();
        if (!this.f11184m) {
            ai aiVarA = ai.a(this.f11174c);
            UInAppMessage uInAppMessage = this.f11175d;
            aiVarA.a(uInAppMessage.msg_id, uInAppMessage.msg_type, 1, 0, 0, 0, 0, 0, 0);
        }
        this.f11184m = true;
    }
}
