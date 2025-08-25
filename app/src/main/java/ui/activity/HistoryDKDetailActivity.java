package ui.activity;

import adapter.ReportDKDetailsAdapter;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import bean.DetailBean;
import butterknife.BindView;
import butterknife.OnClick;
import com.hicorenational.antifraud.R;
import interfaces.IOneClickListener;
import java.util.ArrayList;
import java.util.List;
import network.HistoryDetailInfo;
import network.HistoryListInfo;
import ui.callview.HistoryDetailCallView;
import ui.presenter.HistoryDKDetaPresenter;
import ui.view.swip.SwipBackLayout;

/* loaded from: classes2.dex */
public class HistoryDKDetailActivity extends BaseActivity implements HistoryDetailCallView {
    private HistoryListInfo.RowsBean.DetailsBean info;

    @BindView(R.id.expand_list)
    RecyclerView mExpendList;
    private List<HistoryDetailInfo> mGroupList;
    private List<List<DetailBean>> mItemSet;
    private HistoryDKDetaPresenter mPresenter;

    @BindView(R.id.tv_title)
    TextView mTvTitle;
    private HistoryListInfo.RowsBean rowsBean;

    @Override // ui.activity.BaseActivity
    public void initPage() {
        SwipBackLayout.a(this.mActivity).a();
        this.mTvTitle.setText("举报记录详情");
        util.b1.a(this, 0, "110", getString(R.string.report_time_tips), "", "我知道了", (IOneClickListener) null);
        this.mPresenter = new HistoryDKDetaPresenter(this.mActivity, this);
        try {
            this.rowsBean = (HistoryListInfo.RowsBean) getIntent().getSerializableExtra(util.k1.B);
            this.info = this.rowsBean.getInfo();
            this.mPresenter.getDetail(this.info.getId());
        } catch (Exception unused) {
        }
    }

    @Override // ui.callview.HistoryDetailCallView
    public void onSuccessRequest(HistoryDetailInfo historyDetailInfo) {
        this.mGroupList = new ArrayList();
        this.mItemSet = new ArrayList();
        if (historyDetailInfo == null) {
            return;
        }
        this.mGroupList.add(new HistoryDetailInfo());
        List<HistoryDetailInfo.TellPhone> list = historyDetailInfo.tels;
        if (list != null && list.size() > 0) {
            HistoryDetailInfo historyDetailInfo2 = new HistoryDetailInfo();
            historyDetailInfo2.setTitle("电话");
            historyDetailInfo2.setItemType(1);
            this.mGroupList.add(historyDetailInfo2);
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < historyDetailInfo.tels.size(); i2++) {
                HistoryDetailInfo.TellPhone tellPhone = historyDetailInfo.tels.get(i2);
                DetailBean detailBean = new DetailBean();
                detailBean.setType(1);
                detailBean.setNumber(tellPhone.number);
                detailBean.setOccurTime(tellPhone.occurTime);
                arrayList.add(detailBean);
            }
            this.mItemSet.add(arrayList);
        }
        List<HistoryDetailInfo.SocialTrad> list2 = historyDetailInfo.socials;
        if (list2 != null && list2.size() > 0) {
            HistoryDetailInfo historyDetailInfo3 = new HistoryDetailInfo();
            historyDetailInfo3.setTitle("社交账号");
            historyDetailInfo3.setItemType(8);
            this.mGroupList.add(historyDetailInfo3);
            ArrayList arrayList2 = new ArrayList();
            for (int i3 = 0; i3 < historyDetailInfo.socials.size(); i3++) {
                HistoryDetailInfo.SocialTrad socialTrad = historyDetailInfo.socials.get(i3);
                DetailBean detailBean2 = new DetailBean();
                detailBean2.setType(8);
                detailBean2.setAccount(socialTrad.account);
                detailBean2.setAccountType(socialTrad.accountType);
                detailBean2.setOccurTime(socialTrad.occurTime);
                arrayList2.add(detailBean2);
            }
            this.mItemSet.add(arrayList2);
        }
        List<HistoryDetailInfo.SocialTrad> list3 = historyDetailInfo.payments;
        if (list3 != null && list3.size() > 0) {
            HistoryDetailInfo historyDetailInfo4 = new HistoryDetailInfo();
            historyDetailInfo4.setTitle("交易账户");
            historyDetailInfo4.setItemType(9);
            this.mGroupList.add(historyDetailInfo4);
            ArrayList arrayList3 = new ArrayList();
            for (int i4 = 0; i4 < historyDetailInfo.payments.size(); i4++) {
                HistoryDetailInfo.SocialTrad socialTrad2 = historyDetailInfo.payments.get(i4);
                DetailBean detailBean3 = new DetailBean();
                detailBean3.setType(9);
                detailBean3.setAccount(socialTrad2.account);
                detailBean3.setAccountType(socialTrad2.accountType);
                detailBean3.setOccurTime(socialTrad2.occurTime);
                arrayList3.add(detailBean3);
            }
            this.mItemSet.add(arrayList3);
        }
        ReportDKDetailsAdapter reportDKDetailsAdapter = new ReportDKDetailsAdapter(this.typ_ME, this.rowsBean, historyDetailInfo, this.mActivity, this.mGroupList, this.mItemSet);
        this.mExpendList.setLayoutManager(new LinearLayoutManager(this));
        this.mExpendList.setAdapter(reportDKDetailsAdapter);
    }

    @OnClick({R.id.iv_back})
    public void onViewClicked(View view) {
        if (!isDouble() && view.getId() == R.id.iv_back) {
            finish();
        }
    }

    @Override // ui.callview.HistoryDetailCallView
    public void onfailRequest() {
    }

    @Override // ui.activity.BaseActivity
    public int setLayoutView() {
        return R.layout.activity_dk_history_detail;
    }
}
