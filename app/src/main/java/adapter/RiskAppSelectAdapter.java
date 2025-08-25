package adapter;

import android.graphics.drawable.Drawable;
import android.text.format.Formatter;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import bean.AppInfoBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hicorenational.antifraud.R;
import java.util.List;
import ui.Hicore;

/* loaded from: classes.dex */
public class RiskAppSelectAdapter extends BaseQuickAdapter<AppInfoBean, BaseViewHolder> {
    private List<AppInfoBean> V;
    private b W;

    class a implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ BaseViewHolder f1351a;

        a(BaseViewHolder baseViewHolder) {
            this.f1351a = baseViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (RiskAppSelectAdapter.this.W != null) {
                RiskAppSelectAdapter.this.W.onItemClickListener(this.f1351a.getAdapterPosition(), RiskAppSelectAdapter.this.V);
            }
        }
    }

    public interface b {
        void onItemClickListener(int i2, List<AppInfoBean> list);
    }

    public RiskAppSelectAdapter(int i2, List<AppInfoBean> list) {
        super(i2, list);
        this.V = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void setNewData(List<AppInfoBean> list) {
        this.V = list;
        this.A = list;
        notifyDataSetChanged();
    }

    public void setOnItemClickListener(b bVar) {
        this.W = bVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void a(BaseViewHolder baseViewHolder, AppInfoBean appInfoBean) {
        String str;
        String str2;
        Drawable appIcon = appInfoBean.getAppIcon();
        if (appIcon != null) {
            baseViewHolder.a(R.id.app_icon, appIcon);
        }
        baseViewHolder.a(R.id.iv_checkbox);
        Formatter.formatFileSize(Hicore.getApp(), appInfoBean.getFileSize());
        TextView textView = (TextView) baseViewHolder.c(R.id.tv_level);
        if (appInfoBean.getVirusLevel() == 1) {
            textView.setTextColor(this.x.getResources().getColor(R.color.colorRedRiskFlag));
            textView.setBackgroundResource(R.drawable.shape_red);
            str = "高危";
        } else {
            textView.setTextColor(this.x.getResources().getColor(R.color.dark_orange));
            textView.setBackgroundResource(R.drawable.shape_orange);
            str = "风险";
        }
        if (appInfoBean.isTypeIsApp()) {
            str2 = str + "应用";
        } else {
            str2 = str + "安装包";
        }
        textView.setText(str2);
        baseViewHolder.a(R.id.tv_app_name, (CharSequence) appInfoBean.getName()).a(R.id.tv_app_version, (CharSequence) ("(版本:" + appInfoBean.getVersionCode() + " )")).a(R.id.app_icon, appInfoBean.getAppIcon());
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(BaseViewHolder baseViewHolder, int i2) {
        super.onBindViewHolder((RiskAppSelectAdapter) baseViewHolder, i2);
        ImageView imageView = (ImageView) baseViewHolder.c(R.id.iv_checkbox);
        try {
            AppInfoBean appInfoBean = this.V.get(baseViewHolder.getAdapterPosition());
            if (appInfoBean.getFileSize() > 209715200) {
                imageView.setImageResource(R.mipmap.checkbox_unchecked_circle);
                imageView.setBackgroundColor(this.x.getResources().getColor(R.color.colorGray));
            } else if (appInfoBean.isSelect()) {
                imageView.setImageResource(R.mipmap.checkbox_checked_circle);
            } else {
                imageView.setImageResource(R.mipmap.checkbox_unchecked_circle);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        baseViewHolder.itemView.setOnClickListener(new a(baseViewHolder));
    }
}
