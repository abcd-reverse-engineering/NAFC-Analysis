package ui.activity;

import adapter.CallSelectNewAdapter;
import android.content.Intent;
import android.database.Cursor;
import android.provider.CallLog;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import bean.CallBean;
import butterknife.BindView;
import butterknife.OnClick;
import com.hicorenational.antifraud.R;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import ui.Hicore;
import util.y1;

/* loaded from: classes2.dex */
public class CallRecordNewActivity extends BaseActivity implements CallSelectNewAdapter.b {

    /* renamed from: k, reason: collision with root package name */
    public static final String f17795k = "extra_select_limite";

    /* renamed from: l, reason: collision with root package name */
    public static final int f17796l = 1;

    /* renamed from: m, reason: collision with root package name */
    public static final String f17797m = "extra_select_can";

    /* renamed from: c, reason: collision with root package name */
    private CallSelectNewAdapter f17800c;

    /* renamed from: i, reason: collision with root package name */
    private boolean f17806i;

    /* renamed from: j, reason: collision with root package name */
    private String f17807j;

    @BindView(R.id.btn_report)
    Button mBtnReport;

    @BindView(R.id.iv_back)
    ImageView mIvBack;

    @BindView(R.id.recyclerview)
    RecyclerView mRecyclerview;

    @BindView(R.id.rl_title)
    RelativeLayout mRlTitle;

    @BindView(R.id.tv_child_tab_me)
    TextView mTvChildTabMe;

    @BindView(R.id.tv_child_tab_other)
    TextView mTvChildTabOther;

    @BindView(R.id.tv_tip)
    TextView mTvTip;

    @BindView(R.id.tv_title)
    TextView mTvTitle;

    @BindView(R.id.v_me)
    View mVMe;

    @BindView(R.id.v_other)
    View mVOther;

    /* renamed from: a, reason: collision with root package name */
    private List<CallBean> f17798a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    private List<CallBean> f17799b = new ArrayList();

    /* renamed from: d, reason: collision with root package name */
    private List<CallBean> f17801d = new ArrayList();

    /* renamed from: e, reason: collision with root package name */
    private List<CallBean> f17802e = new ArrayList();

    /* renamed from: f, reason: collision with root package name */
    private boolean f17803f = true;

    /* renamed from: g, reason: collision with root package name */
    private List<CallBean> f17804g = new ArrayList();

    /* renamed from: h, reason: collision with root package name */
    private int f17805h = 100;

    class a implements Runnable {

        /* renamed from: ui.activity.CallRecordNewActivity$a$a, reason: collision with other inner class name */
        class RunnableC0282a implements Runnable {
            RunnableC0282a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                CallRecordNewActivity.this.f17800c.setNewData(CallRecordNewActivity.this.f17799b);
            }
        }

        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            CallRecordNewActivity.this.a();
            if (CallRecordNewActivity.this.f17803f) {
                if (CallRecordNewActivity.this.f17798a != null) {
                    Collections.reverse(CallRecordNewActivity.this.f17798a);
                }
                if (CallRecordNewActivity.this.f17799b != null) {
                    Collections.reverse(CallRecordNewActivity.this.f17799b);
                }
                CallRecordNewActivity.this.f17803f = false;
            }
            CallRecordNewActivity.this.runOnUiThread(new RunnableC0282a());
        }
    }

    private void changeTab(boolean z) {
        if (z) {
            if (this.mVMe.getVisibility() != 0) {
                a(this.mTvChildTabMe, this.mTvChildTabOther);
                this.mVMe.setVisibility(0);
                this.mVOther.setVisibility(4);
                this.f17800c.setNewData(this.f17799b);
                return;
            }
            return;
        }
        if (this.mVOther.getVisibility() != 0) {
            a(this.mTvChildTabOther, this.mTvChildTabMe);
            this.mVMe.setVisibility(4);
            this.mVOther.setVisibility(0);
            this.f17800c.setNewData(this.f17798a);
        }
    }

    private void initData() {
        try {
            this.f17805h = getIntent().getIntExtra("extra_select_can", 20);
            this.f17802e = (List) getIntent().getSerializableExtra(util.k1.f20845c);
        } catch (Exception unused) {
        }
        new Thread(new a()).start();
    }

    private void initView() {
        this.mTvTitle.setText("通话记录选择");
        this.mRecyclerview.setLayoutManager(new LinearLayoutManager(this, 1, false));
        this.f17800c = new CallSelectNewAdapter(R.layout.recyclerview_call_select_new, this.f17798a, this.f17804g);
        this.f17800c.a(this.mRecyclerview);
        this.mRecyclerview.setAdapter(this.f17800c);
        this.f17800c.setOnItemClickListener(this);
        changeTab(true);
    }

    @Override // ui.activity.BaseActivity
    public void initPage() {
        initView();
        initData();
        if (getIntent().getIntExtra("extra_select_limite", 0) == 1) {
            this.f17807j = getIntent().getStringExtra(util.k1.C0);
            this.f17806i = true;
            this.f17805h = 1;
            this.mBtnReport.setVisibility(8);
            this.mTvTip.setVisibility(8);
        }
    }

    @OnClick({R.id.iv_back, R.id.tv_child_tab_me, R.id.tv_child_tab_other, R.id.btn_report})
    public void onViewClicked(View view) {
        if (Hicore.getApp().isDouble()) {
        }
        switch (view.getId()) {
            case R.id.btn_report /* 2131296403 */:
                b();
                break;
            case R.id.iv_back /* 2131296762 */:
                finish();
                break;
            case R.id.tv_child_tab_me /* 2131297474 */:
                changeTab(true);
                break;
            case R.id.tv_child_tab_other /* 2131297475 */:
                changeTab(false);
                break;
        }
    }

    @Override // ui.activity.BaseActivity
    public int setLayoutView() {
        return R.layout.activity_call_record_new;
    }

    private void b() {
        List<CallBean> list = this.f17804g;
        if (list != null && list.size() > 0) {
            this.f17801d.addAll(this.f17804g);
        }
        if (this.f17801d.size() == 0) {
            util.w1.a("还没有选择电话");
        } else {
            org.greenrobot.eventbus.c.f().d(new util.c2.a(300, this.f17801d));
            finish();
        }
    }

    private void c() {
        this.f17802e.addAll(this.f17801d);
        Intent intent = new Intent(this.mActivity, (Class<?>) CriminalCallAddActivity.class);
        intent.putExtra(util.k1.C0, this.f17807j);
        intent.putExtra(util.k1.f20845c, (Serializable) this.f17802e);
        intent.putExtra(util.k1.f20847e, this.f17802e.size() - 1);
        startActivity(intent);
        finish();
    }

    public void a() {
        try {
            Cursor cursorQuery = getContentResolver().query(CallLog.Calls.CONTENT_URI, new String[]{"number", "date", "type", CommonNetImpl.NAME, "geocoded_location", "duration"}, null, null, null);
            while (cursorQuery.moveToNext()) {
                String string = cursorQuery.getString(0);
                long j2 = cursorQuery.getLong(1);
                int i2 = cursorQuery.getInt(2);
                cursorQuery.getString(3);
                String string2 = cursorQuery.getString(4);
                long j3 = cursorQuery.getLong(5);
                if (string.contains("<") && !TextUtils.isEmpty(string)) {
                    string = string.substring(string.indexOf("<") + 1, string.lastIndexOf(">"));
                }
                String str = string;
                String str2 = string2 == null ? "" : string2;
                if (!TextUtils.isEmpty(str)) {
                    CallBean callBean = new CallBean(str, y1.b(Long.valueOf(j2)), str2, i2, false, j3);
                    callBean.setTalkTime(a(j3));
                    if (i2 == 2) {
                        this.f17798a.add(callBean);
                    } else {
                        this.f17799b.add(callBean);
                    }
                }
            }
            cursorQuery.close();
        } catch (Exception unused) {
            showDlogPrimssExcept();
        }
    }

    public String a(long j2) {
        if (j2 < 60) {
            return j2 + "秒";
        }
        if (j2 > 60 && j2 < 3600) {
            return ((j2 % 3600) / 60) + "分钟";
        }
        return (j2 / 3600) + "小时" + ((j2 % 3600) / 60) + "分钟";
    }

    @Override // adapter.CallSelectNewAdapter.b
    public void a(int i2, List<CallBean> list, CallBean callBean) {
        if (i2 < 0) {
            return;
        }
        CallBean callBean2 = list.get(i2);
        if (!callBean2.isSelect()) {
            if (this.f17801d.size() == this.f17805h) {
                util.w1.a("最多选择" + this.f17805h + "个");
                return;
            }
            callBean2.setSelect(true);
            if (!this.f17801d.contains(callBean2)) {
                this.f17801d.add(callBean2);
            }
            if (this.f17806i) {
                String crime_time = callBean2.getCrime_time();
                if (crime_time.length() > 2) {
                    callBean2.setTalkTime(crime_time.substring(0, crime_time.length() - 3));
                }
                callBean2.setIsInput(1);
                callBean2.setSuspectMobile(callBean2.getNumber());
                callBean2.setCallDuration(callBean2.getDuration() + "秒");
                c();
            }
        } else {
            callBean2.setSelect(false);
            this.f17801d.remove(callBean2);
            if (callBean != null && this.f17804g.contains(callBean)) {
                this.f17804g.remove(callBean);
            }
        }
        this.f17800c.notifyDataSetChanged();
    }

    private void a(TextView textView, TextView textView2) {
        textView.setTextColor(getResources().getColor(R.color.black_dark));
        textView2.setTextColor(getResources().getColor(R.color.colorGray));
    }
}
