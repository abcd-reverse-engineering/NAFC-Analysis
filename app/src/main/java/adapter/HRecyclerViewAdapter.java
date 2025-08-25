package adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.hicorenational.antifraud.R;
import util.c1;

/* loaded from: classes.dex */
public class HRecyclerViewAdapter extends RecyclerView.Adapter<HImageHolder> {

    /* renamed from: f, reason: collision with root package name */
    private static String[] f1269f;

    /* renamed from: g, reason: collision with root package name */
    private static int[] f1270g;

    /* renamed from: a, reason: collision with root package name */
    private Context f1271a;

    /* renamed from: b, reason: collision with root package name */
    private int f1272b;

    /* renamed from: c, reason: collision with root package name */
    private a f1273c;

    /* renamed from: d, reason: collision with root package name */
    private int f1274d;

    /* renamed from: e, reason: collision with root package name */
    private int f1275e = R.drawable.iv_share_download;

    public class HImageHolder extends RecyclerView.ViewHolder {

        /* renamed from: a, reason: collision with root package name */
        public FrameLayout f1276a;

        /* renamed from: b, reason: collision with root package name */
        public ImageView f1277b;

        /* renamed from: c, reason: collision with root package name */
        public TextView f1278c;

        public HImageHolder(View view) {
            super(view);
            this.f1276a = (FrameLayout) view.findViewById(R.id.fl_share_item);
            this.f1277b = (ImageView) view.findViewById(R.id.image);
            this.f1278c = (TextView) view.findViewById(R.id.tv_name);
            if (HRecyclerViewAdapter.this.f1272b == 5) {
                HRecyclerViewAdapter.this.a(this.f1276a);
            }
        }
    }

    public interface a {
        void a(int i2, String str);
    }

    public HRecyclerViewAdapter(Context context, int i2) {
        this.f1274d = context.getResources().getDisplayMetrics().widthPixels;
        this.f1271a = context;
        this.f1272b = i2;
        if (this.f1272b == 5) {
            f1269f = new String[]{"微信好友", "QQ好友", "钉钉", "复制链接"};
            f1270g = new int[]{R.drawable.iv_share_wx, R.drawable.iv_login_qq, R.drawable.iv_share_dding, R.drawable.iv_share_copy};
        } else {
            f1269f = new String[]{"微信好友", "朋友圈", "QQ好友", "QQ空间", "微博", "钉钉", "复制链接"};
            f1270g = new int[]{R.drawable.iv_share_wx, R.drawable.iv_share_wxcicle, R.drawable.iv_login_qq, R.drawable.iv_share_qzone, R.drawable.iv_share_sina, R.drawable.iv_share_dding, R.drawable.iv_share_copy};
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return f1269f.length;
    }

    public void setOnItemClickListener(a aVar) {
        this.f1273c = aVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public HImageHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new HImageHolder(LayoutInflater.from(this.f1271a).inflate(R.layout.item_hrecyclerview, viewGroup, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(final HImageHolder hImageHolder, final int i2) {
        hImageHolder.f1278c.setText(f1269f[i2]);
        hImageHolder.f1277b.setImageResource(f1270g[i2]);
        if (this.f1272b == 1 && i2 == f1269f.length - 1) {
            hImageHolder.f1278c.setText("生成海报");
            hImageHolder.f1277b.setImageResource(this.f1275e);
        }
        if (this.f1273c != null) {
            hImageHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: adapter.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f1358a.a(hImageHolder, i2, view);
                }
            });
        }
    }

    public /* synthetic */ void a(HImageHolder hImageHolder, int i2, View view) {
        this.f1273c.a(hImageHolder.getLayoutPosition(), f1269f[i2]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(FrameLayout frameLayout) {
        ViewGroup.LayoutParams layoutParams = frameLayout.getLayoutParams();
        layoutParams.width = (this.f1274d - c1.a(this.f1271a, 16.0f)) / f1269f.length;
        frameLayout.setLayoutParams(layoutParams);
    }
}
