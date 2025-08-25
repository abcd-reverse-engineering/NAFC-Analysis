package adapter;

import android.content.Context;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import bean.DetailBean;
import com.hicorenational.antifraud.R;
import java.util.List;
import network.HistoryDetailInfo;

/* loaded from: classes.dex */
public class ReportDetailListAdapter extends RecyclerView.Adapter<ItemHolder> {

    /* renamed from: a, reason: collision with root package name */
    private final Context f1334a;

    /* renamed from: b, reason: collision with root package name */
    public int f1335b;

    /* renamed from: c, reason: collision with root package name */
    public int f1336c;

    /* renamed from: d, reason: collision with root package name */
    private List<List<DetailBean>> f1337d;

    public class ItemHolder extends RecyclerView.ViewHolder {

        /* renamed from: a, reason: collision with root package name */
        TextView f1338a;

        /* renamed from: b, reason: collision with root package name */
        TextView f1339b;

        /* renamed from: c, reason: collision with root package name */
        TextView f1340c;

        public ItemHolder(View view) {
            super(view);
            this.f1338a = (TextView) view.findViewById(R.id.tv_content);
            this.f1339b = (TextView) view.findViewById(R.id.item_time);
            this.f1340c = (TextView) view.findViewById(R.id.tv_desc);
            this.f1339b.setVisibility(8);
            this.f1340c.setVisibility(8);
        }
    }

    public ReportDetailListAdapter(Context context, List<List<DetailBean>> list, int i2, int i3) {
        this.f1334a = context;
        this.f1337d = list;
        this.f1336c = i2;
        this.f1335b = i3;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(ItemHolder itemHolder, int i2) {
        DetailBean detailBean = this.f1337d.get(this.f1336c).get(i2);
        if (this.f1335b == 1) {
            itemHolder.f1338a.setText(detailBean.getNumber());
            if (!TextUtils.isEmpty(detailBean.getOccurTime())) {
                itemHolder.f1339b.setVisibility(0);
                itemHolder.f1339b.setText(detailBean.getOccurTime());
            }
        }
        if (this.f1335b == 2) {
            itemHolder.f1339b.setVisibility(0);
            itemHolder.f1340c.setVisibility(0);
            itemHolder.f1338a.setText(detailBean.getNumber());
            itemHolder.f1340c.setText(detailBean.getContent());
            if (!TextUtils.isEmpty(detailBean.getOccurTime())) {
                itemHolder.f1339b.setVisibility(0);
                itemHolder.f1339b.setText(detailBean.getOccurTime());
            }
        }
        if (detailBean.getType() == 3) {
            itemHolder.f1338a.setText(detailBean.getFileName());
            if (detailBean.getOs() > 0) {
                itemHolder.f1338a.setText(Html.fromHtml(detailBean.getFileName() + "  <font color=#999999>(ios)</font>"));
            } else {
                itemHolder.f1338a.setText(Html.fromHtml(detailBean.getFileName() + "  <font color=#999999>(Android)</font>"));
            }
            String version = detailBean.getVersion();
            if (!TextUtils.isEmpty(version)) {
                itemHolder.f1339b.setVisibility(0);
                itemHolder.f1339b.setText("版本：" + version);
            }
            String downloadUrl = detailBean.getDownloadUrl();
            HistoryDetailInfo.AppInnerPicture appAuthorInfo = detailBean.getAppAuthorInfo();
            HistoryDetailInfo.AppInnerPicture downloadQRCode = detailBean.getDownloadQRCode();
            if (!TextUtils.isEmpty(downloadUrl)) {
                String str = "下载链接：" + downloadUrl;
                itemHolder.f1340c.setVisibility(0);
                if (appAuthorInfo != null && !TextUtils.isEmpty(appAuthorInfo.name)) {
                    str = str + "\r\n下载二维码：" + appAuthorInfo.name;
                }
                if (downloadQRCode != null && !TextUtils.isEmpty(downloadQRCode.name)) {
                    str = str + "\r\n应用开发者信息：" + downloadQRCode.name;
                }
                itemHolder.f1340c.setText(str);
            }
        }
        if (detailBean.getType() == 4) {
            itemHolder.f1338a.setText(detailBean.getFileName());
        }
        if (detailBean.getType() == 5) {
            itemHolder.f1338a.setText(detailBean.getFileName());
        }
        if (detailBean.getType() == 6) {
            itemHolder.f1338a.setText(detailBean.getFileName());
        }
        if (detailBean.getType() == 7) {
            itemHolder.f1338a.setText(detailBean.getFileName());
            itemHolder.f1339b.setText(detailBean.getOccurTime());
        }
        if (detailBean.getType() == 8) {
            itemHolder.f1338a.setText(detailBean.getAccountType() + "账号：" + detailBean.getAccount());
        }
        if (detailBean.getType() == 9) {
            itemHolder.f1338a.setText(detailBean.getAccountType() + "账户：" + detailBean.getAccount());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f1337d.get(this.f1336c).size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ItemHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new ItemHolder(LayoutInflater.from(this.f1334a).inflate(R.layout.report_group_sub_item, viewGroup, false));
    }
}
