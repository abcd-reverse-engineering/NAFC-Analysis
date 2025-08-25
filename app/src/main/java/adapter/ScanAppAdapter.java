package adapter;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import bean.AppInfoBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hicorenational.antifraud.R;

/* loaded from: classes.dex */
public class ScanAppAdapter extends BaseQuickAdapter<AppInfoBean, BaseViewHolder> {
    public ScanAppAdapter(int i2) {
        super(i2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void a(BaseViewHolder baseViewHolder, AppInfoBean appInfoBean) {
        try {
            baseViewHolder.a(R.id.tv_app_name, (CharSequence) appInfoBean.getName());
            ImageView imageView = (ImageView) baseViewHolder.c(R.id.app_icon);
            Drawable appIcon = appInfoBean.getAppIcon();
            if (appIcon != null) {
                imageView.setBackground(appIcon);
                imageView.setVisibility(0);
            } else {
                imageView.setVisibility(8);
            }
            ImageView imageView2 = (ImageView) baseViewHolder.c(R.id.scan_state);
            int virusLevel = appInfoBean.getVirusLevel();
            if (virusLevel == 0) {
                j.d.b(imageView2, Integer.valueOf(R.mipmap.ic_scan_ok));
                return;
            }
            if (virusLevel != 2 && virusLevel != 1) {
                j.d.a(imageView2, Integer.valueOf(R.mipmap.ic_scan_loading));
                return;
            }
            j.d.b(imageView2, Integer.valueOf(R.mipmap.ic_scan_risk));
        } catch (Exception unused) {
        }
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(BaseViewHolder baseViewHolder, int i2) {
        super.onBindViewHolder((ScanAppAdapter) baseViewHolder, i2);
    }
}
