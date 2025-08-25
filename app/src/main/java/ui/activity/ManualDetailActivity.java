package ui.activity;

import android.content.Intent;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;
import bean.CheckUserBean;
import com.hicorenational.antifraud.R;
import com.luck.picture.lib.entity.LocalMedia;
import interfaces.IClickListener;
import java.util.ArrayList;
import manager.BaseDialog;
import ui.callview.ManualDetailView;
import ui.presenter.ManualDetailPresenter;
import ui.view.swip.SwipBackLayout;

/* compiled from: ManualDetailActivity.kt */
@h.y(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 A2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001AB\u0005¢\u0006\u0002\u0010\u0004J\u0006\u00102\u001a\u000203J\u0006\u00104\u001a\u000203J\b\u00105\u001a\u000203H\u0016J\u0006\u00106\u001a\u000203J\u0010\u00107\u001a\u0002032\u0006\u00108\u001a\u000209H\u0016J\b\u0010:\u001a\u000203H\u0016J\b\u0010;\u001a\u000203H\u0016J\b\u0010<\u001a\u000203H\u0016J\u0006\u0010=\u001a\u000203J\b\u0010>\u001a\u00020\fH\u0016J\u0010\u0010?\u001a\u0002032\b\u0010@\u001a\u0004\u0018\u00010\u0013R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u001b\"\u0004\b \u0010\u001dR\u000e\u0010!\u001a\u00020\"X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\"X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\"X\u0082.¢\u0006\u0002\n\u0000R\u001c\u0010%\u001a\u0004\u0018\u00010&X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u000e\u0010+\u001a\u00020,X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020,X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020,X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020,X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020,X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020,X\u0082.¢\u0006\u0002\n\u0000¨\u0006B"}, d2 = {"Lui/activity/ManualDetailActivity;", "Lui/activity/BaseActivity;", "Landroid/view/View$OnClickListener;", "Lui/callview/ManualDetailView;", "()V", "checkBean", "Lbean/CheckUserBean;", "getCheckBean", "()Lbean/CheckUserBean;", "setCheckBean", "(Lbean/CheckUserBean;)V", "checkType", "", "getCheckType", "()Ljava/lang/Integer;", "setCheckType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "disAgreeStr", "", "getDisAgreeStr", "()Ljava/lang/String;", "setDisAgreeStr", "(Ljava/lang/String;)V", "dlg", "Lmanager/BaseDialog;", "getDlg", "()Lmanager/BaseDialog;", "setDlg", "(Lmanager/BaseDialog;)V", "mDlgRed", "getMDlgRed", "setMDlgRed", "mIvBack", "Landroid/widget/ImageView;", "mPicF", "mPicZ", "mPresenter", "Lui/presenter/ManualDetailPresenter;", "getMPresenter", "()Lui/presenter/ManualDetailPresenter;", "setMPresenter", "(Lui/presenter/ManualDetailPresenter;)V", "mTvArgee", "Landroid/widget/TextView;", "mTvDisAgree", "mTvIdNum", "mTvName", "mTvPhoneNum", "mTvTitle", "disAgreeResonDlg", "", "initListener", "initPage", "initViewData", "onClick", "view", "Landroid/view/View;", "onSuccess", "onSuccessOverrun", "onSuccessUnbind", "overrunDialog", "setLayoutView", "showPreviewPic", "path", "Companion", "app_offic_flavorRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes2.dex */
public final class ManualDetailActivity extends BaseActivity implements View.OnClickListener, ManualDetailView {
    public static final a Companion = new a(null);

    @i.c.a.d
    public static final String Oauth_No = "0";

    @i.c.a.d
    public static final String Oauth_Pend = "2";

    @i.c.a.d
    public static final String Oauth_Succ = "1";

    @i.c.a.d
    public static final String Oauth_fail = "3";

    @i.c.a.e
    private CheckUserBean checkBean;

    @i.c.a.e
    private Integer checkType = 0;

    @i.c.a.e
    private String disAgreeStr;

    @i.c.a.e
    private BaseDialog dlg;

    @i.c.a.e
    private BaseDialog mDlgRed;
    private ImageView mIvBack;
    private ImageView mPicF;
    private ImageView mPicZ;

    @i.c.a.e
    private ManualDetailPresenter mPresenter;
    private TextView mTvArgee;
    private TextView mTvDisAgree;
    private TextView mTvIdNum;
    private TextView mTvName;
    private TextView mTvPhoneNum;
    private TextView mTvTitle;

    /* compiled from: ManualDetailActivity.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(h.q2.t.v vVar) {
            this();
        }
    }

    /* compiled from: ManualDetailActivity.kt */
    static final class b implements RadioGroup.OnCheckedChangeListener {
        b() {
        }

        @Override // android.widget.RadioGroup.OnCheckedChangeListener
        public final void onCheckedChanged(RadioGroup radioGroup, int i2) {
            switch (i2) {
                case R.id.rb_other /* 2131297133 */:
                    ManualDetailActivity.this.setCheckType(0);
                    break;
                case R.id.rb_pic_bf /* 2131297135 */:
                    ManualDetailActivity.this.setCheckType(2);
                    break;
                case R.id.rb_pic_mh /* 2131297136 */:
                    ManualDetailActivity.this.setCheckType(1);
                    break;
            }
        }
    }

    /* compiled from: ManualDetailActivity.kt */
    static final class c implements View.OnClickListener {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ EditText f18378b;

        c(EditText editText) {
            this.f18378b = editText;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Integer checkType = ManualDetailActivity.this.getCheckType();
            if (checkType != null && checkType.intValue() == 1) {
                ManualDetailActivity.this.setDisAgreeStr("手持证件照片模糊");
            } else {
                Integer checkType2 = ManualDetailActivity.this.getCheckType();
                if (checkType2 != null && checkType2.intValue() == 2) {
                    ManualDetailActivity.this.setDisAgreeStr("人像与证件照片不符");
                } else {
                    EditText editText = this.f18378b;
                    if (editText == null) {
                        h.q2.t.i0.f();
                    }
                    String string = editText.getText().toString();
                    if (TextUtils.isEmpty(string)) {
                        util.w1.a("请输入其他原因~");
                        return;
                    }
                    ManualDetailActivity.this.setDisAgreeStr(string);
                }
            }
            ManualDetailPresenter mPresenter = ManualDetailActivity.this.getMPresenter();
            if (mPresenter != null) {
                CheckUserBean checkBean = ManualDetailActivity.this.getCheckBean();
                mPresenter.submitaudit("3", checkBean != null ? checkBean.getTelnumber() : null, ManualDetailActivity.this.getDisAgreeStr());
            }
            BaseDialog dlg = ManualDetailActivity.this.getDlg();
            if (dlg == null) {
                h.q2.t.i0.f();
            }
            dlg.dismiss();
        }
    }

    /* compiled from: ManualDetailActivity.kt */
    public static final class d implements IClickListener {
        d() {
        }

        @Override // interfaces.IClickListener
        public void cancelBtn() {
        }

        @Override // interfaces.IClickListener
        public void clickOKBtn() {
            ManualDetailPresenter mPresenter = ManualDetailActivity.this.getMPresenter();
            if (mPresenter != null) {
                CheckUserBean checkBean = ManualDetailActivity.this.getCheckBean();
                mPresenter.unbind("1", checkBean != null ? checkBean.getTelnumber() : null, "同意");
            }
        }
    }

    public final void disAgreeResonDlg() {
        this.dlg = new BaseDialog(this.mActivity, R.style.base_dialog_style);
        BaseDialog baseDialog = this.dlg;
        if (baseDialog == null) {
            h.q2.t.i0.f();
        }
        baseDialog.setContentView(R.layout.dis_agree_dlg);
        BaseDialog baseDialog2 = this.dlg;
        if (baseDialog2 == null) {
            h.q2.t.i0.f();
        }
        baseDialog2.setGravityLayout(2);
        BaseDialog baseDialog3 = this.dlg;
        if (baseDialog3 == null) {
            h.q2.t.i0.f();
        }
        baseDialog3.setWidthDialogdp(-2.0f);
        BaseDialog baseDialog4 = this.dlg;
        if (baseDialog4 == null) {
            h.q2.t.i0.f();
        }
        baseDialog4.setHeightDialogdp(-2.0f);
        BaseDialog baseDialog5 = this.dlg;
        if (baseDialog5 == null) {
            h.q2.t.i0.f();
        }
        baseDialog5.setCancelable(true);
        BaseDialog baseDialog6 = this.dlg;
        if (baseDialog6 == null) {
            h.q2.t.i0.f();
        }
        baseDialog6.setCanceledOnTouchOutside(true);
        BaseDialog baseDialog7 = this.dlg;
        if (baseDialog7 == null) {
            h.q2.t.i0.f();
        }
        baseDialog7.initOnCreate();
        BaseDialog baseDialog8 = this.dlg;
        if (baseDialog8 == null) {
            h.q2.t.i0.f();
        }
        baseDialog8.show();
        BaseDialog baseDialog9 = this.dlg;
        if (baseDialog9 == null) {
            h.q2.t.i0.f();
        }
        RadioGroup radioGroup = (RadioGroup) baseDialog9.findViewById(R.id.rg_group);
        BaseDialog baseDialog10 = this.dlg;
        if (baseDialog10 == null) {
            h.q2.t.i0.f();
        }
        EditText editText = (EditText) baseDialog10.findViewById(R.id.et_other_reson);
        BaseDialog baseDialog11 = this.dlg;
        if (baseDialog11 == null) {
            h.q2.t.i0.f();
        }
        Button button = (Button) baseDialog11.findViewById(R.id.confirm);
        radioGroup.setOnCheckedChangeListener(new b());
        button.setOnClickListener(new c(editText));
    }

    @i.c.a.e
    public final CheckUserBean getCheckBean() {
        return this.checkBean;
    }

    @i.c.a.e
    public final Integer getCheckType() {
        return this.checkType;
    }

    @i.c.a.e
    public final String getDisAgreeStr() {
        return this.disAgreeStr;
    }

    @i.c.a.e
    public final BaseDialog getDlg() {
        return this.dlg;
    }

    @i.c.a.e
    public final BaseDialog getMDlgRed() {
        return this.mDlgRed;
    }

    @i.c.a.e
    public final ManualDetailPresenter getMPresenter() {
        return this.mPresenter;
    }

    public final void initListener() {
        ImageView imageView = this.mIvBack;
        if (imageView == null) {
            h.q2.t.i0.k("mIvBack");
        }
        if (imageView == null) {
            h.q2.t.i0.f();
        }
        imageView.setOnClickListener(this);
        ImageView imageView2 = this.mPicZ;
        if (imageView2 == null) {
            h.q2.t.i0.k("mPicZ");
        }
        if (imageView2 == null) {
            h.q2.t.i0.f();
        }
        imageView2.setOnClickListener(this);
        ImageView imageView3 = this.mPicF;
        if (imageView3 == null) {
            h.q2.t.i0.k("mPicF");
        }
        if (imageView3 == null) {
            h.q2.t.i0.f();
        }
        imageView3.setOnClickListener(this);
        TextView textView = this.mTvArgee;
        if (textView == null) {
            h.q2.t.i0.k("mTvArgee");
        }
        if (textView == null) {
            h.q2.t.i0.f();
        }
        textView.setOnClickListener(this);
        TextView textView2 = this.mTvDisAgree;
        if (textView2 == null) {
            h.q2.t.i0.k("mTvDisAgree");
        }
        if (textView2 == null) {
            h.q2.t.i0.f();
        }
        textView2.setOnClickListener(this);
    }

    @Override // ui.activity.BaseActivity
    public void initPage() {
        SwipBackLayout.a(this.mActivity).a();
        View viewFindViewById = findViewById(R.id.iv_back);
        h.q2.t.i0.a((Object) viewFindViewById, "findViewById(R.id.iv_back)");
        this.mIvBack = (ImageView) viewFindViewById;
        View viewFindViewById2 = findViewById(R.id.tv_title);
        h.q2.t.i0.a((Object) viewFindViewById2, "findViewById(R.id.tv_title)");
        this.mTvTitle = (TextView) viewFindViewById2;
        View viewFindViewById3 = findViewById(R.id.tv_name);
        h.q2.t.i0.a((Object) viewFindViewById3, "findViewById(R.id.tv_name)");
        this.mTvName = (TextView) viewFindViewById3;
        View viewFindViewById4 = findViewById(R.id.tv_id_num);
        h.q2.t.i0.a((Object) viewFindViewById4, "findViewById(R.id.tv_id_num)");
        this.mTvIdNum = (TextView) viewFindViewById4;
        View viewFindViewById5 = findViewById(R.id.tv_phone_num);
        h.q2.t.i0.a((Object) viewFindViewById5, "findViewById(R.id.tv_phone_num)");
        this.mTvPhoneNum = (TextView) viewFindViewById5;
        View viewFindViewById6 = findViewById(R.id.iv_upload_pic_z);
        h.q2.t.i0.a((Object) viewFindViewById6, "findViewById(R.id.iv_upload_pic_z)");
        this.mPicZ = (ImageView) viewFindViewById6;
        View viewFindViewById7 = findViewById(R.id.iv_upload_pic_f);
        h.q2.t.i0.a((Object) viewFindViewById7, "findViewById(R.id.iv_upload_pic_f)");
        this.mPicF = (ImageView) viewFindViewById7;
        View viewFindViewById8 = findViewById(R.id.tv_agree);
        h.q2.t.i0.a((Object) viewFindViewById8, "findViewById(R.id.tv_agree)");
        this.mTvArgee = (TextView) viewFindViewById8;
        View viewFindViewById9 = findViewById(R.id.tv_disagree);
        h.q2.t.i0.a((Object) viewFindViewById9, "findViewById(R.id.tv_disagree)");
        this.mTvDisAgree = (TextView) viewFindViewById9;
        TextView textView = this.mTvTitle;
        if (textView == null) {
            h.q2.t.i0.k("mTvTitle");
        }
        if (textView == null) {
            h.q2.t.i0.f();
        }
        textView.setText("待审核详情");
        this.mPresenter = new ManualDetailPresenter(this.mActivity, this);
        this.checkBean = (CheckUserBean) getIntent().getSerializableExtra(util.k1.f20845c);
        initListener();
        initViewData();
    }

    public final void initViewData() {
        TextView textView = this.mTvName;
        if (textView == null) {
            h.q2.t.i0.k("mTvName");
        }
        if (textView == null) {
            h.q2.t.i0.f();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("姓名：");
        CheckUserBean checkUserBean = this.checkBean;
        sb.append(checkUserBean != null ? checkUserBean.getName() : null);
        textView.setText(sb.toString());
        TextView textView2 = this.mTvIdNum;
        if (textView2 == null) {
            h.q2.t.i0.k("mTvIdNum");
        }
        if (textView2 == null) {
            h.q2.t.i0.f();
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("证件号：");
        CheckUserBean checkUserBean2 = this.checkBean;
        sb2.append(checkUserBean2 != null ? checkUserBean2.getIdNumber() : null);
        textView2.setText(sb2.toString());
        TextView textView3 = this.mTvPhoneNum;
        if (textView3 == null) {
            h.q2.t.i0.k("mTvPhoneNum");
        }
        if (textView3 == null) {
            h.q2.t.i0.f();
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append("手机号：");
        CheckUserBean checkUserBean3 = this.checkBean;
        sb3.append(checkUserBean3 != null ? checkUserBean3.getTelnumber() : null);
        textView3.setText(sb3.toString());
        CheckUserBean checkUserBean4 = this.checkBean;
        String frontImg = checkUserBean4 != null ? checkUserBean4.getFrontImg() : null;
        ImageView imageView = this.mPicZ;
        if (imageView == null) {
            h.q2.t.i0.k("mPicZ");
        }
        j.d.a(frontImg, imageView, Integer.valueOf(R.drawable.iv_id_z_default));
        CheckUserBean checkUserBean5 = this.checkBean;
        String backImg = checkUserBean5 != null ? checkUserBean5.getBackImg() : null;
        ImageView imageView2 = this.mPicF;
        if (imageView2 == null) {
            h.q2.t.i0.k("mPicF");
        }
        j.d.a(backImg, imageView2, Integer.valueOf(R.drawable.iv_id_f_default));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@i.c.a.d View view) {
        h.q2.t.i0.f(view, "view");
        if (isDouble()) {
        }
        switch (view.getId()) {
            case R.id.iv_back /* 2131296762 */:
                a();
                break;
            case R.id.iv_upload_pic_f /* 2131296855 */:
                CheckUserBean checkUserBean = this.checkBean;
                showPreviewPic(checkUserBean != null ? checkUserBean.getBackImg() : null);
                break;
            case R.id.iv_upload_pic_z /* 2131296856 */:
                CheckUserBean checkUserBean2 = this.checkBean;
                showPreviewPic(checkUserBean2 != null ? checkUserBean2.getFrontImg() : null);
                break;
            case R.id.tv_agree /* 2131297410 */:
                ManualDetailPresenter manualDetailPresenter = this.mPresenter;
                if (manualDetailPresenter != null) {
                    CheckUserBean checkUserBean3 = this.checkBean;
                    manualDetailPresenter.submitaudit("1", checkUserBean3 != null ? checkUserBean3.getTelnumber() : null, "同意");
                    break;
                }
                break;
            case R.id.tv_disagree /* 2131297538 */:
                disAgreeResonDlg();
                break;
        }
    }

    @Override // ui.callview.ManualDetailView
    public void onSuccess() {
        util.w1.a("操作成功");
        finish();
    }

    @Override // ui.callview.ManualDetailView
    public void onSuccessOverrun() {
        overrunDialog();
    }

    @Override // ui.callview.ManualDetailView
    public void onSuccessUnbind() {
        BaseDialog baseDialog = this.mDlgRed;
        if (baseDialog == null) {
            h.q2.t.i0.f();
        }
        baseDialog.dismiss();
        finish();
    }

    public final void overrunDialog() {
        this.mDlgRed = util.b1.c(this.mActivity, "当前身份信息已实名其他账号，是否换绑新账号，并注销老账号？", "需确认当前身份信息与本人一致，请谨慎操作！", "取消", "确定", new d());
    }

    public final void setCheckBean(@i.c.a.e CheckUserBean checkUserBean) {
        this.checkBean = checkUserBean;
    }

    public final void setCheckType(@i.c.a.e Integer num) {
        this.checkType = num;
    }

    public final void setDisAgreeStr(@i.c.a.e String str) {
        this.disAgreeStr = str;
    }

    public final void setDlg(@i.c.a.e BaseDialog baseDialog) {
        this.dlg = baseDialog;
    }

    @Override // ui.activity.BaseActivity
    public int setLayoutView() {
        return R.layout.activity_manual_detail;
    }

    public final void setMDlgRed(@i.c.a.e BaseDialog baseDialog) {
        this.mDlgRed = baseDialog;
    }

    public final void setMPresenter(@i.c.a.e ManualDetailPresenter manualDetailPresenter) {
        this.mPresenter = manualDetailPresenter;
    }

    public final void showPreviewPic(@i.c.a.e String str) {
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
        LocalMedia localMedia = new LocalMedia();
        localMedia.setPath(str);
        arrayList.add(localMedia);
        Intent intent = new Intent(this, (Class<?>) PreviewPictureActivity.class);
        intent.putParcelableArrayListExtra(PreviewPictureActivity.f18539f, arrayList);
        intent.putExtra(PreviewPictureActivity.f18540g, 0);
        intent.putExtra(PreviewPictureActivity.f18541h, arrayList.size());
        intent.putExtra(PreviewPictureActivity.f18542i, str);
        startActivity(intent);
    }
}
