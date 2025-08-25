package com.luck.picture.lib.listener;

import com.luck.picture.lib.entity.LocalMedia;
import java.util.List;

/* loaded from: classes.dex */
public interface OnResultCallbackListener<T extends LocalMedia> {
    void onCancel();

    void onResult(List<T> list);
}
