package ui.activity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import bean.CallBean;
import bean.UploadFileBean;
import butterknife.BindView;
import butterknife.OnClick;
import com.hicorenational.antifraud.R;
import java.io.Serializable;
import java.util.List;
import ui.Hicore;
import ui.view.swip.SwipBackLayout;

/* compiled from: SignCallDetailActivity.kt */
@h.y(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010/\u001a\u000200H\u0016J\u0010\u00101\u001a\u0002002\u0006\u00102\u001a\u00020\u001bH\u0007J\b\u00103\u001a\u000204H\u0016J\b\u00105\u001a\u000200H\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0011\u001a\u00020\u00128\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0017\u001a\u00020\u00128\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R\u001e\u0010\u001a\u001a\u00020\u001b8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001e\u0010 \u001a\u00020!8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001e\u0010&\u001a\u00020\u00048\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0006\"\u0004\b(\u0010\bR\u001e\u0010)\u001a\u00020\u00048\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0006\"\u0004\b+\u0010\bR\u001e\u0010,\u001a\u00020\u00048\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u0006\"\u0004\b.\u0010\b¨\u00066"}, d2 = {"Lui/activity/SignCallDetailActivity;", "Lui/activity/BaseActivity;", "()V", "mAudioNum", "Landroid/widget/TextView;", "getMAudioNum", "()Landroid/widget/TextView;", "setMAudioNum", "(Landroid/widget/TextView;)V", "mBtnConfirm", "Landroid/widget/Button;", "getMBtnConfirm", "()Landroid/widget/Button;", "setMBtnConfirm", "(Landroid/widget/Button;)V", "mCallBean", "Lbean/CallBean;", "mEtPhone", "Landroid/widget/EditText;", "getMEtPhone", "()Landroid/widget/EditText;", "setMEtPhone", "(Landroid/widget/EditText;)V", "mEtVictimPhone", "getMEtVictimPhone", "setMEtVictimPhone", "mLlClause", "Landroid/view/View;", "getMLlClause", "()Landroid/view/View;", "setMLlClause", "(Landroid/view/View;)V", "mTCbSelect", "Landroid/widget/CheckBox;", "getMTCbSelect", "()Landroid/widget/CheckBox;", "setMTCbSelect", "(Landroid/widget/CheckBox;)V", "mTvDuration", "getMTvDuration", "setMTvDuration", "mTvOccurTime", "getMTvOccurTime", "setMTvOccurTime", "mTvTitle", "getMTvTitle", "setMTvTitle", "initPage", "", "onViewClicked", "view", "setLayoutView", "", "showData", "app_offic_flavorRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes2.dex */
public final class SignCallDetailActivity extends BaseActivity {

    /* renamed from: a, reason: collision with root package name */
    private CallBean f18922a;

    @BindView(R.id.tv_audio_num)
    @i.c.a.d
    public TextView mAudioNum;

    @BindView(R.id.btn_confirm)
    @i.c.a.d
    public Button mBtnConfirm;

    @BindView(R.id.et_phone)
    @i.c.a.d
    public EditText mEtPhone;

    @BindView(R.id.et_victim_phone)
    @i.c.a.d
    public EditText mEtVictimPhone;

    @BindView(R.id.ll_clause)
    @i.c.a.d
    public View mLlClause;

    @BindView(R.id.cb_select)
    @i.c.a.d
    public CheckBox mTCbSelect;

    @BindView(R.id.tv_duration)
    @i.c.a.d
    public TextView mTvDuration;

    @BindView(R.id.tv_occur_time)
    @i.c.a.d
    public TextView mTvOccurTime;

    @BindView(R.id.tv_title)
    @i.c.a.d
    public TextView mTvTitle;

    private final void showData() {
        Button button = this.mBtnConfirm;
        if (button == null) {
            h.q2.t.i0.k("mBtnConfirm");
        }
        if (button == null) {
            h.q2.t.i0.f();
        }
        button.setVisibility(8);
        EditText editText = this.mEtPhone;
        if (editText == null) {
            h.q2.t.i0.k("mEtPhone");
        }
        if (editText == null) {
            h.q2.t.i0.f();
        }
        editText.setFocusable(false);
        TextView textView = this.mTvOccurTime;
        if (textView == null) {
            h.q2.t.i0.k("mTvOccurTime");
        }
        if (textView == null) {
            h.q2.t.i0.f();
        }
        textView.setEnabled(false);
        TextView textView2 = this.mTvDuration;
        if (textView2 == null) {
            h.q2.t.i0.k("mTvDuration");
        }
        if (textView2 == null) {
            h.q2.t.i0.f();
        }
        textView2.setEnabled(false);
        EditText editText2 = this.mEtVictimPhone;
        if (editText2 == null) {
            h.q2.t.i0.k("mEtVictimPhone");
        }
        if (editText2 == null) {
            h.q2.t.i0.f();
        }
        editText2.setEnabled(false);
        CheckBox checkBox = this.mTCbSelect;
        if (checkBox == null) {
            h.q2.t.i0.k("mTCbSelect");
        }
        if (checkBox == null) {
            h.q2.t.i0.f();
        }
        checkBox.setEnabled(false);
        TextView textView3 = this.mTvOccurTime;
        if (textView3 == null) {
            h.q2.t.i0.k("mTvOccurTime");
        }
        if (textView3 == null) {
            h.q2.t.i0.f();
        }
        textView3.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        TextView textView4 = this.mTvDuration;
        if (textView4 == null) {
            h.q2.t.i0.k("mTvDuration");
        }
        if (textView4 == null) {
            h.q2.t.i0.f();
        }
        textView4.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        TextView textView5 = this.mAudioNum;
        if (textView5 == null) {
            h.q2.t.i0.k("mAudioNum");
        }
        if (textView5 == null) {
            h.q2.t.i0.f();
        }
        textView5.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        EditText editText3 = this.mEtVictimPhone;
        if (editText3 == null) {
            h.q2.t.i0.k("mEtVictimPhone");
        }
        if (editText3 == null) {
            h.q2.t.i0.f();
        }
        CallBean callBean = this.f18922a;
        if (callBean == null) {
            h.q2.t.i0.f();
        }
        editText3.setText(callBean.getVictimMobile());
        EditText editText4 = this.mEtPhone;
        if (editText4 == null) {
            h.q2.t.i0.k("mEtPhone");
        }
        if (editText4 == null) {
            h.q2.t.i0.f();
        }
        CallBean callBean2 = this.f18922a;
        if (callBean2 == null) {
            h.q2.t.i0.f();
        }
        editText4.setText(callBean2.getSuspectMobile());
        CallBean callBean3 = this.f18922a;
        if ((callBean3 != null ? callBean3.getSwindleTelTypeText() : null) != null) {
            CallBean callBean4 = this.f18922a;
            if (h.z2.b0.c(callBean4 != null ? callBean4.getSwindleTelTypeText() : null, "FaceTime", true)) {
                View view = this.mLlClause;
                if (view == null) {
                    h.q2.t.i0.k("mLlClause");
                }
                if (view != null) {
                    view.setVisibility(0);
                }
                CheckBox checkBox2 = this.mTCbSelect;
                if (checkBox2 == null) {
                    h.q2.t.i0.k("mTCbSelect");
                }
                if (checkBox2 != null) {
                    checkBox2.setChecked(true);
                }
            }
        }
        TextView textView6 = this.mTvOccurTime;
        if (textView6 == null) {
            h.q2.t.i0.k("mTvOccurTime");
        }
        if (textView6 == null) {
            h.q2.t.i0.f();
        }
        CallBean callBean5 = this.f18922a;
        textView6.setText(callBean5 != null ? callBean5.getTalkTime() : null);
        TextView textView7 = this.mTvDuration;
        if (textView7 == null) {
            h.q2.t.i0.k("mTvDuration");
        }
        if (textView7 == null) {
            h.q2.t.i0.f();
        }
        CallBean callBean6 = this.f18922a;
        textView7.setText(callBean6 != null ? callBean6.getCallDuration() : null);
        CallBean callBean7 = this.f18922a;
        if (callBean7 == null) {
            h.q2.t.i0.f();
        }
        if (callBean7.getCallTelDetails() == null) {
            TextView textView8 = this.mAudioNum;
            if (textView8 == null) {
                h.q2.t.i0.k("mAudioNum");
            }
            textView8.setText("");
            return;
        }
        TextView textView9 = this.mAudioNum;
        if (textView9 == null) {
            h.q2.t.i0.k("mAudioNum");
        }
        StringBuilder sb = new StringBuilder();
        CallBean callBean8 = this.f18922a;
        List<UploadFileBean> callTelDetails = callBean8 != null ? callBean8.getCallTelDetails() : null;
        if (callTelDetails == null) {
            h.q2.t.i0.f();
        }
        sb.append(String.valueOf(callTelDetails.size()));
        sb.append("条");
        textView9.setText(sb.toString());
        TextView textView10 = this.mAudioNum;
        if (textView10 == null) {
            h.q2.t.i0.k("mAudioNum");
        }
        textView10.setTextColor(Color.parseColor("#333333"));
    }

    @i.c.a.d
    public final TextView getMAudioNum() {
        TextView textView = this.mAudioNum;
        if (textView == null) {
            h.q2.t.i0.k("mAudioNum");
        }
        return textView;
    }

    @i.c.a.d
    public final Button getMBtnConfirm() {
        Button button = this.mBtnConfirm;
        if (button == null) {
            h.q2.t.i0.k("mBtnConfirm");
        }
        return button;
    }

    @i.c.a.d
    public final EditText getMEtPhone() {
        EditText editText = this.mEtPhone;
        if (editText == null) {
            h.q2.t.i0.k("mEtPhone");
        }
        return editText;
    }

    @i.c.a.d
    public final EditText getMEtVictimPhone() {
        EditText editText = this.mEtVictimPhone;
        if (editText == null) {
            h.q2.t.i0.k("mEtVictimPhone");
        }
        return editText;
    }

    @i.c.a.d
    public final View getMLlClause() {
        View view = this.mLlClause;
        if (view == null) {
            h.q2.t.i0.k("mLlClause");
        }
        return view;
    }

    @i.c.a.d
    public final CheckBox getMTCbSelect() {
        CheckBox checkBox = this.mTCbSelect;
        if (checkBox == null) {
            h.q2.t.i0.k("mTCbSelect");
        }
        return checkBox;
    }

    @i.c.a.d
    public final TextView getMTvDuration() {
        TextView textView = this.mTvDuration;
        if (textView == null) {
            h.q2.t.i0.k("mTvDuration");
        }
        return textView;
    }

    @i.c.a.d
    public final TextView getMTvOccurTime() {
        TextView textView = this.mTvOccurTime;
        if (textView == null) {
            h.q2.t.i0.k("mTvOccurTime");
        }
        return textView;
    }

    @i.c.a.d
    public final TextView getMTvTitle() {
        TextView textView = this.mTvTitle;
        if (textView == null) {
            h.q2.t.i0.k("mTvTitle");
        }
        return textView;
    }

    @Override // ui.activity.BaseActivity
    public void initPage() {
        SwipBackLayout.a(this.mActivity).a();
        TextView textView = this.mTvTitle;
        if (textView == null) {
            h.q2.t.i0.k("mTvTitle");
        }
        if (textView == null) {
            h.q2.t.i0.f();
        }
        textView.setText("通话类嫌疑人电话详情");
        this.f18922a = (CallBean) getIntent().getSerializableExtra(util.k1.f20845c);
        showData();
    }

    @OnClick({R.id.iv_back, R.id.tv_audio_num})
    public final void onViewClicked(@i.c.a.d View view) {
        h.q2.t.i0.f(view, "view");
        Hicore app = Hicore.getApp();
        h.q2.t.i0.a((Object) app, "Hicore.getApp()");
        if (app.isDouble()) {
            return;
        }
        int id = view.getId();
        if (id == R.id.iv_back) {
            finish();
            return;
        }
        if (id != R.id.tv_audio_num) {
            return;
        }
        Intent intent = new Intent(this, (Class<?>) SurveyAudioActivity.class);
        CallBean callBean = this.f18922a;
        if (callBean == null) {
            h.q2.t.i0.f();
        }
        if (callBean.getCallTelDetails() != null) {
            CallBean callBean2 = this.f18922a;
            if (callBean2 == null) {
                h.q2.t.i0.f();
            }
            if (callBean2.getCallTelDetails().size() > 0) {
                CallBean callBean3 = this.f18922a;
                if (callBean3 == null) {
                    h.q2.t.i0.f();
                }
                List<UploadFileBean> callTelDetails = callBean3.getCallTelDetails();
                if (callTelDetails == null) {
                    throw new h.e1("null cannot be cast to non-null type java.io.Serializable");
                }
                intent.putExtra(util.k1.p, (Serializable) callTelDetails);
                startActivity(intent);
            }
        }
    }

    @Override // ui.activity.BaseActivity
    public int setLayoutView() {
        return R.layout.activity_call_criminal_add;
    }

    public final void setMAudioNum(@i.c.a.d TextView textView) {
        h.q2.t.i0.f(textView, "<set-?>");
        this.mAudioNum = textView;
    }

    public final void setMBtnConfirm(@i.c.a.d Button button) {
        h.q2.t.i0.f(button, "<set-?>");
        this.mBtnConfirm = button;
    }

    public final void setMEtPhone(@i.c.a.d EditText editText) {
        h.q2.t.i0.f(editText, "<set-?>");
        this.mEtPhone = editText;
    }

    public final void setMEtVictimPhone(@i.c.a.d EditText editText) {
        h.q2.t.i0.f(editText, "<set-?>");
        this.mEtVictimPhone = editText;
    }

    public final void setMLlClause(@i.c.a.d View view) {
        h.q2.t.i0.f(view, "<set-?>");
        this.mLlClause = view;
    }

    public final void setMTCbSelect(@i.c.a.d CheckBox checkBox) {
        h.q2.t.i0.f(checkBox, "<set-?>");
        this.mTCbSelect = checkBox;
    }

    public final void setMTvDuration(@i.c.a.d TextView textView) {
        h.q2.t.i0.f(textView, "<set-?>");
        this.mTvDuration = textView;
    }

    public final void setMTvOccurTime(@i.c.a.d TextView textView) {
        h.q2.t.i0.f(textView, "<set-?>");
        this.mTvOccurTime = textView;
    }

    public final void setMTvTitle(@i.c.a.d TextView textView) {
        h.q2.t.i0.f(textView, "<set-?>");
        this.mTvTitle = textView;
    }
}
