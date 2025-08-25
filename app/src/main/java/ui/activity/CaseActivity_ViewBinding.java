package ui.activity;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

/* loaded from: classes2.dex */
public class CaseActivity_ViewBinding implements Unbinder {

    /* renamed from: a, reason: collision with root package name */
    private CaseActivity f17829a;

    /* renamed from: b, reason: collision with root package name */
    private View f17830b;

    /* renamed from: c, reason: collision with root package name */
    private View f17831c;

    /* renamed from: d, reason: collision with root package name */
    private View f17832d;

    /* renamed from: e, reason: collision with root package name */
    private View f17833e;

    /* renamed from: f, reason: collision with root package name */
    private View f17834f;

    /* renamed from: g, reason: collision with root package name */
    private View f17835g;

    /* renamed from: h, reason: collision with root package name */
    private View f17836h;

    /* renamed from: i, reason: collision with root package name */
    private View f17837i;

    class a extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CaseActivity f17838a;

        a(CaseActivity caseActivity) {
            this.f17838a = caseActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f17838a.onViewClicked(view);
        }
    }

    class b extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CaseActivity f17840a;

        b(CaseActivity caseActivity) {
            this.f17840a = caseActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f17840a.onViewClicked(view);
        }
    }

    class c extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CaseActivity f17842a;

        c(CaseActivity caseActivity) {
            this.f17842a = caseActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f17842a.onViewClicked(view);
        }
    }

    class d extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CaseActivity f17844a;

        d(CaseActivity caseActivity) {
            this.f17844a = caseActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f17844a.onViewClicked(view);
        }
    }

    class e extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CaseActivity f17846a;

        e(CaseActivity caseActivity) {
            this.f17846a = caseActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f17846a.onViewClicked(view);
        }
    }

    class f extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CaseActivity f17848a;

        f(CaseActivity caseActivity) {
            this.f17848a = caseActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f17848a.onViewClicked(view);
        }
    }

    class g extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CaseActivity f17850a;

        g(CaseActivity caseActivity) {
            this.f17850a = caseActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f17850a.onViewClicked(view);
        }
    }

    class h extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CaseActivity f17852a;

        h(CaseActivity caseActivity) {
            this.f17852a = caseActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f17852a.onViewClicked(view);
        }
    }

    @UiThread
    public CaseActivity_ViewBinding(CaseActivity caseActivity) {
        this(caseActivity, caseActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        CaseActivity caseActivity = this.f17829a;
        if (caseActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f17829a = null;
        caseActivity.mTvTabCreate = null;
        caseActivity.mTvTabHistory = null;
        caseActivity.mTvHistoryDot = null;
        caseActivity.mIvTabCreate = null;
        caseActivity.mIvTabHistory = null;
        caseActivity.mLlCaseQRcode = null;
        caseActivity.mTvCaseName = null;
        caseActivity.mTvNumber = null;
        caseActivity.mIvQrcode = null;
        caseActivity.mTvDate = null;
        caseActivity.mTvCaseCode = null;
        caseActivity.mLlCaseCreate = null;
        caseActivity.mEtName = null;
        caseActivity.mTvType = null;
        caseActivity.mEtCaseCode = null;
        caseActivity.mLlCaseHistory = null;
        caseActivity.mLlCase = null;
        caseActivity.mTvChildTabWait = null;
        caseActivity.mTvChildTabOver = null;
        caseActivity.mSmRefreshWait = null;
        caseActivity.mSmRefreshOver = null;
        caseActivity.mRecyclerviewWait = null;
        caseActivity.mRecyclerviewOver = null;
        caseActivity.mNoDataWait = null;
        caseActivity.mNoDataOver = null;
        this.f17830b.setOnClickListener(null);
        this.f17830b = null;
        this.f17831c.setOnClickListener(null);
        this.f17831c = null;
        this.f17832d.setOnClickListener(null);
        this.f17832d = null;
        this.f17833e.setOnClickListener(null);
        this.f17833e = null;
        this.f17834f.setOnClickListener(null);
        this.f17834f = null;
        this.f17835g.setOnClickListener(null);
        this.f17835g = null;
        this.f17836h.setOnClickListener(null);
        this.f17836h = null;
        this.f17837i.setOnClickListener(null);
        this.f17837i = null;
    }

    @UiThread
    public CaseActivity_ViewBinding(CaseActivity caseActivity, View view) {
        this.f17829a = caseActivity;
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.tv_tab_create, "field 'mTvTabCreate' and method 'onViewClicked'");
        caseActivity.mTvTabCreate = (TextView) Utils.castView(viewFindRequiredView, R.id.tv_tab_create, "field 'mTvTabCreate'", TextView.class);
        this.f17830b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(caseActivity));
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.tv_tab_history, "field 'mTvTabHistory' and method 'onViewClicked'");
        caseActivity.mTvTabHistory = (TextView) Utils.castView(viewFindRequiredView2, R.id.tv_tab_history, "field 'mTvTabHistory'", TextView.class);
        this.f17831c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(caseActivity));
        caseActivity.mTvHistoryDot = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_history_dot, "field 'mTvHistoryDot'", TextView.class);
        caseActivity.mIvTabCreate = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_tab_create, "field 'mIvTabCreate'", ImageView.class);
        caseActivity.mIvTabHistory = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_tab_history, "field 'mIvTabHistory'", ImageView.class);
        caseActivity.mLlCaseQRcode = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_case_qrcode, "field 'mLlCaseQRcode'", LinearLayout.class);
        caseActivity.mTvCaseName = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_case_name, "field 'mTvCaseName'", TextView.class);
        caseActivity.mTvNumber = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_number, "field 'mTvNumber'", TextView.class);
        caseActivity.mIvQrcode = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_qrcode, "field 'mIvQrcode'", ImageView.class);
        caseActivity.mTvDate = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_date, "field 'mTvDate'", TextView.class);
        caseActivity.mTvCaseCode = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_case_code, "field 'mTvCaseCode'", TextView.class);
        caseActivity.mLlCaseCreate = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_case_create, "field 'mLlCaseCreate'", LinearLayout.class);
        caseActivity.mEtName = (EditText) Utils.findRequiredViewAsType(view, R.id.et_name, "field 'mEtName'", EditText.class);
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.tv_type, "field 'mTvType' and method 'onViewClicked'");
        caseActivity.mTvType = (TextView) Utils.castView(viewFindRequiredView3, R.id.tv_type, "field 'mTvType'", TextView.class);
        this.f17832d = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(caseActivity));
        caseActivity.mEtCaseCode = (EditText) Utils.findRequiredViewAsType(view, R.id.et_case_code, "field 'mEtCaseCode'", EditText.class);
        caseActivity.mLlCaseHistory = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_case_history, "field 'mLlCaseHistory'", LinearLayout.class);
        caseActivity.mLlCase = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_case, "field 'mLlCase'", LinearLayout.class);
        View viewFindRequiredView4 = Utils.findRequiredView(view, R.id.tv_child_tab_wait, "field 'mTvChildTabWait' and method 'onViewClicked'");
        caseActivity.mTvChildTabWait = (TextView) Utils.castView(viewFindRequiredView4, R.id.tv_child_tab_wait, "field 'mTvChildTabWait'", TextView.class);
        this.f17833e = viewFindRequiredView4;
        viewFindRequiredView4.setOnClickListener(new d(caseActivity));
        View viewFindRequiredView5 = Utils.findRequiredView(view, R.id.tv_child_tab_over, "field 'mTvChildTabOver' and method 'onViewClicked'");
        caseActivity.mTvChildTabOver = (TextView) Utils.castView(viewFindRequiredView5, R.id.tv_child_tab_over, "field 'mTvChildTabOver'", TextView.class);
        this.f17834f = viewFindRequiredView5;
        viewFindRequiredView5.setOnClickListener(new e(caseActivity));
        caseActivity.mSmRefreshWait = (SmartRefreshLayout) Utils.findRequiredViewAsType(view, R.id.sm_refresh_wait, "field 'mSmRefreshWait'", SmartRefreshLayout.class);
        caseActivity.mSmRefreshOver = (SmartRefreshLayout) Utils.findRequiredViewAsType(view, R.id.sm_refresh_over, "field 'mSmRefreshOver'", SmartRefreshLayout.class);
        caseActivity.mRecyclerviewWait = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.recyclerview_wait, "field 'mRecyclerviewWait'", RecyclerView.class);
        caseActivity.mRecyclerviewOver = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.recyclerview_over, "field 'mRecyclerviewOver'", RecyclerView.class);
        caseActivity.mNoDataWait = Utils.findRequiredView(view, R.id.include_wait, "field 'mNoDataWait'");
        caseActivity.mNoDataOver = Utils.findRequiredView(view, R.id.include_over, "field 'mNoDataOver'");
        View viewFindRequiredView6 = Utils.findRequiredView(view, R.id.iv_back, "method 'onViewClicked'");
        this.f17835g = viewFindRequiredView6;
        viewFindRequiredView6.setOnClickListener(new f(caseActivity));
        View viewFindRequiredView7 = Utils.findRequiredView(view, R.id.confirm, "method 'onViewClicked'");
        this.f17836h = viewFindRequiredView7;
        viewFindRequiredView7.setOnClickListener(new g(caseActivity));
        View viewFindRequiredView8 = Utils.findRequiredView(view, R.id.tv_close, "method 'onViewClicked'");
        this.f17837i = viewFindRequiredView8;
        viewFindRequiredView8.setOnClickListener(new h(caseActivity));
    }
}
