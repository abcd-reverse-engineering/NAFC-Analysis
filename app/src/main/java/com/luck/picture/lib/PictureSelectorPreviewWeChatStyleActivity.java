package com.luck.picture.lib;

import android.text.TextUtils;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.luck.picture.lib.adapter.PictureWeChatPreviewGalleryAdapter;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.config.PictureSelectionConfig;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.style.PictureParameterStyle;
import java.util.List;

/* loaded from: classes.dex */
public class PictureSelectorPreviewWeChatStyleActivity extends PicturePreviewActivity {
    private static final int ALPHA_DURATION = 300;
    private View bottomLine;
    private PictureWeChatPreviewGalleryAdapter mGalleryAdapter;
    private TextView mPictureSendView;
    private RecyclerView mRvGallery;
    private TextView tvSelected;

    private void goneParent() {
        if (this.tv_img_num.getVisibility() == 0) {
            this.tv_img_num.setVisibility(8);
        }
        if (this.mTvPictureOk.getVisibility() == 0) {
            this.mTvPictureOk.setVisibility(8);
        }
        this.check.setText("");
    }

    private boolean isEqualsDirectory(String str, String str2) {
        return this.is_bottom_preview || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || str2.equals(getString(R.string.picture_camera_roll)) || str.equals(str2);
    }

    public /* synthetic */ void a(int i2, LocalMedia localMedia, View view) {
        if (this.viewPager == null || localMedia == null || !isEqualsDirectory(localMedia.getParentFolderName(), this.currentDirectory)) {
            return;
        }
        if (!this.is_bottom_preview) {
            i2 = this.isShowCamera ? localMedia.position - 1 : localMedia.position;
        }
        this.viewPager.setCurrentItem(i2);
    }

    @Override // com.luck.picture.lib.PicturePreviewActivity, com.luck.picture.lib.PictureBaseActivity
    public int getResourceId() {
        return R.layout.picture_wechat_style_preview;
    }

    @Override // com.luck.picture.lib.PicturePreviewActivity, com.luck.picture.lib.PictureBaseActivity
    protected void initCompleteText(int i2) {
        int i3;
        String string;
        boolean z = this.config.style != null;
        PictureSelectionConfig pictureSelectionConfig = this.config;
        if (!pictureSelectionConfig.isWithVideoImage) {
            if (!PictureMimeType.eqVideo(this.selectImages.get(0).getMimeType()) || (i3 = this.config.maxVideoSelectNum) <= 0) {
                i3 = this.config.maxSelectNum;
            }
            PictureSelectionConfig pictureSelectionConfig2 = this.config;
            if (pictureSelectionConfig2.selectionMode != 1) {
                if (!(z && pictureSelectionConfig2.style.isCompleteReplaceNum) || TextUtils.isEmpty(this.config.style.pictureCompleteText)) {
                    this.mPictureSendView.setText((!z || TextUtils.isEmpty(this.config.style.pictureUnCompleteText)) ? getString(R.string.picture_send_num, new Object[]{Integer.valueOf(this.selectImages.size()), Integer.valueOf(i3)}) : this.config.style.pictureUnCompleteText);
                    return;
                } else {
                    this.mPictureSendView.setText(String.format(this.config.style.pictureCompleteText, Integer.valueOf(this.selectImages.size()), Integer.valueOf(i3)));
                    return;
                }
            }
            if (i2 <= 0) {
                this.mPictureSendView.setText((!z || TextUtils.isEmpty(pictureSelectionConfig2.style.pictureUnCompleteText)) ? getString(R.string.picture_send) : this.config.style.pictureUnCompleteText);
                return;
            }
            if (!(z && pictureSelectionConfig2.style.isCompleteReplaceNum) || TextUtils.isEmpty(this.config.style.pictureCompleteText)) {
                this.mPictureSendView.setText((!z || TextUtils.isEmpty(this.config.style.pictureCompleteText)) ? getString(R.string.picture_send) : this.config.style.pictureCompleteText);
                return;
            } else {
                this.mPictureSendView.setText(String.format(this.config.style.pictureCompleteText, Integer.valueOf(this.selectImages.size()), 1));
                return;
            }
        }
        if (pictureSelectionConfig.selectionMode == 1) {
            if (i2 <= 0) {
                this.mPictureSendView.setText((!z || TextUtils.isEmpty(pictureSelectionConfig.style.pictureUnCompleteText)) ? getString(R.string.picture_send) : this.config.style.pictureUnCompleteText);
                return;
            }
            if (!(z && pictureSelectionConfig.style.isCompleteReplaceNum) || TextUtils.isEmpty(this.config.style.pictureCompleteText)) {
                this.mPictureSendView.setText((!z || TextUtils.isEmpty(this.config.style.pictureCompleteText)) ? getString(R.string.picture_send) : this.config.style.pictureCompleteText);
                return;
            } else {
                this.mPictureSendView.setText(String.format(this.config.style.pictureCompleteText, Integer.valueOf(this.selectImages.size()), 1));
                return;
            }
        }
        if ((z && pictureSelectionConfig.style.isCompleteReplaceNum) && !TextUtils.isEmpty(this.config.style.pictureCompleteText)) {
            TextView textView = this.mPictureSendView;
            String str = this.config.style.pictureCompleteText;
            PictureSelectionConfig pictureSelectionConfig3 = this.config;
            textView.setText(String.format(str, Integer.valueOf(this.selectImages.size()), Integer.valueOf(pictureSelectionConfig3.maxVideoSelectNum + pictureSelectionConfig3.maxSelectNum)));
            return;
        }
        TextView textView2 = this.mPictureSendView;
        if (!z || TextUtils.isEmpty(this.config.style.pictureUnCompleteText)) {
            int i4 = R.string.picture_send_num;
            PictureSelectionConfig pictureSelectionConfig4 = this.config;
            string = getString(i4, new Object[]{Integer.valueOf(this.selectImages.size()), Integer.valueOf(pictureSelectionConfig4.maxVideoSelectNum + pictureSelectionConfig4.maxSelectNum)});
        } else {
            string = this.config.style.pictureUnCompleteText;
        }
        textView2.setText(string);
    }

    @Override // com.luck.picture.lib.PicturePreviewActivity, com.luck.picture.lib.PictureBaseActivity
    public void initPictureSelectorStyle() {
        super.initPictureSelectorStyle();
        PictureParameterStyle pictureParameterStyle = this.config.style;
        if (pictureParameterStyle != null) {
            int i2 = pictureParameterStyle.pictureCompleteBackgroundStyle;
            if (i2 != 0) {
                this.mPictureSendView.setBackgroundResource(i2);
            } else {
                this.mPictureSendView.setBackgroundResource(R.drawable.picture_send_button_bg);
            }
            int i3 = this.config.style.pictureRightTextSize;
            if (i3 != 0) {
                this.mPictureSendView.setTextSize(i3);
            }
            if (!TextUtils.isEmpty(this.config.style.pictureWeChatPreviewSelectedText)) {
                this.tvSelected.setText(this.config.style.pictureWeChatPreviewSelectedText);
            }
            int i4 = this.config.style.pictureWeChatPreviewSelectedTextSize;
            if (i4 != 0) {
                this.tvSelected.setTextSize(i4);
            }
            int i5 = this.config.style.picturePreviewBottomBgColor;
            if (i5 != 0) {
                this.selectBarLayout.setBackgroundColor(i5);
            } else {
                this.selectBarLayout.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.picture_color_half_grey));
            }
            PictureParameterStyle pictureParameterStyle2 = this.config.style;
            int i6 = pictureParameterStyle2.pictureCompleteTextColor;
            if (i6 != 0) {
                this.mPictureSendView.setTextColor(i6);
            } else {
                int i7 = pictureParameterStyle2.pictureCancelTextColor;
                if (i7 != 0) {
                    this.mPictureSendView.setTextColor(i7);
                } else {
                    this.mPictureSendView.setTextColor(ContextCompat.getColor(getContext(), R.color.picture_color_white));
                }
            }
            if (this.config.style.pictureOriginalFontColor == 0) {
                this.mCbOriginal.setTextColor(ContextCompat.getColor(this, R.color.picture_color_white));
            }
            int i8 = this.config.style.pictureWeChatChooseStyle;
            if (i8 != 0) {
                this.check.setBackgroundResource(i8);
            } else {
                this.check.setBackgroundResource(R.drawable.picture_wechat_select_cb);
            }
            PictureSelectionConfig pictureSelectionConfig = this.config;
            if (pictureSelectionConfig.isOriginalControl && pictureSelectionConfig.style.pictureOriginalControlStyle == 0) {
                this.mCbOriginal.setButtonDrawable(ContextCompat.getDrawable(this, R.drawable.picture_original_wechat_checkbox));
            }
            int i9 = this.config.style.pictureWeChatLeftBackStyle;
            if (i9 != 0) {
                this.picture_left_back.setImageResource(i9);
            } else {
                this.picture_left_back.setImageResource(R.drawable.picture_icon_back);
            }
            if (!TextUtils.isEmpty(this.config.style.pictureUnCompleteText)) {
                this.mPictureSendView.setText(this.config.style.pictureUnCompleteText);
            }
        } else {
            this.mPictureSendView.setBackgroundResource(R.drawable.picture_send_button_bg);
            this.mPictureSendView.setTextColor(ContextCompat.getColor(getContext(), R.color.picture_color_white));
            this.selectBarLayout.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.picture_color_half_grey));
            this.check.setBackgroundResource(R.drawable.picture_wechat_select_cb);
            this.picture_left_back.setImageResource(R.drawable.picture_icon_back);
            this.mCbOriginal.setTextColor(ContextCompat.getColor(this, R.color.picture_color_white));
            if (this.config.isOriginalControl) {
                this.mCbOriginal.setButtonDrawable(ContextCompat.getDrawable(this, R.drawable.picture_original_wechat_checkbox));
            }
        }
        onSelectNumChange(false);
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x00eb, code lost:
    
        r5 = true;
     */
    @Override // com.luck.picture.lib.PicturePreviewActivity, com.luck.picture.lib.PictureBaseActivity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void initWidgets() {
        /*
            Method dump skipped, instructions count: 245
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.luck.picture.lib.PictureSelectorPreviewWeChatStyleActivity.initWidgets():void");
    }

    @Override // com.luck.picture.lib.PicturePreviewActivity, android.view.View.OnClickListener
    public void onClick(View view) throws Throwable {
        super.onClick(view);
        if (view.getId() == R.id.picture_send) {
            if (this.selectImages.size() != 0) {
                this.mTvPictureOk.performClick();
                return;
            }
            this.btnCheck.performClick();
            if (this.selectImages.size() != 0) {
                this.mTvPictureOk.performClick();
            }
        }
    }

    @Override // com.luck.picture.lib.PicturePreviewActivity
    protected void onPageSelectedChange(LocalMedia localMedia) {
        super.onPageSelectedChange(localMedia);
        goneParent();
        PictureWeChatPreviewGalleryAdapter pictureWeChatPreviewGalleryAdapter = this.mGalleryAdapter;
        if (pictureWeChatPreviewGalleryAdapter != null) {
            int itemCount = pictureWeChatPreviewGalleryAdapter.getItemCount();
            for (int i2 = 0; i2 < itemCount; i2++) {
                LocalMedia item = this.mGalleryAdapter.getItem(i2);
                if (item != null && !TextUtils.isEmpty(item.getPath())) {
                    item.setChecked(item.getPath().equals(localMedia.getPath()) || item.getId() == localMedia.getId());
                }
            }
            this.mGalleryAdapter.notifyDataSetChanged();
        }
    }

    @Override // com.luck.picture.lib.PicturePreviewActivity
    protected void onSelectNumChange(boolean z) {
        if (this.mPictureSendView == null) {
            return;
        }
        goneParent();
        if (!(this.selectImages.size() != 0)) {
            PictureParameterStyle pictureParameterStyle = this.config.style;
            if (pictureParameterStyle == null || TextUtils.isEmpty(pictureParameterStyle.pictureUnCompleteText)) {
                this.mPictureSendView.setText(getString(R.string.picture_send));
            } else {
                this.mPictureSendView.setText(this.config.style.pictureUnCompleteText);
            }
            this.mRvGallery.animate().alpha(0.0f).setDuration(300L).setInterpolator(new AccelerateInterpolator());
            this.mRvGallery.setVisibility(8);
            this.bottomLine.animate().alpha(0.0f).setDuration(300L).setInterpolator(new AccelerateInterpolator());
            this.bottomLine.setVisibility(8);
            return;
        }
        initCompleteText(this.selectImages.size());
        if (this.mRvGallery.getVisibility() == 8) {
            this.mRvGallery.animate().alpha(1.0f).setDuration(300L).setInterpolator(new AccelerateInterpolator());
            this.mRvGallery.setVisibility(0);
            this.bottomLine.animate().alpha(1.0f).setDuration(300L).setInterpolator(new AccelerateInterpolator());
            this.bottomLine.setVisibility(0);
            this.mGalleryAdapter.setNewData(this.selectImages);
        }
        PictureParameterStyle pictureParameterStyle2 = this.config.style;
        if (pictureParameterStyle2 == null) {
            this.mPictureSendView.setTextColor(ContextCompat.getColor(getContext(), R.color.picture_color_white));
            this.mPictureSendView.setBackgroundResource(R.drawable.picture_send_button_bg);
            return;
        }
        int i2 = pictureParameterStyle2.pictureCompleteTextColor;
        if (i2 != 0) {
            this.mPictureSendView.setTextColor(i2);
        }
        int i3 = this.config.style.pictureCompleteBackgroundStyle;
        if (i3 != 0) {
            this.mPictureSendView.setBackgroundResource(i3);
        }
    }

    @Override // com.luck.picture.lib.PicturePreviewActivity
    protected void onSelectedChange(boolean z, LocalMedia localMedia) {
        super.onSelectedChange(z, localMedia);
        if (z) {
            localMedia.setChecked(true);
            if (this.config.selectionMode == 1) {
                this.mGalleryAdapter.addSingleMediaToData(localMedia);
                return;
            }
            return;
        }
        localMedia.setChecked(false);
        this.mGalleryAdapter.removeMediaToData(localMedia);
        if (this.is_bottom_preview) {
            List<LocalMedia> list = this.selectImages;
            if (list != null) {
                int size = list.size();
                int i2 = this.position;
                if (size > i2) {
                    this.selectImages.get(i2).setChecked(true);
                }
            }
            if (this.mGalleryAdapter.isDataEmpty()) {
                onActivityBackPressed();
                return;
            }
            int currentItem = this.viewPager.getCurrentItem();
            this.images.remove(currentItem);
            this.f7745adapter.removeCacheView(currentItem);
            this.position = currentItem;
            this.tv_title.setText(getString(R.string.picture_preview_image_num, new Object[]{Integer.valueOf(this.position + 1), Integer.valueOf(this.images.size())}));
            this.check.setSelected(true);
            this.f7745adapter.notifyDataSetChanged();
        }
    }
}
