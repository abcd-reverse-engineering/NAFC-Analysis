package ui.activity;

import adapter.SocialAccAdapter;
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
import org.greenrobot.eventbus.ThreadMode;

/* loaded from: classes2.dex */
public class SocialAccountActivity extends BaseActivity implements BaseQuickAdapter.i {

    /* renamed from: a, reason: collision with root package name */
    private SocialAccAdapter f19053a;

    /* renamed from: b, reason: collision with root package name */
    private List<SocialAccBean> f19054b = new ArrayList();

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

    private boolean a(SocialAccBean socialAccBean) {
        if (this.f19054b == null) {
            this.f19054b = new ArrayList();
            this.f19054b.add(socialAccBean);
        }
        for (int i2 = 0; i2 < this.f19054b.size(); i2++) {
            SocialAccBean socialAccBean2 = this.f19054b.get(i2);
            if (TextUtils.equals(socialAccBean2.getAccountName(), socialAccBean.getAccountName()) && TextUtils.equals(socialAccBean2.getAccountNum(), socialAccBean.getAccountName())) {
                return true;
            }
        }
        return false;
    }

    private void forceActivity(int i2) {
        Intent intent = new Intent(this.mActivity, (Class<?>) SocialAccountEditActivity.class);
        if (i2 != -1) {
            intent.putExtra(util.k1.v, i2);
            intent.putExtra(util.k1.w, this.f19054b.get(i2));
        }
        startActivity(intent);
    }

    private void getIntentData() {
        List list = (List) getIntent().getSerializableExtra(util.k1.o);
        if (list != null) {
            this.f19054b.addAll(list);
            this.f19053a.notifyDataSetChanged();
        }
    }

    private void sendData() {
        org.greenrobot.eventbus.c.f().d(new util.c2.a(16, this.f19054b));
    }

    @Override // ui.activity.BaseActivity
    public void initPage() {
        org.greenrobot.eventbus.c.f().e(this);
        this.mTvTitle.setText("添加诈骗社交账号");
        this.mTvSelectTip.setText("添加");
        this.mTvCommit.setText("提示：最多可上传20条社交账号");
        this.mBtnCommit.setText("确定");
        this.mRecyclerview.setLayoutManager(new LinearLayoutManager(this, 1, false));
        this.f19053a = new SocialAccAdapter(R.layout.item_social_acc, this.f19054b);
        this.f19053a.a(this.mRecyclerview);
        this.mRecyclerview.setAdapter(this.f19053a);
        this.f19053a.setOnItemChildClickListener(this);
        getIntentData();
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
            if (iA == 14) {
                SocialAccBean socialAccBean = (SocialAccBean) aVar.b();
                if (a(socialAccBean)) {
                    return;
                }
                this.f19054b.add(socialAccBean);
                this.f19053a.notifyDataSetChanged();
                return;
            }
            if (iA != 15) {
                return;
            }
            SocialAccBean socialAccBean2 = (SocialAccBean) aVar.b();
            SocialAccBean socialAccBean3 = this.f19054b.get(((Integer) aVar.d()).intValue());
            socialAccBean3.setAccountNum(socialAccBean2.getAccountNum());
            socialAccBean3.setAccountName(socialAccBean2.getAccountName());
            this.f19053a.notifyDataSetChanged();
        }
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter.i
    public void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
        int id = view.getId();
        if (id == R.id.iv_delete) {
            this.f19054b.remove(i2);
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
            sendData();
            finish();
        } else if (id == R.id.iv_back) {
            sendData();
            finish();
        } else {
            if (id != R.id.ll_select) {
                return;
            }
            if (this.f19054b.size() >= 20) {
                util.w1.a("最多可上传20条社交账号");
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
