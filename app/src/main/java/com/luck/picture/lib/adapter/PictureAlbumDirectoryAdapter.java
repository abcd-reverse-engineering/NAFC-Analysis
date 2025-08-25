package com.luck.picture.lib.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.luck.picture.lib.R;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.config.PictureSelectionConfig;
import com.luck.picture.lib.engine.ImageEngine;
import com.luck.picture.lib.entity.LocalMediaFolder;
import com.luck.picture.lib.listener.OnAlbumItemClickListener;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class PictureAlbumDirectoryAdapter extends RecyclerView.Adapter<ViewHolder> {
    private int chooseMode;
    private PictureSelectionConfig config;
    private List<LocalMediaFolder> folders = new ArrayList();
    private OnAlbumItemClickListener onAlbumItemClickListener;

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivFirstImage;
        TextView tvFolderName;
        TextView tvSign;

        public ViewHolder(View view) {
            super(view);
            this.ivFirstImage = (ImageView) view.findViewById(R.id.first_image);
            this.tvFolderName = (TextView) view.findViewById(R.id.tv_folder_name);
            this.tvSign = (TextView) view.findViewById(R.id.tv_sign);
            if (PictureAlbumDirectoryAdapter.this.config.style == null || PictureAlbumDirectoryAdapter.this.config.style.pictureFolderCheckedDotStyle == 0) {
                return;
            }
            this.tvSign.setBackgroundResource(PictureAlbumDirectoryAdapter.this.config.style.pictureFolderCheckedDotStyle);
        }
    }

    public PictureAlbumDirectoryAdapter(PictureSelectionConfig pictureSelectionConfig) {
        this.config = pictureSelectionConfig;
        this.chooseMode = pictureSelectionConfig.chooseMode;
    }

    public /* synthetic */ void a(LocalMediaFolder localMediaFolder, View view) {
        if (this.onAlbumItemClickListener != null) {
            int size = this.folders.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.folders.get(i2).setChecked(false);
            }
            localMediaFolder.setChecked(true);
            notifyDataSetChanged();
            this.onAlbumItemClickListener.onItemClick(localMediaFolder.isCameraFolder(), localMediaFolder.getName(), localMediaFolder.getImages());
        }
    }

    public void bindFolderData(List<LocalMediaFolder> list) {
        this.folders = list;
        notifyDataSetChanged();
    }

    public List<LocalMediaFolder> getFolderData() {
        List<LocalMediaFolder> list = this.folders;
        return list == null ? new ArrayList() : list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.folders.size();
    }

    public void setChooseMode(int i2) {
        this.chooseMode = i2;
    }

    public void setOnAlbumItemClickListener(OnAlbumItemClickListener onAlbumItemClickListener) {
        this.onAlbumItemClickListener = onAlbumItemClickListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder viewHolder, int i2) {
        final LocalMediaFolder localMediaFolder = this.folders.get(i2);
        String name = localMediaFolder.getName();
        int imageNum = localMediaFolder.getImageNum();
        String firstImagePath = localMediaFolder.getFirstImagePath();
        boolean zIsChecked = localMediaFolder.isChecked();
        viewHolder.tvSign.setVisibility(localMediaFolder.getCheckedNum() > 0 ? 0 : 4);
        viewHolder.itemView.setSelected(zIsChecked);
        if (this.chooseMode == PictureMimeType.ofAudio()) {
            viewHolder.ivFirstImage.setImageResource(R.drawable.picture_audio_placeholder);
        } else {
            ImageEngine imageEngine = PictureSelectionConfig.imageEngine;
            if (imageEngine != null) {
                imageEngine.loadFolderImage(viewHolder.itemView.getContext(), firstImagePath, viewHolder.ivFirstImage);
            }
        }
        Context context = viewHolder.itemView.getContext();
        if (localMediaFolder.getOfAllType() != -1) {
            name = localMediaFolder.getOfAllType() == PictureMimeType.ofAudio() ? context.getString(R.string.picture_all_audio) : context.getString(R.string.picture_camera_roll);
        }
        viewHolder.tvFolderName.setText(context.getString(R.string.picture_camera_roll_num, name, Integer.valueOf(imageNum)));
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.luck.picture.lib.adapter.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f7748a.a(localMediaFolder, view);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.picture_album_folder_item, viewGroup, false));
    }
}
