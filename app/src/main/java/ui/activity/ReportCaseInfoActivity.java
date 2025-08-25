package ui.activity;

import android.content.Intent;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import bean.ReportIDInfoBean;
import bean.SignComitBean;
import bean.SurveyPeopleBean;
import butterknife.BindView;
import butterknife.OnClick;
import com.hicorenational.antifraud.R;
import interfaces.IClickListener;
import java.util.List;
import org.greenrobot.eventbus.ThreadMode;
import ui.callview.VictimPeopleView;
import ui.presenter.ReportCaseInfoPresenter;
import ui.view.swip.SwipBackLayout;

/* compiled from: ReportCaseInfoActivity.kt */
@h.y(bv = {1, 0, 3}, d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010I\u001a\u00020JH\u0016J\u0006\u0010K\u001a\u00020JJ\u0010\u0010L\u001a\u00020J2\u0006\u0010M\u001a\u00020\u0011H\u0007J\b\u0010N\u001a\u00020JH\u0014J\u0010\u0010O\u001a\u00020J2\u0006\u0010P\u001a\u00020QH\u0007J\u0018\u0010R\u001a\u00020S2\u0006\u0010T\u001a\u00020)2\u0006\u0010U\u001a\u00020VH\u0016J\b\u0010W\u001a\u00020JH\u0014J\u0012\u0010X\u001a\u00020J2\b\u0010Y\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010Z\u001a\u00020JH\u0016J\u0016\u0010[\u001a\u00020J2\f\u0010\\\u001a\b\u0012\u0004\u0012\u00020^0]H\u0016J\u0006\u0010_\u001a\u00020JJ\b\u0010`\u001a\u00020)H\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u00020\u00118\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0016\u001a\u00020\u00178\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001e\u0010\u001c\u001a\u00020\u00178\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0019\"\u0004\b\u001e\u0010\u001bR\u001e\u0010\u001f\u001a\u00020\u00178\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0019\"\u0004\b!\u0010\u001bR\u001e\u0010\"\u001a\u00020\u00178\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0019\"\u0004\b$\u0010\u001bR\u001e\u0010%\u001a\u00020\u00178\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0019\"\u0004\b'\u0010\u001bR\u001a\u0010(\u001a\u00020)X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001c\u0010.\u001a\u0004\u0018\u00010/X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u001e\u00104\u001a\u0002058\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u001e\u0010:\u001a\u00020;8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\u001e\u0010@\u001a\u00020;8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010=\"\u0004\bB\u0010?R\u001c\u0010C\u001a\u0004\u0018\u00010DX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010F\"\u0004\bG\u0010H¨\u0006a"}, d2 = {"Lui/activity/ReportCaseInfoActivity;", "Lui/activity/BaseActivity;", "Lui/callview/VictimPeopleView;", "()V", "caseInfoId", "", "getCaseInfoId", "()Ljava/lang/String;", "setCaseInfoId", "(Ljava/lang/String;)V", "comitNumBean", "Lbean/SignComitBean;", "getComitNumBean", "()Lbean/SignComitBean;", "setComitNumBean", "(Lbean/SignComitBean;)V", "mFlBottomView", "Landroid/view/View;", "getMFlBottomView", "()Landroid/view/View;", "setMFlBottomView", "(Landroid/view/View;)V", "mInvolveAccTip", "Landroid/widget/ImageView;", "getMInvolveAccTip", "()Landroid/widget/ImageView;", "setMInvolveAccTip", "(Landroid/widget/ImageView;)V", "mIvBack", "getMIvBack", "setMIvBack", "mIvCallTip", "getMIvCallTip", "setMIvCallTip", "mIvSmsTip", "getMIvSmsTip", "setMIvSmsTip", "mIvWebNetTip", "getMIvWebNetTip", "setMIvWebNetTip", "mMaxNum", "", "getMMaxNum", "()I", "setMMaxNum", "(I)V", "mPresenter", "Lui/presenter/ReportCaseInfoPresenter;", "getMPresenter", "()Lui/presenter/ReportCaseInfoPresenter;", "setMPresenter", "(Lui/presenter/ReportCaseInfoPresenter;)V", "mRvList", "Landroidx/recyclerview/widget/RecyclerView;", "getMRvList", "()Landroidx/recyclerview/widget/RecyclerView;", "setMRvList", "(Landroidx/recyclerview/widget/RecyclerView;)V", "mTvAdd", "Landroid/widget/TextView;", "getMTvAdd", "()Landroid/widget/TextView;", "setMTvAdd", "(Landroid/widget/TextView;)V", "mTvTitle", "getMTvTitle", "setMTvTitle", "reportIDBean", "Lbean/ReportIDInfoBean;", "getReportIDBean", "()Lbean/ReportIDInfoBean;", "setReportIDBean", "(Lbean/ReportIDInfoBean;)V", "initPage", "", "initView", "onClick", "view", "onDestroy", "onEventMainThread", "refreshUIEvent", "Lutil/event/RefreshUIEvent;", "onKeyDown", "", "keyCode", "event", "Landroid/view/KeyEvent;", "onResume", "onSuccessCaseNum", "bean", "onSuccessDelet", "onSuccessHandle", "list", "", "Lbean/SurveyPeopleBean;", "onkeyback", "setLayoutView", "app_offic_flavorRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes2.dex */
public final class ReportCaseInfoActivity extends BaseActivity implements VictimPeopleView {

    @i.c.a.e
    private SignComitBean comitNumBean;

    @BindView(R.id.fl_bottom_view)
    @i.c.a.d
    public View mFlBottomView;

    @BindView(R.id.involved_acc_tip)
    @i.c.a.d
    public ImageView mInvolveAccTip;

    @BindView(R.id.iv_back)
    @i.c.a.d
    public ImageView mIvBack;

    @BindView(R.id.iv_call_tip)
    @i.c.a.d
    public ImageView mIvCallTip;

    @BindView(R.id.iv_sms_tip)
    @i.c.a.d
    public ImageView mIvSmsTip;

    @BindView(R.id.iv_webnet_tip)
    @i.c.a.d
    public ImageView mIvWebNetTip;

    @i.c.a.e
    private ReportCaseInfoPresenter mPresenter;

    @BindView(R.id.recyclerview)
    @i.c.a.d
    public RecyclerView mRvList;

    @BindView(R.id.tv_add)
    @i.c.a.d
    public TextView mTvAdd;

    @BindView(R.id.tv_title)
    @i.c.a.d
    public TextView mTvTitle;

    @i.c.a.e
    private ReportIDInfoBean reportIDBean;

    @i.c.a.d
    private String caseInfoId = "";
    private int mMaxNum = 10;

    /* compiled from: ReportCaseInfoActivity.kt */
    public static final class a implements IClickListener {
        a() {
        }

        @Override // interfaces.IClickListener
        public void cancelBtn() {
            ReportCaseInfoActivity.this.finish();
        }

        @Override // interfaces.IClickListener
        public void clickOKBtn() {
        }
    }

    @i.c.a.d
    public final String getCaseInfoId() {
        return this.caseInfoId;
    }

    @i.c.a.e
    public final SignComitBean getComitNumBean() {
        return this.comitNumBean;
    }

    @i.c.a.d
    public final View getMFlBottomView() {
        View view = this.mFlBottomView;
        if (view == null) {
            h.q2.t.i0.k("mFlBottomView");
        }
        return view;
    }

    @i.c.a.d
    public final ImageView getMInvolveAccTip() {
        ImageView imageView = this.mInvolveAccTip;
        if (imageView == null) {
            h.q2.t.i0.k("mInvolveAccTip");
        }
        return imageView;
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
    public final ImageView getMIvCallTip() {
        ImageView imageView = this.mIvCallTip;
        if (imageView == null) {
            h.q2.t.i0.k("mIvCallTip");
        }
        return imageView;
    }

    @i.c.a.d
    public final ImageView getMIvSmsTip() {
        ImageView imageView = this.mIvSmsTip;
        if (imageView == null) {
            h.q2.t.i0.k("mIvSmsTip");
        }
        return imageView;
    }

    @i.c.a.d
    public final ImageView getMIvWebNetTip() {
        ImageView imageView = this.mIvWebNetTip;
        if (imageView == null) {
            h.q2.t.i0.k("mIvWebNetTip");
        }
        return imageView;
    }

    public final int getMMaxNum() {
        return this.mMaxNum;
    }

    @i.c.a.e
    public final ReportCaseInfoPresenter getMPresenter() {
        return this.mPresenter;
    }

    @i.c.a.d
    public final RecyclerView getMRvList() {
        RecyclerView recyclerView = this.mRvList;
        if (recyclerView == null) {
            h.q2.t.i0.k("mRvList");
        }
        return recyclerView;
    }

    @i.c.a.d
    public final TextView getMTvAdd() {
        TextView textView = this.mTvAdd;
        if (textView == null) {
            h.q2.t.i0.k("mTvAdd");
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
    public final ReportIDInfoBean getReportIDBean() {
        return this.reportIDBean;
    }

    @Override // ui.activity.BaseActivity
    public void initPage() {
        org.greenrobot.eventbus.c.f().e(this);
        SwipBackLayout.a(this.mActivity).a();
        TextView textView = this.mTvTitle;
        if (textView == null) {
            h.q2.t.i0.k("mTvTitle");
        }
        if (textView == null) {
            h.q2.t.i0.f();
        }
        textView.setText("填写报案信息");
        TextView textView2 = this.mTvAdd;
        if (textView2 == null) {
            h.q2.t.i0.k("mTvAdd");
        }
        if (textView2 == null) {
            h.q2.t.i0.f();
        }
        textView2.setText("添加事主信息");
        initView();
    }

    public final void initView() {
        String stringExtra = getIntent().getStringExtra(util.k1.C0);
        if (stringExtra == null) {
            stringExtra = "";
        }
        this.caseInfoId = stringExtra;
        this.reportIDBean = (ReportIDInfoBean) getIntent().getSerializableExtra(util.k1.f20844b);
        this.mPresenter = new ReportCaseInfoPresenter(this.mActivity, this.caseInfoId, this);
        ReportCaseInfoPresenter reportCaseInfoPresenter = this.mPresenter;
        if (reportCaseInfoPresenter != null) {
            RecyclerView recyclerView = this.mRvList;
            if (recyclerView == null) {
                h.q2.t.i0.k("mRvList");
            }
            reportCaseInfoPresenter.initRecyclePeop(recyclerView);
        }
    }

    @OnClick({R.id.iv_back, R.id.ll_add, R.id.rl_involved_acc, R.id.rl_crime_phone, R.id.rl_sms_item, R.id.rl_webnet_item, R.id.btn_commit})
    public final void onClick(@i.c.a.d View view) {
        h.q2.t.i0.f(view, "view");
        if (isDouble()) {
        }
        switch (view.getId()) {
            case R.id.btn_commit /* 2131296395 */:
                SignComitBean signComitBean = this.comitNumBean;
                if (signComitBean != null) {
                    if (signComitBean != null && signComitBean.getVictimCount() == 0) {
                        util.w1.a("请填写事主信息");
                        break;
                    } else {
                        SignComitBean signComitBean2 = this.comitNumBean;
                        if (signComitBean2 != null && signComitBean2.getPaymentCount() == 0) {
                            util.w1.a("请填写涉案账户信息");
                            break;
                        } else {
                            ImageView imageView = this.mIvCallTip;
                            if (imageView == null) {
                                h.q2.t.i0.k("mIvCallTip");
                            }
                            if (!imageView.isShown()) {
                                ImageView imageView2 = this.mIvSmsTip;
                                if (imageView2 == null) {
                                    h.q2.t.i0.k("mIvSmsTip");
                                }
                                if (!imageView2.isShown()) {
                                    ImageView imageView3 = this.mIvWebNetTip;
                                    if (imageView3 == null) {
                                        h.q2.t.i0.k("mIvWebNetTip");
                                    }
                                    if (!imageView3.isShown()) {
                                        util.w1.a("请完善报案信息");
                                        break;
                                    }
                                }
                            }
                            Intent intent = new Intent(this.mActivity, (Class<?>) ReportSignCommitActivity.class);
                            intent.putExtra(util.k1.C0, this.caseInfoId);
                            intent.putExtra(util.k1.f20845c, this.comitNumBean);
                            intent.putExtra(util.k1.f20844b, this.reportIDBean);
                            startActivity(intent);
                            break;
                        }
                    }
                }
                break;
            case R.id.iv_back /* 2131296762 */:
                onkeyback();
                break;
            case R.id.ll_add /* 2131296914 */:
                RecyclerView recyclerView = this.mRvList;
                if (recyclerView == null) {
                    h.q2.t.i0.k("mRvList");
                }
                if (recyclerView.getAdapter() != null) {
                    RecyclerView recyclerView2 = this.mRvList;
                    if (recyclerView2 == null) {
                        h.q2.t.i0.k("mRvList");
                    }
                    RecyclerView.Adapter adapter2 = recyclerView2.getAdapter();
                    if (adapter2 == null) {
                        h.q2.t.i0.f();
                    }
                    h.q2.t.i0.a((Object) adapter2, "mRvList.adapter!!");
                    if (adapter2.getItemCount() >= this.mMaxNum) {
                        util.w1.a("最多添加" + String.valueOf(this.mMaxNum) + "组事主信息");
                        break;
                    }
                }
                Intent intent2 = new Intent(this.mActivity, (Class<?>) VictimActivity.class);
                intent2.putExtra(util.k1.C0, this.caseInfoId);
                startActivity(intent2);
                break;
            case R.id.rl_crime_phone /* 2131297191 */:
                Intent intent3 = new Intent(this.mActivity, (Class<?>) AddCrimePhoneActivity.class);
                intent3.putExtra(util.k1.C0, this.caseInfoId);
                startActivity(intent3);
                break;
            case R.id.rl_involved_acc /* 2131297193 */:
                Intent intent4 = new Intent(this.mActivity, (Class<?>) AccountListActivity.class);
                intent4.putExtra(util.k1.C0, this.caseInfoId);
                startActivity(intent4);
                break;
            case R.id.rl_sms_item /* 2131297200 */:
                Intent intent5 = new Intent(this.mActivity, (Class<?>) CriminalSmsActivity.class);
                intent5.putExtra(util.k1.C0, this.caseInfoId);
                startActivity(intent5);
                break;
            case R.id.rl_webnet_item /* 2131297209 */:
                Intent intent6 = new Intent(this.mActivity, (Class<?>) CriminalWebInfoActivity.class);
                intent6.putExtra(util.k1.C0, this.caseInfoId);
                startActivity(intent6);
                break;
        }
    }

    @Override // ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        org.greenrobot.eventbus.c.f().g(this);
    }

    @org.greenrobot.eventbus.m(threadMode = ThreadMode.MAIN)
    public final void onEventMainThread(@i.c.a.d util.c2.a aVar) {
        h.q2.t.i0.f(aVar, "refreshUIEvent");
        if (aVar.a() != 34) {
            return;
        }
        finish();
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

    @Override // ui.activity.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        ReportCaseInfoPresenter reportCaseInfoPresenter = this.mPresenter;
        if (reportCaseInfoPresenter != null) {
            reportCaseInfoPresenter.getVictimList(this.caseInfoId);
        }
        ReportCaseInfoPresenter reportCaseInfoPresenter2 = this.mPresenter;
        if (reportCaseInfoPresenter2 != null) {
            reportCaseInfoPresenter2.getSubmitCaseInfo(this.caseInfoId);
        }
    }

    @Override // ui.callview.VictimPeopleView
    public void onSuccessCaseNum(@i.c.a.e SignComitBean signComitBean) {
        this.comitNumBean = signComitBean;
        Integer numValueOf = signComitBean != null ? Integer.valueOf(signComitBean.getPaymentCount()) : null;
        if (numValueOf == null) {
            h.q2.t.i0.f();
        }
        if (numValueOf.intValue() > 0) {
            ImageView imageView = this.mInvolveAccTip;
            if (imageView == null) {
                h.q2.t.i0.k("mInvolveAccTip");
            }
            imageView.setImageResource(R.drawable.iv_case_green);
        } else {
            ImageView imageView2 = this.mInvolveAccTip;
            if (imageView2 == null) {
                h.q2.t.i0.k("mInvolveAccTip");
            }
            imageView2.setImageResource(R.drawable.iv_case_red);
        }
        if ((signComitBean != null ? Integer.valueOf(signComitBean.getCallTelCount()) : null).intValue() + (signComitBean != null ? Integer.valueOf(signComitBean.getChargeTelCount()) : null).intValue() + (signComitBean != null ? Integer.valueOf(signComitBean.getLinkTelCount()) : null).intValue() + (signComitBean != null ? Integer.valueOf(signComitBean.getMailingTelCount()) : null).intValue() > 0) {
            ImageView imageView3 = this.mIvCallTip;
            if (imageView3 == null) {
                h.q2.t.i0.k("mIvCallTip");
            }
            imageView3.setVisibility(0);
        } else {
            ImageView imageView4 = this.mIvCallTip;
            if (imageView4 == null) {
                h.q2.t.i0.k("mIvCallTip");
            }
            imageView4.setVisibility(8);
        }
        if ((signComitBean != null ? Integer.valueOf(signComitBean.getSmsCount()) : null).intValue() > 0) {
            ImageView imageView5 = this.mIvSmsTip;
            if (imageView5 == null) {
                h.q2.t.i0.k("mIvSmsTip");
            }
            imageView5.setVisibility(0);
        } else {
            ImageView imageView6 = this.mIvSmsTip;
            if (imageView6 == null) {
                h.q2.t.i0.k("mIvSmsTip");
            }
            imageView6.setVisibility(8);
        }
        if ((signComitBean != null ? Integer.valueOf(signComitBean.getNetAccountCount()) : null).intValue() + (signComitBean != null ? Integer.valueOf(signComitBean.getAppCount()) : null).intValue() + (signComitBean != null ? Integer.valueOf(signComitBean.getUrlCount()) : null).intValue() > 0) {
            ImageView imageView7 = this.mIvWebNetTip;
            if (imageView7 == null) {
                h.q2.t.i0.k("mIvWebNetTip");
            }
            imageView7.setVisibility(0);
            return;
        }
        ImageView imageView8 = this.mIvWebNetTip;
        if (imageView8 == null) {
            h.q2.t.i0.k("mIvWebNetTip");
        }
        imageView8.setVisibility(8);
    }

    @Override // ui.callview.VictimPeopleView
    public void onSuccessDelet() {
        onResume();
    }

    @Override // ui.callview.VictimPeopleView
    public void onSuccessHandle(@i.c.a.d List<? extends SurveyPeopleBean> list) {
        h.q2.t.i0.f(list, "list");
        ReportCaseInfoPresenter reportCaseInfoPresenter = this.mPresenter;
        if (reportCaseInfoPresenter != null) {
            reportCaseInfoPresenter.setListData(list);
        }
    }

    public final void onkeyback() {
        util.b1.a(this.mActivity, "放弃本次案件信息编辑？", "", "确定", "取消", -1, -1, true, (IClickListener) new a());
    }

    public final void setCaseInfoId(@i.c.a.d String str) {
        h.q2.t.i0.f(str, "<set-?>");
        this.caseInfoId = str;
    }

    public final void setComitNumBean(@i.c.a.e SignComitBean signComitBean) {
        this.comitNumBean = signComitBean;
    }

    @Override // ui.activity.BaseActivity
    public int setLayoutView() {
        return R.layout.activity_report_info;
    }

    public final void setMFlBottomView(@i.c.a.d View view) {
        h.q2.t.i0.f(view, "<set-?>");
        this.mFlBottomView = view;
    }

    public final void setMInvolveAccTip(@i.c.a.d ImageView imageView) {
        h.q2.t.i0.f(imageView, "<set-?>");
        this.mInvolveAccTip = imageView;
    }

    public final void setMIvBack(@i.c.a.d ImageView imageView) {
        h.q2.t.i0.f(imageView, "<set-?>");
        this.mIvBack = imageView;
    }

    public final void setMIvCallTip(@i.c.a.d ImageView imageView) {
        h.q2.t.i0.f(imageView, "<set-?>");
        this.mIvCallTip = imageView;
    }

    public final void setMIvSmsTip(@i.c.a.d ImageView imageView) {
        h.q2.t.i0.f(imageView, "<set-?>");
        this.mIvSmsTip = imageView;
    }

    public final void setMIvWebNetTip(@i.c.a.d ImageView imageView) {
        h.q2.t.i0.f(imageView, "<set-?>");
        this.mIvWebNetTip = imageView;
    }

    public final void setMMaxNum(int i2) {
        this.mMaxNum = i2;
    }

    public final void setMPresenter(@i.c.a.e ReportCaseInfoPresenter reportCaseInfoPresenter) {
        this.mPresenter = reportCaseInfoPresenter;
    }

    public final void setMRvList(@i.c.a.d RecyclerView recyclerView) {
        h.q2.t.i0.f(recyclerView, "<set-?>");
        this.mRvList = recyclerView;
    }

    public final void setMTvAdd(@i.c.a.d TextView textView) {
        h.q2.t.i0.f(textView, "<set-?>");
        this.mTvAdd = textView;
    }

    public final void setMTvTitle(@i.c.a.d TextView textView) {
        h.q2.t.i0.f(textView, "<set-?>");
        this.mTvTitle = textView;
    }

    public final void setReportIDBean(@i.c.a.e ReportIDInfoBean reportIDInfoBean) {
        this.reportIDBean = reportIDInfoBean;
    }
}
