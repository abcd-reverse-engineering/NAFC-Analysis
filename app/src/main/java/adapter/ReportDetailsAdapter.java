package adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import bean.DetailBean;
import com.hicorenational.antifraud.R;
import java.util.List;
import network.HistoryDetailInfo;

/* loaded from: classes.dex */
public class ReportDetailsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* renamed from: a, reason: collision with root package name */
    public Typeface f1342a;

    /* renamed from: b, reason: collision with root package name */
    private final Context f1343b;

    /* renamed from: c, reason: collision with root package name */
    private final List<HistoryDetailInfo> f1344c;

    /* renamed from: d, reason: collision with root package name */
    private List<List<DetailBean>> f1345d;

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: a, reason: collision with root package name */
        public int f1346a;

        /* renamed from: b, reason: collision with root package name */
        public TextView f1347b;

        /* renamed from: c, reason: collision with root package name */
        public TextView f1348c;

        /* renamed from: d, reason: collision with root package name */
        public View f1349d;

        public RecyclerViewHolder(View view, int i2) {
            super(view);
            this.f1346a = i2;
            this.f1347b = (TextView) view.findViewById(R.id.group_report);
            this.f1348c = (TextView) view.findViewById(R.id.group_report_count);
            this.f1349d = view.findViewById(R.id.item_line);
        }
    }

    public ReportDetailsAdapter(Typeface typeface, Context context, List<HistoryDetailInfo> list, List<List<DetailBean>> list2) {
        this.f1343b = context;
        this.f1342a = typeface;
        this.f1344c = list;
        this.f1345d = list2;
    }

    private void a(RecyclerViewHolder recyclerViewHolder, int i2) {
        recyclerViewHolder.f1349d.setVisibility(8);
        String title = this.f1344c.get(i2).getTitle();
        if (!TextUtils.isEmpty(title)) {
            recyclerViewHolder.f1347b.setText(title);
        }
        List<List<DetailBean>> list = this.f1345d;
        if (list == null || list.get(i2) == null) {
            recyclerViewHolder.f1348c.setText("0个");
            return;
        }
        recyclerViewHolder.f1348c.setText(this.f1345d.get(i2).size() + "个");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f1344c.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i2) {
        a((RecyclerViewHolder) viewHolder, i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new RecyclerViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recyclerview_report_list, viewGroup, false), i2);
    }
}
