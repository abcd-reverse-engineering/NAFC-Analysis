package adapter;

import bean.CallBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hicorenational.antifraud.R;
import java.util.List;

/* loaded from: classes.dex */
public class SignCallAdapter extends BaseQuickAdapter<CallBean, BaseViewHolder> {
    public SignCallAdapter(int i2, List<CallBean> list) {
        super(i2, list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void a(BaseViewHolder baseViewHolder, CallBean callBean) {
        baseViewHolder.c(R.id.group_victim).setVisibility(0);
        baseViewHolder.a(R.id.tv_phone, (CharSequence) callBean.getSuspectMobile()).a(R.id.tv_phone_type, (CharSequence) callBean.getSwindleTelTypeText()).a(R.id.tv_victim_phone, (CharSequence) callBean.getVictimMobile()).a(R.id.tv_occur_time, (CharSequence) callBean.getTalkTime()).a(R.id.tv_duration, (CharSequence) callBean.getCallDuration()).a(R.id.cl_item);
    }
}
