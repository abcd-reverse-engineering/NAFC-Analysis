package adapter;

import bean.CaseDivisonBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hicorenational.antifraud.R;
import java.util.List;

/* loaded from: classes.dex */
public class PaymentTypeAdapter extends BaseQuickAdapter<CaseDivisonBean, BaseViewHolder> {
    public PaymentTypeAdapter(List<CaseDivisonBean> list) {
        super(R.layout.item_payment_type, list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void a(BaseViewHolder baseViewHolder, CaseDivisonBean caseDivisonBean) {
        baseViewHolder.a(R.id.tv_txet, (CharSequence) caseDivisonBean.getName()).a(R.id.tv_txet);
    }
}
