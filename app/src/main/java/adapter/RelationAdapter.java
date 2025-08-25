package adapter;

import bean.RelationBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hicorenational.antifraud.R;
import java.util.List;

/* loaded from: classes.dex */
public class RelationAdapter extends BaseQuickAdapter<RelationBean, BaseViewHolder> {
    private List<RelationBean> V;
    private boolean W;

    public RelationAdapter(int i2, List<RelationBean> list) {
        super(i2, list);
        this.V = list;
        this.W = false;
    }

    public void k(boolean z) {
        this.W = z;
    }

    public void m(int i2) {
        this.V.remove(i2);
        notifyDataSetChanged();
    }

    public void a(List<RelationBean> list) {
        this.V.clear();
        this.V.addAll(list);
        notifyDataSetChanged();
    }

    public void a(int i2, RelationBean relationBean) {
        this.V.set(i2, relationBean);
        notifyItemChanged(i2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void a(BaseViewHolder baseViewHolder, RelationBean relationBean) {
        String platformText = relationBean.getPlatformText();
        String suspectMobile = relationBean.getSuspectMobile();
        baseViewHolder.a(R.id.tv_name, (CharSequence) platformText);
        baseViewHolder.a(R.id.tv_acc_num, (CharSequence) suspectMobile);
        baseViewHolder.a(R.id.iv_edit);
        baseViewHolder.a(R.id.iv_delete);
        baseViewHolder.a(R.id.cl_item);
        if (this.W) {
            baseViewHolder.c(R.id.iv_edit).setVisibility(8);
            baseViewHolder.c(R.id.iv_delete).setVisibility(8);
            baseViewHolder.c(R.id.iv_arrow).setVisibility(0);
        }
    }
}
