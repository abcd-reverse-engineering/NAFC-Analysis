package adapter;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import bean.CallBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hicorenational.antifraud.R;
import java.util.List;
import util.y1;

/* loaded from: classes.dex */
public class CallSelectNewAdapter extends BaseQuickAdapter<CallBean, BaseViewHolder> {
    private List<CallBean> V;
    private b W;

    class a implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ BaseViewHolder f1261a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ CallBean f1262b;

        a(BaseViewHolder baseViewHolder, CallBean callBean) {
            this.f1261a = baseViewHolder;
            this.f1262b = callBean;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (CallSelectNewAdapter.this.W != null) {
                CallSelectNewAdapter.this.W.a(this.f1261a.getAdapterPosition(), ((BaseQuickAdapter) CallSelectNewAdapter.this).A, this.f1262b);
            }
        }
    }

    public interface b {
        void a(int i2, List<CallBean> list, CallBean callBean);
    }

    public CallSelectNewAdapter(int i2, List<CallBean> list, List<CallBean> list2) {
        super(i2, list);
        this.V = list2;
    }

    public void setOnItemClickListener(b bVar) {
        this.W = bVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void a(BaseViewHolder baseViewHolder, CallBean callBean) {
        int type = callBean.getType();
        String place = callBean.getPlace();
        String number = callBean.getNumber();
        ImageView imageView = (ImageView) baseViewHolder.c(R.id.phone_status);
        if (type == 1) {
            baseViewHolder.g(R.id.tv_phone_num, this.x.getResources().getColor(R.color._030303));
            imageView.setVisibility(4);
        } else if (type == 2) {
            baseViewHolder.g(R.id.tv_phone_num, this.x.getResources().getColor(R.color._030303));
            imageView.setVisibility(0);
            com.bumptech.glide.b.e(this.x).a(Integer.valueOf(R.mipmap.received_call)).a(imageView);
        } else {
            baseViewHolder.g(R.id.tv_phone_num, this.x.getResources().getColor(R.color.missing_phone));
            imageView.setVisibility(0);
            com.bumptech.glide.b.e(this.x).a(Integer.valueOf(R.mipmap.missed_call)).a(imageView);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(type == 2 ? "呼出" : "呼入");
        sb.append(callBean.getTalkTime());
        baseViewHolder.a(R.id.tv_description, (CharSequence) sb.toString());
        if (TextUtils.isEmpty(place)) {
            place = y1.m(number);
        }
        baseViewHolder.a(R.id.tv_phone_num, (CharSequence) number).a(R.id.tv_place, (CharSequence) place).a(R.id.tv_date, (CharSequence) callBean.getCrime_time());
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(BaseViewHolder baseViewHolder, int i2) {
        super.onBindViewHolder((CallSelectNewAdapter) baseViewHolder, i2);
        CallBean callBean = (CallBean) this.A.get(i2);
        CallBean callBeanA = a(callBean);
        if (callBean.isSelect()) {
            ((ImageView) baseViewHolder.c(R.id.iv_checkbox)).setImageResource(R.mipmap.checkbox_checked);
        } else {
            ((ImageView) baseViewHolder.c(R.id.iv_checkbox)).setImageResource(R.mipmap.checkbox_unchecked);
        }
        baseViewHolder.itemView.setOnClickListener(new a(baseViewHolder, callBeanA));
    }

    private CallBean a(CallBean callBean) {
        List<CallBean> list = this.V;
        if (list == null || list.size() <= 0) {
            return null;
        }
        for (CallBean callBean2 : this.V) {
            if (TextUtils.equals(callBean.getNumber(), callBean2.getNumber()) && TextUtils.equals(callBean.getCrime_time(), callBean2.getCrime_time())) {
                callBean.setSelect(true);
                return callBean2;
            }
        }
        return null;
    }
}
