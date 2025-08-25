package adapter;

import android.widget.ImageView;
import android.widget.TextView;
import bean.IDVarfyBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hicorenational.antifraud.R;
import java.util.List;

/* loaded from: classes.dex */
public class IDVarfyListAdapter extends BaseQuickAdapter<IDVarfyBean.Rows, BaseViewHolder> {
    private List<IDVarfyBean.Rows> V;

    public IDVarfyListAdapter(List<IDVarfyBean.Rows> list) {
        super(R.layout.item_idvarfy_list, list);
        this.V = list;
    }

    public void a(List<IDVarfyBean.Rows> list) {
        this.V.clear();
        this.V.addAll(list);
        notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void a(BaseViewHolder baseViewHolder, IDVarfyBean.Rows rows) {
        TextView textView = (TextView) baseViewHolder.c(R.id.tv_id_num);
        TextView textView2 = (TextView) baseViewHolder.c(R.id.tv_idvarfy_time);
        ImageView imageView = (ImageView) baseViewHolder.c(R.id.iv_state);
        textView.setText(rows.getIntivedMobile());
        if (rows.getVerifyStatus() == 0) {
            textView2.setText("过期时间：" + rows.getDeadline());
            imageView.setBackgroundResource(R.drawable.iv_idvarfy_wait);
            return;
        }
        if (rows.getVerifyStatus() == 1) {
            textView2.setText("核实时间：" + rows.getVerifyTime());
            imageView.setBackgroundResource(R.drawable.iv_idvarfy_ok);
            return;
        }
        if (rows.getVerifyStatus() == 2) {
            textView2.setText("过期时间：" + rows.getDeadline());
            imageView.setBackgroundResource(R.drawable.iv_idvarfy_gq);
        }
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(BaseViewHolder baseViewHolder, int i2) {
        super.onBindViewHolder((IDVarfyListAdapter) baseViewHolder, i2);
    }
}
