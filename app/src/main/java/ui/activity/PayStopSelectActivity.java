package ui.activity;

import adapter.PayStopSelAdapter;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import bean.AccountListBean;
import butterknife.BindView;
import butterknife.OnClick;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.hicorenational.antifraud.R;
import java.util.ArrayList;
import java.util.List;
import ui.Hicore;

/* loaded from: classes2.dex */
public class PayStopSelectActivity extends BaseActivity implements BaseQuickAdapter.i {

    /* renamed from: a, reason: collision with root package name */
    private PayStopSelAdapter f18472a;

    /* renamed from: b, reason: collision with root package name */
    private List<AccountListBean> f18473b = new ArrayList();

    @BindView(R.id.btn_commit)
    Button mBtnCommit;

    @BindView(R.id.recyclerview)
    RecyclerView mRecyclerview;

    @BindView(R.id.tv_title)
    TextView mTvTitle;

    private List<AccountListBean> a() {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < this.f18473b.size(); i2++) {
            AccountListBean accountListBean = this.f18473b.get(i2);
            if (accountListBean.isSelect()) {
                arrayList.add(accountListBean);
            }
        }
        return arrayList;
    }

    @Override // ui.activity.BaseActivity
    public void initPage() {
        this.mTvTitle.setText("选择止付账户");
        this.f18473b = (List) getIntent().getSerializableExtra(util.k1.f20845c);
        this.mRecyclerview.setLayoutManager(new LinearLayoutManager(this, 1, false));
        this.f18472a = new PayStopSelAdapter(R.layout.item_paystop_sel, this.f18473b);
        this.f18472a.a(this.mRecyclerview);
        this.mRecyclerview.setAdapter(this.f18472a);
        this.f18472a.setOnItemChildClickListener(this);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter.i
    public void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
        if (view.getId() != R.id.iv_select) {
            return;
        }
        AccountListBean accountListBean = this.f18473b.get(i2);
        ImageView imageView = (ImageView) view;
        if (accountListBean.isSelect()) {
            imageView.setImageResource(R.mipmap.checkbox_unchecked_circle);
            accountListBean.setSelect(false);
        } else {
            imageView.setImageResource(R.mipmap.checkbox_checked_circle);
            accountListBean.setSelect(true);
        }
    }

    @Override // ui.activity.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    @OnClick({R.id.iv_back, R.id.btn_commit})
    public void onViewClicked(View view) {
        if (Hicore.getApp().isDouble()) {
            return;
        }
        int id = view.getId();
        if (id != R.id.btn_commit) {
            if (id != R.id.iv_back) {
                return;
            }
            onBackPressed();
        } else {
            org.greenrobot.eventbus.c.f().d(new util.c2.a(301, a()));
            org.greenrobot.eventbus.c.f().d(new util.c2.a(302, this.f18473b));
            finish();
        }
    }

    @Override // ui.activity.BaseActivity
    public int setLayoutView() {
        return R.layout.activity_paystop_sel_list;
    }
}
