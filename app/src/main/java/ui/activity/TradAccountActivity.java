package ui.activity;

import adapter.SocialAccAdapter;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import bean.SocialAccBean;
import butterknife.BindView;
import butterknife.OnClick;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.hicorenational.antifraud.R;
import java.util.ArrayList;
import java.util.List;
import network.http.ReportNumHttp;
import org.greenrobot.eventbus.ThreadMode;
import util.y1;

/* loaded from: classes2.dex */
public class TradAccountActivity extends BaseActivity implements BaseQuickAdapter.i {

    /* renamed from: c, reason: collision with root package name */
    public static boolean f19107c = false;

    /* renamed from: a, reason: collision with root package name */
    private SocialAccAdapter f19108a;

    /* renamed from: b, reason: collision with root package name */
    private List<SocialAccBean> f19109b = new ArrayList();

    @BindView(R.id.btn_commit)
    Button mBtnCommit;

    @BindView(R.id.recyclerview)
    RecyclerView mRecyclerview;

    @BindView(R.id.tv_commit_tip)
    TextView mTvCommit;

    @BindView(R.id.tv_select_tip)
    TextView mTvSelectTip;

    @BindView(R.id.tv_title)
    TextView mTvTitle;

    class a implements ReportNumHttp.Callback {
        a() {
        }

        @Override // network.http.ReportNumHttp.Callback
        public void onNumSuccess() {
            y1.a((Context) TradAccountActivity.this.mActivity, (Class<?>) ReportNewActivity.class);
        }
    }

    private boolean a(SocialAccBean socialAccBean) {
        if (this.f19109b == null) {
            this.f19109b = new ArrayList();
            this.f19109b.add(socialAccBean);
        }
        for (int i2 = 0; i2 < this.f19109b.size(); i2++) {
            SocialAccBean socialAccBean2 = this.f19109b.get(i2);
            if (TextUtils.equals(socialAccBean2.getAccountName(), socialAccBean.getAccountName()) && TextUtils.equals(socialAccBean2.getAccountNum(), socialAccBean.getAccountNum())) {
                return true;
            }
        }
        return false;
    }

    private void forceActivity(int i2) {
        Intent intent = new Intent(this.mActivity, (Class<?>) TradAccountEditActivity.class);
        if (i2 != -1) {
            intent.putExtra(util.k1.v, i2);
            intent.putExtra(util.k1.w, this.f19109b.get(i2));
        }
        startActivity(intent);
    }

    private void getIntentData() {
        List list = (List) getIntent().getSerializableExtra(util.k1.r);
        if (list != null) {
            this.f19109b.addAll(list);
            this.f19108a.notifyDataSetChanged();
        }
    }

    private void sendData() {
        org.greenrobot.eventbus.c.f().d(new util.c2.a(19, this.f19109b));
    }

    @Override // ui.activity.BaseActivity
    public void initPage() {
        org.greenrobot.eventbus.c.f().e(this);
        this.mTvTitle.setText("添加诈骗交易账户");
        this.mTvSelectTip.setText("添加");
        this.mTvCommit.setText("提示：最多可上传20条交易账户");
        this.mBtnCommit.setText("确定");
        this.mRecyclerview.setLayoutManager(new LinearLayoutManager(this, 1, false));
        this.f19108a = new SocialAccAdapter(R.layout.item_social_acc, this.f19109b);
        this.f19108a.a(this.mRecyclerview);
        this.mRecyclerview.setAdapter(this.f19108a);
        this.f19108a.setOnItemChildClickListener(this);
        getIntentData();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        f19107c = false;
        finish();
    }

    @Override // ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        org.greenrobot.eventbus.c.f().g(this);
    }

    @org.greenrobot.eventbus.m(sticky = true, threadMode = ThreadMode.MAIN)
    public void onEventMainThread(util.c2.a aVar) {
        if (aVar != null) {
            int iA = aVar.a();
            if (iA == 17) {
                org.greenrobot.eventbus.c.f().f(aVar);
                SocialAccBean socialAccBean = (SocialAccBean) aVar.b();
                if (a(socialAccBean)) {
                    return;
                }
                this.f19109b.add(socialAccBean);
                this.f19108a.notifyDataSetChanged();
                return;
            }
            if (iA != 18) {
                return;
            }
            org.greenrobot.eventbus.c.f().f(aVar);
            SocialAccBean socialAccBean2 = (SocialAccBean) aVar.b();
            SocialAccBean socialAccBean3 = this.f19109b.get(((Integer) aVar.d()).intValue());
            socialAccBean3.setAccountNum(socialAccBean2.getAccountNum());
            socialAccBean3.setAccountName(socialAccBean2.getAccountName());
            this.f19108a.notifyDataSetChanged();
        }
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter.i
    public void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
        int id = view.getId();
        if (id == R.id.iv_delete) {
            this.f19109b.remove(i2);
            baseQuickAdapter.notifyDataSetChanged();
        } else {
            if (id != R.id.iv_edit) {
                return;
            }
            forceActivity(i2);
        }
    }

    @OnClick({R.id.iv_back, R.id.ll_select, R.id.btn_commit})
    public void onViewClicked(View view) {
        if (isDouble()) {
            return;
        }
        int id = view.getId();
        if (id == R.id.btn_commit) {
            if (f19107c) {
                ReportNumHttp.getInstance().principalHttp(new a());
            }
            sendData();
            finish();
            return;
        }
        if (id == R.id.iv_back) {
            sendData();
            onBackPressed();
        } else {
            if (id != R.id.ll_select) {
                return;
            }
            if (this.f19109b.size() >= 20) {
                util.w1.a("最多可上传20条交易账户");
            } else {
                forceActivity(-1);
            }
        }
    }

    @Override // ui.activity.BaseActivity
    public int setLayoutView() {
        return R.layout.activity_social_account;
    }
}
