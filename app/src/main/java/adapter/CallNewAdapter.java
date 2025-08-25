package adapter;

import android.text.TextUtils;
import bean.CallBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hicorenational.antifraud.R;
import java.util.List;

/* loaded from: classes.dex */
public class CallNewAdapter extends BaseQuickAdapter<CallBean, BaseViewHolder> {
    public CallNewAdapter(int i2, List<CallBean> list) {
        super(i2, list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void a(BaseViewHolder baseViewHolder, CallBean callBean) {
        baseViewHolder.a(R.id.tv_phone, (CharSequence) callBean.getNumber()).a(R.id.tv_occur_time, (CharSequence) callBean.getCrime_time()).a(R.id.tv_duration, (CharSequence) callBean.getTalkTime()).a(R.id.iv_edit).a(R.id.iv_clear);
        if (TextUtils.isEmpty(callBean.getVictimTel())) {
            baseViewHolder.c(R.id.group_victim).setVisibility(8);
        } else {
            baseViewHolder.c(R.id.group_victim).setVisibility(0);
            baseViewHolder.a(R.id.tv_victim_phone, (CharSequence) callBean.getVictimTel());
        }
    }
}
