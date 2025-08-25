package com.umeng.analytics.pro;

import com.umeng.analytics.pro.bq;
import com.umeng.analytics.pro.bx;
import java.io.Serializable;

/* compiled from: TBase.java */
/* loaded from: classes2.dex */
public interface bq<T extends bq<?, ?>, F extends bx> extends Serializable {
    void clear();

    bq<T, F> deepCopy();

    F fieldForId(int i2);

    void read(cp cpVar) throws bw;

    void write(cp cpVar) throws bw;
}
