package j;

import android.app.Activity;
import android.graphics.Color;
import androidx.core.content.ContextCompat;
import com.hicorenational.antifraud.R;
import com.luck.picture.lib.PictureSelectionModel;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.style.PictureCropParameterStyle;
import com.luck.picture.lib.style.PictureParameterStyle;
import com.luck.picture.lib.style.PictureWindowAnimationStyle;

/* compiled from: PictureLib.java */
/* loaded from: classes2.dex */
public class e {

    /* renamed from: b, reason: collision with root package name */
    private static PictureParameterStyle f17015b;

    /* renamed from: c, reason: collision with root package name */
    private static PictureCropParameterStyle f17016c;

    /* renamed from: g, reason: collision with root package name */
    private static boolean f17020g;

    /* renamed from: a, reason: collision with root package name */
    private static int f17014a = PictureMimeType.ofImage();

    /* renamed from: d, reason: collision with root package name */
    private static PictureWindowAnimationStyle f17017d = new PictureWindowAnimationStyle();

    /* renamed from: e, reason: collision with root package name */
    private static int f17018e = R.style.picture_default_style;

    /* renamed from: f, reason: collision with root package name */
    private static boolean f17019f = false;

    /* renamed from: h, reason: collision with root package name */
    private static boolean f17021h = true;

    public static PictureSelectionModel a(Activity activity, long j2, int i2, int i3) {
        f17018e = R.style.picture_default_style;
        f17019f = false;
        f17020g = false;
        a(activity);
        return c(activity, j2, i2, i3);
    }

    public static PictureSelectionModel b(Activity activity, long j2, int i2, int i3) {
        f17018e = 2131821097;
        f17019f = true;
        f17020g = true;
        b(activity);
        return c(activity, j2, i2, i3);
    }

    private static PictureSelectionModel c(Activity activity, long j2, int i2, int i3) {
        return PictureSelector.create(activity).openGallery(i2).loadImageEngine(b.a()).theme(f17018e).isWeChatStyle(f17019f).setLanguage(-1).setPictureStyle(f17015b).setPictureCropStyle(f17016c).setPictureWindowAnimationStyle(f17017d).isWithVideoImage(true).loadCacheResourcesCallback(a.a()).maxSelectNum(i3).minSelectNum(1).maxVideoSelectNum(i3).imageSpanCount(4).isReturnEmpty(false).setRequestedOrientation(1).previewImage(true).previewVideo(true).enablePreviewAudio(true).isCamera(f17021h).isZoomAnim(true).isGif(true).cutOutQuality(90).enableCrop(f17020g).freeStyleCropEnabled(true).showCropFrame(true).showCropGrid(true).queryMaxFileSize((int) j2).minimumCompressSize(100);
    }

    public static PictureSelectionModel a(Activity activity, long j2, int i2, int i3, boolean z) {
        f17018e = R.style.picture_default_style;
        f17019f = false;
        f17020g = false;
        f17021h = z;
        a(activity);
        return c(activity, j2, i2, i3);
    }

    private static void b(Activity activity) {
        f17015b = new PictureParameterStyle();
        PictureParameterStyle pictureParameterStyle = f17015b;
        pictureParameterStyle.isChangeStatusBarFontColor = false;
        pictureParameterStyle.isOpenCompletedNumStyle = false;
        pictureParameterStyle.isOpenCheckNumStyle = true;
        pictureParameterStyle.pictureStatusBarColor = Color.parseColor("#393a3e");
        f17015b.pictureTitleBarBackgroundColor = Color.parseColor("#393a3e");
        f17015b.pictureContainerBackgroundColor = ContextCompat.getColor(activity, R.color.app_color_black);
        PictureParameterStyle pictureParameterStyle2 = f17015b;
        pictureParameterStyle2.pictureTitleUpResId = R.drawable.picture_icon_wechat_up;
        pictureParameterStyle2.pictureTitleDownResId = R.drawable.picture_icon_wechat_down;
        pictureParameterStyle2.pictureFolderCheckedDotStyle = R.drawable.picture_orange_oval;
        pictureParameterStyle2.pictureLeftBackIcon = R.drawable.picture_icon_close;
        pictureParameterStyle2.pictureTitleTextColor = ContextCompat.getColor(activity, R.color.picture_color_white);
        f17015b.pictureCancelTextColor = ContextCompat.getColor(activity, R.color.picture_color_53575e);
        f17015b.pictureRightDefaultTextColor = ContextCompat.getColor(activity, R.color.picture_color_53575e);
        f17015b.pictureRightSelectedTextColor = ContextCompat.getColor(activity, R.color.picture_color_white);
        PictureParameterStyle pictureParameterStyle3 = f17015b;
        pictureParameterStyle3.pictureUnCompleteBackgroundStyle = R.drawable.picture_send_button_default_bg;
        pictureParameterStyle3.pictureCompleteBackgroundStyle = R.drawable.picture_send_button_bg;
        pictureParameterStyle3.pictureCheckedStyle = R.drawable.picture_wechat_num_selector;
        pictureParameterStyle3.pictureWeChatTitleBackgroundStyle = R.drawable.picture_album_bg;
        pictureParameterStyle3.pictureWeChatChooseStyle = R.drawable.picture_wechat_select_cb;
        pictureParameterStyle3.pictureWeChatLeftBackStyle = R.drawable.picture_icon_back;
        pictureParameterStyle3.pictureBottomBgColor = ContextCompat.getColor(activity, R.color.picture_color_grey);
        PictureParameterStyle pictureParameterStyle4 = f17015b;
        pictureParameterStyle4.pictureCheckNumBgStyle = R.drawable.picture_num_oval;
        pictureParameterStyle4.picturePreviewTextColor = ContextCompat.getColor(activity, R.color.picture_color_white);
        f17015b.pictureUnPreviewTextColor = ContextCompat.getColor(activity, R.color.picture_color_9b);
        f17015b.pictureCompleteTextColor = ContextCompat.getColor(activity, R.color.picture_color_white);
        f17015b.pictureUnCompleteTextColor = ContextCompat.getColor(activity, R.color.picture_color_53575e);
        f17015b.picturePreviewBottomBgColor = ContextCompat.getColor(activity, R.color.picture_color_half_grey);
        PictureParameterStyle pictureParameterStyle5 = f17015b;
        pictureParameterStyle5.pictureExternalPreviewDeleteStyle = R.drawable.picture_icon_delete;
        pictureParameterStyle5.pictureOriginalControlStyle = R.drawable.picture_original_wechat_checkbox;
        pictureParameterStyle5.pictureOriginalFontColor = ContextCompat.getColor(activity, R.color.app_color_white);
        PictureParameterStyle pictureParameterStyle6 = f17015b;
        pictureParameterStyle6.pictureExternalPreviewGonePreviewDelete = true;
        pictureParameterStyle6.pictureNavBarColor = Color.parseColor("#393a3e");
        f17016c = new PictureCropParameterStyle(ContextCompat.getColor(activity, R.color.app_color_grey), ContextCompat.getColor(activity, R.color.app_color_grey), Color.parseColor("#393a3e"), ContextCompat.getColor(activity, R.color.app_color_white), f17015b.isChangeStatusBarFontColor);
    }

    private static void a(Activity activity) {
        if (f17015b != null) {
            return;
        }
        f17015b = new PictureParameterStyle();
        PictureParameterStyle pictureParameterStyle = f17015b;
        pictureParameterStyle.isChangeStatusBarFontColor = false;
        pictureParameterStyle.isOpenCompletedNumStyle = false;
        pictureParameterStyle.isOpenCheckNumStyle = false;
        pictureParameterStyle.pictureStatusBarColor = Color.parseColor("#393a3e");
        f17015b.pictureTitleBarBackgroundColor = Color.parseColor("#393a3e");
        PictureParameterStyle pictureParameterStyle2 = f17015b;
        pictureParameterStyle2.pictureTitleUpResId = R.drawable.picture_icon_arrow_up;
        pictureParameterStyle2.pictureTitleDownResId = R.drawable.picture_icon_arrow_down;
        pictureParameterStyle2.pictureFolderCheckedDotStyle = R.drawable.picture_orange_oval;
        pictureParameterStyle2.pictureLeftBackIcon = R.drawable.picture_icon_back;
        pictureParameterStyle2.pictureTitleTextColor = ContextCompat.getColor(activity, R.color.picture_color_white);
        f17015b.pictureCancelTextColor = ContextCompat.getColor(activity, R.color.picture_color_white);
        PictureParameterStyle pictureParameterStyle3 = f17015b;
        pictureParameterStyle3.pictureCheckedStyle = R.drawable.picture_checkbox_selector;
        pictureParameterStyle3.pictureBottomBgColor = ContextCompat.getColor(activity, R.color.picture_color_grey);
        PictureParameterStyle pictureParameterStyle4 = f17015b;
        pictureParameterStyle4.pictureCheckNumBgStyle = R.drawable.picture_num_oval;
        pictureParameterStyle4.picturePreviewTextColor = ContextCompat.getColor(activity, R.color.picture_color_fa632d);
        f17015b.pictureUnPreviewTextColor = ContextCompat.getColor(activity, R.color.picture_color_white);
        f17015b.pictureCompleteTextColor = ContextCompat.getColor(activity, R.color.picture_color_fa632d);
        f17015b.pictureUnCompleteTextColor = ContextCompat.getColor(activity, R.color.picture_color_white);
        f17015b.picturePreviewBottomBgColor = ContextCompat.getColor(activity, R.color.picture_color_grey);
        PictureParameterStyle pictureParameterStyle5 = f17015b;
        pictureParameterStyle5.pictureExternalPreviewDeleteStyle = R.drawable.picture_icon_delete;
        pictureParameterStyle5.pictureOriginalControlStyle = R.drawable.picture_original_wechat_checkbox;
        pictureParameterStyle5.pictureOriginalFontColor = ContextCompat.getColor(activity, R.color.white);
        PictureParameterStyle pictureParameterStyle6 = f17015b;
        pictureParameterStyle6.pictureExternalPreviewGonePreviewDelete = true;
        pictureParameterStyle6.pictureNavBarColor = Color.parseColor("#393a3e");
    }
}
