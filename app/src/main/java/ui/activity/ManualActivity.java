package ui.activity;

import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import bean.CheckUserBean;
import com.hicorenational.antifraud.R;
import interfaces.IEditAfterListener;
import interfaces.IOneClickListener;
import ui.callview.ManualView;
import ui.presenter.ManualPresenter;
import ui.view.swip.SwipBackLayout;

/* compiled from: ManualActivity.kt */
@h.y(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0014\u001a\u00020\u0015J\b\u0010\u0016\u001a\u00020\u0015H\u0016J\u0010\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0010\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\b\u0010 \u001a\u00020!H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lui/activity/ManualActivity;", "Lui/activity/BaseActivity;", "Landroid/view/View$OnClickListener;", "Lui/callview/ManualView;", "()V", "checkBtn", "Landroid/widget/TextView;", "mEtCheckInfo", "Landroid/widget/EditText;", "mIvBack", "Landroid/widget/ImageView;", "mIvClean", "mIvRight", "mPresenter", "Lui/presenter/ManualPresenter;", "getMPresenter", "()Lui/presenter/ManualPresenter;", "setMPresenter", "(Lui/presenter/ManualPresenter;)V", "mTvTitle", "initListener", "", "initPage", "onClick", "view", "Landroid/view/View;", "onSuccess", "bean", "Lbean/CheckUserBean;", "onfail", "msg", "", "setLayoutView", "", "app_offic_flavorRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes2.dex */
public final class ManualActivity extends BaseActivity implements View.OnClickListener, ManualView {
    private TextView checkBtn;
    private EditText mEtCheckInfo;
    private ImageView mIvBack;
    private ImageView mIvClean;
    private ImageView mIvRight;

    @i.c.a.e
    private ManualPresenter mPresenter;
    private TextView mTvTitle;

    /* compiled from: ManualActivity.kt */
    public static final class a implements IEditAfterListener {
        a() {
        }

        @Override // interfaces.IEditAfterListener
        public void editLength(int i2) {
            if (i2 > 0) {
                ImageView imageViewAccess$getMIvClean$p = ManualActivity.access$getMIvClean$p(ManualActivity.this);
                if (imageViewAccess$getMIvClean$p == null) {
                    h.q2.t.i0.f();
                }
                imageViewAccess$getMIvClean$p.setVisibility(0);
            } else {
                ImageView imageViewAccess$getMIvClean$p2 = ManualActivity.access$getMIvClean$p(ManualActivity.this);
                if (imageViewAccess$getMIvClean$p2 == null) {
                    h.q2.t.i0.f();
                }
                imageViewAccess$getMIvClean$p2.setVisibility(4);
            }
            if (i2 > 10) {
                ManualActivity.access$getCheckBtn$p(ManualActivity.this).setEnabled(true);
            } else {
                ManualActivity.access$getCheckBtn$p(ManualActivity.this).setEnabled(false);
            }
        }
    }

    public static final /* synthetic */ TextView access$getCheckBtn$p(ManualActivity manualActivity) {
        TextView textView = manualActivity.checkBtn;
        if (textView == null) {
            h.q2.t.i0.k("checkBtn");
        }
        return textView;
    }

    public static final /* synthetic */ ImageView access$getMIvClean$p(ManualActivity manualActivity) {
        ImageView imageView = manualActivity.mIvClean;
        if (imageView == null) {
            h.q2.t.i0.k("mIvClean");
        }
        return imageView;
    }

    @i.c.a.e
    public final ManualPresenter getMPresenter() {
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
        ImageView imageView2 = this.mIvClean;
        if (imageView2 == null) {
            h.q2.t.i0.k("mIvClean");
        }
        if (imageView2 == null) {
            h.q2.t.i0.f();
        }
        imageView2.setOnClickListener(this);
        TextView textView = this.checkBtn;
        if (textView == null) {
            h.q2.t.i0.k("checkBtn");
        }
        if (textView == null) {
            h.q2.t.i0.f();
        }
        textView.setOnClickListener(this);
        ImageView imageView3 = this.mIvRight;
        if (imageView3 == null) {
            h.q2.t.i0.k("mIvRight");
        }
        if (imageView3 == null) {
            h.q2.t.i0.f();
        }
        imageView3.setOnClickListener(this);
        EditText editText = this.mEtCheckInfo;
        if (editText == null) {
            h.q2.t.i0.k("mEtCheckInfo");
        }
        util.d1.a(editText, new a());
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
        View viewFindViewById3 = findViewById(R.id.iv_right);
        h.q2.t.i0.a((Object) viewFindViewById3, "findViewById(R.id.iv_right)");
        this.mIvRight = (ImageView) viewFindViewById3;
        View viewFindViewById4 = findViewById(R.id.iv_clear);
        h.q2.t.i0.a((Object) viewFindViewById4, "findViewById(R.id.iv_clear)");
        this.mIvClean = (ImageView) viewFindViewById4;
        View viewFindViewById5 = findViewById(R.id.confirm);
        h.q2.t.i0.a((Object) viewFindViewById5, "findViewById(R.id.confirm)");
        this.checkBtn = (TextView) viewFindViewById5;
        View viewFindViewById6 = findViewById(R.id.et_check_info);
        h.q2.t.i0.a((Object) viewFindViewById6, "findViewById(R.id.et_check_info)");
        this.mEtCheckInfo = (EditText) viewFindViewById6;
        TextView textView = this.mTvTitle;
        if (textView == null) {
            h.q2.t.i0.k("mTvTitle");
        }
        if (textView == null) {
            h.q2.t.i0.f();
        }
        textView.setText("人工审核");
        ImageView imageView = this.mIvRight;
        if (imageView == null) {
            h.q2.t.i0.k("mIvRight");
        }
        if (imageView == null) {
            h.q2.t.i0.f();
        }
        imageView.setBackgroundResource(R.drawable.iv_report_record);
        this.mPresenter = new ManualPresenter(this.mActivity, this);
        initListener();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@i.c.a.d View view) {
        h.q2.t.i0.f(view, "view");
        if (isDouble()) {
        }
        switch (view.getId()) {
            case R.id.confirm /* 2131296476 */:
                ManualPresenter manualPresenter = this.mPresenter;
                if (manualPresenter == null) {
                    h.q2.t.i0.f();
                }
                EditText editText = this.mEtCheckInfo;
                if (editText == null) {
                    h.q2.t.i0.k("mEtCheckInfo");
                }
                if (editText == null) {
                    h.q2.t.i0.f();
                }
                manualPresenter.getCheckInfo(editText.getText().toString());
                break;
            case R.id.iv_back /* 2131296762 */:
                a();
                break;
            case R.id.iv_clear /* 2131296772 */:
                EditText editText2 = this.mEtCheckInfo;
                if (editText2 == null) {
                    h.q2.t.i0.k("mEtCheckInfo");
                }
                if (editText2 == null) {
                    h.q2.t.i0.f();
                }
                editText2.setText("");
                break;
            case R.id.iv_right /* 2131296826 */:
                startActivity(new Intent(this.mActivity, (Class<?>) ManualListActivity.class));
                break;
        }
    }

    @Override // ui.callview.ManualView
    public void onSuccess(@i.c.a.d CheckUserBean checkUserBean) {
        h.q2.t.i0.f(checkUserBean, "bean");
        if (checkUserBean.getAuditStatus() == Integer.parseInt("1")) {
            util.b1.a(this.mActivity, "提示", "该用户已通过认证审核", "确定", (IOneClickListener) null);
        } else {
            if (checkUserBean.getAuditStatus() != Integer.parseInt("2")) {
                onfail("");
                return;
            }
            Intent intent = new Intent(this.mActivity, (Class<?>) ManualDetailActivity.class);
            intent.putExtra(util.k1.f20845c, checkUserBean);
            startActivity(intent);
        }
    }

    @Override // ui.callview.ManualView
    public void onfail(@i.c.a.d String str) {
        h.q2.t.i0.f(str, "msg");
        util.b1.a(this.mActivity, "未找到该用户", "请确认用户是否成功提交人工审核", "确定", (IOneClickListener) null);
    }

    @Override // ui.activity.BaseActivity
    public int setLayoutView() {
        return R.layout.activity_manual_check;
    }

    public final void setMPresenter(@i.c.a.e ManualPresenter manualPresenter) {
        this.mPresenter = manualPresenter;
    }
}
