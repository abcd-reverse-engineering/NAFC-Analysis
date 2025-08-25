package ui.activity;

import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import b.a.a.e.d;
import b.a.a.e.h;
import bean.RechargeBean;
import bean.RechargePlatBean;
import butterknife.BindView;
import butterknife.OnClick;
import com.hicorenational.antifraud.R;
import interfaces.IClickListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import manager.AccountManager;
import ui.Hicore;
import ui.callview.RechargeView;
import ui.presenter.RechargePresenter;
import util.y1;

/* compiled from: RechargeAddActivity.kt */
@h.y(bv = {1, 0, 3}, d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u00105\u001a\u000206H\u0016J\u0018\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020<H\u0016J\u0016\u0010=\u001a\u0002062\f\u0010>\u001a\b\u0012\u0004\u0012\u00020100H\u0016J\b\u0010?\u001a\u000206H\u0016J\u0010\u0010@\u001a\u0002062\u0006\u0010A\u001a\u00020\"H\u0007J\u0006\u0010B\u001a\u000206J\u0006\u0010C\u001a\u000206J\b\u0010D\u001a\u000206H\u0002J\b\u0010E\u001a\u00020:H\u0016J\u0012\u0010F\u001a\u0002062\b\u0010G\u001a\u0004\u0018\u00010\u0013H\u0002J\u0012\u0010H\u001a\u0002062\b\u0010I\u001a\u0004\u0018\u00010\u0013H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001e\u0010\f\u001a\u00020\r8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0012\u001a\u00020\u00138\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0018\u001a\u00020\r8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u000f\"\u0004\b\u001a\u0010\u0011R\u001e\u0010\u001b\u001a\u00020\r8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u000f\"\u0004\b\u001d\u0010\u0011R\u001e\u0010\u001e\u001a\u00020\u00138\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0015\"\u0004\b \u0010\u0017R\u001e\u0010!\u001a\u00020\"8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010)\u001a\u00020\u00138\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0015\"\u0004\b+\u0010\u0017R\u001e\u0010,\u001a\u0012\u0012\u0004\u0012\u00020\u00050-j\b\u0012\u0004\u0012\u00020\u0005`.X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010/\u001a\n\u0012\u0004\u0012\u000201\u0018\u000100X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00102\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00103\u001a\u0004\u0018\u000104X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006J"}, d2 = {"Lui/activity/RechargeAddActivity;", "Lui/activity/BaseActivity;", "Lui/callview/RechargeView;", "()V", "caseInfoId", "", "mBtnConfirm", "Landroid/widget/Button;", "getMBtnConfirm", "()Landroid/widget/Button;", "setMBtnConfirm", "(Landroid/widget/Button;)V", "mEtRechargePhone", "Landroid/widget/EditText;", "getMEtRechargePhone", "()Landroid/widget/EditText;", "setMEtRechargePhone", "(Landroid/widget/EditText;)V", "mEtRechargePlat", "Landroid/widget/TextView;", "getMEtRechargePlat", "()Landroid/widget/TextView;", "setMEtRechargePlat", "(Landroid/widget/TextView;)V", "mEtRechargePlatName", "getMEtRechargePlatName", "setMEtRechargePlatName", "mEtRechargeSum", "getMEtRechargeSum", "setMEtRechargeSum", "mEtRechargeTime", "getMEtRechargeTime", "setMEtRechargeTime", "mLlOtherPlatName", "Landroid/view/View;", "getMLlOtherPlatName", "()Landroid/view/View;", "setMLlOtherPlatName", "(Landroid/view/View;)V", "mPresenter", "Lui/presenter/RechargePresenter;", "mTvTitle", "getMTvTitle", "setMTvTitle", "pickTypes", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "platList", "", "Lbean/RechargePlatBean;", "platformCode", "rechargeBean", "Lbean/RechargeBean;", "initPage", "", "onKeyDown", "", "keyCode", "", "event", "Landroid/view/KeyEvent;", "onSuccessPlatList", "list", "onSuccessSave", "onViewClicked", "view", "onkeyback", "redisplayData", "saveHttpApi", "setLayoutView", "showPlatPiker", "tvView", "showTimePiker", "timePk", "app_offic_flavorRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes2.dex */
public final class RechargeAddActivity extends BaseActivity implements RechargeView {

    @BindView(R.id.btn_confirm)
    @i.c.a.d
    public Button mBtnConfirm;

    @BindView(R.id.et_recharge_phone)
    @i.c.a.d
    public EditText mEtRechargePhone;

    @BindView(R.id.et_recharge_plat)
    @i.c.a.d
    public TextView mEtRechargePlat;

    @BindView(R.id.et_recharge_name)
    @i.c.a.d
    public EditText mEtRechargePlatName;

    @BindView(R.id.et_recharge_sum)
    @i.c.a.d
    public EditText mEtRechargeSum;

    @BindView(R.id.tv_recharge_time)
    @i.c.a.d
    public TextView mEtRechargeTime;

    @BindView(R.id.ll_recharge_plat)
    @i.c.a.d
    public View mLlOtherPlatName;
    private RechargePresenter mPresenter;

    @BindView(R.id.tv_title)
    @i.c.a.d
    public TextView mTvTitle;
    private List<? extends RechargePlatBean> platList;
    private String platformCode;
    private RechargeBean rechargeBean;
    private String caseInfoId = "";
    private ArrayList<String> pickTypes = new ArrayList<>();

    /* compiled from: RechargeAddActivity.kt */
    public static final class a implements IClickListener {
        a() {
        }

        @Override // interfaces.IClickListener
        public void cancelBtn() {
        }

        @Override // interfaces.IClickListener
        public void clickOKBtn() {
            RechargeAddActivity.this.saveHttpApi();
        }
    }

    /* compiled from: RechargeAddActivity.kt */
    public static final class b implements IClickListener {
        b() {
        }

        @Override // interfaces.IClickListener
        public void cancelBtn() {
            RechargeAddActivity.this.finish();
        }

        @Override // interfaces.IClickListener
        public void clickOKBtn() {
        }
    }

    /* compiled from: RechargeAddActivity.kt */
    public static final class c extends h.a {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ TextView f18601b;

        c(TextView textView) {
            this.f18601b = textView;
        }

        @Override // b.a.a.e.h.a
        public void b(int i2, @i.c.a.d String str) {
            h.q2.t.i0.f(str, "item");
            List list = RechargeAddActivity.this.platList;
            if (list == null) {
                h.q2.t.i0.f();
            }
            RechargePlatBean rechargePlatBean = (RechargePlatBean) list.get(i2);
            RechargeAddActivity.this.platformCode = rechargePlatBean.getPlatform();
            if (h.q2.t.i0.a((Object) rechargePlatBean.getEx(), (Object) "1")) {
                RechargeAddActivity.this.getMLlOtherPlatName().setVisibility(0);
            } else {
                RechargeAddActivity.this.getMLlOtherPlatName().setVisibility(8);
            }
            TextView textView = this.f18601b;
            if (textView == null) {
                h.q2.t.i0.f();
            }
            textView.setText(str);
        }
    }

    /* compiled from: RechargeAddActivity.kt */
    static final class d implements d.m {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ TextView f18602a;

        d(TextView textView) {
            this.f18602a = textView;
        }

        @Override // b.a.a.e.d.m
        public final void a(String str, String str2, String str3, String str4, String str5) {
            String str6 = str + '-' + str2 + '-' + str3 + ' ' + str4 + ':' + str5;
            TextView textView = this.f18602a;
            if (textView == null) {
                h.q2.t.i0.f();
            }
            textView.setText(str6);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void saveHttpApi() {
        RechargePresenter rechargePresenter = this.mPresenter;
        if (rechargePresenter == null) {
            h.q2.t.i0.f();
        }
        rechargePresenter.saveRechargeTel(this.rechargeBean);
    }

    private final void showPlatPiker(TextView textView) {
        if (this.pickTypes.size() == 0) {
            return;
        }
        b.a.a.e.h hVar = new b.a.a.e.h(this.mActivity, this.pickTypes);
        hVar.x(3);
        hVar.E(0);
        hVar.C(15);
        hVar.setOnOptionPickListener(new c(textView));
        hVar.m();
    }

    private final void showTimePiker(TextView textView) {
        Calendar calendar = Calendar.getInstance();
        int i2 = calendar.get(1);
        int i3 = calendar.get(2) + 1;
        int i4 = calendar.get(5);
        int i5 = calendar.get(11);
        int i6 = calendar.get(12);
        b.a.a.e.d dVar = new b.a.a.e.d(this, 0, 3);
        dVar.g(2018, 2055);
        dVar.a(i2, i3, i4, i5, i6);
        dVar.setOnDateTimePickListener(new d(textView));
        dVar.m();
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
    public final EditText getMEtRechargePhone() {
        EditText editText = this.mEtRechargePhone;
        if (editText == null) {
            h.q2.t.i0.k("mEtRechargePhone");
        }
        return editText;
    }

    @i.c.a.d
    public final TextView getMEtRechargePlat() {
        TextView textView = this.mEtRechargePlat;
        if (textView == null) {
            h.q2.t.i0.k("mEtRechargePlat");
        }
        return textView;
    }

    @i.c.a.d
    public final EditText getMEtRechargePlatName() {
        EditText editText = this.mEtRechargePlatName;
        if (editText == null) {
            h.q2.t.i0.k("mEtRechargePlatName");
        }
        return editText;
    }

    @i.c.a.d
    public final EditText getMEtRechargeSum() {
        EditText editText = this.mEtRechargeSum;
        if (editText == null) {
            h.q2.t.i0.k("mEtRechargeSum");
        }
        return editText;
    }

    @i.c.a.d
    public final TextView getMEtRechargeTime() {
        TextView textView = this.mEtRechargeTime;
        if (textView == null) {
            h.q2.t.i0.k("mEtRechargeTime");
        }
        return textView;
    }

    @i.c.a.d
    public final View getMLlOtherPlatName() {
        View view = this.mLlOtherPlatName;
        if (view == null) {
            h.q2.t.i0.k("mLlOtherPlatName");
        }
        return view;
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
        this.mPresenter = new RechargePresenter(this, this);
        TextView textView = this.mTvTitle;
        if (textView == null) {
            h.q2.t.i0.k("mTvTitle");
        }
        if (textView == null) {
            h.q2.t.i0.f();
        }
        textView.setText("充值类嫌疑人电话详情");
        String stringExtra = getIntent().getStringExtra(util.k1.C0);
        if (stringExtra == null) {
            stringExtra = "";
        }
        this.caseInfoId = stringExtra;
        this.rechargeBean = (RechargeBean) getIntent().getSerializableExtra(util.k1.f20845c);
        RechargePresenter rechargePresenter = this.mPresenter;
        if (rechargePresenter == null) {
            h.q2.t.i0.f();
        }
        rechargePresenter.getPlatList();
        EditText editText = this.mEtRechargeSum;
        if (editText == null) {
            h.q2.t.i0.k("mEtRechargeSum");
        }
        y1.a(editText);
    }

    @Override // ui.callview.RechargeView
    public void onItemDelet(int i2) {
        RechargeView.a.a(this, i2);
    }

    @Override // ui.callview.RechargeView
    public void onItemEdit(int i2) {
        RechargeView.a.b(this, i2);
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

    @Override // ui.callview.RechargeView
    public void onSuccessList(@i.c.a.d List<? extends RechargeBean> list) {
        h.q2.t.i0.f(list, "list");
        RechargeView.a.a(this, list);
    }

    @Override // ui.callview.RechargeView
    public void onSuccessPlatList(@i.c.a.d List<? extends RechargePlatBean> list) {
        h.q2.t.i0.f(list, "list");
        RechargeView.a.b(this, list);
        if (list.size() > 0) {
            this.platList = list;
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.pickTypes.add(list.get(i2).getPlatformText());
                String platform = list.get(i2).getPlatform();
                RechargeBean rechargeBean = this.rechargeBean;
                if (h.q2.t.i0.a((Object) platform, (Object) (rechargeBean != null ? rechargeBean.getPlatform() : null))) {
                    if (h.q2.t.i0.a((Object) list.get(i2).getEx(), (Object) "1")) {
                        RechargeBean rechargeBean2 = this.rechargeBean;
                        if (rechargeBean2 == null) {
                            h.q2.t.i0.f();
                        }
                        rechargeBean2.setEx(1);
                    } else {
                        RechargeBean rechargeBean3 = this.rechargeBean;
                        if (rechargeBean3 == null) {
                            h.q2.t.i0.f();
                        }
                        rechargeBean3.setEx(0);
                    }
                }
            }
            redisplayData();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0019  */
    @Override // ui.callview.RechargeView
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onSuccessSave() {
        /*
            r1 = this;
            bean.RechargeBean r0 = r1.rechargeBean
            if (r0 == 0) goto L19
            if (r0 != 0) goto L9
            h.q2.t.i0.f()
        L9:
            java.lang.String r0 = r0.getChargeTelInfoID()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L19
            java.lang.String r0 = "修改成功"
            util.w1.a(r0)
            goto L1e
        L19:
            java.lang.String r0 = "添加成功"
            util.w1.a(r0)
        L1e:
            r1.finish()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ui.activity.RechargeAddActivity.onSuccessSave():void");
    }

    @OnClick({R.id.iv_back, R.id.et_recharge_plat, R.id.tv_recharge_time, R.id.btn_confirm})
    public final void onViewClicked(@i.c.a.d View view) {
        h.q2.t.i0.f(view, "view");
        Hicore app = Hicore.getApp();
        h.q2.t.i0.a((Object) app, "Hicore.getApp()");
        if (app.isDouble()) {
        }
        switch (view.getId()) {
            case R.id.btn_confirm /* 2131296396 */:
                TextView textView = this.mEtRechargePlat;
                if (textView == null) {
                    h.q2.t.i0.k("mEtRechargePlat");
                }
                if (textView == null) {
                    h.q2.t.i0.f();
                }
                String string = textView.getText().toString();
                EditText editText = this.mEtRechargePlatName;
                if (editText == null) {
                    h.q2.t.i0.k("mEtRechargePlatName");
                }
                if (editText == null) {
                    h.q2.t.i0.f();
                }
                String string2 = editText.getText().toString();
                EditText editText2 = this.mEtRechargePhone;
                if (editText2 == null) {
                    h.q2.t.i0.k("mEtRechargePhone");
                }
                if (editText2 == null) {
                    h.q2.t.i0.f();
                }
                String string3 = editText2.getText().toString();
                EditText editText3 = this.mEtRechargeSum;
                if (editText3 == null) {
                    h.q2.t.i0.k("mEtRechargeSum");
                }
                if (editText3 == null) {
                    h.q2.t.i0.f();
                }
                String string4 = editText3.getText().toString();
                TextView textView2 = this.mEtRechargeTime;
                if (textView2 == null) {
                    h.q2.t.i0.k("mEtRechargeTime");
                }
                if (textView2 == null) {
                    h.q2.t.i0.f();
                }
                String string5 = textView2.getText().toString();
                View view2 = this.mLlOtherPlatName;
                if (view2 == null) {
                    h.q2.t.i0.k("mLlOtherPlatName");
                }
                if (view2.isShown()) {
                    if (string2.length() == 0) {
                        util.w1.a("请输入充值平台名称");
                        break;
                    }
                }
                if (!(string.length() == 0)) {
                    if (!(string3.length() == 0)) {
                        if (!(string4.length() == 0)) {
                            if (!(string5.length() == 0)) {
                                RechargeBean rechargeBean = this.rechargeBean;
                                if (rechargeBean == null) {
                                    this.rechargeBean = new RechargeBean();
                                    RechargeBean rechargeBean2 = this.rechargeBean;
                                    if (rechargeBean2 == null) {
                                        h.q2.t.i0.f();
                                    }
                                    rechargeBean2.setCaseInfoID(this.caseInfoId);
                                    RechargeBean rechargeBean3 = this.rechargeBean;
                                    if (rechargeBean3 == null) {
                                        h.q2.t.i0.f();
                                    }
                                    rechargeBean3.setPlatform(this.platformCode);
                                    View view3 = this.mLlOtherPlatName;
                                    if (view3 == null) {
                                        h.q2.t.i0.k("mLlOtherPlatName");
                                    }
                                    if (view3.isShown()) {
                                        RechargeBean rechargeBean4 = this.rechargeBean;
                                        if (rechargeBean4 == null) {
                                            h.q2.t.i0.f();
                                        }
                                        rechargeBean4.setPlatformText(string2);
                                    } else {
                                        RechargeBean rechargeBean5 = this.rechargeBean;
                                        if (rechargeBean5 == null) {
                                            h.q2.t.i0.f();
                                        }
                                        rechargeBean5.setPlatformText(string);
                                    }
                                    RechargeBean rechargeBean6 = this.rechargeBean;
                                    if (rechargeBean6 == null) {
                                        h.q2.t.i0.f();
                                    }
                                    rechargeBean6.setSuspectMobile(string3);
                                    RechargeBean rechargeBean7 = this.rechargeBean;
                                    if (rechargeBean7 == null) {
                                        h.q2.t.i0.f();
                                    }
                                    rechargeBean7.setAmount(string4);
                                    RechargeBean rechargeBean8 = this.rechargeBean;
                                    if (rechargeBean8 == null) {
                                        h.q2.t.i0.f();
                                    }
                                    rechargeBean8.setChargeTime(string5);
                                } else {
                                    if (rechargeBean == null) {
                                        h.q2.t.i0.f();
                                    }
                                    rechargeBean.setCaseInfoID(this.caseInfoId);
                                    RechargeBean rechargeBean9 = this.rechargeBean;
                                    if (rechargeBean9 == null) {
                                        h.q2.t.i0.f();
                                    }
                                    rechargeBean9.setPlatform(this.platformCode);
                                    View view4 = this.mLlOtherPlatName;
                                    if (view4 == null) {
                                        h.q2.t.i0.k("mLlOtherPlatName");
                                    }
                                    if (view4.isShown()) {
                                        RechargeBean rechargeBean10 = this.rechargeBean;
                                        if (rechargeBean10 == null) {
                                            h.q2.t.i0.f();
                                        }
                                        rechargeBean10.setPlatformText(string2);
                                    } else {
                                        RechargeBean rechargeBean11 = this.rechargeBean;
                                        if (rechargeBean11 == null) {
                                            h.q2.t.i0.f();
                                        }
                                        rechargeBean11.setPlatformText(string);
                                    }
                                    RechargeBean rechargeBean12 = this.rechargeBean;
                                    if (rechargeBean12 == null) {
                                        h.q2.t.i0.f();
                                    }
                                    rechargeBean12.setSuspectMobile(string3);
                                    RechargeBean rechargeBean13 = this.rechargeBean;
                                    if (rechargeBean13 == null) {
                                        h.q2.t.i0.f();
                                    }
                                    rechargeBean13.setAmount(string4);
                                    RechargeBean rechargeBean14 = this.rechargeBean;
                                    if (rechargeBean14 == null) {
                                        h.q2.t.i0.f();
                                    }
                                    rechargeBean14.setChargeTime(string5);
                                }
                                if (!h.q2.t.i0.a((Object) string3, (Object) AccountManager.getVisiblePhone())) {
                                    saveHttpApi();
                                    break;
                                } else {
                                    util.b1.a(this.mActivity, "添加的充值手机号码是您的登录号码，确定添加个人号码为诈骗号码?", "", "取消", "确定", -1, -1, (IClickListener) new a());
                                    break;
                                }
                            } else {
                                util.w1.a("请选择充值时间");
                                break;
                            }
                        } else {
                            util.w1.a("请输入充值金额");
                            break;
                        }
                    } else {
                        util.w1.a("请填写被充值的手机号码");
                        break;
                    }
                } else {
                    util.w1.a("请选择充值平台");
                    break;
                }
            case R.id.et_recharge_plat /* 2131296581 */:
                TextView textView3 = this.mEtRechargePlat;
                if (textView3 == null) {
                    h.q2.t.i0.k("mEtRechargePlat");
                }
                showPlatPiker(textView3);
                break;
            case R.id.iv_back /* 2131296762 */:
                onkeyback();
                break;
            case R.id.tv_recharge_time /* 2131297673 */:
                TextView textView4 = this.mEtRechargeTime;
                if (textView4 == null) {
                    h.q2.t.i0.k("mEtRechargeTime");
                }
                showTimePiker(textView4);
                break;
        }
    }

    public final void onkeyback() {
        util.b1.b(this.mActivity, "放弃本次信息编辑？", "", "确定", "取消", new b());
    }

    public final void redisplayData() {
        EditText editText = this.mEtRechargePhone;
        if (editText == null) {
            h.q2.t.i0.k("mEtRechargePhone");
        }
        if (editText == null) {
            h.q2.t.i0.f();
        }
        RechargeBean rechargeBean = this.rechargeBean;
        if (rechargeBean == null) {
            h.q2.t.i0.f();
        }
        editText.setText(rechargeBean.getSuspectMobile());
        EditText editText2 = this.mEtRechargeSum;
        if (editText2 == null) {
            h.q2.t.i0.k("mEtRechargeSum");
        }
        if (editText2 == null) {
            h.q2.t.i0.f();
        }
        RechargeBean rechargeBean2 = this.rechargeBean;
        if (rechargeBean2 == null) {
            h.q2.t.i0.f();
        }
        editText2.setText(rechargeBean2.getAmount());
        TextView textView = this.mEtRechargeTime;
        if (textView == null) {
            h.q2.t.i0.k("mEtRechargeTime");
        }
        if (textView == null) {
            h.q2.t.i0.f();
        }
        RechargeBean rechargeBean3 = this.rechargeBean;
        if (rechargeBean3 == null) {
            h.q2.t.i0.f();
        }
        textView.setText(rechargeBean3.getChargeTime());
        RechargeBean rechargeBean4 = this.rechargeBean;
        if (rechargeBean4 == null) {
            h.q2.t.i0.f();
        }
        if (rechargeBean4.getEx() == 1) {
            View view = this.mLlOtherPlatName;
            if (view == null) {
                h.q2.t.i0.k("mLlOtherPlatName");
            }
            view.setVisibility(0);
            TextView textView2 = this.mEtRechargePlat;
            if (textView2 == null) {
                h.q2.t.i0.k("mEtRechargePlat");
            }
            if (textView2 == null) {
                h.q2.t.i0.f();
            }
            ArrayList<String> arrayList = this.pickTypes;
            textView2.setText(arrayList.get(arrayList.size() - 1));
            EditText editText3 = this.mEtRechargePlatName;
            if (editText3 == null) {
                h.q2.t.i0.k("mEtRechargePlatName");
            }
            if (editText3 == null) {
                h.q2.t.i0.f();
            }
            RechargeBean rechargeBean5 = this.rechargeBean;
            if (rechargeBean5 == null) {
                h.q2.t.i0.f();
            }
            editText3.setText(rechargeBean5.getPlatformText());
        } else {
            View view2 = this.mLlOtherPlatName;
            if (view2 == null) {
                h.q2.t.i0.k("mLlOtherPlatName");
            }
            view2.setVisibility(8);
            TextView textView3 = this.mEtRechargePlat;
            if (textView3 == null) {
                h.q2.t.i0.k("mEtRechargePlat");
            }
            if (textView3 == null) {
                h.q2.t.i0.f();
            }
            RechargeBean rechargeBean6 = this.rechargeBean;
            if (rechargeBean6 == null) {
                h.q2.t.i0.f();
            }
            textView3.setText(rechargeBean6.getPlatformText());
        }
        RechargeBean rechargeBean7 = this.rechargeBean;
        if (rechargeBean7 == null) {
            h.q2.t.i0.f();
        }
        this.platformCode = rechargeBean7.getPlatform();
    }

    @Override // ui.activity.BaseActivity
    public int setLayoutView() {
        return R.layout.activity_recharge_add;
    }

    public final void setMBtnConfirm(@i.c.a.d Button button) {
        h.q2.t.i0.f(button, "<set-?>");
        this.mBtnConfirm = button;
    }

    public final void setMEtRechargePhone(@i.c.a.d EditText editText) {
        h.q2.t.i0.f(editText, "<set-?>");
        this.mEtRechargePhone = editText;
    }

    public final void setMEtRechargePlat(@i.c.a.d TextView textView) {
        h.q2.t.i0.f(textView, "<set-?>");
        this.mEtRechargePlat = textView;
    }

    public final void setMEtRechargePlatName(@i.c.a.d EditText editText) {
        h.q2.t.i0.f(editText, "<set-?>");
        this.mEtRechargePlatName = editText;
    }

    public final void setMEtRechargeSum(@i.c.a.d EditText editText) {
        h.q2.t.i0.f(editText, "<set-?>");
        this.mEtRechargeSum = editText;
    }

    public final void setMEtRechargeTime(@i.c.a.d TextView textView) {
        h.q2.t.i0.f(textView, "<set-?>");
        this.mEtRechargeTime = textView;
    }

    public final void setMLlOtherPlatName(@i.c.a.d View view) {
        h.q2.t.i0.f(view, "<set-?>");
        this.mLlOtherPlatName = view;
    }

    public final void setMTvTitle(@i.c.a.d TextView textView) {
        h.q2.t.i0.f(textView, "<set-?>");
        this.mTvTitle = textView;
    }
}
