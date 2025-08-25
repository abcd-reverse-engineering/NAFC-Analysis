package com.luck.picture.lib.adapter;

import android.content.Intent;
import android.graphics.PointF;
import android.net.Uri;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import com.luck.picture.lib.R;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.config.PictureSelectionConfig;
import com.luck.picture.lib.engine.ImageEngine;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.listener.OnVideoSelectedPlayCallback;
import com.luck.picture.lib.photoview.OnViewTapListener;
import com.luck.picture.lib.photoview.PhotoView;
import com.luck.picture.lib.tools.JumpUtils;
import com.luck.picture.lib.tools.MediaUtils;
import com.luck.picture.lib.tools.SdkVersionUtils;
import com.luck.picture.lib.widget.longimage.ImageSource;
import com.luck.picture.lib.widget.longimage.ImageViewState;
import com.luck.picture.lib.widget.longimage.SubsamplingScaleImageView;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

/* loaded from: classes.dex */
public class PictureSimpleFragmentAdapter extends PagerAdapter {
    private static final int MAX_CACHE_SIZE = 20;
    private PictureSelectionConfig config;
    private List<LocalMedia> images;
    private SparseArray<View> mCacheView = new SparseArray<>();
    private OnCallBackActivity onBackPressed;

    public interface OnCallBackActivity {
        void onActivityBackPressed();
    }

    public PictureSimpleFragmentAdapter(PictureSelectionConfig pictureSelectionConfig, List<LocalMedia> list, OnCallBackActivity onCallBackActivity) {
        this.config = pictureSelectionConfig;
        this.images = list;
        this.onBackPressed = onCallBackActivity;
    }

    static /* synthetic */ void a(LocalMedia localMedia, String str, @i.c.a.d ViewGroup viewGroup, View view) {
        OnVideoSelectedPlayCallback onVideoSelectedPlayCallback = PictureSelectionConfig.customVideoPlayCallback;
        if (onVideoSelectedPlayCallback != null) {
            onVideoSelectedPlayCallback.startPlayVideo(localMedia);
            return;
        }
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putBoolean(PictureConfig.EXTRA_PREVIEW_VIDEO, true);
        bundle.putString("videoPath", str);
        intent.putExtras(bundle);
        JumpUtils.startPictureVideoPlayActivity(viewGroup.getContext(), bundle, PictureConfig.PREVIEW_VIDEO_CODE);
    }

    private void displayLongPic(Uri uri, SubsamplingScaleImageView subsamplingScaleImageView) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        subsamplingScaleImageView.setQuickScaleEnabled(true);
        subsamplingScaleImageView.setZoomEnabled(true);
        subsamplingScaleImageView.setPanEnabled(true);
        subsamplingScaleImageView.setDoubleTapZoomDuration(100);
        subsamplingScaleImageView.setMinimumScaleType(2);
        subsamplingScaleImageView.setDoubleTapZoomDpi(2);
        subsamplingScaleImageView.setImage(ImageSource.uri(uri), new ImageViewState(0.0f, new PointF(0.0f, 0.0f), 0));
    }

    public void clear() {
        SparseArray<View> sparseArray = this.mCacheView;
        if (sparseArray != null) {
            sparseArray.clear();
            this.mCacheView = null;
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
        viewGroup.removeView((View) obj);
        if (this.mCacheView.size() > 20) {
            this.mCacheView.remove(i2);
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        List<LocalMedia> list = this.images;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(@NonNull Object obj) {
        return -2;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    @i.c.a.d
    public Object instantiateItem(@i.c.a.d final ViewGroup viewGroup, int i2) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        ImageEngine imageEngine;
        ImageEngine imageEngine2;
        View viewInflate = this.mCacheView.get(i2);
        if (viewInflate == null) {
            viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.picture_image_preview, viewGroup, false);
            this.mCacheView.put(i2, viewInflate);
        }
        PhotoView photoView = (PhotoView) viewInflate.findViewById(R.id.preview_image);
        SubsamplingScaleImageView subsamplingScaleImageView = (SubsamplingScaleImageView) viewInflate.findViewById(R.id.longImg);
        ImageView imageView = (ImageView) viewInflate.findViewById(R.id.iv_play);
        final LocalMedia localMedia = this.images.get(i2);
        if (localMedia != null) {
            String mimeType = localMedia.getMimeType();
            final String compressPath = (!localMedia.isCut() || localMedia.isCompressed()) ? (localMedia.isCompressed() || (localMedia.isCut() && localMedia.isCompressed())) ? localMedia.getCompressPath() : localMedia.getPath() : localMedia.getCutPath();
            boolean zIsGif = PictureMimeType.isGif(mimeType);
            int i3 = 8;
            imageView.setVisibility(PictureMimeType.eqVideo(mimeType) ? 0 : 8);
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.luck.picture.lib.adapter.f
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PictureSimpleFragmentAdapter.a(localMedia, compressPath, viewGroup, view);
                }
            });
            boolean zIsLongImg = MediaUtils.isLongImg(localMedia);
            photoView.setVisibility((!zIsLongImg || zIsGif) ? 0 : 8);
            photoView.setOnViewTapListener(new OnViewTapListener() { // from class: com.luck.picture.lib.adapter.g
                @Override // com.luck.picture.lib.photoview.OnViewTapListener
                public final void onViewTap(View view, float f2, float f3) {
                    this.f7766a.a(view, f2, f3);
                }
            });
            if (zIsLongImg && !zIsGif) {
                i3 = 0;
            }
            subsamplingScaleImageView.setVisibility(i3);
            subsamplingScaleImageView.setOnClickListener(new View.OnClickListener() { // from class: com.luck.picture.lib.adapter.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f7762a.a(view);
                }
            });
            if (!zIsGif || localMedia.isCompressed()) {
                if (this.config != null && (imageEngine = PictureSelectionConfig.imageEngine) != null) {
                    if (zIsLongImg) {
                        displayLongPic(SdkVersionUtils.checkedAndroid_Q() ? Uri.parse(compressPath) : Uri.fromFile(new File(compressPath)), subsamplingScaleImageView);
                    } else {
                        imageEngine.loadImage(viewInflate.getContext(), compressPath, photoView);
                    }
                }
            } else if (this.config != null && (imageEngine2 = PictureSelectionConfig.imageEngine) != null) {
                imageEngine2.loadAsGifImage(viewInflate.getContext(), compressPath, photoView);
            }
        }
        viewGroup.addView(viewInflate, 0);
        return viewInflate;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(@i.c.a.d View view, @i.c.a.d Object obj) {
        return view == obj;
    }

    public void removeCacheView(int i2) {
        SparseArray<View> sparseArray = this.mCacheView;
        if (sparseArray == null || i2 >= sparseArray.size()) {
            return;
        }
        this.mCacheView.removeAt(i2);
    }

    public /* synthetic */ void a(View view, float f2, float f3) {
        OnCallBackActivity onCallBackActivity = this.onBackPressed;
        if (onCallBackActivity != null) {
            onCallBackActivity.onActivityBackPressed();
        }
    }

    public /* synthetic */ void a(View view) {
        OnCallBackActivity onCallBackActivity = this.onBackPressed;
        if (onCallBackActivity != null) {
            onCallBackActivity.onActivityBackPressed();
        }
    }
}
