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
public class CallSelectAdapter extends BaseQuickAdapter<CallBean, BaseViewHolder> {
    private List<CallBean> V;
    private List<CallBean> W;
    private b X;

    class a implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ BaseViewHolder f1258a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ CallBean f1259b;

        a(BaseViewHolder baseViewHolder, CallBean callBean) {
            this.f1258a = baseViewHolder;
            this.f1259b = callBean;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (CallSelectAdapter.this.X != null) {
                CallSelectAdapter.this.X.a(this.f1258a.getAdapterPosition(), CallSelectAdapter.this.V, this.f1259b);
            }
        }
    }

    public interface b {
        void a(int i2, List<CallBean> list, CallBean callBean);
    }

    public CallSelectAdapter(int i2, List<CallBean> list, List<CallBean> list2) {
        super(i2, list);
        this.V = list;
        this.W = list2;
    }

    public void setOnItemClickListener(b bVar) {
        this.X = bVar;
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
        if (TextUtils.isEmpty(place)) {
            place = y1.m(number);
        }
        baseViewHolder.a(R.id.tv_phone_num, (CharSequence) number).a(R.id.tv_place, (CharSequence) place).a(R.id.tv_date, (CharSequence) callBean.getCrime_time());
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(BaseViewHolder baseViewHolder, int i2) {
        super.onBindViewHolder((CallSelectAdapter) baseViewHolder, i2);
        CallBean callBean = this.V.get(baseViewHolder.getAdapterPosition());
        CallBean callBeanA = a(callBean);
        if (callBean.isSelect()) {
            ((ImageView) baseViewHolder.c(R.id.iv_checkbox)).setImageResource(R.mipmap.checkbox_checked);
        } else {
            ((ImageView) baseViewHolder.c(R.id.iv_checkbox)).setImageResource(R.mipmap.checkbox_unchecked);
        }
        baseViewHolder.itemView.setOnClickListener(new a(baseViewHolder, callBeanA));
    }

    private CallBean a(CallBean callBean) {
        List<CallBean> list = this.W;
        if (list == null || list.size() <= 0) {
            return null;
        }
        for (CallBean callBean2 : this.W) {
            if (TextUtils.equals(callBean.getNumber(), callBean2.getNumber()) && TextUtils.equals(callBean.getCrime_time(), callBean2.getCrime_time())) {
                callBean.setSelect(true);
                return callBean2;
            }
        }
        return null;
    }
}
