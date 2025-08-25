package adapter;

import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;
import bean.AccountListBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hicorenational.antifraud.R;
import java.util.List;

/* loaded from: classes.dex */
public class PayStopSelAdapter extends BaseQuickAdapter<AccountListBean, BaseViewHolder> {
    public PayStopSelAdapter(int i2, List<AccountListBean> list) {
        super(i2, list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void a(BaseViewHolder baseViewHolder, AccountListBean accountListBean) {
        ImageView imageView = (ImageView) baseViewHolder.c(R.id.iv_select);
        TextView textView = (TextView) baseViewHolder.c(R.id.tv_suspect_type);
        TextView textView2 = (TextView) baseViewHolder.c(R.id.tv_suspect_account);
        baseViewHolder.a(R.id.tv_suspect_name, (CharSequence) accountListBean.getSuspectName());
        baseViewHolder.a(R.id.tv_time, (CharSequence) accountListBean.getPaymentTime());
        baseViewHolder.a(R.id.tv_transfer_money, (CharSequence) (accountListBean.getTransferAmount() + ""));
        baseViewHolder.a(R.id.iv_select);
        if (accountListBean.isSelect()) {
            imageView.setImageResource(R.mipmap.checkbox_checked_circle);
        } else {
            imageView.setImageResource(R.mipmap.checkbox_unchecked_circle);
        }
        if (TextUtils.isEmpty(accountListBean.getSuspectAccountTypeText())) {
            textView.setText(d.d.D);
        } else {
            textView.setText(accountListBean.getSuspectAccountTypeText());
        }
        if (TextUtils.isEmpty(accountListBean.getSuspectAccount())) {
            textView2.setText(d.d.D);
        } else {
            textView2.setText(accountListBean.getSuspectAccount());
        }
    }
}
