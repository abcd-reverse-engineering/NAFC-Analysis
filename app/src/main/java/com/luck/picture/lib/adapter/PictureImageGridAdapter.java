package com.luck.picture.lib.adapter;

import android.content.Context;
import android.graphics.PorterDuff;
import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.luck.picture.lib.R;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.config.PictureSelectionConfig;
import com.luck.picture.lib.engine.ImageEngine;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.listener.OnPhotoSelectChangedListener;
import com.luck.picture.lib.tools.DateUtils;
import com.luck.picture.lib.tools.MediaUtils;
import com.luck.picture.lib.tools.PictureFileUtils;
import com.luck.picture.lib.tools.SdkVersionUtils;
import com.luck.picture.lib.tools.ToastUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class PictureImageGridAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private PictureSelectionConfig config;
    private Context context;
    private OnPhotoSelectChangedListener imageSelectChangedListener;
    private boolean isGo;
    private boolean showCamera;
    private List<LocalMedia> images = new ArrayList();
    private List<LocalMedia> selectImages = new ArrayList();

    public class CameraViewHolder extends RecyclerView.ViewHolder {
        View headerView;
        TextView tvCamera;

        public CameraViewHolder(View view) {
            super(view);
            this.headerView = view;
            this.tvCamera = (TextView) view.findViewById(R.id.tvCamera);
            this.tvCamera.setText(PictureImageGridAdapter.this.config.chooseMode == PictureMimeType.ofAudio() ? PictureImageGridAdapter.this.context.getString(R.string.picture_tape) : PictureImageGridAdapter.this.context.getString(R.string.picture_take_picture));
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        View btnCheck;
        View contentView;
        ImageView ivPicture;
        TextView tvCheck;
        TextView tvDuration;
        TextView tvIsGif;
        TextView tvLongChart;
        TextView tvName;

        public ViewHolder(View view) {
            super(view);
            this.contentView = view;
            this.ivPicture = (ImageView) view.findViewById(R.id.ivPicture);
            this.tvCheck = (TextView) view.findViewById(R.id.tvCheck);
            this.btnCheck = view.findViewById(R.id.btnCheck);
            this.tvDuration = (TextView) view.findViewById(R.id.tv_duration);
            this.tvIsGif = (TextView) view.findViewById(R.id.tv_isGif);
            this.tvName = (TextView) view.findViewById(R.id.tv_name);
            this.tvLongChart = (TextView) view.findViewById(R.id.tv_long_chart);
            if (PictureImageGridAdapter.this.config.style == null || PictureImageGridAdapter.this.config.style.pictureCheckedStyle == 0) {
                return;
            }
            this.tvCheck.setBackgroundResource(PictureImageGridAdapter.this.config.style.pictureCheckedStyle);
        }
    }

    public PictureImageGridAdapter(Context context, PictureSelectionConfig pictureSelectionConfig) {
        this.context = context;
        this.config = pictureSelectionConfig;
        this.showCamera = pictureSelectionConfig.isCamera;
    }

    /* JADX WARN: Removed duplicated region for block: B:129:0x02fe  */
    @android.annotation.SuppressLint({"StringFormatMatches"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void changeCheckboxState(com.luck.picture.lib.adapter.PictureImageGridAdapter.ViewHolder r11, com.luck.picture.lib.entity.LocalMedia r12) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 843
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.luck.picture.lib.adapter.PictureImageGridAdapter.changeCheckboxState(com.luck.picture.lib.adapter.PictureImageGridAdapter$ViewHolder, com.luck.picture.lib.entity.LocalMedia):void");
    }

    private void notifyCheckChanged(ViewHolder viewHolder, LocalMedia localMedia) {
        viewHolder.tvCheck.setText("");
        int size = this.selectImages.size();
        for (int i2 = 0; i2 < size; i2++) {
            LocalMedia localMedia2 = this.selectImages.get(i2);
            if (localMedia2.getPath().equals(localMedia.getPath()) || localMedia2.getId() == localMedia.getId()) {
                localMedia.setNum(localMedia2.getNum());
                localMedia2.setPosition(localMedia.getPosition());
                viewHolder.tvCheck.setText(String.valueOf(localMedia.getNum()));
            }
        }
    }

    private void singleRadioMediaImage() {
        List<LocalMedia> list = this.selectImages;
        if (list == null || list.size() <= 0) {
            return;
        }
        this.isGo = true;
        int i2 = 0;
        LocalMedia localMedia = this.selectImages.get(0);
        if (this.config.isCamera || this.isGo) {
            i2 = localMedia.position;
        } else {
            int i3 = localMedia.position;
            if (i3 > 0) {
                i2 = i3 - 1;
            }
        }
        notifyItemChanged(i2);
        this.selectImages.clear();
    }

    private void subSelectPosition() {
        if (this.config.checkNumMode) {
            int size = this.selectImages.size();
            int i2 = 0;
            while (i2 < size) {
                LocalMedia localMedia = this.selectImages.get(i2);
                i2++;
                localMedia.setNum(i2);
                notifyItemChanged(localMedia.position);
            }
        }
    }

    public /* synthetic */ void a(View view) {
        OnPhotoSelectChangedListener onPhotoSelectChangedListener = this.imageSelectChangedListener;
        if (onPhotoSelectChangedListener != null) {
            onPhotoSelectChangedListener.onTakePhoto();
        }
    }

    public void bindImagesData(List<LocalMedia> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        this.images = list;
        notifyDataSetChanged();
    }

    public void bindSelectImages(List<LocalMedia> list) {
        ArrayList arrayList = new ArrayList();
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            arrayList.add(list.get(i2));
        }
        this.selectImages = arrayList;
        if (this.config.isSingleDirectReturn) {
            return;
        }
        subSelectPosition();
        OnPhotoSelectChangedListener onPhotoSelectChangedListener = this.imageSelectChangedListener;
        if (onPhotoSelectChangedListener != null) {
            onPhotoSelectChangedListener.onChange(this.selectImages);
        }
    }

    public List<LocalMedia> getImages() {
        List<LocalMedia> list = this.images;
        return list == null ? new ArrayList() : list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.showCamera ? this.images.size() + 1 : this.images.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i2) {
        return (this.showCamera && i2 == 0) ? 1 : 2;
    }

    public List<LocalMedia> getSelectedImages() {
        List<LocalMedia> list = this.selectImages;
        return list == null ? new ArrayList() : list;
    }

    public int getSize() {
        List<LocalMedia> list = this.images;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public boolean isDataEmpty() {
        List<LocalMedia> list = this.images;
        return list == null || list.size() == 0;
    }

    public boolean isSelected(LocalMedia localMedia) {
        int size = this.selectImages.size();
        for (int i2 = 0; i2 < size; i2++) {
            LocalMedia localMedia2 = this.selectImages.get(i2);
            if (localMedia2 != null && !TextUtils.isEmpty(localMedia2.getPath()) && (localMedia2.getPath().equals(localMedia.getPath()) || localMedia2.getId() == localMedia.getId())) {
                return true;
            }
        }
        return false;
    }

    public boolean isShowCamera() {
        return this.showCamera;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@i.c.a.d RecyclerView.ViewHolder viewHolder, final int i2) {
        if (getItemViewType(i2) == 1) {
            ((CameraViewHolder) viewHolder).headerView.setOnClickListener(new View.OnClickListener() { // from class: com.luck.picture.lib.adapter.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f7761a.a(view);
                }
            });
            return;
        }
        final ViewHolder viewHolder2 = (ViewHolder) viewHolder;
        final LocalMedia localMedia = this.images.get(this.showCamera ? i2 - 1 : i2);
        localMedia.position = viewHolder2.getAdapterPosition();
        final String path = localMedia.getPath();
        final String mimeType = localMedia.getMimeType();
        if (this.config.checkNumMode) {
            notifyCheckChanged(viewHolder2, localMedia);
        }
        if (!this.config.isSingleDirectReturn) {
            selectImage(viewHolder2, isSelected(localMedia));
        }
        boolean zIsGif = PictureMimeType.isGif(mimeType);
        viewHolder2.tvCheck.setVisibility(this.config.isSingleDirectReturn ? 8 : 0);
        viewHolder2.btnCheck.setVisibility(this.config.isSingleDirectReturn ? 8 : 0);
        viewHolder2.tvIsGif.setVisibility(zIsGif ? 0 : 8);
        if (PictureMimeType.eqImage(localMedia.getMimeType())) {
            if (localMedia.loadLongImageStatus == -1) {
                localMedia.isLongImage = MediaUtils.isLongImg(localMedia);
                localMedia.loadLongImageStatus = 0;
            }
            viewHolder2.tvLongChart.setVisibility(localMedia.isLongImage ? 0 : 8);
        } else {
            localMedia.loadLongImageStatus = -1;
            viewHolder2.tvLongChart.setVisibility(8);
        }
        boolean zEqVideo = PictureMimeType.eqVideo(mimeType);
        boolean zEqAudio = PictureMimeType.eqAudio(mimeType);
        if (zEqVideo || zEqAudio) {
            viewHolder2.tvDuration.setVisibility(0);
            viewHolder2.tvDuration.setText(DateUtils.formatDurationTime(localMedia.getDuration()));
            viewHolder2.tvDuration.setCompoundDrawablesRelativeWithIntrinsicBounds(zEqVideo ? R.drawable.picture_icon_video : R.drawable.picture_icon_audio, 0, 0, 0);
        } else {
            viewHolder2.tvDuration.setVisibility(8);
        }
        if (this.config.chooseMode == PictureMimeType.ofAudio()) {
            viewHolder2.ivPicture.setImageResource(R.drawable.picture_audio_placeholder);
        } else {
            ImageEngine imageEngine = PictureSelectionConfig.imageEngine;
            if (imageEngine != null) {
                imageEngine.loadGridImage(this.context, path, viewHolder2.ivPicture);
            }
        }
        PictureSelectionConfig pictureSelectionConfig = this.config;
        if (pictureSelectionConfig.enablePreview || pictureSelectionConfig.enPreviewVideo || pictureSelectionConfig.enablePreviewAudio) {
            viewHolder2.btnCheck.setOnClickListener(new View.OnClickListener() { // from class: com.luck.picture.lib.adapter.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) throws Throwable {
                    this.f7756a.a(path, mimeType, localMedia, viewHolder2, view);
                }
            });
        }
        viewHolder2.contentView.setOnClickListener(new View.OnClickListener() { // from class: com.luck.picture.lib.adapter.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws Throwable {
                this.f7750a.a(path, mimeType, i2, localMedia, viewHolder2, view);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return i2 == 1 ? new CameraViewHolder(LayoutInflater.from(this.context).inflate(R.layout.picture_item_camera, viewGroup, false)) : new ViewHolder(LayoutInflater.from(this.context).inflate(R.layout.picture_image_grid_item, viewGroup, false));
    }

    public void selectImage(ViewHolder viewHolder, boolean z) {
        viewHolder.tvCheck.setSelected(z);
        if (z) {
            viewHolder.ivPicture.setColorFilter(ContextCompat.getColor(this.context, R.color.picture_color_80), PorterDuff.Mode.SRC_ATOP);
        } else {
            viewHolder.ivPicture.setColorFilter(ContextCompat.getColor(this.context, R.color.picture_color_20), PorterDuff.Mode.SRC_ATOP);
        }
    }

    public void setOnPhotoSelectChangedListener(OnPhotoSelectChangedListener onPhotoSelectChangedListener) {
        this.imageSelectChangedListener = onPhotoSelectChangedListener;
    }

    public void setShowCamera(boolean z) {
        this.showCamera = z;
    }

    public /* synthetic */ void a(String str, String str2, LocalMedia localMedia, ViewHolder viewHolder, View view) throws Throwable {
        if (SdkVersionUtils.checkedAndroid_Q()) {
            str = PictureFileUtils.getPath(this.context, Uri.parse(str));
        }
        if (!TextUtils.isEmpty(str) && !new File(str).exists()) {
            Context context = this.context;
            ToastUtils.s(context, PictureMimeType.s(context, str2));
        } else {
            if (SdkVersionUtils.checkedAndroid_Q()) {
                localMedia.setRealPath(str);
            }
            MediaUtils.setOrientation(this.context, localMedia);
            changeCheckboxState(viewHolder, localMedia);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0071  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public /* synthetic */ void a(java.lang.String r5, java.lang.String r6, int r7, com.luck.picture.lib.entity.LocalMedia r8, com.luck.picture.lib.adapter.PictureImageGridAdapter.ViewHolder r9, android.view.View r10) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 240
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.luck.picture.lib.adapter.PictureImageGridAdapter.a(java.lang.String, java.lang.String, int, com.luck.picture.lib.entity.LocalMedia, com.luck.picture.lib.adapter.PictureImageGridAdapter$ViewHolder, android.view.View):void");
    }
}
