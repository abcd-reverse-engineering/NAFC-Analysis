package adapter;

import android.graphics.drawable.AnimationDrawable;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;
import bean.UploadStateInfo;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hicorenational.antifraud.R;
import com.luck.picture.lib.entity.LocalMedia;
import java.util.List;

/* loaded from: classes.dex */
public class AudioPreviewAdapter extends BaseQuickAdapter<LocalMedia, BaseViewHolder> {
    List<UploadStateInfo> V;

    public AudioPreviewAdapter(List<LocalMedia> list, List<UploadStateInfo> list2) {
        super(R.layout.item_survey_audio_new_preview, list);
        this.V = list2;
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(BaseViewHolder baseViewHolder, int i2) {
        super.onBindViewHolder((AudioPreviewAdapter) baseViewHolder, i2);
        UploadStateInfo uploadStateInfo = this.V.get(i2);
        ImageView imageView = (ImageView) baseViewHolder.c(R.id.img_defraud_play);
        TextView textView = (TextView) baseViewHolder.c(R.id.tv_size_time);
        if (uploadStateInfo.isPlayState()) {
            ((AnimationDrawable) imageView.getBackground()).start();
        } else {
            imageView.setBackground(null);
            imageView.setBackground(this.x.getResources().getDrawable(R.drawable.anim_defraud_play_blue));
        }
        textView.setText(a(uploadStateInfo.getFileSize()) + "KB/" + a(uploadStateInfo.getFileSize()) + "KB");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void a(BaseViewHolder baseViewHolder, LocalMedia localMedia) {
        String fileName = localMedia.getFileName();
        if (TextUtils.isEmpty(fileName)) {
            fileName = "";
        }
        baseViewHolder.a(R.id.tv_audio_name, (CharSequence) fileName).a(R.id.iv_fail).a(R.id.iv_clear).a(R.id.img_defraud_play);
    }

    private long a(long j2) {
        return j2 / 1024;
    }
}
