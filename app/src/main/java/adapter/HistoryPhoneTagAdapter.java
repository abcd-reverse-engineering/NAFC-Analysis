package adapter;

import android.text.TextUtils;
import android.view.View;
import bean.TellNumHtyBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hicorenational.antifraud.R;
import java.util.List;
import util.h1;

/* loaded from: classes.dex */
public class HistoryPhoneTagAdapter extends BaseQuickAdapter<TellNumHtyBean, BaseViewHolder> {
    private List<TellNumHtyBean> V;

    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }

    public HistoryPhoneTagAdapter(int i2, List<TellNumHtyBean> list) {
        super(i2, list);
        this.V = list;
    }

    public void a(List<TellNumHtyBean> list) {
        this.V.clear();
        this.V.addAll(list);
        notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void a(BaseViewHolder baseViewHolder, TellNumHtyBean tellNumHtyBean) {
        String caseCategoryText = tellNumHtyBean.getCaseCategoryText();
        String number = tellNumHtyBean.getNumber();
        String strA = h1.a(number);
        String submitTime = tellNumHtyBean.getSubmitTime();
        if (TextUtils.isEmpty(caseCategoryText)) {
            caseCategoryText = "其他诈骗";
        }
        if (TextUtils.isEmpty(strA)) {
            strA = "未知";
        }
        baseViewHolder.a(R.id.tv_phone, (CharSequence) number);
        baseViewHolder.a(R.id.casecategory, (CharSequence) caseCategoryText);
        baseViewHolder.a(R.id.phone_type, (CharSequence) strA);
        baseViewHolder.a(R.id.report_time, (CharSequence) submitTime);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(BaseViewHolder baseViewHolder, int i2) {
        super.onBindViewHolder((HistoryPhoneTagAdapter) baseViewHolder, i2);
        baseViewHolder.itemView.setOnClickListener(new a());
    }
}
