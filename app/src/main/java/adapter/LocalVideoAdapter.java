package adapter;

import android.net.Uri;
import android.widget.TextView;
import cn.jzvd.JzvdStd;
import com.bumptech.glide.r.h;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hicorenational.antifraud.R;
import com.luck.picture.lib.entity.LocalMedia;
import java.io.File;
import java.util.List;

/* loaded from: classes.dex */
public class LocalVideoAdapter extends BaseQuickAdapter<LocalMedia, BaseViewHolder> {
    public LocalVideoAdapter(List<LocalMedia> list) {
        super(R.layout.item_local_video, list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void a(BaseViewHolder baseViewHolder, LocalMedia localMedia) {
        ((TextView) baseViewHolder.c(R.id.video_tip)).setVisibility(8);
        JzvdStd jzvdStd = (JzvdStd) baseViewHolder.c(R.id.image_view);
        h hVar = new h();
        hVar.e(R.drawable.ic_add);
        com.bumptech.glide.b.e(this.x).a(Uri.fromFile(new File(localMedia.getPath()))).a((com.bumptech.glide.r.a<?>) hVar).a(jzvdStd.E0);
        jzvdStd.a(localMedia.getPath(), localMedia.getPath(), 0);
    }
}
