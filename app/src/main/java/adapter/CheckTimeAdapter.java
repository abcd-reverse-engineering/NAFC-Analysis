package adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import bean.CheckTimeBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hicorenational.antifraud.R;
import java.util.List;

/* loaded from: classes.dex */
public class CheckTimeAdapter extends BaseQuickAdapter<CheckTimeBean, BaseViewHolder> {
    private b V;

    class a implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ BaseViewHolder f1264a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f1265b;

        a(BaseViewHolder baseViewHolder, int i2) {
            this.f1264a = baseViewHolder;
            this.f1265b = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (CheckTimeAdapter.this.V != null) {
                CheckTimeAdapter.this.V.onItemClickListener(this.f1264a.getAdapterPosition(), ((BaseQuickAdapter) CheckTimeAdapter.this).A);
            }
            for (int i2 = 0; i2 < ((BaseQuickAdapter) CheckTimeAdapter.this).A.size(); i2++) {
                if (i2 == this.f1265b) {
                    ((CheckTimeBean) ((BaseQuickAdapter) CheckTimeAdapter.this).A.get(i2)).setSelect(true);
                } else {
                    ((CheckTimeBean) ((BaseQuickAdapter) CheckTimeAdapter.this).A.get(i2)).setSelect(false);
                }
            }
            CheckTimeAdapter.this.notifyDataSetChanged();
        }
    }

    public interface b {
        void onItemClickListener(int i2, List<CheckTimeBean> list);
    }

    public CheckTimeAdapter(int i2, List<CheckTimeBean> list) {
        super(i2, list);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void setNewData(List<CheckTimeBean> list) {
        this.A = list;
        notifyDataSetChanged();
    }

    public void setOnItemClickListener(b bVar) {
        this.V = bVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void a(BaseViewHolder baseViewHolder, CheckTimeBean checkTimeBean) {
        TextView textView = (TextView) baseViewHolder.c(R.id.content);
        ImageView imageView = (ImageView) baseViewHolder.c(R.id.img);
        textView.setText(checkTimeBean.getContent());
        if (checkTimeBean.isSelect()) {
            textView.setTextColor(this.x.getResources().getColor(R.color._4966FF));
            imageView.setVisibility(0);
        } else {
            textView.setTextColor(this.x.getResources().getColor(R.color.black_dark));
            imageView.setVisibility(8);
        }
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(BaseViewHolder baseViewHolder, int i2) {
        super.onBindViewHolder((CheckTimeAdapter) baseViewHolder, i2);
        baseViewHolder.itemView.setOnClickListener(new a(baseViewHolder, i2));
    }
}
