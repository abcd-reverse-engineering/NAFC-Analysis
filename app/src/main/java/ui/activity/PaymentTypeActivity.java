package ui.activity;

import adapter.PaymentTypeAdapter;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import bean.CaseDivisonBean;
import butterknife.BindView;
import butterknife.OnClick;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.hicorenational.antifraud.R;
import java.util.ArrayList;
import java.util.List;
import ui.callview.PaymentTypeCallView;
import ui.presenter.PaymentTypePresenter;
import ui.view.swip.SwipBackLayout;

/* loaded from: classes2.dex */
public class PaymentTypeActivity extends BaseActivity implements PaymentTypeCallView, BaseQuickAdapter.i {

    @BindView(R.id.recyclerview)
    RecyclerView mRecyclerview;

    @BindView(R.id.tv_title)
    TextView mTvTitle;
    private PaymentTypePresenter mPresenter = null;
    private List<CaseDivisonBean> mPaymentTypeList = new ArrayList();
    private PaymentTypeAdapter mAdapter = null;

    @Override // ui.activity.BaseActivity
    public void initPage() {
        SwipBackLayout.a(this.mActivity).a();
        this.mTvTitle.setText("转账方式");
        this.mPresenter = new PaymentTypePresenter(this, this);
        this.mRecyclerview.setLayoutManager(new GridLayoutManager(this.mActivity, 3));
        this.mAdapter = new PaymentTypeAdapter(this.mPaymentTypeList);
        this.mAdapter.setOnItemChildClickListener(this);
        this.mRecyclerview.setAdapter(this.mAdapter);
        this.mPresenter.paymentType();
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter.i
    public void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
        TextView textView = (TextView) view.findViewById(R.id.tv_txet);
        textView.setTextColor(getResources().getColor(R.color.blue));
        textView.setBackgroundResource(R.drawable.shape_blue_25);
        Intent intent = new Intent();
        intent.putExtra(util.k1.j1, this.mPaymentTypeList.get(i2));
        setResult(-1, intent);
        finish();
    }

    @Override // ui.callview.PaymentTypeCallView
    public void onSuccessPaymentType(List<CaseDivisonBean> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        this.mPaymentTypeList.addAll(list);
        this.mAdapter.notifyDataSetChanged();
    }

    @OnClick({R.id.iv_back})
    public void onViewClicked(View view) {
        if (!isDouble() && view.getId() == R.id.iv_back) {
            finish();
        }
    }

    @Override // ui.activity.BaseActivity
    public int setLayoutView() {
        return R.layout.activity_trans_type;
    }
}
