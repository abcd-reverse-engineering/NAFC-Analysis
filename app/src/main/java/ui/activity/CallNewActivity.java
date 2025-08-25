package ui.activity;

import adapter.CallNewAdapter;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import bean.CallBean;
import butterknife.BindView;
import butterknife.OnClick;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.hicorenational.antifraud.R;
import interfaces.IClickListener;
import interfaces.PermissionsListener;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import manager.AccountManager;
import manager.LoginManager;
import org.greenrobot.eventbus.ThreadMode;
import ui.Hicore;

/* loaded from: classes2.dex */
public class CallNewActivity extends BaseActivity implements BaseQuickAdapter.i {

    /* renamed from: a, reason: collision with root package name */
    private CallNewAdapter f17760a;

    /* renamed from: b, reason: collision with root package name */
    private List<CallBean> f17761b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    private int f17762c = 20;

    /* renamed from: d, reason: collision with root package name */
    private String f17763d = "条举报电话";

    /* renamed from: e, reason: collision with root package name */
    private String f17764e = "最多选择或添加";

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

    class a implements IClickListener {
        a() {
        }

        @Override // interfaces.IClickListener
        public void cancelBtn() {
        }

        @Override // interfaces.IClickListener
        public void clickOKBtn() {
            CallNewActivity.this.a();
            CallNewActivity.this.sendData();
            CallNewActivity.this.finish();
        }
    }

    class b implements PermissionsListener {
        b() {
        }

        @Override // interfaces.PermissionsListener
        public void onDenied(List<String> list, boolean z) {
            util.permissionutil.c.a(CallNewActivity.this.mActivity, list, z, false, this);
        }

        @Override // interfaces.PermissionsListener
        public void onGranted() {
            int size = CallNewActivity.this.f17761b != null ? CallNewActivity.this.f17761b.size() : 0;
            Intent intent = new Intent(CallNewActivity.this, (Class<?>) CallRecordNewActivity.class);
            intent.putExtra("extra_select_can", CallNewActivity.this.f17762c - size);
            CallNewActivity.this.startActivity(intent);
        }
    }

    private void checkPermission() {
        util.permissionutil.c.a(this.mActivity, new String[]{util.permissionutil.a.f20918l}, new b());
    }

    private boolean hasYourselfPhone() {
        String visiblePhone = AccountManager.getVisiblePhone();
        Iterator<CallBean> it = this.f17761b.iterator();
        while (it.hasNext()) {
            if (TextUtils.equals(visiblePhone, it.next().getNumber())) {
                return true;
            }
        }
        return false;
    }

    @Override // ui.activity.BaseActivity
    public void initPage() {
        org.greenrobot.eventbus.c.f().e(this);
        this.mTvTitle.setText("添加诈骗电话");
        this.mTvSelectTip.setText("选择通话记录");
        this.mTvInputTip.setText("手动输入");
        this.mTvCommitTip.setText(getResources().getString(R.string.commit_tip_start_str) + this.f17762c + this.f17763d);
        this.mRecyclerview.setLayoutManager(new LinearLayoutManager(this, 1, false));
        this.f17760a = new CallNewAdapter(R.layout.recyclerview_call_new, this.f17761b);
        this.f17760a.a(this.mRecyclerview);
        this.mRecyclerview.setAdapter(this.f17760a);
        this.f17760a.setOnItemChildClickListener(this);
        redisplayData();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (hasYourselfPhone()) {
            util.b1.a(this.mActivity, "添加的诈骗电话中包含您的登录号码，确定添加个人手机号为诈骗电话？", "", "取消", "确定", -1, -1, true, (IClickListener) new a());
        } else {
            sendData();
            super.onBackPressed();
        }
    }

    @Override // ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        org.greenrobot.eventbus.c.f().g(this);
    }

    @org.greenrobot.eventbus.m(sticky = true, threadMode = ThreadMode.MAIN)
    public void onEvent(util.c2.a aVar) {
        if (aVar != null) {
            int iA = aVar.a();
            if (iA == 300) {
                org.greenrobot.eventbus.c.f().f(aVar);
                a(this.f17761b, (List) aVar.b(), null);
                this.f17760a.setNewData(this.f17761b);
                return;
            }
            if (iA != 301) {
                return;
            }
            org.greenrobot.eventbus.c.f().f(aVar);
            this.f17761b = (List) aVar.b();
            this.f17760a.setNewData(this.f17761b);
        }
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter.i
    public void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
        if (Hicore.getApp().isDouble()) {
            return;
        }
        int id = view.getId();
        if (id == R.id.iv_clear) {
            this.f17761b.remove(i2);
            baseQuickAdapter.notifyDataSetChanged();
        } else {
            if (id != R.id.iv_edit) {
                return;
            }
            Intent intent = new Intent(this, (Class<?>) CallEditActivity.class);
            intent.putExtra(util.k1.f20845c, (Serializable) this.f17761b);
            intent.putExtra(util.k1.f20847e, i2);
            startActivity(intent);
        }
    }

    @Override // ui.activity.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    @OnClick({R.id.iv_back, R.id.ll_select, R.id.ll_input, R.id.btn_commit})
    public void onViewClicked(View view) {
        if (Hicore.getApp().isDouble()) {
        }
        switch (view.getId()) {
            case R.id.btn_commit /* 2131296395 */:
                if (!LoginManager.getInstance().isLogOut()) {
                    onBackPressed();
                    break;
                }
                break;
            case R.id.iv_back /* 2131296762 */:
                onBackPressed();
                break;
            case R.id.ll_input /* 2131296950 */:
                if (!rejuctOperation()) {
                    Intent intent = new Intent(this, (Class<?>) CallEditActivity.class);
                    intent.putExtra(util.k1.f20845c, (Serializable) this.f17761b);
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
            list = (List) getIntent().getSerializableExtra(util.k1.s);
        } catch (Exception e2) {
            e2.printStackTrace();
            list = null;
        }
        ArrayList arrayList = new ArrayList();
        if (list != null && list.size() > 0) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add((CallBean) it.next());
            }
        }
        if (arrayList.size() > 0) {
            this.f17761b.addAll(arrayList);
            this.f17760a.notifyDataSetChanged();
        }
    }

    public boolean rejuctOperation() {
        List<CallBean> list = this.f17761b;
        if (list == null || list.size() != this.f17762c) {
            return false;
        }
        util.w1.a(this.f17764e + this.f17762c + this.f17763d);
        return true;
    }

    public void sendData() {
        org.greenrobot.eventbus.c.f().d(new util.c2.a(9, this.f17761b));
    }

    @Override // ui.activity.BaseActivity
    public int setLayoutView() {
        return R.layout.activity_call_new;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        List<CallBean> list = this.f17761b;
        String visiblePhone = AccountManager.getVisiblePhone();
        for (int i2 = 0; i2 < list.size(); i2++) {
            if (TextUtils.equals(visiblePhone, list.get(i2).getNumber())) {
                this.f17761b.remove(i2);
            }
        }
    }

    private void a(List<CallBean> list, List<CallBean> list2, CallBean callBean) {
        if (list == null) {
            list = new ArrayList<>();
        }
        if (list2 == null || (list2.size() <= 0 && callBean != null)) {
            list2 = new ArrayList<>();
            list2.add(callBean);
        }
        for (CallBean callBean2 : list2) {
            if (list.size() > 0) {
                boolean z = false;
                int i2 = 0;
                while (true) {
                    if (i2 >= list.size()) {
                        break;
                    }
                    CallBean callBean3 = list.get(i2);
                    if (TextUtils.equals(callBean2.getNumber(), callBean3.getNumber()) && TextUtils.equals(callBean2.getCrime_time(), callBean3.getCrime_time())) {
                        if (!TextUtils.isEmpty(callBean3.getVictimTel())) {
                            list.set(i2, callBean2);
                        }
                        z = true;
                    } else {
                        i2++;
                    }
                }
                if (!z) {
                    list.add(callBean2);
                }
            } else {
                list.add(callBean2);
            }
        }
    }
}
