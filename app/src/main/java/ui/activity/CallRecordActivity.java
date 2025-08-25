package ui.activity;

import adapter.CallSelectAdapter;
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
import event.CallEventBean;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import ui.Hicore;
import util.y1;

/* loaded from: classes2.dex */
public class CallRecordActivity extends BaseActivity implements CallSelectAdapter.b {

    /* renamed from: b, reason: collision with root package name */
    private CallSelectAdapter f17781b;

    @BindView(R.id.btn_report)
    Button mBtnReport;

    @BindView(R.id.iv_back)
    ImageView mIvBack;

    @BindView(R.id.recyclerview)
    RecyclerView mRecyclerview;

    @BindView(R.id.rl_title)
    RelativeLayout mRlTitle;

    @BindView(R.id.tv_title)
    TextView mTvTitle;

    /* renamed from: a, reason: collision with root package name */
    private List<CallBean> f17780a = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    private List<CallBean> f17782c = new ArrayList();

    /* renamed from: d, reason: collision with root package name */
    private boolean f17783d = true;

    /* renamed from: e, reason: collision with root package name */
    private List<CallBean> f17784e = new ArrayList();

    /* renamed from: f, reason: collision with root package name */
    private int f17785f = 100;

    class a implements Runnable {

        /* renamed from: ui.activity.CallRecordActivity$a$a, reason: collision with other inner class name */
        class RunnableC0281a implements Runnable {
            RunnableC0281a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                CallRecordActivity.this.f17781b.notifyDataSetChanged();
            }
        }

        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            CallRecordActivity.this.f17780a.addAll(CallRecordActivity.this.a());
            if (CallRecordActivity.this.f17783d && CallRecordActivity.this.f17780a != null) {
                Collections.reverse(CallRecordActivity.this.f17780a);
                CallRecordActivity.this.f17783d = false;
            }
            CallRecordActivity.this.runOnUiThread(new RunnableC0281a());
        }
    }

    private void initData() {
        try {
            this.f17785f = getIntent().getIntExtra("extra_select_can", 0);
        } catch (Exception e2) {
            e2.printStackTrace();
            this.f17785f = 0;
        }
        new Thread(new a()).start();
    }

    private void initView() {
        this.mTvTitle.setText("通话记录选择");
        this.mRecyclerview.setLayoutManager(new LinearLayoutManager(this, 1, false));
        this.f17781b = new CallSelectAdapter(R.layout.recyclerview_call_select, this.f17780a, this.f17784e);
        this.f17781b.a(this.mRecyclerview);
        this.mRecyclerview.setAdapter(this.f17781b);
        this.f17781b.setOnItemClickListener(this);
    }

    @Override // ui.activity.BaseActivity
    public void initPage() {
        initView();
        initData();
    }

    @OnClick({R.id.iv_back, R.id.btn_report})
    public void onViewClicked(View view) {
        if (Hicore.getApp().isDouble()) {
            return;
        }
        int id = view.getId();
        if (id != R.id.btn_report) {
            if (id != R.id.iv_back) {
                return;
            }
            finish();
            return;
        }
        List<CallBean> list = this.f17784e;
        if (list != null && list.size() > 0) {
            this.f17782c.addAll(this.f17784e);
        }
        if (this.f17782c.size() == 0) {
            util.w1.a("还没有选择电话");
        } else {
            org.greenrobot.eventbus.c.f().d(new CallEventBean(this.f17782c));
            finish();
        }
    }

    @Override // ui.activity.BaseActivity
    public int setLayoutView() {
        return R.layout.activity_call_record;
    }

    public List<CallBean> a() {
        try {
            ArrayList arrayList = new ArrayList();
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
                    arrayList.add(new CallBean(str, y1.b(Long.valueOf(j2)), str2, i2, false, j3));
                }
            }
            cursorQuery.close();
            return arrayList;
        } catch (Exception unused) {
            showDlogPrimssExcept();
            return null;
        }
    }

    @Override // adapter.CallSelectAdapter.b
    public void a(int i2, List<CallBean> list, CallBean callBean) {
        if (i2 < 0) {
            return;
        }
        CallBean callBean2 = list.get(i2);
        if (!callBean2.isSelect()) {
            if (this.f17782c.size() == this.f17785f) {
                util.w1.a("最多选择" + this.f17785f + "个");
                return;
            }
            callBean2.setSelect(true);
            if (!this.f17782c.contains(callBean2)) {
                this.f17782c.add(callBean2);
            }
        } else {
            callBean2.setSelect(false);
            this.f17782c.remove(callBean2);
            if (callBean != null && this.f17784e.contains(callBean)) {
                this.f17784e.remove(callBean);
            }
        }
        this.f17781b.notifyDataSetChanged();
    }
}
