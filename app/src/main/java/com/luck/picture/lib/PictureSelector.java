package com.luck.picture.lib;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.style.PictureParameterStyle;
import com.luck.picture.lib.tools.DoubleUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class PictureSelector {
    private final WeakReference<Activity> mActivity;
    private final WeakReference<Fragment> mFragment;

    private PictureSelector(Activity activity) {
        this(activity, null);
    }

    public static PictureSelector create(Activity activity) {
        return new PictureSelector(activity);
    }

    public static <T extends Parcelable> List<T> obtainMultipleResult(Intent intent) {
        if (intent == null) {
            return new ArrayList();
        }
        ArrayList<T> parcelableArrayListExtra = intent.getParcelableArrayListExtra(PictureConfig.EXTRA_RESULT_SELECTION);
        return parcelableArrayListExtra == null ? new ArrayList() : parcelableArrayListExtra;
    }

    public static List<LocalMedia> obtainSelectorList(Bundle bundle) {
        if (bundle == null) {
            return new ArrayList();
        }
        ArrayList parcelableArrayList = bundle.getParcelableArrayList(PictureConfig.EXTRA_SELECT_LIST);
        return parcelableArrayList == null ? new ArrayList() : parcelableArrayList;
    }

    public static <T> Intent putIntentResult(List<T> list) {
        return new Intent().putParcelableArrayListExtra(PictureConfig.EXTRA_RESULT_SELECTION, (ArrayList) list);
    }

    public static void saveSelectorList(Bundle bundle, List<LocalMedia> list) {
        bundle.putParcelableArrayList(PictureConfig.EXTRA_SELECT_LIST, (ArrayList) list);
    }

    public void externalPictureAudio(String str) {
        if (DoubleUtils.isFastDoubleClick()) {
            return;
        }
        if (getActivity() == null) {
            throw new NullPointerException("Starting the PictureSelector Activity cannot be empty ");
        }
        Intent intent = new Intent(getActivity(), (Class<?>) PicturePlayAudioActivity.class);
        intent.putExtra(PictureConfig.EXTRA_AUDIO_PATH, str);
        getActivity().startActivity(intent);
        getActivity().overridePendingTransition(R.anim.picture_anim_enter, 0);
    }

    public void externalPicturePreview(int i2, List<LocalMedia> list, int i3) {
        if (DoubleUtils.isFastDoubleClick()) {
            return;
        }
        if (getActivity() == null) {
            throw new NullPointerException("Starting the PictureSelector Activity cannot be empty ");
        }
        Intent intent = new Intent(getActivity(), (Class<?>) PictureExternalPreviewActivity.class);
        intent.putParcelableArrayListExtra(PictureConfig.EXTRA_PREVIEW_SELECT_LIST, (ArrayList) list);
        intent.putExtra("position", i2);
        getActivity().startActivity(intent);
        Activity activity = getActivity();
        if (i3 == 0) {
            i3 = R.anim.picture_anim_enter;
        }
        activity.overridePendingTransition(i3, R.anim.picture_anim_fade_in);
    }

    public void externalPictureVideo(String str) {
        if (DoubleUtils.isFastDoubleClick()) {
            return;
        }
        if (getActivity() == null) {
            throw new NullPointerException("Starting the PictureSelector Activity cannot be empty ");
        }
        Intent intent = new Intent(getActivity(), (Class<?>) PictureVideoPlayActivity.class);
        intent.putExtra("videoPath", str);
        intent.putExtra(PictureConfig.EXTRA_PREVIEW_VIDEO, true);
        getActivity().startActivity(intent);
    }

    @Nullable
    Activity getActivity() {
        return this.mActivity.get();
    }

    @Nullable
    Fragment getFragment() {
        WeakReference<Fragment> weakReference = this.mFragment;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public PictureSelectionModel openCamera(int i2) {
        return new PictureSelectionModel(this, i2, true);
    }

    public PictureSelectionModel openGallery(int i2) {
        return new PictureSelectionModel(this, i2);
    }

    public PictureSelectionModel setPictureStyle(PictureParameterStyle pictureParameterStyle) {
        return new PictureSelectionModel(this, PictureMimeType.ofImage()).setPictureStyle(pictureParameterStyle);
    }

    public PictureSelectionModel themeStyle(int i2) {
        return new PictureSelectionModel(this, PictureMimeType.ofImage()).theme(i2);
    }

    private PictureSelector(Fragment fragment) {
        this(fragment.getActivity(), fragment);
    }

    public static PictureSelector create(Fragment fragment) {
        return new PictureSelector(fragment);
    }

    private PictureSelector(Activity activity, Fragment fragment) {
        this.mActivity = new WeakReference<>(activity);
        this.mFragment = new WeakReference<>(fragment);
    }

    public void externalPicturePreview(int i2, String str, List<LocalMedia> list, int i3) {
        if (DoubleUtils.isFastDoubleClick()) {
            return;
        }
        if (getActivity() != null) {
            Intent intent = new Intent(getActivity(), (Class<?>) PictureExternalPreviewActivity.class);
            intent.putParcelableArrayListExtra(PictureConfig.EXTRA_PREVIEW_SELECT_LIST, (ArrayList) list);
            intent.putExtra("position", i2);
            intent.putExtra(PictureConfig.EXTRA_DIRECTORY_PATH, str);
            getActivity().startActivity(intent);
            Activity activity = getActivity();
            if (i3 == 0) {
                i3 = R.anim.picture_anim_enter;
            }
            activity.overridePendingTransition(i3, R.anim.picture_anim_fade_in);
            return;
        }
        throw new NullPointerException("Starting the PictureSelector Activity cannot be empty ");
    }
}
