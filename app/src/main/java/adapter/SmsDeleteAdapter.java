package adapter;

import android.text.TextUtils;
import bean.SmsBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hicorenational.antifraud.R;
import java.util.List;

/* loaded from: classes.dex */
public class SmsDeleteAdapter extends BaseQuickAdapter<SmsBean, BaseViewHolder> {
    public SmsDeleteAdapter(int i2, List<SmsBean> list) {
        super(i2, list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void a(BaseViewHolder baseViewHolder, SmsBean smsBean) {
        baseViewHolder.a(R.id.tv_sms_phone, (CharSequence) smsBean.getSmsNum()).a(R.id.tv_time, (CharSequence) smsBean.getStringDate()).a(R.id.tv_sms_content, (CharSequence) smsBean.getSmsContent()).a(R.id.iv_edit).a(R.id.iv_clear);
        if (TextUtils.isEmpty(smsBean.getVictimTel())) {
            baseViewHolder.c(R.id.group_victim).setVisibility(8);
            return;
        }
        baseViewHolder.c(R.id.group_victim).setVisibility(0);
        baseViewHolder.a(R.id.tv_victim_phone, (CharSequence) ("收件人:" + smsBean.getVictimTel()));
    }
}
