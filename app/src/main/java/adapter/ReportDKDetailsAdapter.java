package adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import bean.DetailBean;
import com.hicorenational.antifraud.R;
import java.util.List;
import network.HistoryDetailInfo;
import network.HistoryListInfo;

/* loaded from: classes.dex */
public class ReportDKDetailsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* renamed from: h, reason: collision with root package name */
    public static final int f1305h = -1;

    /* renamed from: i, reason: collision with root package name */
    public static final int f1306i = 1;

    /* renamed from: j, reason: collision with root package name */
    public static final int f1307j = 8;

    /* renamed from: k, reason: collision with root package name */
    public static final int f1308k = 9;

    /* renamed from: a, reason: collision with root package name */
    public Typeface f1309a;

    /* renamed from: b, reason: collision with root package name */
    private final Context f1310b;

    /* renamed from: c, reason: collision with root package name */
    private HistoryListInfo.RowsBean.DetailsBean f1311c;

    /* renamed from: d, reason: collision with root package name */
    private HistoryListInfo.RowsBean f1312d;

    /* renamed from: e, reason: collision with root package name */
    private HistoryDetailInfo f1313e;

    /* renamed from: f, reason: collision with root package name */
    private final List<HistoryDetailInfo> f1314f;

    /* renamed from: g, reason: collision with root package name */
    private List<List<DetailBean>> f1315g;

    public class DefineViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: a, reason: collision with root package name */
        TextView f1316a;

        /* renamed from: b, reason: collision with root package name */
        TextView f1317b;

        /* renamed from: c, reason: collision with root package name */
        TextView f1318c;

        /* renamed from: d, reason: collision with root package name */
        TextView f1319d;

        /* renamed from: e, reason: collision with root package name */
        TextView f1320e;

        /* renamed from: f, reason: collision with root package name */
        TextView f1321f;

        /* renamed from: g, reason: collision with root package name */
        ImageView f1322g;

        /* renamed from: h, reason: collision with root package name */
        TextView f1323h;

        /* renamed from: i, reason: collision with root package name */
        LinearLayout f1324i;

        /* renamed from: j, reason: collision with root package name */
        LinearLayout f1325j;

        /* renamed from: k, reason: collision with root package name */
        LinearLayout f1326k;

        public DefineViewHolder(View view) {
            super(view);
            this.f1316a = (TextView) view.findViewById(R.id.tv_case_type);
            this.f1317b = (TextView) view.findViewById(R.id.casecategory);
            this.f1318c = (TextView) view.findViewById(R.id.tv_report_name);
            this.f1319d = (TextView) view.findViewById(R.id.tv_self);
            this.f1320e = (TextView) view.findViewById(R.id.report_size);
            this.f1321f = (TextView) view.findViewById(R.id.tv_case_num);
            this.f1325j = (LinearLayout) view.findViewById(R.id.ll_report_prog);
            this.f1322g = (ImageView) view.findViewById(R.id.iv_dk_tag);
            this.f1323h = (TextView) view.findViewById(R.id.report_time);
            this.f1324i = (LinearLayout) view.findViewById(R.id.ll_progress);
            this.f1326k = (LinearLayout) view.findViewById(R.id.ll_report_progress);
            this.f1316a.setText("举报详情");
            this.f1325j.setVisibility(8);
        }
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: a, reason: collision with root package name */
        public RecyclerView f1328a;

        /* renamed from: b, reason: collision with root package name */
        public int f1329b;

        /* renamed from: c, reason: collision with root package name */
        public TextView f1330c;

        /* renamed from: d, reason: collision with root package name */
        public TextView f1331d;

        /* renamed from: e, reason: collision with root package name */
        public View f1332e;

        public RecyclerViewHolder(View view, int i2) {
            super(view);
            this.f1329b = i2;
            this.f1328a = (RecyclerView) view.findViewById(R.id.recyclerview);
            this.f1330c = (TextView) view.findViewById(R.id.group_report);
            this.f1331d = (TextView) view.findViewById(R.id.group_report_count);
            this.f1332e = view.findViewById(R.id.item_line);
        }
    }

    public ReportDKDetailsAdapter(Typeface typeface, HistoryListInfo.RowsBean rowsBean, HistoryDetailInfo historyDetailInfo, Context context, List<HistoryDetailInfo> list, List<List<DetailBean>> list2) {
        this.f1310b = context;
        this.f1309a = typeface;
        this.f1312d = rowsBean;
        this.f1311c = rowsBean == null ? null : rowsBean.getInfo();
        this.f1313e = historyDetailInfo;
        this.f1314f = list;
        this.f1315g = list2;
    }

    private void a(DefineViewHolder defineViewHolder) {
        HistoryListInfo.RowsBean.DetailsBean detailsBean = this.f1311c;
        if (detailsBean != null) {
            String caseCategoryText = detailsBean.getCaseCategoryText();
            if (TextUtils.isEmpty(caseCategoryText)) {
                caseCategoryText = "其他诈骗";
            }
            defineViewHolder.f1317b.setText(caseCategoryText);
            defineViewHolder.f1320e.setText("(" + this.f1312d.getEvidenceCount() + "项举报内容)");
            defineViewHolder.f1323h.setText(this.f1311c.getSubmitTime());
            this.f1311c.getRegion();
            this.f1311c.getCaseDescription();
            defineViewHolder.f1322g.setVisibility(0);
        }
        if (this.f1313e.replys == null) {
            defineViewHolder.f1324i.setVisibility(8);
            return;
        }
        defineViewHolder.f1324i.setVisibility(0);
        for (int i2 = 0; i2 < this.f1313e.replys.size(); i2++) {
            View viewInflate = LayoutInflater.from(this.f1310b).inflate(R.layout.report_reply_item, (ViewGroup) null, false);
            ImageView imageView = (ImageView) viewInflate.findViewById(R.id.iv_reply_img);
            TextView textView = (TextView) viewInflate.findViewById(R.id.tv_title);
            TextView textView2 = (TextView) viewInflate.findViewById(R.id.tv_time);
            TextView textView3 = (TextView) viewInflate.findViewById(R.id.tv_content);
            TextView textView4 = (TextView) viewInflate.findViewById(R.id.tv_line);
            textView.setTypeface(this.f1309a);
            HistoryDetailInfo.Replay replay = this.f1313e.replys.get(i2);
            int i3 = replay.processType;
            if (i3 == 3) {
                imageView.setImageResource(R.drawable.iv_gray_polic);
                textView.setText(replay.text);
                textView2.setText(replay.replyTime);
                textView3.setText(replay.description);
            } else if (i3 == 2) {
                imageView.setImageResource(R.drawable.iv_gray_polic);
                textView.setText(replay.text);
                textView2.setText(replay.replyTime);
                textView3.setText(replay.description);
                textView4.setBackgroundResource(R.color.divide_line);
            } else {
                imageView.setImageResource(R.drawable.iv_gray_default_img);
                textView.setText(replay.text);
                textView2.setText(replay.replyTime);
                textView3.setText(replay.description);
                textView4.setVisibility(8);
            }
            if (TextUtils.isEmpty(replay.description)) {
                textView3.setVisibility(8);
            } else {
                textView3.setVisibility(0);
            }
            defineViewHolder.f1326k.addView(viewInflate);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f1314f.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i2) {
        if (this.f1314f.get(i2).getItemType() == -1) {
            return -1;
        }
        if (this.f1314f.get(i2).getItemType() == 1) {
            return 1;
        }
        if (this.f1314f.get(i2).getItemType() == 8) {
            return 8;
        }
        return this.f1314f.get(i2).getItemType() == 9 ? 9 : 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i2) {
        if (viewHolder instanceof DefineViewHolder) {
            a((DefineViewHolder) viewHolder);
        } else if (viewHolder instanceof RecyclerViewHolder) {
            a((RecyclerViewHolder) viewHolder, i2 - 1);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        if (i2 == -1) {
            return new DefineViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.history_list_head, viewGroup, false));
        }
        if (i2 == 1 || i2 == 8 || i2 == 9) {
            return new RecyclerViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recyclerview_report_list, viewGroup, false), i2);
        }
        return null;
    }

    private void a(RecyclerViewHolder recyclerViewHolder, int i2) {
        String title = this.f1314f.get(i2 + 1).getTitle();
        if (!TextUtils.isEmpty(title)) {
            recyclerViewHolder.f1330c.setText(title);
        }
        List<List<DetailBean>> list = this.f1315g;
        if (list != null && list.get(i2) != null) {
            recyclerViewHolder.f1331d.setText(this.f1315g.get(i2).size() + "个");
        } else {
            recyclerViewHolder.f1331d.setText("0个");
        }
        if (i2 == 0) {
            recyclerViewHolder.f1332e.setVisibility(8);
        }
    }
}
