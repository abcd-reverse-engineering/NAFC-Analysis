package ui.activity;

import adapter.ReportDetailListAdapter;
import adapter.ReportDetailsAdapter;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import bean.DetailBean;
import butterknife.BindView;
import butterknife.OnClick;
import com.hicorenational.antifraud.R;
import com.luck.picture.lib.tools.MediaUtils;
import interfaces.IOneClickListener;
import java.util.ArrayList;
import java.util.List;
import network.HistoryDetailInfo;
import network.HistoryListInfo;
import ui.callview.HistoryDetailCallView;
import ui.presenter.HistoryDetaPresenter;
import ui.view.swip.SwipBackLayout;

/* loaded from: classes2.dex */
public class HistoryDetailActivity extends BaseActivity implements HistoryDetailCallView {
    ReportDetailListAdapter detailListAdapter;
    private HistoryListInfo.RowsBean.DetailsBean info;

    @BindView(R.id.casecategory)
    TextView mCaseTegory;

    @BindView(R.id.tv_case_type)
    TextView mCaseTip;

    @BindView(R.id.recyclerview)
    RecyclerView mExpendList;
    private List<HistoryDetailInfo> mGroupList;
    private List<List<DetailBean>> mItemSet;

    @BindView(R.id.ll_progress)
    LinearLayout mLlProgress;

    @BindView(R.id.ll_report_progress)
    LinearLayout mLlReportProgress;

    @BindView(R.id.ll_report_view)
    View mLlReportView;
    private HistoryDetaPresenter mPresenter;

    @BindView(R.id.tv_case_num)
    TextView mTvCaseNum;

    @BindView(R.id.tv_report_name)
    TextView mTvReportInfo;

    @BindView(R.id.tv_report_num)
    TextView mTvReportNum;

    @BindView(R.id.report_time)
    TextView mTvReportTime;

    @BindView(R.id.tv_self)
    TextView mTvSelf;

    @BindView(R.id.tv_title)
    TextView mTvTitle;
    private int pageType;
    private HistoryListInfo.RowsBean rowsBean;

    private void DefineViewData(HistoryDetailInfo historyDetailInfo) {
        HistoryListInfo.RowsBean.DetailsBean detailsBean = this.info;
        if (detailsBean != null) {
            String caseCategoryText = detailsBean.getCaseCategoryText();
            if (TextUtils.isEmpty(caseCategoryText)) {
                caseCategoryText = "其他诈骗";
            }
            this.mCaseTegory.setText(caseCategoryText);
            this.info.getRegion();
            this.info.getCaseDescription();
        }
        if (historyDetailInfo.replys == null) {
            this.mLlProgress.setVisibility(8);
            return;
        }
        this.mLlProgress.setVisibility(0);
        for (int i2 = 0; i2 < historyDetailInfo.replys.size(); i2++) {
            View viewInflate = LayoutInflater.from(this.mActivity).inflate(R.layout.report_reply_item, (ViewGroup) null, false);
            ImageView imageView = (ImageView) viewInflate.findViewById(R.id.iv_reply_img);
            TextView textView = (TextView) viewInflate.findViewById(R.id.stp_line);
            TextView textView2 = (TextView) viewInflate.findViewById(R.id.tv_title);
            TextView textView3 = (TextView) viewInflate.findViewById(R.id.tv_time);
            TextView textView4 = (TextView) viewInflate.findViewById(R.id.tv_content);
            TextView textView5 = (TextView) viewInflate.findViewById(R.id.tv_line);
            textView2.setTypeface(this.typ_ME);
            HistoryDetailInfo.Replay replay = historyDetailInfo.replys.get(i2);
            int i3 = replay.processType;
            if (i3 == 3) {
                imageView.setImageResource(R.drawable.iv_gray_polic);
                textView2.setText(replay.text);
                textView3.setText(replay.replyTime);
                textView4.setText(TextUtils.isEmpty(replay.description) ? "" : replay.description);
            } else if (i3 == 2) {
                imageView.setImageResource(R.drawable.iv_gray_polic);
                textView2.setText(replay.text);
                textView3.setText(replay.replyTime);
                textView4.setText(TextUtils.isEmpty(replay.description) ? "" : replay.description);
                textView5.setBackgroundResource(R.color.transparent);
            } else {
                imageView.setImageResource(R.drawable.iv_gray_default_img);
                textView2.setText(replay.text);
                textView3.setText(replay.replyTime);
                textView4.setText(TextUtils.isEmpty(replay.description) ? "" : replay.description);
                textView5.setVisibility(8);
            }
            if (i2 == historyDetailInfo.replys.size() - 1) {
                textView.setVisibility(8);
            } else {
                textView.setVisibility(0);
            }
            if (TextUtils.isEmpty(replay.description)) {
                textView4.setVisibility(8);
            } else {
                textView4.setVisibility(0);
            }
            this.mLlReportProgress.addView(viewInflate);
        }
    }

    private void getIntentData() throws NumberFormatException {
        try {
            this.pageType = getIntent().getIntExtra(util.k1.C, 0);
            this.rowsBean = (HistoryListInfo.RowsBean) getIntent().getSerializableExtra(util.k1.B);
            this.info = this.rowsBean.getInfo();
            this.mPresenter.getDetail(this.info.getId());
            int i2 = Integer.parseInt(this.rowsBean.getEvidenceCount());
            this.mTvReportNum.setText("（" + i2 + "项举报内容）");
            this.mTvReportTime.setText(this.rowsBean.getInfo().getSubmitTime());
            if (i2 == 0) {
                this.mLlReportView.setVisibility(8);
            }
        } catch (Exception unused) {
        }
    }

    @Override // ui.activity.BaseActivity
    public void initPage() throws NumberFormatException {
        SwipBackLayout.a(this.mActivity).a();
        this.mTvTitle.setText("举报记录详情");
        util.b1.a(this, 0, "110", getString(R.string.report_time_tips), "", "我知道了", (IOneClickListener) null);
        this.mPresenter = new HistoryDetaPresenter(this.mActivity, this);
        getIntentData();
    }

    @Override // ui.callview.HistoryDetailCallView
    public void onSuccessRequest(HistoryDetailInfo historyDetailInfo) {
        this.mGroupList = new ArrayList();
        this.mItemSet = new ArrayList();
        if (historyDetailInfo == null) {
            return;
        }
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
        List<HistoryDetailInfo.SmsPhone> list2 = historyDetailInfo.smSes;
        if (list2 != null && list2.size() > 0) {
            HistoryDetailInfo historyDetailInfo3 = new HistoryDetailInfo();
            historyDetailInfo3.setTitle("短信");
            historyDetailInfo3.setItemType(2);
            this.mGroupList.add(historyDetailInfo3);
            ArrayList arrayList2 = new ArrayList();
            for (int i3 = 0; i3 < historyDetailInfo.smSes.size(); i3++) {
                HistoryDetailInfo.SmsPhone smsPhone = historyDetailInfo.smSes.get(i3);
                DetailBean detailBean2 = new DetailBean();
                detailBean2.setType(2);
                detailBean2.setNumber(smsPhone.number);
                detailBean2.setContent(smsPhone.content);
                detailBean2.setOccurTime(smsPhone.occurTime);
                arrayList2.add(detailBean2);
            }
            this.mItemSet.add(arrayList2);
        }
        List<HistoryDetailInfo.App> list3 = historyDetailInfo.apps;
        if (list3 != null && list3.size() > 0) {
            HistoryDetailInfo historyDetailInfo4 = new HistoryDetailInfo();
            historyDetailInfo4.setTitle("App");
            historyDetailInfo4.setItemType(3);
            this.mGroupList.add(historyDetailInfo4);
            ArrayList arrayList3 = new ArrayList();
            for (int i4 = 0; i4 < historyDetailInfo.apps.size(); i4++) {
                HistoryDetailInfo.App app = historyDetailInfo.apps.get(i4);
                DetailBean detailBean3 = new DetailBean();
                detailBean3.setType(3);
                detailBean3.setOs(historyDetailInfo.os);
                detailBean3.setFileName(app.name);
                detailBean3.setVersion(app.version);
                detailBean3.setOccurTime(app.occurTime);
                detailBean3.setDownloadUrl(app.downloadUrl);
                detailBean3.setAppAuthorInfo(app.appAuthorInfo);
                detailBean3.setDownloadQRCode(app.downloadQRCode);
                arrayList3.add(detailBean3);
            }
            this.mItemSet.add(arrayList3);
        }
        List<HistoryDetailInfo.Image> list4 = historyDetailInfo.imgs;
        if (list4 != null && list4.size() > 0) {
            HistoryDetailInfo historyDetailInfo5 = new HistoryDetailInfo();
            historyDetailInfo5.setTitle("图片");
            historyDetailInfo5.setItemType(4);
            this.mGroupList.add(historyDetailInfo5);
            ArrayList arrayList4 = new ArrayList();
            for (int i5 = 0; i5 < historyDetailInfo.imgs.size(); i5++) {
                HistoryDetailInfo.Image image = historyDetailInfo.imgs.get(i5);
                DetailBean detailBean4 = new DetailBean();
                detailBean4.setType(4);
                detailBean4.setFileName(image.name);
                detailBean4.setOccurTime(image.occurTime);
                arrayList4.add(detailBean4);
            }
            this.mItemSet.add(arrayList4);
        }
        List<HistoryDetailInfo.Record> list5 = historyDetailInfo.mP3s;
        if (list5 != null && list5.size() > 0) {
            HistoryDetailInfo historyDetailInfo6 = new HistoryDetailInfo();
            historyDetailInfo6.setTitle(MediaUtils.VIVO_RECORD_PATH_pt);
            historyDetailInfo6.setItemType(5);
            this.mGroupList.add(historyDetailInfo6);
            ArrayList arrayList5 = new ArrayList();
            for (int i6 = 0; i6 < historyDetailInfo.mP3s.size(); i6++) {
                HistoryDetailInfo.Record record = historyDetailInfo.mP3s.get(i6);
                DetailBean detailBean5 = new DetailBean();
                detailBean5.setType(5);
                detailBean5.setFileName(record.name);
                detailBean5.setOccurTime(record.occurTime);
                arrayList5.add(detailBean5);
            }
            this.mItemSet.add(arrayList5);
        }
        List<HistoryDetailInfo.Video> list6 = historyDetailInfo.mP4s;
        if (list6 != null && list6.size() > 0) {
            HistoryDetailInfo historyDetailInfo7 = new HistoryDetailInfo();
            historyDetailInfo7.setTitle("视频");
            historyDetailInfo7.setItemType(6);
            this.mGroupList.add(historyDetailInfo7);
            ArrayList arrayList6 = new ArrayList();
            for (int i7 = 0; i7 < historyDetailInfo.mP4s.size(); i7++) {
                HistoryDetailInfo.Video video = historyDetailInfo.mP4s.get(i7);
                DetailBean detailBean6 = new DetailBean();
                detailBean6.setType(6);
                detailBean6.setFileName(video.name);
                detailBean6.setOccurTime(video.occurTime);
                arrayList6.add(detailBean6);
            }
            this.mItemSet.add(arrayList6);
        }
        List<HistoryDetailInfo.Url> list7 = historyDetailInfo.urls;
        if (list7 != null && list7.size() > 0) {
            HistoryDetailInfo historyDetailInfo8 = new HistoryDetailInfo();
            historyDetailInfo8.setTitle("网址");
            historyDetailInfo8.setItemType(7);
            this.mGroupList.add(historyDetailInfo8);
            ArrayList arrayList7 = new ArrayList();
            for (int i8 = 0; i8 < historyDetailInfo.urls.size(); i8++) {
                HistoryDetailInfo.Url url = historyDetailInfo.urls.get(i8);
                DetailBean detailBean7 = new DetailBean();
                detailBean7.setType(7);
                detailBean7.setFileName(url.url);
                detailBean7.setOccurTime(url.occurTime);
                arrayList7.add(detailBean7);
            }
            this.mItemSet.add(arrayList7);
        }
        List<HistoryDetailInfo.SocialTrad> list8 = historyDetailInfo.socials;
        if (list8 != null && list8.size() > 0) {
            HistoryDetailInfo historyDetailInfo9 = new HistoryDetailInfo();
            historyDetailInfo9.setTitle("社交账号");
            historyDetailInfo9.setItemType(8);
            this.mGroupList.add(historyDetailInfo9);
            ArrayList arrayList8 = new ArrayList();
            for (int i9 = 0; i9 < historyDetailInfo.socials.size(); i9++) {
                HistoryDetailInfo.SocialTrad socialTrad = historyDetailInfo.socials.get(i9);
                DetailBean detailBean8 = new DetailBean();
                detailBean8.setType(8);
                detailBean8.setAccount(socialTrad.account);
                detailBean8.setAccountType(socialTrad.accountType);
                detailBean8.setOccurTime(socialTrad.occurTime);
                arrayList8.add(detailBean8);
            }
            this.mItemSet.add(arrayList8);
        }
        List<HistoryDetailInfo.SocialTrad> list9 = historyDetailInfo.payments;
        if (list9 != null && list9.size() > 0) {
            HistoryDetailInfo historyDetailInfo10 = new HistoryDetailInfo();
            historyDetailInfo10.setTitle("交易账户");
            historyDetailInfo10.setItemType(9);
            this.mGroupList.add(historyDetailInfo10);
            ArrayList arrayList9 = new ArrayList();
            for (int i10 = 0; i10 < historyDetailInfo.payments.size(); i10++) {
                HistoryDetailInfo.SocialTrad socialTrad2 = historyDetailInfo.payments.get(i10);
                DetailBean detailBean9 = new DetailBean();
                detailBean9.setType(9);
                detailBean9.setAccount(socialTrad2.account);
                detailBean9.setAccountType(socialTrad2.paymentType);
                detailBean9.setOccurTime(socialTrad2.occurTime);
                arrayList9.add(detailBean9);
            }
            this.mItemSet.add(arrayList9);
        }
        ReportDetailsAdapter reportDetailsAdapter = new ReportDetailsAdapter(this.typ_ME, this.mActivity, this.mGroupList, this.mItemSet);
        this.mExpendList.setLayoutManager(new LinearLayoutManager(this));
        this.mExpendList.setAdapter(reportDetailsAdapter);
        DefineViewData(historyDetailInfo);
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
        return d.a.k() ? R.layout.activity_history_detail_local : R.layout.activity_history_detail;
    }
}
