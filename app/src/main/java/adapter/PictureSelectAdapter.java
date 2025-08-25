package adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import bean.UploadStateInfo;
import cn.jzvd.JzvdStd;
import cn.jzvd.y;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hicorenational.antifraud.R;
import com.luck.picture.lib.config.PictureSelectionConfig;
import com.luck.picture.lib.engine.ImageEngine;
import com.luck.picture.lib.entity.LocalMedia;
import java.util.List;
import ui.Hicore;
import util.y1;

/* loaded from: classes.dex */
public class PictureSelectAdapter extends BaseQuickAdapter<LocalMedia, BaseViewHolder> {
    public static final String b0 = "style_item_video";
    public static final String c0 = "style_item_picture";
    static final int d0 = 0;
    static final int e0 = 1;
    private List<LocalMedia> V;
    private b W;
    private boolean X;
    private String Y;
    private int Z;
    List<UploadStateInfo> a0;

    class a implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ BaseViewHolder f1303a;

        a(BaseViewHolder baseViewHolder) {
            this.f1303a = baseViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                if (PictureSelectAdapter.this.W != null) {
                    PictureSelectAdapter.this.W.onItemClickListener(this.f1303a.getAdapterPosition(), PictureSelectAdapter.this.V);
                }
            } catch (Exception unused) {
            }
        }
    }

    public interface b {
        void onItemClickListener(int i2, List<LocalMedia> list);
    }

    public PictureSelectAdapter(int i2, List<LocalMedia> list) {
        super(i2, list);
        this.X = true;
        this.Y = "";
        this.Z = 9;
        this.V = list;
    }

    private void c(BaseViewHolder baseViewHolder, LocalMedia localMedia) {
        baseViewHolder.a(R.id.iv_clear);
        JzvdStd jzvdStd = (JzvdStd) baseViewHolder.c(R.id.image_view);
        ImageView imageView = (ImageView) baseViewHolder.c(R.id.iv_foot);
        ImageView imageView2 = (ImageView) baseViewHolder.c(R.id.iv_clear);
        TextView textView = (TextView) baseViewHolder.c(R.id.tv_video_duration);
        TextView textView2 = (TextView) baseViewHolder.c(R.id.tv_upload_state);
        if (localMedia == null) {
            imageView2.setVisibility(8);
            textView2.setVisibility(8);
            textView.setVisibility(8);
            jzvdStd.setVisibility(4);
            imageView.setVisibility(0);
            return;
        }
        try {
            if (this.a0 != null) {
                int iIndexOf = this.V.indexOf(localMedia);
                int size = this.a0.size();
                if (size > 0 && iIndexOf < size) {
                    a(textView2, this.a0.get(iIndexOf));
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        String path = localMedia.getPath();
        imageView2.setVisibility(0);
        textView2.setVisibility(0);
        jzvdStd.setVisibility(0);
        textView.setVisibility(0);
        imageView.setVisibility(8);
        ImageEngine imageEngine = PictureSelectionConfig.imageEngine;
        if (imageEngine != null) {
            imageEngine.loadGridImage(this.x, path, jzvdStd.E0);
        }
        if (localMedia.getDuration() <= 0) {
            textView.setText(y.a(y1.b(this.x, localMedia.getPath())));
        } else {
            textView.setText(y.a(localMedia.getDuration()));
        }
        jzvdStd.a(path, "", 0);
        jzvdStd.n.setVisibility(4);
        jzvdStd.q.setVisibility(4);
        jzvdStd.p.setVisibility(8);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        int size = this.V.size();
        return (!this.X || size >= this.Z) ? size : size + 1;
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i2) {
        if (this.X) {
            int size = this.V.size();
            if (i2 + 1 == getItemCount() && size < this.Z + 1) {
                return 1;
            }
        }
        return 0;
    }

    public void k(boolean z) {
        this.X = z;
    }

    public void setOnItemClickListener(b bVar) {
        this.W = bVar;
    }

    private void b(BaseViewHolder baseViewHolder, LocalMedia localMedia) {
        baseViewHolder.a(R.id.iv_clear);
        ImageView imageView = (ImageView) baseViewHolder.c(R.id.picture_select);
        ImageView imageView2 = (ImageView) baseViewHolder.c(R.id.picture_foot);
        ImageView imageView3 = (ImageView) baseViewHolder.c(R.id.iv_clear);
        TextView textView = (TextView) baseViewHolder.c(R.id.tv_upload_state);
        if (localMedia == null) {
            imageView3.setVisibility(8);
            imageView.setVisibility(8);
            textView.setVisibility(8);
            imageView2.setVisibility(0);
            return;
        }
        imageView2.setVisibility(8);
        try {
            if (this.a0 != null) {
                int iIndexOf = this.V.indexOf(localMedia);
                int size = this.a0.size();
                if (size > 0 && iIndexOf < size) {
                    a(textView, this.a0.get(iIndexOf));
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        String path = localMedia.getPath();
        imageView3.setVisibility(0);
        imageView.setVisibility(0);
        textView.setVisibility(0);
        if (localMedia.isCut()) {
            com.bumptech.glide.b.e(this.x).a(localMedia.getCutPath()).a(imageView);
        } else {
            com.bumptech.glide.b.e(this.x).a(path).a(imageView);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void a(BaseViewHolder baseViewHolder, LocalMedia localMedia) {
        if (b0.equals(this.Y)) {
            c(baseViewHolder, localMedia);
        } else {
            b(baseViewHolder, localMedia);
        }
    }

    public PictureSelectAdapter(int i2, List<LocalMedia> list, String str, int i3, List<UploadStateInfo> list2) {
        super(i2, list);
        this.X = true;
        this.Y = "";
        this.Z = 9;
        this.V = list;
        this.Y = str;
        this.Z = i3;
        this.a0 = list2;
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(BaseViewHolder baseViewHolder, int i2) {
        super.onBindViewHolder((PictureSelectAdapter) baseViewHolder, i2);
        baseViewHolder.itemView.setOnClickListener(new a(baseViewHolder));
    }

    private void a(TextView textView, UploadStateInfo uploadStateInfo) {
        int uploadState = uploadStateInfo.getUploadState();
        if (uploadState == 0) {
            textView.setText("等待上传");
            textView.setTextColor(Hicore.getApp().getResources().getColor(R.color.colorGray));
            return;
        }
        if (uploadState == 1) {
            textView.setText("上传中");
            textView.setTextColor(Hicore.getApp().getResources().getColor(R.color.black_dark));
        } else if (uploadState == 2) {
            textView.setText("上传完成");
            textView.setTextColor(Hicore.getApp().getResources().getColor(R.color.blue));
        } else {
            if (uploadState != 3) {
                return;
            }
            textView.setText("上传失败");
            textView.setTextColor(Hicore.getApp().getResources().getColor(R.color.colorRed));
        }
    }
}
