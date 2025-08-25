package ui.activity;

import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import bean.CaseDivisonBean;
import bean.SurveyPeopleBean;
import butterknife.BindView;
import butterknife.OnClick;
import com.hicorenational.antifraud.R;
import interfaces.IClickListener;
import ui.callview.SurveyPeopEditView;
import ui.presenter.SurveyPeopleEditPresenter;

/* compiled from: VictimActivity.kt */
@h.y(bv = {1, 0, 3}, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010=\u001a\u00020>H\u0016J\u0006\u0010?\u001a\u00020>J\u0010\u0010@\u001a\u00020>2\u0006\u0010A\u001a\u00020BH\u0007J\u0018\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020HH\u0016J\u0012\u0010I\u001a\u00020>2\b\u0010J\u001a\u0004\u0018\u00010KH\u0016J\u0010\u0010L\u001a\u00020>2\u0006\u0010M\u001a\u00020FH\u0016J\u0006\u0010N\u001a\u00020>J\b\u0010O\u001a\u00020FH\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001e\u0010\r\u001a\u00020\u000e8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0013\u001a\u00020\u00148\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001e\u0010\u0019\u001a\u00020\u001a8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001c\u0010\u001f\u001a\u0004\u0018\u00010 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001e\u0010%\u001a\u00020&8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001e\u0010+\u001a\u00020\u00148\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0016\"\u0004\b-\u0010\u0018R\u001e\u0010.\u001a\u00020\u00148\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0016\"\u0004\b0\u0010\u0018R\u001e\u00101\u001a\u00020&8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010(\"\u0004\b3\u0010*R\u001a\u00104\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u0007\"\u0004\b6\u0010\tR\u001c\u00107\u001a\u0004\u0018\u000108X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<¨\u0006P"}, d2 = {"Lui/activity/VictimActivity;", "Lui/activity/BaseActivity;", "Lui/callview/SurveyPeopEditView;", "()V", "caseInfoId", "", "getCaseInfoId", "()Ljava/lang/String;", "setCaseInfoId", "(Ljava/lang/String;)V", "documCode", "getDocumCode", "setDocumCode", "mBtnCommit", "Landroid/widget/Button;", "getMBtnCommit", "()Landroid/widget/Button;", "setMBtnCommit", "(Landroid/widget/Button;)V", "mEtPeopCredentNumber", "Landroid/widget/EditText;", "getMEtPeopCredentNumber", "()Landroid/widget/EditText;", "setMEtPeopCredentNumber", "(Landroid/widget/EditText;)V", "mIvBack", "Landroid/widget/ImageView;", "getMIvBack", "()Landroid/widget/ImageView;", "setMIvBack", "(Landroid/widget/ImageView;)V", "mPresenter", "Lui/presenter/SurveyPeopleEditPresenter;", "getMPresenter", "()Lui/presenter/SurveyPeopleEditPresenter;", "setMPresenter", "(Lui/presenter/SurveyPeopleEditPresenter;)V", "mTvPeopCredentType", "Landroid/widget/TextView;", "getMTvPeopCredentType", "()Landroid/widget/TextView;", "setMTvPeopCredentType", "(Landroid/widget/TextView;)V", "mTvPeopName", "getMTvPeopName", "setMTvPeopName", "mTvPeopPhone", "getMTvPeopPhone", "setMTvPeopPhone", "mTvTitle", "getMTvTitle", "setMTvTitle", "peopId", "getPeopId", "setPeopId", "stepTwoBean", "Lbean/SurveyPeopleBean;", "getStepTwoBean", "()Lbean/SurveyPeopleBean;", "setStepTwoBean", "(Lbean/SurveyPeopleBean;)V", "initPage", "", "initViewData", "onClick", "view", "Landroid/view/View;", "onKeyDown", "", "keyCode", "", "event", "Landroid/view/KeyEvent;", "onSuccessDocum", "bean", "Lbean/CaseDivisonBean;", "onSuccessHandle", "type", "onkeyback", "setLayoutView", "app_offic_flavorRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes2.dex */
public final class VictimActivity extends BaseActivity implements SurveyPeopEditView {

    @BindView(R.id.btn_commit)
    @i.c.a.d
    public Button mBtnCommit;

    @BindView(R.id.et_peop_credent_number)
    @i.c.a.d
    public EditText mEtPeopCredentNumber;

    @BindView(R.id.iv_back)
    @i.c.a.d
    public ImageView mIvBack;

    @i.c.a.e
    private SurveyPeopleEditPresenter mPresenter;

    @BindView(R.id.tv_peop_credent_type)
    @i.c.a.d
    public TextView mTvPeopCredentType;

    @BindView(R.id.tv_peop_name)
    @i.c.a.d
    public EditText mTvPeopName;

    @BindView(R.id.tv_num_phone)
    @i.c.a.d
    public EditText mTvPeopPhone;

    @BindView(R.id.tv_title)
    @i.c.a.d
    public TextView mTvTitle;

    @i.c.a.e
    private SurveyPeopleBean stepTwoBean;

    @i.c.a.d
    private String caseInfoId = "";

    @i.c.a.d
    private String peopId = "";

    @i.c.a.d
    private String documCode = "0";

    /* compiled from: VictimActivity.kt */
    public static final class a implements IClickListener {
        a() {
        }

        @Override // interfaces.IClickListener
        public void cancelBtn() {
            VictimActivity.this.finish();
        }

        @Override // interfaces.IClickListener
        public void clickOKBtn() {
        }
    }

    @i.c.a.d
    public final String getCaseInfoId() {
        return this.caseInfoId;
    }

    @i.c.a.d
    public final String getDocumCode() {
        return this.documCode;
    }

    @i.c.a.d
    public final Button getMBtnCommit() {
        Button button = this.mBtnCommit;
        if (button == null) {
            h.q2.t.i0.k("mBtnCommit");
        }
        return button;
    }

    @i.c.a.d
    public final EditText getMEtPeopCredentNumber() {
        EditText editText = this.mEtPeopCredentNumber;
        if (editText == null) {
            h.q2.t.i0.k("mEtPeopCredentNumber");
        }
        return editText;
    }

    @i.c.a.d
    public final ImageView getMIvBack() {
        ImageView imageView = this.mIvBack;
        if (imageView == null) {
            h.q2.t.i0.k("mIvBack");
        }
        return imageView;
    }

    @i.c.a.e
    public final SurveyPeopleEditPresenter getMPresenter() {
        return this.mPresenter;
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
    public final EditText getMTvPeopName() {
        EditText editText = this.mTvPeopName;
        if (editText == null) {
            h.q2.t.i0.k("mTvPeopName");
        }
        return editText;
    }

    @i.c.a.d
    public final EditText getMTvPeopPhone() {
        EditText editText = this.mTvPeopPhone;
        if (editText == null) {
            h.q2.t.i0.k("mTvPeopPhone");
        }
        return editText;
    }

    @i.c.a.d
    public final TextView getMTvTitle() {
        TextView textView = this.mTvTitle;
        if (textView == null) {
            h.q2.t.i0.k("mTvTitle");
        }
        return textView;
    }

    @i.c.a.d
    public final String getPeopId() {
        return this.peopId;
    }

    @i.c.a.e
    public final SurveyPeopleBean getStepTwoBean() {
        return this.stepTwoBean;
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
        textView.setText("事主信息");
        this.mPresenter = new SurveyPeopleEditPresenter(this, this);
        initViewData();
    }

    public final void initViewData() {
        String documentType;
        String stringExtra = getIntent().getStringExtra(util.k1.C0);
        if (stringExtra == null) {
            stringExtra = "";
        }
        this.caseInfoId = stringExtra;
        this.stepTwoBean = (SurveyPeopleBean) getIntent().getSerializableExtra(util.k1.f20845c);
        if (this.stepTwoBean == null) {
            TextView textView = this.mTvPeopCredentType;
            if (textView == null) {
                h.q2.t.i0.k("mTvPeopCredentType");
            }
            textView.setText("身份证");
            SurveyPeopleEditPresenter surveyPeopleEditPresenter = this.mPresenter;
            if (surveyPeopleEditPresenter != null) {
                surveyPeopleEditPresenter.httpCredentType(true);
                return;
            }
            return;
        }
        EditText editText = this.mTvPeopName;
        if (editText == null) {
            h.q2.t.i0.k("mTvPeopName");
        }
        SurveyPeopleBean surveyPeopleBean = this.stepTwoBean;
        editText.setText(surveyPeopleBean != null ? surveyPeopleBean.getPeopleName() : null);
        EditText editText2 = this.mTvPeopPhone;
        if (editText2 == null) {
            h.q2.t.i0.k("mTvPeopPhone");
        }
        SurveyPeopleBean surveyPeopleBean2 = this.stepTwoBean;
        editText2.setText(surveyPeopleBean2 != null ? surveyPeopleBean2.getPeoplePhone() : null);
        EditText editText3 = this.mEtPeopCredentNumber;
        if (editText3 == null) {
            h.q2.t.i0.k("mEtPeopCredentNumber");
        }
        SurveyPeopleBean surveyPeopleBean3 = this.stepTwoBean;
        editText3.setText(String.valueOf(surveyPeopleBean3 != null ? surveyPeopleBean3.getDocumentNumber() : null));
        TextView textView2 = this.mTvPeopCredentType;
        if (textView2 == null) {
            h.q2.t.i0.k("mTvPeopCredentType");
        }
        SurveyPeopleBean surveyPeopleBean4 = this.stepTwoBean;
        textView2.setText(surveyPeopleBean4 != null ? surveyPeopleBean4.getDocumentName() : null);
        SurveyPeopleBean surveyPeopleBean5 = this.stepTwoBean;
        this.peopId = String.valueOf(surveyPeopleBean5 != null ? surveyPeopleBean5.getVictimInfoID() : null);
        SurveyPeopleBean surveyPeopleBean6 = this.stepTwoBean;
        if (surveyPeopleBean6 == null || (documentType = surveyPeopleBean6.getDocumentType()) == null) {
            documentType = "0";
        }
        this.documCode = documentType;
        SurveyPeopleEditPresenter surveyPeopleEditPresenter2 = this.mPresenter;
        if (surveyPeopleEditPresenter2 != null) {
            surveyPeopleEditPresenter2.httpCredentType(false);
        }
    }

    @OnClick({R.id.iv_back, R.id.tv_peop_credent_type, R.id.btn_commit})
    public final void onClick(@i.c.a.d View view) {
        h.q2.t.i0.f(view, "view");
        if (isDouble()) {
            return;
        }
        int id = view.getId();
        if (id != R.id.btn_commit) {
            if (id == R.id.iv_back) {
                onkeyback();
                return;
            }
            if (id != R.id.tv_peop_credent_type) {
                return;
            }
            EditText editText = this.mEtPeopCredentNumber;
            if (editText == null) {
                h.q2.t.i0.k("mEtPeopCredentNumber");
            }
            editText.clearFocus();
            SurveyPeopleEditPresenter surveyPeopleEditPresenter = this.mPresenter;
            if (surveyPeopleEditPresenter != null) {
                TextView textView = this.mTvPeopCredentType;
                if (textView == null) {
                    h.q2.t.i0.k("mTvPeopCredentType");
                }
                surveyPeopleEditPresenter.showCredentPiker(textView);
                return;
            }
            return;
        }
        EditText editText2 = this.mTvPeopName;
        if (editText2 == null) {
            h.q2.t.i0.k("mTvPeopName");
        }
        String string = editText2.getText().toString();
        EditText editText3 = this.mTvPeopPhone;
        if (editText3 == null) {
            h.q2.t.i0.k("mTvPeopPhone");
        }
        String string2 = editText3.getText().toString();
        if (TextUtils.isEmpty(string)) {
            util.w1.a("请填写姓名");
            return;
        }
        if (TextUtils.isEmpty(string2)) {
            util.w1.a("请填写电话号码");
            return;
        }
        TextView textView2 = this.mTvPeopCredentType;
        if (textView2 == null) {
            h.q2.t.i0.k("mTvPeopCredentType");
        }
        String string3 = textView2.getText().toString();
        EditText editText4 = this.mEtPeopCredentNumber;
        if (editText4 == null) {
            h.q2.t.i0.k("mEtPeopCredentNumber");
        }
        String string4 = editText4.getText().toString();
        if (TextUtils.isEmpty(string3)) {
            util.w1.a("请选择证件类型");
            return;
        }
        if (TextUtils.isEmpty(string4)) {
            util.w1.a("请填写证件号");
            return;
        }
        int length = string4.length();
        if (h.z2.c0.c((CharSequence) string3, (CharSequence) "身份证", false, 2, (Object) null) && (length < 15 || (length > 15 && length != 18))) {
            util.w1.a("证件号格式不正确");
            return;
        }
        SurveyPeopleBean surveyPeopleBean = new SurveyPeopleBean();
        surveyPeopleBean.setVictimInfoID(this.peopId);
        surveyPeopleBean.setCaseInfoID(this.caseInfoId);
        surveyPeopleBean.setPeopleName(string);
        surveyPeopleBean.setPeoplePhone(string2);
        surveyPeopleBean.setDocumentType(this.documCode);
        surveyPeopleBean.setDocumentName(string3);
        surveyPeopleBean.setDocumentNumber(string4);
        SurveyPeopleBean surveyPeopleBean2 = this.stepTwoBean;
        if (surveyPeopleBean2 != null) {
            surveyPeopleBean.setVictimInfoID(surveyPeopleBean2 != null ? surveyPeopleBean2.getVictimInfoID() : null);
        }
        SurveyPeopleEditPresenter surveyPeopleEditPresenter2 = this.mPresenter;
        if (surveyPeopleEditPresenter2 != null) {
            surveyPeopleEditPresenter2.editPersonInfo(surveyPeopleBean);
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, @i.c.a.d KeyEvent keyEvent) {
        h.q2.t.i0.f(keyEvent, "event");
        if (i2 != 4) {
            return super.onKeyDown(i2, keyEvent);
        }
        onkeyback();
        return true;
    }

    @Override // ui.callview.SurveyPeopEditView
    public void onSuccessDocum(@i.c.a.e CaseDivisonBean caseDivisonBean) {
        if (caseDivisonBean == null) {
            h.q2.t.i0.f();
        }
        String id = caseDivisonBean.getId();
        h.q2.t.i0.a((Object) id, "bean!!.id");
        this.documCode = id;
    }

    @Override // ui.callview.SurveyPeopEditView
    public void onSuccessHandle(int i2) {
        if (this.stepTwoBean != null) {
            util.w1.a("修改成功");
        } else {
            util.w1.a("添加成功");
        }
        finish();
    }

    public final void onkeyback() {
        util.b1.b(this.mActivity, "放弃本次信息编辑？", "", "确定", "取消", new a());
    }

    public final void setCaseInfoId(@i.c.a.d String str) {
        h.q2.t.i0.f(str, "<set-?>");
        this.caseInfoId = str;
    }

    public final void setDocumCode(@i.c.a.d String str) {
        h.q2.t.i0.f(str, "<set-?>");
        this.documCode = str;
    }

    @Override // ui.activity.BaseActivity
    public int setLayoutView() {
        return R.layout.activity_victim;
    }

    public final void setMBtnCommit(@i.c.a.d Button button) {
        h.q2.t.i0.f(button, "<set-?>");
        this.mBtnCommit = button;
    }

    public final void setMEtPeopCredentNumber(@i.c.a.d EditText editText) {
        h.q2.t.i0.f(editText, "<set-?>");
        this.mEtPeopCredentNumber = editText;
    }

    public final void setMIvBack(@i.c.a.d ImageView imageView) {
        h.q2.t.i0.f(imageView, "<set-?>");
        this.mIvBack = imageView;
    }

    public final void setMPresenter(@i.c.a.e SurveyPeopleEditPresenter surveyPeopleEditPresenter) {
        this.mPresenter = surveyPeopleEditPresenter;
    }

    public final void setMTvPeopCredentType(@i.c.a.d TextView textView) {
        h.q2.t.i0.f(textView, "<set-?>");
        this.mTvPeopCredentType = textView;
    }

    public final void setMTvPeopName(@i.c.a.d EditText editText) {
        h.q2.t.i0.f(editText, "<set-?>");
        this.mTvPeopName = editText;
    }

    public final void setMTvPeopPhone(@i.c.a.d EditText editText) {
        h.q2.t.i0.f(editText, "<set-?>");
        this.mTvPeopPhone = editText;
    }

    public final void setMTvTitle(@i.c.a.d TextView textView) {
        h.q2.t.i0.f(textView, "<set-?>");
        this.mTvTitle = textView;
    }

    public final void setPeopId(@i.c.a.d String str) {
        h.q2.t.i0.f(str, "<set-?>");
        this.peopId = str;
    }

    public final void setStepTwoBean(@i.c.a.e SurveyPeopleBean surveyPeopleBean) {
        this.stepTwoBean = surveyPeopleBean;
    }
}
