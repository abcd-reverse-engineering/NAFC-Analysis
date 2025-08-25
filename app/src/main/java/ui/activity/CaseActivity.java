package ui.activity;

import adapter.CaseAdapter;
import adapter.CaseOverAdapter;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import bean.CaseHistoryBean;
import bean.ReportZPEleBean;
import bean.module.RegionMudelBean;
import butterknife.BindView;
import butterknife.OnClick;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.hicorenational.antifraud.R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import interfaces.IClickListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import network.http.StatisticsHttp;
import org.greenrobot.eventbus.ThreadMode;
import ui.callview.CaseCallView;
import ui.presenter.CasePresenter;
import ui.view.swip.SwipBackLayout;

/* loaded from: classes2.dex */
public class CaseActivity extends BaseActivity implements CaseCallView, BaseQuickAdapter.k, BaseQuickAdapter.i {
    private ReportZPEleBean info;

    @BindView(R.id.et_case_code)
    EditText mEtCaseCode;

    @BindView(R.id.et_name)
    EditText mEtName;

    @BindView(R.id.iv_qrcode)
    ImageView mIvQrcode;

    @BindView(R.id.iv_tab_create)
    ImageView mIvTabCreate;

    @BindView(R.id.iv_tab_history)
    ImageView mIvTabHistory;

    @BindView(R.id.ll_case)
    LinearLayout mLlCase;

    @BindView(R.id.ll_case_create)
    LinearLayout mLlCaseCreate;

    @BindView(R.id.ll_case_history)
    LinearLayout mLlCaseHistory;

    @BindView(R.id.ll_case_qrcode)
    LinearLayout mLlCaseQRcode;

    @BindView(R.id.include_over)
    View mNoDataOver;

    @BindView(R.id.include_wait)
    View mNoDataWait;

    @BindView(R.id.recyclerview_over)
    RecyclerView mRecyclerviewOver;

    @BindView(R.id.recyclerview_wait)
    RecyclerView mRecyclerviewWait;

    @BindView(R.id.sm_refresh_over)
    SmartRefreshLayout mSmRefreshOver;

    @BindView(R.id.sm_refresh_wait)
    SmartRefreshLayout mSmRefreshWait;

    @BindView(R.id.tv_case_code)
    TextView mTvCaseCode;

    @BindView(R.id.tv_case_name)
    TextView mTvCaseName;

    @BindView(R.id.tv_child_tab_over)
    TextView mTvChildTabOver;

    @BindView(R.id.tv_child_tab_wait)
    TextView mTvChildTabWait;

    @BindView(R.id.tv_date)
    TextView mTvDate;

    @BindView(R.id.tv_history_dot)
    TextView mTvHistoryDot;

    @BindView(R.id.tv_number)
    TextView mTvNumber;

    @BindView(R.id.tv_tab_create)
    TextView mTvTabCreate;

    @BindView(R.id.tv_tab_history)
    TextView mTvTabHistory;

    @BindView(R.id.tv_type)
    TextView mTvType;
    private final int HISTORY_STATUS_OVER = 0;
    private final int HISTORY_STATUS_WAIT = 1;
    private long mTypeId = -1;
    private List<CaseHistoryBean.Rows> mWaitList = new ArrayList();
    private List<CaseHistoryBean.Rows> mOverList = new ArrayList();
    private CaseAdapter mWaitAdapter = null;
    private CaseOverAdapter mOverAdapter = null;
    private CasePresenter mPresenter = null;
    public boolean isLoadmoreWait = false;
    public boolean isLoadmoreOver = false;
    public int mPageIndexWait = 1;
    public int mPageIndexOver = 1;
    public int mPageSize = 6;
    private boolean isFirst = true;

    class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f17823a;

        /* renamed from: ui.activity.CaseActivity$a$a, reason: collision with other inner class name */
        class RunnableC0283a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ Bitmap f17825a;

            RunnableC0283a(Bitmap bitmap) {
                this.f17825a = bitmap;
            }

            @Override // java.lang.Runnable
            public void run() {
                CaseActivity.this.mIvQrcode.setImageBitmap(this.f17825a);
            }
        }

        a(String str) {
            this.f17823a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Bitmap bitmapDecodeResource = BitmapFactory.decodeResource(CaseActivity.this.getResources(), R.mipmap.ic_police_logo);
            int iA = util.c1.a(CaseActivity.this, 240.0f);
            Bitmap bitmapA = util.e1.a(this.f17823a, iA, iA, bitmapDecodeResource);
            ImageView imageView = CaseActivity.this.mIvQrcode;
            if (imageView != null) {
                imageView.post(new RunnableC0283a(bitmapA));
            }
        }
    }

    class b implements IClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f17827a;

        b(int i2) {
            this.f17827a = i2;
        }

        @Override // interfaces.IClickListener
        public void cancelBtn() {
            CaseActivity.this.mPresenter.deleteCase((CaseHistoryBean.Rows) CaseActivity.this.mWaitList.get(this.f17827a));
        }

        @Override // interfaces.IClickListener
        public void clickOKBtn() {
        }
    }

    private void changeChildTab(boolean z) {
        if (z) {
            if (this.mTvChildTabWait.isEnabled()) {
                this.mNoDataWait.setVisibility(8);
                changeTextBold(this.mTvChildTabWait, this.mTvChildTabOver);
                this.mTvChildTabWait.setBackgroundResource(R.drawable.shape_sed_tab_type);
                this.mTvChildTabOver.setBackgroundColor(getResources().getColor(R.color.white));
                this.mSmRefreshWait.setVisibility(0);
                this.mSmRefreshOver.setVisibility(8);
                this.mSmRefreshWait.e();
                return;
            }
            return;
        }
        if (this.mTvChildTabOver.isEnabled()) {
            this.mNoDataOver.setVisibility(8);
            changeTextBold(this.mTvChildTabOver, this.mTvChildTabWait);
            this.mTvChildTabWait.setBackgroundColor(getResources().getColor(R.color.white));
            this.mTvChildTabOver.setBackgroundResource(R.drawable.shape_sed_tab_type);
            this.mSmRefreshWait.setVisibility(8);
            this.mSmRefreshOver.setVisibility(0);
            this.mSmRefreshOver.e();
        }
    }

    private void changeTab(boolean z) {
        if (z) {
            if (this.mIvTabCreate.getVisibility() != 0) {
                changeTextBold(this.mTvTabCreate, this.mTvTabHistory);
                this.mIvTabCreate.setVisibility(0);
                this.mIvTabHistory.setVisibility(4);
                this.mLlCase.setVisibility(0);
                this.mLlCaseHistory.setVisibility(8);
                return;
            }
            return;
        }
        if (this.mIvTabHistory.getVisibility() != 0) {
            changeTextBold(this.mTvTabHistory, this.mTvTabCreate);
            this.mIvTabCreate.setVisibility(4);
            this.mIvTabHistory.setVisibility(0);
            this.mLlCase.setVisibility(8);
            this.mLlCaseHistory.setVisibility(0);
        }
    }

    private void changeTextBold(TextView textView, TextView textView2) {
        textView.setTypeface(Typeface.defaultFromStyle(1));
        textView2.setTypeface(Typeface.defaultFromStyle(0));
        textView.setTextColor(getResources().getColor(R.color._2B48E7));
        textView2.setTextColor(getResources().getColor(R.color.black_dark));
    }

    private void createQRcode(String str) {
        new Thread(new a(str)).start();
    }

    private void initListener() {
        this.mTvChildTabWait.setEnabled(false);
        this.mSmRefreshWait.a((com.scwang.smartrefresh.layout.b.g) new ClassicsHeader(this));
        this.mSmRefreshWait.s(false);
        this.mSmRefreshWait.a(new com.scwang.smartrefresh.layout.d.d() { // from class: ui.activity.l
            @Override // com.scwang.smartrefresh.layout.d.d
            public final void a(com.scwang.smartrefresh.layout.b.j jVar) {
                this.f19441a.a(jVar);
            }
        });
        this.mSmRefreshWait.a(new com.scwang.smartrefresh.layout.d.b() { // from class: ui.activity.j
            @Override // com.scwang.smartrefresh.layout.d.b
            public final void b(com.scwang.smartrefresh.layout.b.j jVar) {
                this.f19435a.b(jVar);
            }
        });
        this.mSmRefreshWait.e();
        this.mSmRefreshOver.a((com.scwang.smartrefresh.layout.b.g) new ClassicsHeader(this));
        this.mSmRefreshOver.s(false);
        this.mSmRefreshOver.a(new com.scwang.smartrefresh.layout.d.d() { // from class: ui.activity.k
            @Override // com.scwang.smartrefresh.layout.d.d
            public final void a(com.scwang.smartrefresh.layout.b.j jVar) {
                this.f19438a.c(jVar);
            }
        });
        this.mSmRefreshOver.a(new com.scwang.smartrefresh.layout.d.b() { // from class: ui.activity.i
            @Override // com.scwang.smartrefresh.layout.d.b
            public final void b(com.scwang.smartrefresh.layout.b.j jVar) {
                this.f19432a.d(jVar);
            }
        });
        this.mSmRefreshOver.e();
    }

    private CaseOverAdapter initRecyclerOver(RecyclerView recyclerView, List<CaseHistoryBean.Rows> list) {
        recyclerView.setLayoutManager(new LinearLayoutManager(this, 1, false));
        CaseOverAdapter caseOverAdapter = new CaseOverAdapter(list);
        caseOverAdapter.setOnItemChildClickListener(this);
        caseOverAdapter.setOnItemClickListener(this);
        recyclerView.setAdapter(caseOverAdapter);
        return caseOverAdapter;
    }

    private CaseAdapter initRecyclerWait(RecyclerView recyclerView, List<CaseHistoryBean.Rows> list) {
        recyclerView.setLayoutManager(new LinearLayoutManager(this, 1, false));
        CaseAdapter caseAdapter = new CaseAdapter(list);
        caseAdapter.setOnItemChildClickListener(this);
        caseAdapter.setOnItemClickListener(this);
        recyclerView.setAdapter(caseAdapter);
        return caseAdapter;
    }

    private void onItemDelet(int i2) {
        util.b1.b(this.mActivity, "删除当前案件信息？", "", "确定", "取消", new b(i2));
    }

    public /* synthetic */ void a(com.scwang.smartrefresh.layout.b.j jVar) {
        CasePresenter casePresenter;
        if (this.mSmRefreshWait == null || (casePresenter = this.mPresenter) == null) {
            return;
        }
        casePresenter.caseStatus();
        this.mPageIndexWait = 1;
        this.isLoadmoreWait = false;
        this.mPresenter.caseHistory(1, this.mPageIndexWait, this.mPageSize);
    }

    public /* synthetic */ void b(com.scwang.smartrefresh.layout.b.j jVar) {
        if (this.mSmRefreshWait == null || this.mPresenter == null) {
            return;
        }
        this.isLoadmoreWait = true;
        int size = this.mWaitList.size();
        int i2 = this.mPageSize;
        this.mPageIndexWait = (size / i2) + 1;
        this.mPresenter.caseHistory(1, this.mPageIndexWait, i2);
    }

    public /* synthetic */ void c(com.scwang.smartrefresh.layout.b.j jVar) {
        CasePresenter casePresenter;
        if (this.mSmRefreshOver == null || (casePresenter = this.mPresenter) == null) {
            return;
        }
        this.mPageIndexOver = 1;
        this.isLoadmoreOver = false;
        casePresenter.caseHistory(0, this.mPageIndexOver, this.mPageSize);
    }

    public /* synthetic */ void d(com.scwang.smartrefresh.layout.b.j jVar) {
        if (this.mSmRefreshOver == null || this.mPresenter == null) {
            return;
        }
        this.isLoadmoreOver = true;
        int size = this.mOverList.size();
        int i2 = this.mPageSize;
        this.mPageIndexOver = (size / i2) + 1;
        this.mPresenter.caseHistory(0, this.mPageIndexOver, i2);
    }

    @Override // ui.activity.BaseActivity
    public void initPage() {
        StatisticsHttp.getInstance().pageOpenHttp(e.d.f13593k);
        SwipBackLayout.a(this.mActivity).a();
        this.mPresenter = new CasePresenter(this, this);
        this.mWaitAdapter = initRecyclerWait(this.mRecyclerviewWait, this.mWaitList);
        this.mOverAdapter = initRecyclerOver(this.mRecyclerviewOver, this.mOverList);
        org.greenrobot.eventbus.c.f().e(this);
        initListener();
    }

    @Override // ui.callview.CaseCallView
    public void onCreateSuccessRequest(String str, String str2, String str3, String str4) {
        this.mLlCaseQRcode.setVisibility(0);
        this.mLlCaseCreate.setVisibility(8);
        if (TextUtils.isEmpty(str3)) {
            this.mTvCaseCode.setText(c.c.a.b.a.a.f3100g);
        } else {
            this.mTvCaseCode.setText("采集编号：" + str3);
        }
        if (TextUtils.isEmpty(str4)) {
            this.mTvNumber.setVisibility(8);
        } else {
            this.mTvNumber.setVisibility(0);
            this.mTvNumber.setText(str4);
        }
        this.mTvCaseName.setText(str2);
        this.mIvQrcode.setImageResource(R.mipmap.ic_placeholder);
        createQRcode(str);
        this.mTvDate.setText("报案日期：" + util.v1.a(System.currentTimeMillis()));
    }

    @Override // ui.callview.CaseCallView
    public void onDeleteSuccessRequest(CaseHistoryBean.Rows rows) {
        this.mWaitList.remove(rows);
        this.mWaitAdapter.notifyDataSetChanged();
        if (this.mWaitAdapter.c().size() <= 0) {
            this.mNoDataWait.setVisibility(0);
        }
    }

    @Override // ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        org.greenrobot.eventbus.c.f().g(this);
    }

    @org.greenrobot.eventbus.m(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(util.c2.a aVar) {
        if (aVar != null) {
            int iA = aVar.a();
            if (iA != 3) {
                if (iA == 204 || iA == 205) {
                    this.mSmRefreshWait.e();
                    return;
                }
                return;
            }
            this.info = (ReportZPEleBean) aVar.b();
            ReportZPEleBean reportZPEleBean = this.info;
            if (reportZPEleBean != null) {
                this.mTvType.setText(reportZPEleBean.getName());
                this.mTypeId = this.info.getId();
            }
        }
    }

    @Override // ui.callview.CaseCallView
    public void onHistorySuccessRequest(CaseHistoryBean caseHistoryBean, int i2) {
        if (i2 == 0) {
            if (caseHistoryBean != null) {
                onOverSuccessRequest(caseHistoryBean.getRows());
                return;
            } else {
                this.mSmRefreshOver.g();
                this.mSmRefreshOver.b();
                return;
            }
        }
        if (i2 != 1) {
            return;
        }
        if (caseHistoryBean != null) {
            onWaitSuccessRequest(caseHistoryBean.getRows());
        } else {
            this.mSmRefreshWait.g();
            this.mSmRefreshWait.b();
        }
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter.i
    public void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
        if (!isDouble() && view.getId() == R.id.iv_clear) {
            onItemDelet(i2);
        }
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter.k
    public void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
        if (isDouble()) {
            return;
        }
        CaseHistoryBean.Rows rows = (CaseHistoryBean.Rows) baseQuickAdapter.c().get(i2);
        if (rows.getIsExpired() == 1) {
            return;
        }
        int status = rows.getStatus();
        if (status == 1 || status == 2) {
            Intent intent = new Intent(this, (Class<?>) QRcodeActivity.class);
            intent.putExtra(util.k1.f20845c, rows);
            startActivity(intent);
            return;
        }
        if (status == 3) {
            rows.setStatus(5);
            this.mWaitAdapter.notifyItemChanged(i2);
        }
        Intent intent2 = new Intent(this, (Class<?>) CaseDetailActivity.class);
        intent2.putExtra(util.k1.C0, rows.getId());
        intent2.putExtra(util.k1.f20846d, rows.getStatus());
        startActivity(intent2);
    }

    public void onOverSuccessRequest(List<CaseHistoryBean.Rows> list) {
        this.mSmRefreshOver.g();
        this.mSmRefreshOver.b();
        if (list != null && list.size() > 0) {
            RegionMudelBean regionMudelBeanJ = d.a.j();
            if (regionMudelBeanJ == null || (regionMudelBeanJ != null && !TextUtils.equals(regionMudelBeanJ.getStopPayment(), "1"))) {
                Iterator<CaseHistoryBean.Rows> it = list.iterator();
                while (it.hasNext()) {
                    it.next().setStopPaymentCount(0);
                }
            }
            if (this.isLoadmoreOver) {
                this.mOverList.addAll(list);
            } else {
                this.mOverList.clear();
                this.mOverList.addAll(list);
                this.mSmRefreshOver.s(true);
            }
            this.mOverAdapter.notifyDataSetChanged();
            if (list.size() >= this.mPageSize && list.size() <= this.mPageSize) {
                this.mSmRefreshOver.s(true);
            } else {
                this.mSmRefreshOver.s(false);
            }
        } else if (this.isLoadmoreOver) {
            this.mSmRefreshOver.s(false);
        } else {
            this.mOverList.clear();
            this.mWaitAdapter.notifyDataSetChanged();
        }
        if (!this.mTvChildTabOver.isEnabled()) {
            if (this.mOverList.size() > 0) {
                this.mNoDataOver.setVisibility(8);
            } else {
                this.mNoDataOver.setVisibility(0);
            }
        }
        this.isLoadmoreOver = false;
    }

    @Override // ui.activity.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        if (this.isFirst) {
            return;
        }
        this.mPresenter.caseStatus();
        this.isFirst = false;
    }

    @Override // ui.callview.CaseCallView
    public void onStatusSuccessRequest(boolean z) {
        if (z) {
            this.mTvHistoryDot.setVisibility(0);
        } else {
            this.mTvHistoryDot.setVisibility(8);
        }
    }

    @OnClick({R.id.iv_back, R.id.tv_tab_create, R.id.tv_tab_history, R.id.tv_type, R.id.confirm, R.id.tv_close, R.id.tv_child_tab_wait, R.id.tv_child_tab_over})
    public void onViewClicked(View view) {
        if (isDouble()) {
        }
        switch (view.getId()) {
            case R.id.confirm /* 2131296476 */:
                String string = this.mEtName.getText().toString();
                if (!TextUtils.isEmpty(string)) {
                    String string2 = this.mTvType.getText().toString();
                    if (this.mTypeId != -1 && !TextUtils.isEmpty(string2)) {
                        this.mPresenter.createCase(string, this.mEtCaseCode.getText().toString(), this.mTypeId, string2);
                        hideSoftInput();
                        break;
                    } else {
                        util.w1.a("请选择诈骗类型");
                        break;
                    }
                } else {
                    util.w1.a("请输入案件名称");
                    break;
                }
                break;
            case R.id.iv_back /* 2131296762 */:
                finish();
                break;
            case R.id.tv_child_tab_over /* 2131297476 */:
                changeChildTab(false);
                this.mTvChildTabWait.setEnabled(true);
                this.mTvChildTabOver.setEnabled(false);
                break;
            case R.id.tv_child_tab_wait /* 2131297477 */:
                changeChildTab(true);
                this.mTvChildTabWait.setEnabled(false);
                this.mTvChildTabOver.setEnabled(true);
                break;
            case R.id.tv_close /* 2131297479 */:
                this.mLlCaseQRcode.setVisibility(8);
                this.mLlCaseCreate.setVisibility(0);
                this.mEtName.setText("");
                this.mEtCaseCode.setText("");
                this.mTvType.setText("");
                this.info = null;
                this.mTypeId = -1L;
                break;
            case R.id.tv_tab_create /* 2131297746 */:
                changeTab(true);
                break;
            case R.id.tv_tab_history /* 2131297747 */:
                changeTab(false);
                break;
            case R.id.tv_type /* 2131297780 */:
                Intent intent = new Intent(this.mActivity, (Class<?>) TagFlowLaoutActivity.class);
                intent.putExtra(util.k1.f20846d, 2);
                ReportZPEleBean reportZPEleBean = this.info;
                if (reportZPEleBean != null) {
                    intent.putExtra(util.k1.O, reportZPEleBean);
                }
                startActivity(intent);
                break;
        }
    }

    public void onWaitSuccessRequest(List<CaseHistoryBean.Rows> list) {
        this.mSmRefreshWait.g();
        this.mSmRefreshWait.b();
        if (list != null && list.size() > 0) {
            if (this.isLoadmoreWait) {
                this.mWaitList.addAll(list);
            } else {
                this.mWaitList.clear();
                this.mWaitList.addAll(list);
                this.mSmRefreshWait.s(true);
            }
            this.mWaitAdapter.notifyDataSetChanged();
            if (list.size() >= this.mPageSize && list.size() <= this.mPageSize) {
                this.mSmRefreshWait.s(true);
            } else {
                this.mSmRefreshWait.s(false);
            }
        } else if (this.isLoadmoreWait) {
            this.mSmRefreshWait.s(false);
        } else {
            this.mWaitList.clear();
            this.mWaitAdapter.notifyDataSetChanged();
        }
        if (!this.mTvChildTabWait.isEnabled()) {
            if (this.mWaitList.size() > 0) {
                this.mNoDataWait.setVisibility(8);
            } else {
                this.mNoDataWait.setVisibility(0);
            }
        }
        this.isLoadmoreWait = false;
    }

    @Override // ui.activity.BaseActivity
    public int setLayoutView() {
        return R.layout.activity_case;
    }
}
