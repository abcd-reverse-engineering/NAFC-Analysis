package adapter;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import bean.SmsBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hicorenational.antifraud.R;
import java.util.List;

/* loaded from: classes.dex */
public class SmsSelectAdapter extends BaseQuickAdapter<SmsBean, BaseViewHolder> {
    private List<SmsBean> V;
    private List<SmsBean> W;
    private b X;

    class a implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ BaseViewHolder f1355a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ SmsBean f1356b;

        a(BaseViewHolder baseViewHolder, SmsBean smsBean) {
            this.f1355a = baseViewHolder;
            this.f1356b = smsBean;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (SmsSelectAdapter.this.X != null) {
                SmsSelectAdapter.this.X.a(this.f1355a.getAdapterPosition(), SmsSelectAdapter.this.V, this.f1356b);
            }
        }
    }

    public interface b {
        void a(int i2, List<SmsBean> list, SmsBean smsBean);
    }

    public SmsSelectAdapter(int i2, List<SmsBean> list, List<SmsBean> list2) {
        super(i2, list);
        this.V = list;
        this.W = list2;
    }

    public void setOnItemClickListener(b bVar) {
        this.X = bVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void a(BaseViewHolder baseViewHolder, SmsBean smsBean) {
        baseViewHolder.a(R.id.tv_sms_phone, (CharSequence) smsBean.getSmsNum()).a(R.id.tv_sms_content, (CharSequence) smsBean.getSmsContent()).a(R.id.tv_sms_date, (CharSequence) smsBean.getStringDate());
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(BaseViewHolder baseViewHolder, int i2) {
        super.onBindViewHolder((SmsSelectAdapter) baseViewHolder, i2);
        SmsBean smsBean = this.V.get(baseViewHolder.getAdapterPosition());
        SmsBean smsBeanA = a(smsBean);
        if (smsBean.isSelect()) {
            ((ImageView) baseViewHolder.c(R.id.iv_checkbox)).setImageResource(R.mipmap.checkbox_checked);
        } else {
            ((ImageView) baseViewHolder.c(R.id.iv_checkbox)).setImageResource(R.mipmap.checkbox_unchecked);
        }
        baseViewHolder.itemView.setOnClickListener(new a(baseViewHolder, smsBeanA));
    }

    private SmsBean a(SmsBean smsBean) {
        List<SmsBean> list = this.W;
        if (list == null || list.size() <= 0) {
            return null;
        }
        for (SmsBean smsBean2 : this.W) {
            if (TextUtils.equals(smsBean.getSmsNum(), smsBean2.getSmsNum()) && TextUtils.equals(smsBean.getStringDate(), smsBean2.getStringDate())) {
                smsBean.setSelect(true);
                return smsBean2;
            }
        }
        return null;
    }
}
