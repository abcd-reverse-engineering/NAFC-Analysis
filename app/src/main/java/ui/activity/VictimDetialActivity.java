package ui.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import bean.SurveyPeopleBean;
import butterknife.BindView;
import butterknife.OnClick;
import com.hicorenational.antifraud.R;

/* compiled from: VictimDetialActivity.kt */
@h.y(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010'\u001a\u00020(H\u0016J\u0006\u0010)\u001a\u00020(J\u0010\u0010*\u001a\u00020(2\u0006\u0010+\u001a\u00020,H\u0007J\b\u0010-\u001a\u00020.H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0015\u001a\u00020\n8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\f\"\u0004\b\u0017\u0010\u000eR\u001e\u0010\u0018\u001a\u00020\n8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\f\"\u0004\b\u001a\u0010\u000eR\u001e\u0010\u001b\u001a\u00020\n8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\f\"\u0004\b\u001d\u0010\u000eR\u001e\u0010\u001e\u001a\u00020\n8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\f\"\u0004\b \u0010\u000eR\u001c\u0010!\u001a\u0004\u0018\u00010\"X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&¨\u0006/"}, d2 = {"Lui/activity/VictimDetialActivity;", "Lui/activity/BaseActivity;", "()V", "documNumber", "", "getDocumNumber", "()Ljava/lang/String;", "setDocumNumber", "(Ljava/lang/String;)V", "mEtPeopCredentNumber", "Landroid/widget/TextView;", "getMEtPeopCredentNumber", "()Landroid/widget/TextView;", "setMEtPeopCredentNumber", "(Landroid/widget/TextView;)V", "mIvBack", "Landroid/widget/ImageView;", "getMIvBack", "()Landroid/widget/ImageView;", "setMIvBack", "(Landroid/widget/ImageView;)V", "mTvPeopCredentType", "getMTvPeopCredentType", "setMTvPeopCredentType", "mTvPeopName", "getMTvPeopName", "setMTvPeopName", "mTvPeopPhone", "getMTvPeopPhone", "setMTvPeopPhone", "mTvTitle", "getMTvTitle", "setMTvTitle", "stepTwoBean", "Lbean/SurveyPeopleBean;", "getStepTwoBean", "()Lbean/SurveyPeopleBean;", "setStepTwoBean", "(Lbean/SurveyPeopleBean;)V", "initPage", "", "initViewData", "onClick", "view", "Landroid/view/View;", "setLayoutView", "", "app_offic_flavorRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes2.dex */
public final class VictimDetialActivity extends BaseActivity {

    /* renamed from: a, reason: collision with root package name */
    @i.c.a.e
    private SurveyPeopleBean f19206a;

    /* renamed from: b, reason: collision with root package name */
    @i.c.a.d
    private String f19207b = "";

    @BindView(R.id.et_peop_credent_number)
    @i.c.a.d
    public TextView mEtPeopCredentNumber;

    @BindView(R.id.iv_back)
    @i.c.a.d
    public ImageView mIvBack;

    @BindView(R.id.tv_peop_credent_type)
    @i.c.a.d
    public TextView mTvPeopCredentType;

    @BindView(R.id.tv_peop_name)
    @i.c.a.d
    public TextView mTvPeopName;

    @BindView(R.id.tv_num_phone)
    @i.c.a.d
    public TextView mTvPeopPhone;

    @BindView(R.id.tv_title)
    @i.c.a.d
    public TextView mTvTitle;

    public final void a(@i.c.a.d TextView textView) {
        h.q2.t.i0.f(textView, "<set-?>");
        this.mEtPeopCredentNumber = textView;
    }

    public final void b(@i.c.a.d TextView textView) {
        h.q2.t.i0.f(textView, "<set-?>");
        this.mTvPeopName = textView;
    }

    public final void c(@i.c.a.d TextView textView) {
        h.q2.t.i0.f(textView, "<set-?>");
        this.mTvPeopPhone = textView;
    }

    @i.c.a.d
    public final TextView getMEtPeopCredentNumber() {
        TextView textView = this.mEtPeopCredentNumber;
        if (textView == null) {
            h.q2.t.i0.k("mEtPeopCredentNumber");
        }
        return textView;
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
    public final TextView getMTvPeopCredentType() {
        TextView textView = this.mTvPeopCredentType;
        if (textView == null) {
            h.q2.t.i0.k("mTvPeopCredentType");
        }
        return textView;
    }

    @i.c.a.d
    public final TextView getMTvPeopName() {
        TextView textView = this.mTvPeopName;
        if (textView == null) {
            h.q2.t.i0.k("mTvPeopName");
        }
        return textView;
    }

    @i.c.a.d
    public final TextView getMTvPeopPhone() {
        TextView textView = this.mTvPeopPhone;
        if (textView == null) {
            h.q2.t.i0.k("mTvPeopPhone");
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

    @i.c.a.e
    public final SurveyPeopleBean getStepTwoBean() {
        return this.f19206a;
    }

    @Override // ui.activity.BaseActivity
    public void initPage() {
        TextView textView = this.mTvTitle;
        if (textView == null) {
            h.q2.t.i0.k("mTvTitle");
        }
        if (textView == null) {
            h.q2.t.i0.f();
        }
        textView.setText("事主信息详情");
        initViewData();
    }

    public final void initViewData() {
        this.f19206a = (SurveyPeopleBean) getIntent().getSerializableExtra(util.k1.f20845c);
        if (this.f19206a != null) {
            TextView textView = this.mTvPeopName;
            if (textView == null) {
                h.q2.t.i0.k("mTvPeopName");
            }
            SurveyPeopleBean surveyPeopleBean = this.f19206a;
            textView.setText(surveyPeopleBean != null ? surveyPeopleBean.getPeopleName() : null);
            TextView textView2 = this.mTvPeopPhone;
            if (textView2 == null) {
                h.q2.t.i0.k("mTvPeopPhone");
            }
            SurveyPeopleBean surveyPeopleBean2 = this.f19206a;
            textView2.setText(surveyPeopleBean2 != null ? surveyPeopleBean2.getPeoplePhone() : null);
            TextView textView3 = this.mTvPeopCredentType;
            if (textView3 == null) {
                h.q2.t.i0.k("mTvPeopCredentType");
            }
            SurveyPeopleBean surveyPeopleBean3 = this.f19206a;
            textView3.setText(surveyPeopleBean3 != null ? surveyPeopleBean3.getDocumentName() : null);
            SurveyPeopleBean surveyPeopleBean4 = this.f19206a;
            this.f19207b = String.valueOf(surveyPeopleBean4 != null ? surveyPeopleBean4.getDocumentNumber() : null);
            TextView textView4 = this.mEtPeopCredentNumber;
            if (textView4 == null) {
                h.q2.t.i0.k("mEtPeopCredentNumber");
            }
            textView4.setText(this.f19207b);
        }
    }

    @OnClick({R.id.iv_back})
    public final void onClick(@i.c.a.d View view) {
        h.q2.t.i0.f(view, "view");
        if (!isDouble() && view.getId() == R.id.iv_back) {
            onBackPressed();
        }
    }

    @Override // ui.activity.BaseActivity
    public int setLayoutView() {
        return R.layout.activity_victim_detail;
    }

    public final void setMIvBack(@i.c.a.d ImageView imageView) {
        h.q2.t.i0.f(imageView, "<set-?>");
        this.mIvBack = imageView;
    }

    public final void setMTvPeopCredentType(@i.c.a.d TextView textView) {
        h.q2.t.i0.f(textView, "<set-?>");
        this.mTvPeopCredentType = textView;
    }

    public final void setMTvTitle(@i.c.a.d TextView textView) {
        h.q2.t.i0.f(textView, "<set-?>");
        this.mTvTitle = textView;
    }

    public final void setStepTwoBean(@i.c.a.e SurveyPeopleBean surveyPeopleBean) {
        this.f19206a = surveyPeopleBean;
    }

    @i.c.a.d
    public final String a() {
        return this.f19207b;
    }

    public final void a(@i.c.a.d String str) {
        h.q2.t.i0.f(str, "<set-?>");
        this.f19207b = str;
    }
}
