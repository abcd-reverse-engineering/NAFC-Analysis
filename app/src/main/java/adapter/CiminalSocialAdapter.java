package adapter;

import bean.CriminalSocialBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hicorenational.antifraud.R;
import java.util.List;

/* loaded from: classes.dex */
public class CiminalSocialAdapter extends BaseQuickAdapter<CriminalSocialBean, BaseViewHolder> {
    private boolean V;

    public CiminalSocialAdapter(int i2, List<CriminalSocialBean> list) {
        super(i2, list);
        this.V = false;
    }

    public void k(boolean z) {
        this.V = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void a(BaseViewHolder baseViewHolder, CriminalSocialBean criminalSocialBean) {
        String platformText = criminalSocialBean.getPlatformText();
        String suspectAccount = criminalSocialBean.getSuspectAccount();
        baseViewHolder.a(R.id.tv_name, (CharSequence) platformText);
        baseViewHolder.a(R.id.tv_acc_num, (CharSequence) suspectAccount);
        baseViewHolder.a(R.id.iv_edit);
        baseViewHolder.a(R.id.iv_delete);
        baseViewHolder.a(R.id.cl_item);
        if (this.V) {
            baseViewHolder.c(R.id.iv_edit).setVisibility(8);
            baseViewHolder.c(R.id.iv_delete).setVisibility(8);
            baseViewHolder.c(R.id.iv_arrow).setVisibility(0);
        }
    }
}
