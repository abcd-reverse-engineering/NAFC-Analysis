package adapter;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import bean.VerifyAcceptBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hicorenational.antifraud.R;
import java.util.List;
import ui.activity.HandleIDVerifyActivity;
import util.k1;

/* loaded from: classes.dex */
public class IDVarfyAceptListAdapter extends BaseQuickAdapter<VerifyAcceptBean, BaseViewHolder> {
    private List<VerifyAcceptBean> V;

    public IDVarfyAceptListAdapter(List<VerifyAcceptBean> list) {
        super(R.layout.item_idvarfy_caept_list, list);
        this.V = list;
    }

    public void G() {
        this.V.clear();
        notifyDataSetChanged();
    }

    public void a(List<VerifyAcceptBean> list) {
        this.V.clear();
        this.V.addAll(list);
        notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void a(BaseViewHolder baseViewHolder, VerifyAcceptBean verifyAcceptBean) {
        TextView textView = (TextView) baseViewHolder.c(R.id.tv_name);
        TextView textView2 = (TextView) baseViewHolder.c(R.id.tv_id_num);
        TextView textView3 = (TextView) baseViewHolder.c(R.id.tv_idvarfy_time);
        textView.setText(verifyAcceptBean.getInitiatorName() + "向你发起了“身份核实”请求");
        textView2.setText(verifyAcceptBean.getIntivedMobile());
        textView3.setText("过期时间：" + verifyAcceptBean.getDeadline());
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(BaseViewHolder baseViewHolder, int i2) {
        super.onBindViewHolder((IDVarfyAceptListAdapter) baseViewHolder, i2);
        ImageView imageView = (ImageView) baseViewHolder.c(R.id.iv_check_id_new);
        final VerifyAcceptBean verifyAcceptBean = this.V.get(i2);
        if (verifyAcceptBean != null) {
            if (verifyAcceptBean.getIsLookover() == 1) {
                imageView.setVisibility(8);
            } else {
                imageView.setVisibility(0);
            }
        }
        baseViewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: adapter.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f1363a.a(verifyAcceptBean, view);
            }
        });
    }

    public /* synthetic */ void a(VerifyAcceptBean verifyAcceptBean, View view) {
        if (verifyAcceptBean != null) {
            Intent intent = new Intent(this.x, (Class<?>) HandleIDVerifyActivity.class);
            intent.putExtra(k1.c0, verifyAcceptBean.getVerificationLogID());
            intent.putExtra(k1.b0, verifyAcceptBean.getInitiatorName());
            this.x.startActivity(intent);
        }
    }
}
