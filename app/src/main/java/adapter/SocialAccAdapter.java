package adapter;

import android.text.TextUtils;
import bean.SocialAccBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hicorenational.antifraud.R;
import java.util.List;

/* loaded from: classes.dex */
public class SocialAccAdapter extends BaseQuickAdapter<SocialAccBean, BaseViewHolder> {
    private List<SocialAccBean> V;
    private boolean W;

    public SocialAccAdapter(int i2, List<SocialAccBean> list) {
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

    public void a(List<SocialAccBean> list) {
        this.V.clear();
        this.V.addAll(list);
        notifyDataSetChanged();
    }

    public void a(int i2, SocialAccBean socialAccBean) {
        this.V.set(i2, socialAccBean);
        notifyItemChanged(i2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void a(BaseViewHolder baseViewHolder, SocialAccBean socialAccBean) {
        String accountName = socialAccBean.getAccountName();
        String accountNum = socialAccBean.getAccountNum();
        String accountOtherName = socialAccBean.getAccountOtherName();
        if (TextUtils.isEmpty(accountOtherName)) {
            accountOtherName = accountName;
        }
        baseViewHolder.a(R.id.tv_name, (CharSequence) accountOtherName);
        baseViewHolder.a(R.id.tv_acc_num, (CharSequence) accountNum);
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
