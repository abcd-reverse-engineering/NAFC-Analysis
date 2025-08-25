package com.luck.picture.lib.style;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;

/* loaded from: classes.dex */
public class PictureParameterStyle implements Parcelable {
    public static final Parcelable.Creator<PictureParameterStyle> CREATOR = new Parcelable.Creator<PictureParameterStyle>() { // from class: com.luck.picture.lib.style.PictureParameterStyle.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PictureParameterStyle createFromParcel(Parcel parcel) {
            return new PictureParameterStyle(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PictureParameterStyle[] newArray(int i2) {
            return new PictureParameterStyle[i2];
        }
    };
    public boolean isChangeStatusBarFontColor;
    public boolean isCompleteReplaceNum;
    public boolean isOpenCheckNumStyle;
    public boolean isOpenCompletedNumStyle;

    @ColorInt
    public int pictureBottomBgColor;

    @ColorInt
    @Deprecated
    public int pictureCancelTextColor;

    @DrawableRes
    public int pictureCheckNumBgStyle;

    @DrawableRes
    public int pictureCheckedStyle;

    @DrawableRes
    public int pictureCompleteBackgroundStyle;
    public String pictureCompleteText;

    @ColorInt
    public int pictureCompleteTextColor;
    public int pictureCompleteTextSize;

    @ColorInt
    public int pictureContainerBackgroundColor;

    @DrawableRes
    public int pictureExternalPreviewDeleteStyle;
    public boolean pictureExternalPreviewGonePreviewDelete;

    @DrawableRes
    public int pictureFolderCheckedDotStyle;

    @DrawableRes
    public int pictureLeftBackIcon;

    @ColorInt
    public int pictureNavBarColor;

    @DrawableRes
    public int pictureOriginalControlStyle;

    @ColorInt
    public int pictureOriginalFontColor;
    public int pictureOriginalTextSize;

    @ColorInt
    public int picturePreviewBottomBgColor;
    public String picturePreviewText;

    @ColorInt
    public int picturePreviewTextColor;
    public int picturePreviewTextSize;
    public String pictureRightDefaultText;

    @ColorInt
    public int pictureRightDefaultTextColor;

    @ColorInt
    public int pictureRightSelectedTextColor;
    public int pictureRightTextSize;

    @ColorInt
    public int pictureStatusBarColor;

    @ColorInt
    public int pictureTitleBarBackgroundColor;

    @DrawableRes
    public int pictureTitleDownResId;

    @ColorInt
    public int pictureTitleTextColor;
    public int pictureTitleTextSize;

    @DrawableRes
    public int pictureTitleUpResId;

    @DrawableRes
    public int pictureUnCompleteBackgroundStyle;
    public String pictureUnCompleteText;

    @ColorInt
    public int pictureUnCompleteTextColor;
    public String pictureUnPreviewText;

    @ColorInt
    public int pictureUnPreviewTextColor;

    @DrawableRes
    public int pictureWeChatChooseStyle;

    @DrawableRes
    public int pictureWeChatLeftBackStyle;
    public String pictureWeChatPreviewSelectedText;
    public int pictureWeChatPreviewSelectedTextSize;

    @DrawableRes
    public int pictureWeChatTitleBackgroundStyle;

    public PictureParameterStyle() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeByte(this.isChangeStatusBarFontColor ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.isOpenCompletedNumStyle ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.isOpenCheckNumStyle ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.pictureStatusBarColor);
        parcel.writeInt(this.pictureTitleBarBackgroundColor);
        parcel.writeInt(this.pictureContainerBackgroundColor);
        parcel.writeInt(this.pictureTitleTextColor);
        parcel.writeInt(this.pictureTitleTextSize);
        parcel.writeInt(this.pictureCancelTextColor);
        parcel.writeInt(this.pictureRightDefaultTextColor);
        parcel.writeInt(this.pictureRightTextSize);
        parcel.writeString(this.pictureRightDefaultText);
        parcel.writeInt(this.pictureRightSelectedTextColor);
        parcel.writeInt(this.pictureBottomBgColor);
        parcel.writeInt(this.pictureCompleteTextColor);
        parcel.writeInt(this.pictureUnCompleteTextColor);
        parcel.writeInt(this.pictureCompleteTextSize);
        parcel.writeInt(this.pictureUnPreviewTextColor);
        parcel.writeInt(this.picturePreviewTextSize);
        parcel.writeString(this.pictureUnCompleteText);
        parcel.writeString(this.pictureCompleteText);
        parcel.writeInt(this.picturePreviewTextColor);
        parcel.writeString(this.pictureUnPreviewText);
        parcel.writeString(this.picturePreviewText);
        parcel.writeInt(this.picturePreviewBottomBgColor);
        parcel.writeInt(this.pictureNavBarColor);
        parcel.writeInt(this.pictureOriginalFontColor);
        parcel.writeInt(this.pictureOriginalTextSize);
        parcel.writeInt(this.pictureUnCompleteBackgroundStyle);
        parcel.writeInt(this.pictureCompleteBackgroundStyle);
        parcel.writeInt(this.pictureTitleUpResId);
        parcel.writeInt(this.pictureTitleDownResId);
        parcel.writeInt(this.pictureLeftBackIcon);
        parcel.writeInt(this.pictureCheckedStyle);
        parcel.writeByte(this.isCompleteReplaceNum ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.pictureWeChatChooseStyle);
        parcel.writeInt(this.pictureWeChatLeftBackStyle);
        parcel.writeInt(this.pictureWeChatTitleBackgroundStyle);
        parcel.writeInt(this.pictureWeChatPreviewSelectedTextSize);
        parcel.writeString(this.pictureWeChatPreviewSelectedText);
        parcel.writeInt(this.pictureCheckNumBgStyle);
        parcel.writeInt(this.pictureFolderCheckedDotStyle);
        parcel.writeInt(this.pictureExternalPreviewDeleteStyle);
        parcel.writeInt(this.pictureOriginalControlStyle);
        parcel.writeByte(this.pictureExternalPreviewGonePreviewDelete ? (byte) 1 : (byte) 0);
    }

    protected PictureParameterStyle(Parcel parcel) {
        this.isChangeStatusBarFontColor = parcel.readByte() != 0;
        this.isOpenCompletedNumStyle = parcel.readByte() != 0;
        this.isOpenCheckNumStyle = parcel.readByte() != 0;
        this.pictureStatusBarColor = parcel.readInt();
        this.pictureTitleBarBackgroundColor = parcel.readInt();
        this.pictureContainerBackgroundColor = parcel.readInt();
        this.pictureTitleTextColor = parcel.readInt();
        this.pictureTitleTextSize = parcel.readInt();
        this.pictureCancelTextColor = parcel.readInt();
        this.pictureRightDefaultTextColor = parcel.readInt();
        this.pictureRightTextSize = parcel.readInt();
        this.pictureRightDefaultText = parcel.readString();
        this.pictureRightSelectedTextColor = parcel.readInt();
        this.pictureBottomBgColor = parcel.readInt();
        this.pictureCompleteTextColor = parcel.readInt();
        this.pictureUnCompleteTextColor = parcel.readInt();
        this.pictureCompleteTextSize = parcel.readInt();
        this.pictureUnPreviewTextColor = parcel.readInt();
        this.picturePreviewTextSize = parcel.readInt();
        this.pictureUnCompleteText = parcel.readString();
        this.pictureCompleteText = parcel.readString();
        this.picturePreviewTextColor = parcel.readInt();
        this.pictureUnPreviewText = parcel.readString();
        this.picturePreviewText = parcel.readString();
        this.picturePreviewBottomBgColor = parcel.readInt();
        this.pictureNavBarColor = parcel.readInt();
        this.pictureOriginalFontColor = parcel.readInt();
        this.pictureOriginalTextSize = parcel.readInt();
        this.pictureUnCompleteBackgroundStyle = parcel.readInt();
        this.pictureCompleteBackgroundStyle = parcel.readInt();
        this.pictureTitleUpResId = parcel.readInt();
        this.pictureTitleDownResId = parcel.readInt();
        this.pictureLeftBackIcon = parcel.readInt();
        this.pictureCheckedStyle = parcel.readInt();
        this.isCompleteReplaceNum = parcel.readByte() != 0;
        this.pictureWeChatChooseStyle = parcel.readInt();
        this.pictureWeChatLeftBackStyle = parcel.readInt();
        this.pictureWeChatTitleBackgroundStyle = parcel.readInt();
        this.pictureWeChatPreviewSelectedTextSize = parcel.readInt();
        this.pictureWeChatPreviewSelectedText = parcel.readString();
        this.pictureCheckNumBgStyle = parcel.readInt();
        this.pictureFolderCheckedDotStyle = parcel.readInt();
        this.pictureExternalPreviewDeleteStyle = parcel.readInt();
        this.pictureOriginalControlStyle = parcel.readInt();
        this.pictureExternalPreviewGonePreviewDelete = parcel.readByte() != 0;
    }
}
