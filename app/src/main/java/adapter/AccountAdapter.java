package adapter;

import android.text.TextUtils;
import android.widget.TextView;
import bean.AccountListBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hicorenational.antifraud.R;
import java.util.List;

/* loaded from: classes.dex */
public class AccountAdapter extends BaseQuickAdapter<AccountListBean, BaseViewHolder> {
    public AccountAdapter(int i2, List<AccountListBean> list) {
        super(i2, list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void a(BaseViewHolder baseViewHolder, AccountListBean accountListBean) {
        TextView textView = (TextView) baseViewHolder.c(R.id.tv_suspect_type);
        TextView textView2 = (TextView) baseViewHolder.c(R.id.tv_suspect_account);
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
        baseViewHolder.a(R.id.tv_time, (CharSequence) accountListBean.getPaymentTime());
        baseViewHolder.a(R.id.tv_trans, (CharSequence) accountListBean.getPaymentTypeText());
        baseViewHolder.a(R.id.iv_clear);
    }
}
