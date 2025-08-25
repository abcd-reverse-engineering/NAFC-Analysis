package ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import com.hicorenational.antifraud.R;
import com.umeng.analytics.pro.bh;
import ui.view.swip.SwipBackLayout;

/* compiled from: LogoutReasonActivity.kt */
@h.y(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010.\u001a\u00020/J\b\u00100\u001a\u00020/H\u0016J\u0010\u00101\u001a\u00020/2\u0006\u00102\u001a\u00020\u0010H\u0007J\b\u00103\u001a\u00020\u001cH\u0016R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0015\u001a\u00020\u00168\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\u001cX\u0082D¢\u0006\u0002\n\u0000R\u001e\u0010\u001d\u001a\u00020\u001e8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001e\u0010#\u001a\u00020$8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001e\u0010)\u001a\u00020$8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010&\"\u0004\b+\u0010(R\u000e\u0010,\u001a\u00020-X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00064"}, d2 = {"Lui/activity/LogoutReasonActivity;", "Lui/activity/BaseActivity;", "()V", "mConfim", "Landroid/widget/Button;", "getMConfim", "()Landroid/widget/Button;", "setMConfim", "(Landroid/widget/Button;)V", "mEtOtherReson", "Landroid/widget/EditText;", "getMEtOtherReson", "()Landroid/widget/EditText;", "setMEtOtherReson", "(Landroid/widget/EditText;)V", "mFlOtherEdit", "Landroid/view/View;", "getMFlOtherEdit", "()Landroid/view/View;", "setMFlOtherEdit", "(Landroid/view/View;)V", "mIvBack", "Landroid/widget/ImageView;", "getMIvBack", "()Landroid/widget/ImageView;", "setMIvBack", "(Landroid/widget/ImageView;)V", "mMaxCount", "", "mRbGroup", "Landroid/widget/RadioGroup;", "getMRbGroup", "()Landroid/widget/RadioGroup;", "setMRbGroup", "(Landroid/widget/RadioGroup;)V", "mTvTitle", "Landroid/widget/TextView;", "getMTvTitle", "()Landroid/widget/TextView;", "setMTvTitle", "(Landroid/widget/TextView;)V", "mTvWords", "getMTvWords", "setMTvWords", "reaseon", "", "initListener", "", "initPage", "onClick", "view", "setLayoutView", "app_offic_flavorRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes2.dex */
public final class LogoutReasonActivity extends BaseActivity {

    /* renamed from: a, reason: collision with root package name */
    private final int f18316a = 500;

    /* renamed from: b, reason: collision with root package name */
    private String f18317b = "安全/隐私顾虑";

    @BindView(R.id.confirm)
    @i.c.a.d
    public Button mConfim;

    @BindView(R.id.et_other_reson)
    @i.c.a.d
    public EditText mEtOtherReson;

    @BindView(R.id.fl_other_edit)
    @i.c.a.d
    public View mFlOtherEdit;

    @BindView(R.id.iv_back)
    @i.c.a.d
    public ImageView mIvBack;

    @BindView(R.id.rg_group)
    @i.c.a.d
    public RadioGroup mRbGroup;

    @BindView(R.id.tv_title)
    @i.c.a.d
    public TextView mTvTitle;

    @BindView(R.id.tv_words)
    @i.c.a.d
    public TextView mTvWords;

    /* compiled from: LogoutReasonActivity.kt */
    static final class a implements RadioGroup.OnCheckedChangeListener {
        a() {
        }

        @Override // android.widget.RadioGroup.OnCheckedChangeListener
        public final void onCheckedChanged(RadioGroup radioGroup, int i2) {
            switch (i2) {
                case R.id.rb_app /* 2131297129 */:
                    LogoutReasonActivity.this.f18317b = "产品使用体验问题";
                    LogoutReasonActivity.this.b().setVisibility(8);
                    break;
                case R.id.rb_not_me /* 2131297132 */:
                    LogoutReasonActivity.this.f18317b = "非本人注册的账号";
                    LogoutReasonActivity.this.b().setVisibility(8);
                    break;
                case R.id.rb_other /* 2131297133 */:
                    LogoutReasonActivity.this.f18317b = "";
                    LogoutReasonActivity.this.b().setVisibility(0);
                    break;
                case R.id.rb_regist_new /* 2131297138 */:
                    LogoutReasonActivity.this.f18317b = "需要注册新的账号";
                    LogoutReasonActivity.this.b().setVisibility(8);
                    break;
                case R.id.rb_safety /* 2131297139 */:
                    LogoutReasonActivity.this.f18317b = "安全/隐私顾虑";
                    LogoutReasonActivity.this.b().setVisibility(8);
                    break;
            }
        }
    }

    /* compiled from: LogoutReasonActivity.kt */
    public static final class b implements TextWatcher {
        b() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(@i.c.a.d Editable editable) {
            h.q2.t.i0.f(editable, bh.aE);
            LogoutReasonActivity.this.f18317b = editable.toString();
            int length = editable.length();
            if (!TextUtils.isEmpty(h.z2.b0.a(editable.toString(), c.c.a.b.a.a.f3100g, "", false, 4, (Object) null)) && length > LogoutReasonActivity.this.f18316a) {
                LogoutReasonActivity.this.a().setText(editable.subSequence(0, LogoutReasonActivity.this.f18316a));
                LogoutReasonActivity.this.a().requestFocus();
                LogoutReasonActivity.this.a().setSelection(LogoutReasonActivity.this.f18316a);
            }
            LogoutReasonActivity.this.d().setText(length + "/500");
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(@i.c.a.d CharSequence charSequence, int i2, int i3, int i4) {
            h.q2.t.i0.f(charSequence, bh.aE);
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(@i.c.a.d CharSequence charSequence, int i2, int i3, int i4) {
            h.q2.t.i0.f(charSequence, bh.aE);
        }
    }

    @i.c.a.d
    public final RadioGroup c() {
        RadioGroup radioGroup = this.mRbGroup;
        if (radioGroup == null) {
            h.q2.t.i0.k("mRbGroup");
        }
        return radioGroup;
    }

    @i.c.a.d
    public final TextView d() {
        TextView textView = this.mTvWords;
        if (textView == null) {
            h.q2.t.i0.k("mTvWords");
        }
        return textView;
    }

    @i.c.a.d
    public final Button getMConfim() {
        Button button = this.mConfim;
        if (button == null) {
            h.q2.t.i0.k("mConfim");
        }
        return button;
    }

    @i.c.a.d
    public final ImageView getMIvBack() {
        ImageView imageView = this.mIvBack;
        if (imageView == null) {
            h.q2.t.i0.k("mIvBack");
        }
        return imageView;
    }

    @i.c.a.d
    public final TextView getMTvTitle() {
        TextView textView = this.mTvTitle;
        if (textView == null) {
            h.q2.t.i0.k("mTvTitle");
        }
        return textView;
    }

    public final void initListener() {
        RadioGroup radioGroup = this.mRbGroup;
        if (radioGroup == null) {
            h.q2.t.i0.k("mRbGroup");
        }
        radioGroup.setOnCheckedChangeListener(new a());
        EditText editText = this.mEtOtherReson;
        if (editText == null) {
            h.q2.t.i0.k("mEtOtherReson");
        }
        util.d1.a(editText, this.f18316a);
        EditText editText2 = this.mEtOtherReson;
        if (editText2 == null) {
            h.q2.t.i0.k("mEtOtherReson");
        }
        editText2.addTextChangedListener(new b());
    }

    @Override // ui.activity.BaseActivity
    public void initPage() {
        ui.statusbarcompat.b.a((Activity) this, true, true);
        SwipBackLayout.a(this.mActivity).a();
        TextView textView = this.mTvTitle;
        if (textView == null) {
            h.q2.t.i0.k("mTvTitle");
        }
        if (textView == null) {
            h.q2.t.i0.f();
        }
        textView.setText("注销账号");
        initListener();
    }

    @OnClick({R.id.iv_back, R.id.confirm})
    public final void onClick(@i.c.a.d View view) {
        h.q2.t.i0.f(view, "view");
        if (isDouble()) {
            return;
        }
        int id = view.getId();
        if (id != R.id.confirm) {
            if (id != R.id.iv_back) {
                return;
            }
            onBackPressed();
        } else {
            Intent intent = new Intent(this.mActivity, (Class<?>) LogoutSmsCodeActivity.class);
            intent.putExtra(util.k1.f0, this.f18317b);
            startActivity(intent);
        }
    }

    @Override // ui.activity.BaseActivity
    public int setLayoutView() {
        return R.layout.activity_logout_reason;
    }

    public final void setMConfim(@i.c.a.d Button button) {
        h.q2.t.i0.f(button, "<set-?>");
        this.mConfim = button;
    }

    public final void setMFlOtherEdit(@i.c.a.d View view) {
        h.q2.t.i0.f(view, "<set-?>");
        this.mFlOtherEdit = view;
    }

    public final void setMIvBack(@i.c.a.d ImageView imageView) {
        h.q2.t.i0.f(imageView, "<set-?>");
        this.mIvBack = imageView;
    }

    public final void setMTvTitle(@i.c.a.d TextView textView) {
        h.q2.t.i0.f(textView, "<set-?>");
        this.mTvTitle = textView;
    }

    @i.c.a.d
    public final View b() {
        View view = this.mFlOtherEdit;
        if (view == null) {
            h.q2.t.i0.k("mFlOtherEdit");
        }
        return view;
    }

    public final void a(@i.c.a.d RadioGroup radioGroup) {
        h.q2.t.i0.f(radioGroup, "<set-?>");
        this.mRbGroup = radioGroup;
    }

    @i.c.a.d
    public final EditText a() {
        EditText editText = this.mEtOtherReson;
        if (editText == null) {
            h.q2.t.i0.k("mEtOtherReson");
        }
        return editText;
    }

    public final void a(@i.c.a.d EditText editText) {
        h.q2.t.i0.f(editText, "<set-?>");
        this.mEtOtherReson = editText;
    }

    public final void a(@i.c.a.d TextView textView) {
        h.q2.t.i0.f(textView, "<set-?>");
        this.mTvWords = textView;
    }
}
