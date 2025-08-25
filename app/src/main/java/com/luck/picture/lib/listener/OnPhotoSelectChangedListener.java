package com.luck.picture.lib.listener;

import com.luck.picture.lib.entity.LocalMedia;
import java.util.List;

/* loaded from: classes.dex */
public interface OnPhotoSelectChangedListener<T extends LocalMedia> {
    void onChange(List<T> list);

    void onPictureClick(T t, int i2);

    void onTakePhoto();
}
