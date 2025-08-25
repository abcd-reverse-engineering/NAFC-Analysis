package com.luck.picture.lib;

import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.config.PictureSelectionConfig;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.style.PictureParameterStyle;
import com.luck.picture.lib.tools.AttrsUtils;
import com.luck.picture.lib.widget.FolderPopWindow;
import java.util.List;

/* loaded from: classes.dex */
public class PictureSelectorWeChatStyleActivity extends PictureSelectorActivity {
    private TextView mPictureSendView;
    private RelativeLayout rlAlbum;

    private void goneParentView() {
        this.mTvPictureRight.setVisibility(8);
        this.mTvPictureImgNum.setVisibility(8);
        this.mTvPictureOk.setVisibility(8);
    }

    @Override // com.luck.picture.lib.PictureSelectorActivity
    protected void changeImageNumber(List<LocalMedia> list) {
        if (this.mPictureSendView == null) {
            return;
        }
        int size = list.size();
        if (size != 0) {
            this.mPictureSendView.setEnabled(true);
            this.mPictureSendView.setSelected(true);
            this.mTvPicturePreview.setEnabled(true);
            this.mTvPicturePreview.setSelected(true);
            initCompleteText(list);
            PictureParameterStyle pictureParameterStyle = this.config.style;
            if (pictureParameterStyle == null) {
                this.mPictureSendView.setBackgroundResource(R.drawable.picture_send_button_bg);
                this.mPictureSendView.setTextColor(ContextCompat.getColor(getContext(), R.color.picture_color_white));
                this.mTvPicturePreview.setTextColor(ContextCompat.getColor(getContext(), R.color.picture_color_white));
                this.mTvPicturePreview.setText(getString(R.string.picture_preview_num, new Object[]{Integer.valueOf(size)}));
                return;
            }
            int i2 = pictureParameterStyle.pictureCompleteBackgroundStyle;
            if (i2 != 0) {
                this.mPictureSendView.setBackgroundResource(i2);
            } else {
                this.mPictureSendView.setBackgroundResource(R.drawable.picture_send_button_bg);
            }
            int i3 = this.config.style.pictureCompleteTextColor;
            if (i3 != 0) {
                this.mPictureSendView.setTextColor(i3);
            } else {
                this.mPictureSendView.setTextColor(ContextCompat.getColor(getContext(), R.color.picture_color_white));
            }
            int i4 = this.config.style.picturePreviewTextColor;
            if (i4 != 0) {
                this.mTvPicturePreview.setTextColor(i4);
            } else {
                this.mTvPicturePreview.setTextColor(ContextCompat.getColor(getContext(), R.color.picture_color_white));
            }
            if (TextUtils.isEmpty(this.config.style.picturePreviewText)) {
                this.mTvPicturePreview.setText(getString(R.string.picture_preview_num, new Object[]{Integer.valueOf(size)}));
                return;
            } else {
                this.mTvPicturePreview.setText(this.config.style.picturePreviewText);
                return;
            }
        }
        this.mPictureSendView.setEnabled(false);
        this.mPictureSendView.setSelected(false);
        this.mTvPicturePreview.setEnabled(false);
        this.mTvPicturePreview.setSelected(false);
        PictureParameterStyle pictureParameterStyle2 = this.config.style;
        if (pictureParameterStyle2 == null) {
            this.mPictureSendView.setBackgroundResource(R.drawable.picture_send_button_default_bg);
            this.mPictureSendView.setTextColor(ContextCompat.getColor(getContext(), R.color.picture_color_53575e));
            this.mTvPicturePreview.setTextColor(ContextCompat.getColor(getContext(), R.color.picture_color_9b));
            this.mTvPicturePreview.setText(getString(R.string.picture_preview));
            this.mPictureSendView.setText(getString(R.string.picture_send));
            return;
        }
        int i5 = pictureParameterStyle2.pictureUnCompleteBackgroundStyle;
        if (i5 != 0) {
            this.mPictureSendView.setBackgroundResource(i5);
        } else {
            this.mPictureSendView.setBackgroundResource(R.drawable.picture_send_button_default_bg);
        }
        int i6 = this.config.style.pictureUnCompleteTextColor;
        if (i6 != 0) {
            this.mPictureSendView.setTextColor(i6);
        } else {
            this.mPictureSendView.setTextColor(ContextCompat.getColor(getContext(), R.color.picture_color_53575e));
        }
        int i7 = this.config.style.pictureUnPreviewTextColor;
        if (i7 != 0) {
            this.mTvPicturePreview.setTextColor(i7);
        } else {
            this.mTvPicturePreview.setTextColor(ContextCompat.getColor(getContext(), R.color.picture_color_9b));
        }
        if (TextUtils.isEmpty(this.config.style.pictureUnCompleteText)) {
            this.mPictureSendView.setText(getString(R.string.picture_send));
        } else {
            this.mPictureSendView.setText(this.config.style.pictureUnCompleteText);
        }
        if (TextUtils.isEmpty(this.config.style.pictureUnPreviewText)) {
            this.mTvPicturePreview.setText(getString(R.string.picture_preview));
        } else {
            this.mTvPicturePreview.setText(this.config.style.pictureUnPreviewText);
        }
    }

    @Override // com.luck.picture.lib.PictureSelectorActivity, com.luck.picture.lib.PictureBaseActivity
    public int getResourceId() {
        return R.layout.picture_wechat_style_selector;
    }

    @Override // com.luck.picture.lib.PictureBaseActivity
    protected void initCompleteText(List<LocalMedia> list) {
        int i2;
        String string;
        int size = list.size();
        boolean z = this.config.style != null;
        PictureSelectionConfig pictureSelectionConfig = this.config;
        if (!pictureSelectionConfig.isWithVideoImage) {
            if (!PictureMimeType.eqVideo(list.get(0).getMimeType()) || (i2 = this.config.maxVideoSelectNum) <= 0) {
                i2 = this.config.maxSelectNum;
            }
            PictureSelectionConfig pictureSelectionConfig2 = this.config;
            if (pictureSelectionConfig2.selectionMode == 1) {
                if (!(z && pictureSelectionConfig2.style.isCompleteReplaceNum) || TextUtils.isEmpty(this.config.style.pictureCompleteText)) {
                    this.mPictureSendView.setText((!z || TextUtils.isEmpty(this.config.style.pictureCompleteText)) ? getString(R.string.picture_send) : this.config.style.pictureCompleteText);
                    return;
                } else {
                    this.mPictureSendView.setText(String.format(this.config.style.pictureCompleteText, Integer.valueOf(size), 1));
                    return;
                }
            }
            if (!(z && pictureSelectionConfig2.style.isCompleteReplaceNum) || TextUtils.isEmpty(this.config.style.pictureCompleteText)) {
                this.mPictureSendView.setText((!z || TextUtils.isEmpty(this.config.style.pictureUnCompleteText)) ? getString(R.string.picture_send_num, new Object[]{Integer.valueOf(size), Integer.valueOf(i2)}) : this.config.style.pictureUnCompleteText);
                return;
            } else {
                this.mPictureSendView.setText(String.format(this.config.style.pictureCompleteText, Integer.valueOf(size), Integer.valueOf(i2)));
                return;
            }
        }
        if (pictureSelectionConfig.selectionMode == 1) {
            if (size <= 0) {
                this.mPictureSendView.setText((!z || TextUtils.isEmpty(pictureSelectionConfig.style.pictureUnCompleteText)) ? getString(R.string.picture_send) : this.config.style.pictureUnCompleteText);
                return;
            }
            if (!(z && pictureSelectionConfig.style.isCompleteReplaceNum) || TextUtils.isEmpty(this.config.style.pictureCompleteText)) {
                this.mPictureSendView.setText((!z || TextUtils.isEmpty(this.config.style.pictureCompleteText)) ? getString(R.string.picture_send) : this.config.style.pictureCompleteText);
                return;
            } else {
                this.mPictureSendView.setText(String.format(this.config.style.pictureCompleteText, Integer.valueOf(size), 1));
                return;
            }
        }
        if ((z && pictureSelectionConfig.style.isCompleteReplaceNum) && !TextUtils.isEmpty(this.config.style.pictureCompleteText)) {
            TextView textView = this.mPictureSendView;
            String str = this.config.style.pictureCompleteText;
            PictureSelectionConfig pictureSelectionConfig3 = this.config;
            textView.setText(String.format(str, Integer.valueOf(size), Integer.valueOf(pictureSelectionConfig3.maxVideoSelectNum + pictureSelectionConfig3.maxSelectNum)));
            return;
        }
        TextView textView2 = this.mPictureSendView;
        if (!z || TextUtils.isEmpty(this.config.style.pictureUnCompleteText)) {
            int i3 = R.string.picture_send_num;
            PictureSelectionConfig pictureSelectionConfig4 = this.config;
            string = getString(i3, new Object[]{Integer.valueOf(size), Integer.valueOf(pictureSelectionConfig4.maxVideoSelectNum + pictureSelectionConfig4.maxSelectNum)});
        } else {
            string = this.config.style.pictureUnCompleteText;
        }
        textView2.setText(string);
    }

    @Override // com.luck.picture.lib.PictureSelectorActivity, com.luck.picture.lib.PictureBaseActivity
    public void initPictureSelectorStyle() throws Resources.NotFoundException {
        PictureParameterStyle pictureParameterStyle = this.config.style;
        if (pictureParameterStyle != null) {
            int i2 = pictureParameterStyle.pictureUnCompleteBackgroundStyle;
            if (i2 != 0) {
                this.mPictureSendView.setBackgroundResource(i2);
            } else {
                this.mPictureSendView.setBackgroundResource(R.drawable.picture_send_button_default_bg);
            }
            int i3 = this.config.style.pictureBottomBgColor;
            if (i3 != 0) {
                this.mBottomLayout.setBackgroundColor(i3);
            } else {
                this.mBottomLayout.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.picture_color_grey));
            }
            PictureParameterStyle pictureParameterStyle2 = this.config.style;
            int i4 = pictureParameterStyle2.pictureUnCompleteTextColor;
            if (i4 != 0) {
                this.mPictureSendView.setTextColor(i4);
            } else {
                int i5 = pictureParameterStyle2.pictureCancelTextColor;
                if (i5 != 0) {
                    this.mPictureSendView.setTextColor(i5);
                } else {
                    this.mPictureSendView.setTextColor(ContextCompat.getColor(getContext(), R.color.picture_color_53575e));
                }
            }
            int i6 = this.config.style.pictureRightTextSize;
            if (i6 != 0) {
                this.mPictureSendView.setTextSize(i6);
            }
            if (this.config.style.pictureOriginalFontColor == 0) {
                this.mCbOriginal.setTextColor(ContextCompat.getColor(this, R.color.picture_color_white));
            }
            PictureSelectionConfig pictureSelectionConfig = this.config;
            if (pictureSelectionConfig.isOriginalControl && pictureSelectionConfig.style.pictureOriginalControlStyle == 0) {
                this.mCbOriginal.setButtonDrawable(ContextCompat.getDrawable(this, R.drawable.picture_original_wechat_checkbox));
            }
            int i7 = this.config.style.pictureContainerBackgroundColor;
            if (i7 != 0) {
                this.container.setBackgroundColor(i7);
            }
            int i8 = this.config.style.pictureWeChatTitleBackgroundStyle;
            if (i8 != 0) {
                this.rlAlbum.setBackgroundResource(i8);
            } else {
                this.rlAlbum.setBackgroundResource(R.drawable.picture_album_bg);
            }
            if (!TextUtils.isEmpty(this.config.style.pictureUnCompleteText)) {
                this.mPictureSendView.setText(this.config.style.pictureUnCompleteText);
            }
        } else {
            this.mPictureSendView.setBackgroundResource(R.drawable.picture_send_button_default_bg);
            this.rlAlbum.setBackgroundResource(R.drawable.picture_album_bg);
            this.mPictureSendView.setTextColor(ContextCompat.getColor(getContext(), R.color.picture_color_53575e));
            int typeValueColor = AttrsUtils.getTypeValueColor(getContext(), R.attr.picture_bottom_bg);
            RelativeLayout relativeLayout = this.mBottomLayout;
            if (typeValueColor == 0) {
                typeValueColor = ContextCompat.getColor(getContext(), R.color.picture_color_grey);
            }
            relativeLayout.setBackgroundColor(typeValueColor);
            this.mCbOriginal.setTextColor(ContextCompat.getColor(this, R.color.picture_color_white));
            this.mIvArrow.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.picture_icon_wechat_down));
            if (this.config.isOriginalControl) {
                this.mCbOriginal.setButtonDrawable(ContextCompat.getDrawable(this, R.drawable.picture_original_wechat_checkbox));
            }
        }
        super.initPictureSelectorStyle();
        goneParentView();
    }

    @Override // com.luck.picture.lib.PictureSelectorActivity, com.luck.picture.lib.PictureBaseActivity
    protected void initWidgets() {
        super.initWidgets();
        this.rlAlbum = (RelativeLayout) findViewById(R.id.rlAlbum);
        this.mPictureSendView = (TextView) findViewById(R.id.picture_send);
        this.mPictureSendView.setOnClickListener(this);
        this.mPictureSendView.setText(getString(R.string.picture_send));
        this.mTvPicturePreview.setTextSize(16.0f);
        this.mCbOriginal.setTextSize(16.0f);
        PictureSelectionConfig pictureSelectionConfig = this.config;
        boolean z = pictureSelectionConfig.selectionMode == 1 && pictureSelectionConfig.isSingleDirectReturn;
        this.mPictureSendView.setVisibility(z ? 8 : 0);
        if (this.rlAlbum.getLayoutParams() == null || !(this.rlAlbum.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.rlAlbum.getLayoutParams();
        if (z) {
            layoutParams.addRule(14);
        } else {
            layoutParams.addRule(1, R.id.picture_left_back);
        }
    }

    @Override // com.luck.picture.lib.PictureSelectorActivity
    protected void onChangeData(List<LocalMedia> list) {
        super.onChangeData(list);
        initCompleteText(list);
    }

    @Override // com.luck.picture.lib.PictureSelectorActivity, android.view.View.OnClickListener
    public void onClick(View view) throws Resources.NotFoundException {
        super.onClick(view);
        if (view.getId() == R.id.picture_send) {
            FolderPopWindow folderPopWindow = this.folderWindow;
            if (folderPopWindow == null || !folderPopWindow.isShowing()) {
                this.mTvPictureOk.performClick();
            } else {
                this.folderWindow.dismiss();
            }
        }
    }
}
