package com.luck.picture.lib.listener;

import java.util.List;

@Deprecated
/* loaded from: classes.dex */
public interface OnMediaLoadListener<T> {
    void loadComplete(List<T> list);

    void loadMediaDataError();
}
