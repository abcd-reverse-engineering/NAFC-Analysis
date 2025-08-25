package adapter;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import bean.HomeNewCaseBean;
import com.hicorenational.antifraud.R;
import java.util.List;
import manager.AccountManager;
import manager.NotificationHelper;
import ui.Hicore;
import ui.activity.PromosWebDetActivity;
import util.k1;
import util.y1;

/* loaded from: classes.dex */
public class HomeNewCaseAdapter extends RecyclerView.Adapter<a> {

    /* renamed from: c, reason: collision with root package name */
    static final int f1286c = 2;

    /* renamed from: d, reason: collision with root package name */
    static final int f1287d = 3;

    /* renamed from: e, reason: collision with root package name */
    static final int f1288e = 4;

    /* renamed from: f, reason: collision with root package name */
    static final int f1289f = 6;

    /* renamed from: a, reason: collision with root package name */
    private Context f1290a;

    /* renamed from: b, reason: collision with root package name */
    private List<HomeNewCaseBean.RowsBean> f1291b;

    class a extends RecyclerView.ViewHolder {

        /* renamed from: a, reason: collision with root package name */
        public View f1292a;

        /* renamed from: b, reason: collision with root package name */
        public ImageView f1293b;

        /* renamed from: c, reason: collision with root package name */
        public TextView f1294c;

        /* renamed from: d, reason: collision with root package name */
        public TextView f1295d;

        /* renamed from: e, reason: collision with root package name */
        public View f1296e;

        public a(View view) {
            super(view);
            this.f1292a = view.findViewById(R.id.rl_type_topic);
            this.f1293b = (ImageView) view.findViewById(R.id.iv_topic_pic);
            this.f1294c = (TextView) view.findViewById(R.id.iv_topic_tit);
            this.f1295d = (TextView) view.findViewById(R.id.iv_topic_time);
            this.f1296e = view.findViewById(R.id.view_line);
        }
    }

    public HomeNewCaseAdapter(Context context, List<HomeNewCaseBean.RowsBean> list) {
        this.f1290a = context;
        this.f1291b = list;
    }

    private void b(a aVar, int i2) {
        final HomeNewCaseBean.RowsBean rowsBean = this.f1291b.get(i2);
        aVar.f1294c.setText(rowsBean.getTitle());
        String strA = y1.a(rowsBean.getReleaseTime());
        if (TextUtils.isEmpty(rowsBean.getAuthor())) {
            aVar.f1295d.setText("国家反诈中心  " + strA);
        } else {
            aVar.f1295d.setText(rowsBean.getAuthor() + "  " + strA);
        }
        aVar.f1293b.setVisibility(0);
        if (2 == rowsBean.getMterialType() || 3 == rowsBean.getMterialType() || 4 != rowsBean.getMterialType()) {
            j.d.a(rowsBean.getCdnCover(), aVar.f1293b);
        } else {
            aVar.f1293b.setVisibility(4);
        }
        if (TextUtils.isEmpty(rowsBean.getCdnCover())) {
            aVar.f1293b.setVisibility(4);
        }
        aVar.itemView.setOnClickListener(new View.OnClickListener() { // from class: adapter.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f1361a.a(rowsBean, view);
            }
        });
    }

    public List<HomeNewCaseBean.RowsBean> a() {
        return this.f1291b;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f1291b.size();
    }

    public void a(List<HomeNewCaseBean.RowsBean> list) {
        this.f1291b.clear();
        this.f1291b.addAll(list);
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public a onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_home_new_case, viewGroup, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(a aVar, int i2) {
        b(aVar, i2);
    }

    public /* synthetic */ void a(HomeNewCaseBean.RowsBean rowsBean, View view) {
        if (Hicore.getApp().isDouble()) {
            return;
        }
        Intent intent = new Intent(this.f1290a, (Class<?>) PromosWebDetActivity.class);
        intent.putExtra(k1.P, NotificationHelper.CHANEL_NAME);
        intent.putExtra(k1.Q, rowsBean.getLocalFilePath() + AccountManager.getShareParam());
        intent.putExtra(k1.T, rowsBean.getId());
        intent.putExtra(k1.U, 2);
        this.f1290a.startActivity(intent);
    }
}
