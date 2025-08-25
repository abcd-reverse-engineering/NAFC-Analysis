package ui.presenter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import bean.ReportCaseBean;
import bean.ReportIDInfoBean;
import bean.module.ModuelConfig;
import com.hicorenational.antifraud.R;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import network.APIException;
import network.MiddleSubscriber;
import network.account.APIresult;
import ui.activity.ReportCaseInfoActivity;
import ui.activity.ReportRecordsReplyActivity;
import ui.callview.ReportRecordView;
import ui.model.ModelPresent;
import util.k1;
import util.w1;

/* loaded from: classes2.dex */
public class ReportRecordPresenter extends ModelPresent<ReportRecordView> {
    private List<ReportCaseBean.RowsBean> caseBeans;
    private boolean hasLocal;
    private HolderAdapte mAdapter;

    public class HolderAdapte extends RecyclerView.Adapter<a> {

        /* renamed from: a, reason: collision with root package name */
        private Context f20077a;

        class a extends RecyclerView.ViewHolder {

            /* renamed from: a, reason: collision with root package name */
            public View f20079a;

            /* renamed from: b, reason: collision with root package name */
            public View f20080b;

            /* renamed from: c, reason: collision with root package name */
            public TextView f20081c;

            /* renamed from: d, reason: collision with root package name */
            public TextView f20082d;

            /* renamed from: e, reason: collision with root package name */
            public TextView f20083e;

            /* renamed from: f, reason: collision with root package name */
            public TextView f20084f;

            /* renamed from: g, reason: collision with root package name */
            public TextView f20085g;

            /* renamed from: h, reason: collision with root package name */
            public ImageView f20086h;

            /* renamed from: i, reason: collision with root package name */
            public TextView f20087i;

            /* renamed from: j, reason: collision with root package name */
            public TextView f20088j;

            public a(View view) {
                super(view);
                this.f20079a = view.findViewById(R.id.fl_view);
                this.f20081c = (TextView) view.findViewById(R.id.tv_case_name);
                this.f20082d = (TextView) view.findViewById(R.id.tv_victim_name);
                this.f20083e = (TextView) view.findViewById(R.id.tv_id_type);
                this.f20084f = (TextView) view.findViewById(R.id.tv_peop_idcard);
                this.f20085g = (TextView) view.findViewById(R.id.tv_peop_time);
                this.f20086h = (ImageView) view.findViewById(R.id.iv_item_tips);
                this.f20080b = view.findViewById(R.id.ll_red_state);
                this.f20087i = (TextView) view.findViewById(R.id.red_tip);
                this.f20088j = (TextView) view.findViewById(R.id.tv_reply);
            }
        }

        public HolderAdapte(Context context) {
            this.f20077a = context;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(a aVar, final int i2) {
            ReportCaseBean.RowsBean rowsBean;
            if (ReportRecordPresenter.this.caseBeans.size() > 0 && (rowsBean = (ReportCaseBean.RowsBean) ReportRecordPresenter.this.caseBeans.get(i2)) != null) {
                aVar.f20081c.setText(rowsBean.getCaseName());
                aVar.f20082d.setText(TextUtils.isEmpty(rowsBean.getName()) ? "未填写" : rowsBean.getName());
                if (TextUtils.isEmpty(rowsBean.getDocumentNumber())) {
                    aVar.f20083e.setText("证件号");
                    aVar.f20084f.setText("未填写");
                } else {
                    aVar.f20083e.setText("证件号 (" + rowsBean.getDocumentTypeText() + ")： ");
                    aVar.f20084f.setText(rowsBean.getDocumentNumber());
                }
                aVar.f20085g.setText(rowsBean.getProcessTime());
                aVar.f20080b.setVisibility(8);
                if (rowsBean.getStatus() == 0 || rowsBean.getStatus() == 3 || rowsBean.getStatus() == 5) {
                    aVar.f20086h.setImageResource(R.drawable.iv_case_comit);
                    if (ReportRecordPresenter.this.hasLocal) {
                        aVar.f20080b.setVisibility(0);
                        if (rowsBean.getReplyStatus() > 0) {
                            aVar.f20088j.setText("已反馈");
                            aVar.f20088j.setTextColor(Color.parseColor("#2CAF28"));
                            if (rowsBean.getRedPoint() > 0) {
                                aVar.f20087i.setVisibility(0);
                            } else {
                                aVar.f20087i.setVisibility(8);
                            }
                        } else {
                            aVar.f20088j.setText("待反馈");
                            aVar.f20088j.setTextColor(ReportRecordPresenter.this.mActivity.getResources().getColor(R.color.colorGray));
                        }
                    } else {
                        aVar.f20080b.setVisibility(8);
                    }
                } else if (rowsBean.getStatus() == 6) {
                    aVar.f20086h.setImageResource(R.drawable.iv_case_back);
                }
                if (rowsBean.getIsExpired() == 1) {
                    aVar.f20086h.setImageResource(R.drawable.ic_case_exprd);
                    aVar.f20080b.setVisibility(8);
                }
            }
            aVar.f20079a.setOnClickListener(new View.OnClickListener() { // from class: ui.presenter.t
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f20245a.a(i2, view);
                }
            });
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return ReportRecordPresenter.this.caseBeans.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public a onCreateViewHolder(ViewGroup viewGroup, int i2) {
            return new a(LayoutInflater.from(this.f20077a).inflate(R.layout.item_report_record, viewGroup, false));
        }

        public /* synthetic */ void a(int i2, View view) {
            ReportCaseBean.RowsBean rowsBean = (ReportCaseBean.RowsBean) ReportRecordPresenter.this.caseBeans.get(i2);
            if (rowsBean.getIsExpired() == 1) {
                return;
            }
            if (rowsBean.getStatus() == 6) {
                ReportRecordPresenter.this.onsuccessReportID(rowsBean);
                return;
            }
            if ((rowsBean.getStatus() == 0 || rowsBean.getStatus() == 3 || rowsBean.getStatus() == 5) && rowsBean.getReplyStatus() > 0) {
                rowsBean.setRedPoint(1);
                notifyItemChanged(i2);
                Intent intent = new Intent(ReportRecordPresenter.this.mActivity, (Class<?>) ReportRecordsReplyActivity.class);
                intent.putExtra(k1.C0, rowsBean.getId());
                ReportRecordPresenter.this.mActivity.startActivity(intent);
            }
        }
    }

    class a extends MiddleSubscriber<APIresult<ReportCaseBean>> {
        a() {
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return ReportCaseBean.class;
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            super.onErrorMiddle(aPIException);
            ((ReportRecordView) ReportRecordPresenter.this.mvpView).onfailRequest();
            w1.a(aPIException.getMessage());
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<ReportCaseBean> aPIresult) {
            super.onNextMiddle(aPIresult);
            if (aPIresult.getCode() != 0 || aPIresult.getData() == null) {
                onErrorMiddle(APIException.getApiExcept(aPIresult.getMsg()));
            } else {
                ((ReportRecordView) ReportRecordPresenter.this.mvpView).onSuccessRequest(aPIresult.getData());
            }
        }
    }

    public ReportRecordPresenter(Activity activity, ReportRecordView reportRecordView) {
        super(activity, reportRecordView);
        this.caseBeans = new ArrayList();
        this.hasLocal = false;
        this.hasLocal = d.a.k();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onsuccessReportID(ReportCaseBean.RowsBean rowsBean) {
        ReportIDInfoBean reportIDInfoBean = new ReportIDInfoBean();
        reportIDInfoBean.setCaseName(rowsBean.getCaseName());
        reportIDInfoBean.setCaseNumber(rowsBean.getCaseNumber());
        reportIDInfoBean.setCaseCategoryText(rowsBean.getCaseCategoryText());
        reportIDInfoBean.setProcessTime(rowsBean.getProcessTime());
        Intent intent = new Intent(this.mActivity, (Class<?>) ReportCaseInfoActivity.class);
        intent.putExtra(k1.C0, rowsBean.getId());
        intent.putExtra(k1.f20844b, reportIDInfoBean);
        this.mActivity.startActivity(intent);
        this.mActivity.finish();
    }

    public void initRecyclePeop(RecyclerView recyclerView) {
        recyclerView.setLayoutManager(new LinearLayoutManager(this.mActivity, 1, false));
        this.mAdapter = new HolderAdapte(this.mActivity);
        recyclerView.setAdapter(this.mAdapter);
    }

    public void reportUserCases() {
        reportUserCases(d.a.a(ModuelConfig.MODEL_CASEXC, 4, e.b.d2), new a());
    }

    public void setListData(List<ReportCaseBean.RowsBean> list) {
        if (list != null) {
            this.caseBeans = list;
            this.mAdapter.notifyDataSetChanged();
        }
    }
}
