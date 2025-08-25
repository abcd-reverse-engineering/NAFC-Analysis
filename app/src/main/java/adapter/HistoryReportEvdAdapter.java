package adapter;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hicorenational.antifraud.R;
import java.util.List;
import network.HistoryListInfo;

/* loaded from: classes.dex */
public class HistoryReportEvdAdapter extends BaseQuickAdapter<HistoryListInfo.RowsBean, BaseViewHolder> {
    private List<HistoryListInfo.RowsBean> V;
    private b W;
    private boolean X;

    class a implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f1284a;

        a(int i2) {
            this.f1284a = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (HistoryReportEvdAdapter.this.W != null) {
                HistoryListInfo.RowsBean rowsBean = (HistoryListInfo.RowsBean) HistoryReportEvdAdapter.this.V.get(this.f1284a);
                HistoryReportEvdAdapter.this.W.onItemClickListener(rowsBean);
                rowsBean.getInfo().setRedPoint(0);
                HistoryReportEvdAdapter.this.notifyItemChanged(this.f1284a);
            }
        }
    }

    public interface b {
        void onItemClickListener(HistoryListInfo.RowsBean rowsBean);
    }

    public HistoryReportEvdAdapter(List<HistoryListInfo.RowsBean> list) {
        super(R.layout.item_history_report, list);
        this.X = false;
        this.V = list;
        this.X = d.a.k();
    }

    public void setOnItemClickListener(b bVar) {
        this.W = bVar;
    }

    public void a(List<HistoryListInfo.RowsBean> list) {
        this.V.clear();
        this.V.addAll(list);
        notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void a(BaseViewHolder baseViewHolder, HistoryListInfo.RowsBean rowsBean) {
        TextView textView = (TextView) baseViewHolder.c(R.id.tv_self);
        TextView textView2 = (TextView) baseViewHolder.c(R.id.tv_case_num);
        ImageView imageView = (ImageView) baseViewHolder.c(R.id.iv_dk_tag);
        TextView textView3 = (TextView) baseViewHolder.c(R.id.tv_reply);
        TextView textView4 = (TextView) baseViewHolder.c(R.id.red_tip);
        HistoryListInfo.RowsBean.DetailsBean info = rowsBean.getInfo();
        String evidenceCount = rowsBean.getEvidenceCount();
        info.getCaseNumber();
        String caseCategoryText = info.getCaseCategoryText();
        String caseDescription = info.getCaseDescription();
        String submitTime = info.getSubmitTime();
        info.getRegion();
        if (TextUtils.isEmpty(caseCategoryText)) {
            caseCategoryText = "其他诈骗";
        }
        baseViewHolder.a(R.id.casecategory, (CharSequence) caseCategoryText);
        baseViewHolder.a(R.id.report_size, (CharSequence) ("(" + evidenceCount + "项举报内容)"));
        TextUtils.isEmpty(caseDescription);
        baseViewHolder.a(R.id.report_time, (CharSequence) submitTime);
        textView.setVisibility(8);
        textView2.setVisibility(8);
        imageView.setVisibility(8);
        if (info.getRedPoint() == 1) {
            textView4.setVisibility(0);
        } else {
            textView4.setVisibility(8);
        }
        if (this.X) {
            if (info.getReplyStatus() == 1) {
                textView3.setText("待受理");
                textView3.setTextColor(Color.parseColor("#999999"));
                return;
            } else if (info.getReplyStatus() == 2) {
                textView3.setText("已受理");
                textView3.setTextColor(Color.parseColor("#999999"));
                return;
            } else {
                if (info.getReplyStatus() == 3) {
                    textView3.setText("已回复");
                    textView3.setTextColor(Color.parseColor("#2CAF28"));
                    return;
                }
                return;
            }
        }
        textView3.setVisibility(8);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(BaseViewHolder baseViewHolder, @SuppressLint({"RecyclerView"}) int i2) {
        super.onBindViewHolder((HistoryReportEvdAdapter) baseViewHolder, i2);
        baseViewHolder.itemView.setOnClickListener(new a(i2));
    }
}
