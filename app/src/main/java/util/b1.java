package util;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.text.Html;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.method.ScrollingMovementMethod;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import androidx.appcompat.app.AlertDialog;
import bean.NoteDlgBean;
import com.hicorenational.antifraud.R;
import interfaces.IClickListener;
import interfaces.IEditClickListener;
import interfaces.IImageClickListener;
import interfaces.IOneClickListener;
import interfaces.ITimerState;
import manager.BaseDialog;

/* compiled from: DialogUtils.java */
/* loaded from: classes2.dex */
public class b1 {

    /* renamed from: a, reason: collision with root package name */
    private static ui.view.s f20734a;

    /* compiled from: DialogUtils.java */
    static class a extends ui.view.p {

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ Context f20735g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ ITimerState f20736h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(long j2, long j3, Context context, ITimerState iTimerState) {
            super(j2, j3);
            this.f20735g = context;
            this.f20736h = iTimerState;
        }

        @Override // ui.view.p
        public void a(long j2) {
            Context context = this.f20735g;
            if (context == null || ((Activity) context).isFinishing()) {
                return;
            }
            this.f20736h.timeCount((int) (j2 / 1000));
        }

        @Override // ui.view.p
        public void d() {
            this.f20736h.timeOver();
        }
    }

    /* compiled from: DialogUtils.java */
    static class b implements ITimerState {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Activity f20737a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Dialog f20738b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f20739c;

        b(Activity activity, Dialog dialog, boolean z) {
            this.f20737a = activity;
            this.f20738b = dialog;
            this.f20739c = z;
        }

        @Override // interfaces.ITimerState
        public void timeCount(int i2) {
        }

        @Override // interfaces.ITimerState
        public void timeOver() {
            Activity activity = this.f20737a;
            if (activity == null || activity.isFinishing()) {
                return;
            }
            Dialog dialog = this.f20738b;
            if (dialog != null) {
                dialog.dismiss();
            }
            if (this.f20739c) {
                this.f20737a.finish();
            }
        }
    }

    /* compiled from: DialogUtils.java */
    static class c implements ITimerState {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Button f20740a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f20741b;

        c(Button button, String str) {
            this.f20740a = button;
            this.f20741b = str;
        }

        @Override // interfaces.ITimerState
        public void timeCount(int i2) {
            this.f20740a.setText(Html.fromHtml(this.f20741b + "&#160;&#160;&#160;<font color=#2946E6>(" + i2 + "s)</font>"));
        }

        @Override // interfaces.ITimerState
        public void timeOver() {
            Button button = this.f20740a;
            if (button != null) {
                button.setEnabled(true);
                this.f20740a.setTextColor(Color.parseColor("#2946E6"));
                this.f20740a.setText(this.f20741b);
            }
        }
    }

    /* compiled from: DialogUtils.java */
    static class d implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IOneClickListener f20742a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ BaseDialog f20743b;

        d(IOneClickListener iOneClickListener, BaseDialog baseDialog) {
            this.f20742a = iOneClickListener;
            this.f20743b = baseDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IOneClickListener iOneClickListener = this.f20742a;
            if (iOneClickListener != null) {
                iOneClickListener.clickOKBtn();
            }
            this.f20743b.dismiss();
        }
    }

    /* compiled from: DialogUtils.java */
    static class e implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IOneClickListener f20744a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ BaseDialog f20745b;

        e(IOneClickListener iOneClickListener, BaseDialog baseDialog) {
            this.f20744a = iOneClickListener;
            this.f20745b = baseDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IOneClickListener iOneClickListener = this.f20744a;
            if (iOneClickListener != null) {
                iOneClickListener.clickOKBtn();
            }
            this.f20745b.dismiss();
        }
    }

    public static AlertDialog a(Context context, @DrawableRes int i2, String str, String str2, String str3, DialogInterface.OnClickListener onClickListener, String str4, DialogInterface.OnClickListener onClickListener2) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setIcon(i2);
        builder.setTitle(str);
        builder.setMessage(str2);
        builder.setPositiveButton(str3, onClickListener);
        builder.setNegativeButton(str4, onClickListener2);
        return builder.create();
    }

    public static Dialog b(Activity activity, String str, String str2, IOneClickListener iOneClickListener) {
        return a(activity, str, (String) null, str2, iOneClickListener);
    }

    static /* synthetic */ void c(IOneClickListener iOneClickListener, BaseDialog baseDialog, View view) {
        if (iOneClickListener != null) {
            iOneClickListener.clickOKBtn();
        }
        baseDialog.dismiss();
    }

    static /* synthetic */ void d(IClickListener iClickListener, BaseDialog baseDialog, View view) {
        if (iClickListener != null) {
            iClickListener.clickOKBtn();
        }
        baseDialog.dismiss();
    }

    static /* synthetic */ void e(IClickListener iClickListener, BaseDialog baseDialog, View view) {
        if (iClickListener != null) {
            iClickListener.cancelBtn();
        }
        baseDialog.dismiss();
    }

    static /* synthetic */ void f(IClickListener iClickListener, BaseDialog baseDialog, View view) {
        if (iClickListener != null) {
            iClickListener.clickOKBtn();
        }
        baseDialog.dismiss();
    }

    static /* synthetic */ void g(IClickListener iClickListener, BaseDialog baseDialog, View view) {
        if (iClickListener != null) {
            iClickListener.cancelBtn();
        }
        baseDialog.dismiss();
    }

    static /* synthetic */ void h(IClickListener iClickListener, BaseDialog baseDialog, View view) {
        if (iClickListener != null) {
            iClickListener.clickOKBtn();
        }
        baseDialog.dismiss();
    }

    static /* synthetic */ void i(IClickListener iClickListener, BaseDialog baseDialog, View view) {
        if (iClickListener != null) {
            iClickListener.cancelBtn();
        }
        baseDialog.dismiss();
    }

    static /* synthetic */ void j(IClickListener iClickListener, BaseDialog baseDialog, View view) {
        if (iClickListener != null) {
            iClickListener.clickOKBtn();
        }
        baseDialog.dismiss();
    }

    static /* synthetic */ void k(IClickListener iClickListener, BaseDialog baseDialog, View view) {
        if (iClickListener != null) {
            iClickListener.cancelBtn();
        }
        baseDialog.dismiss();
    }

    static /* synthetic */ void l(IClickListener iClickListener, BaseDialog baseDialog, View view) {
        if (iClickListener != null) {
            iClickListener.cancelBtn();
        }
        baseDialog.dismiss();
    }

    static /* synthetic */ void m(IClickListener iClickListener, BaseDialog baseDialog, View view) {
        if (iClickListener != null) {
            iClickListener.clickOKBtn();
        }
        baseDialog.dismiss();
    }

    static /* synthetic */ void n(IClickListener iClickListener, BaseDialog baseDialog, View view) {
        if (iClickListener != null) {
            iClickListener.cancelBtn();
        }
        baseDialog.dismiss();
    }

    static /* synthetic */ void o(IClickListener iClickListener, BaseDialog baseDialog, View view) {
        if (iClickListener != null) {
            iClickListener.clickOKBtn();
        }
        baseDialog.dismiss();
    }

    static /* synthetic */ void p(IClickListener iClickListener, BaseDialog baseDialog, View view) {
        if (iClickListener != null) {
            iClickListener.cancelBtn();
        }
        baseDialog.dismiss();
    }

    static /* synthetic */ void q(IClickListener iClickListener, BaseDialog baseDialog, View view) {
        if (iClickListener != null) {
            iClickListener.clickOKBtn();
        }
        baseDialog.dismiss();
    }

    static /* synthetic */ void r(IClickListener iClickListener, BaseDialog baseDialog, View view) {
        if (iClickListener != null) {
            iClickListener.cancelBtn();
        }
        baseDialog.dismiss();
    }

    static /* synthetic */ void s(IClickListener iClickListener, BaseDialog baseDialog, View view) {
        if (iClickListener != null) {
            iClickListener.clickOKBtn();
        }
        baseDialog.dismiss();
    }

    static /* synthetic */ void t(IClickListener iClickListener, BaseDialog baseDialog, View view) {
        if (iClickListener != null) {
            iClickListener.cancelBtn();
        }
        baseDialog.dismiss();
    }

    static /* synthetic */ void u(IClickListener iClickListener, BaseDialog baseDialog, View view) {
        if (iClickListener != null) {
            iClickListener.clickOKBtn();
        }
        baseDialog.dismiss();
    }

    static /* synthetic */ void v(IClickListener iClickListener, BaseDialog baseDialog, View view) {
        if (iClickListener != null) {
            iClickListener.cancelBtn();
        }
        baseDialog.dismiss();
    }

    static /* synthetic */ void w(IClickListener iClickListener, BaseDialog baseDialog, View view) {
        if (iClickListener != null) {
            iClickListener.clickOKBtn();
        }
        baseDialog.dismiss();
    }

    public static Dialog b(Activity activity, String str, String str2, String str3, String str4, IClickListener iClickListener) {
        return a(activity, str, str2, str3, str4, -1, -1, iClickListener);
    }

    public static BaseDialog c(Activity activity, String str, String str2, String str3, String str4, final IClickListener iClickListener) {
        if (activity == null || activity.isFinishing()) {
            return null;
        }
        final BaseDialog baseDialog = new BaseDialog(activity, R.style.base_dialog_style);
        baseDialog.setContentView(R.layout.custom_bt_dialog_red);
        baseDialog.setGravityLayout(2);
        baseDialog.setWidthDialog(-2.0d);
        baseDialog.setHeightDialog(-2.0d);
        baseDialog.setCancelable(false);
        baseDialog.setCanceledOnTouchOutside(false);
        baseDialog.initOnCreate();
        baseDialog.show();
        TextView textView = (TextView) baseDialog.findViewById(R.id.tv_title);
        TextView textView2 = (TextView) baseDialog.findViewById(R.id.tv_subtitle);
        Button button = (Button) baseDialog.findViewById(R.id.btn_cancel);
        Button button2 = (Button) baseDialog.findViewById(R.id.btn_confirm);
        textView.setText(str);
        textView2.setText(str2);
        button.setText(str3);
        button2.setText(str4);
        button.setOnClickListener(new View.OnClickListener() { // from class: util.q0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                b1.k(iClickListener, baseDialog, view);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: util.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                b1.a(iClickListener, view);
            }
        });
        return baseDialog;
    }

    static /* synthetic */ void d(IOneClickListener iOneClickListener, BaseDialog baseDialog, View view) {
        if (iOneClickListener != null) {
            iOneClickListener.clickOKBtn();
        }
        baseDialog.dismiss();
    }

    public static Dialog e(Activity activity, String str, String str2, String str3, String str4, final IClickListener iClickListener) {
        if (activity == null || activity.isFinishing()) {
            return null;
        }
        final BaseDialog baseDialog = new BaseDialog(activity, R.style.base_dialog_style);
        baseDialog.setContentView(R.layout.custom_btn_bg_dialog);
        baseDialog.setGravityLayout(2);
        baseDialog.setWidthDialogdp(-2.0f);
        baseDialog.setHeightDialogdp(-2.0f);
        baseDialog.setCanceledOnTouchOutside(false);
        baseDialog.initOnCreate();
        baseDialog.show();
        TextView textView = (TextView) baseDialog.findViewById(R.id.customdialog_title);
        TextView textView2 = (TextView) baseDialog.findViewById(R.id.customdialog_subtitle);
        Button button = (Button) baseDialog.findViewById(R.id.cancel_btn);
        Button button2 = (Button) baseDialog.findViewById(R.id.confirm_btn);
        if (TextUtils.isEmpty(str)) {
            textView.setVisibility(8);
        } else {
            textView.setText(str);
        }
        textView2.setText(str2);
        button.setText(str3);
        button2.setText(str4);
        button.setOnClickListener(new View.OnClickListener() { // from class: util.v
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                b1.n(iClickListener, baseDialog, view);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: util.o0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                b1.o(iClickListener, baseDialog, view);
            }
        });
        return baseDialog;
    }

    public static Dialog f(Activity activity, String str, String str2, String str3, String str4, final IClickListener iClickListener) {
        if (activity == null || activity.isFinishing()) {
            return null;
        }
        final BaseDialog baseDialog = new BaseDialog(activity, R.style.base_dialog_style);
        baseDialog.setContentView(R.layout.flow_primiss_dialog_tips);
        baseDialog.setGravityLayout(2);
        baseDialog.setWidthDialog(-2.0d);
        baseDialog.setHeightDialog(-2.0d);
        baseDialog.setCancelable(false);
        baseDialog.setCanceledOnTouchOutside(false);
        baseDialog.initOnCreate();
        baseDialog.show();
        TextView textView = (TextView) baseDialog.findViewById(R.id.customdialog_title);
        TextView textView2 = (TextView) baseDialog.findViewById(R.id.customdialog_subtitle);
        Button button = (Button) baseDialog.findViewById(R.id.cancel_btn);
        Button button2 = (Button) baseDialog.findViewById(R.id.confirm_btn);
        textView.setText(str);
        textView2.setText(str2);
        button.setText(str3);
        button2.setText(str4);
        button.setOnClickListener(new View.OnClickListener() { // from class: util.u
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                b1.a(baseDialog, iClickListener, view);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: util.c0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                b1.b(baseDialog, iClickListener, view);
            }
        });
        return baseDialog;
    }

    static /* synthetic */ void b(IClickListener iClickListener, BaseDialog baseDialog, View view) {
        if (iClickListener != null) {
            iClickListener.clickOKBtn();
        }
        baseDialog.dismiss();
    }

    public static Dialog d(Activity activity, String str, String str2, String str3, String str4, final IClickListener iClickListener) {
        if (activity == null || activity.isFinishing()) {
            return null;
        }
        final BaseDialog baseDialog = new BaseDialog(activity, R.style.base_dialog_style);
        baseDialog.setContentView(R.layout.report_case_tips_dialog);
        baseDialog.setGravityLayout(2);
        baseDialog.setWidthDialog(-2.0d);
        baseDialog.setHeightDialog(-2.0d);
        baseDialog.setCancelable(false);
        baseDialog.setCanceledOnTouchOutside(false);
        baseDialog.initOnCreate();
        baseDialog.show();
        TextView textView = (TextView) baseDialog.findViewById(R.id.dialog_title);
        baseDialog.findViewById(R.id.ll_content);
        TextView textView2 = (TextView) baseDialog.findViewById(R.id.tv_report_time);
        TextView textView3 = (TextView) baseDialog.findViewById(R.id.tv_case_num);
        TextView textView4 = (TextView) baseDialog.findViewById(R.id.tv_polic_num);
        Button button = (Button) baseDialog.findViewById(R.id.cancel_btn);
        Button button2 = (Button) baseDialog.findViewById(R.id.confirm_btn);
        textView.setText(str);
        textView2.setText(str2);
        boolean zIsEmpty = TextUtils.isEmpty(str3);
        String str5 = d.d.D;
        if (zIsEmpty) {
            str3 = d.d.D;
        }
        textView3.setText(str3);
        if (!TextUtils.isEmpty(str4)) {
            str5 = str4;
        }
        textView4.setText(str5);
        button.setOnClickListener(new View.OnClickListener() { // from class: util.e0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                b1.l(iClickListener, baseDialog, view);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: util.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                b1.m(iClickListener, baseDialog, view);
            }
        });
        return baseDialog;
    }

    public static Dialog b(Activity activity, int i2, String str, String str2, String str3, String str4, int i3, int i4, final IClickListener iClickListener) {
        if (activity == null || activity.isFinishing()) {
            return null;
        }
        final BaseDialog baseDialog = new BaseDialog(activity, R.style.base_dialog_style);
        baseDialog.setContentView(R.layout.custom_icon_bt_dialog2);
        baseDialog.setGravityLayout(2);
        baseDialog.setWidthDialog(-2.0d);
        baseDialog.setHeightDialog(-2.0d);
        baseDialog.setCanceledOnTouchOutside(false);
        baseDialog.initOnCreate();
        baseDialog.show();
        ImageView imageView = (ImageView) baseDialog.findViewById(R.id.iv_top_icon);
        TextView textView = (TextView) baseDialog.findViewById(R.id.customdialog_title);
        TextView textView2 = (TextView) baseDialog.findViewById(R.id.customdialog_subtitle);
        Button button = (Button) baseDialog.findViewById(R.id.cancel_btn);
        Button button2 = (Button) baseDialog.findViewById(R.id.confirm_btn);
        if (i2 != -1) {
            imageView.setImageResource(i2);
        } else {
            imageView.setVisibility(8);
        }
        textView.setText(str);
        textView2.setText(str2);
        button.setText(str3);
        button2.setText(str4);
        if (i3 == -1) {
            button.setTextColor(-14072090);
            button.setAlpha(0.5f);
        } else {
            button.setTextColor(activity.getResources().getColor(i3));
        }
        if (i4 == -1) {
            button2.setTextColor(-14072090);
        } else {
            button2.setTextColor(activity.getResources().getColor(i4));
        }
        button.setOnClickListener(new View.OnClickListener() { // from class: util.p0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                b1.t(iClickListener, baseDialog, view);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: util.d0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                b1.u(iClickListener, baseDialog, view);
            }
        });
        return baseDialog;
    }

    private static synchronized void a(Context context, int i2, ITimerState iTimerState) {
        new a(i2 * 1000, 1000L, context, iTimerState);
    }

    public static void a(Activity activity, boolean z, int i2, Dialog dialog) {
        a(activity, i2, new b(activity, dialog, z));
    }

    public static void a(Activity activity, int i2, Button button, String str) {
        a(activity, i2, new c(button, str));
    }

    public static Dialog a(Activity activity, String str, String str2, String str3, IOneClickListener iOneClickListener) {
        if (activity == null || activity.isFinishing()) {
            return null;
        }
        BaseDialog baseDialog = new BaseDialog(activity, R.style.base_dialog_style);
        baseDialog.setContentView(R.layout.custom_dialog_one);
        baseDialog.setGravityLayout(2);
        baseDialog.setWidthDialog(-2.0d);
        baseDialog.setHeightDialog(-2.0d);
        baseDialog.setCancelable(false);
        baseDialog.setCanceledOnTouchOutside(false);
        baseDialog.initOnCreate();
        baseDialog.show();
        TextView textView = (TextView) baseDialog.findViewById(R.id.title);
        TextView textView2 = (TextView) baseDialog.findViewById(R.id.subtitle);
        Button button = (Button) baseDialog.findViewById(R.id.button);
        button.setText(str3);
        textView.setText(str);
        if (!TextUtils.isEmpty(str2)) {
            textView2.setVisibility(0);
            textView2.setText(str2);
        }
        button.setOnClickListener(new d(iOneClickListener, baseDialog));
        return baseDialog;
    }

    static /* synthetic */ void c(IClickListener iClickListener, BaseDialog baseDialog, View view) {
        if (iClickListener != null) {
            iClickListener.cancelBtn();
        }
        baseDialog.dismiss();
    }

    static /* synthetic */ void c(IClickListener iClickListener, View view) {
        if (iClickListener != null) {
            iClickListener.clickOKBtn();
        }
    }

    public static Dialog a(Context context, String str, String str2, String str3, IOneClickListener iOneClickListener) {
        if (context == null) {
            return null;
        }
        BaseDialog baseDialog = new BaseDialog(context, R.style.base_dialog_style);
        baseDialog.setContentView(R.layout.custom_dialog_one);
        baseDialog.setGravityLayout(2);
        baseDialog.setWidthDialog(-2.0d);
        baseDialog.setHeightDialog(-2.0d);
        baseDialog.setCancelable(false);
        baseDialog.setCanceledOnTouchOutside(false);
        baseDialog.initOnCreate();
        baseDialog.show();
        TextView textView = (TextView) baseDialog.findViewById(R.id.title);
        TextView textView2 = (TextView) baseDialog.findViewById(R.id.subtitle);
        Button button = (Button) baseDialog.findViewById(R.id.button);
        button.setText(str3);
        textView.setText(str);
        if (TextUtils.isEmpty(str2)) {
            textView2.setVisibility(8);
        } else {
            textView2.setVisibility(0);
            textView2.setText(str2);
        }
        button.setOnClickListener(new e(iOneClickListener, baseDialog));
        return baseDialog;
    }

    public static Dialog b(Activity activity, int i2, String str, String str2, String str3, String str4, final IClickListener iClickListener) {
        if (activity == null || activity.isFinishing()) {
            return null;
        }
        final BaseDialog baseDialog = new BaseDialog(activity, R.style.base_dialog_style);
        baseDialog.setContentView(R.layout.custom_icon_dialog);
        baseDialog.setGravityLayout(2);
        baseDialog.setWidthDialogdp(-2.0f);
        baseDialog.setHeightDialogdp(-2.0f);
        baseDialog.setCanceledOnTouchOutside(false);
        baseDialog.initOnCreate();
        baseDialog.show();
        ImageView imageView = (ImageView) baseDialog.findViewById(R.id.iv_top_icon);
        TextView textView = (TextView) baseDialog.findViewById(R.id.customdialog_title);
        TextView textView2 = (TextView) baseDialog.findViewById(R.id.customdialog_subtitle);
        Button button = (Button) baseDialog.findViewById(R.id.cancel_btn);
        Button button2 = (Button) baseDialog.findViewById(R.id.confirm_btn);
        if (i2 != -1) {
            imageView.setImageResource(i2);
        } else {
            imageView.setVisibility(8);
        }
        if (TextUtils.isEmpty(str)) {
            textView.setVisibility(8);
        } else {
            textView.setText(str);
        }
        textView2.setText(str2);
        button.setText(str3);
        button2.setText(str4);
        button.setOnClickListener(new View.OnClickListener() { // from class: util.r
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                b1.p(iClickListener, baseDialog, view);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: util.q
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                b1.q(iClickListener, baseDialog, view);
            }
        });
        return baseDialog;
    }

    public static Dialog a(Activity activity, int i2, String str, String str2, String str3, int i3, final IOneClickListener iOneClickListener) {
        if (activity == null || activity.isFinishing()) {
            return null;
        }
        final BaseDialog baseDialog = new BaseDialog(activity, R.style.base_dialog_style);
        baseDialog.setContentView(R.layout.custom_icon_one_dialog);
        baseDialog.setGravityLayout(2);
        baseDialog.setWidthDialog(-2.0d);
        baseDialog.setHeightDialog(-2.0d);
        baseDialog.setCanceledOnTouchOutside(false);
        baseDialog.initOnCreate();
        baseDialog.show();
        ImageView imageView = (ImageView) baseDialog.findViewById(R.id.iv_top_icon);
        TextView textView = (TextView) baseDialog.findViewById(R.id.customdialog_title);
        TextView textView2 = (TextView) baseDialog.findViewById(R.id.customdialog_subtitle);
        Button button = (Button) baseDialog.findViewById(R.id.confirm_btn);
        ImageView imageView2 = (ImageView) baseDialog.findViewById(R.id.iv_close);
        if (i2 != -1) {
            imageView.setImageResource(i2);
        } else {
            imageView.setVisibility(8);
        }
        textView.setText(str);
        textView2.setText(str2);
        button.setText(str3);
        if (i3 == -1) {
            button.setTextColor(-14072090);
        } else {
            button.setTextColor(activity.getResources().getColor(i3));
        }
        button.setOnClickListener(new View.OnClickListener() { // from class: util.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                b1.c(iOneClickListener, baseDialog, view);
            }
        });
        imageView2.setOnClickListener(new View.OnClickListener() { // from class: util.b0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                baseDialog.dismiss();
            }
        });
        return baseDialog;
    }

    static /* synthetic */ void b(IImageClickListener iImageClickListener, BaseDialog baseDialog, View view) {
        if (iImageClickListener != null) {
            iImageClickListener.clickImage();
        }
        baseDialog.dismiss();
    }

    public static Dialog b(Activity activity, boolean z, int i2, String str, int i3) {
        if (activity == null || activity.isFinishing()) {
            return null;
        }
        BaseDialog baseDialog = new BaseDialog(activity, R.style.base_dialog_style);
        baseDialog.setContentView(R.layout.custom_iv_h_dialog);
        baseDialog.setGravityLayout(2);
        baseDialog.setWidthDialog(-2.0d);
        baseDialog.setHeightDialog(-2.0d);
        baseDialog.setCancelable(true);
        baseDialog.setCanceledOnTouchOutside(true);
        baseDialog.initOnCreate();
        baseDialog.show();
        ImageView imageView = (ImageView) baseDialog.findViewById(R.id.iv_img);
        TextView textView = (TextView) baseDialog.findViewById(R.id.tv_title);
        imageView.setBackgroundResource(i3);
        textView.setText(str);
        a(activity, z, i2, baseDialog);
        return baseDialog;
    }

    public static Dialog a(Activity activity, String str, String str2, String str3, final IClickListener iClickListener) {
        if (activity == null || activity.isFinishing()) {
            return null;
        }
        final BaseDialog baseDialog = new BaseDialog(activity, R.style.base_dialog_style);
        baseDialog.setContentView(R.layout.custom_bt_dialog);
        baseDialog.setGravityLayout(2);
        baseDialog.setWidthDialog(-2.0d);
        baseDialog.setHeightDialog(-2.0d);
        baseDialog.setCancelable(false);
        baseDialog.setCanceledOnTouchOutside(false);
        baseDialog.initOnCreate();
        baseDialog.show();
        TextView textView = (TextView) baseDialog.findViewById(R.id.customdialog_title);
        ((TextView) baseDialog.findViewById(R.id.customdialog_subtitle)).setVisibility(8);
        Button button = (Button) baseDialog.findViewById(R.id.cancel_btn);
        Button button2 = (Button) baseDialog.findViewById(R.id.confirm_btn);
        textView.setText(str);
        button.setText(str2);
        button2.setText(str3);
        button.setOnClickListener(new View.OnClickListener() { // from class: util.f0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                b1.g(iClickListener, baseDialog, view);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: util.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                b1.h(iClickListener, baseDialog, view);
            }
        });
        return baseDialog;
    }

    static /* synthetic */ void b(BaseDialog baseDialog, IClickListener iClickListener, View view) {
        baseDialog.dismiss();
        if (iClickListener != null) {
            iClickListener.clickOKBtn();
        }
    }

    static /* synthetic */ void b(IOneClickListener iOneClickListener, BaseDialog baseDialog, View view) {
        if (iOneClickListener != null) {
            iOneClickListener.clickOKBtn();
        }
        baseDialog.dismiss();
    }

    static /* synthetic */ void b(IClickListener iClickListener, View view) {
        if (iClickListener != null) {
            iClickListener.cancelBtn();
        }
    }

    static /* synthetic */ void a(IClickListener iClickListener, View view) {
        if (iClickListener != null) {
            iClickListener.clickOKBtn();
        }
    }

    public static Dialog a(Activity activity, String str, String str2, String str3, String str4, IClickListener iClickListener) {
        return a(activity, str, str2, str3, str4, -1, -1, false, iClickListener);
    }

    public static Dialog a(Activity activity, String str, String str2, String str3, String str4, int i2, int i3, IClickListener iClickListener) {
        return a(activity, str, (CharSequence) str2, false, str3, str4, i2, i3, iClickListener);
    }

    public static Dialog a(Activity activity, String str, CharSequence charSequence, boolean z, String str2, String str3, int i2, int i3, final IClickListener iClickListener) {
        if (activity == null || activity.isFinishing()) {
            return null;
        }
        final BaseDialog baseDialog = new BaseDialog(activity, R.style.base_dialog_style);
        baseDialog.setContentView(R.layout.custom_bt_dialog);
        baseDialog.setGravityLayout(2);
        baseDialog.setWidthDialogdp(-2.0f);
        baseDialog.setHeightDialogdp(-2.0f);
        baseDialog.setCancelable(false);
        baseDialog.setCanceledOnTouchOutside(false);
        baseDialog.initOnCreate();
        baseDialog.show();
        TextView textView = (TextView) baseDialog.findViewById(R.id.customdialog_title);
        TextView textView2 = (TextView) baseDialog.findViewById(R.id.customdialog_subtitle);
        Button button = (Button) baseDialog.findViewById(R.id.cancel_btn);
        Button button2 = (Button) baseDialog.findViewById(R.id.confirm_btn);
        if (z) {
            textView2.setMovementMethod(LinkMovementMethod.getInstance());
            textView2.setText(charSequence);
        } else {
            textView2.setText(charSequence);
        }
        if (TextUtils.isEmpty(charSequence)) {
            textView2.setVisibility(8);
        }
        textView.setText(str);
        button.setText(str2);
        button2.setText(str3);
        if (i2 == -1) {
            button.setTextColor(-14072090);
        } else {
            button.setTextColor(activity.getResources().getColor(i2));
        }
        if (i3 == -1) {
            button2.setTextColor(-14072090);
        } else {
            button2.setTextColor(activity.getResources().getColor(i3));
        }
        button.setOnClickListener(new View.OnClickListener() { // from class: util.w
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                b1.i(iClickListener, baseDialog, view);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: util.p
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                b1.j(iClickListener, baseDialog, view);
            }
        });
        return baseDialog;
    }

    public static Dialog a(Activity activity, String str, CharSequence charSequence, boolean z, String str2, String str3, final IClickListener iClickListener) {
        if (activity == null || activity.isFinishing()) {
            return null;
        }
        final BaseDialog baseDialog = new BaseDialog(activity, R.style.base_dialog_style);
        baseDialog.setContentView(R.layout.custom_clause_dialog);
        baseDialog.setGravityLayout(2);
        baseDialog.setWidthDialogdp(-2.0f);
        baseDialog.setHeightDialogdp(-2.0f);
        baseDialog.setCancelable(false);
        baseDialog.setCanceledOnTouchOutside(false);
        baseDialog.initOnCreate();
        baseDialog.show();
        TextView textView = (TextView) baseDialog.findViewById(R.id.customdialog_title);
        TextView textView2 = (TextView) baseDialog.findViewById(R.id.customdialog_subtitle);
        Button button = (Button) baseDialog.findViewById(R.id.cancel_btn);
        Button button2 = (Button) baseDialog.findViewById(R.id.confirm_btn);
        textView2.setGravity(3);
        if (z) {
            textView2.setMovementMethod(LinkMovementMethod.getInstance());
            textView2.setText(charSequence);
        } else {
            textView2.setText(charSequence);
        }
        if (TextUtils.isEmpty(charSequence)) {
            textView2.setVisibility(8);
        }
        textView.setText(str);
        button.setText(str2);
        button2.setText(str3);
        button.setOnClickListener(new View.OnClickListener() { // from class: util.z
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                b1.r(iClickListener, baseDialog, view);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: util.g0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                b1.s(iClickListener, baseDialog, view);
            }
        });
        return baseDialog;
    }

    @SuppressLint({"ResourceAsColor"})
    public static Dialog a(Activity activity, String str, String str2, String str3, String str4, int i2, int i3, boolean z, final IClickListener iClickListener) {
        if (activity == null || activity.isFinishing()) {
            return null;
        }
        final BaseDialog baseDialog = new BaseDialog(activity, R.style.base_dialog_style);
        baseDialog.setContentView(R.layout.custom_bt_title_dialog);
        baseDialog.setGravityLayout(2);
        baseDialog.setWidthDialogdp(-2.0f);
        baseDialog.setHeightDialogdp(-2.0f);
        baseDialog.setCancelable(z);
        baseDialog.setCanceledOnTouchOutside(z);
        baseDialog.initOnCreate();
        baseDialog.show();
        TextView textView = (TextView) baseDialog.findViewById(R.id.customdialog_title);
        TextView textView2 = (TextView) baseDialog.findViewById(R.id.customdialog_subtitle);
        View viewFindViewById = baseDialog.findViewById(R.id.ll_subtit);
        Button button = (Button) baseDialog.findViewById(R.id.cancel_btn);
        Button button2 = (Button) baseDialog.findViewById(R.id.confirm_btn);
        if (!TextUtils.isEmpty(str2)) {
            viewFindViewById.setVisibility(0);
        }
        textView.setText(str);
        textView2.setText(str2);
        button.setText(str3);
        button2.setText(str4);
        if (i2 == -1) {
            button.setTextColor(-14072090);
        } else {
            button.setTextColor(activity.getResources().getColor(i2));
        }
        if (i3 == -1) {
            button2.setTextColor(-14072090);
        } else {
            button2.setTextColor(activity.getResources().getColor(i3));
        }
        button.setOnClickListener(new View.OnClickListener() { // from class: util.t
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                b1.a(iClickListener, baseDialog, view);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: util.x
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                b1.b(iClickListener, baseDialog, view);
            }
        });
        return baseDialog;
    }

    static /* synthetic */ void a(IClickListener iClickListener, BaseDialog baseDialog, View view) {
        if (iClickListener != null) {
            iClickListener.cancelBtn();
        }
        baseDialog.dismiss();
    }

    public static Dialog a(Context context, String str, String str2, String str3, String str4, IClickListener iClickListener) {
        return a(context, str, str2, str3, str4, -1, -1, iClickListener);
    }

    public static Dialog a(Context context, String str, String str2, String str3, String str4, int i2, int i3, final IClickListener iClickListener) {
        if (context == null) {
            return null;
        }
        final BaseDialog baseDialog = new BaseDialog(context, R.style.base_dialog_style);
        baseDialog.setContentView(R.layout.custom_bt_dialog);
        baseDialog.setGravityLayout(2);
        baseDialog.setWidthDialogdp(-2.0f);
        baseDialog.setHeightDialogdp(-2.0f);
        baseDialog.setCancelable(false);
        baseDialog.setCanceledOnTouchOutside(false);
        baseDialog.initOnCreate();
        baseDialog.show();
        TextView textView = (TextView) baseDialog.findViewById(R.id.customdialog_title);
        TextView textView2 = (TextView) baseDialog.findViewById(R.id.customdialog_subtitle);
        Button button = (Button) baseDialog.findViewById(R.id.cancel_btn);
        Button button2 = (Button) baseDialog.findViewById(R.id.confirm_btn);
        textView.setText(str);
        textView2.setText(str2);
        button.setText(str3);
        button2.setText(str4);
        if (i2 == -1) {
            button.setTextColor(-14072090);
        } else {
            button.setTextColor(context.getResources().getColor(i2));
        }
        if (i3 == -1) {
            button2.setTextColor(-14072090);
        } else {
            button2.setTextColor(context.getResources().getColor(i3));
        }
        button.setOnClickListener(new View.OnClickListener() { // from class: util.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                b1.c(iClickListener, baseDialog, view);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: util.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                b1.d(iClickListener, baseDialog, view);
            }
        });
        return baseDialog;
    }

    public static Dialog a(Activity activity, int i2, String str, String str2, String str3, String str4, IClickListener iClickListener) {
        return a(activity, i2, str, str2, str3, str4, -1, -1, iClickListener);
    }

    public static Dialog a(Activity activity, int i2, String str, String str2, String str3, String str4, int i3, int i4, final IClickListener iClickListener) {
        if (activity == null || activity.isFinishing()) {
            return null;
        }
        final BaseDialog baseDialog = new BaseDialog(activity, R.style.base_dialog_style);
        baseDialog.setContentView(R.layout.custom_icon_bt_dialog);
        baseDialog.setGravityLayout(2);
        baseDialog.setWidthDialog(-2.0d);
        baseDialog.setHeightDialog(-2.0d);
        baseDialog.setCanceledOnTouchOutside(false);
        baseDialog.initOnCreate();
        baseDialog.show();
        ImageView imageView = (ImageView) baseDialog.findViewById(R.id.iv_top_icon);
        TextView textView = (TextView) baseDialog.findViewById(R.id.customdialog_title);
        TextView textView2 = (TextView) baseDialog.findViewById(R.id.customdialog_subtitle);
        Button button = (Button) baseDialog.findViewById(R.id.cancel_btn);
        Button button2 = (Button) baseDialog.findViewById(R.id.confirm_btn);
        ImageView imageView2 = (ImageView) baseDialog.findViewById(R.id.iv_close);
        if (i2 != -1) {
            imageView.setImageResource(i2);
        } else {
            imageView.setVisibility(8);
        }
        textView.setText(str);
        textView2.setText(str2);
        button.setText(str3);
        button2.setText(str4);
        if (i3 == -1) {
            button.setTextColor(-14072090);
        } else {
            button.setTextColor(activity.getResources().getColor(i3));
        }
        if (i4 == -1) {
            button2.setTextColor(-14072090);
        } else {
            button2.setTextColor(activity.getResources().getColor(i4));
        }
        button.setOnClickListener(new View.OnClickListener() { // from class: util.o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                b1.e(iClickListener, baseDialog, view);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: util.a0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                b1.f(iClickListener, baseDialog, view);
            }
        });
        imageView2.setOnClickListener(new View.OnClickListener() { // from class: util.s
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                baseDialog.dismiss();
            }
        });
        return baseDialog;
    }

    public static Dialog a(Activity activity, String str, final IImageClickListener iImageClickListener) {
        if (activity == null || activity.isFinishing()) {
            return null;
        }
        final BaseDialog baseDialog = new BaseDialog(activity, R.style.base_dialog_style);
        baseDialog.setContentView(R.layout.custom_image_dialog);
        baseDialog.setGravityLayout(2);
        baseDialog.setWidthDialogdp(-2.0f);
        baseDialog.setHeightDialogdp(-2.0f);
        baseDialog.setCanceledOnTouchOutside(false);
        baseDialog.initOnCreate();
        baseDialog.show();
        ImageView imageView = (ImageView) baseDialog.findViewById(R.id.iv_close);
        ImageView imageView2 = (ImageView) baseDialog.findViewById(R.id.iv_content);
        j.d.b(imageView2, str);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: util.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                b1.a(iImageClickListener, baseDialog, view);
            }
        });
        imageView2.setOnClickListener(new View.OnClickListener() { // from class: util.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                b1.b(iImageClickListener, baseDialog, view);
            }
        });
        return baseDialog;
    }

    static /* synthetic */ void a(IImageClickListener iImageClickListener, BaseDialog baseDialog, View view) {
        if (iImageClickListener != null) {
            iImageClickListener.clickClose();
        }
        baseDialog.dismiss();
    }

    public static Dialog a(Activity activity, boolean z, int i2, String str, int i3) {
        if (activity == null || activity.isFinishing()) {
            return null;
        }
        BaseDialog baseDialog = new BaseDialog(activity, R.style.base_dialog_style);
        baseDialog.setContentView(R.layout.custom_iv_dialog);
        baseDialog.setGravityLayout(2);
        baseDialog.setWidthDialog(-2.0d);
        baseDialog.setHeightDialog(-2.0d);
        baseDialog.setCancelable(true);
        baseDialog.setCanceledOnTouchOutside(true);
        baseDialog.initOnCreate();
        baseDialog.show();
        ImageView imageView = (ImageView) baseDialog.findViewById(R.id.iv_img);
        TextView textView = (TextView) baseDialog.findViewById(R.id.tv_title);
        imageView.setBackgroundResource(i3);
        textView.setText(str);
        a(activity, z, i2, baseDialog);
        return baseDialog;
    }

    public static Dialog a(final Activity activity, int i2, final String str, String str2, String str3, String str4, final IOneClickListener iOneClickListener) {
        if (activity == null || activity.isFinishing()) {
            return null;
        }
        final BaseDialog baseDialog = new BaseDialog(activity, R.style.base_dialog_style);
        baseDialog.setContentView(R.layout.custom_dialog_one_time);
        baseDialog.setGravityLayout(2);
        baseDialog.setWidthDialog(-2.0d);
        baseDialog.setHeightDialog(-2.0d);
        baseDialog.setCancelable(false);
        baseDialog.setCanceledOnTouchOutside(false);
        baseDialog.initOnCreate();
        baseDialog.show();
        TextView textView = (TextView) baseDialog.findViewById(R.id.title);
        TextView textView2 = (TextView) baseDialog.findViewById(R.id.subtitle);
        Button button = (Button) baseDialog.findViewById(R.id.button);
        textView.setText(Html.fromHtml(str2));
        if (!TextUtils.isEmpty(str3)) {
            textView2.setVisibility(0);
            textView2.setText(str3);
        }
        button.setOnClickListener(new View.OnClickListener() { // from class: util.j0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                b1.d(iOneClickListener, baseDialog, view);
            }
        });
        textView.setOnClickListener(new View.OnClickListener() { // from class: util.i0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                b1.a(str, activity, view);
            }
        });
        if (i2 > 0) {
            button.setText(Html.fromHtml(str4 + "&#160;&#160;&#160;<font color=#2946E6>(" + str2 + "s)</font>"));
            button.setEnabled(false);
            button.setTextColor(Color.parseColor("#999999"));
            a(activity, i2, button, str4);
        } else {
            button.setText(str4);
            button.setTextColor(Color.parseColor("#2946E6"));
        }
        return baseDialog;
    }

    static /* synthetic */ void a(String str, Activity activity, View view) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        y1.a(activity, str);
    }

    public static Dialog a(Activity activity, IOneClickListener iOneClickListener) {
        return a(activity, "诈骗预警功能开启", "诈骗预警功能需要开启悬浮窗、电话、短信权限，可用来识别诈骗来电、诈骗短信、诈骗APP", iOneClickListener);
    }

    public static Dialog a(Activity activity, String str, String str2, final IOneClickListener iOneClickListener) {
        if (activity == null || activity.isFinishing()) {
            return null;
        }
        final BaseDialog baseDialog = new BaseDialog(activity, R.style.base_dialog_style);
        baseDialog.setContentView(R.layout.flow_primiss_dialog);
        baseDialog.setGravityLayout(2);
        baseDialog.setWidthDialog(-2.0d);
        baseDialog.setHeightDialog(-2.0d);
        baseDialog.setCancelable(false);
        baseDialog.setCanceledOnTouchOutside(false);
        baseDialog.initOnCreate();
        baseDialog.show();
        TextView textView = (TextView) baseDialog.findViewById(R.id.customdialog_title);
        TextView textView2 = (TextView) baseDialog.findViewById(R.id.customdialog_subtitle);
        Button button = (Button) baseDialog.findViewById(R.id.confirm_btn);
        textView.setText(str);
        textView2.setText(str2);
        button.setOnClickListener(new View.OnClickListener() { // from class: util.m0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                b1.a(iOneClickListener, baseDialog, view);
            }
        });
        return baseDialog;
    }

    static /* synthetic */ void a(IOneClickListener iOneClickListener, BaseDialog baseDialog, View view) {
        if (iOneClickListener != null) {
            iOneClickListener.clickOKBtn();
        }
        baseDialog.dismiss();
    }

    static /* synthetic */ void a(BaseDialog baseDialog, IClickListener iClickListener, View view) {
        baseDialog.dismiss();
        if (iClickListener != null) {
            iClickListener.cancelBtn();
        }
    }

    public static void a(Activity activity, String str) {
        a(str, true, activity);
    }

    public static void a(String str, boolean z, Activity activity) {
        if (activity != null) {
            try {
                if (activity.isFinishing()) {
                    return;
                }
                if (f20734a == null) {
                    f20734a = ui.view.s.a(activity);
                }
                f20734a.a(str);
                f20734a.setCanceledOnTouchOutside(false);
                f20734a.setCancelable(z);
                f20734a.show();
            } catch (Exception unused) {
            }
        }
    }

    public static void a() {
        try {
            if (f20734a != null) {
                if (f20734a.isShowing()) {
                    f20734a.dismiss();
                }
                f20734a = null;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static Dialog a(Activity activity, String str, String str2, final IEditClickListener iEditClickListener) {
        if (activity == null || activity.isFinishing()) {
            return null;
        }
        final BaseDialog baseDialog = new BaseDialog(activity, R.style.base_dialog_style);
        baseDialog.setContentView(R.layout.custom_edit_dialog);
        baseDialog.setGravityLayout(2);
        baseDialog.setWidthDialog(-2.0d);
        baseDialog.setHeightDialog(-2.0d);
        baseDialog.setCancelable(false);
        baseDialog.setCanceledOnTouchOutside(false);
        baseDialog.initOnCreate();
        baseDialog.show();
        final EditText editText = (EditText) baseDialog.findViewById(R.id.et_content);
        Button button = (Button) baseDialog.findViewById(R.id.cancel_btn);
        Button button2 = (Button) baseDialog.findViewById(R.id.confirm_btn);
        d1.b(editText, 8);
        button.setText(str);
        button2.setText(str2);
        button.setOnClickListener(new View.OnClickListener() { // from class: util.k0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                b1.a(iEditClickListener, baseDialog, view);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: util.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                b1.a(iEditClickListener, editText, baseDialog, view);
            }
        });
        return baseDialog;
    }

    static /* synthetic */ void a(IEditClickListener iEditClickListener, BaseDialog baseDialog, View view) {
        if (iEditClickListener != null) {
            iEditClickListener.cancelBtn();
        }
        baseDialog.dismiss();
    }

    static /* synthetic */ void a(IEditClickListener iEditClickListener, EditText editText, BaseDialog baseDialog, View view) {
        if (iEditClickListener != null) {
            iEditClickListener.clickOKBtn(editText.getText().toString());
        }
        baseDialog.dismiss();
    }

    public static Dialog a(Activity activity, final IClickListener iClickListener) {
        if (activity == null || activity.isFinishing()) {
            return null;
        }
        final BaseDialog baseDialog = new BaseDialog(activity, R.style.base_dialog_style);
        baseDialog.setContentView(R.layout.verify_tips_dialog);
        baseDialog.setGravityLayout(2);
        baseDialog.setWidthDialog(-2.0d);
        baseDialog.setHeightDialog(-2.0d);
        baseDialog.setCancelable(false);
        baseDialog.setCanceledOnTouchOutside(false);
        baseDialog.initOnCreate();
        baseDialog.show();
        Button button = (Button) baseDialog.findViewById(R.id.cancel_btn);
        Button button2 = (Button) baseDialog.findViewById(R.id.confirm_btn);
        ImageView imageView = (ImageView) baseDialog.findViewById(R.id.iv_colse);
        button.setOnClickListener(new View.OnClickListener() { // from class: util.n0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                b1.v(iClickListener, baseDialog, view);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: util.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                b1.w(iClickListener, baseDialog, view);
            }
        });
        imageView.setOnClickListener(new View.OnClickListener() { // from class: util.y
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                baseDialog.dismiss();
            }
        });
        return baseDialog;
    }

    public static Dialog a(Activity activity, NoteDlgBean noteDlgBean, final IOneClickListener iOneClickListener) {
        if (activity == null || activity.isFinishing()) {
            return null;
        }
        final BaseDialog baseDialog = new BaseDialog(activity, R.style.base_dialog_style);
        baseDialog.setContentView(R.layout.custom_note_dialog);
        baseDialog.setGravityLayout(2);
        baseDialog.setWidthDialogdp(-2.0f);
        baseDialog.setHeightDialogdp(-2.0f);
        baseDialog.setCancelable(false);
        baseDialog.setCanceledOnTouchOutside(false);
        baseDialog.initOnCreate();
        baseDialog.show();
        TextView textView = (TextView) baseDialog.findViewById(R.id.title);
        final TextView textView2 = (TextView) baseDialog.findViewById(R.id.content);
        Button button = (Button) baseDialog.findViewById(R.id.confirm_btn);
        textView.setText(Html.fromHtml(noteDlgBean.getTitle()));
        textView2.setText(Html.fromHtml(noteDlgBean.getContent()));
        textView2.setMovementMethod(new ScrollingMovementMethod());
        textView2.setOnTouchListener(new View.OnTouchListener() { // from class: util.k
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return b1.a(textView2, view, motionEvent);
            }
        });
        button.setOnClickListener(new View.OnClickListener() { // from class: util.n
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                b1.b(iOneClickListener, baseDialog, view);
            }
        });
        return baseDialog;
    }

    static /* synthetic */ boolean a(TextView textView, View view, MotionEvent motionEvent) {
        textView.getParent().requestDisallowInterceptTouchEvent(true);
        return false;
    }

    public static Dialog a(int i2, final Activity activity, String str, String str2, String str3, String str4, final IClickListener iClickListener) {
        if (activity == null || activity.isFinishing()) {
            return null;
        }
        final BaseDialog baseDialog = new BaseDialog(activity, R.style.base_dialog_style);
        baseDialog.setContentView(R.layout.custom_bt_dialog);
        baseDialog.setGravityLayout(2);
        baseDialog.setWidthDialog(-2.0d);
        baseDialog.setHeightDialog(-2.0d);
        baseDialog.setCancelable(false);
        baseDialog.setCanceledOnTouchOutside(false);
        baseDialog.initOnCreate();
        baseDialog.show();
        TextView textView = (TextView) baseDialog.findViewById(R.id.customdialog_title);
        TextView textView2 = (TextView) baseDialog.findViewById(R.id.customdialog_subtitle);
        ImageView imageView = (ImageView) baseDialog.findViewById(R.id.iv_close);
        Button button = (Button) baseDialog.findViewById(R.id.cancel_btn);
        Button button2 = (Button) baseDialog.findViewById(R.id.confirm_btn);
        imageView.setVisibility(0);
        textView.setText(str);
        textView2.setText(str2);
        textView2.setTextColor(Color.parseColor("#999999"));
        button.setText(str3);
        button2.setText(str4);
        button2.setTextColor(-14072090);
        button.setTextColor(-14072090);
        if (i2 <= 0) {
            button.setEnabled(false);
            button.setTextColor(Color.parseColor("#999999"));
        }
        imageView.setOnClickListener(new View.OnClickListener() { // from class: util.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                b1.a(baseDialog, activity, view);
            }
        });
        button.setOnClickListener(new View.OnClickListener() { // from class: util.h0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                b1.b(iClickListener, view);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: util.l0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                b1.c(iClickListener, view);
            }
        });
        return baseDialog;
    }

    static /* synthetic */ void a(BaseDialog baseDialog, Activity activity, View view) {
        baseDialog.dismiss();
        activity.finish();
    }

    public static Dialog a(Activity activity) {
        if (activity == null || activity.isFinishing()) {
            return null;
        }
        final BaseDialog baseDialog = new BaseDialog(activity, R.style.base_dialog_style);
        baseDialog.setContentView(R.layout.custom_wb_dialog);
        baseDialog.setGravityLayout(2);
        baseDialog.setWidthDialog(-2.0d);
        baseDialog.setHeightDialog(-2.0d);
        baseDialog.setCancelable(false);
        baseDialog.setCanceledOnTouchOutside(false);
        baseDialog.initOnCreate();
        baseDialog.show();
        ((TextView) baseDialog.findViewById(R.id.tv_done)).setOnClickListener(new View.OnClickListener() { // from class: util.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                baseDialog.dismiss();
            }
        });
        return baseDialog;
    }
}
