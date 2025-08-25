package ui.activity;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import bean.UserInfoBean;
import butterknife.BindView;
import butterknife.OnClick;
import com.hicorenational.antifraud.R;
import manager.AccountManager;
import network.account.APIresult;
import network.http.AddressHttp;
import ui.callview.MinePersonalAddView;
import ui.presenter.MinePersonalAddPresenter;
import ui.view.swip.SwipBackLayout;

/* compiled from: PersonalInfoAddActivity.kt */
@h.y(bv = {1, 0, 3}, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 P2\u00020\u00012\u00020\u0002:\u0001PB\u0005¢\u0006\u0002\u0010\u0003J\b\u0010C\u001a\u00020DH\u0002J\u0006\u0010E\u001a\u00020DJ\u0006\u0010F\u001a\u00020DJ\b\u0010G\u001a\u00020DH\u0016J\u0010\u0010H\u001a\u00020D2\u0006\u0010I\u001a\u00020\u0011H\u0007J\u0016\u0010J\u001a\u00020D2\f\u0010K\u001a\b\u0012\u0002\b\u0003\u0018\u00010LH\u0016J\u0010\u0010M\u001a\u00020D2\u0006\u0010N\u001a\u000205H\u0016J\b\u0010O\u001a\u000205H\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u00020\u00118\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0016\u001a\u00020\u00118\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R\u001e\u0010\u0019\u001a\u00020\u001a8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001e\u0010\u001f\u001a\u00020 8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001e\u0010%\u001a\u00020&8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001c\u0010+\u001a\u0004\u0018\u00010,X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001e\u00101\u001a\u00020 8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\"\"\u0004\b3\u0010$R\u0012\u00104\u001a\u0004\u0018\u000105X\u0082\u000e¢\u0006\u0004\n\u0002\u00106R\u001c\u00107\u001a\u0004\u0018\u000108X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u001c\u0010=\u001a\u0004\u0018\u00010>X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010@\"\u0004\bA\u0010B¨\u0006Q"}, d2 = {"Lui/activity/PersonalInfoAddActivity;", "Lui/activity/BaseActivity;", "Lui/callview/MinePersonalAddView;", "()V", "hasClick", "", "getHasClick", "()Z", "setHasClick", "(Z)V", "mBtnConfirm", "Landroid/widget/Button;", "getMBtnConfirm", "()Landroid/widget/Button;", "setMBtnConfirm", "(Landroid/widget/Button;)V", "mClArea", "Landroid/view/View;", "getMClArea", "()Landroid/view/View;", "setMClArea", "(Landroid/view/View;)V", "mClAreaDetail", "getMClAreaDetail", "setMClAreaDetail", "mEtAddres", "Landroid/widget/EditText;", "getMEtAddres", "()Landroid/widget/EditText;", "setMEtAddres", "(Landroid/widget/EditText;)V", "mEtArea", "Landroid/widget/TextView;", "getMEtArea", "()Landroid/widget/TextView;", "setMEtArea", "(Landroid/widget/TextView;)V", "mIvBack", "Landroid/widget/ImageView;", "getMIvBack", "()Landroid/widget/ImageView;", "setMIvBack", "(Landroid/widget/ImageView;)V", "mPresenter", "Lui/presenter/MinePersonalAddPresenter;", "getMPresenter", "()Lui/presenter/MinePersonalAddPresenter;", "setMPresenter", "(Lui/presenter/MinePersonalAddPresenter;)V", "mTvTitle", "getMTvTitle", "setMTvTitle", "pageType", "", "Ljava/lang/Integer;", "regId", "", "getRegId", "()Ljava/lang/String;", "setRegId", "(Ljava/lang/String;)V", "userInfo", "Lbean/UserInfoBean;", "getUserInfo", "()Lbean/UserInfoBean;", "setUserInfo", "(Lbean/UserInfoBean;)V", "area", "", "initIntentData", "initListener", "initPage", "onClick", "view", "onSuccModifyRequest", "resultInfo", "Lnetwork/account/APIresult;", "onSuccUpdateRequest", "page", "setLayoutView", "Companion", "app_offic_flavorRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes2.dex */
public final class PersonalInfoAddActivity extends BaseActivity implements MinePersonalAddView {
    public static final int ADDRESS_1 = 1;
    public static final int ADDRESS_11 = 11;
    public static final a Companion = new a(null);
    private boolean hasClick;

    @BindView(R.id.btn_confirm)
    @i.c.a.d
    public Button mBtnConfirm;

    @BindView(R.id.cl_area_cont)
    @i.c.a.d
    public View mClArea;

    @BindView(R.id.cl_area_detail_content)
    @i.c.a.d
    public View mClAreaDetail;

    @BindView(R.id.et_address)
    @i.c.a.d
    public EditText mEtAddres;

    @BindView(R.id.et_area)
    @i.c.a.d
    public TextView mEtArea;

    @BindView(R.id.iv_back)
    @i.c.a.d
    public ImageView mIvBack;

    @i.c.a.e
    private MinePersonalAddPresenter mPresenter;

    @BindView(R.id.tv_title)
    @i.c.a.d
    public TextView mTvTitle;
    private Integer pageType = 0;

    @i.c.a.e
    private String regId;

    @i.c.a.e
    private UserInfoBean userInfo;

    /* compiled from: PersonalInfoAddActivity.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(h.q2.t.v vVar) {
            this();
        }
    }

    /* compiled from: PersonalInfoAddActivity.kt */
    public static final class b extends AddressHttp.MyPicker {
        b() {
        }

        @Override // network.http.AddressHttp.MyPicker, b.a.a.e.a.e
        public void onAddressPicked(@i.c.a.e b.a.a.d.k kVar, @i.c.a.e b.a.a.d.d dVar, @i.c.a.e b.a.a.d.e eVar) {
            if (kVar == null || dVar == null || eVar == null) {
                TextView mEtArea = PersonalInfoAddActivity.this.getMEtArea();
                if (mEtArea != null) {
                    mEtArea.setText("");
                    return;
                }
                return;
            }
            PersonalInfoAddActivity.this.setRegId(eVar.getAreaId());
            String str = kVar.getName() + dVar.getName() + eVar.getName();
            TextView mEtArea2 = PersonalInfoAddActivity.this.getMEtArea();
            if (mEtArea2 != null) {
                mEtArea2.setText(str);
            }
        }

        @Override // network.http.AddressHttp.MyPicker
        public void onClear() {
        }
    }

    /* compiled from: PersonalInfoAddActivity.kt */
    static final class c implements View.OnFocusChangeListener {
        c() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public final void onFocusChange(View view, boolean z) {
            if (!z || PersonalInfoAddActivity.this.getHasClick()) {
                return;
            }
            PersonalInfoAddActivity.this.getMEtAddres().setText("");
            PersonalInfoAddActivity.this.setHasClick(true);
        }
    }

    private final void area() {
        AddressHttp.getAddSint(this.mActivity).regionPickNoClear(new b());
    }

    public final boolean getHasClick() {
        return this.hasClick;
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
    public final View getMClArea() {
        View view = this.mClArea;
        if (view == null) {
            h.q2.t.i0.k("mClArea");
        }
        return view;
    }

    @i.c.a.d
    public final View getMClAreaDetail() {
        View view = this.mClAreaDetail;
        if (view == null) {
            h.q2.t.i0.k("mClAreaDetail");
        }
        return view;
    }

    @i.c.a.d
    public final EditText getMEtAddres() {
        EditText editText = this.mEtAddres;
        if (editText == null) {
            h.q2.t.i0.k("mEtAddres");
        }
        return editText;
    }

    @i.c.a.d
    public final TextView getMEtArea() {
        TextView textView = this.mEtArea;
        if (textView == null) {
            h.q2.t.i0.k("mEtArea");
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

    @i.c.a.e
    public final MinePersonalAddPresenter getMPresenter() {
        return this.mPresenter;
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
    public final String getRegId() {
        return this.regId;
    }

    @i.c.a.e
    public final UserInfoBean getUserInfo() {
        return this.userInfo;
    }

    public final void initIntentData() {
        this.userInfo = (UserInfoBean) getIntent().getSerializableExtra(util.k1.f20845c);
        this.pageType = Integer.valueOf(getIntent().getIntExtra(util.k1.f20846d, 0));
        Integer num = this.pageType;
        if (num != null && num.intValue() == 1) {
            TextView textView = this.mTvTitle;
            if (textView == null) {
                h.q2.t.i0.k("mTvTitle");
            }
            if (textView == null) {
                h.q2.t.i0.f();
            }
            textView.setText("所在地区");
            View view = this.mClArea;
            if (view == null) {
                h.q2.t.i0.k("mClArea");
            }
            if (view == null) {
                h.q2.t.i0.f();
            }
            view.setVisibility(0);
            UserInfoBean userInfoBean = this.userInfo;
            if (userInfoBean != null) {
                this.regId = userInfoBean != null ? userInfoBean.getRegionCode() : null;
                TextView textView2 = this.mEtArea;
                if (textView2 == null) {
                    h.q2.t.i0.k("mEtArea");
                }
                UserInfoBean userInfoBean2 = this.userInfo;
                textView2.setText(userInfoBean2 != null ? userInfoBean2.getRegion() : null);
                return;
            }
            return;
        }
        Integer num2 = this.pageType;
        if (num2 != null && num2.intValue() == 11) {
            TextView textView3 = this.mTvTitle;
            if (textView3 == null) {
                h.q2.t.i0.k("mTvTitle");
            }
            if (textView3 == null) {
                h.q2.t.i0.f();
            }
            textView3.setText("详细地址");
            View view2 = this.mClAreaDetail;
            if (view2 == null) {
                h.q2.t.i0.k("mClAreaDetail");
            }
            if (view2 == null) {
                h.q2.t.i0.f();
            }
            view2.setVisibility(0);
            UserInfoBean userInfoBean3 = this.userInfo;
            if (userInfoBean3 != null) {
                this.regId = userInfoBean3 != null ? userInfoBean3.getRegionCode() : null;
                EditText editText = this.mEtAddres;
                if (editText == null) {
                    h.q2.t.i0.k("mEtAddres");
                }
                UserInfoBean userInfoBean4 = this.userInfo;
                editText.setText(userInfoBean4 != null ? userInfoBean4.getAddr() : null);
            }
        }
    }

    public final void initListener() {
        Integer num = this.pageType;
        if (num != null && num.intValue() == 11) {
            EditText editText = this.mEtAddres;
            if (editText == null) {
                h.q2.t.i0.k("mEtAddres");
            }
            editText.setOnFocusChangeListener(new c());
        }
    }

    @Override // ui.activity.BaseActivity
    public void initPage() {
        ui.statusbarcompat.b.a((Activity) this, true, true);
        SwipBackLayout.a(this.mActivity).a();
        this.mPresenter = new MinePersonalAddPresenter(this.mActivity, this);
        initIntentData();
        initListener();
    }

    @OnClick({R.id.iv_back, R.id.et_area, R.id.btn_confirm})
    public final void onClick(@i.c.a.d View view) {
        h.q2.t.i0.f(view, "view");
        if (isDouble()) {
            return;
        }
        int id = view.getId();
        if (id != R.id.btn_confirm) {
            if (id == R.id.et_area) {
                area();
                return;
            } else {
                if (id != R.id.iv_back) {
                    return;
                }
                onBackPressed();
                return;
            }
        }
        Integer num = this.pageType;
        if (num != null && num.intValue() == 1) {
            TextView textView = this.mEtArea;
            if (textView == null) {
                h.q2.t.i0.k("mEtArea");
            }
            if (TextUtils.isEmpty(textView.getText().toString())) {
                util.w1.a("请选择所在地区");
                return;
            }
            MinePersonalAddPresenter minePersonalAddPresenter = this.mPresenter;
            if (minePersonalAddPresenter != null) {
                Integer num2 = this.pageType;
                if (num2 == null) {
                    h.q2.t.i0.f();
                }
                minePersonalAddPresenter.updateUserAddres(num2.intValue(), this.regId, "");
                return;
            }
            return;
        }
        Integer num3 = this.pageType;
        if (num3 != null && num3.intValue() == 11) {
            if (!this.hasClick) {
                onBackPressed();
                return;
            }
            EditText editText = this.mEtAddres;
            if (editText == null) {
                h.q2.t.i0.k("mEtAddres");
            }
            String string = editText.getText().toString();
            if (TextUtils.isEmpty(string) || h.z2.c0.c((CharSequence) string, (CharSequence) "*", false, 2, (Object) null)) {
                util.w1.a("请输入详细地址");
                return;
            }
            MinePersonalAddPresenter minePersonalAddPresenter2 = this.mPresenter;
            if (minePersonalAddPresenter2 != null) {
                Integer num4 = this.pageType;
                if (num4 == null) {
                    h.q2.t.i0.f();
                }
                minePersonalAddPresenter2.updateUserAddres(num4.intValue(), "", string);
            }
        }
    }

    @Override // ui.callview.MinePersonalAddView
    public void onSuccModifyRequest(@i.c.a.e APIresult<?> aPIresult) {
        Integer numValueOf = aPIresult != null ? Integer.valueOf(aPIresult.getCode()) : null;
        if (numValueOf == null || numValueOf.intValue() != 0) {
            util.w1.a(aPIresult != null ? aPIresult.getMsg() : null);
            return;
        }
        TextView textView = this.mEtArea;
        if (textView == null) {
            h.q2.t.i0.k("mEtArea");
        }
        AccountManager.setRegion(textView.getText().toString());
    }

    @Override // ui.callview.MinePersonalAddView
    public void onSuccUpdateRequest(int i2) {
        UserInfoBean userInfoBean = (UserInfoBean) util.p1.a(util.p1.f20902l, UserInfoBean.class);
        Integer num = this.pageType;
        if (num != null && num.intValue() == 1) {
            h.q2.t.i0.a((Object) userInfoBean, "userInfoBean");
            userInfoBean.setRegionCode(this.regId);
            TextView textView = this.mEtArea;
            if (textView == null) {
                h.q2.t.i0.k("mEtArea");
            }
            userInfoBean.setRegion(textView.getText().toString());
        } else {
            Integer num2 = this.pageType;
            if (num2 != null && num2.intValue() == 11) {
                h.q2.t.i0.a((Object) userInfoBean, "userInfoBean");
                EditText editText = this.mEtAddres;
                if (editText == null) {
                    h.q2.t.i0.k("mEtAddres");
                }
                userInfoBean.setAddr(editText.getText().toString());
            }
        }
        util.p1.a(util.p1.f20902l, userInfoBean);
        finish();
    }

    public final void setHasClick(boolean z) {
        this.hasClick = z;
    }

    @Override // ui.activity.BaseActivity
    public int setLayoutView() {
        return R.layout.activity_persona_infol;
    }

    public final void setMBtnConfirm(@i.c.a.d Button button) {
        h.q2.t.i0.f(button, "<set-?>");
        this.mBtnConfirm = button;
    }

    public final void setMClArea(@i.c.a.d View view) {
        h.q2.t.i0.f(view, "<set-?>");
        this.mClArea = view;
    }

    public final void setMClAreaDetail(@i.c.a.d View view) {
        h.q2.t.i0.f(view, "<set-?>");
        this.mClAreaDetail = view;
    }

    public final void setMEtAddres(@i.c.a.d EditText editText) {
        h.q2.t.i0.f(editText, "<set-?>");
        this.mEtAddres = editText;
    }

    public final void setMEtArea(@i.c.a.d TextView textView) {
        h.q2.t.i0.f(textView, "<set-?>");
        this.mEtArea = textView;
    }

    public final void setMIvBack(@i.c.a.d ImageView imageView) {
        h.q2.t.i0.f(imageView, "<set-?>");
        this.mIvBack = imageView;
    }

    public final void setMPresenter(@i.c.a.e MinePersonalAddPresenter minePersonalAddPresenter) {
        this.mPresenter = minePersonalAddPresenter;
    }

    public final void setMTvTitle(@i.c.a.d TextView textView) {
        h.q2.t.i0.f(textView, "<set-?>");
        this.mTvTitle = textView;
    }

    public final void setRegId(@i.c.a.e String str) {
        this.regId = str;
    }

    public final void setUserInfo(@i.c.a.e UserInfoBean userInfoBean) {
        this.userInfo = userInfoBean;
    }
}
