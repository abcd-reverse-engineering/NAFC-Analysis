package adapter;

import android.view.View;
import android.widget.ImageView;
import bean.UploadStateInfo;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hicorenational.antifraud.R;
import com.luck.picture.lib.entity.LocalMedia;
import java.util.List;

/* loaded from: classes.dex */
public class FeedbackSelectAdapter extends BaseQuickAdapter<LocalMedia, BaseViewHolder> {
    static final int a0 = 0;
    static final int b0 = 1;
    private List<LocalMedia> V;
    private b W;
    private boolean X;
    private int Y;
    List<UploadStateInfo> Z;

    class a implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ BaseViewHolder f1267a;

        a(BaseViewHolder baseViewHolder) {
            this.f1267a = baseViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (FeedbackSelectAdapter.this.W != null) {
                FeedbackSelectAdapter.this.W.onItemClickListener(this.f1267a.getAdapterPosition(), FeedbackSelectAdapter.this.V);
            }
        }
    }

    public interface b {
        void onItemClickListener(int i2, List<LocalMedia> list);
    }

    public FeedbackSelectAdapter(int i2, List<LocalMedia> list, int i3, List<UploadStateInfo> list2) {
        super(i2, list);
        this.X = true;
        this.Y = 9;
        this.V = list;
        this.Y = i3;
        this.Z = list2;
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        int size = this.V.size();
        return (!this.X || size >= this.Y) ? size : size + 1;
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i2) {
        if (this.X) {
            int size = this.V.size();
            if (i2 + 1 == getItemCount() && size < this.Y + 1) {
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void a(BaseViewHolder baseViewHolder, LocalMedia localMedia) {
        baseViewHolder.a(R.id.iv_clear);
        ImageView imageView = (ImageView) baseViewHolder.c(R.id.picture_select);
        ImageView imageView2 = (ImageView) baseViewHolder.c(R.id.picture_foot);
        ImageView imageView3 = (ImageView) baseViewHolder.c(R.id.iv_clear);
        if (localMedia == null) {
            imageView3.setVisibility(8);
            imageView.setVisibility(8);
            imageView2.setVisibility(0);
            return;
        }
        imageView2.setVisibility(8);
        String path = localMedia.getPath();
        imageView3.setVisibility(0);
        imageView.setVisibility(0);
        if (localMedia.isCut()) {
            com.bumptech.glide.b.e(this.x).a(localMedia.getCutPath()).a(imageView);
        } else {
            com.bumptech.glide.b.e(this.x).a(path).a(imageView);
        }
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(BaseViewHolder baseViewHolder, int i2) {
        super.onBindViewHolder((FeedbackSelectAdapter) baseViewHolder, i2);
        baseViewHolder.itemView.setOnClickListener(new a(baseViewHolder));
    }
}
