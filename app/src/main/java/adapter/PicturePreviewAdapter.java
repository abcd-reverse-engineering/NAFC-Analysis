package adapter;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import bean.UploadFileBean;
import com.hicorenational.antifraud.R;
import com.luck.picture.lib.entity.LocalMedia;
import java.util.ArrayList;
import java.util.List;
import ui.activity.PreviewPictureActivity;

/* loaded from: classes.dex */
public class PicturePreviewAdapter extends RecyclerView.Adapter<ListiewHolder> {

    /* renamed from: a, reason: collision with root package name */
    private Context f1298a;

    /* renamed from: b, reason: collision with root package name */
    private List<UploadFileBean> f1299b;

    /* renamed from: c, reason: collision with root package name */
    private ArrayList<LocalMedia> f1300c = new ArrayList<>();

    public class ListiewHolder extends RecyclerView.ViewHolder {

        /* renamed from: a, reason: collision with root package name */
        public ImageView f1301a;

        public ListiewHolder(View view) {
            super(view);
            this.f1301a = (ImageView) view.findViewById(R.id.picture_select);
        }
    }

    public PicturePreviewAdapter(Context context, List<UploadFileBean> list) {
        this.f1299b = new ArrayList();
        this.f1298a = context;
        if (this.f1299b != null) {
            this.f1299b = list;
            a();
        }
    }

    private void a() {
        for (int i2 = 0; i2 < this.f1299b.size(); i2++) {
            LocalMedia localMedia = new LocalMedia();
            String fileUrl = this.f1299b.get(i2).getFileUrl();
            if (TextUtils.isEmpty(fileUrl)) {
                localMedia.setPath(this.f1299b.get(i2).getFilePath());
            } else {
                localMedia.setPath(fileUrl);
            }
            localMedia.setFileName(this.f1299b.get(i2).getFileName());
            this.f1300c.add(localMedia);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f1299b.size();
    }

    public void setData(List<UploadFileBean> list) {
        this.f1299b = list;
        a();
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ListiewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new ListiewHolder(LayoutInflater.from(this.f1298a).inflate(R.layout.item_picture, viewGroup, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(ListiewHolder listiewHolder, final int i2) {
        UploadFileBean uploadFileBean;
        if (this.f1299b.size() > 0 && (uploadFileBean = this.f1299b.get(i2)) != null) {
            if (!TextUtils.isEmpty(uploadFileBean.getFileUrl())) {
                j.d.a(this.f1298a, uploadFileBean.getFileUrl(), listiewHolder.f1301a, 4);
            } else if (!TextUtils.isEmpty(uploadFileBean.getFilePath())) {
                j.d.a(this.f1298a, uploadFileBean.getFilePath(), listiewHolder.f1301a, 4);
            }
        }
        listiewHolder.f1301a.setOnClickListener(new View.OnClickListener() { // from class: adapter.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f1365a.a(i2, view);
            }
        });
    }

    public /* synthetic */ void a(int i2, View view) {
        Intent intent = new Intent(this.f1298a, (Class<?>) PreviewPictureActivity.class);
        intent.putParcelableArrayListExtra(PreviewPictureActivity.f18539f, this.f1300c);
        intent.putExtra(PreviewPictureActivity.f18540g, i2);
        this.f1298a.startActivity(intent);
    }
}
