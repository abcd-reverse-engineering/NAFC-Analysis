package ui.activity;

import adapter.SmsDeleteAdapter;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import bean.SmsBean;
import butterknife.BindView;
import butterknife.OnClick;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.hicorenational.antifraud.R;
import interfaces.PermissionsListener;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import manager.LoginManager;
import org.greenrobot.eventbus.ThreadMode;
import ui.Hicore;

/* loaded from: classes2.dex */
public class SmsActivity extends BaseActivity implements BaseQuickAdapter.i {

    /* renamed from: f, reason: collision with root package name */
    public static final int f18993f = 1000;

    /* renamed from: a, reason: collision with root package name */
    private SmsDeleteAdapter f18994a;

    /* renamed from: b, reason: collision with root package name */
    private List<SmsBean> f18995b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    private int f18996c = 20;

    /* renamed from: d, reason: collision with root package name */
    private String f18997d = "条短信";

    /* renamed from: e, reason: collision with root package name */
    private String f18998e = "最多选择或添加";

    @BindView(R.id.btn_commit)
    Button mBtnCommit;

    @BindView(R.id.recyclerview)
    RecyclerView mRecyclerview;

    @BindView(R.id.tv_commit_tip)
    TextView mTvCommitTip;

    @BindView(R.id.tv_input_tip)
    TextView mTvInputTip;

    @BindView(R.id.tv_select_tip)
    TextView mTvSelectTip;

    @BindView(R.id.tv_title)
    TextView mTvTitle;

    class a implements PermissionsListener {
        a() {
        }

        @Override // interfaces.PermissionsListener
        public void onDenied(List<String> list, boolean z) {
            util.permissionutil.c.a(SmsActivity.this.mActivity, list, z, false, this);
        }

        @Override // interfaces.PermissionsListener
        public void onGranted() {
            int size = SmsActivity.this.f18995b != null ? SmsActivity.this.f18995b.size() : 0;
            Intent intent = new Intent(SmsActivity.this, (Class<?>) SmsRecordSelectActivity.class);
            intent.putExtra(SmsRecordSelectActivity.f19028h, 1);
            intent.putExtra("extra_select_can", SmsActivity.this.f18996c - size);
            SmsActivity.this.startActivity(intent);
        }
    }

    private void checkPermission() {
        util.permissionutil.c.a(this.mActivity, new String[]{util.permissionutil.a.w, util.permissionutil.a.v}, new a());
    }

    @Override // ui.activity.BaseActivity
    public void initPage() {
        org.greenrobot.eventbus.c.f().e(this);
        this.mTvTitle.setText("添加诈骗短信");
        this.mTvSelectTip.setText("选择短信");
        this.mTvInputTip.setText("手动输入");
        this.mTvCommitTip.setText(getResources().getString(R.string.commit_tip_start_str) + this.f18996c + this.f18997d);
        this.mRecyclerview.setLayoutManager(new LinearLayoutManager(this, 1, false));
        this.f18994a = new SmsDeleteAdapter(R.layout.recyclerview_sms_record_select, this.f18995b);
        this.f18994a.a(this.mRecyclerview);
        this.mRecyclerview.setAdapter(this.f18994a);
        this.f18994a.setOnItemChildClickListener(this);
        redisplayData();
    }

    @Override // ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        org.greenrobot.eventbus.c.f().g(this);
    }

    @org.greenrobot.eventbus.m(threadMode = ThreadMode.MAIN)
    public void onEvent(util.c2.a aVar) {
        if (aVar != null) {
            int iA = aVar.a();
            if (iA != 302) {
                if (iA != 303) {
                    return;
                }
                org.greenrobot.eventbus.c.f().f(aVar);
                this.f18995b = (List) aVar.b();
                this.f18994a.setNewData(this.f18995b);
                return;
            }
            org.greenrobot.eventbus.c.f().f(aVar);
            List<SmsBean> list = (List) aVar.b();
            if (list == null || list.size() <= 0) {
                return;
            }
            a(this.f18995b, list);
            this.f18994a.setNewData(this.f18995b);
        }
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter.i
    public void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
        if (Hicore.getApp().isDouble()) {
            return;
        }
        int id = view.getId();
        if (id == R.id.iv_clear) {
            this.f18995b.remove(i2);
            baseQuickAdapter.notifyDataSetChanged();
        } else {
            if (id != R.id.iv_edit) {
                return;
            }
            Intent intent = new Intent(this, (Class<?>) SmsAddActivity.class);
            intent.putExtra(util.k1.f20845c, (Serializable) this.f18995b);
            intent.putExtra(util.k1.f20847e, i2);
            startActivity(intent);
        }
    }

    @OnClick({R.id.iv_back, R.id.ll_select, R.id.ll_input, R.id.btn_commit})
    public void onViewClicked(View view) {
        if (isDouble()) {
        }
        switch (view.getId()) {
            case R.id.btn_commit /* 2131296395 */:
                if (!LoginManager.getInstance().isLogOut()) {
                    sendData();
                    finish();
                    break;
                }
                break;
            case R.id.iv_back /* 2131296762 */:
                sendData();
                onBackPressed();
                break;
            case R.id.ll_input /* 2131296950 */:
                if (!rejuctOperation()) {
                    Intent intent = new Intent(this, (Class<?>) SmsAddActivity.class);
                    intent.putExtra(util.k1.f20845c, (Serializable) this.f18995b);
                    startActivity(intent);
                    break;
                }
                break;
            case R.id.ll_select /* 2131296984 */:
                if (!rejuctOperation()) {
                    checkPermission();
                    break;
                }
                break;
        }
    }

    public void redisplayData() {
        List list;
        try {
            list = (List) getIntent().getSerializableExtra(util.k1.u);
        } catch (Exception e2) {
            e2.printStackTrace();
            list = null;
        }
        if (list == null || list.size() <= 0) {
            return;
        }
        this.f18995b.addAll(list);
        this.f18994a.notifyDataSetChanged();
    }

    public boolean rejuctOperation() {
        List<SmsBean> list = this.f18995b;
        if (list == null || list.size() != this.f18996c) {
            return false;
        }
        util.w1.a(this.f18998e + this.f18996c + this.f18997d);
        return true;
    }

    public void sendData() {
        org.greenrobot.eventbus.c.f().d(new util.c2.a(10, this.f18995b));
    }

    @Override // ui.activity.BaseActivity
    public int setLayoutView() {
        return R.layout.activity_call_new;
    }

    private void a(List<SmsBean> list, List<SmsBean> list2) {
        if (list == null) {
            list = new ArrayList<>();
        }
        for (SmsBean smsBean : list2) {
            if (list.size() > 0) {
                boolean z = false;
                int i2 = 0;
                while (true) {
                    if (i2 >= list.size()) {
                        break;
                    }
                    SmsBean smsBean2 = list.get(i2);
                    if (TextUtils.equals(smsBean.getSmsNum(), smsBean2.getSmsNum()) && TextUtils.equals(smsBean.getStringDate(), smsBean2.getStringDate())) {
                        if (!TextUtils.isEmpty(smsBean2.getVictimTel())) {
                            list.set(i2, smsBean);
                        }
                        z = true;
                    } else {
                        i2++;
                    }
                }
                if (!z) {
                    list.add(smsBean);
                }
            } else {
                list.add(smsBean);
            }
        }
    }
}
